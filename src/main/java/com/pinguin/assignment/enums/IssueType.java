package com.pinguin.assignment.enums;

public enum IssueType {
    BUGS("bugs"), STORIES("stories");
    private String value;

    IssueType(String value) {
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
        return "IssueType{" +
                "value='" + value + '\'' +
                '}';
    }
}
