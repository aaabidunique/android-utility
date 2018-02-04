package com.github.aaabidunique.androidutility.apk.domain;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class ApkInfo implements Serializable {

    public enum ApkType {
        USER_APPS, SYSTEM_APPS
    }

    private String appName;
    private transient Drawable appIcon;
    private String appPackage;
    private String appVersion;
    private Integer appVersionCode;
    private ApkType apkType;
    private boolean isDisabled;
    private Long appSize;
    private Long appInstalledTime;
    private Long appUpdatedTime;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Integer getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(Integer appVersionCode) {
        this.appVersionCode = appVersionCode;
    }

    public ApkType getApkType() {
        return apkType;
    }

    public void setApkType(ApkType apkType) {
        this.apkType = apkType;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public Long getAppSize() {
        return appSize;
    }

    public void setAppSize(Long appSize) {
        this.appSize = appSize;
    }

    public Long getAppInstalledTime() {
        return appInstalledTime;
    }

    public void setAppInstalledTime(Long appInstalledTime) {
        this.appInstalledTime = appInstalledTime;
    }

    public Long getAppUpdatedTime() {
        return appUpdatedTime;
    }

    public void setAppUpdatedTime(Long appUpdatedTime) {
        this.appUpdatedTime = appUpdatedTime;
    }
}
