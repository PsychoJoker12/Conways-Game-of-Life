import java.awt.EventQueue;

import javax.swing.JFrame;

public class Frame {
	public static void main(String[] args) {
		Runnable runner=new Runnable() {
			public void run(){
				JFrame frame=new JFrame("Conway's Game of Life");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1080, 720);
				frame.setVisible(true);
			}
		};
		EventQueue.invokeLater(runner);
	}
}
