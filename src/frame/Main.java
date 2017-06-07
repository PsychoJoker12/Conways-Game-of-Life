package frame;

import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		Runnable runner=new frame.GameFrame();
		EventQueue.invokeLater(runner);
	}

}
