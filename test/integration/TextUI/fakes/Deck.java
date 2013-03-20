package com.immortallabs.cardboard.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import com.immortallabs.cardboard.game.Card.COLOR;

/**
 *      <p>Models a stack of CardBoard cards in a
 *      random order. You can deal card off the
 *      deck and ask the deck if it's empty.</p>
 *
 *      <b>Operations:</b>
 *      <ul>
 *      <li>Cards can be dealt off the deck.</li>
 *      <li>The deck can be asked whether or not it is empty.</li>
 *      </ul>
 *      @author         Kyle Williamson
 *      @author         Formerly Sky Eckstrom
 *      @author         ImmortalLabs CSC308 W09
 *      @version        1.3
 *      @version        1/18/09
 *
 *      @see Card
 *
 *      @history
 *              - 1/18/09  1.3  Wrote out code from pseudocode
 *              - 1/13/09  1.2  Switched to using the Collection's shuffle
 *              - 1/13/09  1.2  Added methods to create cards and add them to the deck
 *              - 1/12/09  1.1  Control of Deck given to Kyle Williamson
 *              - 12/04/08 1.1  Added Version History & Pseudocode<br>
 *              - 11/30/08 1.0  Inital Class Skeleton<br>
 **/
 
public class Deck
{
         /**
         *      A stack of cards modeling a deck
         *      that can be accessed in order.
         **/
       private Stack<Card> deck;

        /**
         *      Size of a normal deck - 1
         **/
       private final int normalSize = 80;

        /**
         *      Size of a beginner deck - 1
         **/
       private final int beginSize = 26;

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
                        createDeck();
                }
                /* If the game is going to use a beginner deck */
                else
                {
                        createBeginnerDeck();
                }
                /* If the deck is going to be shuffles */
                if(shuffle)
                {
                        Collections.shuffle(deck);
                }
        }

        /**
         *      Creates the cards for a deck of size of 81. The deck has
         *      Card with 3 different Numbers, Colors, Shapes, and Fills.
         **/
        private void createDeck()
        {
                ArrayList<Card> placeInOrder = new ArrayList<Card>();
                /* For every card's number */
                for(Card.NUMBER num : Card.NUMBER.values())
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
                                                Card tempCard = 
                                                         new Card(sha, col, fil, num);
                                                placeInOrder.add(tempCard);
                                        }
                                }
                        }
                }
                /*Because of enum order, this is done to switch order for the game*/
                for(int index = normalSize; index >= 0; index--)
                {
                        deck.push(placeInOrder.get(index));
                }
        }

        /**
         *      Creates the cards for a deck of size 27. The deck has cards of 3
         *      different Numbers, Shapes, Fills, but only 1 Color.
         **/
        private void createBeginnerDeck()
        {
                ArrayList<Card> placeInOrder = new ArrayList<Card>();
                Card.COLOR col = COLOR.RED;
                //For each card's color
                for(Card.NUMBER num : Card.NUMBER.values())
                {
                        // For each card's shape
                        for(Card.SHAPE sha : Card.SHAPE.values())
                        {
                                // For each card's fill
                                for(Card.FILL fil : Card.FILL.values())
                                {
                                        Card tempCard = new Card(sha, col, fil, num);
                                        placeInOrder.add(tempCard);
                                }
                        }
                }
                /*Because of enum order, this is done to switch order for the game*/
                for(int index = beginSize; index >= 0; index--)
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
}
