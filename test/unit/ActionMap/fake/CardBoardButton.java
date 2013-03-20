package com.immortallabs.cardboard.ui;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * --FAKE--
 * The Button class is used to draw one of the three Cardboard game buttons in 
 * the GameWindow. The type of button to be created is defined in the Button 
 * constructor using the ButtonType enumeration.
 * <br /><br />
 * <b>Operations:</b>
 * <ul>
 * <li>The Button class can create three types of buttons for the game board.
 * </ul>
 * 
 * @author Thomas Dvornik
 */

public class CardBoardButton extends Component 
{

	/**
	 * Contains the Image of the button when it is not being pressed
	 */
	private BufferedImage buttonUp;
	/**
	 * Contains the Image of the button when it is being pressed
	 */
	private BufferedImage buttonDown;
	/**
	 * A reference to the ActionMap Instance being used.
	 */
	private ActionMap     actionMapInst;
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
       /** A unpause button **/
       UNPAUSE, 
       /** A welcome button **/
       WELCOME, 
       /** A explain button **/
       EXPLAIN,
       OK
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
	   this.type = type;
	   //IF type == HINT BUTTON
	   //   LOAD current theme's hint button up image to buttonUp
	   //   LOAD current theme's hint button down image to buttonDown
	   //IF type == THREE MORE BUTTON
	   //   LOAD current theme's three more button up image to buttonUp
	   //   LOAD current theme's three more button down image to buttonDown 
	   //IF type == PAUSE BUTTON
	   //   LOAD current theme's pause button up image to buttonUp
	   //   LOAD current theme's pause button down image to buttonDown 	
	   //SET actionMapInst to actionmap
	   //ADD actionmap as this components mouseListener
	   //SET this class's drawLocation to pt
	   //SET this class's to type
	   //SET this class's to message
	   //SET this class's buttonStatus to BUTTONSTATUS.UP
   }
   
   /**
    * Returns the type of button.
    *
    * @return	The type of button 
    */   
   public BUTTONTYPE getType()
   {
	   return type;
   }

   @Override	
   public void paint(Graphics g)
   {
	   //IF buttonStatus==BUTTON UP
	   //   PAINT buttonUp image to g at drawLocation
	   //IF buttonStatus==BUTTON DOWN
	   //   PAINT buttonUp image to g at drawLocation
	   //IF message!=null
	   //   PAINT message on button
   }

}