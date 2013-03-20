package com.immortallabs.cardboard.game;

import com.immortallabs.cardboard.game.Card;

import edu.profdalbey.Natural;

import java.util.Stack;

/**
 *	<p>Models a stack of CardBoard cards in a
 *	random order. You can deal card off the
 *	deck and ask the deck if it's empty.</p>
 *
 *	<b>Operations:</b>
 *	<ul>
 *	<li>Cards can be dealt off the deck.</li>
 *	<li>The deck can be asked whether or not it is empty.</li>
 *	</ul>
 *	@author		Kyle Williamson
 *	@author		Formerly Sky Eckstrom
 *	@author		ImmortalLabs CSC308 W09
 *	@version	1.11
 *	@version	1/10/09
 *
 *	@see Card
 *
 *	@history
 *		- 1/13/09  1.2	Switched to using the Collection's shuffle
 *		- 1/13/09  1.2	Added methods to create cards and add them to the deck
 *		- 1/12/09  1.1 Control of Deck given to Kyle Williamson
 *		- 12/04/08 1.1	Added Version History & Pseudocode<br>
 *		- 11/30/08 1.0	Inital Class Skeleton<br>
 **/
 
public class Deck
{
    private Natural cardsInDeck;
	/**
	 *	A stack of cards modeling a deck
	 *	that can be accessed in order.
	 **/
	private Stack<Card> deck;
	
	/**
	 *	Instantiates a deck filled with
	 *	every available card in a random
	 *	order
	 *
	 *	@param num 	Number of cards in the deck
	 *	@param flag Decided if the deck will be shuffled
	 **/
	
	public boolean begMode;
	public boolean shuff;
	
	public Deck(boolean gameType, boolean shuffle)
	{
	    cardsInDeck = new Natural(81);
		deck = new Stack<Card>();
		
		if(gameType == true)
			begMode = true;
		else
			begMode = false;
		if (shuffle == true)
			shuff = true;
		else 
			shuff = false;
		
		
		if(gameType)
		    createDeck();
		else
		    createOtherDeck();
		
		
		
		// CREATE a temporary stack
		
		//IF gameType is true, 81 card game
		
			//SET stack size to 81
			//CALL createDeck
		//ELSE
			//SET stack size to 27
			//CALL createBeginnerDeck
		//ENDIF
		
		//SET deck to the stack
		
		//IF shuffle is true
			//CALL collections shuffle on deck
		//ENDIF
	}
	
	public void createOtherDeck()
	{


	        deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
            deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
    /*0*/   deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.THREE));
	        
	      	        
	        //original 12
	        deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
            deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
            /*0*/   deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
            deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
            deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
            /*0*/   deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
            deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
            deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
            /*0*/   deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
            deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
            deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.TWO));
            /*0*/   deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
	}
	
	/**
     * Gives the number of cards that are left in the deck.
     * @return  A natural of the number of cards
     */
    public Natural getCardsLeft()
    {
        return cardsInDeck;
    }
	
	/**
	 * 	Creates the cards for a deck of size of 81. The deck has
	 * 	card of 3 different Numbers, Colors, Shapes, and Fills.
	 **/
	private void createDeck()
	{
		deck.add(new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.RED,  Card.FILL.SOLID,   Card.NUMBER.ONE));
		deck.add(new Card(Card.SHAPE.DIAMOND,  Card.COLOR.BLUE, Card.FILL.HATCHED, Card.NUMBER.TWO));
		deck.add(new Card(Card.SHAPE.OVAL,     Card.COLOR.GREEN,Card.FILL.EMPTY,   Card.NUMBER.THREE));
		deck.add(new Card(Card.SHAPE.DIAMOND,  Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.THREE));
		deck.add(new Card(Card.SHAPE.OVAL,     Card.COLOR.RED,  Card.FILL.HATCHED, Card.NUMBER.ONE));
		deck.add(new Card(Card.SHAPE.DIAMOND,  Card.COLOR.BLUE, Card.FILL.SOLID,   Card.NUMBER.TWO));
		deck.add(new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
		deck.add(new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.RED,  Card.FILL.EMPTY,   Card.NUMBER.THREE));	
		deck.add(new Card(Card.SHAPE.DIAMOND,  Card.COLOR.RED,  Card.FILL.SOLID,   Card.NUMBER.TWO));
		deck.add(new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.GREEN,Card.FILL.SOLID,   Card.NUMBER.THREE));
		deck.add(new Card(Card.SHAPE.OVAL,     Card.COLOR.BLUE, Card.FILL.SOLID,   Card.NUMBER.ONE));
		
		
		
		//original 12
		
/*32*/	deck.add( new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.GREEN,Card.FILL.HATCHED,   Card.NUMBER.TWO));
/*31*/	deck.add( new Card(Card.SHAPE.OVAL,     Card.COLOR.BLUE, Card.FILL.HATCHED, Card.NUMBER.THREE));
/*30*/	deck.add( new Card(Card.SHAPE.DIAMOND,  Card.COLOR.RED,  Card.FILL.HATCHED, Card.NUMBER.ONE));
/*22 8*/deck.add( new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.GREEN,Card.FILL.SOLID,   Card.NUMBER.ONE));
/*21 7*/deck.add( new Card(Card.SHAPE.OVAL,     Card.COLOR.BLUE, Card.FILL.HATCHED, Card.NUMBER.THREE));
/*20 6*/deck.add( new Card(Card.SHAPE.DIAMOND,  Card.COLOR.RED,  Card.FILL.EMPTY,   Card.NUMBER.TWO));
		deck.add( new Card(Card.SHAPE.SQUIGGLY, Card.COLOR.BLUE, Card.FILL.SOLID,   Card.NUMBER.TWO));
/*2*/	deck.add( new Card(Card.SHAPE.DIAMOND,  Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.THREE));
		deck.add(new Card(Card.SHAPE.SQUIGGLY,  Card.COLOR.RED,  Card.FILL.HATCHED, Card.NUMBER.TWO));
/*1*/   deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.THREE));
		deck.add(new Card(Card.SHAPE.OVAL,      Card.COLOR.GREEN,Card.FILL.SOLID,   Card.NUMBER.ONE));
/*0*/	deck.add(new Card(Card.SHAPE.DIAMOND,   Card.COLOR.GREEN,Card.FILL.HATCHED, Card.NUMBER.ONE));
		
		
		
		
		//FOR the 3 Numbers
			//FOR the 3 Colors
				//FOR the 3 Shapes
					//FOR the 3 Fills
						//CREATE card with current Number, Color, Shape, and Fill
						//ADD to deck
					//ENDFOR
				//ENDFOR
			//ENDFOR
		//ENDFOR
	}
	
	/**
	 * 	Creates the cards for a deck of size 27. The deck has cards of 3
	 * 	different Numbers, Shapes, Fills, but only 1 Color.
	 **/
	private void createBeginnerDeck()
	{
		//FOR the 3 Numbers
			//FOR 1 Color
				//FOR the 3 Shapes
					//FOR the 3 Fills
						//CREATE card with current Number, Color, Shape, and Fill
						//ADD to deck
					//ENDFOR
				//ENDFOR
			//ENDFOR
		//ENDFOR
	}
	
	/**
	 *	Deals the top card off the deck. Returns
	 *	null if there are no more cards in the
	 *	deck.
	 *
	 *	@return		the top card of the Deck or
	 *				null if the deck is empty.
	 **/
	public Card deal()
	{
		// POP the top card off of the stack
		// RETURN the top card
		Card theCard = deck.pop();
		
		//System.out.println("card: " + theCard.getNumber());
		//System.out.println("card: " + theCard.getFill());
		//System.out.println("card: " + theCard.getColor());
		//System.out.println("card: " + theCard.getShape());
		cardsInDeck.decrement();
		return theCard;
	}
	
	/**
	 *	Returns whether or not the deck is empty.
	 *
	 *	@return		TRUE if the deck is empty,
	 *				FALSE otherwise.
	 **/
	public boolean isEmpty()
	{
		// RETURN whether or not the stack is empty
		boolean empty = true;
		
		if(deck.empty())
			empty = true;
		else 
			empty = false;
		return empty;
	}

}
