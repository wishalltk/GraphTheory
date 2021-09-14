package com.enums;

public class TestEnums {
    public static void main(String[] args) {
        System.out.println(Directions.NORTH.value());
    }
}

enum Directions {
    NORTH("north"),
    EAST("east"),
    SOUTH("south"),
    WEST("west");
    private final String direction;
    Directions(String direction){
        this.direction = direction;
    }

    public String value() {
        return direction;
    }
}
