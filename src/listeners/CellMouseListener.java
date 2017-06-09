package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import elements.Cell;
import elements.CellGrid;

public class CellMouseListener implements MouseListener {
	CellGrid grid;
	Cell cell;
	
	public CellMouseListener(CellGrid grid, int row, int col) {
		this.grid=grid;
		cell=grid.getCell(row, col);
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		cell.toggle();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

}
