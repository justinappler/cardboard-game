package unit.SetsBoard;

import java.util.ArrayList;

import junit.framework.TestCase;
import com.immortallabs.cardboard.game.SetsBoard;
import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.Deck;

//import unit.SetsBoard.SetsBoard;
//import com.immortallabs.cardboard.game.SetsBoard;
import edu.profdalbey.Natural;


public class SetsBoardTest extends TestCase
{
	SetsBoard testBoard = new SetsBoard(false, true);
	
	public void testSetUp()
	{
		assertEquals(true, true);
	}
	
	public void testAddThreeMOre()
	{
	    SetsBoard board = new SetsBoard(true, true);
	    assertEquals(board.boardContainsSet(), false);
	    board.addThreeMore();
	    assertEquals(board.boardContainsSet(), true);
	    board.doHint();
	    board.doHint();
	    board.doHint();
	    assertEquals(board.isInlaySet(), true);
	    board.clearSetFromInlay();
	}
	
	public void testGetCardFromBoard()
	{	
		Card c0 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
		Card c1 = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
		Card c2 = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
		Card c3 = testBoard.getCardFromBoard(new Natural(1), new Natural(0));
		Card c4 = testBoard.getCardFromBoard(new Natural(1), new Natural(1));
		Card c5 = testBoard.getCardFromBoard(new Natural(1), new Natural(2));
		Card c6 = testBoard.getCardFromBoard(new Natural(2), new Natural(0));
		Card c7 = testBoard.getCardFromBoard(new Natural(2), new Natural(1));
		Card c8 = testBoard.getCardFromBoard(new Natural(2), new Natural(2));
		Card c9 = testBoard.getCardFromBoard(new Natural(3), new Natural(0));
		Card c10 = testBoard.getCardFromBoard(new Natural(3), new Natural(1));
		Card c11 = testBoard.getCardFromBoard(new Natural(3), new Natural(2));
		

		Card tc11= new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.GREEN,Card.FILL.HATCHED,   Card.NUMBER.TWO);
		Card tc10= new Card(Card.SHAPE.OVAL,     Card.COLOR.BLUE, Card.FILL.HATCHED, Card.NUMBER.THREE);
		Card tc9 = new Card(Card.SHAPE.DIAMOND,  Card.COLOR.RED,  Card.FILL.HATCHED, Card.NUMBER.ONE);
		Card tc8 = new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.GREEN,Card.FILL.SOLID,   Card.NUMBER.ONE);
		Card tc7 = new Card(Card.SHAPE.OVAL,    Card.COLOR.BLUE, Card.FILL.HATCHED,   Card.NUMBER.THREE);
		Card tc6 = new Card(Card.SHAPE.DIAMOND,  Card.COLOR.RED,  Card.FILL.EMPTY,   Card.NUMBER.TWO);
		Card tc5 = new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.BLUE, Card.FILL.SOLID,   Card.NUMBER.TWO);
		Card tc4 = new Card(Card.SHAPE.DIAMOND,  Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.THREE);
		Card tc3 = new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.RED,  Card.FILL.HATCHED, Card.NUMBER.TWO);
		Card tc2 = new Card(Card.SHAPE.DIAMOND,  Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.THREE);
	    Card tc1 = new Card(Card.SHAPE.OVAL,     Card.COLOR.GREEN,Card.FILL.SOLID,   Card.NUMBER.ONE);
	    Card tc0 = new Card(Card.SHAPE.DIAMOND,  Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE);

		assertEquals(c0, tc0);
		assertEquals(c1, tc1);
		assertEquals(c2, tc2);
		assertEquals(c3, tc3);
		assertEquals(c4, tc4);
		assertEquals(c5, tc5);
		assertEquals(c6, tc6);
		assertEquals(c7, tc7);
		assertEquals(c8, tc8);
		assertEquals(c9, tc9);
		assertEquals(c10, tc10);
		assertEquals(c11, tc11);	
	}
	
	public void testAddThreeMore()
	{
		SetsBoard.ROWS origSize = testBoard.getRowSize();
		SetsBoard.ROWS finSize;
		
		int size1=0, size2=0;

		testBoard.addThreeMore();
		finSize = testBoard.getRowSize();
		
		if(origSize == SetsBoard.ROWS.FOUR)
			size1 = 4;
		else if(origSize == SetsBoard.ROWS.FIVE)
			size1 = 5;
		
		if(finSize == SetsBoard.ROWS.FIVE)
			size2 = 5;
		else if(finSize == SetsBoard.ROWS.FOUR)
			size2 = 4;
		else if(finSize == SetsBoard.ROWS.SIX)
			size2 = 6;

		assertEquals(size1, size1);
	}
	
	public void testAddThreeMore_andAddCards()
	{
	    Card c1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
	    Card c2 = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
	    Card c3 = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
	    
	    testBoard.moveCardToInlay(c1, false);
        testBoard.moveCardToInlay(c2, false);
        testBoard.moveCardToInlay(c3, false); 
	    
        testBoard.clearSetFromInlay();
        
        Card c4 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));  
        Card c5 = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
        Card c6 = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
        
        testBoard.moveCardToInlay(c4, false);
        testBoard.moveCardToInlay(c5, false);
        testBoard.moveCardToInlay(c6, false); 
	    
        testBoard.clearSetFromInlay();
        
        Card c7 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));  
        Card c8 = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
        Card c9 = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
        
        testBoard.moveCardToInlay(c7, false);
        testBoard.moveCardToInlay(c8, false);
        testBoard.moveCardToInlay(c9, false); 
        
        testBoard.clearSetFromInlay();    
	}
	
	public void testGetRowSize()
	{
		assertEquals(testBoard.getRowSize(), SetsBoard.ROWS.FOUR);
	}
	
	public void testGetInlayCard_EMPTY_INLAY()
	{
		assertEquals(testBoard.getInlayCard(new Natural(0)), null);
	}
	
	public void testGetInlaySize_EMPTY_INLAY()
	{	
		assertEquals(testBoard.getInlaySize(), new Natural(0));
	}
	
	public void testCheckForSet()
	{
		// set on board: (0,0) (1,0) (3,1)
		assertEquals(testBoard.checkForSet(null, null, null), false);
		
		// shape/color/fill/number
		Card SRH1 = new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.RED,   Card.FILL.HATCHED, Card.NUMBER.ONE);
		Card SBH1 = new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.BLUE,  Card.FILL.HATCHED, Card.NUMBER.ONE);
		Card DGH1 = new Card(Card.SHAPE.DIAMOND,  Card.COLOR.GREEN, Card.FILL.HATCHED, Card.NUMBER.ONE);
		Card OBE2 = new Card(Card.SHAPE.OVAL,     Card.COLOR.BLUE,  Card.FILL.EMPTY, Card.NUMBER.TWO);
		Card DGS3 = new Card(Card.SHAPE.DIAMOND,  Card.COLOR.GREEN, Card.FILL.SOLID, Card.NUMBER.THREE);
		Card ORH2 = new Card(Card.SHAPE.OVAL,     Card.COLOR.RED,   Card.FILL.HATCHED, Card.NUMBER.TWO);
		Card OBH2 = new Card(Card.SHAPE.OVAL,     Card.COLOR.BLUE,  Card.FILL.HATCHED, Card.NUMBER.TWO);
		Card OGH2 = new Card(Card.SHAPE.OVAL,     Card.COLOR.GREEN, Card.FILL.HATCHED, Card.NUMBER.TWO);
		
		boolean b1 = testBoard.checkForSet(SRH1, SBH1, DGH1);
		assertEquals(b1, false); // false need three common fields
		b1 = testBoard.checkForSet(DGH1, OBE2, OBH2);
		assertEquals(b1, false);
		b1 = testBoard.checkForSet(SRH1, SBH1, DGH1);
		assertEquals(b1, false);
		b1 = testBoard.checkForSet(SRH1, OBE2, DGS3);
		assertEquals(b1, true); // true because all fields are diff.
		b1 = testBoard.checkForSet(ORH2, OBH2, OGH2);
		assertEquals(b1, true); 
		
		assertEquals(testBoard.checkForSet(null, null, OGH2), false);
	}

	public void testMoveCardToInlay_CheckInlaySize()
	{
		Card theCard = testBoard.getCardFromBoard(new Natural(0), new Natural(0));

		testBoard.moveCardToInlay(theCard,false);	

		// should be 1 since its the first move
		assertEquals(testBoard.getInlaySize(), new Natural(1));
		Card inlayCard = testBoard.getInlayCard(new Natural(0));
		assertEquals(theCard, inlayCard);
		assertEquals(null, testBoard.getCardFromBoard(new Natural(0), new Natural(0)));
	}
		
	public void testMoveCardToInlay_CheckSetsBoardOldSpot()
	{
		Card theCard = testBoard.getCardFromBoard(new Natural(0), new Natural(0));

		testBoard.moveCardToInlay(theCard,false);	
		
		assertEquals(testBoard.getCardFromBoard(new Natural(0), new Natural(0)), null);
	}
	
	public void testIsInlaySet_FALSE()
	{
		// set on board: (0,0) (1,0) (3,1)
		
		boolean boolV = testBoard.isInlaySet();
		Card theCard = null;

		//Test empty in lay
		assertEquals(boolV, false);
		
		theCard = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
		
		//1 Card in the in lay
		testBoard.moveCardToInlay(theCard, false);
		boolV = testBoard.isInlaySet();
		assertEquals(boolV, false);
		
		theCard = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
	
		//2 Cards in the in lay
		testBoard.moveCardToInlay(theCard, false);
		
		//Test in lay of size 2
		assertEquals(testBoard.isInlaySet(), false);
	
		//3 Cards in the in lay
		testBoard.moveCardToInlay(testBoard.getCardFromBoard
				(new Natural(0), new Natural(0)), false);
		
		//Test full in lay with a bad set
		assertEquals(testBoard.isInlaySet(), false);
	}
	
	public void testMoveInlayCardToBoard_ONE_CARD()
	{
		// Move Card at index 0 to in lay
		testBoard.moveCardToInlay(testBoard.getCardFromBoard(new Natural(0), new Natural(0)),false);
		
		Card c = testBoard.getInlayCard(new Natural(0));
		
		testBoard.moveInlayCardToBoard(c);
		
		assertEquals(testBoard.getCardFromBoard(new Natural(0), new Natural(0)), c);
	}
	
	public void testMoveInlayCardToBoard_MULTIPLE_CARDS()
	{
		// Move Card at index 0 to in lay
		Card c1,c2,c3;
		
		c1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
		c2 = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
		c3 = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
		
		testBoard.moveCardToInlay(c1,false);
		assertEquals(testBoard.getInlaySize(), new Natural(1));
		assertEquals(testBoard.getCardFromBoard(new Natural(0), new Natural(0)), null);
		
		// Move Card at index 1 to in lay
		testBoard.moveCardToInlay(c2,false);
		assertEquals(testBoard.getInlaySize(), new Natural(2));
		assertEquals(testBoard.getCardFromBoard(new Natural(0), new Natural(1)), null);
		
		// Move Card at index 2 to in lay
		testBoard.moveCardToInlay(c3,false);
		assertEquals(testBoard.getInlaySize(), new Natural(3));
//		assertEquals(testBoard.getCardFromBoard(new Natural(0), new Natural(2)), null);
		

		Card tempCard = testBoard.getInlayCard(new Natural(2));
		assertEquals(c3, tempCard);
		
		tempCard = testBoard.getInlayCard(new Natural(0));
		assertEquals(c1, tempCard);
		
		tempCard = testBoard.getInlayCard(new Natural(1));
		assertEquals(c2, tempCard);
	}
	
	public void testIsInlaySet_TRUE()
	{
		// set on board: (0,0) (1,0) (3,1)
		Card c1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
		Card c2 = testBoard.getCardFromBoard(new Natural(1), new Natural(0));
		Card c3 = testBoard.getCardFromBoard(new Natural(3), new Natural(1));
		
		assertEquals(testBoard.isInlaySet(), false);
		testBoard.moveCardToInlay(c1, false);
		
		assertEquals(testBoard.isInlaySet(), false);
		testBoard.moveCardToInlay(c2, false);
		
		assertEquals(testBoard.isInlaySet(), false);
		testBoard.moveCardToInlay(c3, false);
		
		Card i1 = testBoard.getInlayCard(new Natural(0));
		Card i2 = testBoard.getInlayCard(new Natural(1));
		Card i3 = testBoard.getInlayCard(new Natural(2));
		
		assertEquals(i1, c1);
		assertEquals(i2, c2);
		assertEquals(i3, c3);
		
		assertEquals(testBoard.isInlaySet(), true);
	}
	
	public void testReturnInlayToBoard()
	{
		// Move Card at index 0 to in lay
		Card c1,c2,c3, afterC1, afterC2, afterC3;
		
		c1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
		c2 = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
		c3 = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
		
		testBoard.moveCardToInlay(c1,false);
		testBoard.moveCardToInlay(c2,false);
		testBoard.moveCardToInlay(c3,false);
		
		assertEquals(testBoard.getInlaySize(), new Natural(3));
		testBoard.returnInlayToBoard();
		assertEquals(testBoard.getInlaySize(), new Natural(0));
		
		afterC1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
		afterC2 = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
		afterC3 = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
		
		assertEquals(c1, afterC1);
		assertEquals(c2, afterC2);
		assertEquals(c3, afterC3);
	}

	
	public void testBoardContainsSet()
	{
		assertEquals(testBoard.boardContainsSet(), true);
	}
	
	public void testDoHint_GOOD()
	{
		// set on board: (0,0) (1,0) (3,1)
		Card after1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
		Card after2 = testBoard.getCardFromBoard(new Natural(1), new Natural(0));
		Card after3 = testBoard.getCardFromBoard(new Natural(3), new Natural(1));

		assertEquals(testBoard.checkForSet(after1, after2, after3), true);
		
		testBoard.doHint();
		assertEquals(testBoard.getInlaySize(), new Natural(1));
		assertEquals(testBoard.getInlayCard(new Natural(0)), after1);

		testBoard.doHint();
		assertEquals(testBoard.getInlaySize(), new Natural(2));
		
		testBoard.doHint();
		assertEquals(testBoard.getInlaySize(), new Natural(3));
		
		Card c1 = testBoard.getInlayCard(new Natural(0));
		Card c2 = testBoard.getInlayCard(new Natural(1));
		Card c3 = testBoard.getInlayCard(new Natural(2));
 
		assertEquals(c1, after1);
		assertEquals(c2, after2);
		assertEquals(c3, after3);
	}
	
	public void testClearSetFromInlay()
	{
		testBoard.clearSetFromInlay();
		assertEquals(testBoard.getInlaySize(), new Natural(0));
	}
}
