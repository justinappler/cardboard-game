package com.immortallabs.cardboard.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EnumSet;
import java.util.HashMap;

import com.immortallabs.cardboard.CardBoardPreferences;
import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.ui.ActionMap.EVENT.NoActionException;

/**
 * <p>
 * The ActionMap translates all user interface actions into logic events. It
 * listens for a user to press a button, keyboard key, or a menu item and sends
 * the appropriate action to the logic
 * </p>
 * <b>Operations:</b>
 * <ul>
 * <li>The ActionMap class processes a game event command
 * <li>The ActionMap class processes a Button
 * <li>The ActionMap class processes a Card
 * <li>The ActionMap class processes a clicked card
 * <li>The ActionMap class listens for a typed key from the keyboard
 * <li>The ActionMap class listens for a pressed key from the keyboard
 * <li>The ActionMap class listens for a mouse press from the mouse
 * <li>The ActionMap class listens for an action from the menu
 * </ul>
 * 
 * @author Thomas Dvornik
 * @author RustyNail CSC308 F08
 * @version 1.4
 * @version 12/05/08
 * @see Logic
 * @history - 12/03/08 Version 1.1 Added Version History. Changed ActionMap to
 *          implement KeyListener/MouseListener and added all required methods
 *          but only need to implement keyTyped, keyPressed, and mousePressed.
 *          Added Pseudocode to those methods along with actionMap and
 *          processEvent. processEvent was overloaded to handle multiple events.
 *          Several TODOS remain.<br> - 12/04/08 Version 1.2 Changed package
 *          and enum names and paths. <br> - 12/04/08 Version 1.3 Finished enum
 *          EVENT and rough draft of psuedocode. Also updated header with added
 *          operations. - 12/05/08 Version 1.4 Changed enum to implement an
 *          abstract method. Finished second draft of psuedocode. - 01/23/09
 *          Version 1.5 Implemented events for realease 1. This includes mouse
 *          events and a couple menu items. Mouse clicks can trigger
 *          CardBoardButtons or CardGraphics - 2/09 Version 1.5 Forgot to add a
 *          version history for release 1. This was committed sometime in
 *          February. This included the code for mouse clicks and basic menu
 *          options. (New game and exit). - 3/04/09 Version 1.6 Finished code
 *          for release two. Includes keybindings, and new menu items.
 */
public class ActionMap implements ActionListener, KeyListener, MouseListener
{
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

    /**
     * Maps all key strokes to the corresponding event.
     */
    private HashMap<String, EVENT> keyMap;

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
                return GameState.ACTION.CARD_SELECT;
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
                return GameState.ACTION.P1_BUZZED_IN;
            }
        },
        /** Buzz Event: Player 2 has buzzed in */
        PLAYER2_BUZZ
        {
            GameState.ACTION getAction() throws NoActionException
            {
                return GameState.ACTION.P2_BUZZED_IN;
            }
        },
        /** Buzz Event: Player 3 has buzzed in */
        PLAYER3_BUZZ
        {
            GameState.ACTION getAction() throws NoActionException
            {
                return GameState.ACTION.P3_BUZZED_IN;
            }
        },
        /** Buzz Event: Player 4 has buzzed in */
        PLAYER4_BUZZ
        {
            GameState.ACTION getAction() throws NoActionException
            {
                return GameState.ACTION.P4_BUZZED_IN;
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
                return GameState.ACTION.NEW_COMPETITIVE_GAME;
            }
        },
        /** New Game Event: Start a new competitive game */
        MULTIPLAYER_GAME
        {
            GameState.ACTION getAction() throws NoActionException
            {
                return GameState.ACTION.NEW_MULTIPLAYER_GAME;
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
        ONE
        {
            GameState.ACTION getAction() throws NoActionException
            {
                throw new NoActionException(this);
            }
        },
        /** Player Event: Change amount of players to 2 for multiplayer mode */
        TWO
        {
            GameState.ACTION getAction() throws NoActionException
            {
                throw new NoActionException(this);
            }
        },
        /** Player Event: Change amount of players to 3 for multiplayer mode */
        THREE
        {
            GameState.ACTION getAction() throws NoActionException
            {
                throw new NoActionException(this);
            }
        },
        /** Player Event: Change amount of players to 4 for multiplayer mode */
        FOUR
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
        /**
         * Enable or disable sound.
         */
        SOUND_TOGGLE
        {
            GameState.ACTION getAction() throws NoActionException
            {
                throw new NoActionException(this);
            }
        },
        REMOVE_INLAY_POS_ONE
        {
            GameState.ACTION getAction() throws NoActionException
            {
                return GameState.ACTION.CLEAR_INLAY_ONE;
            }
        },
        REMOVE_INLAY_POS_TWO
        {
            GameState.ACTION getAction() throws NoActionException
            {
                return GameState.ACTION.CLEAR_INLAY_TWO;
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

        /**
         * NoActionException is thrown when an event's getAction command is
         * called and that event does not have an associative action.
         * 
         * @author tdvornik
         */
        public static class NoActionException extends Exception
        {
            private static final long serialVersionUID = 1L;

            private String eventName;

            NoActionException(EVENT e)
            {
                eventName = e.name();
            }

            public String getMessage()
            {
                return eventName + " does not have an action and should"
                        + " not be sent to GameState.";
            }
        }
    }

    /**
     * All events corresponding to time
     */
    private EnumSet<EVENT> timeSet =
            EnumSet.of(EVENT.TIME_15SEC, EVENT.TIME_30SEC, EVENT.TIME_45SEC,
                EVENT.TIME_UNLIMITED);

    /**
     * All events corresponding to players
     */
    private EnumSet<EVENT> playerSet =
            EnumSet.of(EVENT.ONE, EVENT.TWO, EVENT.THREE,
                EVENT.FOUR);

    /**
     * Instantiates an ActionMap that will listen for actions from the UI or the
     * keyboard. It will use GameState to get the keyboard bindings and send
     * actions.
     * 
     * @param gameGameState
     *            The current gameState of the CardBoard game.
     * @param gameWindow
     *            The current gameWindow displaying the game
     */
    public ActionMap(GameState gameGameState, GameWindow gameWindow)
    {
        /** Get the bindings for all the keys */
        KeyBindings keyBind;
        // SET gameState to gameGameState
        this.gameState = gameGameState;
        // SET this.gameWindow to gameWidow
        this.gameWindow = gameWindow;
        // SET noAction to false
        noAction = false;
        // SET keyMap to a new hash map of strings that represent a key's code
        // and the corresponding event.
        keyMap = new HashMap<String, EVENT>();
        keyBind = new KeyBindings();
        // FOR each keyBinding in KeyBindings.KEYBINDS
        for (KeyBindings.KEY_BIND key : KeyBindings.KEY_BIND.values())
        {
            // ADD the results of getKeyBinding with keyBindins and event to
            keyMap.put(keyBind.getKeyBinding(key), EVENT.valueOf(key.name()));
            // END FOR
        }
    }

    /**
     * Processes an event when a key is typed from the keyboard.
     * 
     * @param interEvent
     *            The event to be processed
     */
    public void processEvent(EVENT interEvent)
    {
        try
        {
            // IF interEvent equals PAUSE
            if (interEvent == EVENT.PAUSE && !noAction)
            {
                // SET noAction to true
                noAction = true;
                // CALL GameWIndow's showPauseDisplay
                gameWindow.showButton(CardBoardButton.BUTTONTYPE.PAUSE);
                // CALL GameState's processAction with interEvent's getAction
                gameState.processAction(interEvent.getAction());
                // ELSE IF interEvent equals UNPAUSE
            }
            else if (interEvent == EVENT.UNPAUSE && noAction)
            {
                // SET noAction to false
                noAction = false;
                // CALL GameWindow's removePauseDisplay
                gameWindow.removeButton(CardBoardButton.BUTTONTYPE.UNPAUSE);
                // CALL GameState's processAction with interEvent's getAction
                gameState.processAction(interEvent.getAction());
                // ELSE IF noAction = false
            }
            else if (!noAction)
            {
                // CALL GameState's processAction with interEvent's getAction
                gameState.processAction(interEvent.getAction());
                // END IF
            }
        }
        catch (NoActionException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Processes a button when it is clicked.
     * 
     * @param clickedButton
     *            The button that is being processed
     */
    public void processEvent(CardBoardButton clickedButton)
    {
        // IF clickedButton's getType equals BUTTONTYPE's WELCOME
        if (clickedButton.getType() == CardBoardButton.BUTTONTYPE.WELCOME)
        {
            // CALL GameWindow's removeButton with WELCOME
            gameWindow.removeButton(CardBoardButton.BUTTONTYPE.WELCOME);
            // CALL GameState;s processAction with Action's UNPAUSE
            gameState.processAction(GameState.ACTION.UNPAUSE);
            // END IF
            // IF clickedButton's getType equals BUTTONTYPE's PAUSE
        }
        else if (clickedButton.getType() == CardBoardButton.BUTTONTYPE.PAUSE
                && !noAction)
        {
            // SET noAction to true
            noAction = true;
            // CALL GameWIndow's showPauseDisplay
            gameWindow.showButton(CardBoardButton.BUTTONTYPE.PAUSE);
            // CALL GameState's processAction with event's getAction
            gameState.processAction(GameState.ACTION.PAUSE);
            // ELSE IF clickedButton's getType equals BUTTONTYPE's UNPAUSE
        }
        else if (clickedButton.getType() == CardBoardButton.BUTTONTYPE.UNPAUSE
                && noAction)
        {
            // SET noAction to false
            noAction = false;
            // CALL GameWindow's removePauseDisplay
            gameWindow.removeButton(CardBoardButton.BUTTONTYPE.UNPAUSE);
            // CALL GameState's processAction with event's getAction
            gameState.processAction(GameState.ACTION.UNPAUSE);
            // ELSE IF noAction should not be taken
        }
        else if (!noAction)
        {
            // IF clickedButton's getType equals BUTTONTYPE's HINT
            if (clickedButton.getType() == CardBoardButton.BUTTONTYPE.HINT)
            {
                // CALL processAction with ACTION's HINT_SELECTED
                gameState.processAction(GameState.ACTION.HINT);
                // ELSE IF clickedButton's getType equals BUTTONTYPE's THREEMORE
            }
            else if (clickedButton.getType() == CardBoardButton.BUTTONTYPE.THREEMORE)
            {
                // CALL GameState's processAction with ACTION's
                // THREE_MORE_SELECTED
                gameState.processAction(GameState.ACTION.THREE_MORE);
                // ELSE IF clickedButton's getType equals BUTTONTYPE's WHY
            }
            else if (clickedButton.getType() == CardBoardButton.BUTTONTYPE.EXPLAIN)
            {
                
                // CALL GameState's processAction with ACTION's EXPLANATION
                gameState.processAction(GameState.ACTION.EXPLANATION);
                // CALL GameState's processAction with ACTION's PAUSE
                gameState.processAction(GameState.ACTION.PAUSE);
                // END IF
            }
        }
        gameWindow.repaint();
    }

    /**
     * Processes a card when it is clicked or the select key is pressed.
     * 
     * @param cardGraphic
     *            The card that is being processed
     */
    public void processEvent(CardGraphic cardGraphic)
    {
        // IF noAction should not be taken
        if (noAction == false)
        {
            // SET noAction to true
            noAction = true;
            // CALL GameWindow's cardClicked with cardGraphic
            gameWindow.cardClicked(cardGraphic);
            // END IF
        }
    }

    /**
     * Process a card to gameState when it is done animating
     * 
     * @param cardGraphic
     *            The Card to be sent to gameState
     */
    public void cardClicked(CardGraphic cardGraphic)
    {
        // IF noAction should be taken
        if (noAction == true)
        {
            // CALL GameState's processAction with ACTION's BOARD_CARD_SELECTED
            gameState.processAction(GameState.ACTION.CARD_SELECT);
            // SET noAction to false
            noAction = false;
        }
    }

    /**
     * Handles when a key is pressed
     * 
     * @param keyEvent
     *            The key that is pressed
     */
    public void keyPressed(KeyEvent keyEvent)
    {
        // CREATE an EVENT interEvent;
        EVENT interEvent;
        // SET interEvent to keyMap's get with keyEvent's keyText with
        // keyEvent's keyCode
        interEvent = keyMap.get(new Integer(keyEvent.getKeyCode()).toString());
        // IF interEvent doesn't equal null
        if (interEvent != null)
        {
            // IF interEvent equals EVENT's SELECT
            if (interEvent == EVENT.SELECT)
            {
                // CALL processEvent with gameWindow's getSelected
                processEvent(gameWindow.getSelectedCardGraphic());
                // ELSE IF interEvent equals an EVENT direction
            }
            else if (EnumSet.of(EVENT.LEFT, EVENT.RIGHT, EVENT.UP, EVENT.DOWN)
                    .contains(interEvent))
            {
                // CALL GameWindow's moveSelector on GameWindow's DIRECTION
                gameWindow.moveSelector(GameWindow.DIRECTION.valueOf(interEvent
                        .name()));
            }
            else
            {
                // CALL processEvent on interEvent's getAction
                processEvent(interEvent);
                // END IF
            }
        }
    }

    public void mousePressed(MouseEvent mouseEvent)
    {
        Object clickedObject =
                gameWindow.getSource(mouseEvent.getX(), mouseEvent.getY());
        // IF Object's getClass with mouseEvent's getSource is a Button
        if (clickedObject.getClass() == CardBoardButton.class)
        {
            // call processEvent with Object's getClass with mouseEvent's
            // getSource
            processEvent((CardBoardButton) clickedObject);
            // ELSE IF Object's getClass with mouseEvent's getSource is a Card
        }
        else if (clickedObject.getClass() == CardGraphic.class)
        {
            // call processEvent with Object's getClass with mouseEvent's
            // getSource
            processEvent((CardGraphic) clickedObject);
            // END IF
        }
    }

    public void actionPerformed(ActionEvent actionEvent)
    {
        // Get the current instance of CardBoardPreference
        CardBoardPreferences pref = CardBoardPreferences.getInstance();
        // If the action is SOUND_TOGGLE than toggle the sound.
        if (actionEvent.getActionCommand().equals(EVENT.SOUND_TOGGLE.name()))
        {
            // If the sound is currently turned off than turn it on
            if (pref.getPreference(CardBoardPreferences.PREF.SOUNDS).equals(
                "OFF"))
            {
                pref.setPreference(CardBoardPreferences.PREF.SOUNDS, "ON");
            }
            // ELSE turn it off
            else
            {
                pref.setPreference(CardBoardPreferences.PREF.SOUNDS, "OFF");
            }
        }
        // ElSE if the action is to change the number of players
        else if (playerSet.contains(EVENT.valueOf(actionEvent
                .getActionCommand())))
        {
            // SET the current preference to that number of players
            pref.setPreference(CardBoardPreferences.PREF.PLAYERS, actionEvent
                    .getActionCommand());
        }
        // ELSE IF the action is to change the amount of time
        else if (timeSet
                .contains(EVENT.valueOf(actionEvent.getActionCommand())))
        {
            // SET the current preferences to new time limit
            pref.setPreference(CardBoardPreferences.PREF.TIME_LIMIT,
                actionEvent.getActionCommand());
        }
        // ELSE IF the action is to show the about page
        else if (actionEvent.getActionCommand().equals(EVENT.ABOUT.name()))
        {
            gameWindow
                    .showPage("http://wiki.csc.calpoly.edu/ImmortalLabs/wiki/about");
        }
        // ELSE IF the action is to show the how to page
        else if (actionEvent.getActionCommand().equals(EVENT.HOW_TO.name()))
        {
            gameWindow
                    .showPage("http://wiki.csc.calpoly.edu/ImmortalLabs/wiki/rules");
        }
        // ELSE send the action to processAction
        else
        {
            // FOR each event in EVENT
            for (EVENT event : EVENT.values())
            {
                // IF actionEvent's getActionCommand equals EVENT's name
                if (actionEvent.getActionCommand() == event.name())
                {
                    // CALL GameState's processAction with EVENT's getAction
                    try
                    {
                        gameState.processAction(event.getAction());
                    }
                    catch (NoActionException e)
                    {
                        e.printStackTrace();
                    }
                    // END IF
                }
                // END FOR
            }
        }
        // Repaint the window in case the action changed anything on the screen
        gameWindow.repaint();
    }

    /** This method is not used in ActionMap */
    public void mouseClicked(MouseEvent arg0)
    {
    }

    /** This method is not used in ActionMap */
    public void mouseEntered(MouseEvent arg0)
    {
    }

    /** This method is not used in ActionMap */
    public void mouseExited(MouseEvent arg0)
    {
    }

    /** This method is not used in ActionMap */
    public void mouseReleased(MouseEvent arg0)
    {
    }

    /** This method is not used in ActionMap */
    public void keyReleased(KeyEvent e)
    {
    }

    /** This method is not used in ActionMap */
    public void keyTyped(KeyEvent e)
    {
    }
}
