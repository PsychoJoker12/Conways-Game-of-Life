package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class CellClickedAction extends AbstractAction{
	int row, col;
	
	public CellClickedAction(int row, int col) {
		super("Cell ("+row+","+col+")");
		this.row=row;
		this.col=col;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.GameFrame.toggleButton(row, col);
		System.out.println("Cell ("+row+","+col+")");
	}

}
