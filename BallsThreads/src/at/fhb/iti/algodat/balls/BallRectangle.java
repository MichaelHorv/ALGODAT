package at.fhb.iti.algodat.balls;

import at.fhb.iti.algodat.balls.balls.BasicBallRectangle;
import at.fhb.iti.algodat.balls.defs.Definitions;

public class BallRectangle extends BasicBallRectangle {



    private static int inRect = 0;


    public static int getInRect() {
        return inRect;
    }

    public static void setInRect(int inRect) {
        BallRectangle.inRect = inRect;
    }
    
	public BallRectangle(int d, int e, int f, int g) {
		super(d,e,f,g);
	}

	public synchronized void occupy() {

        while(inRect >= Definitions.MAXBALLSINRECT)
        {
            try {
                wait();
            }
            catch (Exception ignored)
            {}
        }
        inRect++;
        notify();
    }

	public synchronized void free() {
        inRect--;
        notify();
	}

}
