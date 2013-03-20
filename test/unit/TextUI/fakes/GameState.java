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

    /** The Type of Game currently being played */
    private GAMETYPE gameType;

    /** The size of the Inlay when it is full of cards */
    private static final int kInlayFull = 3;

    /** The Number of players in the current game */
    private PLAYERCOUNT numPlayers;

    /** The state of the game currently being played */
    private GAMESTATE gameState;

    /** The player in multiplayer mode that is currently buzzed in */
    private PLAYER buzzedPlayer;

    /** The timer for the current game */
    private Timer gameTimer;

    /** The sets board for the current game */
    private SetsBoard gameBoard;

    /** The preferences for the cardboard game */
    private CardBoardPreferences prefs;

    /** The sound player for the cardboard game */
    private SoundPlayer soundPlayer;

    /** The user interface for the cardboard game */
    private CardBoardUI ui;

    /** The scores for all players in the game */
    private Score[] scores;

    /** Whether GameState is in debug or not */
    private boolean debug;
    
    /** The explanation for the last 3 cards in the inlay */
    private String lastExplanation;

    /**
     * Creates a new GameState class which subsequently creates new copies of
     * each component of the Sets Game
     * 
     * @param debug Whether or not to start in debugging mode<br>
     *            <code>true</code> causes GameState to use an unshuffled deck<br>
     *            <code>false</code> causes GameState to use a shuffled deck
     */
    public GameState(boolean debug)
    {
        gameBoard = new SetsBoard(false, debug);

        gameTimer = new Timer();

        gameTimer.pause();

        gameTimer.addObserver(this);

        prefs = CardBoardPreferences.getInstance();

        this.debug = debug;

        gameType = GAMETYPE.SINGLE;

        numPlayers = PLAYERCOUNT.ONE;

        gameState = GAMESTATE.WELCOME;

        buzzedPlayer = null;
        
        lastExplanation = "";
    }


    public void update(Observable observed, Object argument)
    {

    }


    public SetsBoard getBoard()
    {
        // RETURN gameBoard
        return gameBoard;
    }


    public Timer getTimer()
    {
        // RETURN gameTimer
        return gameTimer;
    }


    public Score getScore(PLAYER player)
    {
        return new Score();
    }


    public CardBoardPreferences getPreferences()
    {
        return prefs;
    }


    public void setUserInterface(CardBoardUI gameUI)
    {
        this.ui = gameUI;
    }


    public void processAction(ACTION action)
    {
        // CASE action OF
        switch (action)
        {
            // CONDITION NEW_SOLITAIRE_GAME
            case NEW_SOLITAIRE_GAME:
                // CALL startNewSinglePlayer()
                System.out.println("new solitaire game");
                break;
            // CONDITION NEW_COMPETITIVE_GAME
            case NEW_COMPETITIVE_GAME:
                // CALL startNewCompetitive()
                 System.out.println("new competitive game");
                break;
            // CONDITION NEW_MULTIPLAYER_GAME
            case NEW_MULTIPLAYER_GAME:
                // CALL startNewMultiplayer()
                 System.out.println("new multiplayer game");
                break;
            case NEW_BEGINNER_GAME:
                // CALL startNewBeginner()
                 System.out.println("new beginner game");
                break;
            // CONDITION CARD_SELECT
            case CARD_SELECT:
                // CALL boardCardSelect()
                System.out.println("card selected");
                break;
            // CONDITION PAUSE
            case PAUSE:
                // CALL pauseGame()
                 System.out.println("game paused");
                break;
            // CONDITION UNPAUSE
            case UNPAUSE:
                // CALL unpauseGame()
                System.out.println("game unpaused");
                break;
            // CONDITION THREE_MORE
            case THREE_MORE:
                // CALL addThreeMoreCards()
                System.out.println("three more");
                break;
            // CONDITION HINT
            case HINT:
                // CALL useHint()
                System.out.println("hint");
                break;
            // CONDITION EXPLANATION
            case EXPLANATION:
                // CALL explainSet()
                System.out.println("explanation shown");
                break;
            // CONDITION P1_BUZZED_IN
            case P1_BUZZED_IN:
                // CALL buzz() with player ONE
                System.out.println("Player1 buzzed");
                break;
            // CONDITION P2_BUZZED_IN
            case P2_BUZZED_IN:
                // CALL buzz() with player TWO
                System.out.println("Player2 buzzed");
                break;
            // CONDITION P3_BUZZED_IN
            case P3_BUZZED_IN:
                // CALL buzz() with player THREE
                System.out.println("Player3 buzzed");
                break;
            // CONDITION P4_BUZZED_IN
            case P4_BUZZED_IN:
                // CALL buzz() with player FOUR
                System.out.println("Player4 buzzed");
                break;
            // CONDITION CLEAR_INLAY_ONE
            case CLEAR_INLAY_ONE:
                System.out.println("clear inlay size one");
                break;
            // CONDITION CLEAR_INLAY_TWO
            case CLEAR_INLAY_TWO:
                System.out.println("clear inlay size two");
                break;
            // DEFAULT
            default:
                // PRINT an invalid action error to error stream
                System.err.println("Invalid action (" + action.name()
                        + ") sent to GameState");
        }
        // ENDCASE
    }

 
    private void cardSelect()
    {

    }


    private void boardCardSelect()
    {
        
    }


    private void inlayCardSelect()
    {

    }


    private void inlayFull(PLAYER selectPlayer)
    {
        
        
    }


    private void returnInlayCard(int index)
    {
        
    }


    private void startNewSinglePlayer()
    {
        
    }


    private void startNewBeginner()
    {
        
    }


    private void startNewCompetitive()
    {
        
    }


    private void startNewMultiplayer()
    {
        
    }


    private void pauseGame()
    {

    }


    private void unpauseGame()
    {
        
    }


    private void startCountdown()
    {
        
    }


    private void handleTimerExpiration()
    {
        
    }


    private PLAYERCOUNT getPlayerCount()
    {

        return null;
    }


    private void addThreeMoreCards()
    {
        
    }


    private void useHint()
    {
        
    }

 
    private void gameWon()
    {
        
    }


    private void announceGameWinner()
    {
        
    }


    private void getExplanation()
    {
      
    }

    
    private void showExplanation()
    {
        
    }


    private void buzz(PLAYER player)
    {
        
    }

    public int getCardsLeft()
    {
    	return 0;
    }


    public GAMETYPE getGameType()
    {
        return null;
    }
    

    public String getStateString()
    {
        return "";
    }
}
