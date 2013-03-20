package com.immortallabs.cardboard.ui;

import com.immortallabs.cardboard.game.Card;

/**
 * --FAKE--
 * <p>The CardBoardUI class is an interface that must implemented by all
 * user interfaces for the Cardboard Sets Game.</p>
 * <b>Operations:</b>
 * <ul>
 * <li>A class that implements CardBoardUI can provide the user with the
 *    Player's Name
 * <li>A class that implements CardBoardUI can provide the user with the
 *    currently selected card.
 * </ul>
 * @author Thomas Dvornik
 */
public interface CardBoardUI
{
	/**
	 * Retrieves the name/handle of the current player from the User Interface.
	 * 
	 * @return The name or handle of the player who received the high score
	 */
	public String getName();
	
	/**
	 * Gets the Card currently selected on the game board.
	 * 
	 * @return The Card currently selected on the game board.
	 */
	public Card getSelected();
	
	/**
	 * Shows the user the explanation behind a correct or incorrect set.
	 * 
	 * @param explanation A string containing the explanation to display
	 */
	public void showExplanation(String explanation);
	
	/**
	 * Shows the user the timer expiration penalty message.
	 * 
	 * @param message A string containing the penalty message
	 */
	public void showExpirationPenalty(String message);
	
}
