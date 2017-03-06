package com.ali.androidutility.utility;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class ExternalActionUtility {

    public static void openInStore(Context context, String packageName, String errorMessage) {
        Intent intent;
        try {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (android.content.ActivityNotFoundException anfe) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
        }
    }

    private static void sendMail(Context context, String emailId, String subject, String chooserTitle) {
        final Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{emailId});
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        context.startActivity(Intent.createChooser(emailIntent, chooserTitle));
    }
}
