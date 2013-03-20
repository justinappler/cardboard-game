package com.immortallabs.cardboard.game;
import unit.GameState.TestMonitor;

public class Score 
{
	public enum scoreEvent
	{
		ADD_SET,
		MISS_SET,
		TIME_OUT,
		HINT,
		THREE_MORE
	}
	
    public Score() 
    {
    	TestMonitor.add("Score");
    }
    
    public void modifyScore(scoreEvent event)
    {
    	TestMonitor.add("Score.modifyScore(" + event.toString() + ")");
    }

    public int getScore()
    {
    	TestMonitor.add("Score.getScore");
    	return 0;
    }

    public void resetScore()
    {
    	TestMonitor.add("Score.resetScore");
    }
}