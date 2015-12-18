package com.enums;

public enum Color {

	RED,
	ORANGE,
	YELLOW,
	GREEN,
	BLUE,
	PURPLE;
	
	public static Color getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
