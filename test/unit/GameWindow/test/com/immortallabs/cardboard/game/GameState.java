package com.immortallabs.cardboard.game;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import com.immortallabs.cardboard.CardBoardPreferences;
import com.immortallabs.cardboard.game.Score.scoreEvent;
import com.immortallabs.cardboard.game.Timer.TIMER_LIMIT;
import com.immortallabs.cardboard.ui.CardBoardUI;

import edu.profdalbey.Natural;

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
     * The ACTION enumeration represents each of the various actions the user
     * can do to interact with the game.
     */
    public enum ACTION
    {
        /** Start a new solitaire Game */
        NEW_SOLITAIRE_GAME,

        /** Start a new competitive game */
        NEW_COMPETITIVE_GAME,

        /** Start a new multiplayer game */
        NEW_MULTIPLAYER_GAME,

        /** Start a new beginner mode game */
        NEW_BEGINNER_GAME,

        /** Card on the Game Board Selected */
        CARD_SELECT,

        /** Pause Game Selected */
        PAUSE,

        /** UnPause Game Selected */
        UNPAUSE,

        /** Three More Cards Selected */
        THREE_MORE,

        /** Hint Selected */
        HINT,

        /** Set Explanation Selected */
        EXPLANATION,

        /** Player 1 Buzzed In */
        P1_BUZZED_IN,

        /** Player 2 Buzzed In */
        P2_BUZZED_IN,

        /** Player 3 Buzzed In */
        P3_BUZZED_IN,

        /** Player 4 Buzzed In */
        P4_BUZZED_IN,
        
        /** Remove first card from inlay */
        CLEAR_INLAY_ONE,
        
        /** Remove second card from inlay */
        CLEAR_INLAY_TWO
        
    };

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
    };

    /**
     * The GAMETYPE enumeration represents the various gametypes that could be
     * in play
     */
    public enum GAMETYPE
    {
        /** Single Player */
        SINGLE,

        /** Multiplayer */
        MULTI,

        /** Competitive */
        COMPETITIVE
    }

    /**
     * The PLAYERCOUNT enumeration represents the current number of players in
     * the game
     */
    private enum PLAYERCOUNT
    {
        /** 1 Player */
        ONE(1),

        /** 2 Players */
        TWO(2),

        /** 3 Players */
        THREE(3),

        /** 4 Players */
        FOUR(4);

        /** Number of players in the game */
        private int playercount;

        /**
         * Constructs a PLAYERCOUNT enumeration with the integer corresponding
         * to the number of players
         * 
         * @param playercount
         *            the number of players in the game of the given enumeration
         */
        PLAYERCOUNT(int playercount)
        {
            this.playercount = playercount;
        }

        /**
         * Gets the number of players in the game as in integer
         * 
         * @return the number of players in the game as an integer
         */
        public int getPlayerCount()
        {
            return playercount;
        }

    }

    /**
     * The GAMESTATE enumeration represents the current state of the game being
     * played
     */
    private enum GAMESTATE
    {
        /** The game is paused */
        PAUSED,

        /** The welcome message is being displayed */
        WELCOME,

        /** The game is running awaiting the user's input */
        RUNNING,

        /** A player in a multiplayer game buzzed in */
        BUZZED,
        
        /** The game has been won */
        WON
    }


    /**
     * Creates a new GameState class which subsequently creates new copies of
     * each component of the Sets Game
     * 
     * @param debug
     *            Whether or not to start in debugging mode
     *            True causes GameState to use an unshuffled deck
     *            False causes GameState to use a shuffled deck
     */
    public GameState(boolean debug)
    {

    }

    /**
     * Updates the game state when an observed object has been changed.
     * Currently, this method only monitors the Timer class for expiration.
     * 
     * @param observed
     *            The object being observed for changes
     * @param argument
     *            The argument passed from the observed object
     */
    public void update(Observable observed, Object argument)
    {

    }

    /**
     * Returns the SetsBoard for the current game state.
     * 
     * @return The SetsBoard for the current game state
     */
    public SetsBoard getBoard()
    {
       return new SetsBoard(false,true);
    }

    /**
     * Returns the Timer for the current games state.
     * 
     * @return The Timer for the current games state
     */
    public Timer getTimer()
    {
 
       return null;
    }

    /**
     * Returns the Score for the specified player.
     * 
     * @param player
     *            The player to return the score of
     * @return The Score of the given player
     */
    public Score getScore(PLAYER player)
    {
        // CREATE a Score reference requestedScore
       return null;

    }

    /**
     * Returns the CardBoardPreferences for the current game state.
     * 
     * @return The CardBoardPreferences for the current game state.
     */
    public CardBoardPreferences getPreferences()
    {
       return null;
    }

    /**
     * Sets the User Interface for the logic to use to request and provide
     * information to the user.
     * 
     * @param gameUI
     *            The class implementing CardBoardUI to use
     */
    public void setUserInterface(CardBoardUI gameUI)
    {

    }

    /**
     * Processes a game interaction from the user and consequently updates the
     * game's internal state to reflect the action that occurred.
     * 
     * @param action
     *            The User Action to process
     */
    public void processAction(ACTION action)
    {
      
    }

    /**
     * Calls the appropriate method based on whether the selected card is on the
     * game board or in the inlay.
     */
    private void cardSelect()
    {

    }

    /**
     * Updates the state of the game after a user selected a card on the game
     * board.
     */
    private void boardCardSelect()
    {

    }

    /**
     * Updates the state of the game after a user selected a card in the inlay.
     */
    private void inlayCardSelect()
    {

        // END IF
    }

    /**
     * Handles the situation in which the game board inlay is full
     * 
     * @param selectPlayer
     *            The player who added the last card
     */
    private void inlayFull(PLAYER selectPlayer)
    {

        
    }

    /** 
     * Return the card at the given inlay index to the board
     * 
     * @param index
     *          The index of the inlay card to return
     */
    private void returnInlayCard(int index)
    {

    }

    /**
     * Starts a new Single Player Game, clearing the current game
     */
    private void startNewSinglePlayer()
    {

    }

    /**
     * Starts a new Single Player Game in Beginner Mode, clearing the current
     * game.
     */
    private void startNewBeginner()
    {

    }

    /**
     * Starts a new Competitive Mode Game, clearing the current game
     */
    private void startNewCompetitive()
    {

    }

    /**
     * Starts a new Multiplayer Game, clearing the current game
     */
    private void startNewMultiplayer()
    {

    }

    /**
     * Pauses the current game
     */
    private void pauseGame()
    {
        //IF the state is not c
    }

    /**
     * UnPauses the current game
     */
    private void unpauseGame()
    {

    }

    /**
     * Gets the timer value from preferences and then starts the countdown timer
     * using the value obtained.
     */
    private void startCountdown()
    {
 
    }

    /**
     * Updates the game state when the timer expires at the end of a countdown.
     * If the current game is multiplayer, the player buzzed in loses points for
     * not completing a set in time. If the game is competitive, the player
     * loses points for running out of time before finding a set.
     */
    private void handleTimerExpiration()
    {

    }

    /**
     * Returns the player count from preferences
     * 
     * @return the player count
     */
    private PLAYERCOUNT getPlayerCount()
    {
       return PLAYERCOUNT.ONE; 
    }

    /**
     * Attempts to add 3 more cards to the game board. If the game board
     * currently has a set, causes a score reduction and doesn't change the
     * board. In multiplayer, there is no score reduction.
     */
    private void addThreeMoreCards()
    {

    }

    /**
     * Attempts to use a Hint to find the next card in the Set. If the current
     * game is Competitive, no action is taken.
     */
    private void useHint()
    {

    }

    /**
     * Sets the game state to won and notifies the player of their
     * success
     */
    private void gameWon()
    {

    }

    /**
     * Tells the UI to announce that a player in a multiplayer game
     * has won.
     */
    private void announceGameWinner()
    {

    }

    /**
     * Explains the inlay contents (whether it be a valid set or not) to the
     * user by providing the UI with an explanation message
     */
    private void getExplanation()
    {
     
    }

    /**
     * Show the stored explanation for the last 3 cards in the inlay
     */
    private void showExplanation()
    {
 
    }

    /**
     * Updates the game state to reflect the given player buzzing in while
     * playing in multiplayer mode
     */
    private void buzz(PLAYER player)
    {

    }

    /**
     * Returns the type of the game currently in progress
     * 
     * @return The type of the current game
     */
    public GAMETYPE getGameType()
    {
       return GAMETYPE.SINGLE; 
    }
    
    /**
     * Returns a string containing information about the current game state.
     * <b>This method is for testing purposes only</b>
     * 
     * @return a string containing information about the current game state
     */
    public String getStateString()
    {
       return null;

    }
}
