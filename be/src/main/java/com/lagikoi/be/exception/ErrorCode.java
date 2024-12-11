package com.lagikoi.be.exception;


import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(900, "Uncategorized Exception"),
    INVALID_KEY_EXCEPTION(901, "Invalid message Key"),
    FISH_EXISTED(1001, "Fish existed"),
    FISH_CREATION_NAME_SIZE(1002, "Fish name cannot be larger than 255 characters"),
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

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
