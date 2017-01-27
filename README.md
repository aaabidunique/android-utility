# android-utility
A handy set of utility for android

[![API](https://img.shields.io/badge/API-9%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=9) [![](https://jitpack.io/v/aaabidunique/android-utility.svg)](https://jitpack.io/#aaabidunique/android-utility)

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	compile 'com.github.aaabidunique:android-utility:1.0.0'
}
```

## Usage

### SharedPreferenceHelper
This class is used for performing operation on android shared preferences.

``` java
SharedPreferenceHelper.getString(yourContext, yourKey, defaultValue);
```
``` java
SharedPreferenceHelper.setString(yourContext, yourKey, value);
```
``` java
SharedPreferenceHelper.getInt(yourContext, yourKey, defaultValue);
```
``` java
SharedPreferenceHelper.setInt(yourContext, yourKey, value);
```
``` java
SharedPreferenceHelper.getBoolean(yourContext, yourKey, defaultValue);
```
``` java
SharedPreferenceHelper.setBoolean(yourContext, yourKey, value);
```
``` java
SharedPreferenceHelper.remove(yourContext, yourKey);
```

**BY DEFAULT IT IS USING "PREF" AS THE PREFERENCE FILE NAME**

If you want to change the file name use below code

``` java
SharedPreferenceHelper.PREF_FILE = "yourFileName";
```

### ValidationUtility
This class is used for performing validation for various java objects.

``` java
ValidationUtility.isEmpty(yourJavaObject);
```

``` java
ValidationUtility.isNotEmpty(yourJavaObject);
```

``` java
ValidationUtility.validateEmail(yourEmailString);
```

### ClipBoardUtility
This class is used for performing android clipboard related operation.

``` java
ClipBoardUtility.copyToClipboard(yourContext, label, content);
```

**MORE COMING SOON...**
