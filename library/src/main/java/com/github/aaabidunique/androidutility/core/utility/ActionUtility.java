package com.github.aaabidunique.androidutility.core.utility;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

@SuppressWarnings("unused")
public class ActionUtility {

    private ActionUtility() {
    }

    /**
     * @param context     is used for starting new activity.
     * @param packageName is the package of the app which will be opened in store.
     *                    <p>
     *                    THis method is responsible for opening the requested app in play store.
     */
    public static void openInStore(Context context, String packageName) {
        Intent intent;
        try {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (android.content.ActivityNotFoundException anfe) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    /**
     * @param context      is used for starting new activity.
     * @param emailId      is the email id to whom email have to be sent.
     * @param subject      is the subject of mail.
     * @param chooserTitle is the title for chooser in case multiple email client are installed.
     */
    public static void sendEMail(Context context, String emailId, String subject, String chooserTitle) {
        final Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{emailId});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        context.startActivity(Intent.createChooser(emailIntent, chooserTitle));
    }
}
