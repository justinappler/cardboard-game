package com.immortallabs.cardboard;
import java.io.FileNotFoundException;
import java.util.HashMap;

import unit.GameState.TestMonitor;

public class CardBoardPreferences {

    private static CardBoardPreferences pref;
    
	public enum PREF {
		/** The count down time limit for competitive mode. */ 
		TIME_LIMIT,
		
		/** The current theme of the CardBoard game. */
		THEME,
		
		/** The current number of the players if a multiplayer game is created. */
		PLAYERS,
	}
	

	private CardBoardPreferences()
	{
		TestMonitor.add("CardBoardPreference");
	}
	
	public static CardBoardPreferences getInstance()
	{
	    pref = new CardBoardPreferences();
	    
	    return pref;
	}
	
	public String getPreference(PREF pref) 
	{

		TestMonitor.add("CardBoardPreference.getPreference(" + pref.toString() + ")");
		
		if (pref == PREF.PLAYERS)
		{
			return "FOUR";
		}
		else if (pref == PREF.TIME_LIMIT)
		{
			return "FIFTEEN_SECONDS";
		}
		
		return null;
	}
	

	public void setPreference(PREF pref, String value) 
	{
		TestMonitor.add("CardBoardPreference.setPreference");
	}
	
	
	
}
