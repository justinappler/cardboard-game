package unit.SetsBoard;

import edu.profdalbey.Natural;
import com.immortallabs.cardboard.game.SetsBoard;
import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.Deck;

public class Main 
{
	public static SetsBoard sb = new SetsBoard(false, false);
	
	public static void main(String[] args)
	{
		testSetUp();
		testMoveCardToInlay();
		testMoveInlayCardToBoard();
		testAddThreeMore();
		testDoHint();
		testClearInlay();
	}
	
	public static void testSetUp()
	{
		System.out.println("SET UP");
		System.out.println("SIZE OF BOARD: " + sb.getBoardSize());
		
		printCard(sb.getCardFromBoard(new Natural(0), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(0), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(0), new Natural(2)));
		printCard(sb.getCardFromBoard(new Natural(1), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(1), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(1), new Natural(2)));
		printCard(sb.getCardFromBoard(new Natural(2), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(2), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(2), new Natural(2)));
		printCard(sb.getCardFromBoard(new Natural(3), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(3), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(3), new Natural(2)));
	}
	
	public static void printGameBoard12()
	{
		printCard(sb.getCardFromBoard(new Natural(0), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(0), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(0), new Natural(2)));
		printCard(sb.getCardFromBoard(new Natural(1), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(1), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(1), new Natural(2)));
		printCard(sb.getCardFromBoard(new Natural(2), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(2), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(2), new Natural(2)));
		printCard(sb.getCardFromBoard(new Natural(3), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(3), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(3), new Natural(2)));
	}
	
	public static void printGameBoard15()
	{
		printCard(sb.getCardFromBoard(new Natural(0), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(0), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(0), new Natural(2)));
		printCard(sb.getCardFromBoard(new Natural(1), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(1), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(1), new Natural(2)));
		printCard(sb.getCardFromBoard(new Natural(2), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(2), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(2), new Natural(2)));
		printCard(sb.getCardFromBoard(new Natural(3), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(3), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(3), new Natural(2)));
		printCard(sb.getCardFromBoard(new Natural(4), new Natural(0)));
		printCard(sb.getCardFromBoard(new Natural(4), new Natural(1)));
		printCard(sb.getCardFromBoard(new Natural(4), new Natural(2)));
	}
	
	public static void testMoveCardToInlay()
	{
		System.out.println("\n\n***************************");
		System.out.println("MOVE CARD TO INLAY- GOOD");
		Card goodC = sb.getCardFromBoard(new Natural(0), new Natural(0));
		Card goodC2 = sb.getCardFromBoard(new Natural(0), new Natural(1));
		Card goodC3 = sb.getCardFromBoard(new Natural(0), new Natural(2));

		sb.moveCardToInlay(goodC,false);
		sb.moveCardToInlay(goodC2,false);
		sb.moveCardToInlay(goodC3, false);
		printInlay();
		
		System.out.println("Is inlay a set?: " + sb.isInlaySet());

		System.out.println("\n\ngameboard: ");
		printGameBoard12();
		
		//Move cards back to the gameboard
		sb.returnInlayToBoard();
		System.out.println("\nafter clearing the inlay back to board: ");
		printInlay();
		
		System.out.println("\ngameboard after returning card from inlay back to board.");
		printGameBoard12();
	}
	
	public static void printCard(Card c)
	{
		System.out.println("=================");
		if(c == null)
		{
			System.out.println("null!");
		}
		else
		{
			System.out.println(c.getShape());
			System.out.println(c.getFill());
			System.out.println(c.getColor());
			System.out.println(c.getNumber());
		}
	}
	
	public static void testMoveInlayCardToBoard()
	{
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("\nTESTING MOVE ONE CARD BACK TO BOARD");
		Card c1 = sb.getCardFromBoard(new Natural(2), new Natural(2));
		Card c2 = sb.getCardFromBoard(new Natural(3), new Natural(2));
		sb.moveCardToInlay(c1, false);
		sb.moveCardToInlay(c2, false);
		System.out.println("\nGameboard:");
		printGameBoard12();
		
		System.out.println("\nMOVE FIRST CARD FROM INLAY BACK.");
		sb.moveInlayCardToBoard(c1);
		printInlay();
		System.out.println("\nGAMEBOARD");
		printGameBoard12();
		
		sb.moveInlayCardToBoard(c2);
		System.out.println("Moving inlay at index 1 back to board.");
		System.out.println("Gameboard should be full now...");
		printGameBoard12();
	}
	
	public static void testAddThreeMore()
	{
		sb.addThreeMore();
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^" +
				"\n\nADDED THREE MORE CARDS TO BOARD.");
		printGameBoard15();
	}
	
	public static void testDoHint()
	{
		sb.doHint();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%" +
				"\n\ngameboard after do hint 1 time");
		printGameBoard15();
		printInlay();
		
		System.out.println("\ngameboard after do hint 2 times");
		sb.doHint();
		printGameBoard15(); System.out.println("");
		printInlay();
		
		System.out.println("\ngameboard after do hint 3 times");
		sb.doHint();
		printGameBoard15(); System.out.println("");
		printInlay();
		
	}
	
	public static void testClearInlay()
	{
		System.out.println("\n\n#######################");
		System.out.println("GOT A SET! NOW CLEAR IT AND START OVER.");
		sb.clearSetFromInlay();
		System.out.println("after clearing set before adding 3 more");
		printGameBoard15();
		printInlay();
		
		System.out.println("after adding three more to fill spots");
		sb.addThreeMore();
		printGameBoard15();
	}
	
	public static void printInlay()
	{
		System.out.println("\n\nCURRENT INLAY::::");
		System.out.println("inlay[0]: ");
		printCard(sb.getInlayCard(new Natural(0)));
		System.out.println("inlay[1]: ");
		printCard(sb.getInlayCard(new Natural(1)));
		System.out.println("inlay[2]: ");
		printCard(sb.getInlayCard(new Natural(2)));
	}
}
