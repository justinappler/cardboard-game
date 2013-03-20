package com.immortallabs.cardboard.game;

import java.util.Observable;
import java.util.Observer;
import unit.ActionMap.ActionMapTestData;
import com.immortallabs.cardboard.CardBoardPreferences;
import com.immortallabs.cardboard.ui.CardBoardUI;

/**
 * --FAKE--
 * <p>The GameState Class models the gameplay rules of the Sets Game.  In addition to 
 * it's own internal gameplay policies, it utilizes classes such as SetsBoard
 * and Deck to enforce the rules of the game.  It has a Deck, a Score for
 * each Player, a Timer, a set of Preferences, a set of High Scores, and a
 * User Interface from which it can query information about the user.</p>
 * 
 * <b>Operations:</b>
 * <ul>
 * <li>The GameState class can provide the user interface information about the game
 *   state
 * <li>The GameState class can update the game state based on user interactions
 * </ul>
 * 
 * @author Thomas Dvornik
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
		
		NEW_BEGINNER_GAME,
		
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
		CLEAR_INLAY_ONE,
		CLEAR_INLAY_TWO
	};
	
	/**
	 * The PLAYER enumeration represents the possible players (1-4) in the 
	 * sets game.
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
	 * The GAMETYPE enumeration represents the various gametypes that
	 * could be in play
	 */
	private enum GAMETYPE 
	{
		/** Single Player */
		SINGLE,
		
		/** Multiplayer */
		MULTI,
		
		/** Competitive */
		COMPETITIVE
	}
	
	/**
	 * The PLAYERCOUNT enumeration represents the current number of
	 * players in the game
	 */
	private enum PLAYERCOUNT
	{
		/** 1 Player */
		ONE,
		
		/** 2 Players */
		TWO,
		
		/** 3 Players */
		THREE,
		
		/** 4 Players */
		FOUR
	}
	
	/**
	 * The GAMESTATE enumeration represents the current state of
	 * the game being played
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
		BUZZED
	}
	
	/** The Type of Game currently being played */
	private GAMETYPE gameType;
	
	/** The Number of players in the current game */
	private PLAYERCOUNT numPlayers;
	
	/** The state of the game currently being played */
	private GAMESTATE gameState;
	
	/** The player in multiplayer mode that is currently buzzed in */
	private PLAYER buzzedPlayer;
	
	/** Whether or not sounds are enabled */
	private boolean soundsOn;
	
	/** The timer for the current game */
	private Timer gameTimer;
	
	/** The sets board for the current game */
	private SetsBoard gameBoard;
	
	/** The high scores for all of this computer's cardboard games */
	private HighScores highScores;
	
	/** The preferences for the cardboard game */
	private CardBoardPreferences prefs;
	
	/** The sound player for the cardboard game */
	private SoundPlayer soundPlayer;
	
	/** The user interface for the cardboard game */
	private CardBoardUI ui;
	
	//TODO: (Known Issue) Make the following Scores an Array set to the size 
	//      of PLAYER. This makes setting and getting these values using 
	//      PLAYERs trivial and not require a switch statement
	
	/** The score for player 1 */
	private Score player1;
	
	/** The score for player 2 */
	private Score player2;
	
	/** The score for player 3 */
	private Score player3;
	
	/** The score for player 4 */
	private Score player4;
	
	
	/**
	 * Creates a new GameState class which subsequently creates new copies of each
	 * component of the Sets Game
	 */
	public GameState()
	{
		//CREATE a new HighScores and assign it to highScores
		//CREATE a new SetsBoard and assign it to gameBoard
		//CREATE a new SoundPlayer and assign it to soundPlayer
		//CREATE a new Timer and assign it to gameTimer
		//CALL gameTimer's pause()
		//CALL gameTimer's addObserver using this class as the argument
	    //CREATE a new CardBoardPreferences and assign it to prefs
	    
		//GET the sounds preference from CardBoardPreferences
		//SET soundsOn to whether or not the sounds preference is 'on'
		
		//SET gameType to SINGLE
	    //SET numPlayers to ONE
		//SET gameState to WELCOME
	}
	
	/**
	 * Returns the SetsBoard for the current game state.
	 * 
	 * @return The SetsBoard for the current game state
	 */
	public SetsBoard getBoard()
	{
		//RETURN gameBoard
		return new SetsBoard(false, false);
	}
	
	/**
	 * Returns the Timer for the current games state.
	 * 
	 * @return The Timer for the current games state
	 */
	public Timer getTimer()
	{
		//RETURN gameTimer
	    return null;
	}
	
	/**
	 * Updates the game state when an observed object has been
	 * changed.  Currently, this method only monitors the Timer
	 * class for expiration.
	 * 
	 * @param observed The object being observed for changes
	 * @param argument The argument passed from the observed object
	 */
	public void update(Observable observed, Object argument)
	{
		//IF observed is a Timer THEN
			//CALL handleTimerExpiration()
		//END IF
	}

	/**
	 * Returns the Score for the specified player.
	 * 
	 * @param player The player to return the score of
	 * @return The Score of the given player
	 */
	public Score getScore(PLAYER player)
	{
		//CREATE a Score reference requestedScore
		
	    
	    //TODO: (Known Issue) Remove this switch using the update
	    //      mentioned with the private variables that are set
	    
		//CASE player OF
			//CONDITION player1
				//SET requestedScore to the player1 score
			//CONDITION player2
				//SET requestedScore to the player2 score
			//CONDITION player3
				//SET requestedScore to the player3 score
			//CONDITION player4
				//SET requestedScore to the player4 score
	    //ENDCASE

		//RETURN requestedScore
	    return null;
	}
	
	/**
	 * Returns the CardBoardPreferences for the current game state.
	 * 
	 * @return The CardBoardPreferences for the current game state.
	 */
	public CardBoardPreferences getPreferences()
	{
		//RETURN prefs
        return null;
	}
	
	/**
	 * Returns the HighScores for the current game state.
	 * 
	 * @return The HighScores for the current Game state
	 */
	public HighScores getHighscores()
	{
		//RETURN highScores
        return null;
	}
	
	/**
	 * Sets the User Interface for the logic to use to request and provide
	 * information to the user.
	 * 
	 * @param ui The class implementing CardBoardUI to use
	 */
	public void setUserInterface(CardBoardUI ui)
	{
	    //SET this's ui to the passed ui
	}
	
	/**
	 * Processes a game interaction from the user and consequently updates the
	 * game's internal state to reflect the action that occurred.
	 * 
	 * @param action The User Action to process
	 */
	public void processAction(ACTION action)
	{
		//CASE action OF 
			//CONDITION NEW_SOLITAIRE_GAME
		if (action.equals(ACTION.NEW_SOLITAIRE_GAME)) { 
				//CALL startNewSinglePlayer()
			ActionMapTestData.add("solitare");
			//CONDITION NEW_COMPETITIVE_GAME
		} else if (action.equals(ACTION.NEW_COMPETITIVE_GAME)) {
				//CALL startNewCompetitive()
			ActionMapTestData.add("competitive");
			//CONDITION NEW_MULTIPLAYER_GAME
		} else if (action.equals(ACTION.NEW_MULTIPLAYER_GAME)) {
				//CALL startNewMultiplayer()
			ActionMapTestData.add("multiplayer");
		} else if (action.equals(ACTION.NEW_BEGINNER_GAME)) {
			//CALL startNewMultiplayer()
			ActionMapTestData.add("beginner");
			//CONDITION BOARD_CARD_SELECT
		} else if (action.equals(ACTION.CARD_SELECT)) {
				//CALL inlayCardSelect()
			ActionMapTestData.add("card");
			//CONDITION PAUSE
		} else if (action.equals(ACTION.PAUSE)) {
				//CALL pauseGame()
			ActionMapTestData.add("pause");
	        //CONDITION UNPAUSE
		} else if (action.equals(ACTION.UNPAUSE)) {
	            //CALL unpauseGame()
			ActionMapTestData.add("unpause");
			//CONDITION THREE_MORE
		} else if (action.equals(ACTION.THREE_MORE)) {
				//CALL addThreeMoreCards()
			ActionMapTestData.add("three");
			//CONDITION HINT
		} else if (action.equals(ACTION.HINT)) {
				//CALL useHint()
			ActionMapTestData.add("hint");
			//CONDITION EXPLANATION
		} else if (action.equals(ACTION.EXPLANATION)) {
				//CALL explainSet()
			ActionMapTestData.add("explain");
			//CONDITION P1_BUZZED_IN
		} else if (action.equals(ACTION.P1_BUZZED_IN)) {
				//CALL buzz() with player ONE
			ActionMapTestData.add("p1");
	        //CONDITION P2_BUZZED_IN
		} else if (action.equals(ACTION.P2_BUZZED_IN)) {
	            //CALL buzz() with player TWO
			ActionMapTestData.add("p2");
	        //CONDITION P3_BUZZED_IN
		} else if (action.equals(ACTION.P3_BUZZED_IN)) {
	            //CALL buzz() with player THREE
			ActionMapTestData.add("p3");
	        //CONDITION P4_BUZZED_IN
		} else if (action.equals(ACTION.P4_BUZZED_IN)) {
	            //CALL buzz() with player FOUR
			ActionMapTestData.add("p4");
			//DEFAULT
		} else {
				//PRINT an invalid action error to error stream
			ActionMapTestData.add("bad");
	    //ENDCASE
		}
	}
	
	/**
	 * Updates the state of the game after a user selected a card on the game
	 * board.
	 */
	private void boardCardSelect()
	{
	    //CREATE a Card reference selectedCard and set it to the result of
	    //   the ui's getSelected()
	    
	    //CREATE a PLAYER selectPlayer
	    //IF gameType is MULTI
	        //SET selectPlayer to buzzedPlayer
	    //ELSE
	        //SET selectPlayer to player1
	    //END IF
	    
	    //IF gameType is MULTI AND gameState is not equal to BUZZED THEN
	        //DO nothing
	    //ELSE
	        //CALL gameBoard's moveCardToInlay with the selectedCard
            //IF gameBoard's getInlaySize() equals 3 (INLAY_FULL) THEN
    	        //IF gameBoard's isInlaySet() THEN
    	            //CALL explainSet()
    	            //CALL score's modifyScore on the selectedPlayer
    	            //CALL gameBoard's clearSetFromInlay()
    	            //CALL soundPlayer's playSetSuccess()
    	            //CALL gameBoard's addThreeCards()
    	        //ELSE
    	            //CALL explainSet()
    	            //CALL gameBoards's returnInlaytoBoard()
    	            //CALL score's modifyscore on the selectedPlayer
    	            //CALL soundPlayer's playSetFailure()
                //END IF
            //ELSE
                //CALL soundPlayer's playActionAcknowledged()
            //END IF
    
	        //IF competitive mode THEN
                //GET the timer countdown preference from prefs
                //CALL timer's startCountDown() with the timer countdown value
            //END IF
	    //END IF
	}
	
	/** 
	 * Updates the state of the game after a user selected a card in the inlay.
	 */
	private void inlayCardSelect()
	{
        //CREATE a Card reference selectedCard and set it to the result of
        //   the ui's getSelected()
	    
	    //CREATE PLAYER selectPlayer
	    //IF gameType is SINGLE or COMPETETIVE
	        //SET selectPlayer to PLAYER1
	    //ELSE
	        //SET selectPlayer to buzzedPlayer
	    //END IF
	    
	    //IF gameType is MULTI and gameState is not BUZZED
	        // do nothing
	    //ELSE
	        //Call gameBoard's moveInlayCardToBoard with the selected card
	        //CALL soundPlayer's playActionAcknowledged()
	    //END IF
	}
	
	/**
	 * Starts a new Single Player Game, clearing
	 * the current game
	 */
	private void startNewSinglePlayer()
	{
        //CREATE a new Score and assign it to player1
		//SET gameState to RUNNING
	    //SET gameType to SINGLE
	    //SET numPlayers to ONE
	    //CREATE a new SetsBoard
	    
        //CALL timer's startCountUp()
	}
	
	/**
	 * Starts a new Competitive Mode Game, clearing
	 * the current game
	 */
	private void startNewCompetitive()
	{
        //CREATE a new Score and assign it to player1
        //SET gameState to RUNNING
        //SET gameType to COMPETITIVE
        //SET numPlayers to ONE
        //CREATE a new SetsBoard and assign it to gameBoard
	    
	    //GET the timer value preference from Preferences
        //CALL timer startCountDown() with the timer value as the parameter
	}
	
	/**
	 * Starts a new Multiplayer Game, clearing the
	 * current game
	 */
	private void startNewMultiplayer()
	{
        //CREATE a new score and assign it to player1
	    //CREATE a new score and assign it to player2
        //CREATE a new score and assign it to player3
        //CREATE a new score and assign it to player4
	    
        //SET gameState to RUNNING
        //SET gameType to MULTIPLAYER
	    
	    //GET the playercount preference from GameBoardPreferences
        //SET the number of players to that value
	    
        //CREATE a new SetsBoard and assign it to gameBoard
        
        //CALL timer's startCountUp()
	}
	
	/**
	 * Pauses the current game
	 */
	private void pauseGame()
	{
		//SET the game state to PAUSED
	    //CALL timer's pause()
	}
	
	/**
	 * UnPauses the current game
	 */
	private void unpauseGame()
	{
	    //SET the game state to RUNNING
	    //CALL timer's resume();
	}
	
	
	/**
	 * Updates the game state when the timer expires at the end of a
	 * countdown.  If the current game is multiplayer, the player 
	 * buzzed in loses points for not completing a set in time.  If the
	 * game is competitive, the player loses points for running out of
	 * time before finding a set.
	 */
	private void handleTimerExpiration()
	{
		//IF gameType is MULTI THEN
			//CALL score's modifyScore() with TIME_OUT on buzzedPlayer's score
			//CALL timer's buzzDone()
		//ELSE
			//CALL score's modifyScore() with TIME_OUT on player1
			//GET the timer value from prefs
			//CALL timer's startCountDown() with the timer value
		//END IF
		
		//CALL ui's showExpirationPenalty() with an expired timer message
		//SET the gameState to RUNNING
	}
	
	/**
	 * Attempts to add 3 more cards to the game board.  If the game board
	 * currently has a set, causes a score reduction and doesn't change
	 * the board.  In multiplayer, there is no score reduction.
	 */
	private void addThreeMoreCards()
	{
		//IF the gameState is RUNNING
			//IF the gameType is SINGLE THEN
				//IF gameBoard's boardContainsSet THEN
					//CALL player1's modifyScore() with THREE_MORE_PENALTY
				//ELSE
					//CALL gameBoard's addRow()
				//END IF
			//ELSE IF the gameType is COMPETITIVE THEN
				//IF gameBoard' boardContainsSet THEN
					//CALL player1's modifyScore() with THREE_MORE_PENALTY
				//ELSE
					//CALL gameBoard's addRow()
				//END IF
			//ELSE
				//IF NOT gameBoard's boardContainsSet THEN
					//CALL gameBoard's addRow()
				//END IF
			//END IF
		//END IF
	}
	
	/**
	 * Attempts to use a Hint to find the next card in the Set.  If the current
	 * game is Competitive, no action is taken.
	 */
	private void useHint()
	{
		//IF the gameState is RUNNING THEN
			//IF the gameType is SINGLE THEN
				//CALL gameBoard's useHint()
				//CALL player1's modifyScore with HINT
			//ELSE IF the gameType is MULTI THEN
				//CALL gameBoard's useHint()
			//END IF
		//END IF
	}
	
	/**
	 * Explains the inlay contents (whether it be a valid set or not)
	 * to the user by providing the UI with an explanation message
	 */
	private void explainSet()
	{
	    //IF gameBoard's isInlaySet THEN
	        //CALL SetsBoard's inlayExplain() method and assign it to a string
	        //CALL the ui's showExplanation() with the explanation string
	    //ENDIF
	}
	
	/**
	 * Updates the game state to reflect the given player
	 * buzzing in while playing in multiplayer mode
	 */
	private void buzz(PLAYER player)
	{
	    //IF the gameType is MULTI THEN
	        //SET buzzedPlayer to player
	        //SET the gameState to BUZZED
	        //CALL timer's buzzIn()
	    //END IF
	}
}
