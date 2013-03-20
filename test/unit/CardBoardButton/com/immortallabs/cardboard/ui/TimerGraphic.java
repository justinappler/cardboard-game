package com.immortallabs.cardboard.ui;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

import com.immortallabs.cardboard.game.Timer;

import edu.profdalbey.Natural;

/**
 * <p>The TimerGraphic class displays the information of
 * a Timer in a graphical display.</p>
 *
 * <br><br>
 * <b>Operations:</b>
 * <ul>
 * <li>The TimerGraphic class can graphically display a Timer.
 * </ul>
 *
 * @author Ryan S. Lange
 * @version 0.2
 * @version 12/04/08
 * 
 * @see Timer
 * @see Point
 * 
 * @history
 *  - 12/04/08 0.2 Added Version History & Pseudocode<br>
 *  - 12/01/08 0.1 Initial Class Skeleton<br>
 */

public class TimerGraphic extends JComponent
{
	/**
	 * Instance of the Timer
	 */
	private Timer theTimer;
	
	/**
	 * Holds the total amount of seconds on the timer
	 */
	private Natural totalSeconds;
	
	/**
	 * Holds the amount of hours the seconds has
	 */
	private int hours;
	
	/**
	 * Holds the amount of minutes the seconds has 
	 */
	private int minutes;
	
	/**
	 * Holds the amount of seconds from the TotalSeconds
	 */
	private int seconds;
	
	/**
	 * Holds the string to show the time
	 */
	private String timeString;
	
	/**
	 * Holds the point to be painted
	 */
	private Point myPoint;
	
	
	/**
	 * Initializes the TimerGraphic with a Timer t
	 * at the position of the Point p.
	 *
	 * @param p the Point at which to draw the TimerGraphic window.
	 * @param t the Timer that we are displaying.
	 */
    public TimerGraphic(Point p, Timer t) 
    {

    }
    
    /**
     * Makes the string to put into the text field of the window
     */
    private String makeTimerString()
    {

    	return null;
    }
    
    /**
     * Converts the totalSeconds into hours, minutes, and seconds
     */
    private void convertTotalSeconds()
    {

    }
    
    @Override
	public void paint(Graphics g)
	{

	}
}
