package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import frame.GameFrame;

@SuppressWarnings("serial")
public class StepAction extends AbstractAction {
	GameFrame frame;
	
	public StepAction(String name, GameFrame frame){
		super(name);
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getGrid().updateGrid();
	}

}
