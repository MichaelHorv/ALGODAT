package at.fhb.iti.algodat.balls.grafics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import at.fhb.iti.algodat.balls.Ball;
import at.fhb.iti.algodat.balls.balls.BallsModel;
import at.fhb.iti.algodat.balls.defs.Definitions;

public class BallsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private BallsModel theModel;

	protected void paintComponent(Graphics g) {
		if (isOpaque()) {
			g.setColor(getBackground());
			g.fillRect(0, 0, this.getWidth() - Definitions.OFFSET, this.getHeight()- Definitions.OFFSET);
		}
		g.setColor(Color.BLACK);
		g.drawRect( 0, 0, this.getWidth() - Definitions.OFFSET, this.getHeight() - Definitions.OFFSET);

		if (theModel != null) {
			if (theModel.getRectangle() !=  null)
			    theModel.getRectangle().paintComponent(g);
			for (Ball b : theModel.getBallSet()) {
				b.paintComponent(g);
			}
		}
	}

	public void registerModel(BallsModel bm) {
		theModel=bm;
	}
	
}
