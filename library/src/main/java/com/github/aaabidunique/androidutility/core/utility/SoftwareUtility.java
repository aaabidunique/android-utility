package com.github.aaabidunique.androidutility.core.utility;

import android.os.Build;

import java.lang.reflect.Field;

@SuppressWarnings("unused")
public class SoftwareUtility {

    private SoftwareUtility() {
    }

    /**
     * @return return the codename for android based on sdk version.
     */
    public static String getAndroidName() {
        switch (Build.VERSION.SDK_INT) {
            case 1:
                return "BASE";
            case 2:
                return "GINGERBREAD";
            case 3:
                return "CUPCAKE";
            case 4:
                return "DONUT";
            case 5:
            case 6:
            case 7:
                return "ECLAIR";
            case 8:
                return "FROYO";
            case 9:
            case 10:
                return "GINGERBREAD";
            case 11:
            case 12:
            case 13:
                return "HONEYCOMB";
            case 14:
            case 15:
                return "ICECREAM SANDWICH";
            case 16:
            case 17:
            case 18:
                return "JELLY_BEAN";
            case 19:
            case 20:
                return "KITKAT";
            case 21:
            case 22:
                return "LOLLIPOP";
            case 23:
                return "MARSHMALLOW";
            case 24:
            case 25:
                return "NOUGAT";
            case 26:
                return "OREO";
            default:
                return getAndroidVersionName();
        }
    }

    private static String getAndroidVersionName() {
        int sdk_version = Build.VERSION.SDK_INT;
        String versionName = "";
        Field[] fields = Build.VERSION_CODES.class.getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            int fieldValue = -1;
            try {
                fieldValue = field.getInt(new Object());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (fieldValue == sdk_version) {
                versionName = fieldName;
            } else {
                versionName = "";
            }
        }
        return versionName;
    }
}
