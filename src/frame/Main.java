package frame;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		GameFrame frame=new frame.GameFrame();
		frame.instantiateButtons();
		EventQueue.invokeLater(frame);
	}

}
