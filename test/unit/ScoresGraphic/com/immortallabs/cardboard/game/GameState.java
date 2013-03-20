package com.immortallabs.cardboard.game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


/**
 * <p>
 * The GameState Class models the gameplay rules of the Sets Game. In addition
 * to it's own internal gameplay policies, it utilizes classes such as SetsBoard
 * and Deck to enforce the rules of the game. It has a Deck, a Score for each
 * Player, a Timer, a set of Preferences, a set of High Scores, and a User
 * Interface from which it can query information about the user.
 * </p>
 * <b>Operations:</b>
 * <ul>
 * <li>The GameState class can provide the user interface information about the
 * game state
 * <li>The GameState class can update the game state based on user interactions
 * </ul>
 * 
 * @author Justin C. Appler
 * @author Immortal Labs, CSC309 W09
 * @version 1.3
 * @version January 10th, 2009
 * @see HighScores
 * @see Deck
 * @see CardBoardUI
 * @see SetsBoard
 * @see CardBoardPreferences
 * @history - 01/10/09 1.3 Changed Name to GameState, Updated Version/Author
 *          Info<br>
 *          - 12/04/08 1.2 ACTION Change, Conformed JavaDocs, More Pseudocoding<br>
 *          - 12/02/08 1.1 Added Version History & Pseudocode<br>
 *          - 12/01/08 1.0 Initial Class Skeleton<br>
 */
public class GameState implements Observer
{
    /**
     * The PLAYER enumeration represents the possible players (1-4) in the sets
     * game.
     */
    public enum PLAYER
    {
        /** The First Player */
        PLAYER1,

        /** The Second Player */
        PLAYER2,

        /** The Third Player */
        PLAYER3,

        /** The Fourth Player */
        PLAYER4
    }

   public void update(Observable o, Object arg)
   {
      // TODO Auto-generated method stub
      
   }

}

