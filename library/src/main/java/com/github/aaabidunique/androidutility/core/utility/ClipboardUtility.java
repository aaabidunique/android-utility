package com.github.aaabidunique.androidutility.core.utility;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.github.aaabidunique.androidutility.validation.ValidationUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for performing operation on clipboard
 */
@SuppressWarnings("unused")
public class ClipboardUtility {

    private static final String TAG = ClipboardUtility.class.getSimpleName();

    private ClipboardUtility() {
    }

    /**
     * @param context is used for fetching clipboard manager.
     * @param label   is the clipboard content label.
     * @param content is the clipboard content.
     *                <p>
     *                This method copies provided input to clipboard's primary clip.
     */
    public static void copyToClipboard(Context context, String label, String content) {
        ClipData clipData = ClipData.newPlainText(label, content);
        saveToClipboard(context, clipData);
    }

    /**
     * @param context    is used for fetching clipboard manager.
     * @param label      is the clipboard uri label.
     * @param contentUri is the clipboard uri.
     *                   <p>
     *                   This method copies provided input to clipboard's primary clip.
     */
    public static void copyToClipboard(Context context, String label, Uri contentUri) {
        ClipData clipData = ClipData.newUri(context.getContentResolver(), label, contentUri);
        saveToClipboard(context, clipData);
    }

    /**
     * @param context   is used for fetching clipboard manager.
     * @param title     is the clipboard intent title.
     * @param appIntent s the clipboard intent.
     *                  <p>
     *                  This method copies provided input to clipboard's primary clip.
     */
    public static void copyToClipboard(Context context, String title, Intent appIntent) {
        ClipData clipData = ClipData.newIntent(title, appIntent);
        saveToClipboard(context, clipData);
    }

    private static void saveToClipboard(Context context, ClipData clipData) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (ValidationUtility.isNotEmpty(clipboard)) {
            clipboard.setPrimaryClip(clipData);
        } else {
            String error = "Invalid clipboard manager instance";
            Log.e(TAG, error);
        }
    }

    /**
     * @param context is used for fetching clipboard manager.
     * @return list of clipdata item from clipboard
     * <p>
     * This method return all clip data present in primary clip of clipboard.
     */
    public static List<ClipData.Item> getDataFromClipboard(Context context) {
        List<ClipData.Item> clipDataList = null;
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (ValidationUtility.isNotEmpty(clipboard)) {
            ClipData clipData = clipboard.getPrimaryClip();
            if (ValidationUtility.isNotEmpty(clipData) && clipData.getItemCount() > 0) {
                clipDataList = new ArrayList<>();
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    clipDataList.add(clipData.getItemAt(i));
                }
            }
        } else {
            String error = "Invalid clipboard manager instance";
            Log.e(TAG, error);
        }
        return clipDataList;
    }

    /**
     * @param context is used for fetching clipboard manager.
     *                <p>
     *                This method clears the primary clip data in clipboard.
     */
    public static void clearClipboard(Context context) {
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (ValidationUtility.isNotEmpty(clipboard)) {
            ClipData clipData = ClipData.newPlainText(null, null);
            clipboard.setPrimaryClip(clipData);
        } else {
            String error = "Invalid clipboard manager instance";
            Log.e(TAG, error);
        }
    }
}
