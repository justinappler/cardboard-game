package com.immortallabs.cardboard.game;

import java.util.ArrayList;



import edu.profdalbey.Natural;

/**
 * --FAKE--
 * <p>The SetsBoard class models the state of the game board by
 * keeping track of what Cards are in the inlay and what Cards 
 * are on the game board. Also the SetsBoard class determines 
 * what is a set and can return information about the game board.</p>
 *
 * <br><br>
 * <b>Operations:</b>
 * <ul>
 * <li>The SetsBoard class can give a card from the game board.
 * <li>The SetsBoard class can clear the inlay.
 * <li>The SetsBoard class can move Cards from the inlay back to the game board.
 * <li>The SetsBoard class can give the amount of rows in the game board.
 * <li>The SetsBoard class can check for sets both on the game board and in the inlay.
 * <li>The SetsBoard class can give the amount of Cards in the inlay.
 * <li>The SetsBoard class can support Hint functionality. 
 * </ul>
 *
 *
 * @author Thomas Dvornik
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
	 * Keeps track of size and next position in the inlay.
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
	 * Holds all the Cards currently in the inlay.
	 */
	private ArrayList<Card> inlayList;
	
	/**
	 * Holds the return index to the game board from the inlay.
	 */
	private int[] returnIndex;
	
	/**
	 * Tells if the deck should be shuffled or not.
	 * true  - shuffled
	 * false - ordered
	 */
	private boolean shuffle;
	
	/**
	 * Tells if we are in beginner mode with only 27 cards
	 */
	private boolean begMode;
	
	/**
	 * The amount of columns possible for the game board.
	 */
	public static final Natural kBOARD_SIZE_X = new Natural(3);
	
	/**
	 * The amount of cards in a set.
	 */
	public static final int setSize = 3;
	
	/**
	 * Initializes the SetsBoard
	 * 
	 * @param beginnerMode: True for beginner mode (27 Cards)
	 * @param shuffle: True if deck is to be shuffled for testing
	 */
    public SetsBoard(boolean beginnerMode, boolean shuffle) 
    {
    	//SET numRows to FOUR
    	
    	//CREATE returnIndex array with size setSize
    	//CREATE hintList array with size setSize
    	//CALL clearHintList()
    	
    	//FOR i = 0 to 11
    		// GET a card from deck 
    		// STORE the Card in cardList at currentIndex
    		// INCREMENT currentIndex
    	//END FOR
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
    	//SET returnIndex to: index equals x * 3 + y
    	//RETURN Card from cardList at returnIndex
    	return null;
    }
    
    /**
    * Adds a row and three more Cards to the game board.
    */
    public void addThreeMore( )
    {  
    	//CREATE boolean isSpot=false
    	//FOR i=0 to cardList length
    	//   IF cardList[i] == null
    	//      isSpot=true
    	//   END IF
    	//END FOR
    	
    	//IF isSpot
    	//   FOR currCard=0 and i=0, loop while i<cardList length and currCard<setSize
    	//      IF cardList[i] == null
    	//         GET a card from deck 
    	//         STORE the Card in cardList at i
    	//         INCREMENT currCard
    	//      END IF
    	//   END FOR   	
    	//ELSE
    	//   CHANGE numRows to next value
    	//   FOR i = 0 to 11
		//      GET a card from deck 
		//      STORE the Card in cardList at currentIndex
		//      INCREMENT currentIndex
	    //   END FOR
    	//END IF
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
	 * Returns the Card from the inlay at the given index.
	 *
	 * @param index the index in the inlay.
	 * @return the Card from the inlay at the given index.
	 */
    public Card getInlayCard(Natural index)
    {
    	// RETURN Card from inlayList at position of index
    	return null;
    }
    
    /**
	 * Returns the amount of Cards in the inlay at the current
	 * time.
	 * 
	 * @return the amount of Cards in the inlay.
	 */
    public Natural getInlaySize()
    {
    	// RETURN inlayIndex
    	return new Natural(1);
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
    private boolean checkForSet(Card card1, Card card2, Card card3)
    {
    	//CREATE a boolean retValue = false
    	
    	//IF all card1, card2, and card3 all have same fill, shape, color, and number
    		//SET refalsetValue =  true
    	//ELSE IF card1, card2, and card3 all have same fill, shape, and color
    		//SET refalsetValue =  true
    	//ELSE IF card1, card2, and card3 all have same fill, shape, and number
    		//SET refalsetValue =  true
    	//ELSE IF card1, card2, and card3 all have same fill, color, and number
    		//SET refalsetValue =  true
    	//ELSE IF card1, card2, and card3 all have same shape, color, and number
    		//SET refalsetValue =  true
    	//ELSE IF card1, card2, and card3 all have different fill, shape, color, and number
    		//SET refalsetValue =  true
    	
    	//RETURN retVAlue
    	return false;
    }
    
    /**
     * Produces a String explaining why or why not the set in the inlay
     * does or does not constitute a proper set.
     * 
     * @pre The inlay must contain 3 Cards
     * 
     * @return String explaining the set.
     */
    public String explanation()
    {
    	//CREATE String retString to null
    	//CREATE a String setString = "This was a set because all three cards have three common characteristics";
    	//CREATE a String noSetString = "This is not a set because card1, card2, and card3 do not have three common characteristics";
    	//CREATE a String commonString = "This was a set because all the cards have all common characteristics";
    	//CREATE a String oppositeString = "This was a set because all the cards have no common characteristics";
    	
    	//IF all card1, card2, and card3 all have same fill, shape, color, and number
    		//SET retString to commonString
    	//ELSE IF card1, card2, and card3 all have same fill, shape, and color
    		//SET retString to setString
    	//ELSE IF card1, card2, and card3 all have same fill, shape, and number
    		//SET retString to setString
    	//ELSE IF card1, card2, and card3 all have same fill, color, and number
   			//SET retString to setString
    	//ELSE IF card1, card2, and card3 all have same shape, color, and number
    		//SET retString to setString
    	//ELSE IF card1, card2, and card3 all have different fill, shape, color, and number
   			//SET retString to oppositeString
    	//ELSE
    		//SET retString to noSetString
    	//END IF
	
    	//RETURN retVAlue
    	return null;
    }
    
    /**
	 * Returns true if the Cards in the inlay constitute a set.
	 * Returns false if the Cards in the inlay do not constitute a set.
	 * 
	 * @return true if there is a set in the inlay.
	 *         false if there is not a set in the inlay.
	 */
    public Boolean isInlaySet()
    {
    	//CREATE a boolean retValue = false
    	
    	//SET isSet to the return value of checkForSet() with parameters: inlayList[0],inlayList[1],inlayList[2]
    	
    	//IF set equals true
    		//SET refalsetValue =  true
    	
    	//RETURN retVAlue
    	return false;
    }
    
    /**
	 * Returns true if there are Cards that constitute a set. 
	 * Returns false if there are not any Cards that constitute a set.
	 * 
	 * The Cards that are used to test for a set come from both the inlay and 
	 * the game board or all the Cards that are currently in play.
	 * 
	 * @return true if the game board contains a set.
	 *         false if the game board does not contain a set.
	 */
    public Boolean boardContainsSet()
    {
    	//CREATE a boolean retValue = true
    	//SET isSet equal to first element in hintList 
    	
    	//IF isSet equals -1 THEN
    		//SET refalsetValue =  false
    	
    	//RETURN retVAlue
    	return true;
    }
    
    /**
     * Removes all entries in the hintList
     */
    private void clearHintList()
    {
    	//FOR i=0 to i=3
    		//SET entry in hintList at position i to -1
    	//END FOR
    }
    
    /**
     * Makes a set from the Cards on the game board and 
     * stores the index of each Card in the set in hintList    	
     */
    private boolean makeSet()
    {
    	//CREATE a boolean retValue = false
    	
    	//SET first  to 0
    	//SET second to 1
    	//SET third  to 2
    	//SET isSet  to false
    	
    	//FOR first to first = amount of Cards on board
    		//FOR second to second = amount of Cards on board
    			//FOR third to third = amount of Cards on board
    				//SET isSet to return value of checkForSet() with parameters: cardList[first], cardList[second], cardList[third].
    				//IF isSet equals true
    					//SET hintList[hintIndex] to cardList[first]
    					//SET hintList[hintIndex] to cardList[second]
    					//SET hintList[hintIndex] to cardList[third]
    					//SET refalsetValue =  true
    				//END IF
    			//END FOR
    		//END FOR
    	//END FOR
    	
    	//RETURN retVAlue
    	return false;
    }
    
    /**
     * Moves a Card from a set on the board to the inlay.
     * 
     * @return true if the move to the inlay was a success
	 * 	       false if the move to the inlay was a failure
     */
    public boolean doHint()
    {
    	//CREATE a boolean retValue = false
    	
    	//IF boardContainsSet()
    		//SET index equal to return value of findHintCard()
    		//SET inlayList[inlayIndex] to cardList[index]
    		//SET hintList[inlayIndex] to index
    		//REMOVE Card at cardList[index]
    		//SET refalsetValue =  true
    	//END IF
    	
    	//RETURN retVAlue
    	return false;
    }
    
    /**
     * Finds a Card from the game board that is part of a set.
     * 
     * @return the index of a Card in a set on the game board.
     */
    private int findHintCard()
    {
    	//CREATE an integer retValue = -1
    	
    	//IF hintIndex does not equal 0
    		//SET retValue = element in hintArray at position hintIndex
    	
    	//RETURN retValue
    	return 0;
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
    	//CREATE an integer retValue = -1
    	
    	//FOR each Card in the cardList array
    		//IF theCard equals cardList[i]
    			//SET retValue =  i
    		//END IF
    	//END FOR
    	
    	//RETURN retValue
    	return -1;
    }
    
    /**
	 * Moves the Card with the given coordinates to the inlay.
	 *
	 * @param x the column index of the game board
	 * @param y the row index of the game board
	 * @param isHint: if true than card is being moved to inlay due to using a hint.
	 * 	              if false than card was chosen by the player.
	 * 
	 * @return true if the move to the inlay was a success
	 * 	       false if the move to the inlay was a failure
	 */
    public boolean moveCardToInlay(Card theCard, Boolean isHint)
    {
    	//CREATE a boolean retValue = false
    	
    	//IF isHint equals false
    		//SET index to return value of cardToIndex(theCard)
    		//SET inlayList[inlayIndex] to the card in cardList[index]
    		//SET returnInlayToBoard[inlayIndex] to index
    		//REMOVE the card at cardList[index]
    		//INCREMENT inlayIndex
    		//SET refalsetValue =  true
    	//ELSE /* Hint button was clicked to move the card to inlay */
    		//IF boardContainsSet()
    			//SET index to the return value of findHintCard()
    			//SET inlayList[inlayIndex] to the card in carList[index]
    			//SET returnInlayToBoard[inlayIndex] to index
    			//REMOVE the card at cardList[index]
    			//INCREMENT inlayIndex
    			//SET refalsetValue =  true
    		//ELSE
    			//SET refalsetValue =  false
    		//END IF
    	//END IF
    	
    	//RETURN retValue
    	return false;
    }
    
    /**
	 * Removes all Cards from inlay due to a player getting a correct set
	 */
    public void clearSetFromInlay()
    {
    	//SET first index of inlayList to null
    	//Set second index of inlayList to null
    	//Set third index of indlayList to null
    }
    
    /**
     * Moved one Card from inlay back to original position on the game board
     * 
     * @param theCard is the Card to be moved back to the game board
     */
    public void moveInlayCardToBoard(Card theCard)
    {    	
    	//FOR i=0 to i = size of inlayList
    		//IF theCard equals inlayList[i]
    			//SET index to returnIndex[i]
    			//SET cardList[index] to inlayList[i]
    			//REMOVE inlayList[i]
    		//END IF
    	//END FOR
    }
    
    /**
     * Moves Cards from inlay back to original position on the game board.
     */
    public void returnInlayToBoard()
    {
    	//WHILE inlayIndex is greater than 0 
    		//SET index to returnInlayToBoard[inlayIndex]
    		//SET cardList[index] to inlayList[inlayIndex]
    		//SET inlayList[inlayIndex] to null
    		//DECREMENT inlayIndex
    	//END WHILE
    }
}
