package com.immortallabs.cardboard.ui;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * <p>
 * The KeyBindings class models all key binding for the game. If a player
 * changes any key bindings, the class persist it to retain the information for
 * future games.
 * </p>
 * <b>Operations:</b>
 * <ul>
 * <li>The KeyBindings class can get a specific key binding for an action
 * <li>The KeyBindings class can set a specific key binding for an action
 * </ul>
 * File Format for persistence: The file format is the KEY_BIND followed by the
 * key text that represents it. They are separated by a space and each different
 * binding is on its own row. ----------------------------- HINT h PAUSE p
 * -----------------------------
 * 
 * @author Thomas Dvornik
 * @author RustyNail CSC308 F08
 * @version 1.2
 * @version 12/05/08
 * @history - 12/03/08 Version 1.1 Added Version History. Moved all KeyBinding
 *          methods and enums to KeyBindings class. Added TODO - 12/05/08
 *          Version 1.2 Finished peusdocode and TODO
 */
public class KeyBindings
{
    /** Holds all the key bindings with their current values. */
    private HashMap<KEY_BIND, String> keyBindings;

    /**
     * KEY_BIND models all the different keyboard bindings for all the different
     * actions.
     */
    public enum KEY_BIND
    {
        /** The keyboard key the is binded to the Hint Button */
        HINT,

        /** The keyboard key the is binded to the Pause Button */
        PAUSE,

        /** The keyboard key the is binded to the 3 More Button */
        THREE_MORE,

        /** The keyboard key that chooses the selected card */
        SELECT,

        /** The keyboard key that moves the selected card up */
        UP,

        /** The keyboard key that moves the selected card down */
        DOWN,

        /** The keyboard key that moves the selected card left */
        LEFT,

        /** The keyboard key that moves the selected card right */
        RIGHT,

        /**
         * The keyboard key that removes the card at inlay position 1 assuming
         * that there is a card there
         */
        REMOVE_INLAY_POS_ONE,

        /**
         * The keyboard key that removes the card at inlay position 2 assuming
         * that there is a card there
         */
        REMOVE_INLAY_POS_TWO,

        /** The keyboard key that buzzes in Player 1 */
        PLAYER1_BUZZ,

        /** The keyboard key that buzzes in Player 2 */
        PLAYER2_BUZZ,

        /** The keyboard key that buzzes in Player 3 */
        PLAYER3_BUZZ,

        /** The keyboard key that buzzes in Player 4 */
        PLAYER4_BUZZ,
    }

    /**
     * Constructs KeyBindings with previously saved key binds.
     */
    public KeyBindings() throws FileNotFoundException, NoSuchFieldException
    {
        KEY_BIND keyBinding;

        // IF file keyBindings.cvs doesn't exist in current directory
        // THROW FileNotFoundException with what file is missing and where
        // ELSE
        // OPEN file keyBindings.cvs for read
        // FOR each row in file
        // SET keyBinding to null
        // READ in row
        // GET word from file
        // FOR each keyBind in KEY_BIND
        // IF word equal keyBind's name
        // SET keyBinding for keyBind
        // END IF
        // END FOR
        // IF keyBinding is null
        // THROW NoSuchFieldException
        // END IF
        // GET word from file
        // CALL keyBindings' add with keyBind, word
        // END FOR
        // CLOSE file
        // END IF
    }

    /**
     * Gets a specific key binding for a specific action
     * 
     * @param keyBinding
     *            The keyboard binding for a specific action.
     * @return The string value representing the keyboard binding.
     */
    public String getKeyBinding(KEY_BIND keyBinding)
    {
        // RETURN keyBindins' get with keyBinding
        return null;
    }

    /**
     * Sets and persist all the key binding in KEY_BIND with their key
     * 
     * @param keyMap
     *            The HashMap of all the keyboard binding and there keys.
     */
    public void setKeyBindings(HashMap<KEY_BIND, String> keyMap)
    {
        // SET keyBindings to keyMap
        // IF file keyBindings.cvs doesn't exist in current directory
        // THROW FileNotFoundException with what file is missing and where
        // ELSE
        // OPEN file keyBindings.cvs for write
        // CLEAR file's contents

        // FOR each entry in keyMap's entrySet
        // GET KEY_BIND's name from entry's getKey
        // WRITE row with name and entry's getValue
        // END FOR

        // CLOSE file
        // END IF
    }
}
