package com.github.aaabidunique.androidutility.validation;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtility {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private ValidationUtility() {
    }

    public static boolean validateEmail(String email) {
        if (isNotEmpty(email)) {
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        } else {
            return false;
        }
    }

    public static <E> boolean isEmpty(CharSequence charSequence) {
        return ((charSequence == null) || (charSequence.length() == 0));
    }

    public static <E> boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isEmpty(String string) {
        return ((string == null) || ("null".equalsIgnoreCase(string) || (string.trim().length() == 0)));
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isEmpty(Object[] array) {
        return ((array == null) || (array.length == 0));
    }

    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    public static <K, E> boolean isEmpty(Map<K, E> map) {
        return ((map == null) || (map.size() == 0));
    }

    public static <K, E> boolean isNotEmpty(Map<K, E> map) {
        return !isEmpty(map);
    }

    public static <E> boolean isEmpty(Collection<E> collection) {
        return ((collection == null) || (collection.size() == 0));
    }

    public static <E> boolean isNotEmpty(Collection<E> collection) {
        return ((collection != null) && (collection.size() > 0));
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    public static boolean isEmpty(Object object) {
        if (object == null)
            return true;
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
}