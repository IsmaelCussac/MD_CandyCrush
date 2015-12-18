package com.model;

import java.util.HashMap;
import java.util.Map;

public class GridModel {
	
	private int xMax;
	private int yMax;
	Map<Case, Candy> grid = new HashMap<Case,Candy>();
	public static GridModel gridModel = new GridModel();
	
	private GridModel(){
	}

	public int getxMax() {
		return xMax;
	}

	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	public int getyMax() {
		return yMax;
	}

	public void setyMax(int yMax) {
		this.yMax = yMax;
	}

	public Map<Case, Candy> getGrid() {
		return grid;
	}

	public void setGrid(Map<Case, Candy> grid) {
		this.grid = grid;
	}
	
	public Candy getCandy(int x, int y){
		return grid.get(new Case(x,y));
	}
	
	public void setCandy(int x, int y, Candy candy){
		grid.put(new Case(x,y), candy);
	}
}