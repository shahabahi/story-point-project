package com.pinguin.assignment.enums;

public enum EnumStory {
    ONE(1), TWO(2), TREE(3), FIVE(5),EIGHT(8);
    private int value;

    EnumStory(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Story{" +
                "value=" + value +
                '}';
    }
}
