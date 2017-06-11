package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import frames.GameFrame;

public class ClearScreenAction extends AbstractAction{
	GameFrame frame;
	
	public ClearScreenAction(String name, GameFrame frame) {
		super(name);
		this.frame=frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getGrid().clear();
	}
}
