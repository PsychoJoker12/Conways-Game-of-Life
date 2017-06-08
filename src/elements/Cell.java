package elements;

import javax.swing.Action;
import javax.swing.JButton;

public class Cell extends JButton{
	boolean isAlive;
	int row, col;
	
	public Cell(Action a, int row, int col) {
		super(a);
		this.row=row;
		this.col=col;
		isAlive=false;
	}
	
	public boolean isAlive(){
		return isAlive;
	}
	
	public void toggle(){
		isAlive=!isAlive;
	}
	
	public String toString(){
		return "Cell ("+row+","+col+"). Alive: "+isAlive;
	}

}
