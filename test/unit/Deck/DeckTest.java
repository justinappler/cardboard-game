package unit.Deck;


import junit.framework.TestCase;

import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.Deck;
import com.immortallabs.cardboard.game.Card.COLOR;
import com.immortallabs.cardboard.game.Card.FILL;
import com.immortallabs.cardboard.game.Card.NUMBER;
import com.immortallabs.cardboard.game.Card.SHAPE;

public class DeckTest extends TestCase 
{
	Deck d1;
	Deck d2;
	public DeckTest(String name)
	{
		super(name);
	}
	
	public void setUp()
	{
		d1 = new Deck(false, false);
		d2 = new Deck(true, false);
	}
	
	public void testDrawNotNull()
	{
		assertTrue(d1.deal() != null);
		assertTrue(d2.deal() != null);
	}
	
	public void testIsEmptyFalse()
	{
		d1.deal();
		assertEquals(d1.isEmpty(), false);
		assertEquals(d2.isEmpty(), false);
		d2.deal();
		assertEquals(d2.isEmpty(), false);
	}
	
	public void testIsEmptyTrue()
	{
		for(int i = 0; i < 26; i++)
			d1.deal();
		assertEquals(d1.isEmpty(), false);
		d1.deal();
		assertEquals(d1.isEmpty(), true);
		for(int i = 0; i < 80; i++)
			d2.deal();
		assertEquals(d2.isEmpty(), false);
		d2.deal();
		assertEquals(d2.isEmpty(), true);
	}
	
	public void testBeginCreate()
	{
		assertEquals(d1.deal(), new Card(SHAPE.SQUIGGLES, COLOR.RED, FILL.SOLID, NUMBER.ONE));
		assertEquals(d1.deal(), new Card(SHAPE.SQUIGGLES, COLOR.RED, FILL.STRIPED, NUMBER.ONE));
		for(int i = 0; i < 24; i++)
			d1.deal();
		assertEquals(d1.deal(), new Card(SHAPE.OVALS, COLOR.RED, FILL.EMPTY, NUMBER.THREE));
		assertEquals(d1.deal(), null);
	}
	
	public void testDeckCreate()
	{
		assertEquals(d2.deal(), new Card(SHAPE.SQUIGGLES, COLOR.RED, FILL.SOLID, NUMBER.ONE));
		assertEquals(d2.deal(), new Card(SHAPE.SQUIGGLES, COLOR.RED, FILL.STRIPED, NUMBER.ONE));
		for(int i = 0; i < 30; i++)
			d2.deal();
		assertEquals(d2.deal(), new Card(SHAPE.DIAMONDS, COLOR.RED, FILL.EMPTY, NUMBER.TWO));
		for(int i = 0; i < 46; i++)
			d2.deal();
		assertEquals(d2.deal(), new Card(SHAPE.OVALS, COLOR.GREEN, FILL.STRIPED, NUMBER.THREE));
		assertEquals(d2.deal(), new Card(SHAPE.OVALS, COLOR.GREEN, FILL.EMPTY, NUMBER.THREE));
		assertEquals(d2.deal(), null);
	}
	
	/*this is a test to have someone visually check if an unshuffled deck and a shuffled deck match up,
	 * which they should not. It is very unlikely that three cards will match up when one deck has
	 * been shuffled randomly.
	 */
	public void testPhysicalShuffleCheck()
	{
		Deck d3 = new Deck(true, true);
		Card c1 = d2.deal();
		Card c2 = d3.deal();
		System.out.println("Unshuffled Deck: first Card: " + c1.getShape() + " " + c1.getColor() + " " + c1.getFill() + " " + c1.getNumber());
		System.out.println("Shuffled Deck: first Card: " + c2.getShape() + " " + c2.getColor() + " " + c2.getFill() + " " + c2.getNumber());
		System.out.println("");
		c1 = d2.deal();
		c2 = d3.deal();
		System.out.println("Unshuffled Deck: second Card: " + c1.getShape() + " " + c1.getColor() + " " + c1.getFill() + " " + c1.getNumber());
		System.out.println("Shuffled Deck: second Card: " + c2.getShape() + " " + c2.getColor() + " " + c2.getFill() + " " + c2.getNumber());
		System.out.println("");
		c1 = d2.deal();
		c2 = d3.deal();
		System.out.println("Unshuffled Deck: third Card: " + c1.getShape() + " " + c1.getColor() + " " + c1.getFill() + " " + c1.getNumber());
		System.out.println("Shuffled Deck: third Card: " + c2.getShape() + " " + c2.getColor() + " " + c2.getFill() + " " + c2.getNumber());
	}

}
