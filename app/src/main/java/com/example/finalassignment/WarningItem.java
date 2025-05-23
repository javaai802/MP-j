package com.example.finalassignment;

public class WarningItem {
    private String title;
    private String message;
    private int iconResId;

    public WarningItem(String title, String message, int iconResId) {
        this.title = title;
        this.message = message;
        this.iconResId = iconResId;
    }

    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public int getIconResId() { return iconResId; }
}
