package com.github.aaabidunique.androidutility.apk.worker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.github.aaabidunique.androidutility.validation.ValidationUtility;

/**
 * This class is responsible for providing option for manging apk
 */
@SuppressWarnings("unused")
public class AppManager {

    private static final String TAG = AppManager.class.getSimpleName();

    private AppManager() {
    }

    /**
     * @param context     is used for starting activity with intent.
     * @param packageName is the package of the app which need to be launched.
     *                    <p>
     *                    This method will launch the the application with provided package name
     */
    public static void launch(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (ValidationUtility.isEmpty(intent)) {
            Log.e(TAG, packageName + " launch intent error");
        }
        context.startActivity(intent);
    }

    /**
     * @param activity    is used for starting activity for result with intent.
     * @param requestCode is the request code for comparison on activity result.
     * @param packageName is the package of the app which need to be uninstalled.
     *                    <p>
     *                    This method will uninstall the the application with provided package name
     */
    public static void uninstall(Activity activity, int requestCode, String packageName) {
        Intent intent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE);
        intent.setData(Uri.parse("package:" + packageName));
        intent.putExtra(Intent.EXTRA_RETURN_RESULT, true);
        activity.startActivityForResult(intent, requestCode);
    }
}
