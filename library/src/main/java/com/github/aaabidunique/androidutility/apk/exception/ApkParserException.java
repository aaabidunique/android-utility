package com.github.aaabidunique.androidutility.apk.exception;

@SuppressWarnings("unused")
public class ApkParserException extends RuntimeException {

    public ApkParserException(String message) {
        super(message);
    }

    public ApkParserException(Throwable throwable) {
        super(throwable);
    }

    public ApkParserException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
