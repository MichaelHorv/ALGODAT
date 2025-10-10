package at.fhb.iti.algodat.balls.balls;

import java.util.HashSet;
import java.util.Set;

import at.fhb.iti.algodat.balls.Ball;
import at.fhb.iti.algodat.balls.BallRectangle;

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
			Ball b = theBallSet.iterator().next();
			b.stop();
			theBallSet.remove(b);
		}
	}

}
