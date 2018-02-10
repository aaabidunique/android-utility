package com.github.aaabidunique.androidutility.validation;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class ValidationUtility {

    private static final String EMAIL_PATTERN = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    private ValidationUtility() {
    }

    /**
     * <p>
     * This method validates whether input charsequence is empty.
     */
    public static <E> boolean isEmpty(CharSequence charSequence) {
        return ((charSequence == null) || (charSequence.length() == 0));
    }

    /**
     * <p>
     * This method validates whether input charsequence is notempty.
     */
    public static <E> boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    /**
     * <p>
     * This method validates whether input string is empty.
     */
    public static boolean isEmpty(String string) {
        return ((string == null) || ("null".equalsIgnoreCase(string) || (string.trim().length() == 0)));
    }

    /**
     * <p>
     * This method validates whether input string is notempty.
     */
    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    /**
     * <p>
     * This method validates whether input array is empty.
     */
    public static boolean isEmpty(Object[] array) {
        return ((array == null) || (array.length == 0));
    }

    /**
     * <p>
     * This method validates whether input array is notempty.
     */
    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

    /**
     * <p>
     * This method validates whether input map is empty.
     */
    public static <K, E> boolean isEmpty(Map<K, E> map) {
        return ((map == null) || (map.size() == 0));
    }

    /**
     * <p>
     * This method validates whether input map is notempty.
     */
    public static <K, E> boolean isNotEmpty(Map<K, E> map) {
        return !isEmpty(map);
    }

    /**
     * <p>
     * This method validates whether input collection is empty.
     */
    public static <E> boolean isEmpty(Collection<E> collection) {
        return ((collection == null) || (collection.size() == 0));
    }

    /**
     * <p>
     * This method validates whether input collection is notempty.
     */
    public static <E> boolean isNotEmpty(Collection<E> collection) {
        return ((collection != null) && (collection.size() > 0));
    }

    /**
     * <p>
     * This method validates whether input object is empty.
     */
    public static boolean isEmpty(Object object) {
        if (object == null)
            return true;
        if (object instanceof Boolean)
            return false;
        if (object instanceof Number)
            return false;
        if (object instanceof Character)
            return false;
        return false;
    }

    /**
     * <p>
     * This method validates whether input object is notempty.
     */
    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    /**
     * @param input string that needs to be matched
     * @param regex is the pattern to be matched with
     * @return boolean whether pattern matches the input or not
     * <p>
     * This method validates for a given input string and pattern both matches each other or not.
     */
    public static boolean isValid(String input, String regex) {
        if (isEmpty(input) || isEmpty(regex)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        return isValid(input, pattern);
    }

    /**
     * @param input   string that needs to be matched
     * @param pattern is the pattern to be matched with
     * @return boolean whether pattern matches the input or not
     * <p>
     * This method validates for a given input string and pattern both matches each other or not.
     */
    public static boolean isValid(String input, Pattern pattern) {
        if (isEmpty(input) || isEmpty(pattern)) {
            return false;
        }
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    /**
     * @param email that need to be validated
     * @return boolean whether input email  is valid or not.
     * <p>
     * This method validates whether input email is valid based on email regex or not.
     */
    public static boolean isValid(String email) {
        if (isEmpty(email)) {
            return false;
        }
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        return isValid(email, pattern);
    }
}