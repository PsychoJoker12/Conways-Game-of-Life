package elements;

import frame.GameFrame;
import listeners.CellMouseListener;

public class CellGrid {
	Cell[][] grid;
	
	public CellGrid(GameFrame frame, int width, int height) {
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
	
	public Cell getCell(int row, int col) {
		return grid[row][col];
	}
	
	public void toggleAndUpdate(int row, int col){
		grid[row][col].toggleAndUpdate();
	}
	
	public void updateGrid() {
		updateUI();
		
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				Cell cell=grid[i][j];
				int numLiving=checkLiving(i,j);
				
				if(cell.isLiving()){
					if(numLiving>3 || numLiving<2){
						cell.toggle();
					}
				}
				else{
					if(numLiving==3){
						cell.toggle();
					}
				}
			}
		}
		updateUI();
	}
	
	private void updateUI(){
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				grid[i][j].updateUI();
			}
		}
	}
	
	private int checkLiving(int row, int col){
		int numLiving=0;
		
		for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, grid.length-1); i++) {
			for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, grid[i].length-1); j++) {
				if (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length) {
					if(i!=row || j!=col){
						if(grid[i][j].oldState()){
							numLiving++;
						}
					}
				}
			}
		}
		return numLiving;
	}
}
