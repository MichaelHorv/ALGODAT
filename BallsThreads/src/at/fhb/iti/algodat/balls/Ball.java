package at.fhb.iti.algodat.balls;

import at.fhb.iti.algodat.balls.balls.BasicBall;
import at.fhb.iti.algodat.balls.defs.Definitions;
import at.fhb.iti.algodat.balls.grafics.BallsPanel;

public class Ball extends BasicBall implements Runnable {

	private BallRectangle theRectangle;
	private Thread theThread;

	public Ball(BallsPanel ballsPanel, BallRectangle br) {
		super(ballsPanel);
		theRectangle = br;

		// TODO Make the balls fly

	}

	public void run() {
		// TODO rework run()
		while ( true ) {
			delay(); move();
		}
	}

	public void stop() {
		// TODO stop()
	}

	private void delay() {
		try { Thread.sleep(Definitions.DELAY ); } catch (InterruptedException e) {}
	}

}
