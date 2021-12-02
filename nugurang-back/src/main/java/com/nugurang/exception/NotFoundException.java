package com.nugurang.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

public class NotFoundException extends Exception {

    @Getter
    @NonNull
    private String objectName;

    @Builder
    public NotFoundException(String message, String objectName) {
        super(message);
        this.objectName = objectName;
    }

    @Builder
    public NotFoundException(String message, Throwable cause, String objectName) {
        super(message, cause);
        this.objectName = objectName;
    }
}
