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


	public synchronized void removeABall() {
		if ( ! theBallSet.isEmpty() ) {
			Ball b = theBallSet.iterator().next();
			if (b.isTouching(theRectangle) && theBallSet.size() <= Definitions.MAXBALLSINRECT)
			{
				theRectangle.free();
			}
			b.stop();
			theBallSet.remove(b);

		}
	}
}
