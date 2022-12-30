package com.challenge.models;

public enum AlertColor {
    VALID_RED("rgb(220, 53, 69)");

    public final String rgb;

    AlertColor(String colorRgb) {
        this.rgb = colorRgb;
    }
}
