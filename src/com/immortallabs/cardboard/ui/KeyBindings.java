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
 * </ul>
 * 
 * @author Nikhil Kowshik
 * @author Immortal Labs CSC309 W09
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
   /**
    * Key for using a hint: 'H' key on the keyboard
    */
   private static final String kKeyHint = "72";

   /**
    * Key for pausing the game: 'P' key on the keyboard
    */
   private static final String kKeyPause = "80";

   /**
    * Key for pausing the game: 'R' key on the keyboard
    */
   private static final String kKeyUnpause = "82";

   /**
    * Key for asking for three more cards: 'T' key on the keyboard
    */
   private static final String kKeyThreeMore = "84";

   /**
    * Key for moving a card from the table to the inlay: ENTER key on the
    * keyboard
    */
   private static final String kKeySelect = "10";

   /**
    * Key for moving the selected card up: UP arrow key on the keyboard
    */
   private static final String kKeyUp = "38";

   /**
    * Key for moving the selected card down: DOWN arrow key on the keyboard
    */
   private static final String kKeyDown = "40";

   /**
    * Key for moving the selected card left: LEFT arrow key on the keyboard
    */
   private static final String kKeyLeft = "37";

   /**
    * Key for moving the selected card right: RIGHT arrow key on the keyboard
    */
   private static final String kKeyRight = "39";

   /**
    * Key for moving the first card in the inlay back to the table: '1' key on
    * the keyboard
    */
   private static final String kKeyRemoveInlayOne = "49";

   /**
    * Key for moving the second card in the inlay back to the table: '2' key on
    * the keyboard
    */
   private static final String kKeyRemoveInlayTwo = "50";

   /**
    * Key for player one to buzz in: LEFT SHIFT key on the keyboard
    */
   private static final String kKeyBuzzOne = "16";

   /**
    * Key for player two to buzz in: SPACE key on the keyboard
    */
   private static final String kKeyBuzzTwo = "32";

   /**
    * Key for player three to buzz in: RIGHT CONTROL key on the keyboard
    */
   private static final String kKeyBuzzThree = "17";

   /**
    * Key for player four to buzz in: NUMPAD 0 key on the keyboard
    */
   private static final String kKeyBuzzFour = "47";

   /**
    * Holds all the key bindings with their current values.
    */
   private HashMap<KEY_BIND, String> keyBindings;

   /**
    * KEY_BIND models all the different keyboard bindings for all the different
    * actions.
    */
   public enum KEY_BIND
   {
      /** The keyboard key that is binded to the Hint Button */
      HINT,

      /** The keyboard key that is binded to the Pause Button */
      PAUSE,

      /** The keyboard key that unpauses the game; it is the same key as pause */
      UNPAUSE,

      /** The keyboard key that is binded to the 3 More Button */
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
   public KeyBindings()
   {
      // CREATE a new HashMap and set it to keyBindings
      keyBindings = new HashMap<KEY_BIND, String>();

      // ADD the hint key to keyBindings
      keyBindings.put(KEY_BIND.HINT, kKeyHint);

      // ADD the pause key to keyBindings
      keyBindings.put(KEY_BIND.PAUSE, kKeyPause);

      // ADD the unpause key to keyBindings; it is the same key as pause
      keyBindings.put(KEY_BIND.UNPAUSE, kKeyUnpause);

      // ADD the three more key to keyBindings
      keyBindings.put(KEY_BIND.THREE_MORE, kKeyThreeMore);

      // ADD the select key to keyBindings
      keyBindings.put(KEY_BIND.SELECT, kKeySelect);

      // ADD the up key to keyBindings
      keyBindings.put(KEY_BIND.UP, kKeyUp);

      // ADD the down key to keyBindings
      keyBindings.put(KEY_BIND.DOWN, kKeyDown);

      // ADD the left key to keyBindings
      keyBindings.put(KEY_BIND.LEFT, kKeyLeft);

      // ADD the right key to keyBindings
      keyBindings.put(KEY_BIND.RIGHT, kKeyRight);

      // ADD the remove inlay key one to keyBindings
      keyBindings.put(KEY_BIND.REMOVE_INLAY_POS_ONE, kKeyRemoveInlayOne);

      // ADD the remove inlay key two to keyBindings
      keyBindings.put(KEY_BIND.REMOVE_INLAY_POS_TWO, kKeyRemoveInlayTwo);

      // ADD the player one buzz key to keyBindings
      keyBindings.put(KEY_BIND.PLAYER1_BUZZ, kKeyBuzzOne);

      // ADD the player two buzz key to keyBindings
      keyBindings.put(KEY_BIND.PLAYER2_BUZZ, kKeyBuzzTwo);

      // ADD the player three buzz key to keyBindings
      keyBindings.put(KEY_BIND.PLAYER3_BUZZ, kKeyBuzzThree);

      // ADD the player four buzz key to keyBindings
      keyBindings.put(KEY_BIND.PLAYER4_BUZZ, kKeyBuzzFour);
   }

   /**
    * Gets a specific key binding for a specific action
    * 
    * @param keyBinding
    *           The keyboard binding for a specific action.
    * @return The string value representing the keyboard binding.
    */
   public String getKeyBinding(KEY_BIND keyBinding)
   {
      // RETURN keyBindins' get with keyBinding
      return (String) keyBindings.get(keyBinding);
   }

   /**
    * Sets and persist all the key binding in KEY_BIND with their key
    * 
    * @param keyMap
    *           The HashMap of all the keyboard binding and there keys.
    */
   public void setKeyBindings(HashMap<KEY_BIND, String> keyMap)
   {
      // SET the keyBindings to keyMap
      keyBindings = keyMap;
   }
}
