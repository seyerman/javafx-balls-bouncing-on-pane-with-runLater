package threads;

import javafx.application.Platform;
import ui.BallBouncingGUI;

public class GUIUpdateControlThread extends Thread{
	private final static long UPDATE_SLEEP_TIME = 5;
	private BallBouncingGUI ballBouncingGUI;
	
	public GUIUpdateControlThread(BallBouncingGUI bbg) {
		ballBouncingGUI = bbg;
	}
	
	public void run() {
		while (true) {
			GUIUpdateRunnable gur = new GUIUpdateRunnable(ballBouncingGUI);
			Platform.runLater(gur);

			try {
				sleep(UPDATE_SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
