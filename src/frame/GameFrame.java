package frame;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import actions.*;
import elements.Cell;

public class GameFrame implements Runnable {
	JFrame frame;
	JMenuBar menuBar;
	final static int CELL_WIDTH=100;
	final static int CELL_HEIGHT=100;
	static Cell[][] cells=new Cell[CELL_WIDTH][CELL_HEIGHT];
	
	public void run(){
		frame=new JFrame("Conway's Game of Life");
		frame.setLayout(new GridLayout(CELL_WIDTH,CELL_HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1080, 720);
		frame.setVisible(true);
		
		//Creates MenuBar
		menuBar=new JMenuBar();
			//"File" menu
			JMenu fileMenu=new JMenu("Simulation");
				JMenuItem runButton=new JMenuItem(new SimulationAction());
				fileMenu.add(runButton);
		
		//Add Cell Buttons
		for(Cell[] row : cells){
			for(Cell cell : row){
				frame.add(cell);
			}
		}
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
	}
	
	public void instantiateButtons(){
		for(int i=0; i<cells.length; i++){
			for(int j=0; j<cells[i].length; j++){
				cells[i][j]=new Cell(new CellClickedAction(i,j));
			}
		}
	}
	
	public static void toggleButton(int row, int col){
		cells[row][col].toggle();
	}
}
