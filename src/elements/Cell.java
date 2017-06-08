package elements;

import javax.swing.Action;
import javax.swing.JButton;

public class Cell extends JButton{
	boolean alive;
	
	public Cell(Action a) {
		super(a);
		alive=false;
	}
	
	public void toggle(){
		alive=!alive;
	}

}
