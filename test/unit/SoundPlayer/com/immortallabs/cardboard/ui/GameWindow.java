package com.immortallabs.cardboard.ui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.immortallabs.cardboard.CardBoardResource; 
import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.game.SetsBoard;

import edu.profdalbey.Natural;

/**
 * <p>
 * Displays the state of the CardBoard game in a single window.
 * </p>
 * 
 * <b>Operations:</b>
 * <ul>
 * <li>GameWindow displays the game state in a window.</li>
 * <li>GameWindow can return the current x,y coordinates of the open inlay
 * slot.</li>
 * <li>GameWindow can prompt the user for his or her name and return it.</li>
 * </ul>
 * 
 * @author Lamont Samuels
 * @author Immortal Labs CSC309 W09
 * @author Sky Eckstrom
 * @author Rusty Nail CSC308 F08
 * @version 1.2
 * @version 01/12/08
 * 
 * @history - 01/19/08 1.2 Updated the Psuedocode - 01/12/08 1.2 Updated Author
 *          Tags, Added the Following instance variables: - hintButton -
 *          pauseButton - threeMoreButton - explainWhyButton - - 12/04/08 1.1
 *          Added Version History & Pseudocode<br> - 11/30/08 1.0 Inital Class
 *          Skeleton<br>
 */

public class GameWindow extends javax.swing.JPanel implements CardBoardUI, ActionListener
{
   /**
    * INLAY represents the different open inlay positions.
    */
   public enum INLAY
   {
      /** Inlay spot one * */
      ONE,

      /** Inlay spot two * */
      TWO,

      /** Inlay spot three * */
      THREE;
   }

   /**
    * DIRECTION represents the different movement directions for the selected
    * card.
    */
   public enum DIRECTION
   {
      /** Move up * */
      UP,

      /** Move down * */
      DOWN,

      /** Move left * */
      LEFT,

      /** Move right * */
      RIGHT;
   }

   /** the height of the window * */
   public final int kWindowHeight = 730;

   /** the width of the window */
   public final int kWindowWidth = 780;

   /** Holds the selected card * */
   private CardGraphic selected;

   /** reference of the GameState */
   private GameState state;

   /** represents the first inlaySpot */
   private final int firstInlay = 0;

   /** represents the second inlaySpot */
   private final int secondInlay = 1;

   /** represents the third inlaySpot */
   private final int thirdInlay = 2;

   /** The Card Components currently displayed */
   private CardGraphic[][] cards;

   /** Represents the max number of cards in the lay */ 
   private final int kInlaySize = 3; 
   
   /** The Card components currently in the inlay */
   private CardGraphic[] inlay;

   /** Represents the x location of the inlay cards */
   private final int inlayX = 35;

   /** Represents the y locations of the inlay cards */
   private final int[] inlayY = {30, 145, 255};

   /** Represents the message the game wants to display to the user */ 
   private String message; 
   
   /** Represents if a message needs to be displayed to the user */ 
   private boolean hasMessage = false; 
   
   /** Represents the font size of pause prompt */
   private final int kPauseSize = 16;

   /** Represents the font size of welcome prompt */
   private final int kWelcomeSize = 15;

   /** Represents the composite shade value */
   private final float kComposite = 0.75f;
   /** Represents the x location of the buttons */
   private final int buttonsX = 25;
   
   /** Represents the fileName for background image */
   private final String kBackgroundFile = "background.jpg";

   /** Represents the fileName for message image */
   private final String kMessageFile = "messageBox.jpg";
   
   /** Represents the number of columns for the cards */
   private final int kColumns = 3;

   /** Represents the max number of rows for the cards */
   private final int kRowsMax = 7;
   
   /** Represents the location of the message box */ 
   private final Point messageLoc = new Point(250,205); 
   
   /** Represents the delay time for showing a message for a valid set*/ 
   private final int delayTimeValid = 800; 
   
   /** Represents the delay time for showing a message for a invalid set */ 
   private final int delayTimeInvalid = 3000; 
   
   /** Represents the delay time for showing a message for a invalid set */ 
   private final int delayTimeMessage = 1500; 
   
   /** Represents the start location of message prompt */ 
   private final Point messagePromptLoc = new Point(340,295);

   /** Represents the message prompt text size */
   private final int kMessageSize = 13; 
   
   /** Represents the y locations of the buttons */
   private final int[] buttonsY = {373, 438, 503, 568};

   /** Represents the beginning card location */
   private final Point cardStartLoc = new Point(235, 30);

   /** Represents the X offset for the cards */
   private final int kCardXOffset = 20;

   /** Represents the backgrounds location */
   private final Point backgroundStartLoc = new Point(0, 0);

   /** Represents the Y offset for the cards */
   private final int kCardYOffset = 20;

   /** Represents the scaleIndex */
   private int scaleIndex;

   /** Represents the hint button Index */
   private final int kHintIndex = 0;

   /** Represents the pause button index */
   private final int kPauseIndex = 1;

   /** Represents the threeMore button index */
   private final int kThreeMoreIndex = 2;

   /** Represents the explain button index */
   private final int kExplainIndex = 3;

   /** Represents the first scalar index */
   private final int kFirstScalar = 0;

   /** Represents the two scalar index */
   private final int kSecondScalar = 1;

   /** Represents a second in milliseconds */
   private final int kSecond = 1000;

   /** Represents the third scalar index */
   private final int kThirdScalar = 2;

   /** Represents current number of rows */
   private int numberOfRows;

   /** Represents the number of rows the game could have */
   private final int[] kCardRows =
   {4, 5, 6, 7};

   /** Represents the scale width sizes for the cards */
   private final int[] kCardWidth =
   {150, 130, 110};

   /** Represents the scale height sizes for the cards */
   private final int[] kCardHeight =
   {100, 80, 60};

   /** Represents the actionMap with this game */
   private ActionMap map;

   /** Represents the width of a button */
   private final Dimension kButtonDimesion = new Dimension(180, 50);

   /** Represents the hint button */
   private CardBoardButton hintButton;

   /** Represents the pause button */
   private CardBoardButton pauseButton;

   /** Represents the explain button */
   private CardBoardButton explainButton;

   /** Represents the threeMore button */
   private CardBoardButton threeMoreButton;

   /** Represents the timer's location */
   private final Point timeLoc = new Point(35, 655);

   /** Represents the score's location */
   private final Point scoreLoc = new Point(235, 655);
   
   /** Represents the cards left location */
   private final Point cardsLeftLoc = new Point(650,655); 

   /** Represents if the game is paused */
   private boolean isPaused;

   /** Represents if the application just launched */
   private boolean isWelcome;

   /** Represents the x location of the rectangle to paint over the cards */
   private final Point paintOverLoc = new Point(220, 5);

   /** Represents the paint over width for pausing */
   private final Dimension paintOverDimesion = new Dimension(551, 612);

   /** Represents the paint over message location */
   private final Point paintOverMessageLoc = new Point(235, 260);

   /** Represents the resume button location */
   private final Point resumeButtonLoc = new Point(420, 275);

   /** Represents the start button location */
   private final Point startButtonLoc = new Point(305, 305);

   /** Represents the start prompt location */
   private final Point startPromptLoc = new Point(160, 290);

   /** Represents the backgrounds width and height */
   private final Dimension background = new Dimension(780, 686);

   /** Represents the welcome button */
   private CardBoardButton welcomeButton;
   
   /** Represents the currently selected column */
   private int selectedCol = 0; 
   
   /** Represents the currently selected row */
   private int selectedRow = 0; 

   /** Represents the resume button */
   private CardBoardButton resumeButton;


   /** Represents the Menu Bar for the game */
   public CardBoardMenu menu;

   /** Represents the Game's ScoreGraphic */
   private ScoresGraphic scores; 
   
   /** Allows for repaiting the timerGraphic every second */
   private javax.swing.Timer repaintTimer;
   
   private Graphics bufferedGraphic;
   private Image offImage;
   
   /**
    * Instantiates a new game window that will display the state of the game
    * held in GameState.
    * 
    * @param offimage
    *           the offscreen image to get the graphics from. 
    */
   public GameWindow(boolean isNormal) 
   { 
      super();
      init(isNormal);
   }
   public void init(boolean isNormal) 
   {
      // CALL setUserInterface on GameState passing a copy of self
      state = new GameState(isNormal); 
      state.setUserInterface(this);
      // CREATE new ActionMap
      map = new ActionMap(state, this);
      
      // CREATE the cards array
      cards = new CardGraphic[kRowsMax][kColumns];

      // CREATE the inlay cards.
      inlay = new CardGraphic[kColumns];

      // CALL setSize with sizes of the GameWindow
      setSize(kWindowWidth, kWindowHeight);

      // ADD a mouseListener with ActionMap
      this.addMouseListener(map);
      
      this.addKeyListener(map); 

      // CREATE a new CardBoardMenu
      menu = new CardBoardMenu(map);

      // SET isPaused to false
      isPaused = false;

      // SET repaint timer to paint every second
      repaintTimer = new javax.swing.Timer(kSecond, this);

      // SET isWelcome to true
      isWelcome = true;
      
   }
   /**
    * Creates the off screen image
    */
   public void makeImageBuffer()
   {
      //CREATE an offscreen image 
      offImage = this.createImage(kWindowWidth, kWindowHeight);
      
      //GET the graphics from the offscreen image 
      bufferedGraphic = offImage.getGraphics();
   }
   private void highlightCard(CardGraphic card)
   {
      boolean done = false; 
      for (int row = 0; row < numberOfRows && !done; row++)
      {
         // FOR each column in the board
         for (int col = 0; col < kColumns && !done; col++)
         {
            if(cards[row][col] != null)
            {
               if (cards[row][col].getCard().equals(card.getCard()))
               {
                 //ASSIGN card to the card clicked 
                  selectedRow = row; 
                  selectedCol = col; 
                  done = true; 
               }

            }
         }
      }
   }
   /**
    * Sets the selected card to the clicked card.
    * 
    * @param card
    *           the card that was selected
    */
   public void cardClicked(CardGraphic card)
   {
      // SET selected to the card
      this.selected = card;
   
      if(!state.getBoard().isInInlay(card.getCard()))
      {
         highlightCard(card); 
         getRightCard(); 
      }
      // ANIMATE the card to the openInlaySlot
      // card.animateTo(getOpenInLaySpot());

      // CALL map.CardClicked with card
      map.cardClicked(card);

      // Repaint the screen
      repaint();
   }
   /**
    * Moves the selected card in the specified direction
    * 
    * @param dir
    *           the direction to move
    */
   public void moveSelector(DIRECTION dir)
   {
      if(dir == DIRECTION.UP)
      {
         getUpCard(); 
      }
      else if(dir == DIRECTION.DOWN)
      {
         getDownCard(); 
      }
      else if(dir == DIRECTION.LEFT)
      {
         getLeftCard();
      }
      else if(dir == DIRECTION.RIGHT)
      {
         getRightCard(); 
      }
      Graphics g = this.getGraphics(); 
      paint(g); 
   }
   private void getLeftCard () 
   { 
      //CREATE card = null 
      SetsBoard board = state.getBoard(); 

      boolean done = false; 
      
      int row = selectedRow; 
      int col = selectedCol - 1; 
      
      // FOR each row in the game board
      do
      {
         if(row == 0 && col < 0)
         {
           row = this.kCardRows[board.getRowSize().ordinal()] - 1; 
           col = this.kColumns - 1;
         }
         else if(col < 0)
         {
           col = this.kColumns - 1;
           row--; 
         }
         
         if(cards[row][col] != null)
         {
            done = true;
         }
         else 
         {
            col--; 
         }
         
      }
      while(!done);
      
      selectedRow = row; 
      selectedCol = col; 
   }
   private void getUpCard () 
   { 
      boolean done = false; 
      
      int row = selectedRow - 1; 
      int col = selectedCol; 
      
      // FOR each row in the game board
      do
      {
         if(row < 0)
         {
           row = 0; 
           done= true; 
         }     
         else 
         {
            if(cards[row][col] != null)
            {
               done = true;  
            }
            else 
            {
               row -= 1; 
            }
         }
         
      }
      while(!done);
      
      selectedRow = row; 
      selectedCol = col; 
   }
   private void getDownCard () 
   { 
      //CREATE card = null 
      SetsBoard board = state.getBoard(); 

      boolean done = false; 
      
      int row = selectedRow +  1; 
      int col = selectedCol; 
      
      // FOR each row in the game board
      do
      {
         if(row >  this.kCardRows[board.getRowSize().ordinal()])
         {
           row = this.kCardRows[board.getRowSize().ordinal()] -1; 
           done = true; 
         } 
         else 
         {
            if(cards[row][col] != null)
            {
               done = true;  
            }
            else 
            {
               row += 1; 
            }
            
         }
         
      }
      while(!done);
      
      selectedRow = row; 
      selectedCol = col; 
   }
   private void getRightCard() 
   { 
      //CREATE card = null 
      SetsBoard board = state.getBoard(); 

      boolean done = false; 
      
      int row = selectedRow; 
      int col = selectedCol + 1; 
      
      // FOR each row in the game board
      do
      {
         if(row == kCardRows[board.getRowSize().ordinal()]-1  && col >= this.kColumns)
         {
           row = 0; 
           col = 0;
         }
         else if(col >= kColumns)
         {
           col = 0;
           row++; 
         }
         
         if(cards[row][col] != null)
         {
            done = true;
         }
         else 
         {
            col++; 
         }
         
      }
      while(!done);
      
      selectedRow = row; 
      selectedCol = col; 
   }
   /**
    * The object on which the event initially occurred.
    * 
    * @param x
    *           the x location where the mouse was pressed
    * @param y
    *           the y location where the mouse was pressed
    * @return The object on which the event initially occurred.
    */
   public Object getSource(int x, int y)
   {
      // CREATE objectInLay = CALL to checkInLay with x and y 
      Object objectInLay = checkInLay(x, y);

      // CREATE objectCards = CALL to checkCards with x and y 
      Object objectCards = checkCards(x, y);

      // CREATE objectButton = CALL to checkButtons with x and y 
      Object objectButton = checkButtons(x, y);

      // IF objectInLay is not null and the game isn't paused THEN
      if (objectInLay != null && !isPaused)
      {
         // RETURN objectInLay
         return objectInLay;
      }
      // ELE IF objectCards is not null and the game isn't paused THEN
      else if (objectCards != null && !isPaused)
      {
         // RETURN objectCards
         return objectCards;
      }
      // ELSE IF objectButton is not null THEN
      else if (objectButton != null)
      {
         // RETURN objectButton
         return objectButton;
      }
      // ELSE
      else
      {
         // RETURN the instance of GameWindow 
         return this;
      }

   }
   /**
    * Sets the references to the window's game state
    * @param state
    *             a reference to the game's state. 
    */
   public void setGameState (GameState state)
   {
      this.state = state; 
      // CALL setUserInterface on GameState passing a copy of self
      state.setUserInterface(this);
      // CREATE new ActionMap
      map = new ActionMap(state, this);
   }

   /**
    * Checks to see if the mouse clicked on one of the inlay cards
    * 
    * @param x
    *           the x location where the mouse was pressed
    * @param y
    *           the y location where the mouse was pressed
 
    * @return an inlay card if the x and y is within the bounds of the card,
    *         otherwise NULL
    */
   private CardGraphic checkInLay(int x, int y)
   {
      //CREATE card = null 
      CardGraphic card = null;


         // IF the x and y is within the bounds of the first in lay card THEN 
         if ((x >= inlayX && x <= (inlayX + kCardWidth[scaleIndex]))
               && ((y >= inlayY[firstInlay]) && (y <= inlayY[firstInlay]
                     + kCardHeight[scaleIndex])))
         {
            // IF the first inlay card exists  THEN
            if (inlay[firstInlay] != null)
            {
            // ASSIGN card to be the first inlay card
            card = inlay[firstInlay];
            }
         }
         // ELSE IF the x and y is within the bounds of the second in lay card THEN
         else if ((x >= inlayX && x <= (inlayX + kCardWidth[scaleIndex]))
               && ((y >= inlayY[secondInlay]) && (y <= inlayY[secondInlay]
                     + kCardHeight[scaleIndex])))
         {
            // IF the second inlay card exists  THEN
            if (inlay[secondInlay] != null)
            {
            // ASSIGN the second inlay card
               card = inlay[secondInlay];
            }
         }
         // ELSE IF the x and y is within the bounds of the third in lay card THEN
         else if ((x >= inlayX && x <= (inlayX + kCardWidth[scaleIndex]))
               && ((y >= inlayY[thirdInlay]) && (y <= inlayY[thirdInlay]
                     + kCardHeight[scaleIndex])))
         {
            // IF the third inlay card exists  THEN
            if (inlay[thirdInlay] != null)
            {
               // RETURN the third inlay card
               card = inlay[thirdInlay];
            }
         }
      
      //RETURN card 
      return card;
   }

   /**
    * Checks to see if the mouse clicked on a card
    * 
    * @param x
    *           the x location where the mouse was pressed
    * @param y
    *           the y location where the mouse was pressed
    * @return a card if the x and y is within the bounds of the card, otherwise
    *         NULL
    */
   private CardGraphic checkCards(int x, int y)
   {
      //CREATE card = null 
      CardGraphic card = null;

      //CREATE cardX = the starting location of the first card on the board
      int cardX = cardStartLoc.x;
      
      //CREATE cardY = the starting location of the second card on the board
      int cardY = cardStartLoc.y;

      // FOR each row in the game board
      for (int row = 0; row < numberOfRows; row++)
      {
         // FOR each column in the board
         for (int col = 0; col < kColumns; col++)
         {
            // IF the x and y is within the bounds of the card THEN
            if ((x >= cardX && x <= (cardX + kCardWidth[scaleIndex]))
                  && ((y >= cardY) && (y <= cardY + kCardHeight[scaleIndex])))
            {
               //IF the card is exists within the board THEN 
               if (cards[row][col] != null)
               {
                 //ASSIGN card to the card clicked 
                  card = cards[row][col];
               }

            }
            // ASSIGN cardX = to the xCoordinate of the next card
            cardX = cardX + kCardXOffset + kCardWidth[scaleIndex];
         }
         // REASSIGN cardX = to the starting x location of the first card 
         cardX = cardStartLoc.x;
         
         // ASSIGN cardY = to the next row on the game board 
         cardY = cardY + kCardYOffset + kCardHeight[scaleIndex];
      }

      // RETURN card
      return card;
   }

   /**
    * Check to see if the mouse clicked on a button
    * 
    * @param x
    *           the x location where the mouse was pressed
    * @param y
    *           the y location where the mouse was pressed
    * @return a button if the x and y is within the bounds of the button,
    *         otherwise NULL
    */
   private Object checkButtons(int x, int y)
   {
      //CREATE button = nul;l 
      CardBoardButton button = null;

      // IF the x and y is within the bounds of the hint button THEN
      if ((x >= buttonsX && x <= (buttonsX + kButtonDimesion.width))
            && ((y >= buttonsY[kHintIndex]) && (y <= buttonsY[kHintIndex]
                  + kButtonDimesion.height)))
      {
         // ASSIGN button to the hint button
         button = hintButton;

      }

      // ELSE IF the x and y is within the bounds of the pause button THEN
      else if ((x >= buttonsX && x <= (buttonsX + kButtonDimesion.width))
            && ((y >= buttonsY[kPauseIndex]) && (y <= buttonsY[kPauseIndex]
                  + kButtonDimesion.height)))
      {
         // ASSIGN button to the pause button
         button = pauseButton;

      }
      // ELSE IF the x and y is within the bounds of the three more button THEN
      else if ((x >= buttonsX && x <= (buttonsX + kButtonDimesion.width))
            && ((y >= buttonsY[kThreeMoreIndex]) && (y <= buttonsY[kThreeMoreIndex]
                  + kButtonDimesion.height)))
      {
         // ASSIGN button to the three more button
         button = threeMoreButton;

      }
      // ELSE IF the x and y is within the bounds of the explain button THEN
      else if ((x >= buttonsX && x <= (buttonsX + kButtonDimesion.width))
            && ((y >= buttonsY[kExplainIndex]) && (y <= buttonsY[kExplainIndex]
                  + kButtonDimesion.height)))
      {
         // ASSIGN button tp the explain button
         button = explainButton;

      }
      // ELSE IF the x and y is within the bounds of the welcome button THEN
      else if ((x >= startButtonLoc.x && x <= (startButtonLoc.x + kButtonDimesion.width))
            && ((y >= startButtonLoc.y) && (y <= startButtonLoc.y
                  + kButtonDimesion.height)) && isWelcome == true)
      {
         // ASSIGN button to the explain button
         button = welcomeButton;

      }
      // ELSE IF the x and y is within the bounds of the welcome button THEN
      else if ((x >= resumeButtonLoc.x && x 
                <= (resumeButtonLoc.x + kButtonDimesion.width))
               && ((y >= resumeButtonLoc.y) && (y <= resumeButtonLoc.y
                  + kButtonDimesion.height)) && isPaused == true)
      {
         // ASSIGN button to the explain button
         button = resumeButton;

      }
      // RETURN button
      return button;
   }

   /**
    * Shows the user the explanation behind a correct or incorrect set.
    * 
    * @param message
    *           A string containing the explanation to display
    */
   public void showExpirationPenalty(String message)
   {
      // CALL showMessage with message
      showMessage(message); 
   }
   /**
    * Shows the user the timer expiration penalty message.
    * 
    * @param message
    *           A string containing the penalty message
    */
   public void showExplanation(String message)
   {
      // CONSTRUCT TRY
      try
      {
         // CREATE a new BufferedImage img
         BufferedImage img;
         
         //GET the GameWindow's graphics 
         Graphics g = this.getGraphics(); 
         
         if(this.state.getBoard().isInlaySet())
         {
             img = CardBoardResource.getImage(this,"validSetMessage.jpg");
             //Paint the message background box and message 
             paint(g); 
             g.drawImage(img, messageLoc.x, messageLoc.y, null);
             
             //Pause the timer for 2 seconds for the message to display. 
             repaintTimer.stop(); 
             Thread.sleep(delayTimeValid); 
             repaintTimer.start(); 
 
         }
         else
         {
             img = CardBoardResource.getImage(this,"invalidSetMessage.jpg");
             //Paint the message background box and message and show explain button
             paint(g); 
             paintExplain(g); 
             g.drawImage(img, messageLoc.x, messageLoc.y, null);  
             
             repaintTimer.stop(); 
             Thread.sleep(delayTimeInvalid); 
             repaintTimer.start(); 
             
         }

      } 
     catch (InterruptedException e)
      {
         e.printStackTrace();
      } 
   }
   public void showMessage (String message)
   {
      // CONSTRUCT TRY
      try
      {
         // CREATE a new BufferedImage img
         BufferedImage img =  CardBoardResource.getImage(this,this.kMessageFile);
         
         //Paint the message background box and message 
         Graphics g = this.getGraphics(); 
         paint(g); 
         g.drawImage(img, messageLoc.x, messageLoc.y, null);
         Font font = new Font("TimesRoman", Font.BOLD, kMessageSize);
         g.setFont(font);
         g.drawString(message, messagePromptLoc.x, messagePromptLoc.y);
         repaintTimer.stop(); 
         Thread.sleep(delayTimeMessage); 
         repaintTimer.start(); 
      } 
     catch (InterruptedException e)
      {
         e.printStackTrace();
      } 
      
   }
   /**
    * Removes the last set displayed in the inlay.
    */
   public void clearLastSet()
   {
      // CALL paint to fresh the window with the inlays removed
      repaint();
   }
   /**
    * Retrieves the name/handle of the current player from the User Interface.
    * 
    * @return The name or handle of the player who received the high score
    */
   public String getName()
   {
      // CREATE a string for the name
      String name = "";
      
      // CREATE a string with a prompt asking for name
      String prompt = "Please enter in your name.";
      
      // CALL JOptionPane.showInputDialog with prompt and ASSIGN it to name
     //name = JOptionPane.showInputDialog(null, prompt);
      
      //RETURN the name
      return name;
   }

   /**
    * Notifies GameWindow that the theme has changed.
    */
   public void themeChanged()
   {
      // LOAD the new background image
      // FOR each button in the display
      // NOTIFY the button of the new theme
   }

   /**
    * Displays the button of the given type in the game window.
    * 
    * @param btn
    *           the button type to display
    */
   public void showButton(CardBoardButton.BUTTONTYPE btn)
   {
      // IF the btn is equaled to the pause button THEN
      if (btn == CardBoardButton.BUTTONTYPE.PAUSE)
      {
         // SET isPaused to true
         isPaused = true;
      }
      repaint();
   }
   public void displayBuzzedPlayer(GameState.PLAYER player)
   {
       scores.setBuzzedPlayer(player); 
       repaint(); 
   }
   /**
    * Removes the button of the given type from the game window.
    * 
    * @param btn
    *           the button type to remove
    */
   public void removeButton(CardBoardButton.BUTTONTYPE btn)
   {
      // IF the btn is equaled to the unpause button THEN
      if (btn == CardBoardButton.BUTTONTYPE.UNPAUSE)
      {
         // SET isPaused to false
         isPaused = false;
      }
      // ELSE if the btn is equaled to the welcome button THEN
      else if (btn == CardBoardButton.BUTTONTYPE.WELCOME)
      {
         // SET isWeclome to false
         isWelcome = false;
         state.processAction(GameState.ACTION.NEW_SOLITAIRE_GAME);
         repaintTimer.start();

      }
      repaint();
   }

   /** 
    * Updates the window by calling the paint method 
    * @param g the graphics for painting to the window 
    */
   public void update(Graphics g)
   {
      //CALL paint with g
      paint(g); 
   }

   /**
    * Paints all components to the window 
    * @param g  
    *            the graphics to paint the components to 
    *           
    */
   public void paint(Graphics g)
   {
         // IF the welcome screen should be displayed 
         if (isWelcome)
         {
            //IF the offscreen image is not equal to null 
            if(bufferedGraphic != null)
            {
               // CREATE a new offscreen image 
               bufferedGraphic.clearRect(0, 0, kWindowWidth, kWindowHeight);
               
               // CALL paintBackground with bufferedGraphic
               paintBackground(bufferedGraphic);
               
               // CALL paintBackground with bufferedGraphic
               paintWelcome(bufferedGraphic);
            }
         }
         // ELSE IF the game is not paused then paint the cards and buttons
         else if (!isPaused)
         {

            // DETERMINE the current scale size
            scaleIndex = kFirstScalar;
            
            SetsBoard.ROWS row = state.getBoard().getRowSize(); 
            
            // IF row size of the board is five THEN
            if (row == SetsBoard.ROWS.FIVE)
            {
               // SET the scale size to the first card size
               scaleIndex = kFirstScalar;
            }
            // ELSE IF the row size of the board is six THEN
            else if (row == SetsBoard.ROWS.SIX)
            {
               // SET the scale size to the second card size
               scaleIndex = kSecondScalar;
            }
            // ELSE IF the row size of the board is seven THEN
            else if (row == SetsBoard.ROWS.SEVEN)
            {
               // SET the scale size to the third card size
               scaleIndex = kThirdScalar;
            }
            // Determine the number of rows currently on the board
            numberOfRows = kCardRows[state.getBoard().getRowSize().ordinal()];
            
            // CREATE an offscreen buffered graphic image 
            bufferedGraphic.clearRect(0, 0, kWindowWidth, kWindowHeight);
       
            // CALL paintBackground with bufferedGraphic
            paintBackground(bufferedGraphic);
            
            paintSelectedCard(bufferedGraphic);
            // CALL paintInLayCards with bufferedGraphic
            paintInLayCards(bufferedGraphic);
            // CALL paintCards with bufferedGraphic
            paintCards(bufferedGraphic);
            paintCardCount(bufferedGraphic); 
            
            // CALL paintButtons with bufferedGraphic 
            paintButtons(bufferedGraphic);
            // CALL paintScore with bufferedGraphic
            paintScore(bufferedGraphic);
            // CALL paintTimer with bufferedGraphic
            paintTimer(bufferedGraphic);
                      
         }
         // ELSE paint over the cards and paint the resume button
         else
         {
            // CREATE an offscreen buffered graphic image 
        	   bufferedGraphic.clearRect(0, 0, kWindowWidth, kWindowHeight);
        	           	   
        	   //CALL paintBackground with bufferedGraphic 
        	   paintBackground(bufferedGraphic);
        	   // CALL paintInLayCards with bufferedGraphic
            paintInLayCards(bufferedGraphic);
            // CALL paintOver with bufferedGraphic
            paintOver(bufferedGraphic);
            // CALL paintScore with bufferedGraphic
            paintScore(bufferedGraphic);
            // CALL paintTimer with bufferedGraphic
            paintTimer(bufferedGraphic);
         }
         // DRAW the offscreen image 
         g.drawImage(offImage, 0, 0, this);

   }

   /**
    * Paints all cards currently in the inlay
    * 
    * @param g
    *           the graphics component to paint the cards to.
    */
   private void paintInLayCards(Graphics g)
   {
      // CREATE setsBoard
      SetsBoard board;
      
      // CALL gameState.getBoard() and ASSIGN to setsBoard
      board = state.getBoard();

      // Clear the inlay cards.
      inlay = new CardGraphic[kColumns];

      // FOR each Card in the lay
      for (int index = 0; index < kInlaySize; index++)
      {
         // ASSIGN tempCard to the card
         Card tempCard = board.getInlayCard(new Natural(index));

         //IF a inlay card exisits 
         if (tempCard != null)
         {
            // CREATE a new CardGraphic with tempCard
            CardGraphic card = new CardGraphic(tempCard, map, new Natural(0),
                  new Natural(0), this, new Point(inlayX, inlayY[index]));

           
              // SCALE the card to a row size of 5
               card.scaleTo(board.getRowSize());
         
            // ADD the CardGraphic to the inylay cards
            inlay[index] = card;

            // PAINT the CardGraphic
            card.paint(g);
         } 
         // ELSE
         else
         {
            //INSERT a blank card into the inlay
            inlay[index] = null;

         }
      }
   }

   /**
    * Paints the background to the screen
    * 
    * @param g
    *           the graphics component to paint the cards to.
    */
   private void paintBackground(Graphics g)
   {
         // CONSTRUCT a 2D graphics from g
         Graphics2D g2d = (Graphics2D) g;
         
         // SET 2D graphics composite to 100%
         g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
               1f));
         
         // CREATE a new BufferedImage img
         BufferedImage img = CardBoardResource.getImage(this, kBackgroundFile); 
         

         // CALL g.drawImage with img, background's x location, backgrounds's y
         // location, and null
         g.drawImage(img, backgroundStartLoc.x, backgroundStartLoc.y, null);
   }

   /**
    * Paints all the cards to the screen
    * 
    * @param g
    *           the graphics component to paint the cards to.
    */
   private void paintCards(Graphics g)
   {
      //CONSTRUCT two ints cardX, and cardY
      int cardX = 0, cardY = 0;
      
      // CREATE setsBoard
      SetsBoard board;
      
      // CALL gameState.getBoard() and ASSIGN to setsBoard
      board = state.getBoard();      

      // GET rowSize
      int size = kCardRows[(board.getRowSize()).ordinal()];

      //SET cardX and cardY to the starting coordinates of the first board card. 
      cardX = cardStartLoc.x;
      cardY = cardStartLoc.y;

      // FOR each row in the setsBoard
      for (int row = 0; row < size; row++)
      {

         // FOR each col in the setsBoard
         for (int col = 0; col < kColumns; col++)
         {
            // CALL setsBoard.getCardFromBoard with row and col
            Card tempCard = board.getCardFromBoard(new Natural(row),
                  new Natural(col));

            //IF a card exists  
            if (tempCard != null)
            {
               // CONSTRUCT a CardGraphic with card
               CardGraphic card = new CardGraphic(tempCard, map, new Natural(
                     row), new Natural(col), this, new Point(cardX, cardY));
               
               // ADD the CardGraphic to cards
               cards[row][col] = card;
              
              //Scale the card to the right side. 
              card.scaleTo(board.getRowSize());
              
               // PAINT the CardGraphic
               card.paint(g);
            } 
            //ELSE 
            else
            {
               // INSERT a empty card 
               cards[row][col] = null;
            }
            // GET the xCoordinate of the next card 
            cardX = cardX + kCardWidth[scaleIndex] + kCardXOffset;
         }
         // RESET the starting XCoordinate 
         cardX = cardStartLoc.x;
         // GET the yCoordinate of the next row 
         cardY = cardY + kCardHeight[scaleIndex] + kCardYOffset;
      }
   }

   /**
    * Paints all buttons to the screen
    * 
    * @param g
    *           the graphics component to paint the cards to.
    */
   private void paintButtons(Graphics g)
   {
      // CONSTRUCT a hint CardBoardButton with
      // the hint's x location, hint's y location,
      // GameWindow's actionmap,
      // CardBoardButton.BUTTONTYPE.HINT, and 
      // "Hint" as the string
      hintButton = new CardBoardButton(
            new Point(buttonsX, buttonsY[kHintIndex]), map,
            CardBoardButton.BUTTONTYPE.HINT, "Hint");

      // CONSTRUCT a pause CardBoardButton with
      // the pause's x location, pause's y location,
      //  GameWindow actionmap,
      // CardBoardButton.BUTTONTYPEE.PAUSE, and
      // "Pause" as the string
      pauseButton = new CardBoardButton(new Point(buttonsX,
            buttonsY[kPauseIndex]), map, CardBoardButton.BUTTONTYPE.PAUSE,
            "Pause");

      // CONSTRUCT a threeMore CardBoardButton with
      // the threeMore's x location, threeMore's y location,
      // GameWindow's actionmap
      // CardBoardButton.BUTTONTYPE.THREEMORE
      // "3 More Cards" as the string.
      threeMoreButton = new CardBoardButton(new Point(buttonsX,
            buttonsY[kThreeMoreIndex]), map,
            CardBoardButton.BUTTONTYPE.THREEMORE, "3 More Cards");
      
      // PAINT hint
      hintButton.paint(g);
      // PAINT pause
      pauseButton.paint(g);
      // PAINT threeMore
      threeMoreButton.paint(g);
   }

   /**
    * Paints over the cards and paints a resume button in the middle
    * 
    * @param g
    *           the graphics component to paint the cards to.
    */
   private void paintOver(Graphics g)
   {
      // SET the color to black
      g.setColor(Color.black);
      
      // Cover the cards
      g.fillRect(paintOverLoc.x, paintOverLoc.y, paintOverDimesion.width,
            paintOverDimesion.height);
      
      // SET the color to white
      g.setColor(Color.white);

     
      // SET the font of the prompt to be Times New Roman, bold and to welcome's text size
      Font font = new Font("TimesRoman", Font.BOLD, kPauseSize);
      
      g.setFont(font);
      
      // DRAW the prompt message to the screen
      g.drawString(
            "Please click on the resume button to continue playing the game",
            paintOverMessageLoc.x, paintOverMessageLoc.y);

      // CONSTRUCT the resume button
      resumeButton = new CardBoardButton(resumeButtonLoc, map,
            CardBoardButton.BUTTONTYPE.UNPAUSE, "Resume");

      // PAINT the resumeButton
      resumeButton.paint(g);
   }

   /**
    * Paints the welcome screen to the frame
    * 
    * @param g
    *           the graphics component to paint the cards to.
    */
   private void paintWelcome(Graphics g)
   {
      //CONSTRUCT a 2D graphics variable from g
      Graphics2D g2d = (Graphics2D) g;

      //SET the 2D graphics color to white
      g2d.setColor(Color.white);

      //SET 2D graphics composite to 75%
      g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
            this.kComposite));
      
       // DRAW over the board with a rectangle 
      g2d.fillRect(backgroundStartLoc.x, backgroundStartLoc.y,
            background.width, background.height);

      // SET the graphics component to black
      g.setColor(Color.black);

      
      // SET the font of the prompt to be Times New Roman, bold and to welcome's text size
      Font font = new Font("TimesRoman", Font.BOLD, kWelcomeSize);
      g.setFont(font);
      
      // DRAW the welcome prompt
      g.drawString(
            "Welcome to CardBoard!\n Click the start button to begin playing.",
            startPromptLoc.x, startPromptLoc.y);

      // CONSTRUCT the welcomeButton
      welcomeButton = new CardBoardButton(startButtonLoc, map,
            CardBoardButton.BUTTONTYPE.WELCOME, "Welcome");

      // PAINT the startButton
      welcomeButton.paint(g);
   }

   /**
    * Paints the timer graphic to the screen
    * 
    * @param g
    *           the graphics component to paint the cards to.
    */
   private void paintTimer(Graphics g)
   {
      // CREATE timer TimerGraphic with
      // CREATE Point to be timer's x location, timer's y location
      // CALL gameState.getTimer()
      TimerGraphic timer = new TimerGraphic(timeLoc, state.getTimer());

      // PAINT timer
      timer.paint(g);
   }
   private void paintCardCount(Graphics g)
   {
      // STORE the number of cards left in the deck 
     // String numberOfCards = Integer.toString(state.getBoard().getCardsLeft().intValue()); 
      String numberOfCards = "81"; 
      // SET the color to white
      g.setColor(Color.white);

      // SET the font of the prompt to be Times New Roman, bold and to pause's text size
      Font font = new Font("TimesRoman", Font.BOLD, kPauseSize);
      g.setFont(font);
      
      // DRAW the number of cards left to the screen
      g.drawString(
            "Cards left: " + numberOfCards ,
            cardsLeftLoc.x, cardsLeftLoc.y);
            
   }
   /**
    * Displays the given page in a different browser page.
    * @param aPage
    *             
    */
   public void showPage (String aPage) { 
      
      URL url = null; 
      try 
      { 
         url = new URL (aPage); 
      } 
      catch (MalformedURLException exp) 
      { 
         exp.printStackTrace();
      } 

      if (url != null) 
      { 
 //        getAppletContext().showDocument (url); 
      } 
   }

   private void paintSelectedCard(Graphics g)
   {
      //GET starting location of the first card  
      CardGraphic card = cards[selectedRow][selectedCol]; 
      if(card == null)
      {
         Card tempCard = state.getBoard().getCardFromBoard(new Natural(selectedRow),
               new Natural(selectedCol));
         if(tempCard != null)
         {
         selected = new CardGraphic(tempCard, map, new Natural(
               selectedRow), new Natural(selectedCol), this, new Point(cardStartLoc.x, cardStartLoc.y));
         g.setColor(Color.yellow);
         g.fillRect(this.cardStartLoc.x-5, this.cardStartLoc.y-5,kCardWidth[scaleIndex] + 10, kCardHeight[scaleIndex] + 10);  
         }
      }
      else 
      {
         selected= card; 
         g.setColor(Color.yellow);
         g.fillRect(card.getDrawLocation().x-5, card.getDrawLocation().y-5,kCardWidth[scaleIndex] + 10, kCardHeight[scaleIndex] + 10);  
      }
   }
   /**
    * Paints the score graphic to the screen
    * 
    * @param g
    *           the graphics component to paint the cards to.
    */
   private void paintScore(Graphics g)
   {
      // CREATE score ScoreGraphic with
      // CREATE Point to be timer's x location, timer's y location
      // CALL gameState.getScore with gametState.PLAYER.PLAYER1
      // CALL gameState.getScore with gameState.PLAYER.PLAYER2
      // CALL gameState.getScore with gameState.PLAYER.PLAYER3
      // CALL gameState.getScore with gameState.PLAYER.PLAYER4

       scores = new ScoresGraphic(scoreLoc, state
            .getScore(GameState.PLAYER.PLAYER1), state
            .getScore(GameState.PLAYER.PLAYER2), state
            .getScore(GameState.PLAYER.PLAYER3), state
            .getScore(GameState.PLAYER.PLAYER4));
      // PAINT score
      scores.paint(g);
   }
   /**
    * Paints the explain why button
    * @param g the graphic to paint the explain button onto. 
    */
   private void paintExplain(Graphics g)
   {
       //CONSTRUCT a explain CardBoardButton with 
       //the explain's x location, explain's y location, 
       //the GameWindow's actionMap
       //CardBoardButton.BUTTONTYPE.EXPLAIN 
       //"Explain" as the string
        
       explainButton = new CardBoardButton(new
       Point(buttonsX,buttonsY[kExplainIndex]),map,
       CardBoardButton.BUTTONTYPE.EXPLAIN,"Explain");
       
       // PAINT explain
       explainButton.paint(g);
   }
   /**
    * Returns the currently selected card;
    * 
    * @return returns the currently selected card
    */
   public Card getSelected()
   {
      // RETURN selectedCard
      return this.selected.getCard();
   }

   /** 
    * Updates the timer graphic 
    * @param e the source that fired the event
    */
   public void actionPerformed(ActionEvent e)
   {
      this.paintTimer(this.getGraphics());

   }
   /**
    * Retrieves the currently selected card
    * @return the currently selected card
    */
   public CardGraphic getSelectedCardGraphic()
   {
      return this.selected;
   }

}
