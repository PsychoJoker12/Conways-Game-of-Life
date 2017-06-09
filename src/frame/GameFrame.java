package frame;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import elements.Cell;
import listeners.MouseListener;

public class GameFrame extends JFrame {
	final int GRID_WIDTH;
	final int GRID_HEIGHT;
	Cell[][] cells;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GameFrame frame=new GameFrame();
			}
		});
	}
	
	public GameFrame() {
		GRID_WIDTH=100;
		GRID_HEIGHT=100;
		
		createAndShowGUI();
	}
	
	private void createAndShowGUI() {
		/* Create and set up the window */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Conway's Game of Life");
		setLayout(new GridLayout(GRID_WIDTH, GRID_HEIGHT));
		setResizable(true);
		
		//Create MenuBar
		JMenuBar menuBar=new JMenuBar();
			//"File" menu
			JMenu fileMenu=new JMenu("Run");
				JMenuItem runButton=new JMenuItem();
				fileMenu.add(runButton);
			menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
		//Create Cells
		cells=new Cell[GRID_WIDTH][GRID_HEIGHT];
		for(int i=0; i<cells.length; i++){
			for(int j=0; j<cells[i].length; j++){
				cells[i][j]=new Cell(i, j);
				Cell cell=cells[i][j];
				add(cell);
				cell.addMouseListener(new MouseListener(this, i, j));
			}
		}
		
		//Display the window
		pack();
		setVisible(true);
	}
	
	public Cell getCell(int row, int col){
		return cells[row][col];
	}
}
