package com.pinguin.assignment.enums;

public enum BugStatus {
    NEW("new"), VERIFIED("verified"), RESOLVED("resolved");
    private String value;

    BugStatus(String value) {
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
        return "BugStatus{" +
                "value='" + value + '\'' +
                '}';
    }
}
