package at.fhb.iti.algodat.balls;

import at.fhb.iti.algodat.balls.balls.BasicBall;
import at.fhb.iti.algodat.balls.defs.Definitions;
import at.fhb.iti.algodat.balls.grafics.BallsPanel;

public class Ball extends BasicBall implements Runnable {

    private boolean shallRun;
    private BallRectangle theRectangle;
	private Thread theThread;

	public Ball(BallsPanel ballsPanel, BallRectangle br) {
		super(ballsPanel);
		theRectangle = br;
        shallRun = true;

        new Thread(this).start();

	}

	public void run() {
		while (shallRun) {
            while (!isTouching(theRectangle) && shallRun) {
                delay();
                move();
            }
            theRectangle.occupy();
            while(isTouching(theRectangle) && shallRun){
                delay();
                move();
            }
            theRectangle.free();
        }
	}

	public void stop() {
		shallRun = false;

        
	}

	private void delay() {
		try { Thread.sleep(Definitions.DELAY ); } catch (InterruptedException e) {}
	}

}
