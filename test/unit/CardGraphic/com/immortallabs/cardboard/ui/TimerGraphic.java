package com.immortallabs.cardboard.ui;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;

import com.immortallabs.cardboard.game.Timer;

import edu.profdalbey.Natural;

/**
 * <p>
 * The TimerGraphic class displays the information of a Timer in a graphical
 * display.
 * </p>
 * <br>
 * <br>
 * <b>Operations:</b>
 * <ul>
 * <li>The TimerGraphic class can graphically display a Timer.
 * </ul>
 * 
 * @author Ryan S. Lange
 * @version 0.3
 * @version 12/04/08
 * @see Timer
 * @see Point
 * @history - 01/21/09 0.3 Added source code - 12/04/08 0.2 Added Version
 *          History & Pseudocode<br> - 12/01/08 0.1 Initial Class Skeleton<br>
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
     * Final for 10
     */
    private static final int kTen = 10;
    
    /**
     * Final for 60
     */
    private static final int kSixty = 60;

    /**
     * Final for 26
     */
    private static final int kTwentySix = 26;
    
    /**
     * Final for 130
     */
    private static final int kOneThirty = 130;
    
    /**
     * Final for 30
     */
    private static final int kThirty = 30;
    
    /**
     * Initializes the TimerGraphic with a Timer t at the position of the Point
     * p.
     * 
     * @param p
     *            the Point at which to draw the TimerGraphic window.
     * @param t
     *            the Timer that we are displaying.
     */
    public TimerGraphic(Point p, Timer t)
    {
        //SET thetimer to t
        theTimer = t;
        
        //SET timeString to null
        timeString = null;
        
        //SET myPoint to p
        myPoint = p;

        //CALL makeTimerString
        makeTimerString();
    }

    /**
     * Makes the string to put into the text field of the window
     */
    private String makeTimerString()
    {
        //SET totalSeconds to return value of theTimer's seconds
        totalSeconds = theTimer.getSeconds();

        //CALL convertTotalSeconds
        convertTotalSeconds();

        //SET theHour, theMin, and theSec = null
        String theHour = null, theMin = null, theSec = null;

        //SET theHour to string of hours
        theHour = String.valueOf(hours);

        //IF minutes are less than 10
        if (minutes < kTen)
        {
            //theMin = "0" + string of minutes
            theMin = "0" + String.valueOf(minutes);
        }
        //ELSE
        else
        {
            //theMin = string of minutes
            theMin = String.valueOf(minutes);
        }
        //END IF
        
        //IF seconds less than 10
        if (seconds < kTen)
        {
            //theSec = "0" + string of seconds
            theSec = "0" + String.valueOf(seconds);
        }
        //ELSE
        else
        {
            //theSec = string of seconds
            theSec = String.valueOf(seconds);
        }
        //END IF
        
        //timeString = theHour + ":" + theMin + ":" + theSec
        timeString = theHour + ":" + theMin + ":" + theSec;
        
        //RETURN timeString
        return timeString;
    }

    /**
     * Converts the totalSeconds into hours, minutes, and seconds
     */
    private void convertTotalSeconds()
    {
        // SET hours to totalSeconds / (60 * 60)
        hours = totalSeconds.intValue() / (kSixty * kSixty);

        // SET minutes to (totalSeconds / 60) % 60
        minutes = (totalSeconds.intValue() / kSixty) % kSixty;

        // SET seconds to totalSeconds % 60
        seconds = totalSeconds.intValue() % kSixty;
    }

    @Override
    public void paint(Graphics g)
    {
        // PAINT the timer graphics window
        // super.paint(g);

        //SET color of background to black
        g.setColor((java.awt.Color.black));
        
        //FILL rect with x and y
        g.fillRect(myPoint.x, myPoint.y - kTwentySix, kOneThirty, kThirty);

        //SET color of text to white
        g.setColor(java.awt.Color.WHITE);
        
        //SET font to arial bold size 32
        g.setFont(java.awt.Font.decode("Arial-BOLD-32"));
        
        //CALL drawString with parameters return of makeTimerString, x, and y
        g.drawString(makeTimerString(), myPoint.x, myPoint.y);
        
        //CALL drawString with parameters timeString, x, an dy
        g.drawString(timeString, myPoint.x, myPoint.y);
    }
}
