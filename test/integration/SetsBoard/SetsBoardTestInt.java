package integration.SetsBoard;

import junit.framework.TestCase;
import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.SetsBoard;
import com.immortallabs.cardboard.game.Card.COLOR;
import com.immortallabs.cardboard.game.Card.FILL;
import com.immortallabs.cardboard.game.Card.NUMBER;
import com.immortallabs.cardboard.game.Card.SHAPE;

import edu.profdalbey.Natural;

public class SetsBoardTestInt extends TestCase
{
	SetsBoard testBoard = new SetsBoard(true, false);
	
	public void testExplanation_manually()
    {
	    SetsBoard setsBoard = new SetsBoard(false, false);
        // 0,0
        // 3,0
        // 3,1
        
        Card c1 = setsBoard.getCardFromBoard(new Natural(0), new Natural(0));
        Card c2 = setsBoard.getCardFromBoard(new Natural(3), new Natural(0));
        Card c3 = setsBoard.getCardFromBoard(new Natural(3), new Natural(1));
        
        setsBoard.moveCardToInlay(c1, false);
        setsBoard.moveCardToInlay(c2, false);
        setsBoard.moveCardToInlay(c3, false);

        setsBoard.explanation();
        setsBoard.clearSetFromInlay();
        
        // 0,0
        // 0,1
        // 1,1
        c1 = setsBoard.getCardFromBoard(new Natural(0), new Natural(0));
        c2 = setsBoard.getCardFromBoard(new Natural(0), new Natural(1));
        c3 = setsBoard.getCardFromBoard(new Natural(1), new Natural(1));
        
        setsBoard.moveCardToInlay(c1, false);
        setsBoard.moveCardToInlay(c2, false);
        setsBoard.moveCardToInlay(c3, false);

        setsBoard.explanation();
        setsBoard.clearSetFromInlay();
        
        // 3,0
        // 2,1
        // 1,0
        c1 = setsBoard.getCardFromBoard(new Natural(3), new Natural(0));
        c2 = setsBoard.getCardFromBoard(new Natural(2), new Natural(1));
        c3 = setsBoard.getCardFromBoard(new Natural(1), new Natural(0));
        
        setsBoard.moveCardToInlay(c1, false);
        setsBoard.moveCardToInlay(c2, false);
        setsBoard.moveCardToInlay(c3, false);

        setsBoard.explanation();
        setsBoard.clearSetFromInlay();
        
        // 0,0
        // 3,1
        // 2,1
        c1 = setsBoard.getCardFromBoard(new Natural(0), new Natural(0));
        c2 = setsBoard.getCardFromBoard(new Natural(3), new Natural(1));
        c3 = setsBoard.getCardFromBoard(new Natural(2), new Natural(1));
        
        setsBoard.moveCardToInlay(c1, false);
        setsBoard.moveCardToInlay(c2, false);
        setsBoard.moveCardToInlay(c3, false);

        setsBoard.explanation();
        setsBoard.clearSetFromInlay();
        
        // 0,1
        // 3,1
        // 2,2
        c1 = setsBoard.getCardFromBoard(new Natural(0), new Natural(1));
        c2 = setsBoard.getCardFromBoard(new Natural(3), new Natural(1));
        c3 = setsBoard.getCardFromBoard(new Natural(2), new Natural(2));
        
        setsBoard.moveCardToInlay(c1, false);
        setsBoard.moveCardToInlay(c2, false);
        setsBoard.moveCardToInlay(c3, false);

        setsBoard.explanation();
        setsBoard.clearSetFromInlay();
        
        // 0,0
        // 1,0
        // 1,2
        c1 = setsBoard.getCardFromBoard(new Natural(0), new Natural(0));
        c2 = setsBoard.getCardFromBoard(new Natural(1), new Natural(0));
        c3 = setsBoard.getCardFromBoard(new Natural(1), new Natural(2));
        
        setsBoard.moveCardToInlay(c1, false);
        setsBoard.moveCardToInlay(c2, false);
        setsBoard.moveCardToInlay(c3, false);

        setsBoard.explanation();
        setsBoard.clearSetFromInlay();
        
        // 0,0
        // 2,0
        // 2,2
        c1 = setsBoard.getCardFromBoard(new Natural(0), new Natural(0));
        c2 = setsBoard.getCardFromBoard(new Natural(2), new Natural(0));
        c3 = setsBoard.getCardFromBoard(new Natural(2), new Natural(2));
        
        setsBoard.moveCardToInlay(c1, false);
        setsBoard.moveCardToInlay(c2, false);
        setsBoard.moveCardToInlay(c3, false);

        setsBoard.explanation();
        setsBoard.clearSetFromInlay();
        

        //do hint seven times...
        for(int i = 0; i < 7; i++)
        {
            if(setsBoard.boardContainsSet() == false)
            {
                setsBoard.addThreeMore();
                i--;
            }
            else
            {
                setsBoard.doHint();
                setsBoard.doHint();
                setsBoard.doHint();

                setsBoard.explanation();
                setsBoard.clearSetFromInlay();
            }
        }
        
        // 0,0
        // 0,1
        // 3,0
        c1 = setsBoard.getCardFromBoard(new Natural(0), new Natural(0));
        c2 = setsBoard.getCardFromBoard(new Natural(0), new Natural(1));
        c3 = setsBoard.getCardFromBoard(new Natural(3), new Natural(1));
        
        setsBoard.moveCardToInlay(c1, false);
        setsBoard.moveCardToInlay(c2, false);
        setsBoard.moveCardToInlay(c3, false);

        setsBoard.explanation();
        setsBoard.clearSetFromInlay();
        
        // 0,0
        // 1,0
        // 0,1
        c1 = setsBoard.getCardFromBoard(new Natural(0), new Natural(0));
        c2 = setsBoard.getCardFromBoard(new Natural(1), new Natural(0));
        c3 = setsBoard.getCardFromBoard(new Natural(0), new Natural(1));
        
        setsBoard.moveCardToInlay(c1, false);
        setsBoard.moveCardToInlay(c2, false);
        setsBoard.moveCardToInlay(c3, false);

        setsBoard.explanation();
        setsBoard.clearSetFromInlay();
        
        // 1,0
        // 0,0
        // 0,1
        c1 = setsBoard.getCardFromBoard(new Natural(1), new Natural(0));
        c2 = setsBoard.getCardFromBoard(new Natural(0), new Natural(0));
        c3 = setsBoard.getCardFromBoard(new Natural(0), new Natural(1));
        
        setsBoard.moveCardToInlay(c1, false);
        setsBoard.moveCardToInlay(c2, false);
        setsBoard.moveCardToInlay(c3, false);

        setsBoard.explanation();
        setsBoard.clearSetFromInlay();

    }
	
	/**
	 * ADDED FOR DEFECT #95
	 */
	public void testIsSet_withNullCard()
	{
	    testBoard.moveCardToInlay(null, false);
	    testBoard.moveCardToInlay(null, false);
	    testBoard.moveCardToInlay(null, false);
	    
	    assertEquals(testBoard.isInlaySet(), false);
	}
	
	public void testNumCardsLeft()
	{
	    assertEquals(testBoard.getCardsLeft().intValue(), 15);
 
	    testBoard.doHint();
	    testBoard.doHint();
	    testBoard.doHint();
	    
	    testBoard.clearSetFromInlay();
	    testBoard.addThreeMore();

	    assertEquals(testBoard.getCardsLeft().intValue(), 12);
	}
	
	/**
	 * ADDED FOR DEFECT #67
	 */
	public void testGetCardFromBoard()
	{	
		Card c0  = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
		Card c1  = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
		Card c2  = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
		Card c3  = testBoard.getCardFromBoard(new Natural(1), new Natural(0));
		Card c4  = testBoard.getCardFromBoard(new Natural(1), new Natural(1));
		Card c5  = testBoard.getCardFromBoard(new Natural(1), new Natural(2));
		Card c6  = testBoard.getCardFromBoard(new Natural(2), new Natural(0));
		Card c7  = testBoard.getCardFromBoard(new Natural(2), new Natural(1));
		Card c8  = testBoard.getCardFromBoard(new Natural(2), new Natural(2));
		Card c9  = testBoard.getCardFromBoard(new Natural(3), new Natural(0));
		Card c10 = testBoard.getCardFromBoard(new Natural(3), new Natural(1));
		Card c11 = testBoard.getCardFromBoard(new Natural(3), new Natural(2));
		
		
		//	SHAPE shape, COLOR color, FILL fill, NUMBER number
		Card tc0 = new Card(Card.SHAPE.SQUIGGLES, Card.COLOR.RED, Card.FILL.SOLID, Card.NUMBER.ONE);
		Card tc1 = new Card(Card.SHAPE.SQUIGGLES, Card.COLOR.RED, Card.FILL.STRIPED, Card.NUMBER.ONE);
		Card tc2 = new Card(Card.SHAPE.SQUIGGLES, Card.COLOR.RED, Card.FILL.EMPTY, Card.NUMBER.ONE);
		Card tc3 = new Card(Card.SHAPE.DIAMONDS, Card.COLOR.RED, Card.FILL.SOLID, Card.NUMBER.ONE);
		Card tc4 = new Card(Card.SHAPE.DIAMONDS, Card.COLOR.RED, Card.FILL.STRIPED, Card.NUMBER.ONE);
		Card tc5 = new Card(Card.SHAPE.DIAMONDS, Card.COLOR.RED, Card.FILL.EMPTY, Card.NUMBER.ONE);
		Card tc6 = new Card(Card.SHAPE.OVALS, Card.COLOR.RED, Card.FILL.SOLID, Card.NUMBER.ONE);
		Card tc7 = new Card(Card.SHAPE.OVALS, Card.COLOR.RED, Card.FILL.STRIPED, Card.NUMBER.ONE);
		Card tc8 = new Card(Card.SHAPE.OVALS, Card.COLOR.RED, Card.FILL.EMPTY, Card.NUMBER.ONE);
		Card tc9 = new Card(Card.SHAPE.SQUIGGLES, Card.COLOR.RED, Card.FILL.SOLID, Card.NUMBER.TWO);
		Card tc10 = new Card(Card.SHAPE.SQUIGGLES, Card.COLOR.RED, Card.FILL.STRIPED, Card.NUMBER.TWO);
		Card tc11 = new Card(Card.SHAPE.SQUIGGLES, Card.COLOR.RED, Card.FILL.EMPTY, Card.NUMBER.TWO);
	
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
	
	/**
	 * ADDED FOR DEFECT #115
	 */
	public void testBadSet_thenUseHint()
	{  
	    Card c1,c2,c3;
        
        c1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
        c2 = testBoard.getCardFromBoard(new Natural(1), new Natural(1));
        c3 = testBoard.getCardFromBoard(new Natural(2), new Natural(1));
        
        testBoard.moveCardToInlay(c1,false);
        testBoard.moveCardToInlay(c2,false);
        testBoard.moveCardToInlay(c3,false);
        
        assertEquals(testBoard.isInlaySet(), false);
        testBoard.clearSetFromInlay();
        
        testBoard.doHint();
        testBoard.doHint();
        testBoard.doHint();
        
        assertEquals(testBoard.isInlaySet(), true);
	}
	
	/**
     * ADDED FOR DEFECT #95, #106
     */
	public void testAddThreeMore()
	{
	    // Original size
	    assertEquals(testBoard.getBoardSize().intValue(), 12);
	    testBoard.addThreeMore();
	    
	    // A set is on the board now so don't add any cards
	  
	    assertEquals(testBoard.getBoardSize().intValue(), 12);
	    
	    testBoard.doHint();
	    testBoard.doHint();
	    testBoard.doHint();
	    
	    assertEquals(testBoard.isInlaySet(), true);
	}

	public void testDeckEmpty()
	{
	    assertEquals(testBoard.deckEmpty(), false);
	    
	    testBoard.doHint();
	    testBoard.doHint();
	    testBoard.doHint();
	    testBoard.addThreeMore();
	    testBoard.clearSetFromInlay();
	    
	    testBoard.doHint();
        testBoard.doHint();
        testBoard.doHint();
        testBoard.addThreeMore();
        testBoard.clearSetFromInlay();
        
        testBoard.doHint();
        testBoard.doHint();
        testBoard.doHint();
        testBoard.addThreeMore();
        testBoard.clearSetFromInlay();
        
        testBoard.doHint();
        testBoard.doHint();
        testBoard.doHint();
        testBoard.addThreeMore();
        testBoard.clearSetFromInlay();
        
        testBoard.doHint();
        testBoard.doHint();
        testBoard.doHint();
        testBoard.addThreeMore();
        testBoard.clearSetFromInlay();
        
        assertEquals(testBoard.deckEmpty(), true);
	}
	
	public void testGetRowSize()
	{
		assertEquals(testBoard.getRowSize(), SetsBoard.ROWS.FOUR);
	}
	
	public void testGetInlayCard()
	{
	    //empty
		assertEquals(testBoard.getInlayCard(new Natural(0)), null);
		
		Card c1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
		
		testBoard.moveCardToInlay(c1, false);
		assertEquals(testBoard.getInlayCard(new Natural(0)), c1);
	}
	
	public void testGetInlaySize()
	{	
	    //empty
		assertEquals(testBoard.getInlaySize().intValue(), 0);
		
		Card c1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
        
        testBoard.moveCardToInlay(c1, false);
        assertEquals(testBoard.getInlaySize().intValue(), 1);
	}
	
	/**
	 * ADDED FOR DEFECT #93
	 */
	public void testAddThreeMore_withOneCardInInlay()
	{
	    /* The point of this test is to test the fix of the defect
	     * which was anytime you pressed add three more it would add 
	     * three more, or if there was only one or two cards in the 
	     * in lay it would still add three more.
	     */
	    
	    Card c1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
        Card c2 = testBoard.getCardFromBoard(new Natural(1), new Natural(0));
	    
	    assertEquals(testBoard.getBoardSize().intValue(), 12);
	    testBoard.addThreeMore();
	    assertEquals(testBoard.getBoardSize().intValue(), 12);
	    testBoard.moveCardToInlay(c1, false);
	    testBoard.addThreeMore();
	    assertEquals(testBoard.getBoardSize().intValue(), 12);
	    testBoard.moveCardToInlay(c2, false);
	    testBoard.addThreeMore();
	    assertEquals(testBoard.getBoardSize().intValue(), 12);
	}
	
	/**
	 * ADDED FOR DEFECT #92
	 */
	public void testGetNewHintListAfterClearingSet()
	{
	    /*
	     * The point of the test is to test the fix of the defect 
	     * which was after a set was selected we would add three more
	     * but we were not generated the next hint list.  This proves that
	     * after creating a set and calling the three more a new set 
	     * is generated.
	     */
	    
	    // set on board: (0,0) (1,0) (3,1)
        Card c1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
        Card c2 = testBoard.getCardFromBoard(new Natural(1), new Natural(0));
        Card c3 = testBoard.getCardFromBoard(new Natural(3), new Natural(1));
        
        testBoard.moveCardToInlay(c1, false);
        testBoard.moveCardToInlay(c2, false);
        testBoard.moveCardToInlay(c3, false);
        
        testBoard.addThreeMore();
        testBoard.clearSetFromInlay();

        assertEquals(testBoard.isInlaySet(), false);
        
        testBoard.doHint();
        testBoard.doHint();
        testBoard.doHint();
        
        assertEquals(testBoard.isInlaySet(), true);
	}
	
	/**
    * ADDED FOR DEFECT #90
    */
	public void testCheckForSet()
	{
		// set on board: (0,0) (1,0) (3,1)
		assertEquals(testBoard.checkForSet(null, null, null), false);
		
		//	SHAPE shape, COLOR color, FILL fill, NUMBER number
		Card SRH1 = new Card(Card.SHAPE.SQUIGGLES, Card.COLOR.RED,   Card.FILL.STRIPED, Card.NUMBER.ONE);
		Card SBH1 = new Card(Card.SHAPE.SQUIGGLES, Card.COLOR.PURPLE,  Card.FILL.STRIPED, Card.NUMBER.ONE);
		Card DGH1 = new Card(Card.SHAPE.DIAMONDS,  Card.COLOR.GREEN, Card.FILL.STRIPED, Card.NUMBER.ONE);
		Card OBE2 = new Card(Card.SHAPE.OVALS,     Card.COLOR.PURPLE,  Card.FILL.EMPTY, Card.NUMBER.TWO);
		Card DGS3 = new Card(Card.SHAPE.DIAMONDS,  Card.COLOR.GREEN, Card.FILL.SOLID, Card.NUMBER.THREE);
		Card ORH2 = new Card(Card.SHAPE.OVALS,     Card.COLOR.RED,   Card.FILL.STRIPED, Card.NUMBER.TWO);
		Card OBH2 = new Card(Card.SHAPE.OVALS,     Card.COLOR.PURPLE,  Card.FILL.STRIPED, Card.NUMBER.TWO);
		Card OGH2 = new Card(Card.SHAPE.OVALS,     Card.COLOR.GREEN, Card.FILL.STRIPED, Card.NUMBER.TWO);
		
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
		
	public void testMoveCardToInlay_CheckSetsBoardOldSpot()
	{
		Card theCard = testBoard.getCardFromBoard(new Natural(0), new Natural(0));

		testBoard.moveCardToInlay(theCard,false);	
		
		// should be true because on the game board the old card
		// position should be a null place holder
		assertEquals(testBoard.getCardFromBoard
				(new Natural(0), new Natural(0)), null);
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
				(new Natural(1), new Natural(1)), false);
		
		//Test full in lay with a bad set
		assertEquals(testBoard.isInlaySet(), false);
	}
	
	public void testMoveCardToInlay_HINT()
	{
        testBoard.moveCardToInlay(null,true);
        assertEquals(testBoard.getInlaySize().intValue(), 1);
	}
	
	/**
	 * ADDED FOR DEFECT #85
	 */
	public void test_MoveInlayCardToBoard()
	{
	    // Move Card at index 0 to in lay
	    Card c1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
	    Card c2 = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
	    
        testBoard.moveCardToInlay(c1 ,false);
        testBoard.moveCardToInlay(c2, false);
        
        testBoard.moveInlayCardToBoard(c1);
        
        assertEquals(testBoard.getInlayCard(new Natural(0)), null);
        assertEquals(testBoard.getInlayCard(new Natural(1)), c2);
        assertEquals(testBoard.getInlayCard(new Natural(2)), null);
        
	}
	
	public void testMoveInlayCardToBoard_ONE_CARD()
	{
		// Move Card at index 0 to in lay
		testBoard.moveCardToInlay(testBoard.getCardFromBoard(new Natural(0), new Natural(0)),false);
		
		Card c = testBoard.getInlayCard(new Natural(0));
		
		testBoard.moveInlayCardToBoard(c);
		
		assertEquals(testBoard.getCardFromBoard
				(new Natural(0), new Natural(0)), c);
	}
	
	public void testMoveInlayCardToBoard_MULTIPLE_CARDS()
	{
		// Move Card at index 0 to in lay
		Card c1,c2,c3;
		
		c1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
		c2 = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
		c3 = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
		
		testBoard.moveCardToInlay(c1,false);
		assertEquals(testBoard.getInlaySize().intValue(), 1);
		assertEquals(testBoard.getCardFromBoard(new Natural(0), new Natural(0)), null);
		
		// Move Card at index 1 to in lay
		testBoard.moveCardToInlay(c2,false);
		assertEquals(testBoard.getInlaySize().intValue(), 2);
		assertEquals(testBoard.getCardFromBoard(new Natural(0), new Natural(1)), null);
		
		// Move Card at index 2 to in lay
		testBoard.moveCardToInlay(c3,false);
		assertEquals(testBoard.getInlaySize().intValue(), 3);	
		assertEquals(testBoard.getCardFromBoard(new Natural(0), new Natural(2)), null);
		

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
		Card c2 = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
		Card c3 = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
		
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
		
		assertEquals(testBoard.getInlaySize().intValue(), 3);
		testBoard.returnInlayToBoard();
		assertEquals(testBoard.getInlaySize().intValue(), 0);
		
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
		assertEquals(SetsBoard.ROWS.valueOf("FOUR"), SetsBoard.ROWS.FOUR);
		assertEquals(SetsBoard.ROWS.valueOf("FIVE"), SetsBoard.ROWS.FIVE);
		assertEquals(SetsBoard.ROWS.valueOf("SIX"), SetsBoard.ROWS.SIX);
		assertEquals(SetsBoard.ROWS.valueOf("SEVEN"), SetsBoard.ROWS.SEVEN);
		
		SetsBoard.ROWS.values();

	}
	
	public void testDoHint_GOOD()
	{
		// set on board: (0,0) (0,1) (0,2)
		Card after1 = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
		Card after2 = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
		Card after3 = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
		
		
		testBoard.doHint();
		assertEquals(testBoard.getInlaySize().intValue(), 1);
		
		testBoard.doHint();
		assertEquals(testBoard.getInlaySize().intValue(), 2);
		
		testBoard.doHint();
		assertEquals(testBoard.getInlaySize().intValue(), 3);
		
		Card c1 = testBoard.getInlayCard(new Natural(0));
		Card c2 = testBoard.getInlayCard(new Natural(1));
		Card c3 = testBoard.getInlayCard(new Natural(2));
 
		assertEquals(c1, after1);
		assertEquals(c2, after2);
		assertEquals(c3, after3);
	}
	
	/**
	 * ADDED FOR DEFECT #59
	 */
	public void testIsInInlay()
	{
	    Card c1  = testBoard.getCardFromBoard(new Natural(0), new Natural(2));
	    Card c2  = testBoard.getCardFromBoard(new Natural(2), new Natural(1)); 
        Card bad = testBoard.getCardFromBoard(new Natural(0), new Natural(0));
        
        testBoard.moveCardToInlay(c1, false);
        testBoard.moveCardToInlay(c2, false);
	    
        assertEquals(testBoard.isInInlay(c1), true);
        assertEquals(testBoard.isInInlay(c2), true);
        assertEquals(testBoard.isInInlay(bad), false);
	}

	/**
	 * ADDED FOR DEFECT #62 and #71
	 */
	public void testExplanation()
	{
	    String s = null;
        
        // cards do not make a set
        Card c4 = testBoard.getCardFromBoard(new Natural(1), new Natural(0));
        Card c5 = testBoard.getCardFromBoard(new Natural(2), new Natural(1));
        Card c6 = testBoard.getCardFromBoard(new Natural(0), new Natural(1));
   
        assertEquals(testBoard.getInlayCard(new Natural(0)), null);
        assertEquals(testBoard.getInlayCard(new Natural(1)), null);
        assertEquals(testBoard.getInlayCard(new Natural(2)), null);
        
        assertEquals(testBoard.explanation(), "This is NOT a set because there are not 3 cards selected");
        
        testBoard.moveCardToInlay(c4, false);
        testBoard.moveCardToInlay(c5, false);
        
        assertEquals(testBoard.explanation(), "This is NOT a set because there are not 3 cards selected");
 
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
	
	
	/*
	public void testExplanation_FULLY_WITH_SET()
	{	    
	    int times = 0;
	    
	    while(times >= 9)
	    {
	        System.err.println();
	        for(int i = 0; i < 3; i++)
	        {
	            testBoard.doHint();
	        }
	        
	        if(testBoard.getInlaySize().intValue() == 3)
	        {
                    testBoard.explanation();
                    testBoard.clearSetFromInlay();
                    times = times + 3;
	        }  
	        else
	        {
	            testBoard.addThreeMore();
	        }
	    } 
	}
	*/

	public void testClearSetFromInlay()
	{
		testBoard.clearSetFromInlay();
		assertEquals(testBoard.getInlaySize().intValue(), 0);
	}
} 
