package com.immortallabs.cardboard.ui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import com.immortallabs.cardboard.game.SetsBoard;
import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.ui.CardBoardButton.BUTTONTYPE;

import edu.profdalbey.Natural;


/**
 * FAKE! From Release 1
 */

public class CardGraphic extends JComponent implements Runnable
{
	
	/**
	 * Contains the card that this graphic represents
	 */
	private Card card;
	
	public static int tempCount = 0; 
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
	private static int x;
	
	private static int y; 
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
   
   private Point drawLocation;
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
	 * The width of the cards at each scale size
	 */
	private static final int[] WIDTH = {140, 120, 100};

	/**
	 * The height of the cards at each scale size
	 */
	private static final int[] HEIGHT= {180, 160, 140};

	/**
	 * The spacing between each card at each scale size
	 */
	private static final int[] SPACE = {30, 20, 10};
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
	private static final int DELAY=100;
	
	private static int totalCards = 0; 
	public static int isInlay = 0; 
	
	  private final int START_X = 235; 
	  private final int START_Y = 30; 
	  
	  private final int kX_Offset = 20; 
	  private final int kY_Offset = 20; 
	  
	  private final int kCardWidth =150; 
	  private final int kCardHeight = 100; 
	  
	  
	private static  int index = 0;  
	
	private final String[] fileArray = {"images/h1bc.jpg","images/n2rs.jpg", "images/s3rs.jpg",
										"images/h3gc.jpg","images/s1gc.jpg","images/n1bh.jpg",
										"images/h2bc.jpg","images/s3bh.jpg","images/h3bc.jpg",
										"images/h2rs.jpg","images/n1rs.jpg","images/h2gc.jpg"}; 
 	  
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
	   this.card = card; 
	   this.actionMapInst = actionmap; 
      this.drawLocation = drawLocation; 
	   //drawLocation = new Point(235,75);
	   
	   //SET this card
	   //SET this ActionMap instance
	   //SET this row
	   //SET this column
	   //SET this GameWindow instance
	   
	   //SET drawLocation to the point of the board where this card will be 
	   //       drawn by taking into account the scale size, offset, and spacing
	   
	   //LOAD the current theme into theme
	   //LOAD the card graphic into cardGraphic 
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
	   //INSTANTIATE animate to a new thread with this class as the target
	   //SET dstPoint to the coordinates of the inlaySpot
	   //SET dx to (the point - the card graphic's current x position) 
	   //SET dy to (the point - the card graphic's current y position) 
	   //IF dx >= SPEED 
	   //   dx = dx / SPEED
	   //IF dy >= SPEED 
	   //   dy = dy / SPEED	   
	   //START animate
   }

   /**
    * The method to run on a seperate thread to animate this CardGraphic's position.
    *
    */
   public void run()
   {
	   //GET the current time
	   //WHILE animate is the thread running
	   //   distFromX=absolute(cards x position - dstPoint x)
	   //   distFromY=absolute(cards y position - dstPoint y)
	   //   IF distFromX > absolute(dx) 
	   //      ADD dx to the cards x position
	   //   ELSE cards x position = x coordinate of dstPoint
	   //   IF distFromY > absolute(dy)   
	   //      ADD dy to the cards y position
	   //   ELSE cards y position = y coordinate of dstPoint
	   //   IF cards position == dstPoint
	   //      STOP animation
	   //      CALL actionMapInst.CardClicked
	   //   SLEEP thread for DELAY milliseconds 
	   //END WHILE
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
   public Point getDrawLocation() 
   {
      return drawLocation; 
   }
   
   /**
    * Returns the card.
    *
    * @return	The card 
    */   
   public Card getCard()
   {
	   //RETURN card
	   return card;
   }   

   @Override 	
   public void paint(Graphics g)
   {
	   //PAINT cardGraphic to g at drawLocation
	   try 
	 	  {
           BufferedImage img; 
           img = ImageIO.read(new File(fileArray[index++]));
           if(index == 12)
           {
              index = 0;
           }
           g.drawImage(img,drawLocation.x,drawLocation.y,null);
		   
	 	} 
	 	  catch (IOException e) 
	 		  {
	 		   
	 		  }
	 	  
   }

}
