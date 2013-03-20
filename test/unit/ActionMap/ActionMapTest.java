package unit.ActionMap;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import junit.framework.TestCase;
import unit.ActionMap.ActionMapTestData;
import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.ui.ActionMap;
import com.immortallabs.cardboard.ui.CardBoardButton;
import com.immortallabs.cardboard.ui.CardGraphic;
import com.immortallabs.cardboard.ui.GameWindow;
import com.immortallabs.cardboard.ui.ActionMap.EVENT;
import com.immortallabs.cardboard.ui.CardBoardButton.BUTTONTYPE;

/**
 * Action Map Unit test
 * 
 * @author tdvornik
 *
 */
public class ActionMapTest extends TestCase {
	GameWindow gm = new GameWindow (new GameState());
	ActionMap am = gm.getAM();

	public void setUp() {
		ActionMapTestData.clear();
	}
	
	/**
	 * Test that game state is unpaused and game window closes the welcome screen when 
	 * the welcome screen is clicked when the game starts up.
	 * 
	 * Updated to test fix for ticked #96 and #76
	 */
	public void testGameStartUp() {
		CardBoardButton button = new CardBoardButton(null, am, BUTTONTYPE.WELCOME, "welcome");
		am.processEvent(button);
		
		assertEquals("remove-WELCOME unpause repaint", ActionMapTestData.getData());
	}
	
	/**
	 * Test that correct actions are taken when the pause button is pressed. The thread sleeps 
	 * are there to mimic more realistic mouse clicks
	 * 
	 * Updated to test fix for ticked #81 and #73
	 */
	public void testProcessButtonPause() {
		CardBoardButton pause = new CardBoardButton(null, am, BUTTONTYPE.PAUSE, "pause");
		CardBoardButton unpause = new CardBoardButton(null, am, BUTTONTYPE.UNPAUSE, "unpause");
		CardBoardButton hint = new CardBoardButton(null, am, BUTTONTYPE.HINT, "hint");
		CardBoardButton threemore = new CardBoardButton(null, am, BUTTONTYPE.THREEMORE, "threemore");
		try {
			am.processEvent(hint);
			Thread.sleep(1000);
			am.processEvent(pause);
			Thread.sleep(1000);
			am.processEvent(threemore);
			Thread.sleep(1000);
			am.processEvent(unpause);
			Thread.sleep(1000);
			am.processEvent(threemore);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals("hint repaint show-PAUSE pause repaint " +
				"remove-UNPAUSE unpause repaint three", 
				ActionMapTestData.getData());
	}
	
	/**
	 * Test correct action is taken when a card is clicked. These are done on multiple threads
	 * to make sure that when multiple cards are clicked, it doesn't overload the system. 
	 * This will also confirm no cards can be clicked when a card is animating for 
	 * release two.
	 * 
	 * Updated to test fix for ticked #51
	 */
	public void testCardClickByMousePress() {
		EventHappend eh = new EventHappend();;
		MouseEvent me = new MouseEvent(new CardGraphic(null, null, null,
				null, null), 0, 0, 0, 0, 0, 0, false);
		
		try {
			eh.setME(me);
			new Thread(eh).start();
			new Thread(eh).start();
			
			Thread.sleep(1500);
			new Thread(eh).start();
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals("clicked card clicked card", ActionMapTestData.getData());
	}
	
	/**
	 * Test that a card can not be clicked when the game is paused. 
	 */
	public void testCardClickWhilePaused() {
		CardBoardButton pause = new CardBoardButton(null, am, BUTTONTYPE.PAUSE, "pause");
		CardBoardButton unpause = new CardBoardButton(null, am, BUTTONTYPE.UNPAUSE, "unpause");
		EventHappend eh = new EventHappend();;
		MouseEvent me = new MouseEvent(new CardGraphic(null, null, null,
				null, null), 0, 0, 0, 0, 0, 0, false);
		
		try {
			eh.setME(me);
			am.processEvent(pause);
			Thread.sleep(1000);
			new Thread(eh).start();
			Thread.sleep(1000);
			am.processEvent(unpause);
			Thread.sleep(1000);
			new Thread(eh).start();
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals("show-PAUSE pause repaint remove-UNPAUSE unpause repaint clicked card",
				ActionMapTestData.getData());
	}
	
	/**
	 * Test to make sure a user can start a single player game
	 */
	public void testProcessActionEventSinglePlayer() {
		ActionEvent ae = new ActionEvent(am, 0, "SINGLEPLAYER_GAME");
		am.actionPerformed(ae);
		
		assertEquals("solitare remove-UNPAUSE repaint", ActionMapTestData.getData());
	}
	
	/**
	 * Test to make sure a user can start a beginner game
	 */
	public void testProcessActionEventBeginnerGame() {
		ActionEvent ae = new ActionEvent(am, 0, "BEGINNER_GAME");
		am.actionPerformed(ae);
		
		assertEquals("beginner remove-UNPAUSE repaint", ActionMapTestData.getData());
	}
	
	/**
     * test to make sure the game pause through keyboard action
     */
	public void testPauseEvent() {
	    am.processEvent(ActionMap.EVENT.PAUSE);
	    
	    assertEquals("show-PAUSE pause", ActionMapTestData.getData());
	}
	
	/**
     * Test to make sure the game unpauses through keyboard actions
     */
	public void testUnpauseEvent() {
        am.processEvent(ActionMap.EVENT.UNPAUSE);
        
        assertEquals("unpause", ActionMapTestData.getData());
    }
	
	public void testHintEvent() {
        am.processEvent(ActionMap.EVENT.HINT);
        
        assertEquals("hint repaint", ActionMapTestData.getData());
    }
	/**
     * Regression test for defect #164
     */
    public void testDefect164() {
        ActionEvent ae = new ActionEvent(am, 0, "MULTIPLAYER_GAME");
        am.actionPerformed(ae);
        
        assertEquals("multiplayer remove-UNPAUSE repaint", ActionMapTestData.getData());
        
        ActionMapTestData.clear();
        ae = new ActionEvent(am, 0, "COMPETITIVE_GAME");
        am.actionPerformed(ae);
        
        assertEquals("competitive remove-UNPAUSE repaint", ActionMapTestData.getData());
    }
	
    /**
     * Regression test for defect #167
     */
    public void testDefect167() {
        assertTrue(ActionMap.EVENT.ONE.name().equals("ONE"));
        assertTrue(ActionMap.EVENT.TWO.name().equals("TWO"));
        assertTrue(ActionMap.EVENT.THREE.name().equals("THREE"));
        assertTrue(ActionMap.EVENT.FOUR.name().equals("FOUR"));
    }
    
    /** Test unused methods */
    public void testUnusedMethods() {
        am.mouseClicked(null);
        am.mouseEntered(null);
        am.mouseExited(null);
        am.mouseReleased(null);
        am.keyReleased(null);
        am.keyTyped(null);
    }
    
	/**
	 * Used for multiple thread creation.
	 * @author amphro
	 *
	 */
	private class EventHappend implements Runnable {
		private MouseEvent me = null;
		
		public void setME (MouseEvent me) {
			this.me = me;
		}
		
		public void run() {
			if (me != null)
				am.mousePressed(me);
		}
	}
	
}

