package frame;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import actions.RunSimulation;

public class GameFrame implements Runnable {
	public void run(){
		JFrame frame=new JFrame("Conway's Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1080, 720);
		frame.setVisible(true);
		
		//Creates MenuBar
		JMenuBar menubar=new JMenuBar();
			//"File" menu
			JMenu fileMenu=new JMenu("Simulation");
				JMenuItem runButton=new JMenuItem(new RunSimulation());
				fileMenu.add(runButton);
		
		menubar.add(fileMenu);
		frame.setJMenuBar(menubar);
	}
}
