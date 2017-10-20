package com.ali.androidutility.utility;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class ClipBoardUtility {

    private ClipBoardUtility() {
    }

    public static void copyToClipboard(Context context, String label, String content) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText(label, content);
        clipboard.setPrimaryClip(clipData);
    }

    public static void copyToClipboard(Context context, Uri contentUri) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newUri(context.getContentResolver(), "URI", contentUri);
        clipboard.setPrimaryClip(clipData);
    }

    public static void copyToClipboard(Context context, String title, Intent appIntent) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newIntent(title, appIntent);
        clipboard.setPrimaryClip(clipData);
    }

    public static List<ClipData.Item> getDataFromClipboard(Context context) {
        List<ClipData.Item> clipDataList = null;
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = clipboard.getPrimaryClip();
        if (ValidationUtility.isNotEmpty(clipData) && clipData.getItemCount() > 0) {
            clipDataList = new ArrayList<>();
            for (int i = 0; i < clipData.getItemCount(); i++) {
                clipDataList.add(clipData.getItemAt(i));
            }
        }
        return clipDataList;
    }

    public static void clearClipboard(Context context) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("", "");
        clipboard.setPrimaryClip(clipData);
    }
}
