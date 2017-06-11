package elements;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Cell extends JLabel {
	private boolean isLiving;
	private boolean oldState;
	private int row, col;
	private Icon alive, dead;
	
	public Cell(int row, int col) {
		this.row=row;
		this.col=col;
		isLiving=false;
		oldState=true;

		alive=new ImageIcon("resources/cell/Cell_Alive.png");
		dead=new ImageIcon("resources/cell/Cell_Dead.png");
		
		updateUI();
	}
	
	public boolean isLiving(){
		return isLiving;
	}
	
	public boolean oldState(){
		return oldState;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	public void setLiving(){
		isLiving=true;
	}
	
	public void setDead(){
		isLiving=false;
	}
	
	public void toggle(){
		isLiving=!isLiving;
	}
	
	public void toggleAndUpdate(){
		toggle();
		updateUI();
	}
	
	@Override
	public void updateUI(){
		if(oldState!=isLiving){
			if(isLiving){
				setIcon(alive);
				super.updateUI();
			}
			else{
				setIcon(dead);
				super.updateUI();
			}
		}
		oldState=isLiving;
	}
	
	@Override
	public String toString(){
		String out;
		if(isLiving()) out="T";
		else out="F";
		return "Cell ("+row+","+col+") "+out;
	}
}
