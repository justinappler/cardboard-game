package com.immortallabs.cardboard;

import java.util.HashMap;

/**
 * <p>
 * The CardBoardPreferences class models all options for the game. If a player
 * changes any options, the class persist it to retain the information for
 * future games.
 * </p>
 * <b>Operations:</b>
 * <ul>
 * <li>The CardBoardPreferences class can get a current game preference
 * <li>The CardBoardPreferences class can set a current game preference
 * </ul> * File Format for persistence: The file format is the PREF followed by
 * the text that represents the value. They are separated by a space and each
 * different binding is on its own row. ----------------------------- TIMELIMIT
 * 15 PLAYER 2 -----------------------------
 * 
 * @author Ryan Lange
 * @author Formerly Thomas Dvornik
 * @author RustyNail CSC308 F08
 * @version 1.3
 * @version 12/05/08
 * @history - 12/02/08 1.1 Added Version History & Pseudocode to
 *          CardBoardPreference(), getPreferences(), getKeyBindings(),
 *          setPreference(), and setKeyBindings().<br> - 12/03/08 1.2 Split
 *          KeyBinding methods and enum into its own class. Moved into correct
 *          package. Added TODO for persist. - 12/05/08 1.3 Fixed persistence
 *          issue. Changed tree to hash. setPreference appends the new
 *          preference to the file. When the game is started next time and reads
 *          all the rows, if it is in the file twice, it will replace it in the
 *          map. This is a quicker solution and the amount of rows will never
 *          get so large to slow down initialization speed.
 */
public class CardBoardPreferences
{
    private static final String kFileName = "preferences.txt";
    private HashMap<PREF, String> prefMap;
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
     * 
     */
    private CardBoardPreferences()
    {
    	// INSTANTIATE A NEW HASHMAP
    	prefMap = new HashMap<PREF, String>(); 
    	
    	//LOAD prefMap with default settings
    	prefMap.put(PREF.TIME_LIMIT, "15");
    	prefMap.put(PREF.PLAYERS, "1");
    	prefMap.put(PREF.SOUNDS, "on");
    }
    
    public static CardBoardPreferences getInstance()
    {
        if(instance == null)
        {
            instance = new CardBoardPreferences();
        }
        return instance;
    }
    
    /**
     * @param pref
     *            The desired enumeration
     * @return 
     *            The value of the desired enumeration
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
    	// SET the given key pref to the given value in prefMap
        prefMap.put(pref, value); 
    }
}
