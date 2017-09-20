package com.demo.base;

public enum UserType {
    User(1),
    ADMIN(2);

    private int code;

    UserType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
