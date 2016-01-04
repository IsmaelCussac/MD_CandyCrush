package com.enums;

public enum CandyColor {

	RED,
	CYAN,
	YELLOW,
	GREEN,
	BLUE,
	PURPLE;
	
	public static CandyColor getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
