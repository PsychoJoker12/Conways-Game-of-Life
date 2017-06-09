package elements;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Cell extends JLabel {
	private boolean isLiving;
	private int row, col;
	private Icon alive, dead;
	
	public Cell(int row, int col) {
		this.row=row;
		this.col=col;
		isLiving=false;

		alive=new ImageIcon("resources/cell/Cell_Alive.png");
		dead=new ImageIcon("resources/cell/Cell_Dead.png");
		
		updateUI();
	}
	
	public void toggle(){
		isLiving=!isLiving;
		updateUI();
	}
	
	@Override
	public void updateUI(){
		if(isLiving){
			setIcon(alive);
			super.updateUI();
		}
		else{
			setIcon(dead);
			super.updateUI();
		}
	}
}
