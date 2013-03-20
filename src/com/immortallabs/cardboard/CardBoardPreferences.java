package com.immortallabs.cardboard;

import java.util.HashMap;

/**
 * <p>
 * The CardBoardPreferences class models all options for the game. If a player
 * changes any options this class persists the change until next game is started
 * </p>
 * <b>Operations:</b>
 * <ul>
 * <li>The CardBoardPreferences class can get a current game preference
 * <li>The CardBoardPreferences class can set a current game preference
 * </ul>
 * 
 * @author Ryan Lange
 * @author Formerly Thomas Dvornik
 * @author RustyNail CSC308 F08
 * @version 1.3
 * @version 12/05/08
 * @history - 02/20/09 1.2 Changed to a singleton class. - 12/02/08 1.1 Added
 *          Version History & Pseudocode to CardBoardPreference(),
 *          getPreferences(), setPreference()<br> 
            - 12/03/08 1.2 Moved into correct package.<br> 
 */
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
        // INSTANTIATE A NEW HASHMAP
        prefMap = new HashMap<PREF, String>();

        // LOAD prefMap with default settings
        prefMap.put(PREF.TIME_LIMIT, time15);
        prefMap.put(PREF.PLAYERS, players1);
        prefMap.put(PREF.SOUNDS, soundOn);
    }

    /**
     * Gives the current state of the preferences
     * 
     * @return instance : The current instance of CardBoardPreferences
     */
    public static CardBoardPreferences getInstance()
    {
        // IF an instance has not been constructed yet
        if (instance == null)
        {
            // CALL the constructer to get an instance of CardBoardPreferences
            instance = new CardBoardPreferences();
        }
        // END IF

        // RETURN the newly created instance
        return instance;
    }

    /**
     * @param pref
     *            the desired enumeration
     * @return The value of the desired enumeration
     */
    public String getPreference(PREF pref)
    {
        // RETURN the value of the given key from prefMap
        return prefMap.get(pref);
    }

    /**
     * @param pref
     *            The enumeration to modify
     * @param value
     *            The new value of the enumeration pref
     */
    public void setPreference(PREF pref, String value)
    {
        // SET validValue to false
        boolean validValue = false;

        // IF pref is the TIME_LIMIT enum
        if (pref == PREF.TIME_LIMIT)
        {
            // IF value is a valid time value
            if (value.equals(time15) || value.equals(time30)
                    || value.equals(time45) || value.equals(timeUnlimited))
            {
                // SET validValue to true
                validValue = true;
            }
            // ELSE
            else
            {
                // PRINT error message
                System.err.println("Bad TIME_LIMIT: " + value);
            }
            // END IF
        }
        // ELSE IF pref is the PLAYERS enum
        else if (pref == PREF.PLAYERS)
        {
            // IF value is a valid players value
            if (value.equals(players1) || value.equals(players2)
                    || value.equals(players3) || value.equals(players4))
            {
                // SET validValue to true
                validValue = true;
            }
            // ELSE
            else
            {
                // PRINT error message
                System.err.println("Bad PLAYERS: " + value);
            }
            // END IF
        }
        // ELSE IF pref is the SOUNDS enum
        else if (pref == PREF.SOUNDS)
        {
            // IF value is a valid value
            if (value.equals(soundOn) || value.equals(soundOff))
            {
                // SET validValue to true
                validValue = true;
            }
            // ELSE
            else
            {
                // PRINT error message
                System.err.println("Bad SOUND: " + value);
            }
            // END IF
        }
        // END IF

        // IF validValue is true
        if (validValue)
        {
            // SET the given key pref to the given value in prefMap
            prefMap.put(pref, value);
        }
        // END IF
    }
}
