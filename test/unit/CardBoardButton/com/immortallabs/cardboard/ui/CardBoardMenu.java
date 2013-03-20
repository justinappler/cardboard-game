package com.immortallabs.cardboard.ui;

import com.immortallabs.cardboard.CardBoardPreferences;
import com.immortallabs.cardboard.ui.ActionMap.EVENT;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 * <p>The CardBoardMenu class models a Menu for the GameWindow. It will have
 * all the options to run the CardBoard game. These options include starting 
 * a new game, changing preferences, changing key bindings, and exiting the 
 * game.</p>
 * 
 * @author Michael Brooks
 * @author ImmortalLabs CSC 309 W'09
 * @author Formerly Thomas Dvornik
 * @author Formerly RustyNail CSC308 F08
 * @version 1.4
 * @version 1/21/09
 * @see ActionMap
 *
 * @history  
 *  - 12/04/08 Version 1.1 Changed package. 
 *  - 12/04/08 Version 1.2 Finished psuedocode for main methods. Have to 
 *    research methods that I have to override, if any at all.
 *  - 12/05/08 Version 1.3 Addied missing menu items. Added radio buttons.
 *    fixed javaDocs
 *  - 01/19/09 Version 1.4 Fixed pseudocode, coded R1 version.
 */
public class CardBoardMenu 
{
   /** Current game ActionMap */
   private ActionMap actionMap;
   
   /** The CardBoardMenu bar that goes on the top of GameWindow */
   private JMenuBar mMenuBar;
   
   /**
    * Instantiates a Menu with the following menu options,
    * <ul>
    * <li>File</li>
    *       <ul>
    *       <li>New Game</li>
    *       <ul>
    *       <li>Single Player Game</li>
    *       <li>Competitive Game</li>
    *       <li>Multiplayer Game</li>
    *       </ul>
    *    <li>Exit</li>
    *    </ul>
    * <li>Options</li>
    *       <ul>
    *       <li>Preferences</li>
    *          <li>Theme</li>
    *             <li>Simple</li>
    *             <li>Desert</li>
    *             <li>Coral</li>
    *          <li>Time Limit</li>
    *             <li>15 Seconds</li>
    *             <li>30 Seconds</li>
    *             <li>45 Seconds</li>
    *             <li>Unlimited</li>
    *          <li>Players</li>
    *             <li>1 Player</li>
    *             <li>2 Players</li>
    *             <li>3 Players</li>
    *             <li>4 Players</li>
    *       <li>Key Bindings</li>
    *       </ul>
    * <li>Help</li>
    *       <ul>
    *       <li>About CardBoard</li>
    *       <li>How to play CardBoard</li>
    *       </ul>
    * </ul>
    * @param actionMap ActionMap to link up menu items with events
    */
   public CardBoardMenu(ActionMap actionMap)
   {
      
   }
   
   private void addRadioMenuItems(String selected, JMenu timeLimitMenu)
   {
   
   }
   
   /**
    * Creates a radio menu item for a menu so only one menu item can be selected.
    * @param itemName the name of the item to add
    * @param interEvent the event to occur when the item is clicked
    * @return Created MenuItem
    */   
   private JMenuItem createRadioMenuItem(String itemName, EVENT interEvent)
   {
      return null;
   }
   
   /**
    * Creates a menu item for a menu
    * @param itemName the name of the item to add
    * @param interEvent the event to occur when the item is clicked
    * @return Created MenuItem
    */
   private JMenuItem createMenuItem(String itemName, EVENT interEvent) 
   {
      return null;
   }
   
   /**
    * Returns the constructed menu bar.
    * @return the constructed menu bar
    */
   public JMenuBar getMenuBar()
   {
      return null;
   }
}
