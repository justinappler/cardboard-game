package com.immortallabs.cardboard.ui;

import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.game.SetsBoard;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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

public class GameWindow extends JFrame implements CardBoardUI, ActionListener
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
   private final int kWindowHeight = 730;

   /** the width of the window */
   private final int kWindowWidth = 780;

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

   /** The Card components currently in the inlay */
   private CardGraphic[] inlay;

   /** Represents the x location of the inlay cards */
   private final int inlayX = 35;

   /** Represents the y locations of the inlay cards */
   private final int[] inlayY =
   { 75, 190, 300 };

   /** Represents the font size of pause prompt */
   private final int kPauseSize = 16;

   /** Represents the font size of welcome prompt */
   private final int kWelcomeSize = 20;

   /** Represents the composite shade value */
   private final float kComposite = 0.75f;
   /** Represents the x location of the buttons */
   private final int buttonsX = 25;

   /** Represents the fileName for background image */
   private final String kBackgroundFile = "images/background.jpg";

   /** Represents the number of columns for the cards */
   private final int kColumns = 3;

   /** Represents the max number of rows for the cards */
   private final int kRowsMax = 7;

   /** Represents the maxium number of rows for the cards */
   private final int kRows = 4;

   /** Represents the y locations of the buttons */
   private final int[] buttonsY =
   { 415, 480, 545, 610 };

   /** Represents the beginning card location */
   private final Point cardStartLoc = new Point(235, 75);

   /** Represents the X offset for the cards */
   private final int kCardXOffset = 20;

   /** Represents the backgrounds location */
   private final Point backgroundStartLoc = new Point(0, 45);

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
   { 4, 5, 6, 7 };

   /** Represents the scale width sizes for the cards */
   private final int[] kCardWidth =
   { 150, 130, 110 };

   /** Represents the scale height sizes for the cards */
   private final int[] kCardHeight =
   { 100, 80, 60 };

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
   private final Point timeLoc = new Point(35, 700);

   /** Represents the score's location */
   private final Point scoreLoc = new Point(235, 700);

   /** Represents if the game is paused */
   private boolean isPaused;

   /** Represents if the application just launched */
   private boolean isWelcome;

   /** Represents the x location of the rectangle to paint over the cards */
   private final Point paintOverLoc = new Point(220, 50);

   /** Represents the paint over width for pausing */
   private final Dimension paintOverDimesion = new Dimension(551, 612);

   /** Represents the paint over message location */
   private final Point paintOverMessageLoc = new Point(235, 305);

   /** Represents the resume button location */
   private final Point resumeButtonLoc = new Point(420, 320);

   /** Represents the start button location */
   private final Point startButtonLoc = new Point(305, 350);

   /** Represents the start prompt location */
   private final Point startPromptLoc = new Point(100, 335);

   /** Represents the backgrounds width and height */
   private final Dimension background = new Dimension(780, 686);

   /** Represents the welcome button */
   private CardBoardButton welcomeButton;

   /** Represents the resume button */
   private CardBoardButton resumeButton;

   /** Represents the Menu Bar for the game */
   private CardBoardMenu menu;

   /** Allows for repaiting the timerGraphic every second */
   private javax.swing.Timer repaintTimer;

   /**
    * Instantiates a new game window that will display the state of the game
    * held in logic.
    * 
    * @param state
    *           the game to display
    */
   public GameWindow(GameState state)
   {
      // CALL setUserInterface on GameState passing a copy of self
      state.setUserInterface(this);

      cards = new CardGraphic[kRowsMax][kColumns];

      inlay = new CardGraphic[kColumns];

      // SET the instance of GameState to the passed in state
      this.state = state;

      // CALL setSize with sizes of the GameWindow
      setSize(kWindowWidth, kWindowHeight);

      // CREATE new ActionMap
      map = new ActionMap(state, this);

      // ADD a mouseListener with ActionMap
      this.addMouseListener(map);

      // CREATE a new CardBoardMenu
      menu = new CardBoardMenu(map);

      // CALL setJMenuBar with CardBoardMenu
      setJMenuBar(menu.getMenuBar());

      // SET isPaused to false
      isPaused = false;

      // SET repaint timer to paint every second
      repaintTimer = new javax.swing.Timer(kSecond, this);

      // SET isWelcome to true
      isWelcome = true;

      // CALL setVisible with true
      this.setVisible(true);

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

      // ANIMATE the card to the openInlaySlot
      // card.animateTo(getOpenInLaySpot());
      
      map.cardClicked(card);
    
      repaint(); 
   }

   /**
    * Checks to see if the card is currently in the inlay
    * 
    * @param c
    *           the card to check to see if its in the inlay
    * @return true if the card is in the inlay false otherwise
    */
   private boolean isCardinInlay(Card c)
   {
      // GET the setsBoard from gameState
      SetsBoard board = state.getBoard();

      // DECLARE isCard to be false
      boolean isCard = false;

      // FOR each card in the inLay
      for (int index = 0; index < board.getInlaySize().intValue(); index++)
      {
         // IF the card is in the inlay
         if (board.getInlayCard(new Natural(index)).equals(c))
         {
            // Set isCard to true
            isCard = true;
         }
      }
      // RETURN isCard
      return isCard;
   }

   /**
    * Moves the selected card in the specified direction
    * 
    * @param dir
    *           the direction to move
    */
   public void moveSelector(DIRECTION dir)
   {
      // SWITCH on the direction
      // CASE UP
      // Move the selected up
      // CASE DOWN
      // Move the selected down
      // CASE LEFT
      // Move the left
      // CASE RIGHT
      // Move the selected right
   }

   /**
    * The object on which the Event initially occurred.
    * 
    * @param x
    *           the x location where the mouse was pressed
    * @param y
    *           the y location where the mouse was pressed
    * @return The object on which the Event initially occurred.
    */
   public Object getSource(int x, int y)
   {
      // ASSIGN objectInLay with CALL to checkInLay
      Object objectInLay = checkInLay(x, y);

      // ASSIGN objectCards with CALL to checkCards
      Object objectCards = checkCards(x, y);

      // ASSIGN objectButton with CALL to checkButtons
      Object objectButton = checkButtons(x, y);

      // IF objectInLay != NULL THEN
      if (objectInLay != null && !isPaused)
      {
         // RETURN objectInLay
         return objectInLay;
      }
      // ELE IF objectCards != NULL THEN
      else if (objectCards != null && !isPaused)
      {
         // RETURN objectCards
         return objectCards;
      }
      // ELSE IF objectButton != NULL THEN
      else if (objectButton != null)
      {
         // RETURN objectButton
         return objectButton;
      }
      // ELSE
      else
      {
         // RETURN this
         return this;
      }

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
      CardGraphic card = null;

      // IF the x and y is within the bounds of the first in lay card
      // AND there is at least one card in the inlayTHEN
      if (inlay[firstInlay] != null)
      {
         // Check the bounds THEN
         if ((x >= inlayX && x <= (inlayX + kCardWidth[scaleIndex]))
               && ((y >= inlayY[firstInlay]) && (y <= inlayY[firstInlay]
                     + kCardHeight[scaleIndex])))
         {
            // RETURN the first inlay card
            if (inlay[firstInlay] != null)
            {
               card = inlay[firstInlay];
            }
         }

      }
      // ELSE IF the x and y is within the bounds of the second in lay card
      // AND there are at least two cards in the inlay THEN
      if (inlay[secondInlay] != null)
      {
         // Check the bounds THEN
         if ((x >= inlayX && x <= (inlayX + kCardWidth[scaleIndex]))
               && ((y >= inlayY[secondInlay]) && (y <= inlayY[secondInlay]
                     + kCardHeight[scaleIndex])))
         {
            // RETURN the second inlay card
            if (inlay[secondInlay] != null)
            {
               card = inlay[secondInlay];
            }
         }

      }
      // ELSE IF the x and y is within the bounds of the third in lay card
      // AND there are at least three cards in the inlay THEN
      if (inlay[thirdInlay] != null)
      {
         // Check the bounds THEN
         if ((x >= inlayX && x <= (inlayX + kCardWidth[scaleIndex]))
               && ((y >= inlayY[thirdInlay]) && (y <= inlayY[thirdInlay]
                     + kCardHeight[scaleIndex])))
         {
            // RETURN the third inlay card
            if (inlay[thirdInlay] != null)
            {
               card = inlay[thirdInlay];
            }
         }

      }

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
      CardGraphic card = null;

      int cardX = cardStartLoc.x;
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
               // RETURN card
               if (cards[row][col] != null)
               {
                  card = cards[row][col];
               }

            }
            cardX = cardX + kCardXOffset + kCardWidth[scaleIndex];
         }
         cardX = cardStartLoc.x;
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
      CardBoardButton button = null;

      // IF the x and y is within the bounds of the hint button THEN
      if ((x >= buttonsX && x <= (buttonsX + kButtonDimesion.width))
            && ((y >= buttonsY[kHintIndex]) && (y <= buttonsY[kHintIndex]
                  + kButtonDimesion.height)))
      {
         // RETURN the hint button
         button = hintButton;

      }

      // ELSE IF the x and y is within the bounds of the pause button THEN
      else if ((x >= buttonsX && x <= (buttonsX + kButtonDimesion.width))
            && ((y >= buttonsY[kPauseIndex]) && (y <= buttonsY[kPauseIndex]
                  + kButtonDimesion.height)))
      {
         // RETURN the pause button
         button = pauseButton;

      }
      // ELSE IF the x and y is within the bounds of the three more button THEN
      else if ((x >= buttonsX && x <= (buttonsX + kButtonDimesion.width))
            && ((y >= buttonsY[kThreeMoreIndex]) && (y <= buttonsY[kThreeMoreIndex]
                  + kButtonDimesion.height)))
      {
         // RETURN the three more button
         button = threeMoreButton;

      }
      // ELSE IF the x and y is within the bounds of the explain button THEN
      else if ((x >= buttonsX && x <= (buttonsX + kButtonDimesion.width))
            && ((y >= buttonsY[kExplainIndex]) && (y <= buttonsY[kExplainIndex]
                  + kButtonDimesion.height)))
      {
         // RETURN the explain button
         button = explainButton;

      }
      // ELSE IF the x and y is within the bounds of the welcome button THEN
      else if ((x >= startButtonLoc.x && x <= (startButtonLoc.x + kButtonDimesion.width))
            && ((y >= startButtonLoc.y) && (y <= startButtonLoc.y
                  + kButtonDimesion.height)) && isWelcome == true)
      {
         // RETURN the explain button
         button = welcomeButton;

      }
      // ELSE IF the x and y is within the bounds of the welcome button THEN
      else if ((x >= resumeButtonLoc.x && x <= (resumeButtonLoc.x + kButtonDimesion.width))
            && ((y >= resumeButtonLoc.y) && (y <= resumeButtonLoc.y
                  + kButtonDimesion.height)) && isPaused == true)
      {
         // RETURN the explain button
         button = resumeButton;

      }
      // RETURN button
      return button;
   }

   /**
    * Shows the user the explanation behind a correct or incorrect set.
    * 
    * @param explanation
    *           A string containing the explanation to display
    */
   public void showExpirationPenalty(String message)
   {
      // CALL JOptionPane.showMessageDialog with the message
      JOptionPane.showMessageDialog(this, message);
   }

   /**
    * Shows the user the timer expiration penalty message.
    * 
    * @param message
    *           A string containing the penalty message
    */
   public void showExplanation(String message)
   {
      // CALL JOptionPane.showMessageDialog with the message
      this.repaint(); 
      JOptionPane.showMessageDialog(this, message);
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
    * Returns the current open inlay spot to place a card.
    * 
    * @return the point at which to place a card in the inlay
    */
   public Point getOpenInlaySpot()
   {
      boolean foundOpenInLay = false;
      int index = 0;

      // CREATE a temp Point and assign it to null
      Point temp = null;

      // FOR each card in the inLay
      while (!foundOpenInLay && index < inlay.length)
      {
         // IF index does not contain a card THEN
         if (inlay[index] == null)
         {
            // RETURN the point location corresponding to that index
            temp = new Point(inlayX, inlayY[index]);
         }
         index++;
      }
      return temp;
   }

   /**
    * Returns an openInLaySpot
    * 
    * @return returns an openInLaySpot
    */
   private INLAY getOpenInLaySpot()
   {
      boolean foundOpenInLay = false;
      int openInLaySpot = 0, index = 0;

      // FOR each card in the inLay
      while (!foundOpenInLay && index < inlay.length)
      {
         // IF the card is in the inlay
         if (inlay[index] == null)
         {
            openInLaySpot = index;
            foundOpenInLay = true;
         }
         index++;
      }
      // CHECK to see which inlaySpot is open
      if (openInLaySpot == this.firstInlay)
      {
         return INLAY.ONE;

      }
      // ELSE IF open inlay spot is in the second return inlay two
      else if (openInLaySpot == this.secondInlay)
      {
         return INLAY.TWO;
      }
      // ELSE return the third inlay spot s
      else
      {
         return INLAY.THREE;
      }
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
      // name = JOptionPane.showInputDialog(null, prompt);
      // RETURN the name
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

   @Override
   public void update(Graphics g)
   {
      // CALL paint with g
      paint(g);
   }

   @Override
   public void paint(Graphics g)
   {
      // CALL paintBackground with g
      paintBackground(g);

      // IF the welcome screen is set then
      if (isWelcome)
      {
         paintWelcome(g);
      }
      // ELSE IF the game is not paused then paint the cards and buttons
      else if (!isPaused)
      {

         // CALL paintInLayCards with g
         paintInLayCards(g);
         // CALL paintCards with g
         paintCards(g);
         // CALL paintButtons with g
         paintButtons(g);
         // CALL paintScore with g
         paintScore(g);
         // CALL paintTimer with g
         paintTimer(g);

         // DETERMINE the current scale size
         scaleIndex = kFirstScalar;

         if (state.getBoard().getRowSize() == SetsBoard.ROWS.FIVE)
         {
            scaleIndex = kFirstScalar;
         } else if (state.getBoard().getRowSize() == SetsBoard.ROWS.SIX)
         {
            scaleIndex = kSecondScalar;
         } else if (state.getBoard().getRowSize() == SetsBoard.ROWS.SEVEN)
         {
            scaleIndex = kThirdScalar;
         }
         numberOfRows = getRowSize(state.getBoard().getRowSize());
      }
      // ELSE paint over the cards and paint the resume button
      else
      {
         // CALL paintInLayCards with g
         paintInLayCards(g);
         // CALL paintOver with g
         paintOver(g);
         // CALL paintScore with g
         paintScore(g);
         // CALL paintTimer with g
         paintTimer(g);
      }
      menu.getMenuBar().repaint();
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

      // FOR each Card in the lay
      for (int i = 0; i < board.getInlaySize().intValue(); i++)
      {
         // ASSIGN tempCard to the card
         Card tempCard = board.getInlayCard(new Natural(i));

         if (tempCard != null)
         {
            // CREATE a new CardGraphic with tempCard
            CardGraphic card = new CardGraphic(tempCard, map, new Natural(0),
                  new Natural(0), this, new Point(inlayX, inlayY[i]));

            if (board.getRowSize() == SetsBoard.ROWS.FIVE)
            {
               card.scaleTo(SetsBoard.ROWS.FIVE);
            } else if (board.getRowSize() == SetsBoard.ROWS.SIX)
            {
               card.scaleTo(SetsBoard.ROWS.SIX);
            } else if (board.getRowSize() == SetsBoard.ROWS.SEVEN)
            {
               card.scaleTo(SetsBoard.ROWS.SEVEN);
            }
            // ADD the CardGraphic to the inylayCards
            inlay[i] = card;

            // PAINT the CardGraphic
            card.paint(g);
         } else
         {
            inlay[i] = null;

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
      // CONSTRUCT TRY
      try
      {
         // CREATE a new BufferedImage img
         BufferedImage img;
         // CALL ImageIO.read with background image file name and ASSIGN to img
         img = ImageIO.read(new File(kBackgroundFile));
         // CALL g.drawImage with img, background's x location, backgrounds's y
         // location, null
         g.drawImage(img, backgroundStartLoc.x, backgroundStartLoc.y, null);
      } catch (IOException e)
      {
         System.exit(1);
      }
   }

   /**
    * Returns the number of rows in the game
    * 
    * @param rows
    *           the enumeration for the number of rows
    * @return the number of rows for the game.
    */
   private int getRowSize(SetsBoard.ROWS rows)
   {
      // CREATE size and assign it to 4;
      int size;
      if (rows == SetsBoard.ROWS.FIVE)
      {
         size = kCardRows[SetsBoard.ROWS.FIVE.ordinal()];
      } else if (rows == SetsBoard.ROWS.SIX)
      {
         size = kCardRows[SetsBoard.ROWS.SIX.ordinal()];
      } else if (rows == SetsBoard.ROWS.SEVEN)
      {
         size = kCardRows[SetsBoard.ROWS.SEVEN.ordinal()];
      } else
      {
         size = kCardRows[SetsBoard.ROWS.FOUR.ordinal()];
      }

      // RETURN size
      return size;
   }

   /**
    * Paints all the cards to the screen
    * 
    * @param g
    *           the graphics component to paint the cards to.
    */
   private void paintCards(Graphics g)
   {
      // CREATE setsBoard
      SetsBoard board;
      // CALL gameState.getBoard() and ASSIGN to setsBoard
      board = state.getBoard();

      int cardX = 0, cardY = 0;

      // GET rowSize
      int size = getRowSize(board.getRowSize());

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

            if (tempCard != null)
            {
               // CONSTRUCT a CardGraphic with card
               CardGraphic card = new CardGraphic(tempCard, map, new Natural(
                     row), new Natural(col), this, new Point(cardX, cardY));
               // ADD the CardGraphic to cards
               cards[row][col] = card;
               if (board.getRowSize() == SetsBoard.ROWS.FIVE)
               {
                  card.scaleTo(SetsBoard.ROWS.FIVE);
               } else if (board.getRowSize() == SetsBoard.ROWS.SIX)
               {
                  card.scaleTo(SetsBoard.ROWS.SIX);
               } else if (board.getRowSize() == SetsBoard.ROWS.SEVEN)
               {
                  card.scaleTo(SetsBoard.ROWS.SEVEN);
               }
               // PAINT the CardGraphic
               card.paint(g);
            } else
            {
               cards[row][col] = null;
            }
            cardX = cardX + kCardWidth[scaleIndex] + kCardXOffset;
         }
         cardX = cardStartLoc.x;
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
      // NEW Point to be hint's x location, hint's y location
      // the game's actionmap
      // CardBoardButton.BUTTONTYPE.HINT
      // "Hint" as the string
      hintButton = new CardBoardButton(
            new Point(buttonsX, buttonsY[kHintIndex]), map,
            CardBoardButton.BUTTONTYPE.HINT, "Hint");

      // CONSTRUCT a pause CardBoardButton with
      // NEW Point to be pause's x location, pause's y location
      // the game's actionmap
      // CardBoardButton.BUTTONTYPEE.PAUSE
      // "Hint" as the string
      pauseButton = new CardBoardButton(new Point(buttonsX,
            buttonsY[kPauseIndex]), map, CardBoardButton.BUTTONTYPE.PAUSE,
            "Pause");

      // CONSTRUCT a threeMore CardBoardButton with
      // NEW Point to be threeMore's x location, threeMore's y location
      // the game's actionmap
      // /CardBoardButton.BUTTONTYPE.THREEMORE
      // "Hint" as the string.
      threeMoreButton = new CardBoardButton(new Point(buttonsX,
            buttonsY[kThreeMoreIndex]), map,
            CardBoardButton.BUTTONTYPE.THREEMORE, "3 More Cards");

      /*
       * //CONSTRUCT a explain CardBoardButton with //NEW Point to be explain's
       * x location, explain's y location //the game's actionMap
       * //CardBoardButton.BUTTONTYPE.EXPLAIN //"Hint" as the string
       * explainButton = new CardBoardButton(new
       * Point(buttonsX,buttonsY[kExplainIndex]),map,
       * CardBoardButton.BUTTONTYPE.EXPLAIN,"Explain ?");
       */
      // PAINT hint
      hintButton.paint(g);
      // PAINT pause
      pauseButton.paint(g);
      // PAINT threeMore
      threeMoreButton.paint(g);
      // PAINT explain
      // explainButton.paint(g);
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

      // DRAW the prompt message to the screen
      Font font = new Font("TimesRoman", Font.BOLD, kPauseSize);
      g.setFont(font);
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
      // CONSTRUCT 2D graphics variable from g
      Graphics2D g2d = (Graphics2D) g;

      // SET the 2D graphics color to white
      g2d.setColor(Color.white);

      // SET 2D graphics composite to 75%
      g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
            this.kComposite));
      // DRAW the over the screen with rectangle
      g2d.fillRect(backgroundStartLoc.x, backgroundStartLoc.y,
            background.width, background.height);

      // SET the graphics compontent to black
      g.setColor(Color.black);

      // DRAW the welcome prompt
      Font font = new Font("TimesRoman", Font.BOLD, kWelcomeSize);
      g.setFont(font);
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

      ScoresGraphic score = new ScoresGraphic(scoreLoc, state
            .getScore(GameState.PLAYER.PLAYER1), state
            .getScore(GameState.PLAYER.PLAYER2), state
            .getScore(GameState.PLAYER.PLAYER3), state
            .getScore(GameState.PLAYER.PLAYER4));
      // PAINT score
      score.paint(g);
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

   public void actionPerformed(ActionEvent e)
   {
      this.paintTimer(this.getGraphics());

   }

}
