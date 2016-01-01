package com.enums;

public enum CandyColor {

	RED,
	ORANGE,
	YELLOW,
	GREEN,
	BLUE,
	PURPLE;
	
	public static CandyColor getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
