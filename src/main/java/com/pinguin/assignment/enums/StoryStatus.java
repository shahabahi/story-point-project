package com.pinguin.assignment.enums;

public enum StoryStatus {
    NEW("new"), ESTIMATED("estimated"), COMPLETED("completed");
    private String value;

    StoryStatus(String value) {
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
        return "StoryStatus{" +
                "value='" + value + '\'' +
                '}';
    }
}
