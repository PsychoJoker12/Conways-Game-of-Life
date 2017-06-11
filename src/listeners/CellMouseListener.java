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
package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import elements.CellGrid;

public class CellMouseListener implements MouseListener {
	CellGrid grid;
	int row, col;
	
	public CellMouseListener(CellGrid grid, int row, int col) {
		this.grid=grid;
		this.row=row;
		this.col=col;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		grid.toggleAndUpdate(row,col);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}
