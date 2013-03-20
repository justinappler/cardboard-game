package com.immortallabs.cardboard.game;

import java.util.Observable;
import java.util.EventListener;
import java.util.TimerTask;

import javax.swing.event.EventListenerList;

import edu.profdalbey.Natural;

/**
 * --FAKE--
 *	<p>Counts the number of seconds that have passed
 *	continuously. Timer also will handle counting down
 *	a specified number of seconds and can have a
 *	concurrent buzz-in count down timer.</p>
 *
 *	<b>Operations:</b>
 *	<ul>
 *	<li>Timer can return the number of seconds passed in the game.</li>
 *	<li>Timer can be paused/resumed.</li>
 *	<li>Timer class can count down a specified number of seconds.</li>
 *	<li>Timer class will handle user buzzing in.</li>
 *	</ul>
 *	
 *  @author Thomas Dvornik
 *
 **/

public class Timer extends Observable
{
	/**
	 *	Represents the different possible timer limits
	 **/
	public enum TIMER_LIMIT
	{
		/** Fifiteen second countdown **/
		FIFTEEN_SECONDS,
		
		/** Thirty second countdown **/
		THIRTY_SECONDS,
		
		/** Fourty five second countdown **/
		FOURTYFIVE_SECONDS,
		
		/** Unlimited i.e. no countdown **/
		UNLIMITED
	}
	
	/** Holds all the event listeners for the timer **/
	private EventListenerList listeners;
	
	/** Holds the number of seconds elapsed in the timer **/
	private int seconds;
	
	/**	Holds the target seconds we're counting down to.
	 *	If targetSeconds is zero we're not counting down
	 *	to anything.
	 **/
	private int targetSeconds;
	
	/** The internal timer that fires once a second **/
	private java.util.Timer		timer;
	
	/**
	 *	Instantiates a new timer with a zero
	 *	count that begins immediately
	 **/
	public Timer()
	{
		//	CREATE a new timer
		//	SCHEDULE the timer to fire TimerIncrementer once a second
	}
	
	/**
	 *	Restarts the counter at zero and resumes
	 *	the timer if it's paused.
	 **/
	public void startCountUp()
	{
		// IF the timer is null
			// CREATE a new timer
			// SCHEDULE the timer to fire TimerIncrementer once a second
		
		// SET seconds to zero
	}
	
	/**
	 *	Pauses the timer.
	 **/
	public void pause()
	{
		// IF the timer is not null
			// CANCEL the timer
			// SET the timer to null
	}
	
	/**
	 *	Resumes the timer at it's previous count
	 **/
	public void resume()
	{
		// IF the timer is null
			// CREATE a new timer
			// SCHEDULE the timer to fire TimerIncrementer once a second
	}
	
	/**
	 *	Starts a count down with fifteen seconds
	 *	that runs concurrent to the on going count up.
	 **/
	public void buzzIn()
	{
		// SET targetSeconds to the current time + 15 seconds	
	}
	
	/**
	 *	Ends the count down buzz in timer and switches
	 *	the returned seconds to the overall count up
	 *	timer.
	 **/
	public void buzzDone()
	{
		// SET targetSeconds to zero
	}
	
	/**
	 *	Switches the timer to count-down mode that runs
	 *	concurrent to the ongoing count up.
	 *
	 *	@param	seconds		the number of seconds to count down.
	**/
	public void startCountdown(TIMER_LIMIT seconds)
	{
		// SWITCH on seconds
			// CASE FIFTEEN_SECONDS
				// SET targetSeconds to the current time + 15 seconds
			// CASE THIRTY_SECONDS
				// SET targetSeconds to the current time + 30 seconds
			// CASE FOURTYFIVE_SECONDS
				// SET targetSeconds to the current time + 45 seconds
	}
	
	/**
	 *	Returns the current number of seconds on the timer,
	 *	if in count up mode the timer will return the number
	 *	of seconds the timer has been running. If in count
	 *	down mode the timer will return the number of seconds
	 *	remaining.
	 *
	 *	@return		the current number of seconds on the timer
	 **/
	public Natural getSeconds()
	{
		// IF targetSeconds is nonzero
			// RETURN targetSeconds - seconds
		// ELSE
			// RETURN seconds
		return null;
	}
	
	/**
	 *	Registers an event listener that will get called
	 *	every time the timer fires.
	 *
	 *	@param	listener	the listener to register
	 **/
	public void addTimerListener(EventListener listener)
	{
		// ADD the listener to the EventListeners list
	}
	
	/**
	 *	<p>Increments the number of seconds in the timer and fires
	 *	an event when it's done</p>
	 *
	 *	<b>Operations:</b>
	 *	<ul>
	 *	<li>Increments the number of seconds passed.</li>
	 *	<li>Sends an event when targetSeconds has been reached</li>
	 *	</ul>
	 **/
	private class TimerIncrementer extends TimerTask
	{
		/**
		 *	Called each tick of the timer to increment
		 *	the number of seconds.
		 **/
		public void run()
		{
			// INCREMENT the seconds
			
			// IF targetSeconds is nonzero and seconds = targetSeconds
				// LOOP through the event listener list
					// SEND the timer event to the current listener
		}
	}
}