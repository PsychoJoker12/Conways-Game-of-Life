package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import elements.Cell;
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
