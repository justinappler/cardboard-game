package com.immortallabs.cardboard.game;

import java.util.ArrayList;

import edu.profdalbey.Natural;

/**
 * <p>The SetsBoard class models the state of the game board by
 * keeping track of what Cards are in the in-lay and what Cards 
 * are on the game board. Also the SetsBoard class determines 
 * what is a set and can return information about the game board.</p>
 *
 * <br><br>
 * <b>Operations:</b>
 * <ul>
 * <li>The SetsBoard class can give a card from the game board.
 * <li>The SetsBoard class can clear the in-lay.
 * <li>The SetsBoard class can move Cards from the in-lay back to the game board.
 * <li>The SetsBoard class can give the amount of rows in the game board.
 * <li>The SetsBoard class can check for sets both on the game board and in the in-lay.
 * <li>The SetsBoard class can give the amount of Cards in the .
 * <li>The SetsBoard class can support Hint functionality. 
 * </ul>
 *
 *
 * @author Ryan S. Lange
 * @version 0.2
 * @version 12/04/08 
 * 
 * @see Natural
 * @see Card
 * @see Deck
 * 
 * @history
 *  - 12/04/08 0.2 Added Version History & pseudocode <br>
 *  - 12/01/08 0.1 Initial Class Skeleton<br>
 */

public class SetsBoard 
{
	/**
	 * The possible number of rows in the game board
	 * 
	 * @author rslange
	 */
	public enum ROWS
	{
		/** The board has 4 rows */
		FOUR,
		/** The board has 5 rows */
		FIVE,
		/** The board has 6 rows */
		SIX,
		/** The board has 7 rows */
		SEVEN;
	}
	
	/**
	 * Keeps track of the next open position in the hintList.
	 */
	private int hintIndex;
	
	/**
	 * Holds 3 Cards from the game board that constitute a set. 
	 */
	private int[] hintList;
	
	/**
	 * Keeps track of size and next position in the in-lay.
	 */
	private int inlayIndex;
	
	/**
	 * Keeps track of the current index in the cardList.
	 */
	private int currentIndex;
	
	/**
	 * Represents the number of rows in the game board.
	 */
	private ROWS numRows;
	
	/**
	 * Holds all the Cards currently on the game board.
	 */
	private ArrayList<Card> cardList;
	
	/**
	 * Holds all the Cards currently in the in-lay.
	 */
	private ArrayList<Card> inlayList;
	
	/**
	 * The Deck that is used for the game board.
	 */
	private Deck gameDeck;
	
	/**
	 * Holds the return index's to go from the in-lay to the game board.
	 */
	private int []returnInlayToBoard;
	
	/**
	 * Tells if the deck is empty or not
	 */
	private boolean deckEmpty;
	
	/**
	 * The amount of columns possible for the game board.
	 */
	public static final Natural kBOARD_SIZE_X = new Natural(3);
	
	/**
	 * The amount of cards in a set.
	 */
	public static final int setSize = 3;
	
	/**
	 * Max size of inlay
	 */
	private static final int inlaySize = 3;
	
	/**
	 * Starting number of cards
	 */
	private static final int startNumCards = 12;
	
	private boolean canUseHint;
	
	/**
	 * Initializes the SetsBoard
	 */
	
	/**
	 * Initializes the SetsBoard
	 * 
	 * @param beginnerMode: True for beginner mode (27 Cards)
	 * @param shuffle: True if deck is to be shuffled for testing
	 */
    public SetsBoard(boolean aBeginner, boolean shuff) 
    {

    }
    
    /**
     * Sets all positions in inlay to initial value of null
     */
    private void initializeInlay()
    {

    }
    
    /**
	 * Returns the Card at the given coordinates.
	 *
	 * @param x the column position of the Card on the game board.
	 * @param y the row position of the Card on the game board.
	 * @return the Card at the given coordinates x and y.
	 */
    public Card getCardFromBoard(Natural x, Natural y)
    {
    	return null;
    }
    
    /**
     * If a set is selected and removed from the game board:
     * 		Adds three new cards in old cards positions.
     * If there is not a set on the board:
     * 		Adds a row and three more Cards to the game board.
     */
    public void addThreeMore( )
    {  

    }
    
    /**
     * Returns if the deck is empty or not
     */
    public boolean deckEmpty()
    {
    	return null;
    }
    
    /**
	 * Returns the amount of rows currently on the game board.
	 * 
	 * @return the amount of Cards currently on the game board.
	 */
    public ROWS getRowSize()
    {
    	//RETURN numRows
    	return null;
    }
    
    /**
	 * Returns the Card from the in-lay at the given index.
	 *
	 * @param  The index in the in-lay.
	 * @return The Card from the in-lay at the given index.
	 */
    public Card getInlayCard(Natural index)
    {
    	// RETURN Card from inlayList at position of index
    	return null;
    }
    
    /**
     * Returns true if the card is in the inlay.
     */
    public boolean isInInlay(Card c)
    {
    	return true;
    }
    
    /**
     * Verifies that three given Cards constitute a set
     * 
     * @param card1 first Card
     * @param card2 second Card
     * @param card3 third Card
     * 
     * @return true if the three Cards constitute a set
     * 	       false if the three Cards do not constitute a set
     */
    public boolean checkForSet(Card card1, Card card2, Card card3)
    {
    	return true;
    }
    
    private boolean isFeatureSet(Enum e1, Enum e2, Enum e3)
    {
    	return true;
    }
    
    /**
     * Produces a String explaining why or why not the set in the in-lay
     * does or does not constitute a proper set.
     * 
     * @precondition The in-lay must contain 3 Cards
     * 
     * @return String explaining the set.
     */
    public String explanation()
    {
    	return null;
    }
    
    /**
	 * Moves the Card to the in-lay.
	 *
	 * @param theCard theCard to move to the in-lay.
	 * @param isHint: if true than card is being moved to in-lay due to using a hint.
	 * 	              if false than card was chosen by the player.
	 * 
	 * @return true if the move to the in-lay was a success
	 * 	       false if the move to the in-lay was a failure
	 */
    public boolean moveCardToInlay(Card theCard, Boolean isHint)
    {
    	return true;
    }
    
    /**
     * Moves a Card from a set on the board to the in-lay.
     * 
     * @return true if the move to the in-lay was a success
	 * 	       false if the move to the in-lay was a failure
     */
    public boolean doHint()
    {
    	return true;
    }
    
    /**
	 * Returns the amount of Cards in the in-lay at the current
	 * time.
	 * 
	 * @return the amount of Cards in the in-lay.
	 */
    public Natural getInlaySize()
    {
	return null;
    }
    
    /**
	 * Returns true if the Cards in the in-lay constitute a set.
	 * Returns false if the Cards in the in-lay do not constitute a set.
	 * 
	 * @return true if there is a set in the in-lay.
	 *         false if there is not a set in the in-lay.
	 */
    public boolean isInlaySet()
    {
    	return null;
    }
    
    /**
	 * Returns true if there are Cards that constitute a set. 
	 * Returns false if there are not any Cards that constitute a set.
	 * 
	 * The Cards that are used to test for a set come from both the in-lay and 
	 * the game board or all the Cards that are currently in play.
	 * 
	 * @return true if the game board contains a set.
	 *         false if the game board does not contain a set.
	 */
    public boolean boardContainsSet()
    {
    	return true;
    }
    
    /**
     * Removes all entries in the hintList
     */
    private void clearHintList()
    {	

    }
    
    /**
     * Makes a set from the Cards on the game board and 
     * stores the index of each Card in the set in hintList  
     * 
     * @return true if there is a set on the board
     * 		   false if there is not a set on the board	
     */
    private boolean makeSet()
    {
    	return true;
    }
    
    /**
     * Returns the index of the Card in the game board.
     * 
     * @param theCard to find the index of.
     *
     * @return index of the Card in the game board.
     */
    private int cardToIndex(Card theCard)
    {
    	return true;
    }
    
    /**
     * Resets board status because a set has been found.
     */
    private void resetBoardStatus()
    {

    }
    
    /**
	 * Removes all Cards from in-lay due to a player getting a correct set
	 */
    public void clearSetFromInlay()
    {

    }
    
    /**
     * Moved one Card from in-lay back to original position on the game board
     * 
     * @param theCard is the Card to be moved back to the game board
     */
    public void moveInlayCardToBoard(Card theCard)
    {  

    }
    
    /**
     * Computes the amount of cards on the gameboard
     */
    public Natural getBoardSize()
    {
    	return null;
    }
    
    /**
     * Moves Cards from in-lay back to original position on the game board.
     */
    public void returnInlayToBoard()
    {

    }
}
