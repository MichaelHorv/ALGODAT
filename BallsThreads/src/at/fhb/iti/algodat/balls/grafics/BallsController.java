package at.fhb.iti.algodat.balls.grafics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import at.fhb.iti.algodat.balls.Ball;
import at.fhb.iti.algodat.balls.BallRectangle;
import at.fhb.iti.algodat.balls.balls.BallsModel;

public class BallsController implements ActionListener, Runnable {

	private BallsModel theModel;
	private BallsPanel thePanel;
	private BallRectangle theRectangle;

	public BallsController(BallsModel bm) {
		theModel = bm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("Button pressed!" + e);
		
		if ( e.getActionCommand() == "Toss") {
			    theModel.add(new Ball(thePanel,theRectangle));
		} else 	if ( e.getActionCommand() == "Toss10") {
			  for (int i = 0 ; i < 10; i ++)
				theModel.add(new Ball(thePanel,theRectangle));
		} else 	if ( e.getActionCommand() == "Toss100") {
			for (int i = 0 ; i < 100; i ++)
				theModel.add(new Ball(thePanel,theRectangle));
		} else if ( e.getActionCommand() == "Remove") {
			    theModel.removeABall();
		} else if ( e.getActionCommand() == "Remove10") {
			  for (int i = 0 ; i < 10; i ++)
				 theModel.removeABall();
		} else if ( e.getActionCommand() == "Remove100") {
			for (int i = 0 ; i < 100; i ++)
				theModel.removeABall();
	    }
	}
	
	public void registerView(BallsPanel jPanel) {
		thePanel = jPanel;
		new Thread(this).start();
	}
	
	public void run() {
		while (true) {
 		   thePanel.repaint();
		   try { Thread.sleep(25); } catch (InterruptedException e) {}
		}
	}

	public void register(BallRectangle br) {
		theRectangle = br;
		
	}

	
}
