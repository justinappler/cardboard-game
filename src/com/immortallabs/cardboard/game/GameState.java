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
        // CREATE a new SetsBoard and assign it to gameBoard
        gameBoard = new SetsBoard(false, debug);

        // CREATE a new SoundPlayer and assign it to soundPlayer
        soundPlayer = new SoundPlayer();

        // CREATE a new Timer and assign it to gameTimer
        gameTimer = new Timer();

        // CALL gameTimer's pause()
        gameTimer.pause();

        // CALL gameTimer's addObserver using this class as the argument
        gameTimer.addObserver(this);

        // CREATE a new CardBoardPreferences and assign it to prefs
        prefs = CardBoardPreferences.getInstance();

        // SET this' debug to debug
        this.debug = debug;

        // SET gameType to SINGLE
        gameType = GAMETYPE.SINGLE;

        // SET numPlayers to ONE
        numPlayers = PLAYERCOUNT.ONE;

        // SET gameState to WELCOME
        gameState = GAMESTATE.WELCOME;

        // SET the buzzedPlayer to null
        buzzedPlayer = null;
        
        // SET the last explanation to an empty string;
        lastExplanation = "";
    }

    /**
     * Updates the game state when an observed object has been changed.
     * Currently, this method only monitors the Timer class for expiration.
     * 
     * @param observed The object being observed for changes
     * @param argument The argument passed from the observed object
     */
    public void update(Observable observed, Object argument)
    {
        // IF observed is a Timer THEN
        if (observed instanceof Timer && gameTimer.isExpired())
        {
            // CALL handleTimerExpiration()
            handleTimerExpiration();
        }
        // END IF
    }

    /**
     * Returns the SetsBoard for the current game state.
     * 
     * @return The SetsBoard for the current game state
     */
    public SetsBoard getBoard()
    {
        // RETURN gameBoard
        return gameBoard;
    }

    /**
     * Returns the Timer for the current games state.
     * 
     * @return The Timer for the current games state
     */
    public Timer getTimer()
    {
        // RETURN gameTimer
        return gameTimer;
    }

    /**
     * Returns the Score for the specified player.
     * 
     * @param player The player to return the score of
     * @return The Score of the given player
     */
    public Score getScore(PLAYER player)
    {
        // CREATE a Score reference requestedScore
        Score requestedScore = null;

        // IF the given player is in the game
        if (player.ordinal() <= numPlayers.ordinal())
        {
            // SET the requestedScore to the score of the requested PLAYER
            requestedScore = scores[player.ordinal()];
        }

        // RETURN requestedScore
        return requestedScore;
    }

    /**
     * Returns the CardBoardPreferences for the current game state.
     * 
     * @return The CardBoardPreferences for the current game state.
     */
    public CardBoardPreferences getPreferences()
    {
        // RETURN prefs
        return prefs;
    }

    /**
     * Sets the User Interface for the logic to use to request and provide
     * information to the user.
     * 
     * @param gameUI The class implementing CardBoardUI to use
     */
    public void setUserInterface(CardBoardUI gameUI)
    {
        // SET this's ui to the passed ui
        this.ui = gameUI;
    }

    /**
     * Processes a game interaction from the user and consequently updates the
     * game's internal state to reflect the action that occurred.
     * 
     * @param action  The User Action to process
     */
    public void processAction(ACTION action)
    {
        // CASE action OF
        switch (action)
        {
            // CONDITION NEW_SOLITAIRE_GAME
            case NEW_SOLITAIRE_GAME:
                // CALL startNewSinglePlayer()
                startNewSinglePlayer();
                break;
            // CONDITION NEW_COMPETITIVE_GAME
            case NEW_COMPETITIVE_GAME:
                // CALL startNewCompetitive()
                startNewCompetitive();
                break;
            // CONDITION NEW_MULTIPLAYER_GAME
            case NEW_MULTIPLAYER_GAME:
                // CALL startNewMultiplayer()
                startNewMultiplayer();
                break;
            case NEW_BEGINNER_GAME:
                // CALL startNewBeginner()
                startNewBeginner();
                break;
            // CONDITION CARD_SELECT
            case CARD_SELECT:
                // CALL boardCardSelect()
                cardSelect();
                break;
            // CONDITION PAUSE
            case PAUSE:
                // CALL pauseGame()
                pauseGame();
                break;
            // CONDITION UNPAUSE
            case UNPAUSE:
                // CALL unpauseGame()
                unpauseGame();
                break;
            // CONDITION THREE_MORE
            case THREE_MORE:
                // CALL addThreeMoreCards()
                addThreeMoreCards();
                break;
            // CONDITION HINT
            case HINT:
                // CALL useHint()
                useHint();
                break;
            // CONDITION EXPLANATION
            case EXPLANATION:
                // CALL explainSet()
                showExplanation();
                break;
            // CONDITION P1_BUZZED_IN
            case P1_BUZZED_IN:
                // CALL buzz() with player ONE
                buzz(PLAYER.PLAYER1);
                break;
            // CONDITION P2_BUZZED_IN
            case P2_BUZZED_IN:
                // CALL buzz() with player TWO
                buzz(PLAYER.PLAYER2);
                break;
            // CONDITION P3_BUZZED_IN
            case P3_BUZZED_IN:
                // CALL buzz() with player THREE
                buzz(PLAYER.PLAYER3);
                break;
            // CONDITION P4_BUZZED_IN
            case P4_BUZZED_IN:
                // CALL buzz() with player FOUR
                buzz(PLAYER.PLAYER4);
                break;
            // CONDITION CLEAR_INLAY_ONE
            case CLEAR_INLAY_ONE:
                returnInlayCard(1);
                break;
            // CONDITION CLEAR_INLAY_TWO
            case CLEAR_INLAY_TWO:
                returnInlayCard(2);
                break;
            // DEFAULT
            default:
                // PRINT an invalid action error to error stream
                System.err.println("Invalid action (" + action.name()
                        + ") sent to GameState");
        }
        // ENDCASE
    }

    /**
     * Calls the appropriate method based on whether the selected card is on the
     * game board or in the inlay.
     */
    private void cardSelect()
    {
        // GET the selected card
        Card selectedCard = ui.getSelected();

        // IF the game hasn't been won
        if (gameState != GAMESTATE.WON)
        {
            // IF the selected card is in the inlay
            if (gameBoard.isInInlay(selectedCard))
            {
                // CALL inlayCardSelect
                inlayCardSelect();
            }
            // ELSE
            else
            {
                // CALl boardCardSelect
                boardCardSelect();
            }
        }
    }

    /**
     * Updates the state of the game after a user selected a card on the game
     * board.
     */
    private void boardCardSelect()
    {
        // CREATE a Card reference selectedCard and set it to the result of
        // the ui's getSelected()
        Card selectedCard = ui.getSelected();

        // CREATE a PLAYER selectPlayer
        PLAYER selectPlayer;

        // IF gameType is MULTI
        if (gameType == GAMETYPE.MULTI)
        {
            // SET selectPlayer to buzzedPlayer
            selectPlayer = buzzedPlayer;
        }
        // ELSE
        else
        {
            // SET selectPlayer to player1
            selectPlayer = PLAYER.PLAYER1;
        }
        // END IF

        // IF game type not multiplayer or no player is buzzed in
        if (gameType != GAMETYPE.MULTI || gameState == GAMESTATE.BUZZED)
        {
            // CALL gameBoard's moveCardToInlay with the selectedCard
            gameBoard.moveCardToInlay(selectedCard, false);

            // IF gameBoard's getInlaySize() equals 3 (INLAY_FULL) THEN
            if (gameBoard.getInlaySize().intValue() == kInlayFull)
            {
                // CALL inlay is full method
                inlayFull(selectPlayer);
            }
            // ELSE
            else
            {
                //PLAY the action acknowledged sound
                soundPlayer.playActionAcknowledged();
            }
            // END IF

            // IF there are no more sets on the board and no more cards to play
            if (gameBoard.deckEmpty() && !gameBoard.boardContainsSet())
            {
                //SET the game state to won
                gameWon();
            }
            // END IF
        }
        // ELSE is multiplayer AND not buzzed
        else
        {
            // INFORM the players that someone must buzz in
            ui.showMessage(CardBoardMessage.MUST_BUZZ_IN);
        }
        // END IF
    }

    /**
     * Updates the state of the game after a user selected a card in the inlay.
     */
    private void inlayCardSelect()
    {
        // CREATE a Card reference selectedCard and set it to the result of
        // the ui's getSelected()
        Card selectedCard = ui.getSelected();

        // IF game type not multiplayer or a player is buzzed in
        if (gameType != GAMETYPE.MULTI || gameState == GAMESTATE.BUZZED)
        {
            // Call gameBoard's moveInlayCardToBoard with the selected card
            gameBoard.moveInlayCardToBoard(selectedCard);

            //PLAY the action acknowledged sound
            soundPlayer.playActionAcknowledged();
        }
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
        // IF the inlay is a set 
        if (gameBoard.isInlaySet())
        {
            // PLAY the set found sound
            soundPlayer.playSetSuccess();
            
            // EXPLAIN why it is or isn't a set
            getExplanation();
            
            // IF the inlay wasn't filled by a multiplayer hint
            if (selectPlayer != null)
            {
                // ADD the add set bonus to the selected player's score
                scores[selectPlayer.ordinal()].modifyScore(scoreEvent.ADD_SET);
            }
            
            // SHOW the user the set found message
            ui.showMessage(CardBoardMessage.CORRECT_SET);
            
            // CALL gameBoard's clearSetFromInlay()
            gameBoard.clearSetFromInlay();
        }
        // ELSE
        else
        {
            // PLAY the set failure sound
            soundPlayer.playSetFailure();
            
            // EXPLAIN why it is or isn't a set
            getExplanation();
            
            // IF the inlay wasn't filled by a multiplayer hint
            if (selectPlayer != null)
            {
                // SUBTRACT the missed set bonus to the selected player's score
                scores[selectPlayer.ordinal()].modifyScore(scoreEvent.MISS_SET);
            }
            
            // SHOW the user the invalid set message
            ui.showMessage(CardBoardMessage.INVALID_SET);
            
            // CALL gameBoards's returnInlaytoBoard()
            gameBoard.returnInlayToBoard();
        }
        
        // IF its a multiplayer game
        if (gameType == GAMETYPE.MULTI)
        {
            // TELL the timer to end the buzz in
            gameTimer.buzzDone();
            
            // CLEAR the buzzed in player
            buzzedPlayer = null;

            // STOP displaying the buzzed in player
            ui.displayBuzzedPlayer(buzzedPlayer);
            
            // SET the gamestate back to running
            gameState = GAMESTATE.RUNNING;
            
            // CALL timer's resume
            gameTimer.resume();
        }
        // ELSE IF its a competitive game
        else if (gameType == GAMETYPE.COMPETITIVE)
        {
            // RESTART countdown timer
            startCountdown();
        }
        
    }

    /** 
     * Return the card at the given inlay index to the board
     * 
     * @param index
     *          The index of the inlay card to return
     */
    private void returnInlayCard(int index)
    {
        // IF the passed index is a valid inlay index (1 or 2)
        if (index == 1 || index == 2)
        {
            // GET the card at the given inlay index
            Card inlayCard = gameBoard.getInlayCard(new Natural(index - 1));
            
            // IF there is a card in the inlay position
            //    AND game type is not multiplayer or a player is buzzed in
            if (inlayCard != null 
                    && (gameType != GAMETYPE.MULTI || gameState == GAMESTATE.BUZZED))
            {
                // Call gameBoard's moveInlayCardToBoard with the selected card
                gameBoard.moveInlayCardToBoard(inlayCard);

                //PLAY the action acknowledged sound
                soundPlayer.playActionAcknowledged();
            }
            // END IF
        }
    }

    /**
     * Starts a new Single Player Game, clearing the current game
     */
    private void startNewSinglePlayer()
    {
        // CREATE a new Score and assign it to player1
        scores = new Score[PLAYERCOUNT.ONE.getPlayerCount()];
        scores[0] = new Score();

        // SET gameState to RUNNING
        gameState = GAMESTATE.RUNNING;

        // SET gameType to SINGLE
        gameType = GAMETYPE.SINGLE;

        // SET numPlayers to ONE
        numPlayers = PLAYERCOUNT.ONE;

        // CREATE a new SetsBoard
        gameBoard = new SetsBoard(false, debug);

        // SET the buzzedPlayer to null
        buzzedPlayer = null;

        // CREATE a new game timer
        gameTimer = new Timer();
        
        // CALL gameTimer's addObserver using this class as the argument
        gameTimer.addObserver(this);
        
        // CALL timer's startCountUp()
        gameTimer.startCountUp();
    }

    /**
     * Starts a new Single Player Game in Beginner Mode, clearing the current
     * game.
     */
    private void startNewBeginner()
    {
        // CREATE a new Score and assign it to player1
        scores = new Score[PLAYERCOUNT.ONE.getPlayerCount()];
        scores[0] = new Score();

        // SET gameState to RUNNING
        gameState = GAMESTATE.RUNNING;

        // SET gameType to SINGLE
        gameType = GAMETYPE.SINGLE;

        // SET numPlayers to ONE
        numPlayers = PLAYERCOUNT.ONE;

        // CREATE a new SetsBoard
        gameBoard = new SetsBoard(true, debug);

        // SET the buzzedPlayer to null
        buzzedPlayer = null;

        // CREATE a new game timer
        gameTimer = new Timer();
        
        // CALL gameTimer's addObserver using this class as the argument
        gameTimer.addObserver(this);
        
        // CALL timer's startCountUp()
        gameTimer.startCountUp();
    }

    /**
     * Starts a new Competitive Mode Game, clearing the current game
     */
    private void startNewCompetitive()
    {
        // CREATE a new Score and assign it to player1
        scores = new Score[PLAYERCOUNT.ONE.getPlayerCount()];
        scores[0] = new Score();

        // SET gameState to RUNNING
        gameState = GAMESTATE.RUNNING;

        // SET gameType to COMPETITIVE
        gameType = GAMETYPE.COMPETITIVE;

        // SET numPlayers to ONE
        numPlayers = PLAYERCOUNT.ONE;

        // CREATE a new SetsBoard and assign it to gameBoard
        gameBoard = new SetsBoard(false, debug);

        // SET the buzzedPlayer to null
        buzzedPlayer = null;

        // CREATE a new game timer
        gameTimer = new Timer();
        
        // CALL gameTimer's addObserver using this class as the argument
        gameTimer.addObserver(this);
        
        // CALL startCountdown
        startCountdown();
    }

    /**
     * Starts a new Multiplayer Game, clearing the current game
     */
    private void startNewMultiplayer()
    {
        // SET numPlayers to the player count
        numPlayers = getPlayerCount();

        // CREATE a new scores array
        scores = new Score[numPlayers.getPlayerCount()];

        // FOR each score in the scores array
        for (int index = 0; index < numPlayers.getPlayerCount(); index++)
        {
            // CREATE a new Score class and assign it to the index in the array
            scores[index] = new Score();
        }
        // END FOR

        // SET gameState to RUNNING
        gameState = GAMESTATE.RUNNING;

        // SET gameType to MULTIPLAYER
        gameType = GAMETYPE.MULTI;
        
        // SET the buzzed player to null
        buzzedPlayer = null;

        // CREATE a new SetsBoard and assign it to gameBoard
        gameBoard = new SetsBoard(false, debug);

        // CREATE a new game timer
        gameTimer = new Timer();
        
        // CALL gameTimer's addObserver using this class as the argument
        gameTimer.addObserver(this);
        
        // CALL timer's startCountUp()
        gameTimer.startCountUp();
    }

    /**
     * Pauses the current game
     */
    private void pauseGame()
    {
        //IF the state is not currently WON
        if (gameState != GAMESTATE.WON)
        {
            // SET the game state to PAUSED
            gameState = GAMESTATE.PAUSED;
    
            // CALL timer's pause()
            gameTimer.pause();
        }
    }

    /**
     * UnPauses the current game
     */
    private void unpauseGame()
    {
        //IF the state is not currently WON
        if (gameState != GAMESTATE.WON)
        {
            // IF there is a buzzed player
            if (buzzedPlayer != null)
            {
                // RESET the state to BUZZED
                gameState = GAMESTATE.BUZZED;
            }
            // ELSE
            else
            {
                // SET the game state to RUNNING
                gameState = GAMESTATE.RUNNING;
            }
            // END IF
    
            // CALL timer's resume();
            gameTimer.resume();
        }
    }

    /**
     * Gets the timer value from preferences and then starts the countdown timer
     * using the value obtained.
     */
    private void startCountdown()
    {
        // GET the timer value preference from Preferences
        String countdownTime =
                prefs.getPreference(CardBoardPreferences.PREF.TIME_LIMIT);

        // SET a new time limit value to unlimited time
        TIMER_LIMIT limit = TIMER_LIMIT.TIME_UNLIMITED;
        try
        {
            // TRY to set the time limit to the preferences value
            limit = TIMER_LIMIT.valueOf(countdownTime);
        }
        catch (IllegalArgumentException exception)
        {
        }

        // CALL timer's startCountDown() with the timer countdown value
        gameTimer.startCountdown(limit);
    }

    /**
     * Updates the game state when the timer expires at the end of a countdown.
     * If the current game is multiplayer, the player buzzed in loses points for
     * not completing a set in time. If the game is competitive, the player
     * loses points for running out of time before finding a set.
     */
    private void handleTimerExpiration()
    {
        // PLAY a failed set sound
        soundPlayer.playSetFailure();
        
        // IF gameType is MULTI THEN
        if (gameType == GAMETYPE.MULTI)
        {
            // CALL score's modifyScore() with TIME_OUT on buzzedPlayer's score
            scores[buzzedPlayer.ordinal()].modifyScore(scoreEvent.TIME_OUT);

            // END the timer buzz in
            gameTimer.buzzDone();

            // CLEAR the buzzed in player
            buzzedPlayer = null;

            // STOP displaying the buzzed in player
            ui.displayBuzzedPlayer(buzzedPlayer);
            
            // IF there are cards in the inlay
            if (gameBoard.getInlaySize().intValue() > 0)
            {
                // RETURN any cards in the inlay to the board
                gameBoard.returnInlayToBoard();
            }
            
            // CALL ui's showExpirationPenalty() with an expired timer message
            ui.showMessage(CardBoardMessage.TIMER_EXPIRATION);
            
            // CALL timer's resume
            gameTimer.resume();
        }
        // ELSE (competitive mode)
        else
        {
            // CALL score's modifyScore() with TIME_OUT on player1
            scores[PLAYER.PLAYER1.ordinal()].modifyScore(scoreEvent.TIME_OUT);

            // IF the inlay is not empty
            if (gameBoard.getInlaySize().intValue() != 0)
            {
                // RETURN all cards to the board
                gameBoard.returnInlayToBoard();
            }
            
            // IF doing a hint succeeds
            if (gameBoard.doHint())
            {
                // DO the second hint
                gameBoard.doHint();
                
                // DO the third hint
                gameBoard.doHint();
                
                // INFORM the user that the timer expired
                ui.showMessage(CardBoardMessage.TIMER_EXPIRATION);
                
                // CLEAR the inlay
                gameBoard.clearSetFromInlay();
            }
            // ELSE
            else
            {
                // INFORM the user the timer expired and there wasn't a set
                ui.showMessage(CardBoardMessage.NO_SET_TIMER_EXPIRATION);
            }
            // END IF
            
            // CALL startCountdown()
            startCountdown();
        }
        // END IF

        // SET the gameState to RUNNING
        gameState = GAMESTATE.RUNNING;
    }

    /**
     * Returns the player count from preferences
     * 
     * @return the player count
     */
    private PLAYERCOUNT getPlayerCount()
    {
        // GET the player count preference from GameBoardPreferences
        String playerCount =
                prefs.getPreference(CardBoardPreferences.PREF.PLAYERS);

        // SET a new player count value to 2
        PLAYERCOUNT count = PLAYERCOUNT.TWO;
        try
        {
            // TRY to set the player count to the preferences value
            count = PLAYERCOUNT.valueOf(playerCount);
        }
        catch (IllegalArgumentException exception)
        {
        }

        // RETURN the player count
        return count;
    }

    /**
     * Attempts to add 3 more cards to the game board. If the game board
     * currently has a set, causes a score reduction and doesn't change the
     * board. In multiplayer, there is no score reduction.
     */
    private void addThreeMoreCards()
    {
        // IF the gameState is RUNNING
        if (gameState == GAMESTATE.RUNNING)
        {
            // IF the gameType not multiplayer
            if (gameType != GAMETYPE.MULTI)
            {
                // IF gameBoard's boardContainsSet THEN
                if (gameBoard.boardContainsSet())
                {
                    // EXPLAIN that there are still 3 more cards left
                    ui.showMessage(CardBoardMessage.THREE_MORE_WHILE_SET);
                    
                    // CALL player1's modifyScore() with THREE_MORE_PENALTY
                    scores[PLAYER.PLAYER1.ordinal()]
                            .modifyScore(scoreEvent.THREE_MORE);
                }
                // ELSE
                else
                {
                    // CALL gameBoard's addThreeMore()
                    gameBoard.addThreeMore();
                    
                    // INFORM the ui that an internal state change occured
                    ui.redraw();
                }
                // END IF
            }
            // ELSE
            else
            {
                // IF NOT gameBoard's boardContainsSet THEN
                if (!gameBoard.boardContainsSet())
                {
                    // CALL gameBoard's addThreeMore()
                    gameBoard.addThreeMore();
                    
                    // INFORM the ui that an internal state change occured
                    ui.redraw();
                }
                // ELSE
                else
                {
                    // INFORM the user that there is a set on the board
                    ui.showMessage(CardBoardMessage.THREE_MORE_WHILE_SET);
                }
                // END IF
            }
            // END IF
        }
        // END IF
    }

    /**
     * Attempts to use a Hint to find the next card in the Set. If the current
     * game is Competitive, no action is taken.
     */
    private void useHint()
    {
        // IF the gameState is RUNNING THEN
        if (gameState == GAMESTATE.RUNNING)
        {
            // IF the gameType is SINGLE THEN
            if (gameType == GAMETYPE.SINGLE)
            {
                // IF gameBoard's doHint() is true (there is a set on the board)
                if(gameBoard.doHint())
                {
                    // CALL player1's modifyScore with HINT
                    scores[PLAYER.PLAYER1.ordinal()]
                           .modifyScore(scoreEvent.HINT);
                }
                // ELSE
                else
                {
                    // IF the board contains a set
                    if (gameBoard.boardContainsSet())
                    {
                        // EXPLAIN that a hint can't be used
                        ui.showMessage(CardBoardMessage.CANNOT_USE_HINT);
                    }
                    // ELSE
                    else
                    {
                        // EXPLAIN that there was no hint to be had
                        ui.showMessage(CardBoardMessage.NO_SET_ON_BOARD);
                    }
                }
                
                // IF the inlay is full
                if (gameBoard.getInlaySize().intValue() == kInlayFull)
                {
                    // CALL inlayFull method with player 1
                    inlayFull(PLAYER.PLAYER1);
                }

            }
            // ELSE IF the gameType is MULTI THEN
            else if (gameType == GAMETYPE.MULTI)
            {
                // IF using a hint fails
                if (!gameBoard.doHint())
                {
                    // EXPLAIN that there was no hint to be had
                    ui.showMessage(CardBoardMessage.NO_SET_ON_BOARD);
                }
                

                // IF the inlay is full
                if (gameBoard.getInlaySize().intValue() == kInlayFull)
                {
                    // CALL inlayFull method with no player
                    inlayFull(null);
                }
            }
            // ELSE gametype is multiplayer
            else
            {
                // SHOW a message stating that you cannot use a hint
                ui.showMessage(CardBoardMessage.NO_HINT_IN_COMPETITIVE);
            }
            // END IF
            
            // IF the deck is empty and the board has no set
            if (gameBoard.deckEmpty() && !gameBoard.boardContainsSet())
            {
                // SET the game to won
                gameWon();
            }
        }
        // END IF
    }

    /**
     * Sets the game state to won and notifies the player of their
     * success
     */
    private void gameWon()
    {
        //PLAY the game won sound
        soundPlayer.playWin();
        
        // IF the game is multiplayer
        if (gameType == GAMETYPE.MULTI)
        {
            // ANNOUNCE the winner's victory
            announceGameWinner();
        }
        // ELSE
        else
        {
            //ANNOUNCE the single player game is over
            ui.showMessage(CardBoardMessage.GAME_WON);
        }
        
        //PAUSE the timer
        gameTimer.pause();

        //SET the game state to WON
        gameState = GAMESTATE.WON;
    }

    /**
     * Tells the UI to announce that a player in a multiplayer game
     * has won.
     */
    private void announceGameWinner()
    {
        // CREATE a winners list for ties
        ArrayList<PLAYER> winners = new ArrayList<PLAYER>();
        
        // CREATE a winner placeholder
        PLAYER winner = PLAYER.PLAYER1;
        
        // FOR each of the players
        for (int index = 1; index < numPlayers.getPlayerCount(); index++)
        {
            // GET the winner's score
            Score winScore = scores[winner.ordinal()];
            
            // GET the other's score
            Score otherScore = scores[index];
            
            // IF the current player is greater than the winner
            if (otherScore.getScore() > winScore.getScore())
            {
                // EMPTY the winners list
                winners = new ArrayList<PLAYER>();
                
                // SET the winner to the current player
                winner = PLAYER.values()[index];
            }
            // ELSE IF the current player is equal to the winner
            else if (otherScore.getScore() == winScore.getScore())
            {
                // ADD the current player to the winners list
                winners.add(PLAYER.values()[index]);
            }
        }
        // END FOR
        
        // IF the winners list is empty
        if (winners.size() == 0)
        {
            // CREATE a new game won message
            CardBoardMessage message = CardBoardMessage.GAME_WON;
            
            // SET the message text
            message.setText(winner.toString() + " won!");
            
            // ANNOUNCE the winner won
            ui.showMessage(message);
        }
        // ELSE
        else
        {
            // ADD the first winner to the message string
            String winnersMessage = winner.toString();
            
            // FOR EACH tied player, add their name to the message
            for (PLAYER player : winners)
            {
                winnersMessage += ", " + player.toString();
            }

            // ADD the rest of the message
            winnersMessage += " all tied!";
            
            // CREATE a new game won message
            CardBoardMessage message = CardBoardMessage.GAME_WON;
            
            // SET the message text
            message.setText(winnersMessage);
            
            // ANNOUNCE the winners won
            ui.showMessage(message);
        }
        // END IF 
    }

    /**
     * Explains the inlay contents (whether it be a valid set or not) to the
     * user by providing the UI with an explanation message
     */
    private void getExplanation()
    {
        // CALL SetsBoard's explanation() method and assign it to a string
        lastExplanation = gameBoard.explanation();        
    }

    /**
     * Show the stored explanation for the last 3 cards in the inlay
     */
    private void showExplanation()
    {
        // PAUSE the game
        pauseGame();
        
        // CREATE a new explanation message
        CardBoardMessage message = CardBoardMessage.EXPLANATION;
        
        // SET the message text
        message.setText(lastExplanation);
        
        // SHOW the explanation message
        ui.showMessage(message);
    }

    /**
     * Updates the game state to reflect the given player buzzing in while
     * playing in multiplayer mode
     */
    private void buzz(PLAYER player)
    {
        // IF in multiplayer and the state is not currently buzzed in
        if (gameType == GAMETYPE.MULTI && gameState != GAMESTATE.BUZZED)
        {
            // SET buzzedPlayer to player
            buzzedPlayer = player;

            // SET the gameState to BUZZED
            gameState = GAMESTATE.BUZZED;

            // CALL timer's buzzIn()
            gameTimer.buzzIn();
            
            // SHOW the currently buzzed in player
            ui.displayBuzzedPlayer(buzzedPlayer);
        }
        // END IF
    }

    /**
     * Returns the type of the game currently in progress
     * 
     * @return The type of the current game
     */
    public GAMETYPE getGameType()
    {
        // RETURN the current game type
        return gameType;
    }
    
    /**
     * Returns a string containing information about the current game state.
     * <b>This method is for testing purposes only</b>
     * 
     * @return a string containing information about the current game state
     */
    public String getStateString()
    {
        return gameType.toString() + "," + numPlayers.toString() + ","
                + gameState.toString() + "," 
                + ((buzzedPlayer == null) ? "NONE" : buzzedPlayer.toString());
    }
}
