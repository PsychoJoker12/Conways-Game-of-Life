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
package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import frame.GameFrame;

@SuppressWarnings("serial")
public class StepAction extends AbstractAction {
	GameFrame frame;
	
	public StepAction(String name, GameFrame frame){
		super(name);
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getGrid().updateGrid();
	}

}
