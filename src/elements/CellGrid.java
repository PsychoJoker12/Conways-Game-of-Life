package elements;

import frame.GameFrame;
import listeners.CellMouseListener;

public class CellGrid {
	Cell[][] grid;
	
	public CellGrid(GameFrame frame, int width, int height){
		grid=new Cell[height][width];
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				grid[i][j]=new Cell(i, j);
				Cell cell=grid[i][j];
				frame.add(cell);
				cell.addMouseListener(new CellMouseListener(this, i, j));
			}
		}
	}
	
	public Cell getCell(int row, int col){
		return grid[row][col];
	}
	
	public void updateGrid(){
		//TODO to be implemented
	}
}
