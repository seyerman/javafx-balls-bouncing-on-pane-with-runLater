package ui;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.BallsPool;
import threads.BallThread;
import threads.GUIUpdateControlThread;

public class BallBouncingGUI {
	
	private Stage stage;

    @FXML
    private Pane pane;
    
    private List<Circle> circles;
    
    private BallsPool ballsPool;
    
    private long timePressed;
    
    @FXML
    public void initialize() {
    	ballsPool = new BallsPool();
    	circles = new ArrayList<Circle>();
    	GUIUpdateControlThread gut = new GUIUpdateControlThread(this);
    	gut.setDaemon(true);
    	gut.start();
    }
    
    public void setStage(Stage st) {
    	stage = st;
    }
    
    @FXML
    public void onPressed(MouseEvent event) {
    	timePressed = System.currentTimeMillis();
    }
    
    @FXML
    public void onRelease(MouseEvent event) {
    	long timeRelease = System.currentTimeMillis();
    	long timeElapsed = timeRelease - timePressed;
    	System.out.println(timeElapsed);
    	
    	//creating the new ball through of the pool balls
    	int id = ballsPool.addBall(event.getSceneX(), event.getSceneY(), timeElapsed);
    	
    	//generating random color
    	Color randomColor = new Color(Math.random(),Math.random(),Math.random(),1);
    	
    	//creating the circle shape and adding to pane container
    	Circle c = new Circle(ballsPool.getBall(id).getRadius(), randomColor);
    	c.setLayoutX(ballsPool.getBall(id).getX());
    	c.setLayoutY(ballsPool.getBall(id).getY());
    	pane.getChildren().add(c);
    	circles.add(c);

    	BallThread bt = new BallThread(ballsPool.getBall(id), this);
    	bt.setDaemon(true);
    	bt.start();
    }
    
    //update all circles
	public void updateCircles() {
		for (int id = 0; id < circles.size(); id++) {
			circles.get(id).setLayoutX(ballsPool.getBall(id).getX());
			circles.get(id).setLayoutY(ballsPool.getBall(id).getY());			
		}
	}

	public double getWith() {
		return stage.getWidth();
	}

}
