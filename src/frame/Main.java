package frame;

import java.awt.EventQueue;

public class Main {
	static GameFrame frame;
	
	public static void main(String[] args) {
		frame=new frame.GameFrame();
		frame.instantiateButtons();
		EventQueue.invokeLater(frame);
	}
	
	public static GameFrame getFrame(){
		return frame;
	}
}
