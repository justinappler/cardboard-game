package com.immortallabs.cardboard.ui;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * FAKE!
 */

public class CardBoardButton extends JComponent 
{

	/**
	 * A reference to the ActionMap Instance being used.
	 */
	private ActionMap     actionMapInst;
	/**
	 * The point on the GameWindow where this button is drawn
	 */
	private Point         drawLocation;

	/**

    /**
     * The ButtonType enumeration is used to describe what type of button is to be created.
     */
    private enum BUTTONSTATUS
    {
       /** The button is up **/
       UP, 
       /** The button is down **/
       DOWN
    }	
    /**
 	 * The type of button
	 */
    private BUTTONTYPE  type;
    /**
     * The ButtonType enumeration is used to describe what type of button is to be created.
     */
    public enum BUTTONTYPE
    {
       /** A hint button **/
       HINT, 
       /** A three more button **/
       THREEMORE, 
       /** A pause button **/
       PAUSE, 
       /** A unpause button **/
       UNPAUSE, 
       /** A welcome button **/
       WELCOME, 
       /** A explain button **/
       EXPLAIN
       
       , OK
    }
    public static int tempCount = 0; 
   /**
    * Creates one of the possible buttons at a certain point in the GameWindow.
    *
    * @param   pt          where to draw the Button
    * @param   actionmap   the instance of ActionMap to use
    * @param   type        the type of button to create
    * @see     ActionMap
    */
   public CardBoardButton(Point pt, ActionMap actionmap, BUTTONTYPE type, String message)
   {
	   this.drawLocation = pt; 
	   this.type = type; 
   }
   
   /**
    * Returns the type of button.
    *
    * @return	The type of button 
    */   
   public BUTTONTYPE getType()
   {
	   //RETURN type
	   return type; 
   }

   @Override	
   public void paint(Graphics g)
   {

 	  BufferedImage img = null;
 
 	  try 
 	  {
 		  if(tempCount == 0)
 		  { 
 			  img = ImageIO.read(new File("images/start.jpg")); 
 		  }
 		  else if (tempCount == 1)
 		  { 
 			  img = ImageIO.read(new File("images/hint.jpg"));
           tempCount = 2; 
 		  }
 		  else if (tempCount == 2)
 		  { 
 			  img = ImageIO.read(new File("images/pause.jpg"));
           tempCount = 3; 
 		  }
 		  else if (tempCount == 3)
 		  { 
 			  img = ImageIO.read(new File("images/threeMore.jpg"));
           tempCount = 1; 
 		  }
 	      g.drawImage(img,drawLocation.x,drawLocation.y,null);
     }
 	  catch (IOException e) 
 		  {
 		   	System.out.println("Did not load image"); 
 		  }
   }

}