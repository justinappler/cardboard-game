package com.immortallabs.cardboard.game;

import com.immortallabs.cardboard.game.Card.COLOR;
import com.immortallabs.cardboard.game.Card.FILL;
import com.immortallabs.cardboard.game.Card.NUMBER;
import com.immortallabs.cardboard.game.Card.SHAPE;
import edu.profdalbey.Natural;

public class SetsBoard 
{

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
	
	int inlaySize = 0;
	
    public SetsBoard(boolean beginnerMode, boolean shuffle) 
    {
    	inlaySize = 0;
    }
    
    public Card getCardFromBoard(Natural x, Natural y)
    {
    	return null;
    }
    
    public void addThreeMore( )
    {  
    }
    
    public ROWS getRowSize()
    {
    	return null;
    }

    public Card getInlayCard(Natural index)
    {
    	return new Card(null, null, null, null);
    }
    
    public Natural getInlaySize()
    {
    	return new Natural(inlaySize);
    }

    public String explanation()
    {
    	return null;
    }
    
    public boolean isInlaySet()
    {
    	return true;
    }
    
    public boolean isInInlay(Card c)
    {
    	return false;
    }
    
    public boolean boardContainsSet()
    {
    	return true;
    }
    
    public boolean doHint()
    {
    	return false;
    }
    
    public boolean moveCardToInlay(Card theCard, Boolean isHint)
    {
    	return false;
    }
    
    public void clearSetFromInlay()
    {
    }
    
    public void moveInlayCardToBoard(Card theCard)
    {    	
    	
    }
    public void returnInlayToBoard()
    {
    	
    }

    public int getCardsLeft()
    {
    	return 0;
    }
    
    public boolean deckEmpty()
    {
        
        return false;
    }
    
}
