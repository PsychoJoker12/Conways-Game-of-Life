package listeners;

import java.awt.event.MouseEvent;

import elements.Cell;
import frame.GameFrame;

public class MouseListener implements java.awt.event.MouseListener {
	GameFrame frame;
	Cell cell;
	
	public MouseListener(GameFrame frame, int row, int col) {
		this.frame=frame;
		cell=frame.getCell(row, col);
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
