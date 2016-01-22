package com.enums;

public enum CandyColor {

	RED,
	CYAN,
	YELLOW,
	GREEN,
	BLUE,
	BLACK;
	
	public static CandyColor getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
