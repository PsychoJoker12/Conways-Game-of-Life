/* 	Final project "Conway's Game of Life", AP Computer Science
 * 
 *  Copyright (C) 2017  Robert Ciliberto
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

import frames.GameFrame;
import listeners.CellMouseListener;

public class CellGrid {
	File savedGridFile;
	Cell[][] grid;
	boolean[][] savedGrid;
	
	public CellGrid(GameFrame frame, int width, int height) {
		savedGridFile=null;
		grid=new Cell[height][width];
		savedGrid=new boolean[height][width];
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
	
	public void updateGrid(Timer timer) {
		int totalNumber=0;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				Cell cell=grid[i][j];
				int numLiving=checkLiving(i,j);
				totalNumber+=numLiving;
				
				if(cell.isLiving()){
					if(numLiving<2 || numLiving>3){
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
		if(totalNumber==0) timer.stop();
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
							if(numLiving>3) return 4;
						}
					}
				}
			}
		}
		return numLiving;
	}
	
	public void saveGrid(){
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				Cell cell=grid[i][j];
				savedGrid[i][j]=cell.isLiving();
			}
		}
	}
	
	public void loadTemporaryGrid(){
		for(int i=0; i<savedGrid.length; i++){
			for(int j=0; j<savedGrid[i].length; j++){
				grid[i][j].setLivingState(savedGrid[i][j]);
			}
		}
		updateUI();
	}
	
	public void openGridFile(){
		JFileChooser fileChooser=new JFileChooser("./examples/");
		fileChooser.setDialogTitle("Open Saved Grid");
		FileNameExtensionFilter filter=new FileNameExtensionFilter(
				"Saved Grid", "grid");
		fileChooser.setFileFilter(filter);
		int returnState=fileChooser.showOpenDialog(null);
		if(returnState==JFileChooser.APPROVE_OPTION){
			savedGridFile=fileChooser.getSelectedFile();
			try {
				loadGridFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void loadGridFile() throws IOException{
		List<String> lines=Files.readAllLines(Paths.get(savedGridFile.getAbsolutePath()));
		
		for(int i=0; i<lines.size(); i++){
			String row=lines.get(i);
			for(int j=0; j<row.length(); j++){
				if(row.charAt(j)=='1'){
					grid[i][j].setLiving();
				}
				else{
					grid[i][j].setDead();
				}
			}
		}
		
		updateUI();
	}
	
	public void saveGridFile(){
		JFileChooser fileChooser=new JFileChooser("./examples/");
		fileChooser.setDialogTitle("Save Grid");
		FileNameExtensionFilter filter=new FileNameExtensionFilter(
				"Saved Grid", "grid");
		fileChooser.setFileFilter(filter);
		int returnState=fileChooser.showSaveDialog(null);
		if(returnState==JFileChooser.APPROVE_OPTION){
			savedGridFile=fileChooser.getSelectedFile();
			String path=savedGridFile.getPath();
			if(path.length()>5 && path.substring(path.length()-5).equals(".grid")){
				saveFile(path.substring(0, path.length()-5));
			}
			else saveFile(path);
		}
	}
	
	private void saveFile(String path){
		try {
			PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(path+".grid")));
			for(int i=0; i<grid.length; i++){
				for(int j=0; j<grid[i].length;j++){
					Cell cell=grid[i][j];
					if(cell.isLiving()){
						out.append("1");
					}
					else{
						out.append("0");
					}
				}
				out.println();
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void clear(){
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				grid[i][j].setDead();
				grid[i][j].updateUI();
			}
		}
	}
}
