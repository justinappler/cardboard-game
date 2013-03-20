package unit.CardTest;

import com.immortallabs.cardboard.game.Card.COLOR;
import com.immortallabs.cardboard.game.Card.FILL;
import com.immortallabs.cardboard.game.Card.NUMBER;
import com.immortallabs.cardboard.game.Card.SHAPE;
import com.immortallabs.cardboard.game.Card;

import junit.framework.TestCase;

public class CardTest extends TestCase
{

	public CardTest(String name)
	{
		super(name);
	}
	
	/**
	 * Tests the constructor and get methods using the FIRST
	 * enumeration of each type.
	 */
	public void testConstructor1andGets()
	{
		Card testCard = new Card(SHAPE.SQUIGGLES, COLOR.RED, FILL.SOLID, NUMBER.ONE);
		
		assertEquals(testCard.getShape(), SHAPE.SQUIGGLES);
		assertEquals(testCard.getColor(), COLOR.RED);
		assertEquals(testCard.getFill(), FILL.SOLID);
		assertEquals(testCard.getNumber(), NUMBER.ONE);		
	}
	
	/**
	 * Tests the constructor and get methods using the SECOND
	 * enumeration of each type.
	 */
	public void testConstructor2andGets()
	{
		Card testCard2 = new Card(SHAPE.DIAMONDS, COLOR.PURPLE, FILL.STRIPED, NUMBER.TWO);
		
		assertEquals(testCard2.getShape(), SHAPE.DIAMONDS);
		assertEquals(testCard2.getColor(), COLOR.PURPLE);
		assertEquals(testCard2.getFill(), FILL.STRIPED);
		assertEquals(testCard2.getNumber(), NUMBER.TWO);
	}
	
	/**
	 * Tests the constructor and get methods using the THIRD
	 * enumeration of each type.
	 */
	public void testConstructor3andGets()
	{
		Card testCard3 = new Card(SHAPE.OVALS, COLOR.GREEN, FILL.EMPTY, NUMBER.THREE);
		
		assertEquals(testCard3.getShape(), SHAPE.OVALS);
		assertEquals(testCard3.getColor(), COLOR.GREEN);
		assertEquals(testCard3.getFill(), FILL.EMPTY);
		assertEquals(testCard3.getNumber(), NUMBER.THREE);
	}
	
	/**
	 * Tests getting the values of the Colors.
	 */
	public void testColor()
	{
		assertEquals(COLOR.valueOf("RED"), COLOR.RED);
		assertEquals(COLOR.valueOf("PURPLE"), COLOR.PURPLE);
		assertEquals(COLOR.valueOf("GREEN"), COLOR.GREEN);
		
		COLOR [] holder = COLOR.values();
		assertEquals(holder[0], COLOR.RED);
		assertEquals(holder[1], COLOR.PURPLE);
		assertEquals(holder[2], COLOR.GREEN);		
	}
	
	/**
	 * Tests getting the values of the Shapes.
	 */
	public void testShape()
	{
		assertEquals(SHAPE.valueOf("SQUIGGLES"), SHAPE.SQUIGGLES);
		assertEquals(SHAPE.valueOf("DIAMONDS"), SHAPE.DIAMONDS);
		assertEquals(SHAPE.valueOf("OVALS"), SHAPE.OVALS);
		
		SHAPE [] holder = SHAPE.values();
		assertEquals(holder[0], SHAPE.SQUIGGLES);
		assertEquals(holder[1], SHAPE.DIAMONDS);
		assertEquals(holder[2], SHAPE.OVALS);		
	}
	
	/**
	 * Tests getting the values of the Fills.
	 */
	public void testFill()
	{
		assertEquals(FILL.valueOf("SOLID"), FILL.SOLID);
		assertEquals(FILL.valueOf("STRIPED"), FILL.STRIPED);
		assertEquals(FILL.valueOf("EMPTY"), FILL.EMPTY);
		
		FILL [] holder = FILL.values();
		assertEquals(holder[0], FILL.SOLID);
		assertEquals(holder[1], FILL.STRIPED);
		assertEquals(holder[2], FILL.EMPTY);		
	}
	
	/**
	 * Tests getting the values of the Numbers.
	 */
	public void testNumber()
	{
		assertEquals(NUMBER.valueOf("ONE"), NUMBER.ONE);
		assertEquals(NUMBER.valueOf("TWO"), NUMBER.TWO);
		assertEquals(NUMBER.valueOf("THREE"), NUMBER.THREE);
		
		NUMBER [] holder = NUMBER.values();
		assertEquals(holder[0], NUMBER.ONE);
		assertEquals(holder[1], NUMBER.TWO);
		assertEquals(holder[2], NUMBER.THREE);		
	}
	
	/**
	 * Tests the equals() method to verify functionality.
	 */
	public void testEquals1()
	{
		Card testCard1 = new Card(SHAPE.OVALS, COLOR.GREEN, FILL.EMPTY, NUMBER.THREE);
		Card testCard2 = new Card(SHAPE.OVALS, COLOR.GREEN, FILL.EMPTY, NUMBER.THREE);
		assertEquals(testCard1, testCard2);		
	}
	
	/**
	 * Tests the equals() method to verify functionality.
	 */
	public void testEquals2()
	{
		Card testCard1 = new Card(SHAPE.OVALS, COLOR.GREEN, FILL.EMPTY, NUMBER.THREE);
		assertEquals(testCard1.equals(testCard1), true);		
	}
	
	/**
	 * Tests the equals() method to verify functionality.
	 */
	public void testEquals3()
	{
		Card testCard1 = new Card(SHAPE.OVALS, COLOR.GREEN, FILL.EMPTY, NUMBER.THREE);
		assertEquals(testCard1.equals(null), false);		
	}
	
	/**
	 * Tests the equals() method to verify that it fails if the cards are
	 * not equal.
	 */
	public void testNotEqual1()
	{
		Card testCard1 = new Card(SHAPE.OVALS, COLOR.GREEN, FILL.EMPTY, NUMBER.THREE);
		Card testCard2 = new Card(SHAPE.DIAMONDS, COLOR.GREEN, FILL.EMPTY, NUMBER.THREE);
		if (testCard1.equals(testCard2))
		{
			fail(testCard1.toString());
		}
	}
	
	/**
	 * Tests the equals() method to verify that it fails if the cards are
	 * not equal.
	 */
	public void testNotEqual2()
	{
		Card testCard1 = new Card(SHAPE.OVALS, COLOR.GREEN, FILL.EMPTY, NUMBER.THREE);
		Card testCard2 = new Card(SHAPE.OVALS, COLOR.GREEN, FILL.EMPTY, NUMBER.TWO);
		if (testCard1.equals(testCard2))
		{
			fail(testCard1.toString());
		}
	}
	
	/**
	 * Tests the equals() method to verify that it fails if the cards are
	 * not equal.
	 */
	public void testNotEqual3()
	{
		Card testCard1 = new Card(SHAPE.OVALS, COLOR.GREEN, FILL.EMPTY, NUMBER.THREE);
		Card testCard2 = new Card(SHAPE.OVALS, COLOR.RED, FILL.EMPTY, NUMBER.THREE);
		if (testCard1.equals(testCard2))
		{
			fail(testCard1.toString());
		}
	}
	
	/**
	 * Tests the equals() method to verify that it fails if the cards are
	 * not equal.
	 */
	public void testNotEqual4()
	{
		Card testCard1 = new Card(SHAPE.OVALS, COLOR.GREEN, FILL.EMPTY, NUMBER.THREE);
		Card testCard2 = new Card(SHAPE.OVALS, COLOR.GREEN, FILL.SOLID, NUMBER.THREE);
		if (testCard1.equals(testCard2))
		{
			fail(testCard1.toString());
		}
	}
	
	/**
	 * Tests the clone() method to verify functionality.
	 */
	public void testClone()
	{
		Card testCard1 = new Card(SHAPE.OVALS, COLOR.GREEN, FILL.EMPTY, NUMBER.THREE);
		Card testCard2 = (Card)testCard1.clone();
		assertEquals(testCard1, testCard2);		
	}

}
