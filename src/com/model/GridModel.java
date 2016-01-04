package com.model;


public class GridModel {
	
	private Candy[][] grid;
	private static GridModel gridModel = new GridModel();
	
	private GridModel(){
	}
	
	public void setGrid(){
		grid = new Candy[Constants.xMax][Constants.yMax];
	}
	
	public Candy[][] getGrid(){
		return grid;
	}
	
	public static GridModel getInstance(){
		return gridModel;
	}
	
	public Candy getCandy(int x, int y){
		return grid[x][y];
	}
	
	public void setCandy(int x, int y, Candy candy){
		grid[x][y] =  candy;
	}
}