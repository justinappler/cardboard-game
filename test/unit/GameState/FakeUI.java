package unit.GameState;

import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.CardBoardMessage;
import com.immortallabs.cardboard.game.Deck;
import com.immortallabs.cardboard.game.GameState.PLAYER;
import com.immortallabs.cardboard.ui.CardBoardUI;

public class FakeUI implements CardBoardUI
{
    private Deck deck;
    
    public FakeUI()
    {
        deck = new Deck(true, false);
    }
    
	public String getName()
	{
		TestMonitor.add("UI.getName");
		return null;
	}

	public Card getSelected()
	{
		TestMonitor.add("UI.getSelected()");
		return deck.deal();
	}

	public void showMessage(CardBoardMessage message)
	{
       TestMonitor.add("UI.showMessage(" + message.toString() + ")");
	}

	public void displayBuzzedPlayer(PLAYER player) 
	{
	    TestMonitor.add("UI.displayBuzzed(" + player + ")");
	}
	
	public void redraw()
	{
	    TestMonitor.add("UI.redraw()");
	}
}
