package com.controller;

import com.enums.CandyColor;
import com.model.Candy;
import com.model.Constants;
import com.model.GridModel;

public class GridManager {

	private static GridManager gridManager = new GridManager();
	private GridModel gridModel;
	private boolean marked[][];

	private GridManager() {
		gridModel = GridModel.getInstance();
		gridModel.setGrid();
		marked = new boolean[Constants.xMax][Constants.yMax];
		
	}

	public GridModel getGridModel() {
		return gridModel;
	}
	
	public static GridManager getInstance(){
		return gridManager;
	}

	public void setGridModel(GridModel gridModel) {
		this.gridModel = gridModel;
	}

	public boolean fill() {
		boolean modified = false;
		for (int i = 0; i < Constants.xMax; i++) {
			for (int j = Constants.yMax - 1; j >= 0; j--) {
				if (gridModel.getCandy(i, j) == null) {
					if (j == 0) {
						Candy candy = new Candy();
						candy.setColor(CandyColor.getRandom());
						gridModel.setCandy(i, j, candy);
					} else {
						gridModel.setCandy(i, j, gridModel.getCandy(i, j - 1));
						gridModel.setCandy(i, j - 1, null);
					}
					modified = true;
				}
			}
		}
		return modified;
	}

	public boolean removeAlignments() {

		for (int i = 0; i < Constants.xMax; i++) {
			for (int j = 0; j < Constants.yMax; j++) {
				if (gridModel.getCandy(i, j) != null && horizontalAligned(i, j)) {
					marked[i][j] = marked[i + 1][j] = marked[i + 2][j] = true;
				}
				if (gridModel.getCandy(i, j) != null && verticalAligned(i, j)) {
					marked[i][j] = marked[i][j + 1] = marked[i][j + 2] = true;
				}
			}
		}
		
		// passe 2 : supprimer les cases marquées
		boolean modified = false;
		for (int i = 0; i < Constants.xMax; i++) {
			for (int j = 0; j < Constants.yMax; j++) {
				if (marked[i][j]) {
					gridModel.setCandy(i, j, null);
					marked[i][j] = false;
					modified = true;
				}
			}
		}
		return modified;

	}

	public void swap(int x1, int y1, int x2, int y2) {

		Candy candyTmp = gridModel.getCandy(x1, y1);
		gridModel.setCandy(x1, y1, gridModel.getCandy(x2, y2));
		gridModel.setCandy(x2, y2, candyTmp);

	}

	public boolean isValidSwap(int x1, int y1, int x2, int y2) {
		// il faut que les cases soient dans la grille
		if (x1 == -1 || x2 == -1 || y1 == -1 || y2 == -1)
			return false;
		// que les cases soient à côté l'une de l'autre
		if (Math.abs(x2 - x1) + Math.abs(y2 - y1) != 1)
			return false;
		// et que les couleurs soient différentes
		if (gridModel.getCandy(x1, y1) == gridModel.getCandy(x2, y2))
			return false;

		// alors on effectue l'échange
		swap(x1, y1, x2, y2);

		// et on vérifie que ça créé un nouvel alignement
		boolean newAlignment = false;
		for (int i = 0; i < 3; i++) {
			newAlignment |= horizontalAligned(x1 - i, y1);
			newAlignment |= horizontalAligned(x2 - i, y2);
			newAlignment |= verticalAligned(x1, y1 - i);
			newAlignment |= verticalAligned(x2, y2 - i);
		}

		// puis on annule l'échange
		swap(x1, y1, x2, y2);
		return newAlignment;
	}

	boolean horizontalAligned(int i, int j) {
		if (i < 0 || j < 0 || i >= Constants.xMax-2 || j >= Constants.yMax)
			return false;

		if (gridModel.getCandy(i, j).getColor() == gridModel.getCandy(i + 1, j).getColor()
				&& gridModel.getCandy(i, j).getColor() == gridModel.getCandy(i + 2, j).getColor())
			return true;
		return false;
	}

	// est-ce qu'on a trois cases de la même couleur vers le bas depuis (i, j) ?
	boolean verticalAligned(int i, int j) {
		if (i < 0 || j < 0 || i >= Constants.yMax || j >= Constants.yMax-2)
			return false;
		if (gridModel.getCandy(i, j).getColor() == gridModel.getCandy(i, j + 1).getColor()
				&& gridModel.getCandy(i, j).getColor() == gridModel.getCandy(i, j + 2).getColor())
			return true;
		return false;
	}
}
