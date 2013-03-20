package com.immortallabs.cardboard.ui;

import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.GameState;

/**
 * <p>
 * The CardBoardUI class is an interface that must implemented by all user
 * interfaces for the Cardboard Sets Game.
 * </p>
 * <b>Operations:</b>
 * <ul>
 * <li>A class that implements CardBoardUI can provide the user with the
 * Player's Name
 * <li>A class that implements CardBoardUI can provide the user with the
 * currently selected card.
 * </ul>
 * 
 * @author Justin C. Appler
 * @author Immortal Labs CSC309 W09
 * @version 1.2
 * @version January 12th, 2009
 * @history - 01/12/09 1.2 Moved the class to the new project<br>
 *          - 12/04/08 1.1 Added the getSelected and showExplanation method<br>
 *          - 12/01/08 1.0 Initial Class Skeleton<br>
 */
public interface CardBoardUI
{
    /**
     * Retrieves the name/handle of the current player from the User Interface.
     * 
     * @return The name or handle of the player who received the high score
     */
    String getName();

    /**
     * Gets the Card currently selected on the game board.
     * 
     * @return The Card currently selected on the game board.
     */
    Card getSelected();

    /**
     * Shows the user the explanation behind a correct or incorrect set.
     * 
     * @param explanation
     *            A string containing the explanation to display
     */
    void showExplanation(String explanation);

    /**
     * Shows the user a message regarding an action they've taken
     * 
     * @param message
     *          The message to be shown to the user
     */
    public void showMessage(String message);
    
    /**
     * Shows the user the timer expiration penalty message.
     * 
     * @param message
     *            A string containing the penalty message
     */
    void showExpirationPenalty(String message);
    

    /**
     * Displays the player that is currently buzzed in
     * @param player
     * 		The player that is currently buzzed in
     * 		null if no player is currently buzzed in
     */
    public void displayBuzzedPlayer(GameState.PLAYER player);
}
