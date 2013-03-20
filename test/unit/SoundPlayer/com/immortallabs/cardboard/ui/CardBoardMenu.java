package com.immortallabs.cardboard.ui;

import com.immortallabs.cardboard.CardBoardPreferences;
import com.immortallabs.cardboard.CardBoardPreferences.PREF;
import com.immortallabs.cardboard.ui.ActionMap.EVENT;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
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
 * @version 1.6
 * @version 2/26/09
 * @see ActionMap
 *
 * @history  
 *  - 12/04/08 Version 1.1 Changed package. 
 *  - 12/04/08 Version 1.2 Finished psuedocode for main methods. Have to 
 *    research methods that I have to override, if any at all.
 *  - 12/05/08 Version 1.3 Added missing menu items. Added radio buttons.
 *    fixed javaDocs
 *  - 01/19/09 Version 1.4 Fixed pseudocode, coded R1 version.
 *  - 02-02-09 Version 1.5 Removed R2 code.
 *  - 02-26-09 Version 1.6 Corrected R2 code.
 *  - 03-06-09 Version 1.7 Fixed defects 169, 171, 174
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
    *       <li>Beginner Game</li>
    *       <li>Competitive Game</li>
    *       <li>Multiplayer Game</li>
    *       </ul>
    *    </ul>
    * <li>Options</li>
    *       <ul>
    *       <li>Preferences</li>
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
    *          <li>Sound On/Off</li>
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
      CardBoardPreferences prefs = CardBoardPreferences.getInstance();
      
      //SET this.actionMap to actionMap
      this.actionMap = actionMap;
      
      //CREATE new menu bar
      mMenuBar = new JMenuBar();
      
      //---------- File Menu ----------
      //ADD "File" menu to menu bar
      JMenu fileMenu = new JMenu("File");
      mMenuBar.add(fileMenu);
      
      //------ New Game Menu ------
      //ADD "New Game" menu to "File" menu
      JMenu newGameMenu = new JMenu("New Game");
      fileMenu.add(newGameMenu);
      
      //ADD createMenuItem with "Solitaire" and EVENT's SINGLEPLAYER_GAME 
      // to "New Game" menu
      newGameMenu.add(createMenuItem("Solitaire", EVENT.SINGLEPLAYER_GAME));
      
      //ADD createMenuItem with "Beginner" and EVENT's BEGINNER_GAME 
      // to "New Game" menu
      newGameMenu.add(createMenuItem("Beginner", EVENT.BEGINNER_GAME));
      
      //ADD createMenuItem with "Competitive" and EVENT's COMPETITIVE_GAME 
      // to "New Game" menu
      newGameMenu.add(createMenuItem("Competitive", EVENT.COMPETITIVE_GAME));
      
      //ADD createMenuItem with "Multiplayer" and EVENT's MULTIPLAYER_GAME 
      // to "New Game" menu
      newGameMenu.add(createMenuItem("Multiplayer", EVENT.MULTIPLAYER_GAME));
      
      //---------- Options Menu ----------
      //ADD "Options" menu to menu bar
      JMenu optionsMenu = new JMenu("Options");
      mMenuBar.add(optionsMenu);
      
      //------ Preferences Menu ------
      //ADD "Preferences" menu to "Options" menu
      JMenu preferencesMenu = new JMenu("Preferences");
      optionsMenu.add(preferencesMenu);
      
      //--- Time Limit Menu ---
      //ADD "Time Limit" menu to "Options" menu
      JMenu timeLimitMenu = new JMenu("Time Limit");
      preferencesMenu.add(timeLimitMenu);     
      
      //SET "Time Limit" menu's selected to Logic's Preference's getPreference 
      // with PREF's TIME_LIMIT
      addRadioMenuItems(prefs.getPreference(PREF.TIME_LIMIT), timeLimitMenu);        
      
      //--- Players Menu ---
      //ADD "Players" menu to "Options" menu
      JMenu playerMenu = new JMenu("Players");
      preferencesMenu.add(playerMenu);
      
      //SET "Players" menu's selected to Logic's Preference's getPreference 
      // with PREF's PLAYERS
      addPlayerRadioMenuItems(prefs.getPreference(PREF.PLAYERS), playerMenu);
      
      // CREATE checkbox menu item.
      JCheckBoxMenuItem sound = new JCheckBoxMenuItem("Sound On/Off");
      //CALL MenuItems item's addActionListener with actionMap
      sound.addActionListener(actionMap);
      
      //SET menuItem's action command to interEvent's name
      sound.setActionCommand("SOUND_TOGGLE");
      
      preferencesMenu.add(sound);
      
      //---------- Help Menu ----------
      //ADD "Help" menu to the menu bar
      JMenu helpMenu = new JMenu("Help");
      
      //------- About CardBoard Menu -------
      //ADD createMenuItem with "About CardBoard" and EVENT.ABOUT to "Help" 
      // menu
      helpMenu.add(createMenuItem("About CardBoard", EVENT.ABOUT));
      
      //------- How To Play Menu -------
      //ADD createMenuItem with "How to play CardBoard" and EVENT.HOW_TO to 
      // "Help" menu
      helpMenu.add(createMenuItem("How to play CardBoard", EVENT.HOW_TO));
      
      // ADD "Help" menu to the menu bar.
      mMenuBar.add(helpMenu);
   }

   /**
    * Creates the radio menu items for the number of players in the game and
    * adds them to the menu of players.
    * @param selected the default menu item to be selected at the start of the game.
    * @param playerMenu the menu to be added to.
    */   
   private void addPlayerRadioMenuItems(String selected, JMenu playerMenu)
   {
		// Fixed defect 169,171,174 below
      //CREATE createRadioMenuItem with "1 Player" and EVENT's ONE
      JMenuItem onePlayer = createRadioMenuItem("1 Player", EVENT.ONE);
      
      //CREATE createRadioMenuItem with "2 Players" and EVENT's TWO
      JMenuItem twoPlayer = createRadioMenuItem("2 Player", EVENT.TWO);
      
      //CREATE createRadioMenuItem with "3 Players" and EVENT's THREE
      JMenuItem threePlayer = createRadioMenuItem("3 Player", EVENT.THREE);
      
      //CREATE createRadioMenuItem with "4 Players" and EVENT's FOUR
      JMenuItem fourPlayer = createRadioMenuItem("4 Player", EVENT.FOUR);
      
      //LINK the menu items together so that only one can be selected.
      ButtonGroup playerGroup = new ButtonGroup();
      
      //ADD createRadioMenuItem with "1 Player" and EVENT's ONE to 
      // group
      playerGroup.add(onePlayer);
      
      //ADD createRadioMenuItem with "2 Players" and EVENT's TWO to 
      // group
      playerGroup.add(twoPlayer);
      
      //ADD createRadioMenuItem with "3 Players" and EVENT's THREE to 
      // group
      playerGroup.add(threePlayer);
      
      //ADD createRadioMenuItem with "4 Players" and EVENT's FOUR to 
      // group
      playerGroup.add(fourPlayer);     
      
      //ADD createRadioMenuItem with "1 Player" and EVENT's ONE to 
      // "Players" menu
      playerMenu.add(onePlayer);
      
      //ADD createRadioMenuItem with "2 Players" and EVENT's TWO to 
      // "Players" menu
      playerMenu.add(twoPlayer);
      
      //ADD createRadioMenuItem with "3 Players" and EVENT's THREE to 
      // "Players" menu
      playerMenu.add(threePlayer);
      
      //ADD createRadioMenuItem with "4 Players" and EVENT's FOUR to 
      // "Players" menu
      playerMenu.add(fourPlayer);

      // SET one player radio menu item to be selected (Defect 174 fixed here).
      onePlayer.setSelected(true);
     
   }

   /**
    * Creates the radio menu items for the amount of time in the competitive game and
    * adds them to the menu of time limits.
    * @param selected the default menu item to be selected at the start of the game.
    * @param timeLimitMenu the menu to be added to.
    */   
   private void addRadioMenuItems(String selected, JMenu timeLimitMenu)
   {
      //CREATE createRadioMenuItem with "15 Seconds" and EVENT's TIME_15SEC
      JMenuItem fifteen = createRadioMenuItem("15 Seconds", EVENT.TIME_15SEC);
      
      //CREATE createRadioMenuItem with "30 Seconds" and EVENT's TIME_30SEC
      JMenuItem thirty = createRadioMenuItem("30 Seconds", EVENT.TIME_30SEC);
      
      //CREATE createRadioMenuItem with "45 Seconds" and EVENT's TIME_45SEC
      JMenuItem fourtyfive = createRadioMenuItem("45 Seconds", EVENT.TIME_45SEC);
      
      //CREATE createRadioMenuItem with "Unlimited" and EVENT's TIME_UNLIMITED
      JMenuItem unlimited = createRadioMenuItem("Unlimited", EVENT.TIME_UNLIMITED);
      
      //LINK the menu items together so that only one can be selected.
      ButtonGroup timeGroup = new ButtonGroup();
      
      //ADD createRadioMenuItem with "15 Seconds" and EVENT's TIME_15SEC to 
      // group
      timeGroup.add(fifteen);
      
      //ADD createRadioMenuItem with "30 Seconds" and EVENT's TIME_30SEC to 
      // group
      timeGroup.add(thirty);
      
      //ADD createRadioMenuItem with "45 Seconds" and EVENT's TIME_45SEC to 
      // group
      timeGroup.add(fourtyfive);
      
      //ADD createRadioMenuItem with "Unlimited" and EVENT's TIME_UNLIMITED
      // group
      timeGroup.add(unlimited);     
      
      //ADD createRadioMenuItem with "15 Seconds" and EVENT's TIME_15SEC to 
      // "Time Limit" menu
      timeLimitMenu.add(fifteen);
      
      //ADD createRadioMenuItem with "30 Seconds" and EVENT's TIME_30SEC to 
      // "Time Limit" menu
      timeLimitMenu.add(thirty);
      
      //ADD createRadioMenuItem with "45 Seconds" and EVENT's TIME_45SEC to
      // "Time Limit" menu
      timeLimitMenu.add(fourtyfive);
      
      //ADD createRadioMenuItem with "Unlimited" and EVENT's TIME_UNLIMITED 
      // to "Time Limit" menu
      timeLimitMenu.add(unlimited);

      // SET fifteen second radio menu item to be selected. Fixed defect 174 here.
      fifteen.setSelected(true);
   }
      
   /**
    * Creates a radio menu item for a menu.
    * @param itemName the name of the item to add
    * @param interEvent the event to occur when the item is clicked
    * @return Created MenuItem
    */   
   private JMenuItem createRadioMenuItem(String itemName, EVENT interEvent)
   {
      //CREATE JRadioButtonMenuItem with itemName
      JRadioButtonMenuItem newItem = new JRadioButtonMenuItem(itemName);
      //CALL MenuItems item's addActionListener with actionMap
      newItem.addActionListener(actionMap);
      
      //SET menuItem's action command to interEvent's name
      newItem.setActionCommand(interEvent.toString());
      
      //RETURN menu item
      return newItem;
   }
   
   /**
    * Creates a menu item for a menu.
    * @param itemName the name of the item to add
    * @param interEvent the event to occur when the item is clicked
    * @return Created MenuItem
    */
   private JMenuItem createMenuItem(String itemName, EVENT interEvent) 
   {
      //CREATE MenuItem with itemName
      JMenuItem newItem = new JMenuItem(itemName);
      //CALL MenuItems item's addActionListener with actionMap
      newItem.addActionListener(actionMap);
      //SET menuItem's action command to interEvent's name
      newItem.setActionCommand(interEvent.toString());
      //RETURN menu item
      return newItem;
   }
   
   /**
    * Returns the constructed menu bar.
    * @return the constructed menu bar
    */
   public JMenuBar getMenuBar()
   {
      return mMenuBar;
   }
}
