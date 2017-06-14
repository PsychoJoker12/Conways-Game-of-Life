package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import frames.GameFrame;

@SuppressWarnings("serial")
public class LoadSavedGridAction extends AbstractAction {
	GameFrame frame;
	
	public LoadSavedGridAction(String name, GameFrame frame){
		super(name);
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getTimer().stop();
		frame.getGrid().loadSavedGrid();
	}
}
