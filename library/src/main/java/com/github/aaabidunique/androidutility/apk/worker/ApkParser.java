package com.github.aaabidunique.androidutility.apk.worker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.github.aaabidunique.androidutility.apk.domain.ApkInfo;
import com.github.aaabidunique.androidutility.apk.exception.ApkParserException;
import com.github.aaabidunique.androidutility.validation.ValidationUtility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for parsing a n apk info return the the info
 */
@SuppressWarnings("unused")
public class ApkParser {

    private static final String TAG = ApkParser.class.getSimpleName();

    private ApkParser() {
    }

    /**
     * @param context     is used for fetching package manager.
     * @param packageName is the name of apk for which info need to be fetched.
     * @return ApkInfo object will contains apk info.
     * <p>
     * This method can be used to get apk info when package name of a apk is already known.
     */
    public static ApkInfo getAppInfo(Context context, String packageName) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            return getApkInfo(packageManager, applicationInfo);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            throw new ApkParserException(e);
        }
    }

    /**
     * @param context is used for fetching package manager.
     * @return List<ApkInfo> object will contains list of all installed apk info.
     * <p>
     * This method is used to get list of all installed apk including user apk and system apk.
     */
    public static List<ApkInfo> getAllInstalledAppInfo(Context context) {
        List<ApkInfo> apkInfoList;
        ApkInfo apkInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            List<ApplicationInfo> applicationInfoList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
            apkInfoList = new ArrayList<>();
            for (ApplicationInfo applicationInfo : applicationInfoList) {
                apkInfo = getApkInfo(packageManager, applicationInfo);
                if (ValidationUtility.isNotEmpty(apkInfo)) {
                    apkInfoList.add(apkInfo);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            throw new ApkParserException(e);
        }
        return apkInfoList;
    }

    private static ApkInfo getApkInfo(PackageManager packageManager, ApplicationInfo applicationInfo) throws PackageManager.NameNotFoundException {
        ApkInfo apkInfo;
        PackageInfo packageInfo = packageManager.getPackageInfo(applicationInfo.packageName, PackageManager.GET_META_DATA);
        if (ValidationUtility.isEmpty(applicationInfo) || ValidationUtility.isEmpty(packageInfo)) {
            String error = "ApplicationInfo or packageInfo is null";
            Log.e(TAG, error);
        }
        apkInfo = new ApkInfo();
        File apk = new File(applicationInfo.publicSourceDir);
        String appName = packageManager.getApplicationLabel(applicationInfo).toString().trim();
        apkInfo.setAppName(appName);
        apkInfo.setAppIcon(packageManager.getApplicationIcon(applicationInfo));
        apkInfo.setAppPackage(applicationInfo.packageName);
        apkInfo.setAppVersion(packageInfo.versionName);
        apkInfo.setAppVersionCode(packageInfo.versionCode);
        if (applicationInfo.enabled) {
            apkInfo.setDisabled(false);
        } else {
            apkInfo.setDisabled(true);
        }
        if (isSystemPackage(applicationInfo)) {
            apkInfo.setApkType(ApkInfo.ApkType.SYSTEM_APPS);
        } else {
            apkInfo.setApkType(ApkInfo.ApkType.USER_APPS);
        }
        apkInfo.setAppSize(apk.length());
        apkInfo.setAppInstalledTime(packageInfo.firstInstallTime);
        apkInfo.setAppUpdatedTime(apk.lastModified());
        return apkInfo;
    }

    private static boolean isSystemPackage(ApplicationInfo applicationInfo) {
        return ((applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0);
    }
}
