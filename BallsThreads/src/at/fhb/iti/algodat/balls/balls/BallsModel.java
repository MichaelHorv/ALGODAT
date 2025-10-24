package at.fhb.iti.algodat.balls.balls;

import java.util.HashSet;
import java.util.Set;

import at.fhb.iti.algodat.balls.Ball;
import at.fhb.iti.algodat.balls.BallRectangle;
import at.fhb.iti.algodat.balls.defs.Definitions;

public class BallsModel {

	private BallRectangle theRectangle;
	Set<Ball> theBallSet;

	public BallsModel(){
		theBallSet = new HashSet<Ball>();
		theRectangle = null;
	}
	
	
	public void add(Ball b) {
		theBallSet.add(b);
	}

	public BallRectangle getRectangle() {
		return theRectangle;
		
	}

	public Set<Ball> getBallSet() {
		return theBallSet;
	}

	public void register(BallRectangle br) {
		theRectangle = br;		
	}


	public void removeABall() {
		if ( ! theBallSet.isEmpty() ) {
            int ballsOut = theBallSet.size();
            if (ballsOut < Definitions.MAXBALLSINRECT) {
            }
                BallRectangle.setInRect(ballsOut);
            }
			Ball b = theBallSet.iterator().next();
			b.stop();
			theBallSet.remove(b);
		}
	}
