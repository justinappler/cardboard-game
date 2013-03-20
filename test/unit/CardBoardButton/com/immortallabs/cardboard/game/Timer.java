package com.immortallabs.cardboard.game;

import java.util.Observable;
import java.util.TimerTask;

import edu.profdalbey.Natural;

/**
 * <p>
 * Counts the number of seconds that have passed continuously. Timer also will
 * handle counting down a specified number of seconds and can have a concurrent
 * buzz-in count down timer.
 * </p>
 * <b>Operations:</b>
 * <ul>
 * <li>Timer can return the number of seconds passed in the game.</li>
 * <li>Timer can be paused/resumed.</li>
 * <li>Timer class can count down a specified number of seconds.</li>
 * <li>Timer class will handle user buzzing in.</li>
 * <li>Time can be checked for expiration.</li>
 * </ul>
 * 
 * @author Justin C. Appler
 * @author Sky Eckstrom
 * @author Immortal Labs CSC309 W09
 * @version 1.3
 * @version 01/30/09
 * @history - 01/30/09 1.3 Added an isExpired check<br>
 *          Timer notifies observers on all changes now<br>
 *          - 01/12/09 1.2 jappler took ownership of class, updated version<br>
 *          - 12/04/08 1.1 Added Version History & Pseudocode<br>
 *          - 11/30/08 1.0 Inital Class Skeleton<br>
 **/

public class Timer extends Observable
{
	/**
	 * Represents the different possible timer limits
	 */
	public enum TIMER_LIMIT
	{
		/** Fifiteen second countdown */
		FIFTEEN_SECONDS(15),

		/** Thirty second countdown */
		THIRTY_SECONDS(30),

		/** Fourty five second countdown */
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

	/** The period of the timer in milliseconds */
	private static final long TIMER_PERIOD = 1000;

	/** The delay prior to starting the timer */
	private static final long TIMER_DELAY = 1000;

	/** Holds all the event listeners for the timer */
	/* private EventListenerList listeners; */

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

	}

	/**
	 * Restarts the counter at zero and resumes the timer if it's paused.
	 **/
	public void startCountUp()
	{

	}

	/**
	 * Pauses the timer.
	 **/
	public void pause()
	{

	}

	/**
	 * Resumes the timer at it's previous count
	 **/
	public void resume()
	{

	}

	/**
	 * Starts a count down with fifteen seconds that runs concurrent to the on
	 * going count up.
	 **/
	public void buzzIn()
	{


	}

	/**
	 * Ends the count down buzz in timer and switches the returned seconds to
	 * the overall count up timer.
	 **/
	public void buzzDone()
	{

	}

	/**
	 * Switches the timer to count-down mode.
	 * 
	 * @param seconds
	 *            the number of seconds to count down.
	 **/
	public void startCountdown(TIMER_LIMIT seconds)
	{

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

	}

	/**
	 * Registers an event listener that will get called every time the timer
	 * fires.
	 * 
	 * @param listener
	 *            the listener to register
	 **/
	/*
	 * public void addTimerListener(EventListener listener) { // ADD the
	 * listener to the EventListeners list listeners.add(EventListener,
	 * listener); }
	 */

	/**
	 * Checks to see if the last update was an expiration.
	 * 
	 * @returns true if the last update was an expiration, false otherwise
	 */
	public boolean isExpired()
	{
		return true;
	}

	/**
	 * <p>
	 * Increments the number of seconds in the timer and fires an event when
	 * it's done
	 * </p>
	 * <b>Operations:</b>
	 * <ul>
	 * <li>Increments the number of seconds passed.</li>
	 * <li>Sends an event when targetSeconds has been reached</li>
	 * </ul>
	 **/
	private class TimerIncrementer extends TimerTask
	{
		/**
		 * Called each tick of the timer to increment the number of seconds.
		 **/
		public void run()
		{

		}
	}
}
