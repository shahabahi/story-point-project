package com.pinguin.assignment.enums;

public enum BugPriority {
    CRITICAL("critical"), MAJOR("major"), MINOR("minor");
    private String value;

    BugPriority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BugPriority{" +
                "value='" + value + '\'' +
                '}';
    }
}
