package com.immortallabs.cardboard.game;

import java.util.Observable;
import java.util.TimerTask;

import edu.profdalbey.Natural;

/**
 * FAKE! from Release 2 in Trunk
 */

public class Timer extends Observable
{
    /**
     * Represents the different possible timer limits
     */
    public enum TIMER_LIMIT
    {
        /** Fifteen second countdown */
        FIFTEEN_SECONDS(15),

        /** Thirty second countdown */
        THIRTY_SECONDS(30),

        /** Forty five second countdown */
        FOURTYFIVE_SECONDS(45),

        /** Unlimited i.e. no countdown */
        UNLIMITED(0);

        /** The number of seconds for the enumeration */
        private int seconds;

        /**
         * Creates the given TIMER_LIMIT enum with the relevant time in seconds
         * 
         * @param seconds
         *            The time in seconds
         */
        TIMER_LIMIT(int seconds)
        {
            // SET this enums seconds to seconds
            this.seconds = seconds;
        }

        /**
         * Gets the time in seconds of the TIMER_LIMIT enum
         * 
         * @return the time in seconds
         */
        private int getTimeInSeconds()
        {
            // RETURN seconds
            return seconds;
        }
    }

    /** The value for target seconds when not counting down */
    private static final int kCountdownDisabled = -1;

    /** The period of the timer in milliseconds */
    private static final long kTimerPeriod = 1000;

    /** The delay prior to starting the timer */
    private static final long kTimerDelay = 1000;

    /** Holds the number of seconds elapsed in the timer */
    private int seconds;

    /**
     * Holds the target seconds we're counting down to. If targetSeconds is zero
     * we're not counting down to anything.
     */
    private int targetSeconds;

    /** The internal timer that fires once a second */
    private java.util.Timer timer;

    /** Records the current status of the timer (if expired or not) */
    private boolean expired;

    /**
     * Instantiates a new timer with a zero count that begins immediately
     */
    public Timer()
    {
        // SET the state of the expiration to false
        expired = false;

        // SET targetSeconds to 0
        targetSeconds = kCountdownDisabled;

        // SET the seconds to 0
        seconds = 0;

        // CREATE a new timer
        timer = new java.util.Timer();

        // SCHEDULE the timer to fire TimerIncrementer once a second
        timer.scheduleAtFixedRate(new TimerIncrementer(), kTimerDelay,
            kTimerPeriod);
    }

    /**
     * Restarts the counter at zero and resumes the timer if it's paused.
     **/
    public void startCountUp()
    {
        // PAUSE the timer
        pause();
        
        // SET seconds to zero
        seconds = 0;

        // RESUME the timer
        resume();
        
        // SET that the class has been 'changed'
        setChanged();

        // NOTIFY observers that the time has changed
        notifyObservers();
    }

    /**
     * Pauses the timer.
     **/
    public void pause()
    {
        // IF the timer is not null
        if (timer != null)
        {
            // CANCEL the timer
            timer.cancel();

            // SET the timer to null
            timer = null;
        }
    }

    /**
     * Resumes the timer at it's previous count
     **/
    public void resume()
    {
        // IF the timer is not null
        if (timer != null)
        {
            // CANCEL the existing timer
            timer.cancel();
        }

        // CREATE a new timer
        timer = new java.util.Timer();

        // SCHEDULE the timer to fire TimerIncrementer once a second
        timer.scheduleAtFixedRate(new TimerIncrementer(), kTimerDelay,
            kTimerPeriod);
    }

    /**
     * Starts a count down with fifteen seconds that runs concurrent to the on
     * going count up.
     **/
    public void buzzIn()
    {
        // SET targetSeconds to 15 seconds
        targetSeconds = TIMER_LIMIT.FIFTEEN_SECONDS.getTimeInSeconds();

    }

    /**
     * Ends the count down buzz in timer and switches the returned seconds to
     * the overall count up timer.
     **/
    public void buzzDone()
    {
        // SET targetSeconds to zero
        targetSeconds = kCountdownDisabled;
    }

    /**
     * Switches the timer to count-down mode.
     * 
     * @param limit
     *            the number of seconds to count down.
     **/
    public void startCountdown(TIMER_LIMIT limit)
    {
        // PAUSE the current timer
        pause();

        // SET the expiration state to !expired
        expired = false;

        // SET target seconds to the passed countdown limit value
        targetSeconds = limit.getTimeInSeconds();

        // RESUME the timer
        resume();
        
        // SET that the class has been 'changed'
        setChanged();

        // NOTIFY observers that the time has changed
        notifyObservers();
    }

    /**
     * Returns the current number of seconds on the timer, if in count up mode
     * the timer will return the number of seconds the timer has been running.
     * If in count down mode the timer will return the number of seconds
     * remaining.
     * 
     * @return the current number of seconds on the timer
     **/
    public Natural getSeconds()
    {
        // CREATE a natural reference
        Natural returnedSeconds;

        // IF targetSeconds is nonzero
        if (targetSeconds != kCountdownDisabled)
        {
            // SET seconds to targetSeconds
            returnedSeconds = new Natural(targetSeconds);
        }
        // ELSE
        else
        {
            // SET seconds to seconds
            returnedSeconds = new Natural(this.seconds);
        }

        // RETURN the number of seconds on the clock
        return returnedSeconds;
    }

    /**
     * Checks to see if the last update was an expiration.
     * 
     * @return true if the last update was an expiration, false otherwise
     */
    public boolean isExpired()
    {
        // SET a local variable to the expiration state
        boolean isExpired = expired;

        // IF the state is expired
        if (isExpired)
        {
            // SET expired to false
            expired = false;
        }

        return isExpired;
    }

    /**
     * <p>
     * Increments the number of seconds in the timer and notifies observers
     * that the number of seconds has changed.
     * </p>
     * <b>Operations:</b>
     * <ul>
     * <li>Increments the number of seconds passed.</li>
     * <li>Notifies observers when each second passes.</li>
     * </ul>
     **/
    private class TimerIncrementer extends TimerTask
    {
        /**
         * Called each tick of the timer to increment the number of seconds.
         **/
        public void run()
        {
            // IF targetSeconds is 0
            if (targetSeconds == 0)
            {
                // SET the expiration state to expired
                expired = true;

                // SET targetSeconds to -1
                targetSeconds = kCountdownDisabled;

                // CANCEL the timer task
                cancel();
            }
            // ELSE IF the target seconds is not yet 0
            else if (targetSeconds > 0)
            {
                // DECREMENT the targetSeconds
                targetSeconds--;
            }
            // ELSE
            else
            {
                // INCREMENT the seconds
                seconds++;
            }
            // END IF

            // SET that the class has been 'changed'
            setChanged();

            // NOTIFY observers that a second has passed
            notifyObservers();
        }
    }
}