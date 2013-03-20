package com.immortallabs.cardboard.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import com.immortallabs.cardboard.game.Card.COLOR;

import edu.profdalbey.Natural;

/**
 * FAKE! from Release 1 in Trunk
 */
 
public class Deck
{
         /**
         *      A stack of cards modeling a deck
         *      that can be accessed in order.
         **/
       private Stack<Card> deck;

        /**
         *      Size of a normal deck
         **/
       private final int normalSize = 81;

        /**
         *      Size of a beginner deck
         **/
       private final int beginSize = 27;
       
       /**
        *       Number of cards in the current Deck
        */
       private Natural cardsInDeck;

         /**
         *      Instantiates a deck filled with
         *      every available card in a random
         *      order
         *
         *      @param gameType  True for a normal Deck, false 
         *                       for a beginner deck
         *      @param shuffle   flag for if the deck will be shuffled
         **/
        public Deck(boolean gameType, boolean shuffle)
        {
                /* Pile of cards representing the deck */
                deck = new Stack<Card>();
                /* If the game is going to use a normal deck */
                if(gameType)
                {
                	cardsInDeck = new Natural(normalSize);
                    createDeck(true);
                }
                /* If the game is going to use a beginner deck */
                else
                {
                	cardsInDeck = new Natural(beginSize);
                    createDeck(false);
                }
                /* If the deck is going to be shuffles */
                if(shuffle)
                {
                        Collections.shuffle(deck);
                }
        }
        
        /**
         * Creates the Cards used in a deck. If a normal size deck it has 81 cards
         * and 3 different Numbers, Colors, Shapes, and Fills. If it's a beginner
         * deck it has 27 cards, 3 different Colors, Shapes, and Fills but only one
         * Color
         * @param normDeck A boolean to determine if a normal size deck is created
         * or a beginner deck.
         */
        private void createDeck(boolean normDeck)
        {
        	ArrayList<Card> placeInOrder = new ArrayList<Card>();
        	int index;
        	/* For every card's number */
            for(Card.NUMBER num : Card.NUMBER.values())
            {
                /* If the deck is normal size */
                if(normDeck)
                {
                    /* For every card's color */
                    for(Card.COLOR col : Card.COLOR.values())
                    {
                        /* For every card's shape */
                        for(Card.SHAPE sha : Card.SHAPE.values())
                        {
                            /* For every card's fill */
                            for(Card.FILL fil : Card.FILL.values())
                            {
                                Card tempCard = new Card(sha, col, fil, num);
                                placeInOrder.add(tempCard);
                            }   
                        }
                    }
                }
                //Else the deck is a beginner size
                else
                {
                    Card.COLOR col = COLOR.RED;
                    /* For every card's shape */
                    for(Card.SHAPE sha : Card.SHAPE.values())
                    {
                        /* For every card's fill */
                        for(Card.FILL fil : Card.FILL.values())
                        {
                            Card tempCard = new Card(sha, col, fil, num);
                            placeInOrder.add(tempCard);
                        }   
                    }
                }
            }
            //If the deck is normal size
            if(normDeck)
            	index = normalSize-1;
            //If the deck is a beginner size
            else
            	index = beginSize-1;
            for( ; index >= 0; index--)
            {
                   deck.push(placeInOrder.get(index));
            }
        }

        /**
         *      Deals the top card off the deck. Returns
         *      null if there are no more cards in the
         *      deck.
         *
         *      @return          the top card of the Deck or
         *                       null if the deck is empty.
         **/
        public Card deal()
        {
                /* If the deck is empty */
                if(isEmpty())
                {
                        return null;
                }
                cardsInDeck.decrement();
                return deck.pop();
        }

        /**
         *      Returns whether or not the deck is empty.
         *
         *      @return         TRUE if the deck is empty,
         *                      FALSE otherwise.
         **/
        public boolean isEmpty()
        {
                return deck.empty();
        }
        
        /**
         * Gives the number of cards that are left in the deck.
         * @return	A natural of the number of cards
         */
        public Natural getCardsLeft()
        {
        	return cardsInDeck;
        }
}
