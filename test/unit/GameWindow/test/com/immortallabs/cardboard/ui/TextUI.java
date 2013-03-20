package com.immortallabs.cardboard.ui;
import java.util.Scanner;

import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.game.Score;
import com.immortallabs.cardboard.game.SetsBoard;
import com.immortallabs.cardboard.game.Timer;
import com.immortallabs.cardboard.game.GameState.ACTION;
import com.immortallabs.cardboard.game.GameState.PLAYER;
import com.immortallabs.cardboard.game.SetsBoard.ROWS;

import edu.profdalbey.Natural;

/**
 *      <p>Displays the state of the CardBoard game through
 *      a console. It creates a 3x4 grid where each location
 *      has it's number and the characteristics of the card.
 *      There are another 3 slots for cards that have been selected</p>
 *
 *      <b>Operations:</b>
 *      <ul>
 *      <li>TextUI displays the game state in a console.</li>
 *      <li>TextUI can prompt the user for his or her name and return it.</li>
 *      </ul>
 *
 *      @author         Kyle Williamson
 *      @author         ImmortalLabs CSC308 W09
 *      @version        1.1
 *      @version        2/15/09
 *      @history        - 2/15/09 Changed the game so that cards moved from the
 *                      inlay back to the board don't automically shift up
 *                      - 1/31/09 Fixed minor bugs that arose
 *                      - 1/10/09 Initial version of TextUI released
 **/

public class TextUI implements CardBoardUI
{
       /**
        *      INLAY represents the different open
        *      inlay positions.
        **/
        public enum INLAY
        {
               /** Inlay spot one **/
               ONE,

               /** Inlay spot two **/
               TWO,

               /** Inlay spot three **/
               THREE;
        }

        /** Holds the selected card **/
        private Card selected;

        /** Holds the current  state of the game **/
        private GameState game;

        /** Reads from the input stream **/
        private Scanner input;

        /** number of possible columns in the game **/
        private final int cols = 3;

        /** Four rows currently on the board **/
        private final int fourRows = 4;

        /** Five rows currently on the board **/
        private final int fiveRows = 5;

        /** Six rows currently on the board **/
        private final int sixRows = 6;

        /** Seven rows currently on the board **/
        private final int sevenRows = 7;

        /** Number of blank rows used for pause **/
        private final int loops = 50;
        
        /** Size of the inlay **/
        private final int inlaySize = 3;

        /**
         *      Instantiates a new game window that will display
         *      the state of the game held in logic.
         *
         *      @param  logic the game to display
         **/
        public TextUI(GameState logic)
        {
                input = new Scanner(System.in);
                game = logic;
                game.setUserInterface(this);
                display();
        }

        /**
         *      Sets the selected card to the chosen card.
         *
         *      @param    card   The card that has been selected
         **/
        public void cardSelected(Card card)
        {
                selected = card;
                // If the card has been previously selected
                if(selected == null)
                {
                        System.out.println("invalid card selected");
                }
                else
                {
                        game.processAction(ACTION.CARD_SELECT);
                }
                selected = null;
        }

        /**
         *      Returns the currently selected card.
         * 
         *      @return last card that was selected.
         */

        public Card getSelected()
        {
                return selected;
        }

        /**
         *      Print out the expiration message
         *
         *      @param message  expiration message passed to TextUI
         **/
        public void showExpirationPenalty(String message)
        {
                System.out.println("expiration penalty: " + message);
        }

        /**
         *      Print out the explanation message
         *
         *      @param message  explanation message passed to TextUI
         */
        public void showExplanation(String message)
        {
                System.out.println("explanation: " + message);
        }

        /**
         *      Asks the user to type in a username.
         *
         *      @return username that was chosen.
         */

         public String getName()
         {
                System.out.println("please enter your desired username: ");
                String username = input.nextLine();
                return username;
         }

        /**
         *      Creates a new game and calls an ACTION depending on 
         *      input from the user
         */

         private void display()
         {
                String line;
                char option = 'a';
                int rows;
                Natural nat;
                SetsBoard board;
 
                System.out.println("Card Board");
                System.out.println("board won't display new time and scores until "
                                         + "user selects a card or time runs out");
                board = game.getBoard();
                preferences();
 
                options();
                draw();
                // While player has not entered 'q'
                do
                {
                        board = game.getBoard();
                        System.out.print(": ");
                        line = input.next();
 
                        rows = getRows();
                        // For each row
                        for(int n1 = 0; n1 < rows; n1++)
                        {
                                //For each column
                                for(int n2 = 0; n2 < cols; n2++)
                                {
                                        String s1 = new String(Integer.toString(n1));
                                        String s2 = new String(Integer.toString(n2));
                                        String finalS = s1.concat(s2);
                                        // If line is equal to a card number on the board
                                        if(line.equals(finalS))
                                        {
                                                 cardSelected(
                                                 board.getCardFromBoard(new 
                                                 Natural(n1), new Natural(n2)));
                                        }
                                }
                        }
 
                        nat = board.getInlaySize();
                        // For each card in the Inlay
                        for(int inlayIndex = 0; inlayIndex < nat.intValue();
                              inlayIndex++)
                        {
                                String s1 = new String(
                                       Integer.toString(inlayIndex));
                                String s2 = new String(Integer.toString(rows));
                                String finalS = s2.concat(s1);
                                // If line is equal to a card number in the inlay
                                if(line.equals(finalS))
                                {
                                         cardSelected(
                                               board.getInlayCard(new Natural(
                                                    inlayIndex)));
                                }
                        }
 
                        option = (char)line.charAt(0); 
                        gameChoice(option);
                }while(option != 'q');
                System.out.println("End of game");
                System.exit(0);
         }

        /**
         *      The options for starting a new game of CardBoard. Allows for
         *      solitaire mode and beginner mode.
         */
         private void preferences()
         {
                char readIn = 'a';
                String line;
                System.out.println("starting a new game");
                System.out.println("enter q to exit, s for solitaire mode, "
                                         + "b for beginner mode");
                //PRINT enter c for competitive mode
                //PRINT enter m for multiplayer mode

                // While user has not entered 'q'. 's', or 'b'
                do
                {
                        System.out.print(": ");
                        line = input.next();
                        readIn = (char)line.charAt(0);
                }while(readIn != 'q' && readIn != 's' && readIn != 'b');
                // If user wants a solitaire game
                if(readIn == 's')
                {
                        game.processAction(ACTION.NEW_SOLITAIRE_GAME);
                }
                // If user wants a beginner game
                else if(readIn == 'b')
                {
                        game.processAction(ACTION.NEW_BEGINNER_GAME);
                }
                // If user wants to quit
                else
                {
                        System.out.println("End of game");
                        System.exit(0);
                }
         }

        /**
         *      Draws the text version of the Card Board game.
         **/
        private void draw()
        {
                int rows;
                SetsBoard board = game.getBoard();
 
                Timer time = game.getTimer();
                Score sc = game.getScore(PLAYER.PLAYER1);
 
                rows = getRows();
                //Print out the time and score
                System.out.print("Timer: " + time.getSeconds() + " seconds");
                System.out.println("    Score: " + sc.getScore());
 
                //Print out the game board vertically for each row
                for(int n1 = 0; n1 < rows; n1++)
                {
                        // Print the game for each column
                        for(int n2 = 0; n2 < cols; n2++)
                        {
                                Card currentPos = board.getCardFromBoard(
                                       new Natural(n1), new Natural(n2));
                                //If the card has previously been selected
                                if(currentPos == null)
                                {
                                        System.out.println(n1 + "" + n2 
                                              + "\tCard has been selected");
                                }
                                //If the card has not been selected
                                else
                                {
                                        System.out.println(n1 + "" + n2 + "\t" 
                                        + currentPos.getShape() + "\t"
                                        + currentPos.getColor() + "\t"  
                                        + currentPos.getFill() + "\t" 
                                        + currentPos.getNumber());
                                }
                        }
                }
                //Print out the cards that have been selected
                System.out.println("\n\nInlay:");
                // For each card in the Inlay
                for(int tempInlaySize = 0; tempInlaySize < inlaySize; tempInlaySize++)
                {
                         Card currentPos = board.getInlayCard(new Natural(
                               tempInlaySize));
                         //If the card has been selected
                         if(currentPos == null)
                         {
                                System.out.println(rows + "" + tempInlaySize 
                                     + "\tEmpty");
                         }
                         //If the card exists on the Inlay
                         else
                         {
                                System.out.println(rows + "" + tempInlaySize + "\t" 
                                + currentPos.getShape() + "\t"  
                                + currentPos.getColor() + "\t" + currentPos.getFill()
                                + "\t" + currentPos.getNumber());
                         }
                }
         }

        /**
         *      Print out all the options a user can input.
         **/
        private void options()
        {
                System.out.println("Options:");
                System.out.println("# of card to select");
                System.out.println("r to refresh screen");
                System.out.println("t for three more");
                System.out.println("n to play a new game (Select this option"
                                       + "to change difficulty or game type");
                System.out.println("p to pause");
                System.out.println("u to unpause game");
                System.out.println("h to recieve a hint");
                System.out.println("o to redisplay options");
                System.out.println("q to quit");
        }

       /**
        *       Turns the enum ROWS into an int representing row size
        *       @return Number of rows
        **/
        private int getRows()
        {
                int rows = 0;
                SetsBoard board = game.getBoard();   
 
                ROWS row = board.getRowSize();
                // If there are four rows
                if(row == ROWS.FOUR)
                {
                       rows = fourRows;
                }
                // If there are five rows
                else if(row == ROWS.FIVE)
                {
                       rows = fiveRows;
                }
                // If there are six rows
                else if(row == ROWS.SIX)
                {
                       rows = sixRows;
                }
                // If there are seven rows
                else
                {
                       rows = sevenRows;
                }      
                return rows;      
        }

       /**
        *       Runs through options for the game, selecting one if
        *       given a valid choice.
        *       @param userChoice the first character the user typed in
        **/
        private void gameChoice(char userChoice)
        {
                // If the user wants to refresh
                if(userChoice == 'r')
                {
                       draw();
                }
                // If the user wants to start a new game
                if(userChoice == 'n')
                {
                      preferences();
                      draw();
                }
                // If the user wants three more
                if(userChoice == 't')
                {
                      game.processAction(ACTION.THREE_MORE);
                      draw();
                }
                // If user wants to pause
                if(userChoice == 'p')
                {
                        game.processAction(ACTION.PAUSE);
                        // Print out a loops number of empty lines
                        for(int blankLines = 0; blankLines < loops;
                             blankLines++)
                        {
                             System.out.println("");
                        }
                }
                // If user wants to unpause
                if(userChoice == 'u')
                {
                        game.processAction(ACTION.UNPAUSE);
                        draw();
                }
                // If user wants a hint
                if(userChoice == 'h')
                {
                        game.processAction(ACTION.HINT);
                        draw();
                }
                // If user wants to view the options
                if(userChoice == 'o')
                {
                        options();
                }                
        }
}

