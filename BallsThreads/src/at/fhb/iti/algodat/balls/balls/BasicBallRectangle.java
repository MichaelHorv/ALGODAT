package at.fhb.iti.algodat.balls.balls;

import java.awt.Color;
import java.awt.Graphics;

public class BasicBallRectangle {

	private int posx;
	private int sizey;
	private int posy;
	private int sizex;

	public BasicBallRectangle(int d, int e, int f, int g) {
		posx=d; posy=e; sizex=f; sizey=g;
	}
	
	public boolean isTouchedBy(int x, int y,int dx, int dy) {
		return x + dx >= posx && x <= posx + sizex &&
			   y + dy >= posy && y <= posy + sizey ;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect( posx, posy, sizex, sizey);	
	}
	
}
