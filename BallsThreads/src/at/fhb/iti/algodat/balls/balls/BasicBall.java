package at.fhb.iti.algodat.balls.balls;

import java.awt.Color;
import java.awt.Graphics;

import at.fhb.iti.algodat.balls.BallRectangle;
import at.fhb.iti.algodat.balls.defs.Definitions;
import at.fhb.iti.algodat.balls.grafics.BallsPanel;

public class BasicBall {
	
	private static int counter = 0;
	
	protected int number;
	
	private Color theColor;
	private int xsize;
	private int ysize;
	
	private int posx;
	private int deltax;

	private int posy;
	private int deltay;
	
	private int maxX;
	private int maxY;


	public BasicBall(BallsPanel ballsPanel) {
		  theColor = new Color( randomI(0,180), randomI(0,180), randomI(0,180));
	      xsize = randomI(10,40);
	      ysize = xsize;
	      
	      maxX = ballsPanel.getWidth()-xsize - Definitions.OFFSET;
	      maxY = ballsPanel.getHeight()-ysize - Definitions.OFFSET;

	      posx= randomI(0, maxX/3 - xsize );
	      posy= randomI(0, maxY);
	      
	      deltax = randomI(1,10);
	      deltay = randomI(1,10);
	      
	      number = counter;
	      counter++;
	      
	}

	
	private double randomV(double upper, double lower)
	   {
	       assert lower < upper;
	       return Math.random()*(upper - lower) + lower;
	   }
	
    private int randomI(int upper, int lower) {
	       assert lower < upper;
    	   return (int) randomV(upper, lower);
    }

	
    
    public void move()  {  

    	posx += deltax; 
        posy += deltay; 
        
          if (posx < 0) 
                { posx = 0; deltax = -deltax; } 
          if (posx > maxX )  
                { posx = maxX ; deltax = -deltax; } 
          if (posy < 0) 
                { posy = 0; deltay = -deltay; } 
          if (posy  > maxY)  
                { posy = maxY ; deltay = -deltay; } 
          
          // System.out.println("Ball " + this.number + " moving to " + posx + ", " + posy);

    } 

    
	public void paintComponent(Graphics g) {
		   g.setColor(theColor);
		   g.fillOval(posx,posy,xsize,ysize);      
	}
	
	protected boolean isTouching(BallRectangle tR) {
		return tR.isTouchedBy( posx, posy, xsize, ysize);
	}
	
}
