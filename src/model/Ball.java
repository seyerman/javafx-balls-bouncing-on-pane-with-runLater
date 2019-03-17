package model;

public class Ball {
	private final static double RADIUS = 20;
	
	public final static double ADVANCE = 10.0;
	
	private StateOfMove state;
	
	private double x;
	private double y;
	private double r;
	private long sleepTime;
	
	public Ball(double newX, double newY, long st) {
		x = newX;
		y = newY;
		r = RADIUS;
		
		sleepTime = st;
		
		state = StateOfMove.FORWARD;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	public double getRadius() {
		return r;
	}
	
	public long getSleepTime() {
		return sleepTime;
	}

	public void move(double max) {
		switch(state) {
			case FORWARD:
				x = x+ADVANCE;
				if(x+r>max) {
					state = StateOfMove.BACKWARD;
				}
			break;
			case BACKWARD:
				x = x-ADVANCE;
				if(x<0) {
					state = StateOfMove.FORWARD;
				}
			break;
		}
	}
}
