package com.lagikoi.be.exception;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(900, "Uncategorized Exception"),
    INVALID_KEY_EXCEPTION(901, "Invalid message Key"),

    UNAUTHENTICATED(950, "Unauthenticated"),
    TOKEN_CREATION(951, "Failed to create token due to signing error"),

    USER_EXISTED(1001, "User is existed"),
    USER_NOT_EXISTED(1002, "User not existed"),

    FISH_EXISTED(1101, "Fish is existed"),
    FISH_CREATION_NAME_SIZE(1102, "Fish name cannot be larger than 255 characters"),
    FISH_LIST_NOT_FOUND(1100, "Fish list is empty"),
    FISH_NOT_FOUND(1101, "Not found fish"),
    FISH_CATEGORY_NOT_FOUND(1102, "Fish category is empty")

    ;

    int code;
    String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
