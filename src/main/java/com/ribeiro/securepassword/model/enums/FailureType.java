package com.ribeiro.securepassword.model.enums;

public enum FailureType {
    HIGHER_EIGHT("password must contain at least 8 characters"),
    CAPITAL_LETTER("password must contain at least one capital letter"),
    SMALL_LETTER("password must contain at least one small letter"),
    NUMBER("password must contain at least one number"),
    SPECIAL_CHARACTER("password must contain at least one special character");

    private final String description;

    FailureType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}