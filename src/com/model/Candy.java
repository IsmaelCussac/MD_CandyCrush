package com.model;

import com.enums.CandyAction;
import com.enums.CandyColor;

public class Candy {
	
	private CandyColor color;
	private CandyAction action;
	
	public Candy(){
	}
	
	public CandyColor getColor() {
		return color;
	}
	public void setColor(CandyColor color) {
		this.color = color;
	}
	public CandyAction getAction() {
		return action;
	}
	public void setAction(CandyAction action) {
		this.action = action;
	}
}
