package actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class SimulationAction extends AbstractAction{
	public SimulationAction(){
		super("Run Simulation");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO make an action
		System.out.println("RUN");
	}
}
