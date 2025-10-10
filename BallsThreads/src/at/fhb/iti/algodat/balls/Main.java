package at.fhb.iti.algodat.balls;

import at.fhb.iti.algodat.balls.balls.BallsModel;
import at.fhb.iti.algodat.balls.grafics.*;

public class Main {

	public static void main(String[] args) {

		BallsModel bm = new BallsModel ();
		BallsController bc = new BallsController (bm);
		BallApplication ba = new BallApplication(bc);
		
		bc.registerView(ba.getBallsPanel());
		ba.getBallsPanel().registerModel(bm);
		
		BallRectangle br = new BallRectangle(ba.getBallsPanel().getWidth() / 3, 
						                     ba.getBallsPanel().getHeight() / 3,
                                             ba.getBallsPanel().getWidth() / 3,
                                             ba.getBallsPanel().getHeight()  / 3);
		
		bm.register(br);
		bc.register(br);
		

		bm.add(new Ball(ba.getBallsPanel(),br));
		bm.add(new Ball(ba.getBallsPanel(),br));
		bm.add(new Ball(ba.getBallsPanel(),br));

	}

}
