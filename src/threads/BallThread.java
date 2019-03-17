package threads;

import model.Ball;
import ui.BallBouncingGUI;

public class BallThread extends Thread{
	private Ball ball;
	private BallBouncingGUI ballBouncingGUI;
	private boolean moving;
	
	public BallThread(Ball b, BallBouncingGUI bbgui) {
		ball = b;
		moving = true;
		ballBouncingGUI = bbgui;
	}
	
	public void run() {
		while(moving) {
			ball.move(ballBouncingGUI.getWith());
			try {
				sleep(ball.getSleepTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
