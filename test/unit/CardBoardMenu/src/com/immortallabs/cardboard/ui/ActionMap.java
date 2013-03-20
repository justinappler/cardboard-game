package com.immortallabs.cardboard.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
 *          Several TODOS remain.<br>
 *          - 12/04/08 Version 1.2 Changed package and enum names and paths. <br>
 *          - 12/04/08 Version 1.3 Finished enum EVENT and rough draft of
 *          psuedocode. Also updated header with added operations. - 12/05/08
 *          Version 1.4 Changed enum to implement an abstract method. Finished
 *          second draft of psuedocode. - 01/23/09 Version 1.5 Implemented
 *          events for realease 1. This includes mouse events and a couple menu
 *          items. Mouse clicks can trigger CardBoardButtons or CardGraphics
 */
public class ActionMap implements ActionListener, KeyListener, MouseListener
{


    /**
     * Decides if an event should be processed. If false, everything gets
     * processed. If true, something is animating or the game is paused and
     * nothing should be done unless the card is done animating or the game is
     * unpaused.
     */

    /** All the possible events that can occur from game window. */
    public static enum EVENT
    {
        /** Hint Event: Player has asked for a hint */
        HINT,

        /** Pause Event: Player wants to pause the game */
        PAUSE,

        /** Pause Event: Player wants to unpause the game */
        UNPAUSE,

        /**
         * 3 More Event: Player has asked for 3 more cards to appear on the game
         * board
         */
        THREE_MORE,

        /**
         * Card Select Event: Player has selected a card to add add to the inlay
         */
        SELECT,

        /** Direction event: Player wants to move the selected card up */
        UP,

        /** Direction event: Player wants to move the selected card down */
        DOWN,

        /** Direction event: Player wants to move the selected card left */
        LEFT,

        /** Direction event: Player wants to move the selected card right */
        RIGHT,

        /** A card is selected */
        CARD_SELECTED,

        /** Buzz Event: Player 1 has buzzed in */
        PLAYER1_BUZZ,

        /** Buzz Event: Player 2 has buzzed in */
        PLAYER2_BUZZ,

        /** Buzz Event: Player 3 has buzzed in */
        PLAYER3_BUZZ,

        /** Buzz Event: Player 4 has buzzed in */
        PLAYER4_BUZZ,

        /** New Game Event: Start a new competitive game */
        SINGLEPLAYER_GAME,

        /** New Game Event: Start a new competitive game */
        COMPETITIVE_GAME,

        /** New Game Event: Start a new competitive game */
        MULTIPLAYER_GAME,

        /** New Game Event: Start a new beginner game */
        BEGINNER_GAME,

        /** Theme Event: Change theme to simple */
        SIMPLE_THEME,

        /** Theme Event: Change theme to desert */
        DESERT_THEME,

        /** Theme Eveant: Change theme to coral */
        CORAL_THEME,

        /**
         * Time Limit Event: Change the time limit for competitive mode to 15
         * seconds
         */
        TIME_15SEC,

        /**
         * Time Limit Event: Change the time limit for competitive mode to 30
         * seconds
         */
        TIME_30SEC,

        /**
         * Time Limit Event: Change the time limit for competitive mode to 45
         * seconds
         */
        TIME_45SEC,

        /**
         * Time Limit Event: Change the time limit for competitive mode to
         * unlimited
         */
        TIME_UNLIMITED,

        /**
         * Player Event: Change amount of players to 1 for multiplayer mode to
         * unlimited
         */
        ONE,
        /** Player Event: Change amount of players to 2 for multiplayer mode */
        TWO,
        /** Player Event: Change amount of players to 3 for multiplayer mode */
        THREE,
        /** Player Event: Change amount of players to 4 for multiplayer mode */
        FOUR,


        /** Help Menu Event: Display About CardBoard information for player */
        ABOUT,

        /**
         * Help Menu Event: Display How To Play CardBoard information for player
         */
        HOW_TO,

        /** Exit Event: Time to exit the game */
        EXIT, SOUND_TOGGLE, KEY_BINDS;

    }
    public ActionMap()
    {

    }


    public void keyPressed(KeyEvent keyEvent)
    {
        // //CREATE an EVENT interEvent;
        // EVENT interEvent;
        //
        // //SET interEvent to keyMap's get with keyEvent's keyText with
        // // keyEvent's keyCode
        // interEvent = keyMap.get(keyEvent.getKeyCode());
        //
        // if (interEvent != null) {
        // //IF interEvent equals EVENT's SELECT
        // if (interEvent == EVENT.SELECT) {
        // //CALL processEvent with gameWindow's getSelectedCard
        // //processEvent();
        // //ELSE IF interEvent equals an EVENT direction
        // } else if (EnumSet.of(EVENT.LEFT, EVENT.RIGHT, EVENT.UP, EVENT.DOWN)
        // .contains(interEvent)) {
        // //CALL GameWindow's moveSelector on GameWindow's DIRECTION
        // //ELSE IF EVENT is not null
        // } else {
        // //CALL processEvent on interEvent's getAction
        // processEvent(interEvent);
        // //END IF
        // }
        // }
    }

    public void mousePressed(MouseEvent mouseEvent)
    {
      
    }

    public void actionPerformed(ActionEvent actionEvent)
    {}

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
