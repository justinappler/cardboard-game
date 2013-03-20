package com.immortallabs.cardboard;

import java.util.HashMap;


public class CardBoardPreferences
{
    /** Represents limit limit of 15 seconds */
    private String time15 = "TIME_15SEC";

    /** Represents limit limit of 30 seconds */
    private String time30 = "TIME_30SEC";

    /** Represents limit limit of 45 seconds */
    private String time45 = "TIME_45SEC";

    /** Represents an unlimited time limit */
    private String timeUnlimited = "TIME_UNLIMITED";

    /** Represents a 1 player game */
    private String players1 = "ONE";

    /** Represents a 2 player game */
    private String players2 = "TWO";

    /** Represents a 3 player game */
    private String players3 = "THREE";

    /** Represents a 4 player game */
    private String players4 = "FOUR";

    /** Represents sound is on */
    private String soundOn = "ON";

    /** Represents sound is off */
    private String soundOff = "OFF";

    /** Holds each preference with is value */
    private HashMap<PREF, String> prefMap;

    /** Holds the instance of CardBoardPreferenece */
    private static CardBoardPreferences instance;

    /**
     * The enumeration for different preferences
     * 
     * @author rslange
     */
    public enum PREF
    {
        /**
         * The different preferences that a user can save for future games.
         */
        TIME_LIMIT, PLAYERS, SOUNDS;
    }

    /**
     * Constructs a new CardBoardPreferences
     */
    private CardBoardPreferences()
    {

    }


    public static CardBoardPreferences getInstance()
    {
        if (instance == null)
        {
            instance = new CardBoardPreferences();
        }
        return instance;
    }


    public String getPreference(PREF pref)
    {
        return null;
    }


    public void setPreference(PREF pref, String value)
    {
        
    }
}
