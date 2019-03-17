package model;

import java.util.ArrayList;
import java.util.List;

public class BallsPool {
	private List<Ball> balls;
	
	public BallsPool() {
		balls = new ArrayList<Ball>();
	}
	
	public int addBall(double nx, double ny, long st) {
		balls.add(new Ball(nx, ny, st));
		return balls.size()-1;
	}
	
	public Ball getBall(int id) {
		return balls.get(id);
	}
	
	
}
