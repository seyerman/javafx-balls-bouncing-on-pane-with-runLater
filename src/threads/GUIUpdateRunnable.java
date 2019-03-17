package threads;

import ui.BallBouncingGUI;

public class GUIUpdateRunnable implements Runnable{
	private BallBouncingGUI ballBouncingGUI;
	public GUIUpdateRunnable(BallBouncingGUI bbg) {
		ballBouncingGUI = bbg;
	}
	
	@Override
	public void run() {
		ballBouncingGUI.updateCircles();
	}
}
