package com.immortallabs.cardboard.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.EnumSet;
import java.util.HashMap;

import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.ui.ActionMap.EVENT.NoActionException;

/**
 * FAKE!
 */
public class ActionMap implements  ActionListener, KeyListener, MouseListener {
   /** The Current game Logic */
   private GameState gameState;

   /** The current game GameWindow */
   private GameWindow gameWindow;

   /**
    * Decides if an event should be processed. If false, everything gets
    * processed. If true, something is animating or the game is paused and
    * nothing should be done unless the card is done animating or the game is
    * unpaused.
    */
   private boolean noAction;

   /** All the possible events that can occur from game window. */
   public static enum EVENT
   {
       /** Hint Event: Player has asked for a hint */
       HINT
       {
           GameState.ACTION getAction()
           {
               return GameState.ACTION.HINT;
           }
       },

       /** Pause Event: Player wants to pause the game */
       PAUSE
       {
           GameState.ACTION getAction()
           {
               return GameState.ACTION.PAUSE;
           }
       },

       /** Pause Event: Player wants to unpause the game */
       UNPAUSE
       {
           GameState.ACTION getAction()
           {
               return GameState.ACTION.UNPAUSE;
           }
       },

       /**
        * 3 More Event: Player has asked for 3 more cards to appear on the game
        * board
        */
       THREE_MORE
       {
           GameState.ACTION getAction()
           {
               return GameState.ACTION.THREE_MORE;
           }
       },

       /**
        * Card Select Event: Player has selected a card to add add to the inlay
        */
       SELECT
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
               // Not Implemented for release 1
               // return GameState.ACTION.BOARD_CARD_SELECT;
           }
       },

       /** Direction event: Player wants to move the selected card up */
       UP
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /** Direction event: Player wants to move the selected card down */
       DOWN
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /** Direction event: Player wants to move the selected card left */
       LEFT
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /** Direction event: Player wants to move the selected card right */
       RIGHT
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /** A card is selected */
       CARD_SELECTED
       {
           GameState.ACTION getAction()
           {
               return GameState.ACTION.CARD_SELECT;
           }
       },

       /** Buzz Event: Player 1 has buzzed in */
       PLAYER1_BUZZ
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
               // Not Implemented for release 1
               // return GameState.ACTION.P1_BUZZED_IN;
           }
       },

       /** Buzz Event: Player 2 has buzzed in */
       PLAYER2_BUZZ
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
               // Not Implemented for release 1
               // return GameState.ACTION.P2_BUZZED_IN;
           }
       },

       /** Buzz Event: Player 3 has buzzed in */
       PLAYER3_BUZZ
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
               // Not Implemented for release 1
               // return GameState.ACTION.P3_BUZZED_IN;
           }
       },

       /** Buzz Event: Player 4 has buzzed in */
       PLAYER4_BUZZ
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
               // Not Implemented for release 1
               // return GameState.ACTION.P4_BUZZED_IN;
           }
       },

       /** New Game Event: Start a new competitive game */
       SINGLEPLAYER_GAME
       {
           GameState.ACTION getAction()
           {
               return GameState.ACTION.NEW_SOLITAIRE_GAME;
           }
       },

       /** New Game Event: Start a new competitive game */
       COMPETITIVE_GAME
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
               // Not Implemented for release 1
               // return GameState.ACTION.NEW_COMPETITIVE_GAME;
           }
       },

       /** New Game Event: Start a new competitive game */
       MULTIPLAYER_GAME
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
               // Not Implemented for release 1
               // return GameState.ACTION.NEW_MULTIPLAYER_GAME;
           }
       },

       /** New Game Event: Start a new beginner game */
       BEGINNER_GAME
       {
           GameState.ACTION getAction()
           {
               return GameState.ACTION.NEW_BEGINNER_GAME;
           }
       },

       /** Theme Event: Change theme to simple */
       SIMPLE_THEME
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /** Theme Event: Change theme to desert */
       DESERT_THEME
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /** Theme Eveant: Change theme to coral */
       CORAL_THEME
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /**
        * Time Limit Event: Change the time limit for competitive mode to 15
        * seconds
        */
       TIME_15SEC
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /**
        * Time Limit Event: Change the time limit for competitive mode to 30
        * seconds
        */
       TIME_30SEC
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /**
        * Time Limit Event: Change the time limit for competitive mode to 45
        * seconds
        */
       TIME_45SEC
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /**
        * Time Limit Event: Change the time limit for competitive mode to
        * unlimited
        */
       TIME_UNLIMITED
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /**
        * Player Event: Change amount of players to 1 for multiplayer mode to
        * unlimited
        */
       PLAYER1
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /** Player Event: Change amount of players to 2 for multiplayer mode */
       PLAYER2
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /** Player Event: Change amount of players to 3 for multiplayer mode */
       PLAYER3
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /** Player Event: Change amount of players to 4 for multiplayer mode */
       PLAYER4
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /** Help Menu Event: Display About CardBoard information for player */
       ABOUT
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /**
        * Help Menu Event: Display How To Play CardBoard information for player
        */
       HOW_TO
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       },

       /** Exit Event: Time to exit the game */
       EXIT
       {
           GameState.ACTION getAction() throws NoActionException
           {
               throw new NoActionException(this);
           }
       };

       /**
        * The GameState action corresponding to the event
        * 
        * @return The GameState ACTION corresponding to the event. If this
        *         method is called and there is no action corresponding with
        *         this event, then a NoActionException is thrown.
        */
       abstract GameState.ACTION getAction() throws NoActionException;
		
		class NoActionException extends Exception {
			private String eventName;
			
			NoActionException(EVENT e) {
				eventName = e.name();
			}
			@Override
			public String getMessage() {
				return eventName + " does not have an action and should" +
					" not be sent to GameState.";				
			}
		}
	}
	
	/**
	 * Instantiates an ActionMap that will listen for actions from the 
	 * UI or the keyboard. It will use GameState to get the keyboard bindings and
	 * send actions.
	 * 
	 * @param gameGameState The current gameState of the CardBoard game.
	 */
	public ActionMap(GameState gameGameState, GameWindow gameWindow) {
		//SET gameState to gameGameState
		this.gameState = gameGameState;
		//SET this.gameWindow to gameWidow
		this.gameWindow = gameWindow;
		//SET noAction to false
		noAction = false;
	}

	/**
	 * Processes an event when a key is typed from the keyboard.
	 * 
	 * @param interEvent The event to be processed
	 */
	public void processEvent(EVENT interEvent) {
		
	}
	
	/**
	 * Processes a button when it is clicked.
	 * 
	 * @param clickedButton The button that is being processed
	 */
	public void processEvent(CardBoardButton clickedButton) {

	}
	
	/**
	 * Processes a card when it is clicked or the select key 
	 * is pressed.
	 * 
	 * @param cardGraphic The card that is being processed
	 */
	public void processEvent(CardGraphic cardGraphic) {
	
	}

	/**
	 * Process a card to gameState when it is done animating 
	 * 
	 * @param cardGraphic The Card to be sent to gameState
	 */
	public void cardClicked(CardGraphic cardGraphic) {
	
	}
		
	public void keyPressed(KeyEvent keyEvent) 
	{
      if(keyEvent.getKeyCode() == KeyEvent.VK_UP)
      {
         gameWindow.moveSelector(GameWindow.DIRECTION.UP);
      }
      else if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
      {
         gameWindow.moveSelector(GameWindow.DIRECTION.DOWN);
      }
      else if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
      {
         gameWindow.moveSelector(GameWindow.DIRECTION.RIGHT);
      }
      else if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
      {
         gameWindow.moveSelector(GameWindow.DIRECTION.LEFT);
      }
      else if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER) 
      {
         CardGraphic card = gameWindow.getSelectedCardGraphic(); 
         
         if(card != null)
         {
            System.out.println("Card was returned by ENTER KEY");
         }
         else 
         {
            System.out.println("Card was not returned by ENTER KEY");
         }
      }
	}
	
	public void mousePressed(MouseEvent mouseEvent) {
		
	    Object object = gameWindow.getSource(mouseEvent.getX(), mouseEvent.getY());

		if (object.getClass().getName().equals("com.immortallabs.cardboard.ui.CardGraphic"))
		{
			System.out.println("a card was clicked!");
		}
		else if (object.getClass().getName().equals("com.immortallabs.cardboard.ui.CardBoardButton"))
		{
			CardBoardButton button = ((CardBoardButton) object);
			
			if (button.getType() == CardBoardButton.BUTTONTYPE.WELCOME)
			{
				System.out.println("Welcome button was pressed");
            CardBoardButton.tempCount = 1; 
				gameWindow.removeButton(CardBoardButton.BUTTONTYPE.WELCOME); 
			}
			else if (button.getType() == CardBoardButton.BUTTONTYPE.PAUSE)
			{
				System.out.println("pause button was pressed");
				
			}
			else if (button.getType() == CardBoardButton.BUTTONTYPE.HINT)
			{
				System.out.println("hint button was pressed");
			}
			else if (button.getType() == CardBoardButton.BUTTONTYPE.EXPLAIN)
			{
				System.out.println("explain button was pressed");
			}
			else if(button.getType() == CardBoardButton.BUTTONTYPE.THREEMORE)
			{
				System.out.println("three more button was pressed");
			}
			else
			{
				System.out.println(button.getType().toString()+ " button was pressed");
			}
		}
	}	
	public void actionPerformed(ActionEvent actionEvent) {
      
      if (actionEvent.getActionCommand().equals(EVENT.EXIT.name()))
      {
      
         System.exit(0);
      }

	}
	
	/** This method is not used in ActionMap */
	public void mouseClicked(MouseEvent arg0) {}
	/** This method is not used in ActionMap */
	public void mouseEntered(MouseEvent arg0) {}
	/** This method is not used in ActionMap*/
	public void mouseExited(MouseEvent arg0) {}
	/** This method is not used in ActionMap*/
	public void mouseReleased(MouseEvent arg0) {}
	/** This method is not used in ActionMap*/
	public void keyReleased(KeyEvent e) {}
	/** This method is not used in ActionMap*/
	public void keyTyped(KeyEvent e) {}
}
