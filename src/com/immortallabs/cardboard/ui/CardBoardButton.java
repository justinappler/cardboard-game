package com.immortallabs.cardboard.ui;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import com.immortallabs.cardboard.CardBoardResource;

/**
 * The Button class is used to draw one of the three Cardboard game buttons in
 * the GameWindow. The type of button to be created is defined in the Button
 * constructor using the ButtonType enumeration. <br />
 * <br />
 * <b>Operations:</b>
 * <ul>
 * <li>The Button class can create three types of buttons for the game board.
 * </ul>
 * 
 * @author Nikhil Kowshik
 * @author Formerly Brad Barrows at version 1.2
 * @version 1.3
 * @version 1/14/09 Version History
 * @history - 12/04/08 1.2 More Pseudocoding<br> - 12/02/08 1.1 Added Version
 *          History & Pseudocode <br>
 */

public class CardBoardButton extends JComponent
{
   /**
    * Contains the Image of the button when it is not being pressed
    */
   private BufferedImage buttonUp;

   /**
    * The point on the GameWindow where this button is drawn
    */
   private Point drawLocation;
   /**
    * The current status of the button
    */
   private BUTTONSTATUS buttonStatus;
   /**
    * Contains the message to be printed on the button
    */
   private String message;

   /**
    * The ButtonType enumeration is used to describe what type of button is to
    * be created.
    */
   private enum BUTTONSTATUS
   {
      /** The button is up * */
      UP,
      /** The button is down * */
      DOWN
   }

   /**
    * The type of button
    */
   private BUTTONTYPE type;

   /**
    * The ButtonType enumeration is used to describe what type of button is to
    * be created.
    */
   public enum BUTTONTYPE
   {
      /** A hint button * */
      HINT,
      /** A three more button * */
      THREEMORE,
      /** A pause button * */
      PAUSE,
      /** An unpause button * */
      UNPAUSE,
      /** A welcome button * */
      WELCOME,
      /** A explain button * */
      EXPLAIN
      /** An OK button for dialog boxes */
      , OK
   }

   /**
    * Creates one of the possible buttons at a certain point in the GameWindow.
    * 
    * @param pt
    *           where to draw the Button
    * @param actionmap
    *           the instance of ActionMap to use
    * @param type
    *           the type of button to create
    * @param message
    *           the message to place on the button
    * @see ActionMap
    */
   public CardBoardButton(Point pt, ActionMap actionmap, BUTTONTYPE type,
         String message)
   {
      // CREATE a new string for the buttonUp filename
      String up = null;

      // IF type is a HINT BUTTON
      if (type == BUTTONTYPE.HINT)
      {
         // SET up to current theme's hint button up image filename
         up = "hint.jpg";
      }
      // ELSE IF type is a THREE MORE BUTTON
      else if (type == BUTTONTYPE.THREEMORE)
      {
         // SET up to current theme's three more button up image filename
         up = "threeMore.jpg";
      }
      // ELSE IF type is a PAUSE BUTTON
      else if (type == BUTTONTYPE.PAUSE)
      {
         // SET up to current theme's pause button up image filename
         up = "pause.jpg";
      }
      // ELSE IF type is a UNPAUSE BUTTON
      else if (type == BUTTONTYPE.UNPAUSE)
      {
         up = "resume.jpg";
      }
      // ELSE IF type is a WELCOME BUTTON
      else if (type == BUTTONTYPE.WELCOME)
      {
         up = "start.jpg";
      }
      // ELSE IF type is a WELCOME BUTTON
      else if (type == BUTTONTYPE.EXPLAIN)
      {
         up = "explain.jpg";
      }
      else if (type == BUTTONTYPE.OK)
      {
         up = "ok.jpg";
      }

      buttonUp = CardBoardResource.getImage(this, up);

      // ADD actionmap as this components mouseListener
      this.addMouseListener(actionmap);

      // SET this class's drawLocation to pt
      drawLocation = pt;

      // SET this class's to type
      this.type = type;

      // SET this class's to message
      this.message = message;

      // SET this class's buttonStatus to BUTTONSTATUS.UP
      buttonStatus = BUTTONSTATUS.UP;
   }

   /**
    * Returns the type of button.
    * 
    * @return The type of button
    */
   public BUTTONTYPE getType()
   {
      // RETURN type
      return type;
   }

   /**
    * Draw the buttons onto the main window.
    * 
    * @param g
    *           the graphics context to draw the buttons onto
    */
   public void paint(Graphics g)
   {
      // PAINT buttonUp image to g at drawLocation
      g.drawImage(buttonUp, drawLocation.x, drawLocation.y, null);
   }
}
