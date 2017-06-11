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
package frames;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AboutFrame extends JFrame{
	private static boolean instanceRunning=false;
	private static String information=
			"  Copyright (C) 2017 Robert Ciliberto\n"+
			"\n"+
			"  About this program:\n"+
			"     The Game of Life, also known simply as Life, is a cellular automaton\n"+
			"     devised by the British mathematician John Horton Conway in 1970. The\n"+
			"     \"game\" is a zero-player game, meaning that its evolution is determined\n"+
			"     by its initial state, requiring no further input. One interacts with the\n"+
			"     Game of Life by creating an initial configuration and observing how it\n"+
			"     evolves.\n"+
			"\n"+
			"  How to Play:\n"+
			"     1. Any live cell with fewer than two live neighbours dies, as if caused\n"+
			"        by underpopulation.\n"+
			"     2. Any live cell with two or three live neighbours lives on to the next\n"+
			"        generation.\n"+
			"     3. Any live cell with more than three live neighbours dies, as if by\n"+
			"        overpopulation.\n"+
			"     4. Any dead cell with exactly three live neighbours becomes a live cell,\n"+
			"        as if by reproduction.";
	
	public AboutFrame(){
		instanceRunning=true;
		/* Create and set up the window */
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("About");
		setLayout(new GridLayout(1,1));
		setResizable(false);
		
		JTextArea about=new JTextArea();
		about.setText(information);
		about.setEditable(false);
		add(about);
		System.out.println();
		pack();
		setVisible(true);
	}
	
	public static boolean instanceRunning(){
		return instanceRunning;
	}
	
	@Override
	protected void processWindowEvent(WindowEvent e){
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			instanceRunning=false;
		}
		super.processWindowEvent(e);
	}
}
