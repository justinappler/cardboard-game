package com.immortallabs.cardboard.game;

/**
 * <p>
 * The CardBoardMessage class models any of the various messages displayed to
 * the user.  While each message type has default text, the messages can be
 * changed to suit the specific situation.
 * </p>
 * <b>Operations:</b>
 * <ul>
 * <li>The CardBoardMessage class change the text of the message
 * <li>The CardBoardMessage class can provide the English text of a message
 * </ul>
 * 
 * @author Justin C. Appler
 * @author Immortal Labs, CSC309 W09
 * @version 1.0
 * @version March 8th, 2009
 * @see GameState
 * @see GameWindow
 * @history - 03/08/09 1.0 Initial Class Design & Implementation<br>
 */
public enum CardBoardMessage
{
    /** The message displayed when a set is found */
    CORRECT_SET("You found a set!"),
    
    /** The message displayed when an invalid set is found */
    INVALID_SET("Not a valid set!"),
    
    /** The message displayed when the timer expires */
    TIMER_EXPIRATION("You ran out of time."),

    /** The message displayed when there is no set on the board */
    NO_SET_ON_BOARD("There is no set on the board."),

    /** The message displayed when the game has been won */
    GAME_WON("You won the game!"),

    /**  The message displayed when a hint cannot be used */
    CANNOT_USE_HINT("You cannot use a hint after selecting a card."),
    
    /** 
     * The message displayed when 3 more is selected 
     * and there is a set on the board.
     */
    THREE_MORE_WHILE_SET("There is still a set on the board!"),

    /** The message displayed when a hint is attempted in competitive */
    NO_HINT_IN_COMPETITIVE("You cannot use a hint in competitive mode!"),
    
    /** 
     * The message displayed a card is clicked in multiplayer while
     * no player is currently buzzed in
     */
    MUST_BUZZ_IN("Someone must buzz in first!"),
    
    /**
     * The message shown when the user requests a valid or invalid set
     * explanation.
     */
    EXPLANATION("");
    
    /** The text of the message */
    String text = null;
    
    /**
     * Constructs a cardboard message using the passed text
     * @param text The text of the message
     */
    CardBoardMessage(String text)
    {
        // SET the passed text to the message's text
        this.text = text;
    }
    
    /**
     * Sets the text of the message
     * @param text The text of the message
     */
    public void setText(String text)
    {
        // SET the message text to the passed text
        this.text = text;
    }
    
    /**
     * Gets the text of the message
     * @return The text of the message
     */
    public String getText()
    {
        // RETURN the message text
        return text;
    }
}
