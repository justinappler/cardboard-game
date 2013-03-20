package com.immortallabs.cardboard.game;

import java.util.ArrayList;

import edu.profdalbey.Natural;

/**
 * <p>
 * The SetsBoard class models the state of the game board by keeping track of
 * what Cards are in the in-lay and what Cards are on the game board. Also the
 * SetsBoard class determines what is a set and can return information about the
 * game board.
 * </p>
 * <br>
 * <br>
 * <b>Operations:</b>
 * <ul>
 * <li>The SetsBoard class can give a card from the game board.
 * <li>The SetsBoard class can clear the in-lay.
 * <li>The SetsBoard class can move Cards from the in-lay back to the game
 * board.
 * <li>The SetsBoard class can give the amount of rows in the game board.
 * <li>The SetsBoard class can check for sets both on the game board and in the
 * in-lay.
 * <li>The SetsBoard class can give the amount of Cards in the .
 * <li>The SetsBoard class can support Hint functionality.
 * </ul>
 * 
 * @author Ryan S. Lange
 * @version 0.2
 * @version 12/04/08
 * @see Natural
 * @see Card
 * @see Deck
 * @history - 01/10/09 0.3 Added source code<br> - 12/04/08 0.2 Added Version
 *          History & pseudocode <br> - 12/01/08 0.1 Initial Class Skeleton<br>
 */

public class SetsBoard
{
    /**
     * The possible number of rows in the game board
     * 
     * @author rslange
     */
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

    /**
     * Keeps track of the next open position in the hintList.
     */
    private int hintIndex;

    /**
     * Holds 3 Cards from the game board that constitute a set.
     */
    private int[] hintList;

    /**
     * Keeps track of the current index in the cardList.
     */
    private int currentIndex;

    /**
     * Represents the number of rows in the game board.
     */
    private ROWS numRows;

    /**
     * Holds all the Cards currently on the game board.
     */
    private ArrayList<Card> cardList;

    /**
     * Holds all the Cards currently in the in-lay.
     */
    private ArrayList<Card> inlayList;

    /**
     * The Deck that is used for the game board.
     */
    private Deck gameDeck;

    /**
     * Holds the return index's to go from the in-lay to the game board.
     */
    private int[] returnInlayToBoard;

    /**
     * Tells if the deck is empty or not
     */
    private boolean deckEmpty;

    /**
     * The amount of cards in a set.
     */
    public static final int kSetSize = 3;

    /**
     * Max size of inlay
     */
    private static final int kInlaySize = 3;

    /**
     * Starting number of cards
     */
    private static final int kStartNumCards = 12;

    /**
     * Flag that says if a hint can be used. True: can use a hint. False: cannot
     * use a hint.
     */
    private boolean canUseHint;

    /**
     * Initializes the SetsBoard
     * 
     * @param aBeginner
     *            True for beginner mode (27 Cards)
     * @param shuff
     *            True if deck is to be shuffled for testing
     */
    public SetsBoard(boolean aBeginner, boolean shuff)
    {
        // SET deckEmpty to false
        deckEmpty = false;

        // SET canUseHint to true
        canUseHint = true;

        // SET gameDeck to a deck with aBeginner and shuff
        gameDeck = new Deck(!aBeginner, shuff);

        // MAKE cardList into an array of cards
        cardList = new ArrayList<Card>();

        // SET currentIndex to zero
        currentIndex = 0;

        // MAKE inlayList into an array of cards
        inlayList = new ArrayList<Card>();

        // MAKE hintList into an array of ints
        hintList = new int[kSetSize];

        // MAKE returnInlayToBoard into an array of ints
        returnInlayToBoard = new int[kInlaySize];

        // SET hintIndex to zero
        hintIndex = 0;

        // INITIALIZE returnToBoard with -1
        returnInlayToBoard[0] = -1;
        returnInlayToBoard[1] = -1;
        returnInlayToBoard[2] = -1;

        // SET numRows to FOUR
        numRows = ROWS.FOUR;

        // CALL clearHintList
        clearHintList();

        // CALL intitializeInlay
        initializeInlay();

        // FOR iterator=0 to amount of cards to start game with
        for (int iterator = 0; iterator < kStartNumCards; iterator++)
        {
            // ADD a card to the cardList
            cardList.add(currentIndex++, gameDeck.deal());
        }
        // END FOR

        // CALL makeSet
        makeSet();
    }

    /**
     * Returns the number of cards left in the deck
     * 
     * @return the number of cards remaining in the deck
     */
    public Natural getCardsLeft()
    {
        // RETURN the number of cards left
        return gameDeck.getCardsLeft();
    }

    /**
     * Sets all positions in inlay to initial value of null
     */
    private void initializeInlay()
    {
        // SET inlayList to be filled with null values
        inlayList.add(0, null);
        inlayList.add(1, null);
        inlayList.add(2, null);
        inlayList.add(kInlaySize, null);
    }

    /**
     * Returns the Card at the given coordinates.
     * 
     * @param x
     *            the column position of the Card on the game board.
     * @param y
     *            the row position of the Card on the game board.
     * @return the Card at the given coordinates x and y.
     */
    public Card getCardFromBoard(Natural x, Natural y)
    {
        // SET index to x * 3 + y
        int index = x.intValue() * kInlaySize + y.intValue();

        // RETURN Card from cardList at returnIndex
        return cardList.get(index);
    }

    /**
     * If a set is selected and removed from the game board: Adds three new
     * cards in old cards positions. If there is not a set on the board: Adds a
     * row and three more Cards to the game board.
     */
    public void addThreeMore()
    {

        // SET isSpot to false
        boolean isSpot = false;

        // SET first, second, and third to -1
        int first = -1, second = -1, third = -1;

        // IF size of inlay == max size of inlay
        if (getInlaySize().intValue() == kInlaySize)
        {
            // FOR iterator=0 to size of cardList
            for (int iterator = 0; iterator < cardList.size(); iterator++)
            {
                // IF current card == null
                if (cardList.get(iterator) == null)
                {
                    // IF first < 0
                    if (first < 0)
                    {
                        // first = iterator
                        first = iterator;
                    }
                    // ELSE IF second < 0
                    else if (second < 0)
                    {
                        // second = iterator
                        second = iterator;
                    }
                    // ELSE IF third < 0
                    else if (third < 0)
                    {
                        // third = iterator
                        third = iterator;
                    }
                    // END IF

                    // SET isSpot to true
                    isSpot = true;
                }
                // END IF
            }
            // END FOR

            // IF isSpot and numRows > 0
            if (isSpot && numRows.ordinal() > 0)
            { 
                // SET origSize to the index in the cardList of the card
                int origSize = (numRows.ordinal() + kInlaySize) * kInlaySize;

                // SET index to origSize
                int index = origSize;

                // SET breakOut to false
                boolean breakOut = false;

                // FOR the amount of cards on the board
                for (int iterator = 0; iterator 
                        < (numRows.ordinal() + kInlaySize) * kInlaySize; 
                                iterator++)
                {
                    // SET card to the current card
                    Card card = cardList.get(iterator);

                    // IF card is null
                    if (card == null)
                    {
                        // FOR the amount of cards on the board
                        for (; index < cardList.size() && !breakOut; index++)
                        {
                            // SET C2 to current card
                            Card c2 = cardList.get(index);

                            // IF c2 is not null
                            if (c2 != null)
                            {
                                // REPLACE the card at the current spot with c2
                                cardList.set(iterator, c2);

                                // SET breakOut to be true to stop
                                breakOut = true;
                            }
                            // END IF
                        }

                        // SET breakOut back to false for next time through
                        breakOut = false;
                    }
                    // END FOR
                }
                // END FOR

                // REMOVE the last three spots in cardlist
                cardList.remove(origSize);
                cardList.remove(origSize);
                cardList.remove(origSize);

                // IF numRows == FIVE
                if (numRows == ROWS.FIVE)
                {
                    // SET numRows to four
                    numRows = ROWS.FOUR;
                }
                // ELSE IF numRows is six
                else if (numRows == ROWS.SIX)
                {
                    // SET numRows to five
                    numRows = ROWS.FIVE;
                }
                // ELSE IF numRow is seven
                else if (numRows == ROWS.SEVEN)
                {
                    // SET numRow to six
                    numRows = ROWS.SIX;
                }
                // END IF
            }

            // IF isSpot == true
            else if (isSpot)
            {      
                // IF gameDeck is not empty
                if (!gameDeck.isEmpty())
                {
                    // SET cardList to a new card at position of first
                    cardList.set(first, gameDeck.deal());
                }
                // END IF

                // IF gameDeck is not empty
                if (!gameDeck.isEmpty())
                {
                    // SET cardList to a new card at position of second
                    cardList.set(second, gameDeck.deal());
                }
                // END IF

                // IF gameDeck is not empty
                if (!gameDeck.isEmpty())
                {
                    // SET cardList to a new card at position of third
                    cardList.set(third, gameDeck.deal());
                }
                // END IF

                // IF gameDeck is not empty
                if (gameDeck.isEmpty())
                {
                    // SET deckEmpty to true
                    deckEmpty = true;
                }
                // END IF
            }
            // END IF
        }
        // ELSE IF board does not contain a set.
        else if (!boardContainsSet())
        {
            // IF numRows == FOUR
            if (!gameDeck.isEmpty() && numRows == ROWS.FOUR)
            {
                // numRows = FIVE
                numRows = ROWS.FIVE;
            }
            // ELSE IF numRows == FIVE
            else if (!gameDeck.isEmpty() && numRows == ROWS.FIVE)
            {
                // numRows = SIX
                numRows = ROWS.SIX;
            }
            // ELSE IF numRows == SIX
            else if (!gameDeck.isEmpty() && numRows == ROWS.SIX)
            {
                // numRows = SEVEN
                numRows = ROWS.SEVEN;
            }
            // END IF

            // FOR iterator=0 to size of a set
            for (int iterator = 0, index = cardList.size(); 
                iterator < kInlaySize; iterator++)
            {
                // IF gameDeck is not empty
                if (!gameDeck.isEmpty())
                {
                    // ADD a card to cardList at index position
                    cardList.add(index++, gameDeck.deal());
                }
                // ELSE
                else
                {
                    // SET deckEmpty to true
                    deckEmpty = true;
                }
                // END IF
            }
            // END FOR
        }
        // END IF

        // CALL makeSet
        makeSet();
    }

    /**
     * Returns if the deck is empty or not
     * 
     * @return true if deck is empty false if deck is not empty
     */
    public boolean deckEmpty()
    {
        // RETURN deckEmpty
        return deckEmpty;
    }

    /**
     * Returns the amount of rows currently on the game board.
     * 
     * @return the amount of Cards currently on the game board.
     */
    public ROWS getRowSize()
    {
        // RETURN numRows
        return numRows;
    }

    /**
     * Returns the Card from the in-lay at the given index.
     * 
     * @param index :
     *            The index in the in-lay.
     * @return The Card from the in-lay at the given index.
     */
    public Card getInlayCard(Natural index)
    {
        // RETURN Card from inlayList at position of index
        return inlayList.get(index.intValue());
    }

    /**
     * Returns true if the card is in the inlay.
     * 
     * @param c :
     *            the Card to be check for in the inlay
     * @return : true if the card is in the inlay false if the card is not in
     *         the inlay
     */
    public boolean isInInlay(Card c)
    {
        // SET retValue to false
        boolean retValue = false;

        // FOR iterator=0 to size of inlay
        for (int iterator = 0; iterator < kInlaySize; iterator++)
        {
            // IF inlayList at iterator is not null AND inlayList at iterator ==
            // c
            if (inlayList.get(iterator) != null
                    && inlayList.get(iterator).equals(c))
            {
                // SET retValue to true
                retValue = true;
            }
            // END IF
        }
        // END FOR

        // RETURN retValue
        return retValue;
    }

    /**
     * Verifies that three given Cards constitute a set
     * 
     * @param card1
     *            first Card
     * @param card2
     *            second Card
     * @param card3
     *            third Card
     * @return true if the three Cards constitute a set false if the three Cards
     *         do not constitute a set
     */
    public boolean checkForSet(Card card1, Card card2, Card card3)
    {
        // SET isSet to true
        boolean isSet = true;

        // IF card1 and card2 and card3 are null
        if (card1 == null || card2 == null || card3 == null)
        {
            // SET isSet to false
            isSet = false;
        }
        // ELSE IF card1 == card2 and card2 == card3 and card1 == card3
        else if (card1.equals(card2) && card2.equals(card3)
                && card1.equals(card3))
        {
            // SET isSet to false
            isSet = false;
        }

        // ELSE
        else
        {
            // SET isSet to the AND of the return value of isFeatureSet with
            // each cards color
            isSet &=
                    isFeatureSet(card1.getColor(), card2.getColor(), card3
                            .getColor());
            // SET isSet to the AND of the return value of isFeatureSet with
            // each cards shape
            isSet &=
                    isFeatureSet(card1.getShape(), card2.getShape(), card3
                            .getShape());
            // SET isSet to the AND of the return value of isFeatureSet with
            // each cards fill
            isSet &=
                    isFeatureSet(card1.getFill(), card2.getFill(), card3
                            .getFill());
            // SET isSet to the AND of the return value of isFeatureSet with
            // each cards number
            isSet &=
                    isFeatureSet(card1.getNumber(), card2.getNumber(), card3
                            .getNumber());
        }
        // END IF

        // RETURN isSet
        return isSet;
    }

    /**
     * Compares three enumerations and return true if they are all different or
     * all the same.
     * 
     * @param e1
     *            the first enum
     * @param e2
     *            the second enum
     * @param e3
     *            the third enum
     * @return true if all enumerations are the same or all different false
     *         otherwise
     */

    @SuppressWarnings("unchecked")
    private boolean isFeatureSet(Enum e1, Enum e2, Enum e3)
    {
        // SET isFeatureSet to false
        boolean isFeatureSet = false;

        // IF e1 and e2 and e3 are not all equal
        if (e1 != e2 && e1 != e3 && e2 != e3)
        {
            // SET isFeatureSet to true
            isFeatureSet = true;
        }
        // END IF

        // IF e1 and e2 and e3 are all equal
        if (e1 == e2 && e2 == e3)
        {
            // SET isFeatureSet to true
            isFeatureSet = true;
        }

        // RETURN isFeatureSet
        return isFeatureSet;
    }

    /**
     * Makes the string that gives reasons that the set is valid or invalid
     * 
     * @param set
     *            true if set is valid false if set is invalid
     * @return a string of why/why not it is a set
     */
    private String getReasons(boolean set)
    {
        // SET retString to an empty string
        String retString = "";

        // Get all of the cards from the in-lay
        Card c1 = getInlayCard(new Natural(0));
        Card c2 = getInlayCard(new Natural(1));
        Card c3 = getInlayCard(new Natural(2));

        // IF the colors break the set
        if (!isFeatureSet(c1.getColor(), c2.getColor(), c3.getColor()))
        {
            // IF first two cards are matching
            if (c1.getColor() == c2.getColor())
            {
                // SET retString to corresponding message
                retString =
                  retString
                    + "COLOR: Bottom card does not match the top and middle\n";
            }
            // ELSE IF first and last cards are matching
            else if (c1.getColor() == c3.getColor())
            {
                // SET retString to corresponding message
                retString =
                  retString
                    + "COLOR: Middle card does not match the top and bottom\n";
            }
            // ELSE IF second and third cards are matching
            else if (c2.getColor() == c3.getColor())
            {
                // SET retString to corresponding message
                retString =
                 retString
                  + "COLOR: Top card does not match the middle and bottom\n";
            }
            // END IF
        }
        // IF fill do make a set
        if (!isFeatureSet(c1.getFill(), c2.getFill(), c3.getFill()))
        {
            // IF first two cards are matching
            if (c1.getFill() == c2.getFill())
            {
                // SET retString to corresponding message
                retString =
                 retString
                  + "FILL: Bottom card does not match the top and middle\n";
            }
            // ELSE IF first and last cards are matching
            else if (c1.getFill() == c3.getFill())
            {
                // SET retString to corresponding message
                retString =
                 retString
                   + "FILL: Middle card does not match the top and bottom\n";
            }
            // ELSE IF second and third cards are matching
            else if (c2.getFill() == c3.getFill())
            {
                // SET retString to corresponding message
                retString =
                 retString
                   + "FILL: Top card does not match the middle and bottom\n";
            }
            // END IF
        }
        // IF number make a set
        if (!isFeatureSet(c1.getNumber(), c2.getNumber(), c3.getNumber()))
        {
            // IF first two cards are matching
            if (c1.getNumber() == c2.getNumber())
            {
                // SET retString to corresponding message
                retString =
                 retString
                  + "NUMBER: Bottom card does not match the top and middle\n";
            }
            // ELSE IF first and last cards are matching
            else if (c1.getNumber() == c3.getNumber())
            {
                // SET retString to corresponding message
                retString =
                 retString
                   + "NUMBER: Middle card does not match the top and bottom\n";
            }
            // ELSE IF second and third cards are matching
            else if (c2.getNumber() == c3.getNumber())
            {
                // SET retString to corresponding message
                retString =
                 retString
                   + "NUMBER: Top card does not match the middle and bottom\n";
            }
            // END IF
        }
        // IF shapes make a set
        if (!isFeatureSet(c1.getShape(), c2.getShape(), c3.getShape()))
        {
            // IF first two cards are matching
            if (c1.getShape() == c2.getShape())
            {
                // SET retString to corresponding message
                retString =
                 retString
                   + "SHAPE: Bottom card does not match the top and middle\n";
            }
            // ELSE IF first and last cards are matching
            else if (c1.getShape() == c3.getShape())
            {
                // SET retString to corresponding message
                retString =
                  retString
                    + "SHAPE: Middle card does not match the top and bottom\n";
            }
            // ELSE IF second and third cards are matching
            else if (c2.getShape() == c3.getShape())
            {
                // SET retString to corresponding message
                retString =
                 retString
                   + "SHAPE: Top card does not match the middle and bottom\n";
            }
            // END IF
        }
        // END IF


        // RETURN retString
        return retString;
    }

    /**
     * Produces a String explaining why or why not the set in the in-lay does or
     * does not constitute a proper set.
     * 
     * @precondition The in-lay must contain 3 Cards
     * @return String explaining the set.
     */
    public String explanation()
    {
        // SET explanation to an empty string
        String explanation = "";

        // SET returnString to null
        String returnString = null;

        // IF the cards in the in-lay are invalid
        if (!isInlaySet())
        {
            // IF there is not 3 cards in the in-lay are an invalid set
            if (getInlaySize().intValue() != kInlaySize)
            {
                // SET returnString to say is is not a set because there is not
                // 3 cards selected
                returnString =
                        "This is NOT a set because there are not 3 cards selected";
            }
            // ELSE the cards in the in-lay are a valid set
            else
            {
                // SET explanation to say it is not a valid set because: ...
                explanation = explanation + "This is NOT a set because:\n";

                // APPEND the resultString to explanation
                returnString = explanation + getReasons(false);
            }
            // END IF
        }

        // RETURN returnString
        return returnString;
    }

    /**
     * Moves the Card to the in-lay.
     * 
     * @param theCard :
     *            theCard to move to the in-lay.
     * @param isHint :
     *            if true than card is being moved to in-lay due to using a
     *            hint. if false than card was chosen by the player.
     * @return : true if the move to the in-lay was a success false if the move
     *         to the in-lay was a failure
     */
    public boolean moveCardToInlay(Card theCard, Boolean isHint)
    {
        // CREATE a boolean retValue = false
        boolean retValue = false;

        // CREATE an index int
        int index;

        // IF isHint equals false /*Card is being moved by user clicking Card*/
        if (!isHint)
        {
            // SET index to return value of cardToIndex(theCard)
            index = cardToIndex(theCard);

            // IF index >= 0 AND index < size of cardList
            if (index >= 0 && index < cardList.size())
            {
                // FOR size of board
                for (int iterator = 0; iterator < kInlaySize; iterator++)
                {
                    // IF current card is null
                    if (inlayList.get(iterator) == null)
                    {
                        inlayList.set(iterator, cardList.get(index));

                        // SET returnInlayToBoard[iterator] to index
                        returnInlayToBoard[iterator] = index;

                        // REMOVE the card at cardList[index]
                        cardList.set(index, null);

                        // SET canUseHint to false
                        canUseHint = false;

                        // SET retValue = true
                        retValue = true;
                    }
                }
            }
        }
        // ELSE
        else
        {
            // IF boardContainsSet()
            if (boardContainsSet())
            {
                // SET index to hintList at hintIndex position and increment
                // hintIndex
                index = hintList[hintIndex++];

                // FOR inlay size
                for (int iterator = 0; iterator < kInlaySize; iterator++)
                {
                    // IF current card is null
                    if (inlayList.get(iterator) == null)
                    {
                        inlayList.set(iterator, cardList.get(index));

                        // SET returnInlayToBoard[iterator] to index
                        returnInlayToBoard[iterator] = index;

                        // REMOVE the card at cardList[index]
                        cardList.set(index, null);

                        // SET retValue = true
                        retValue = true;
                    }
                }
            }
            // END IF
        }

        // RETURN retValue
        return retValue;
    }

    /**
     * Moves a Card from a set on the board to the in-lay.
     * 
     * @return true if the move to the in-lay was a success false if the move to
     *         the in-lay was a failure
     */
    public boolean doHint()
    {
        // CREATE a boolean retValue = false
        boolean retValue = false;

        // IF boardContainsSet()
        if (boardContainsSet() && canUseHint)
        {
            // SET index to hintList at position hintIndex
            int index = hintList[hintIndex];

            // IF index >= 0
            if (index >= 0)
            {
                // SET retValue to return value of moveCardToInlay with params
                // of cardList @ index & true
                retValue = moveCardToInlay(cardList.get(index), true);
            }
            // END IF
        }
        // END IF

        // RETURN retValue
        return retValue;
    }

    /**
     * Returns the amount of Cards in the in-lay at the current time.
     * 
     * @return the amount of Cards in the in-lay.
     */
    public Natural getInlaySize()
    {
        int theSize = 0;

        // IF fist position of inlayList != null
        if (inlayList.get(0) != null)
        {
            // INCREMENT theSize
            theSize++;
        }
        // END IF

        // IF second position of inlayList != null
        if (inlayList.get(1) != null)
        {
            // INCREMENT theSize
            theSize++;
        }
        // END IF

        // IF third position of inlayList != null
        if (inlayList.get(2) != null)
        {
            // INCREMENT theSize
            theSize++;
        }
        // END IF

        // RETURN a Natural of theSize
        return new Natural(theSize);
    }

    /**
     * Returns true if the Cards in the in-lay constitute a set. Returns false
     * if the Cards in the in-lay do not constitute a set.
     * 
     * @return true if there is a set in the in-lay. false if there is not a set
     *         in the in-lay.
     */
    public boolean isInlaySet()
    {
        // CREATE a boolean retValue = false
        boolean retValue = false;

        // SET isSet to the return value of checkForSet() with parameters:
        // inlayList[0],inlayList[1],inlayList[2]
        if (getInlaySize().intValue() == kInlaySize)
        {
            // SET retValue to return value of checkForSet with params each card
            // in inlay
            retValue =
                    checkForSet(inlayList.get(0), inlayList.get(1), inlayList
                            .get(2));
        }
        // END IF

        // RETURN retVAlue
        return retValue;
    }

    /**
     * Returns true if there are Cards that constitute a set. Returns false if
     * there are not any Cards that constitute a set. The Cards that are used to
     * test for a set come from both the in-lay and the game board or all the
     * Cards that are currently in play.
     * 
     * @return true if the game board contains a set. false if the game board
     *         does not contain a set.
     */
    public boolean boardContainsSet()
    {
        // CREATE a boolean retValue = true
        boolean retValue = true;

        // IF isSet equals -1 THEN
        if (hintList[0] < 0)
        {
            // SET retValue = false
            retValue = false;
        }
        // END IF

        // RETURN retVAlue
        return retValue;
    }

    /**
     * Removes all entries in the hintList
     */
    private void clearHintList()
    {
        // FOR iterator=0 to iterator=3
        for (int iterator = 0; iterator < kInlaySize; iterator++)
        {
            // SET entry in hintList at position iterator to -1
            hintList[iterator] = -1;
        }
        hintIndex = 0;
        // END FOR
    }

    /**
     * Makes a set from the Cards on the game board and stores the index of each
     * Card in the set in hintList
     * 
     * @return true if there is a set on the board false if there is not a set
     *         on the board
     */
    private boolean makeSet()
    {
        // CREATE a boolean retValue = false
        boolean retValue = false;

        // SET isSet to false
        boolean isSet = false;

        // SET first to 0
        // SET second to 1
        // SET third to 2
        int first, second, third;

        // SET hintIndex to 0
        hintIndex = 0;

        // FOR first to first = amount of Cards on board
        for (first = 0; first < cardList.size() && !retValue; first++)
        {
            // FOR second to second = amount of Cards on board
            for (second = 1; second < cardList.size() && !retValue; second++)
            {
                // FOR third to third = amount of Cards on board
                for (third = 2; third < cardList.size() && !retValue; third++)
                {
                    // SET isSet to return value of checkForSet() with
                    // parameters: cardList[first], cardList[second],
                    // cardList[third].
                    isSet =
                            checkForSet(cardList.get(first), cardList
                                    .get(second), cardList.get(third));

                    // IF isSet equals true
                    if (isSet)
                    {
                        // IF hintIndex is not greater than 2
                        if (!(hintIndex > 2))
                        {
                            // SET hintList[hintIndex] to first
                            hintList[hintIndex++] = first;

                            // SET hintList[hintIndex] to second
                            hintList[hintIndex++] = second;

                            // SET hintList[hintIndex] to third
                            hintList[hintIndex] = third;

                            // SET retValue = true
                            retValue = true;
                        }
                        // END IF
                    }
                    // END IF
                }
                // END FOR
            }
            // END FOR
        }
        // END FOR

        // SET hintIndex to 0
        hintIndex = 0;

        // RETURN retVAlue
        return retValue;
    }

    /**
     * Returns the index of the Card in the game board.
     * 
     * @param theCard
     *            to find the index of.
     * @return index of the Card in the game board.
     */
    private int cardToIndex(Card theCard)
    {
        // CREATE an integer retValue = -1
        int retValue = -1;

        // FOR each Card in the cardList array
        for (int iterator = 0; iterator < cardList.size(); iterator++)
        {
            // IF theCard equals cardList[iterator]
            if (cardList.get(iterator) != null
                    && cardList.get(iterator).equals(theCard))
            {
                // SET retValue = iterator
                retValue = iterator;
                // break;
            }
            // END IF
        }
        // END FOR

        // RETURN retValue
        return retValue;
    }

    /**
     * Resets board status because a set has been found.
     */
    private void resetBoardStatus()
    {
        // SET hintIndex to 0
        hintIndex = 0;

        // SET each index in returnInlayToBoard to -1
        returnInlayToBoard[0] = -1;
        returnInlayToBoard[1] = -1;
        returnInlayToBoard[2] = -1;

        // CALL clearHintList
        clearHintList();

        // CALL initializeInlay
        initializeInlay();

        // CALL makeSet
        makeSet();
    }

    /**
     * Removes all Cards from in-lay due to a player getting a correct set
     */
    public void clearSetFromInlay()
    {
        // CALL addThreeMore
        addThreeMore();

        // SET each index in inlayList to null
        inlayList.set(0, null);
        inlayList.set(1, null);
        inlayList.set(2, null);

        // SET canUseHint to true
        canUseHint = true;

        // SET hintIndex to 0
        hintIndex = 0;

        // CALL resetBoardStatus
        resetBoardStatus();
    }

    /**
     * Moved one Card from in-lay back to original position on the game board
     * 
     * @param theCard
     *            is the Card to be moved back to the game board
     */
    public void moveInlayCardToBoard(Card theCard)
    {
        // CREATE index variable
        int index;

        // FOR iterator=0 to iterator = size of inlayList
        for (int iterator = 0; theCard != null && iterator < kInlaySize; iterator++)
        {
            //IF current card equals the card passed in
            if (theCard.equals(inlayList.get(iterator)))
            {
                // SET index to value in returnInlayToBoard at iterator
                index = returnInlayToBoard[iterator];

                // SET cardList to theCard at index
                cardList.set(index, theCard);

                // SET inlayList to null at current position
                inlayList.set(iterator, null);
            }
        }
        // END FOR

        // IF size of inlay is 0
        if (getInlaySize().intValue() == 0)
        {
            // SET canUseHint to true
            canUseHint = true;

            // SET hintIndex to 0
            hintIndex = 0;
        }
        // END IF
    }

    /**
     * Computes the amount of cards on the game board
     * 
     * @return the amount of cards in the game board
     */
    public Natural getBoardSize()
    {
        // RETURN a Natural with size of cardList
        return new Natural(cardList.size());
    }

    /**
     * Moves Cards from in-lay back to original position on the game board.
     */
    public void returnInlayToBoard()
    {
        // CREATE index variable
        int index;
        int iterator = kInlaySize - 1;

        // WHILE iterator is greater than 0
        while (iterator >= 0)
        {
            // SET index to returnInlayToBoard[iterator]
            index = returnInlayToBoard[iterator];

            // SET returnInlayToBoard at index iterator to -1
            returnInlayToBoard[iterator] = -1;

            // SET cardList[index] to inlayList[iterator]
            cardList.set(index, inlayList.get(iterator));

            // SET inlayList[iterator] to null
            inlayList.set(iterator, null);

            // DECREMENT iterator
            iterator--;
        }
        // END WHILE

        // SET canUseHint to true
        canUseHint = true;

        // SET hintIndex to 0
        hintIndex = 0;
    }
}
