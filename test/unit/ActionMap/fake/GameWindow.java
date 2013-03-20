package com.immortallabs.cardboard.ui;

import java.awt.Graphics;
import java.awt.Point;
import unit.ActionMap.ActionMapTestData;
import javax.swing.JFrame;
import javax.swing.JMenu;
import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.ui.GameWindow;
/**
 * --FAKE--
 *	<p>Displays the state of the CardBoard game in
 *	a single window.</p>
 *
 *	<b>Operations:</b>
 *	<ul>
 *	<li>GameWindow displays the game state in a window.</li>
 *	<li>GameWindow can return the current x,y coordinates of the open inlay slot.</li>
 *	<li>GameWindow can prompt the user for his or her name and return it.</li>
 *	</ul>
 *  @author 	Thomas Dvornik
 **/

public class GameWindow extends JFrame implements CardBoardUI
{
	/**
	 *	INLAY represents the different open
	 *	inlay positions.
	 **/
	public enum INLAY
	{
		/** Inlay spot one **/
		ONE,
		
		/** Inlay spot two **/
		TWO,
		
		/** Inlay spot three **/
		THREE;
	}
	
	/**
	 *	DIRECTION represents the different movement
	 *	directions for the selected card.
	 **/
	public enum DIRECTION
	{
		/** Move up **/
		UP,
		
		/** Move down **/
		DOWN,
		
		/** Move left **/
		LEFT,
		
		/** Move right **/
		RIGHT,
		
		HINTDIR;
	}
	
	/** the height of the window **/ 
	private final int kWindowHeight = 730; 
	
	/** the width of the window */
    private final int kWindowWidth = 780; 
	
	/** Holds the selected card **/
	private CardGraphic selected;
	
	/** reference of the GameState */
	private GameState state; 
	private ActionMap map;
	public CardBoardMenu menu;
	
	/** The Card Components currently displayed */ 
	private CardGraphic[][] cards; 
	
	/** The Card components currently in the inlay */ 
	private CardGraphic[] inlay; 
	
	/** Represents the x location of the inlay cards */ 
	private final int INLAY_X = 35; 
	
	/** Represents the y locations of the inlay cards */
	private final int[] INLAY_Y = {75,190,300}; 
	  
	/** Represents the x location of the buttons */ 
	private final int BUTTON_X = 25; 
	
	/** Represents the y locations of the buttons */
	private final int[] BUTTON_Y = {415,480,545,610}; 
	    
	public boolean hasMessage;
	/**
	 *	Instantiates a new game window that will display
	 *	the state of the game held in logic.
	 *
	 *	@param	logic	the game to display
	 **/
	public GameWindow(GameState state)
	{
		this.state = state;
		this.map = new ActionMap(state, this);
		menu = new CardBoardMenu(map);
		// CALL setUserInterface on Logic passing a copy of self
		// SET the instance of GameState to the passed in state 
		
		// CALL setSize with sizes of the GameWindow
	    
		// ADD a mouseListener with ActionMap 
	
		// CREATE a new CardBoardMenu
		// CALL setJMenuBar with CardBoardMenu 
		
		// CALL setVisible with true 
	}
	
	public void displayBuzzedPlayer(GameState.PLAYER player) {
	    
	}
	
	/**
	 *	Sets the selected card to the clicked card.
	 **/
	public void cardClicked(CardGraphic card)
	{
		// SET selected to the card
		ActionMapTestData.add("clicked");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		map.cardClicked(card);
		// IF the card is not in the inlay
			// ANIMATE the card to the openInlaySlot
		// ELSE
			// CALL cardClicked in ActionMap
	}
	
	/**
	 *	Moves the selected card in the specified direction
	 *
	 *	@param	dir		the direction to move
	 **/
	public void moveSelector(DIRECTION dir)
	{
		// SWITCH on the direction
			// CASE UP
				// Move the selected up
			// CASE DOWN
				// Move the selected down
			// CASE LEFT
				// Move the left
			// CASE RIGHT
				// Move the selected right
	}
	/**
	 * The object on which the Event initially occurred.
	 * @param x the x location where the mouse was pressed 
	 * @param y	the y location where the mouse was pressed 
	 * @return The object on which the Event initially occurred. 
	 */
	public Object getSource (int x, int y)
	{
		if (x < 10 && y < 10)
			return new CardGraphic(null, null, null, null, null);
		else
			return new CardBoardButton(null, null, CardBoardButton.BUTTONTYPE.PAUSE, "pause");
		
	}
	/**
	 * Checks to see if the mouse clicked on one of the inlay cards 
	 * @param x the x location where the mouse was pressed
	 * @param y the y location where the mouse was pressed
	 * @return an inlay card if the x and y is within the bounds of the card, otherwise NULL
	 */
	private Object checkInLay(int x, int y)
	{
			//IF the x and y is within the bounds of the first in lay card 
					//AND there is at least one card in the inlayTHEN
					//RETURN the first inlay card 
			//ELSE IF the x and y is within the bounds of the second in lay card
				   // AND there are at least two cards in the inlay THEN
				  //RETURN the second inlay card 
			//ELSE IF the x and y is within the bounds of the third in lay card
		   		  // AND there are at least three cards in the inlay THEN
				 //RETURN the third inlay card 
		   //ELSE 
				//RETURN NULL
		
		
		return null; 
	}
	/**
	 * Checks to see if the mouse clicked on a card 
	 * @param x the x location where the mouse was pressed
	 * @param y the y location where the mouse was pressed
	 * @return a card if the x and y is within the bounds of the card, otherwise NULL
	 */
	private Object checkCards(int x, int y)
	{
		//FOR each card currently displayer 
			// IF the x and y is within the bounds of the card THEN 
					//RETURN the card 
		// RETURN NULL 
		return null; 
	}
	/**
	 * Check to see if the mouse clicked on a button 
	 * @param x the x location where the mouse was pressed
	 * @param y the y location where the mouse was pressed
	 * @return a button if the x and y is within the bounds of the button, otherwise NULL
	 */
	private Object checkButtons(int x, int y)
	{
		//IF the x and y is within the bounds of the hint button THEN 
			//RETURN the hint button 
		//ELSE IF the x and y is within the bounds of the pause button THEN
			//RETURN the pause button 
		//ELSE IF the x and y is within the bounds of the three more button THEN 
			//RETURN the three more button 
		//ELSE IF the x and y is within the bounds of the explain button THEN
		    //RETURN the explain button 
		//ELSE
			//RETURN NULL; 
		return null; 
	}
	public void showExpirationPenalty(String message)
	{
		// CALL JOptionPane.showInputDialog with the message 
		// Display the JOptionPane 
	}
	public void showExplanation(String message)
	{
		// CALL JOptionPane.showInputDialog with the message 
		// Display the JOptionPane 
	}
	/**
	 *	Removes the last set displayed in the inlay.
	 **/
	public void clearLastSet()
	{
		// CALL paint to fresh the window with the inlays removed 
	}
	/**
	 *	Returns the current open inlay spot to place
	 *	a card.
	 *
	 *	@return		the point at which to place a card
	 *				in the inlay
	 **/
	 public Point getOpenInlaySpot()
	 {
	 	// FOR each index in the inlay 
		 	//IF index does not contain a card THEN
		 		//RETURN the point location corresponding to that index 
	 	return null;
	 }
	 
	 @Override
	 public String getName()
	 {
		// CREATE a string for the name
	    // CREATE a string with a prompt asking for aname 
	 	// CALL JOptionPane.showInputDialog with prompt and ASSIGN it to name 
	 	// RETURN the name
	 	return null;
	 }
	 
	 /**
	  *	Notifies GameWindow that the theme has changed.
	  **/
	 public void themeChanged()
	 {
	 	// LOAD the new background image
		// FOR each button in the display
			// NOTIFY the button of the new theme
	 }
	 /**
	  *	Displays the button of the given type in the game window.
	  *
	  *	@param	btn		the button type to display
	  **/
	 public void showButton(CardBoardButton.BUTTONTYPE btn)
	 {
	 	// CREATE a new button passing the type
	 	// ADD the button to the window
		 ActionMapTestData.add("show-" + btn);
	 }
	 /**
	  *	Removes the button of the given type from the game window.
	  *
	  *	@param	btn		the button type to remove
	  **/
	 public void removeButton(CardBoardButton.BUTTONTYPE btn)
	 {
		 ActionMapTestData.add("remove-" + btn);
	 	// FOR each button in the display
	 		// IF the button type matches
	 			// REMOVE the button from the display
	 }

	 @Override
	 public void repaint()
	 {
		 ActionMapTestData.add("repaint");
	 }
	 @Override
	 public void update(Graphics g)
	 {
	 	// CALL paint with g
	 }
	 
	 @Override
	 public void paint(Graphics g)
	 {
		 //CALL paintBackground with g
	 	 //CALL paintInLayCards with g
		 //CALL paintCards with g
		 //CALL paintButtons with g
		 //CALL paintScore with g
		 //CALL paintTimer with g
	 }
	 /**
	  * Paints all cards currently in the inlay 
	  * @param g the graphics component to paint the cards to. 
	  */
	 private void paintInLayCards(Graphics g)
	 { 
		 //CREATE setsBoard 
		 //CALL gameState.getBoard() and ASSIGN to setsBoard 
		 //FOR each Card in the lay 
		 	// ASSIGN tempCard to the card 
		 	// CREATE a new CardGraphic with tempCard 
		 	// ADD the CardGraphic to the inylayCards 
		 	// PAINT the CardGraphic 		 
	 }
	 /**
	  * Paints the background to the screen 
	  * @param g the graphics component to paint the cards to. 
	  */
	 private void paintBackground(Graphics g)
	 { 
		 //CONSTRUCT TRY 
		    //CREATE a new BufferedImage img 
		    //CALL ImageIO.read with background image file name and ASSIGN to img
		    //CALL g.drawImage with img, background's x location, backgrounds's y location, null 
	 }

	 /**
	  * Paints all the cards to the screen
	  * @param g the graphics component to paint the cards to. 
	  */
	 private void paintCards(Graphics g)
	 { 
		 //CREATE setsBoard 
		 //CALL gameState.getBoard() and ASSIGN to setsBoard 
		 //FOR each row in the setsBoard
		 	//FOR each col in the setsBoard 
		          //CALL setsBoard.getCardFromBoard with row and col
		 		  //CONSTRUCT a CardGraphic with card 
		 		  //ADD the CardGraphic to cards 
		 		  //PAINT the CardGraphic 
	 }
	 /**
	  * Paints all buttons to the screen
	  * @param g the graphics component to paint the cards to. 
	  */
	 private void paintButtons(Graphics g)
	 { 
		 //CONSTRUCT a hint CardBoardButton with 
		 	    //NEW Point to be hint's x location, hint's y location 
		 		//the game's actionmap
		 		//Button.BUTTONTYPE.HINT  
		 		//"Hint" as the string 
		 
		 //CONSTRUCT a pause CardBoardButton with 
	 	    //NEW Point to be pause's x location, pause's y location 
	 		//the game's actionmap
	 		//Button.BUTTONTYPE.PAUSE  
	 		//"Hint" as the string
		 
		 //CONSTRUCT a threeMore CardBoardButton with 
	 	    //NEW Point to be threeMore's x location, threeMore's y location 
	 		//the game's actionmap
	 		//Button.BUTTONTYPE.THREEMORE  
	 		//"Hint" as the string 
		 
		 //CONSTRUCT a explain CardBoardButton with 
	 	    //NEW Point to be explain's x location, explain's y location 
	 		//the game's actionmap
	 		//Button.BUTTONTYPE.EXPLAIN  
	 		//"Hint" as the string 
		 
		 //PAINT hint 
		 //PAINT pause
		 //PAINT threeMore
		 //PAINT explain 
	 }
	 /**
	  * Paints the timer graphic to the screen
	  * @param g the graphics component to paint the cards to. 
	  */
	 private void paintTimer(Graphics g)
	 { 
		 //CREATE timer TimerGraphic with 
		 		//CREATE Point to be timer's x location, timer's y location 
		 		//CALL gameState.getTimer() 
		 //PAINT timer 
	 }
	 /**
	  * Paints the score graphic to the screen
	  * @param g the graphics component to paint the cards to. 
	  */
	 private void paintScore(Graphics g)
	 { 
		 //CREATE score ScoreGraphic with 
		 		//CREATE Point to be timer's x location, timer's y location 
		 		//CALL gameState.getScore with gametState.PLAYER.PLAYER1
		 		//CALL gameState.getScore with gameState.PLAYER.PLAYER2
		 		//CALL gameState.getScore with gameState.PLAYER.PLAYER3
		 		//CALL gameState.getScore with gameState.PLAYER.PLAYER4
		 //PAINT score 
	 }
	/**
	 * Returns the currently selected card; 
	 * @return returns the currently selected card
	 */
	public Card getSelected() {
		//RETURN selectedCard 
		return null;
	}

	public ActionMap getAM() {
		return map;
	}
	
	public void showPage(String URL) {
	    
	}
	
	public CardGraphic getSelectedCardGraphic() {
	    return null;
	}
	 
}