package frame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import actions.SimulationAction;
import elements.Cell;

public class GameFrame implements Runnable {
	JFrame frame;
	JMenuBar menuBar;
	static Cell[][] cells=new Cell[10][10];
	
	public void run(){
		frame=new JFrame("Conway's Game of Life");
		frame.setLayout(new GridLayout(10,10));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1080, 720);
		frame.setVisible(true);
		
		//Creates MenuBar
		menuBar=new JMenuBar();
			//"File" menu
			JMenu fileMenu=new JMenu("Simulation");
				JMenuItem runButton=new JMenuItem(new SimulationAction());
				fileMenu.add(runButton);
		
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
	}
	
	public void instantiateButtons(){
		for(int i=0; i<cells.length; i++){
			for(int j=0; j<cells[i].length; j++){
				cells[i][j]=new Cell(i,j);
			}
		}
	}
	
	public static void toggleButton(int row, int col){
		cells[row][col].toggle();
	}
}
