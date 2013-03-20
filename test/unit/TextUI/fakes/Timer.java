package com.immortallabs.cardboard.game;
import java.util.Observable;
import java.util.TimerTask;


import edu.profdalbey.Natural;


public class Timer extends Observable
{

    public enum TIMER_LIMIT
    {
        /** Fifteen second countdown */
        TIME_15SEC(15),

        /** Thirty second countdown */
        TIME_30SEC(30),

        /** Forty five second countdown */
        TIME_45SEC(45),

        /** Unlimited i.e. no countdown */
        TIME_UNLIMITED(0);

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

	public Timer()
	{
		
	}
	
	public void startCountUp()
	{
		
	}
	

	public void pause()
	{
		
	}
	

	public void resume()
	{
		
	}
	

	public void buzzIn()
	{
		
	}
	

	public void buzzDone()
	{
		
	}
	

	public void startCountdown(TIMER_LIMIT seconds)
	{
		
	}
	

	public Natural getSeconds()
	{

		return new Natural(0);
	}

	public boolean isExpired()
	{
		return false;
	}
	
	private class TimerIncrementer
	{

	}
}
