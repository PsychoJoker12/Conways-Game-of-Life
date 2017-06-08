package elements;

import javax.swing.JButton;

public class Cell extends JButton{
	boolean alive;
	
	public Cell(int row, int col) {
		super("Cell ("+row+","+col+")");
		alive=false;
	}
	
	public void toggle(){
		alive=!alive;
	}

}
