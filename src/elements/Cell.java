package elements;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cell extends JButton{
	boolean isAlive;
	int row, col;
	Icon alive,dead;
	
	public Cell(Action a, int row, int col) {
		super(a);
		this.row=row;
		this.col=col;
		
		alive=new ImageIcon("resources/cell/Cell_Alive.png");
		dead=new ImageIcon("resources/cell/Cell_Dead.png");
		
		isAlive=false;
		updateUI();
	}
	
	public boolean isAlive(){
		return isAlive;
	}
	
	public void setAlive(){
		isAlive=true;
	}
	
	public void setDead(){
		isAlive=false;
	}
	
	public void toggle(){
		isAlive=!isAlive;
	}
	
	@Override
	public void updateUI(){
		if(isAlive){
			setIcon(alive);
			super.updateUI();
		}
		else{
			setIcon(dead);
			super.updateUI();
		}
	}
	
	@Override
	public String toString(){
		return "Cell ("+row+","+col+"). Alive: "+isAlive;
	}

}
