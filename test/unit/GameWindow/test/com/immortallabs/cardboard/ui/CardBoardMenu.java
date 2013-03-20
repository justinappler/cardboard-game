package com.immortallabs.cardboard.ui;

import com.immortallabs.cardboard.ui.ActionMap.EVENT;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 * FAKE! From Release 1 file 
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
      
      //ADD "Exit" and EVENT.EXIT to "File" menu
      fileMenu.add(createMenuItem("Exit", EVENT.EXIT));
   }
      
   /**
    * Creates a radio menu item for a menu so only one menu item can be selected.
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
    * Creates a menu item for a menu
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
