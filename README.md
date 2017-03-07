# android-utility
A handy set of utility for android

[![API](https://img.shields.io/badge/API-9%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=9) [![](https://jitpack.io/v/aaabidunique/android-utility.svg)](https://jitpack.io/#aaabidunique/android-utility) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-android%20utility-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/5353)

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

If you want to use the latest code present in branch `master` then use below code:

```gradle
dependencies {
	...
	compile 'com.github.aaabidunique:android-utility:master-SNAPSHOT'
}
```
Gradle can cache the `SNAPSHOT` builds. You could add the following configuration in your build.gradle file in order to ensure Gradle always picks up the ‘freshest’ version of the build:

```gradle
configurations.all {
    resolutionStrategy.cacheChangingModulesFor 0, 'seconds'
}
```

## List of Utility/Helper

### ClipBoardUtility
This class is used for performing android clipboard related operation. [More Info](https://github.com/aaabidunique/android-utility/wiki/ClipBoardUtility)

### DefaultSharedPreferenceHelper
This class is used for getting info from default android shared preferences. [More Info](https://github.com/aaabidunique/android-utility/wiki/DefaultSharedPreferenceHelper)

### ExternalActionUtility
This class is used for performingexternal action/operation. [More Info](https://github.com/aaabidunique/android-utility/wiki/ExternalActionUtility)

### SharedPreferenceHelper
This class is used for performing operation on android shared preferences. [More Info](https://github.com/aaabidunique/android-utility/wiki/SharedPreferenceHelper)

### ValidationUtility
This class is used for performing validation for various java objects. [More Info](https://github.com/aaabidunique/android-utility/wiki/ValidationUtility)

**More coming soon...**

**For complete docs click [here](https://github.com/aaabidunique/android-utility/wiki)**
