package com.immortallabs.cardboard.ui;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import com.immortallabs.cardboard.game.Timer;


/**
 * Fake 
 */

public class TimerGraphic extends Component
{

	
	private Point p; 
   
   private static int tempCount = 0; 
	/**
	 * Initializes the TimerGraphic with a Timer t
	 * at the position of the Point p.
	 *
	 * @param p the Point at which to draw the TimerGraphic window.
	 * @param t the Timer that we are displaying.
	 */
    public TimerGraphic(Point p, Timer t) 
    {

    	this.p = p; 
    }
    
    /**
     * Creates a window to display the current timer
     * 
     * @param p the Point at which to draw the timerGraphic window.
     */
    private void createWindow()
    {
    	//CREATE a window at the point p passed in
    	//SET length of window to ....
    	//SET height of window to ....
    	
    	//ADD hours : minutes : seconds to the window
    	//CALL paint() with the window
    }
    /**
     * Converts the totalSeconds into hours, minutes, and seconds
     */
    private void convertTotalSeconds()
    {
    	//SET hours   to totalSeconds / (60 * 60)
    	//SET minutes to (totalSeconds / 60) % 60
    	//SET seconds to totalSeconds % 60
    }
    
    @Override
	public void paint(Graphics g)
	{
    	//PAINT the timer graphics window

		super.paint(g);
		g.setColor(Color.black); 
		g.drawString("Time: 3:12", p.x, p.y); 
      if(tempCount++ == 0) 
      {
		System.out.println("Timer Graphic printed"); 
      } 
   }
}
