package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import elements.Cell;
import frame.GameFrame;
import frame.Main;

public class CellClickedAction extends AbstractAction{
	int row, col;
	Icon alive, dead;
	
	public CellClickedAction(int row, int col) {
		super("Cell ("+row+","+col+")");
		this.row=row;
		this.col=col;
		alive=UIManager.getIcon("FileView.directoryIcon"); //placeholder
		dead=null;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		GameFrame frame=Main.getFrame();
		Cell cell=frame.getCell(row, col);
		frame.toggleButton(row, col);
		System.out.println(cell);
		
		if(cell.isAlive()){
			cell.setIcon(alive);
			cell.updateUI();
		}
		else{
			cell.setIcon(dead);
			cell.updateUI();
		}
	}

}
