package com.pinguin.assignment.enums;

public enum Story {
    ONE(1), TWO(2), TREE(3), FIVE(5),EIGHT(8),THIRTEEN(13);
    private int value;

    Story(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
