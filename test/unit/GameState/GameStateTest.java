package unit.GameState;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.immortallabs.cardboard.CardBoardPreferences;
import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.game.Score;
import com.immortallabs.cardboard.game.SetsBoard;
import com.immortallabs.cardboard.game.Timer;
import com.immortallabs.cardboard.game.GameState.ACTION;
import com.immortallabs.cardboard.game.GameState.PLAYER;

public class GameStateTest
{
    private GameState state;
    private FakeUI ui;

    @Before
    public void setUp() throws Exception
    {
        state = new GameState(false);
        state.setUserInterface(ui = new FakeUI());
    }

    @After
    public void tearDown() throws Exception
    {
        TestMonitor.clear();
    }

    @Test
    public void testGameState()
    {
        assertTrue(TestMonitor.dump().equals(
            "SetsBoard,Timer,Timer.pause,CardBoardPreference,"));
        assertTrue(state.getStateString().equals("SINGLE,ONE,WELCOME,NONE"));
    }

    @Test
    public void testGetBoard()
    {
        assertTrue(state.getBoard() instanceof SetsBoard);
    }

    @Test
    public void testGetTimer()
    {
        assertTrue(state.getTimer() instanceof Timer);
    }

    @Test
    public void testGetScore()
    {
        state.processAction(ACTION.NEW_SOLITAIRE_GAME);
        assertTrue(state.getScore(PLAYER.PLAYER1) instanceof Score);
        assertTrue(state.getScore(PLAYER.PLAYER2) == null);

        state.processAction(ACTION.NEW_MULTIPLAYER_GAME);
        assertTrue(state.getScore(PLAYER.PLAYER1) instanceof Score);
        assertTrue(state.getScore(PLAYER.PLAYER2) instanceof Score);
        assertTrue(state.getScore(PLAYER.PLAYER3) instanceof Score);
        assertTrue(state.getScore(PLAYER.PLAYER4) instanceof Score);
    }

    @Test
    public void testGetPreferences()
    {
        assertTrue(state.getPreferences() instanceof CardBoardPreferences);
    }

    @Test
    public void testSetUserInterface()
    {
        TestMonitor.clear();
        state.processAction(ACTION.EXPLANATION);

        assertTrue(TestMonitor.dump().equals("Timer.pause,UI.showMessage(EXPLANATION),"));
    }

    @Test
    public void testNewSolitaireGame()
    {
        String actualState = "";
        String monitor =
                "SetsBoard,Timer,Timer.pause,CardBoardPreference,Score,SetsBoard,Timer,Timer.startCountUp,";
        String expState = "SINGLE,ONE,RUNNING,NONE";

        state.processAction(ACTION.NEW_SOLITAIRE_GAME);
        actualState = state.getStateString();

        assertTrue(TestMonitor.dump().equals(monitor));
        assertTrue(actualState.equals(expState));
    }

    @Test
    public void testNewBeginnerGame()
    {
        String actualState = "";
        String monitor =
                "SetsBoard,Timer,Timer.pause,CardBoardPreference,Score,SetsBoard,Timer,Timer.startCountUp,";
        String expState = "SINGLE,ONE,RUNNING,NONE";

        state.processAction(ACTION.NEW_BEGINNER_GAME);
        actualState = state.getStateString();

        assertTrue(TestMonitor.dump().equals(monitor));
        assertTrue(actualState.equals(expState));
    }

    @Test
    public void testNewCompetitiveGame()
    {
        String actualState = "";
        String monitor =
                "SetsBoard,Timer,Timer.pause,CardBoardPreference,Score,SetsBoard,Timer,CardBoardPreference.getPreference(TIME_LIMIT),Timer.startCountdown(TIME_UNLIMITED),";
        String expState = "COMPETITIVE,ONE,RUNNING,NONE";

        state.processAction(ACTION.NEW_COMPETITIVE_GAME);
        actualState = state.getStateString();
        
        assertTrue(TestMonitor.dump().equals(monitor));
        assertTrue(actualState.equals(expState));
    }

    @Test
    public void testNewMultiplayerGame()
    {
        String actualState = "";
        String monitor =
                "SetsBoard,Timer,Timer.pause,CardBoardPreference,CardBoardPreference.getPreference(PLAYERS),Score,Score,Score,Score,SetsBoard,Timer,Timer.startCountUp,";
        String expState = "MULTI,FOUR,RUNNING,NONE";

        state.processAction(ACTION.NEW_MULTIPLAYER_GAME);
        actualState = state.getStateString();
        
        assertTrue(TestMonitor.dump().equals(monitor));
        assertTrue(actualState.equals(expState));
    }

    @Test
    public void testBuzzIn()
    {
        String actualState = "";
        String monitor =
                "SetsBoard,Timer,Timer.pause,CardBoardPreference,CardBoardPreference.getPreference(PLAYERS),Score,Score,Score,Score,SetsBoard,Timer,Timer.startCountUp,Timer.buzzIn,UI.displayBuzzed(PLAYER2),UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,Timer.buzzDone,UI.displayBuzzed(null),Timer.resume,SetsBoard.deckEmpty,";
        String expState1 = "MULTI,FOUR,BUZZED,PLAYER2";
        String expState2 = "MULTI,FOUR,RUNNING,NONE";

        state.processAction(ACTION.NEW_MULTIPLAYER_GAME);
        state.processAction(ACTION.P2_BUZZED_IN);
        
        actualState = state.getStateString();
        assertTrue(actualState.equals(expState1));
        
        state.processAction(ACTION.CARD_SELECT);
        state.processAction(ACTION.CARD_SELECT);
        state.processAction(ACTION.CARD_SELECT);
        
        actualState = state.getStateString();
        assertTrue(actualState.equals(expState2));

        assertTrue(TestMonitor.dump().equals(monitor));
        
    }
    
    @Test
    public void testCardSelect()
    {
        String actualState = "";
        String monitor =
                "SetsBoard,Timer,Timer.pause,CardBoardPreference,Score,SetsBoard,Timer,Timer.startCountUp,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,";
        String expState = "SINGLE,ONE,RUNNING,NONE";

        state.processAction(ACTION.NEW_SOLITAIRE_GAME);
        for (int i = 0; i < 81; i++)
        {
            state.processAction(ACTION.CARD_SELECT);
        }
        actualState = state.getStateString();
        
        assertTrue(TestMonitor.dump().equals(monitor));
        assertTrue(actualState.equals(expState));
    }

    @Test
    public void testPause()
    {
        String actualState = "";
        String monitor =
                "SetsBoard,Timer,Timer.pause,CardBoardPreference,Score,SetsBoard,Timer,Timer.startCountUp,Timer.pause,";
        String expState = "SINGLE,ONE,PAUSED,NONE";

        state.processAction(ACTION.NEW_SOLITAIRE_GAME);
        state.processAction(ACTION.PAUSE);
        actualState = state.getStateString();

        assertTrue(TestMonitor.dump().equals(monitor));
        assertTrue(actualState.equals(expState));
    }

    @Test
    public void testUnpause()
    {
        String actualState = "";
        String monitor =
                "SetsBoard,Timer,Timer.pause,CardBoardPreference,Score,SetsBoard,Timer,Timer.startCountUp,Timer.pause,Timer.resume,";
        String expState = "SINGLE,ONE,RUNNING,NONE";

        state.processAction(ACTION.NEW_SOLITAIRE_GAME);
        state.processAction(ACTION.PAUSE);
        state.processAction(ACTION.UNPAUSE);
        actualState = state.getStateString();

        assertTrue(TestMonitor.dump().equals(monitor));
        assertTrue(actualState.equals(expState));
    }

    @Test
    public void testHint()
    {
        String actualState = "";
        String monitor =
                "SetsBoard,Timer,Timer.pause,CardBoardPreference,Score,SetsBoard,Timer,Timer.startCountUp,SetsBoard.doHint,SetsBoard.boardContainsSet,UI.showMessage(CANNOT_USE_HINT),SetsBoard.getInlaySize,SetsBoard.deckEmpty,SetsBoard.doHint,SetsBoard.boardContainsSet,UI.showMessage(CANNOT_USE_HINT),SetsBoard.getInlaySize,SetsBoard.deckEmpty,SetsBoard.doHint,SetsBoard.boardContainsSet,UI.showMessage(CANNOT_USE_HINT),SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,";
        String expState = "SINGLE,ONE,RUNNING,NONE";

        state.processAction(ACTION.NEW_SOLITAIRE_GAME);
        state.processAction(ACTION.HINT);
        state.processAction(ACTION.HINT);
        state.processAction(ACTION.HINT);
        actualState = state.getStateString();

        assertTrue(TestMonitor.dump().equals(monitor));
        assertTrue(actualState.equals(expState));
    }

    @Test
    public void testThreeMore()
    {
        String actualState = "";
        String monitor =
                "SetsBoard,Timer,Timer.pause,CardBoardPreference,Score,SetsBoard,Timer,Timer.startCountUp,SetsBoard.boardContainsSet,UI.showMessage(THREE_MORE_WHILE_SET),Score.modifyScore(THREE_MORE),";
        String expState = "SINGLE,ONE,RUNNING,NONE";

        state.processAction(ACTION.NEW_SOLITAIRE_GAME);
        state.processAction(ACTION.THREE_MORE);
        actualState = state.getStateString();

        assertTrue(TestMonitor.dump().equals(monitor));
        assertTrue(actualState.equals(expState));
    }

    @Test
    public void testExplanation()
    {
        String actualState = "";
        String monitor =
                "SetsBoard,Timer,Timer.pause,CardBoardPreference,Score,SetsBoard,Timer,Timer.startCountUp,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.deckEmpty,UI.getSelected(),SetsBoard.isInInlay,UI.getSelected(),SetsBoard.moveCardToInlay,SetsBoard.getInlaySize,SetsBoard.isInlaySet,SetsBoard.explanation,Score.modifyScore(ADD_SET),UI.showMessage(CORRECT_SET),SetsBoard.clearSetFromInlay,SetsBoard.deckEmpty,Timer.pause,UI.showMessage(EXPLANATION),";
        String expState = "SINGLE,ONE,PAUSED,NONE";

        state.processAction(ACTION.NEW_SOLITAIRE_GAME);
        state.processAction(ACTION.CARD_SELECT);
        state.processAction(ACTION.CARD_SELECT);
        state.processAction(ACTION.CARD_SELECT);
        state.processAction(ACTION.EXPLANATION);
        actualState = state.getStateString();

        assertTrue(TestMonitor.dump().equals(monitor));
        assertTrue(actualState.equals(expState));
    }
    
    @Test
    public void testDefect175() throws Exception
    {
        String monitor = "SetsBoard,Timer,Timer.pause,CardBoardPreference,Timer.pause,UI.showMessage(EXPLANATION),";
        
        state.processAction(ACTION.EXPLANATION);
        assertTrue(TestMonitor.dump().equals(monitor));
    }
    
    @Test
    public void testDefect181() throws Exception
    {
        String actualState = "MULTI,FOUR,BUZZED,PLAYER1";

        state.processAction(ACTION.NEW_MULTIPLAYER_GAME);
        state.processAction(ACTION.P1_BUZZED_IN);
        state.processAction(ACTION.P2_BUZZED_IN);
        
        assertTrue(state.getStateString().equals(actualState));
    }
    
    @Test
    public void testDefect183() throws Exception
    {
        String monitor = "SetsBoard,Timer,Timer.pause,CardBoardPreference,Score,SetsBoard,Timer,CardBoardPreference.getPreference(TIME_LIMIT),Timer.startCountdown(TIME_UNLIMITED),UI.showMessage(NO_HINT_IN_COMPETITIVE),SetsBoard.deckEmpty,";
        
        state.processAction(ACTION.NEW_COMPETITIVE_GAME);
        state.processAction(ACTION.HINT);
        
        assertTrue(TestMonitor.dump().equals(monitor));
    }
    
    @Test
    public void testDefect182() throws Exception
    {
        Timer t;
        state.processAction(ACTION.NEW_COMPETITIVE_GAME);
        t = state.getTimer();
        state.processAction(ACTION.NEW_SOLITAIRE_GAME);
        
        assertFalse(state.getTimer().equals(t));
        
    }

}
