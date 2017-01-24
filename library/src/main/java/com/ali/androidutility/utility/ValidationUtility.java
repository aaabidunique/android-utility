package com.ali.androidutility.utility;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtility {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean validateEmail(String email) {
        if (isNotEmpty(email)) {
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        } else {
            return false;
        }
    }

    public static boolean isEmpty(Object object) {
        if (object == null)
            return true;
        if (object instanceof String)
            return isEmpty((String) object);
        if (object instanceof Collection)
            return isEmpty((Collection<?>) object);
        if (object instanceof Map)
            return isEmpty((Map<?, ?>) object);
        if (object instanceof CharSequence)
            return isEmpty((CharSequence) object);
        if (object instanceof Boolean)
            return false;
        if (object instanceof Number)
            return false;
        if (object instanceof Character)
            return false;
        if (object instanceof java.sql.Timestamp)
            return false;
        return false;
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    public static boolean isEmpty(String string) {
        return ((string == null) || (string.trim().length() == 0));
    }

    public static <E> boolean isEmpty(Collection<E> collection) {
        return ((collection == null) || (collection.size() == 0));
    }

    public static <K, E> boolean isEmpty(Map<K, E> map) {
        return ((map == null) || (map.size() == 0));
    }

    public static <E> boolean isEmpty(CharSequence charSequence) {
        return ((charSequence == null) || (charSequence.length() == 0));
    }

    public static boolean isNotEmpty(String string) {
        return ((string != null) && (string.length() > 0));
    }

    public static <E> boolean isNotEmpty(Collection<E> collection) {
        return ((collection != null) && (collection.size() > 0));
    }

    public static <E> boolean isNotEmpty(CharSequence charSequence) {
        return ((charSequence != null) && (charSequence.length() > 0));
    }

    public static boolean isString(Object object) {
        return ((object != null) && (object instanceof String));
    }
}
