package com.immortallabs.cardboard.ui;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import com.immortallabs.cardboard.game.SetsBoard;
import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.ui.CardBoardButton.BUTTONTYPE;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.lang.Math;
import edu.profdalbey.Natural;
import java.io.InputStream;


/**
 * The CardGraphic class is used to draw the Cardboard game cards in the 
 * GameWindow. It does this by extending Component and overwriting the 
 * paint method. This class also contains methods to animate and scale 
 * the cards appropriately.
 * <br /><br />
 * <b>Operations:</b>
 * <ul>
 * <li>The CardGraphic class can create a card for the game board.
 * <li>The CardGraphic class can animate itself card.
 * <li>The CardGraphic class can scale the size of itself to fit on the game board.
 * </ul>
 * 
 * @author Brad Barrows
 * @version 1.3
 * @version Jan. 3rd, 2008
 * 
 * @history
 *  - 1/13/09  1.3 Updated packages and tags <br> 
 *  - 12/04/08 1.2 More Pseudocoding<br>
 *  - 12/02/08 1.1 Added Version History & Pseudocode<br> 
 */

public class CardGraphic extends JComponent implements Runnable
{
	
	/**
	 * Contains the card that this graphic represents
	 */
	private Card card;
	/**
	 * Contains the Image of the card graphic
	 */
	private BufferedImage cardGraphic;	
	/**
	 * The thread to be created for animation
	 */
	private Thread animate;		
	/**
	 * A reference to the instance of the ActionMap
	 */
	private ActionMap     actionMapInst;
	/**
	 * The point that the card graphic is being drawn at
	 */
	private Point         drawLocation;
	/**
	 * The point that the card graphic is being animated to
	 */
	private Point         dstPoint;	
	/**
	 * The change in the card's horizontal position every animation frame
	 */
	private int       dx;
	/**
	 * The change in the card's vertical position every animation frame
	 */
	private int       dy;
	/**
	 * The row this card is in
	 */
	private Natural       row;
	/**
	 * The column this card is in
	 */
	private Natural       column;
	/**
	 * A reference to the instance of the GameWindow
	 */
	private GameWindow    gamewindow;
	/**
	 * The number of rows of cards on the game board
	 */
	private SetsBoard.ROWS       numRows;
	/**
	 * The current theme of the card graphics
	 */
	private String theme;
	
	/**
	 * The x position of the inlay spots for the cards
	 */
	private static final int[] INLAYX = {10, 10, 10};

	/**
	 * The y position of the inlay spots for the cards
	 */
	private static final int[] INLAYY= {10, 200, 400};
		
	/**
	 * The width of the cards at each scale size
	 */
	private static final int[] WIDTH = {140, 120, 100, 80};

	/**
	 * The height of the cards at each scale size
	 */
	private static final int[] HEIGHT= {180, 160, 140, 120};

	/**
	 * The spacing between each card at each scale size
	 */
	private static final int[] SPACE = {40, 30, 20, 10};
	/**
	 * The x offset on the game board of the cards
	 */
	private static final int OFFX=300;
	/**
	 * The y offset on the game board of the cards
	 */
	private static final int OFFY=100;
	/**
	 * The speed at which the card moves across the board
	 */
	private static final int SPEED=100;
	/**
	 * The delay between animation frames
	 */
	private static final int DELAY=10;
	
   /**
    * Creates a CardGraphic to represent a card at the position row, column in the game board.
    * @param   card  the card to represent
    * @param   actionmap   the ActionMap instance to use
    * @param   row         the row of the gameboard to place the card
    * @param   column      the column of the gameboard to place the card
    * @param   gamewindow  the GameWindow instance to use
    * @see     Card
    * @see     ActionMap
    * @see     GameWindow
    * @see     Natural
    */
   public CardGraphic(Card card, ActionMap actionmap, Natural row, Natural column, GameWindow gamewindow, Point drawLocation)
   {

   }

   /**
    * Animates a card from its current position to a desired point.
    *
    * Uses a seperate thread to animate this CardGraphic without losing
    * the response of the GUI.
    * 
    * @param   inlaySpot    the spot on the inlay to animate to
    * @see     Point
    */
   public void animateTo(GameWindow.INLAY inlaySpot)
   {

   }

   /**
    * The method to run on a seperate thread to animate this CardGraphic's position.
    *
    */
   public synchronized void run()
   {
	
	}
   
   /**
    * Scales the size of this CardGraphic to fit on the gameboard with 4,5,6 or 7 rows.
    *
    * This method is called when the number of rows of cards on the gameboard
    * increases. It is used to scale the size of the cards to all fit in the 
    * GameWindow.
    *
    * @param   rows  the number of rows of cards on the gameboard
    * @see     GameWindow
    */
   public void scaleTo(SetsBoard.ROWS rows)
   {

   }
   
   /**
    * Returns the card.
    *
    * @return	The card 
    */   
   public Card getCard()
   {
	   //RETURN card
	   return null;
   }   

   @Override 	
   public void paint(Graphics g)
   {

   }

}
