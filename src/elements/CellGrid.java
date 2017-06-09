package elements;

import java.util.Arrays;

import frame.GameFrame;
import listeners.CellMouseListener;

public class CellGrid {
	Cell[][] grid, temp;
	
	public CellGrid(GameFrame frame, int width, int height) {
		grid=new Cell[width][height];
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
	
	public void updateGrid() {
		temp=Arrays.copyOf(grid, grid.length);
		
		for(int i=0; i<temp.length; i++){
			for(int j=0; j<temp[i].length; j++){
				
				Cell cell=grid[i][j];
				int numLiving=checkLiving(i,j);
				
				if(!cell.isLiving()){
					if(numLiving==3) cell.setLiving();
				}
				else{
					if(numLiving<2 || numLiving>3) cell.setDead();
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
		
		for(int i=row-1; i<=row+1; i++){
			while(i<0) i++;
			if(i>=temp.length) break;
			
			for(int j=col; j<=col+1; j++){
				while(j<0) j++;
				if(j>=temp[i].length) break;
				
				Cell cell=temp[i][j];
				if(i!=row && j!=col && cell.isLiving()){
					numLiving++;
				}
			}
		}
		return numLiving;
	}
}
