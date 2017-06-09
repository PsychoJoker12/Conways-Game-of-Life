package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import elements.Cell;
import frame.GameFrame;

public class CellClickedAction extends AbstractAction{
	int row, col;
	Icon alive, dead;
	GameFrame frame;
	
	public CellClickedAction(GameFrame frame, int row, int col) {
		super();
		this.frame=frame;
		this.row=row;
		this.col=col;
		alive=new ImageIcon("resources/cell/Cell_Alive.png");
		dead=new ImageIcon("resources/cell/Cell_Dead.png");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Cell cell=frame.getCell(row, col);
		cell.toggle();
		cell.updateUI();
	}
}
