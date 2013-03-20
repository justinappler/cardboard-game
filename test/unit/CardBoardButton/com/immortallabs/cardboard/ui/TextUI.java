package com.immortallabs.cardboard.ui;
import java.util.Scanner;

import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.game.Score;
import com.immortallabs.cardboard.game.SetsBoard;
import com.immortallabs.cardboard.game.Timer;
import com.immortallabs.cardboard.game.GameState.ACTION;
import com.immortallabs.cardboard.game.GameState.PLAYER;
import com.immortallabs.cardboard.game.SetsBoard.ROWS;

import edu.profdalbey.Natural;

/**
 *	<p>Displays the state of the CardBoard game through
 *	a console. It creates a 3x4 grid where each location
 *	has it's number and the characteristics of the card.
 *	There are another 3 slots for cards that have been selected</p>
 *
 *	<b>Operations:</b>
 *	<ul>
 *	<li>TextUI displays the game state in a console.</li>
 *	<li>TextUI can prompt the user for his or her name and return it.</li>
 *	</ul>
 *
 *	@author		Kyle Williamson
 *	@author		ImmortalLabs CSC308 W09
 *	@version	1.0
 *	@version	1/10/09
 **/

public class TextUI implements CardBoardUI
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
	
	/** Holds the selected card **/
	private Card selected;
	
	/** Holds the current  state of the game **/
	private GameState game;
	
	/** Reads from the input stream **/
	private Scanner input;
	
	/** number of possible columns in the game **/
	private final int cols = 3;
	
	/** Four rows currently on the board **/
	private final int fourRows = 4;
	
	/** Five rows currently on the board **/
	private final int fiveRows = 5;
	
	/** Six rows currently on the board **/
	private final int sixRows = 6;
	
	/** Seven rows currently on the board **/
	private final int sevenRows = 7;
	
	/**
	 *	Instantiates a new game window that will display
	 *	the state of the game held in logic.
	 *
	 *	@param	logic	the game to display
	 **/
	public TextUI(GameState logic)
	{

	}
	
	/**
	 *	Sets the selected card to the chosen card.
	 *
	 *  @param 	card	The card that has been selected
	 **/
	public void cardSelected(Card card)
	{

			
		
	}
	
	/**
	 * 	Returns the currently selected card.
	 * 
	 *  @return last card that was selected.
	 */
	@Override
	public Card getSelected()
	{
		return null;
	}
	
	/**
	 * 	Print out the expiration message
	 * 
	 * 	@param message	expiration message passed to TextUI
	 */
	@Override
	public void showExpirationPenalty(String message)
	{
	}
	
	/**
	 * 	Print out the explanation message
	 * 
	 * 	@param message	explanation message passed to TextUI
	 */
	@Override
	public void showExplanation(String message)
	{
	}
	
	/**
	 * 	Asks the user to type in a username.
	 * 
	 *  @return username that was chosen.
	 */
	@Override
	 public String getName()
	 {
		return null;
	 }
	 
	/**
	 * 	Creates a new game and calls an ACTION depending on input from the user
	 */
	 private void display()
	 {

	 }
	 
	 /**
	  * 	The options for starting a new game of CardBoard. Allows for
	  * 	solitaire mode and beginner mode.
	  */
	 private void preferences()
	 {

	 }
	 
	 /**
	  * 	Draws the text version of the Card Board game.
	  **/
	 private void draw()
	 {

	 }
	 
	 /**
	  * 	Print out all the options a user can input.
	  **/
	 private void options()
	 {

	 }
	
}


