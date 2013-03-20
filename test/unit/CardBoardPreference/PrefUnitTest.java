package unit.CardBoardPreference;

import junit.framework.TestCase;

import com.immortallabs.cardboard.CardBoardPreferences;

public class PrefUnitTest extends TestCase
{
    CardBoardPreferences prefs = CardBoardPreferences.getInstance();
    
    public void testGetInstance_Default()
    {
        String players = prefs.getPreference(CardBoardPreferences.PREF.PLAYERS);
        String time    = prefs.getPreference(CardBoardPreferences.PREF.TIME_LIMIT);
        String sound   = prefs.getPreference(CardBoardPreferences.PREF.SOUNDS);
        
        System.err.println(players);
        System.err.println(time);
        System.err.println(sound);
        
        assertEquals(players, "ONE");
        assertEquals(time, "TIME_15SEC");
        assertEquals(sound, "ON");
    }
    
    public void testChangePlayers()
    {
        String players = prefs.getPreference(CardBoardPreferences.PREF.PLAYERS);
        assertEquals(players, "ONE");
        
        prefs.setPreference(CardBoardPreferences.PREF.PLAYERS, "TWO");  
        String players2 = prefs.getPreference(CardBoardPreferences.PREF.PLAYERS);
        assertEquals(players2, "TWO");
        
        prefs.setPreference(CardBoardPreferences.PREF.PLAYERS, "FOUR");  
        String players4 = prefs.getPreference(CardBoardPreferences.PREF.PLAYERS);
        assertEquals(players4, "FOUR");
        
        prefs.setPreference(CardBoardPreferences.PREF.PLAYERS, "THREE");  
        String players3 = prefs.getPreference(CardBoardPreferences.PREF.PLAYERS);
        assertEquals(players3, "THREE");
    }
    
    public void testChangeTime()
    {
        String time = prefs.getPreference(CardBoardPreferences.PREF.TIME_LIMIT);
        assertEquals(time, "TIME_15SEC");
        
        prefs.setPreference(CardBoardPreferences.PREF.TIME_LIMIT, "TIME_30SEC");  
        String time30 = prefs.getPreference(CardBoardPreferences.PREF.TIME_LIMIT);
        assertEquals(time30, "TIME_30SEC");
        
        prefs.setPreference(CardBoardPreferences.PREF.TIME_LIMIT, "TIME_45SEC");  
        String time45 = prefs.getPreference(CardBoardPreferences.PREF.TIME_LIMIT);
        assertEquals(time45, "TIME_45SEC");
        
        prefs.setPreference(CardBoardPreferences.PREF.TIME_LIMIT, "TIME_UNLIMITED");  
        String timeUnlimited = prefs.getPreference(CardBoardPreferences.PREF.TIME_LIMIT);
        assertEquals(timeUnlimited, "TIME_UNLIMITED");
    }
    
    public void testChangeSound()
    {
        String sound = prefs.getPreference(CardBoardPreferences.PREF.SOUNDS);
        assertEquals(sound, "ON");
        
        prefs.setPreference(CardBoardPreferences.PREF.SOUNDS, "OFF");  
        String soundOff = prefs.getPreference(CardBoardPreferences.PREF.SOUNDS);
        assertEquals(soundOff, "OFF");
        
        prefs.setPreference(CardBoardPreferences.PREF.SOUNDS, "ON");  
        String soundOn = prefs.getPreference(CardBoardPreferences.PREF.SOUNDS);
        assertEquals(soundOn, "ON");
    }
    
    public void testEnumMethods()
    {
    	assertEquals(CardBoardPreferences.PREF.valueOf("PLAYERS"), 
    		CardBoardPreferences.PREF.PLAYERS);
    	assertEquals(CardBoardPreferences.PREF.valueOf("SOUNDS"), 
        		CardBoardPreferences.PREF.SOUNDS);
    	assertEquals(CardBoardPreferences.PREF.valueOf("TIME_LIMIT"), 
        		CardBoardPreferences.PREF.TIME_LIMIT);
    	
    	CardBoardPreferences.PREF.values();
    }
    
    public void testBadInput_sounds()
    {
        String sound = prefs.getPreference(CardBoardPreferences.PREF.SOUNDS);
        assertEquals(sound, "ON");
        
        prefs.setPreference(CardBoardPreferences.PREF.SOUNDS, "off");  
        String soundOff = prefs.getPreference(CardBoardPreferences.PREF.SOUNDS);
        assertEquals(soundOff, "ON");
        
        prefs.setPreference(CardBoardPreferences.PREF.SOUNDS, "oN");  
        String soundOn = prefs.getPreference(CardBoardPreferences.PREF.SOUNDS);
        assertEquals(soundOn, "ON");
        
        prefs.setPreference(CardBoardPreferences.PREF.SOUNDS, "on");  
        String soundlower = prefs.getPreference(CardBoardPreferences.PREF.SOUNDS);
        assertEquals(soundlower, "ON");
    }
    
    public void testBadInput_time()
    {
        String time = prefs.getPreference(CardBoardPreferences.PREF.TIME_LIMIT);
        assertEquals(time, "TIME_UNLIMITED");
        
        prefs.setPreference(CardBoardPreferences.PREF.TIME_LIMIT, "15");  
        String time30 = prefs.getPreference(CardBoardPreferences.PREF.TIME_LIMIT);
        assertEquals(time30, "TIME_UNLIMITED");
        
        prefs.setPreference(CardBoardPreferences.PREF.TIME_LIMIT, "TIME_45SEC");  
        String time45 = prefs.getPreference(CardBoardPreferences.PREF.TIME_LIMIT);
        assertEquals(time45, "TIME_45SEC");
        
        prefs.setPreference(CardBoardPreferences.PREF.TIME_LIMIT, "88");  
        String timeUnlimited = prefs.getPreference(CardBoardPreferences.PREF.TIME_LIMIT);
        assertEquals(timeUnlimited, "TIME_45SEC");
    }
    
    public void testBadInput_players()
    {
        String players = prefs.getPreference(CardBoardPreferences.PREF.PLAYERS);
        assertEquals(players, "THREE");
        
        prefs.setPreference(CardBoardPreferences.PREF.PLAYERS, "p2");  
        String players2 = prefs.getPreference(CardBoardPreferences.PREF.PLAYERS);
        assertEquals(players2, "THREE");
        
        prefs.setPreference(CardBoardPreferences.PREF.PLAYERS, "haaaa");  
        String players4 = prefs.getPreference(CardBoardPreferences.PREF.PLAYERS);
        assertEquals(players4, "THREE");
        
        prefs.setPreference(CardBoardPreferences.PREF.PLAYERS, "what?");  
        String players3 = prefs.getPreference(CardBoardPreferences.PREF.PLAYERS);
        assertEquals(players3, "THREE");
    }
}
