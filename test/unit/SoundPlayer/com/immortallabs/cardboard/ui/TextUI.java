package com.immortallabs.cardboard.ui;
import java.util.Scanner;

import com.immortallabs.cardboard.CardBoardPreferences;
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
 *      a console. It creates a list of cards with a number to differentiate
 *      each card and then displays it's characteristics. It also creates
 *      a list of the Inlay cards where each has a number so that it can
 *      be selected and the characteristics of the card. The console will print
 *      the timer for the game, and a score for each player of the game. If a
 *      player selects a card on the board it will move to the Inlay and vice 
 *      versa. The game will display if after selecting three cards a correct 
 *      set was created.</p>
 *
 *      <b>Operations:</b>
 *      <ul>
 *      <li>TextUI displays the game state in a console.</li>
 *      <li>TextUI can prompt the user for his or her name and return it.</li>
 *      <li>TextUI can display error and explanation messages.</li>
 *      </ul>
 *
 *      @author         Kyle Williamson
 *      @author         ImmortalLabs CSC308 W09
 *      @version        1.0
 *      @version        1/10/09
 **/

public final class TextUI implements CardBoardUI
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
        
        /** Size of the Inlay **/
        private final int inlaySize = 3;
        
        public static void main(String[] args) 
        {
            // A flag to mark if the application will be running in test mode.
            boolean isNormal = true;
            // DEFINE a GameState
            GameState game;
            
            // FOR EACH argument
            for (String arg : args)
            {
                // IF the argument is "-t"
                if (arg.equals("-t"))
                {
                   // SET that the program will run in test mode.
                   isNormal = false;
                }
            }
            CardBoardPreferences pref = CardBoardPreferences.getInstance();
            pref.setPreference(CardBoardPreferences.PREF.SOUNDS, "OFF");
            
            // CREATE a new GameState.
            game = new GameState(isNormal);
            
            TextUI window = new TextUI(game);
        }

        /**
         *      Instantiates a new version of TextUI for the user to play
         *
         *      @param  logic for the game to display
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
                //Else card is still on the board
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
                System.out.println("\nexpiration penalty: " + message + "\n:");
        }

        /**
         *      Print out the explanation message
         *
         *      @param message  explanation message passed to TextUI
         */
        public void showExplanation(String message)
        {
                System.out.println("\nexplanation: " + message + "\n:");
        }

         /**
         *      Print out the message
         *
         *      @param message  message passed to TextUI
         */
        public void showMessage(String message)
        {
                System.out.println("\nmessage: " + message + "\n:");
        }

        /**
         *      Asks the user to type in a username.
         *
         *      @return username that was chosen.
         */
         public String getName()
         {
                System.out.println("\nplease enter your desired username: ");
                String username = input.nextLine();
                System.out.println(":");
                return username;
         }
         
  /*       public void displayBuzzedPlayer(GameState.PLAYER player)
         {
             
         }*/

        /**
         *      Starts a new game and draws the first board. It then cycles through
         *      until the user enter's a 'q' character. Takes input and checks to
         *      see if it is a number and exists on the board or the inlay, otherwise
         *      calls gameChoice() method with the input.
         */
         private void display()
         {
             String line;
             char option = 'a';
             SetsBoard board;

             System.out.println("Card Board");
             System.out.println("board won't display new time and scores until "
                                      + "user selects a card, refreshes, or time" +
                                      		" runs out");
             //Start the game type the user wants to play
             preferences();
             //Print out the available options
             options();
             //Draw a text version of the game
             draw();
             // While player has not entered 'q'
             do
             {
                 int rows;
                 Natural nat;
                 //Get a current version of the game
                 board = game.getBoard();
                 System.out.print(": ");
                 line = input.next();
 
                 //Set rows to the number of Rows being used in the game
                 rows = getRows();
                 // For each row of the game
                 for(int row = 0; row < rows; row++)
                 {
                     //For each column of the game
                     for(int col = 0; col < cols; col++)
                     {
                         //Create a string out of the row and column
                         String finalString = Integer.toString(row)
                         + Integer.toString(col);
                         // If line is equal to a card number on the board
                         if(line.equals(finalString))
                         {
                             //Set the card as selected
                             cardSelected(board.getCardFromBoard(new 
                             Natural(row), new Natural(col)));
                         }
                     }
                 }
                 //Set nat to the number of cards in the inlay
                 nat = board.getInlaySize();
                 // For each card in the Inlay
                 for(int inlayIndex = 0; inlayIndex < nat.intValue(); inlayIndex++)
                 {
                     //Create a string out of the number of rows and inlay size
                     String finalString = Integer.toString(rows) +
                     Integer.toString(inlayIndex);
                     // If line is equal to a card number in the inlay
                     if(line.equals(finalString))
                     {
                         //Set the card as selected
                         cardSelected(board.getInlayCard(new Natural(inlayIndex)));
                     }
                  }
                //Get the first char of the input string
                option = line.charAt(0); 
                //Call gameChoice to check the input against the options
                gameChoice(option);
                }while(option != 'q');
             System.out.println("End of game");
             System.exit(0);
         }

        /**
         *      The options for starting a new game of CardBoard. Current game
         *      types are solitaire mode, beginner mode, competitive mode, or
         *      multiplayer mode
         */
         private void preferences()
         {
             //Set readIn to a non-valid character in preferences
             char readIn = 'a';
             String line;
             System.out.println("starting a new game\nenter q to exit, " +
                "s for solitaire mode, b for beginner mode, c for " +
                "competitive mode, m for multiplayer mode");
             // While user has not entered 'q', 's', 'b', 'c', or 'm'
             do
             {
                 
                 System.out.print(": ");
                 line = input.next();
                 readIn = line.charAt(0);
             }while(readIn != 'q' && readIn != 's' && readIn != 'b' && 
                     readIn != 'c' && readIn != 'm');
             // If user chose a solitaire game
             if(readIn == 's')
             {
                 game.processAction(ACTION.NEW_SOLITAIRE_GAME);
             }
             // If user chose a beginner game
             else if(readIn == 'b')
             {
                  game.processAction(ACTION.NEW_BEGINNER_GAME);
             }
             // If user chose a competitive game
             else if(readIn == 'c')
             {
                 CardBoardPreferences pref = CardBoardPreferences.getInstance();
                 System.out.print("Enter the time limit you desire" +
                 " [15 seconds(f), 30 seconds(t), 45 second(o), or unlimited(u)]");
                 //Do while input character is not a valid time limit
                 do
                 {
                     System.out.print(":");
                     //Read the first character of input
                     line = input.next();
                     readIn = line.charAt(0);
                 }while(readIn != 'f' && readIn != 't' && readIn != 'o'
                     && readIn != 'u');
                 //If the user chose a fifteen second game
                 if(readIn == 'f')
                 {
                     pref.setPreference(CardBoardPreferences.PREF.TIME_LIMIT, "TIME_15SEC");
                 }
                 //If the user chose a thirty second game
                 else if(readIn == 't')
                 {
                     pref.setPreference(CardBoardPreferences.PREF.TIME_LIMIT, "TIME_30SEC");
                 }
                 //If the user chose a forty-five second game
                 else if(readIn == 'o')
                 {
                     pref.setPreference(CardBoardPreferences.PREF.TIME_LIMIT, "TIME_45SEC");
                 }
                 //If the user chose a unlimited time game
                 else if(readIn == 'u')
                 {
                     pref.setPreference(CardBoardPreferences.PREF.TIME_LIMIT, "TIME_UNLIMITED");
                 }
                 game.processAction(ACTION.NEW_COMPETITIVE_GAME);
             }
             // If chose wants a multiplayer game
             else if(readIn == 'm')
             {
                 CardBoardPreferences pref = CardBoardPreferences.getInstance();
                 System.out.print("Enter the number of players you desire" +
                 		" (min 2, max 4):");
                 //Do while input character is not a valid number of players
                 do
                 {
                     //Read the first character of input
                     line = input.next();
                     readIn = line.charAt(0);
                 }while(readIn != '2' && readIn != '3' && readIn != '4');
                 //If the user chose a 2 player game
                 if(readIn == '2')
                 {
                     pref.setPreference(CardBoardPreferences.PREF.PLAYERS, "PLAYER2");
                 }
                 //If the user chose a 3 player game
                 else if(readIn == '3')
                 {
                     pref.setPreference(CardBoardPreferences.PREF.PLAYERS, "PLAYER3");
                 }
                 //If the user chose a 4 player game
                 else if(readIn == '4')
                 {
                     pref.setPreference(CardBoardPreferences.PREF.PLAYERS, "PLAYER4");
                 }
                 game.processAction(ACTION.NEW_MULTIPLAYER_GAME);
             }
             // If user chose to quit
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
            //Get the timer, and the score for all possible players
            Timer time = game.getTimer();
            Score scoreOne = game.getScore(PLAYER.PLAYER1);
            Score scoreTwo = game.getScore(PLAYER.PLAYER2);
            Score scoreThree = game.getScore(PLAYER.PLAYER3);
            Score scoreFour = game.getScore(PLAYER.PLAYER4);
            //Set rows to the number of Rows being used in the game
            rows = getRows();
                
            //Print out the time, scores, and cards left
            System.out.println("Timer: " + time.getSeconds() + " seconds");
            System.out.println("    Player 1: " + scoreOne.getScore());
            //If there are at least two players
            if(scoreTwo != null)
                System.out.println("    Player 2: " + scoreTwo.getScore());
            //If there are at least three players
            else if(scoreThree != null)
                System.out.println("    Player 3: " + scoreThree.getScore());
            //If there are four players
            else if(scoreFour != null)
                System.out.println("    Player 4: " + scoreFour.getScore());
            System.out.println("Cards left: " + board.getCardsLeft());
            //Print out the game board vertically for each row
            for(int rowNum = 0; rowNum < rows; rowNum++)
            {
                // Print the game for each volume
                for(int colNum = 0; colNum < cols; colNum++)
                {
                    Card currentPos = board.getCardFromBoard(
                            new Natural(rowNum), new Natural(colNum));
                    //If the card has previously been selected
                    if(currentPos == null)
                    {
                        System.out.println(rowNum + "" + colNum 
                                + "\tCard has been selected");
                    }
                    //Else the card has not been selected
                    else
                    {
                        //Print out a cards characteristic
                        System.out.println(rowNum + "" + colNum + "\t" + 
                                currentPos.getShape() + "\t" + 
                                currentPos.getColor() + "\t" + currentPos.getFill()
                                + "\t" + currentPos.getNumber());
                    }
                 }
              }
              //Print out the cards that have been selected
              System.out.println("\n\nInlay:");
              // For each card in the Inlay
              for(int tempInlaySize = 0; tempInlaySize < inlaySize; tempInlaySize++)
              {
                  //Get the current card in the Inlay
                  Card currentPos = board.getInlayCard(new Natural(tempInlaySize));
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
                System.out.println("n to play a new game (Select this option "
                                       + "to change difficulty or game type)");
                System.out.println("p to pause");
                System.out.println("u to unpause game");
                System.out.println("h to recieve a hint");
                System.out.println("o to redisplay options");
                
                System.out.println("q to quit");
                
                System.out.println("These options only work for multiplayer mode");
                System.out.println("! for player 1 to buzz in");
                System.out.println("@ for player 2 to buzz in");
                System.out.println("# for player 3 to buzz in");
                System.out.println("$ for player 4 to buzz in");
        }

       /**
        *       Turns the enum ROWS, which changes depending on the number of 
        *       cards in play, into an int representing row size.
        *       @return Number of rows
        **/
        private int getRows()
        {
            int rows = 0;
            SetsBoard board = game.getBoard();   
 
            ROWS enumRow = board.getRowSize();
            // If there are four rows
            if(enumRow == ROWS.FOUR)
            {
                rows = fourRows;
            }
            // If there are five rows
            else if(enumRow == ROWS.FIVE)
            {
                rows = fiveRows;
            }
            // If there are six rows
            else if(enumRow == ROWS.SIX)
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
            // If the user chose to refresh
            if(userChoice == 'r')
            {
                draw();
            }
            // If the user chose to start a new game
            if(userChoice == 'n')
            {
                preferences();
                draw();
            }
            // If the user chose three more
            if(userChoice == 't')
            {
                game.processAction(ACTION.THREE_MORE);
                draw();
            }
            // If user chose to pause
            if(userChoice == 'p')
            {
                game.processAction(ACTION.PAUSE);
                // Print out a loops number of empty lines
                for(int blankLines = 0; blankLines < loops; blankLines++)
                {
                    System.out.println("");
                }
            }
            // If user chose to unpause
            if(userChoice == 'u')
            {
                game.processAction(ACTION.UNPAUSE);
                draw();
            }
            // If user chose a hint
            if(userChoice == 'h')
            {
                game.processAction(ACTION.HINT);
                draw();
            }
            // If user chose to view the options
            if(userChoice == 'o')
            {
                options();
            }         
            // Player 1 has buzzed in
            if(userChoice == '!')
            {
                game.processAction(ACTION.P1_BUZZED_IN);
            }  
            // Player 2 has buzzed in
            if(userChoice == '@')
            {
                game.processAction(ACTION.P2_BUZZED_IN);
            }  
            // Player 3 has buzzed in
            if(userChoice == '#')
            {
                game.processAction(ACTION.P3_BUZZED_IN);
            }  
            // Player 4 has buzzed in
            if(userChoice == '$')
            {
                game.processAction(ACTION.P4_BUZZED_IN);
            }  
        }

    /**
     * Reveal the player who is currently buzzed in, for multiplayer mode
     */
    public void displayBuzzedPlayer(PLAYER player) 
    {
    	if(player != null)
    		System.out.println(player + ": ");
    }
}

