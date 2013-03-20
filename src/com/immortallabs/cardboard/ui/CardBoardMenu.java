package com.immortallabs.cardboard.ui;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import com.immortallabs.cardboard.CardBoardPreferences;
import com.immortallabs.cardboard.CardBoardPreferences.PREF;
import com.immortallabs.cardboard.ui.ActionMap.EVENT;

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
    *       <li>Beginner Game</li>
    *       <li>Single Player Game</li>
    *       <li>Competitive Game</li>
    *       <li>Multiplayer Game</li>
    *          <li>1 Player</li>
    *           <li>2 Players</li>
    *           <li>3 Players</li>
    *           <li>4 Players</li>
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
    *          <li>Sound On/Off</li>
    *       </ul>
    * <li>Help</li>
    *       <ul>
    *       <li>About CardBoard</li>
    *       <li>How to play CardBoard</li>
    *       <li>Key Bindings:</li>
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
      fileMenu.setMnemonic(KeyEvent.VK_F);
      mMenuBar.add(fileMenu);
      
      //------ New Game Menu ------
      //ADD "New Game" menu to "File" menu
      JMenu newGameMenu = new JMenu("New Game");
      fileMenu.add(newGameMenu);
      
      //ADD createMenuItem with "Beginner" and EVENT's BEGINNER_GAME 
      // to "New Game" menu
      JMenuItem beginner = createMenuItem("Beginner", EVENT.BEGINNER_GAME);
      beginner.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, 
                                                     InputEvent.ALT_MASK));
      newGameMenu.add(beginner);
      
      //ADD createMenuItem with "Solitaire" and EVENT's SINGLEPLAYER_GAME 
      // to "New Game" menu
      JMenuItem solitaire = createMenuItem("Solitaire", EVENT.SINGLEPLAYER_GAME);
      solitaire.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 
                                                     InputEvent.ALT_MASK));
      newGameMenu.add(solitaire);
      
      
      //ADD createMenuItem with "Competitive" and EVENT's COMPETITIVE_GAME 
      // to "New Game" menu
      JMenuItem competitive = createMenuItem("Competitive", 
                                             EVENT.COMPETITIVE_GAME);
      competitive.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, 
                                                        InputEvent.ALT_MASK));
      newGameMenu.add(competitive);
      
      //ADD Menu with "Multiplayer" to "New Game" menu
      JMenu multiplayer = new JMenu("Multiplayer");
      addPlayerRadioMenuItems("ONE", multiplayer);      
      newGameMenu.add(multiplayer);
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
      
      // CREATE checkbox menu item.
      JCheckBoxMenuItem sound = new JCheckBoxMenuItem("Sound On/Off", true);
      sound.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, 
                                                  InputEvent.ALT_MASK));
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
      JMenuItem about = createMenuItem("About CardBoard", EVENT.ABOUT);
      about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                                                 InputEvent.ALT_MASK));
      helpMenu.add(about);
      
      //------- How To Play Menu -------
      //ADD createMenuItem with "How to play CardBoard" and EVENT.HOW_TO to 
      // "Help" menu
      JMenuItem how = createMenuItem("How to play CardBoard", EVENT.HOW_TO);
      how.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 
                                                InputEvent.ALT_MASK));
      helpMenu.add(how);
       
      JMenuItem key = createMenuItem("Key Binds", EVENT.KEY_BINDS);
      key.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, 
                                                InputEvent.ALT_MASK));
      helpMenu.add(key);
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
     
      //CREATE createRadioMenuItem with "2 Players" and EVENT's TWO
      JMenuItem twoPlayer = createRadioMenuItem("2 Player", EVENT.TWO);
      twoPlayer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
                                                      InputEvent.ALT_MASK));

      
      //CREATE createRadioMenuItem with "3 Players" and EVENT's THREE
      JMenuItem threePlayer = createRadioMenuItem("3 Player", EVENT.THREE);
      threePlayer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, 
                                                        InputEvent.ALT_MASK));
      
      //CREATE createRadioMenuItem with "4 Players" and EVENT's FOUR
      JMenuItem fourPlayer = createRadioMenuItem("4 Player", EVENT.FOUR);
      fourPlayer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,
                                                      InputEvent.ALT_MASK));
      
      //LINK the menu items together so that only one can be selected.
      ButtonGroup playerGroup = new ButtonGroup();
      
      //ADD createRadioMenuItem with "2 Players" and EVENT's TWO to 
      // group
      playerGroup.add(twoPlayer);
      
      //ADD createRadioMenuItem with "3 Players" and EVENT's THREE to 
      // group
      playerGroup.add(threePlayer);
      
      //ADD createRadioMenuItem with "4 Players" and EVENT's FOUR to 
      // group
      playerGroup.add(fourPlayer);     
      
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
      twoPlayer.setSelected(true);
     
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
      fifteen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                                                    InputEvent.ALT_MASK));
      
      //CREATE createRadioMenuItem with "30 Seconds" and EVENT's TIME_30SEC
      JMenuItem thirty = createRadioMenuItem("30 Seconds", EVENT.TIME_30SEC);
      thirty.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                                                   InputEvent.ALT_MASK));
      
      //CREATE createRadioMenuItem with "45 Seconds" and EVENT's TIME_45SEC
      JMenuItem fourtyfive = createRadioMenuItem("45 Seconds", EVENT.TIME_45SEC);
      fourtyfive.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
                                                       InputEvent.ALT_MASK));
      
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
            
      //ADD createRadioMenuItem with "15 Seconds" and EVENT's TIME_15SEC to 
      // "Time Limit" menu
      timeLimitMenu.add(fifteen);
      
      //ADD createRadioMenuItem with "30 Seconds" and EVENT's TIME_30SEC to 
      // "Time Limit" menu
      timeLimitMenu.add(thirty);
      
      //ADD createRadioMenuItem with "45 Seconds" and EVENT's TIME_45SEC to
      // "Time Limit" menu
      timeLimitMenu.add(fourtyfive);
      
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

