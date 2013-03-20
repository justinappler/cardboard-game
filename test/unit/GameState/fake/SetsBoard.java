package com.immortallabs.cardboard.game;

import com.immortallabs.cardboard.game.Card.COLOR;
import com.immortallabs.cardboard.game.Card.FILL;
import com.immortallabs.cardboard.game.Card.NUMBER;
import com.immortallabs.cardboard.game.Card.SHAPE;
import unit.GameState.TestMonitor;
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
    	TestMonitor.add("SetsBoard");
    	inlaySize = 0;
    }
    
    public Card getCardFromBoard(Natural x, Natural y)
    {
    	TestMonitor.add("SetsBoard.getCardFromBoard");
    	return null;
    }
    
    public void addThreeMore( )
    {  
    	TestMonitor.add("SetsBoard.addThreeMore");
    }
    
    public ROWS getRowSize()
    {
    	TestMonitor.add("SetsBoard.getRowSize");
    	return null;
    }

    public Card getInlayCard(Natural index)
    {
    	TestMonitor.add("SetsBoard.getInlayCard");
    	return new Card(SHAPE.DIAMOND, COLOR.RED, FILL.EMPTY, NUMBER.ONE);
    }
    
    public Natural getInlaySize()
    {
    	TestMonitor.add("SetsBoard.getInlaySize");
    	if (inlaySize == 3)
    	    inlaySize = 0;
    	inlaySize++;
    	return new Natural(inlaySize);
    }

    public String explanation()
    {
    	TestMonitor.add("SetsBoard.explanation");
    	return null;
    }
    
    public boolean isInlaySet()
    {
    	TestMonitor.add("SetsBoard.isInlaySet");
    	return true;
    }
    
    public boolean isInInlay(Card c)
    {
        TestMonitor.add("SetsBoard.isInInlay");
    	return false;
    }
    
    public boolean boardContainsSet()
    {
    	TestMonitor.add("SetsBoard.boardContainsSet");
    	return true;
    }
    
    public boolean doHint()
    {
    	TestMonitor.add("SetsBoard.doHint");
    	return false;
    }
    
    public boolean moveCardToInlay(Card theCard, Boolean isHint)
    {
    	TestMonitor.add("SetsBoard.moveCardToInlay");
    	return false;
    }
    
    public void clearSetFromInlay()
    {
    	TestMonitor.add("SetsBoard.clearSetFromInlay");
    }
    
    public void moveInlayCardToBoard(Card theCard)
    {    	
    	TestMonitor.add("SetsBoard.moveInlayCardToBoard");
    }
    public void returnInlayToBoard()
    {
    	TestMonitor.add("SetsBoard.returnInlayToBoard");
    }
    
    public boolean deckEmpty()
    {
        TestMonitor.add("SetsBoard.deckEmpty");
        return false;
    }
    
}
