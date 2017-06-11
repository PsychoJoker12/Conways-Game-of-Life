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
package frame;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

import actions.HelpButtonAction;
import actions.StepAction;
import actions.timer.StartTimerAction;
import actions.timer.StopTimerAction;
import elements.CellGrid;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	final int GRID_WIDTH;
	final int GRID_HEIGHT;
	Timer timer;
	CellGrid grid;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GameFrame frame=new GameFrame();
				frame.setVisible(true);
			}
		});
	}
	
	public GameFrame() {
		GRID_WIDTH=108;
		GRID_HEIGHT=72;
		
		createTimer();
		createAndShowGUI();
	}
	
	private void createTimer(){
		timer=new Timer(100, new StepAction("Run", this));
	}
	
	private void createAndShowGUI() {
		/* Create and set up the window */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Conway's Game of Life");
		setLayout(new GridLayout(GRID_HEIGHT, GRID_WIDTH));
		setResizable(false);
		
		//Create MenuBar
		JMenuBar menuBar=new JMenuBar();
			//"Run" menu
			JMenu simulationMenu=new JMenu("Simulation");
				JMenuItem stepButton=new JMenuItem(new StepAction("Step", this));
				simulationMenu.add(stepButton);
				
				simulationMenu.addSeparator();
				
				JMenuItem runButton=new JMenuItem(new StartTimerAction("Run", timer));
				simulationMenu.add(runButton);
				JMenuItem stopButton=new JMenuItem(new StopTimerAction("Stop", timer));
				simulationMenu.add(stopButton);
			menuBar.add(simulationMenu);
			
			//"Help" Menu
			JMenu helpMenu=new JMenu("Help");
				JMenuItem aboutButton=new JMenuItem(new HelpButtonAction("About"));
				helpMenu.add(aboutButton);
			menuBar.add(helpMenu);
		setJMenuBar(menuBar);
		
		//Create Grid
		grid=new CellGrid(this, GRID_WIDTH, GRID_HEIGHT);
		
		
		//Display the window
		pack();
		setVisible(true);
	}
	
	public CellGrid getGrid(){
		return grid;
	}
}
