package com.immortallabs.cardboard.ui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * The Button class is used to draw one of the three Cardboard game buttons in 
 * the GameWindow. The type of button to be created is defined in the Button 
 * constructor using the ButtonType enumeration.
 * <br /><br />
 * <b>Operations:</b>
 * <ul>
 * <li>The Button class can create three types of buttons for the game board.
 * </ul>
 * 
 * @author Nikhil Kowshik
 * @author Formerly Brad Barrows at version 1.2
 * @version 1.3
 * @version 1/14/09
 * 
 * Version History
 * @history
 *  - 12/04/08 1.2 More Pseudocoding<br>
 *  - 12/02/08 1.1 Added Version History & Pseudocode <br>
 */

public class CardBoardButton extends JComponent 
{

   /**
    * Contains the Image of the button when it is not being pressed
    */
   private BufferedImage buttonUp;
   
   /**
    * The ActionMap to use with this button
    */
   private ActionMap actionMapInst;
   
   /**
    * The point on the GameWindow where this button is drawn
    */
   private Point         drawLocation;
   /**
    * The current status of the button
    */
   private BUTTONSTATUS  buttonStatus;
   /**
    * Contains the message to be printed on the button
    */
   private String message;
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
       /** An unpause button **/
       UNPAUSE, 
       /** A welcome button **/
       WELCOME, 
       /** A explain button **/
       EXPLAIN
    }

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
      //CREATE a new string for the buttonUp filename
      String up = null;
      
      //IF type is a HINT BUTTON
      if (type == BUTTONTYPE.HINT)
      {
         //SET up to current theme's hint button up image filename
         up = "images/hint.jpg";
      }
      //ELSE IF type is a THREE MORE BUTTON
      else if (type == BUTTONTYPE.THREEMORE)
      {   
         //SET up to current theme's three more button up image filename
         up = "images/threeMore.jpg";
      }     
      //ELSE IF type is a PAUSE BUTTON
      else if (type == BUTTONTYPE.PAUSE)
      {
         //SET up to current theme's pause button up image filename
         up = "images/pause.jpg";
      }
      //ELSE IF type is a UNPAUSE BUTTON
      else if (type == BUTTONTYPE.UNPAUSE)
      {
        up = "images/resume.jpg";
      }
      //ELSE IF type is a WELCOME BUTTON
      else if (type == BUTTONTYPE.WELCOME)
      {
        up = "images/start.jpg";
      }
      
      //TRY to open the up and down pictures and store them
      try
      {
         //SET buttonUp to the buffered image with the filename in up
         buttonUp = ImageIO.read(new File(up));
         
         System.out.println(buttonUp.toString());
      }
      catch (Exception e)
      {
         System.exit(1);
      }

      //SET actionMapInst to actionmap
      actionMapInst = actionmap;
      
      //ADD actionmap as this components mouseListener
      this.addMouseListener(actionmap);
      
      //SET this class's drawLocation to pt
      drawLocation = pt;
      
      //SET this class's to type
      this.type = type;
      
      //SET this class's to message
      this.message = message;
      
      //SET this class's buttonStatus to BUTTONSTATUS.UP
      buttonStatus = BUTTONSTATUS.UP;
   }
   
   /**
    * Returns the type of button.
    *
    * @return  The type of button 
    */   
   public BUTTONTYPE getType()
   {
      //RETURN type
      return type;
   }

   @Override   
   public void paint(Graphics g)
   {     
      //PAINT buttonUp image to g at drawLocation
      g.drawImage(buttonUp, drawLocation.x, drawLocation.y, null);
   }
}
