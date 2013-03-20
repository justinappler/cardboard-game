package com.immortallabs.cardboard.game;
/**
 * The Card class contains all the necessary information to represent a 
 * Cardboard game card. It contains enumerations and "getter" methods 
 * for each attribute of the card.
 * <br /><br />
 * <b>Operations:</b>
 * <ul>
 * <li>The Card class represents a card from the game CardBoard.
 * </ul>
 * @author Michael Brooks
 * @author ImmortalLabs CSC309 W'09
 * @author Brad Barrows
 * @author Rusty Nail CSC308 F'08
 * @version 1.3
 * @version Jan. 21st, 2009
 * 
 * @history
 *  - 01/15/09 1.3 Corrected Pseudocoding, added code to methods. <br>
 *  - 12/04/08 1.2 More Pseudocoding<br>
 *  - 12/02/08 1.1 Added Version History & Pseudocode  <br>  
 */

public class Card
{
   /**
    * The Shape enumeration describes the shape of the icons on the card.
    */
   public enum SHAPE
   {
      /** The squiggles shape **/     
      SQUIGGLES, 
      /** The diamonds shape **/
      DIAMONDS, 
      /** The ovals shape **/
      OVALS
   }
   /**
    * The Color enumeration describes the color of the icons on the card.
    */
   public enum COLOR
   {
       /** The color red **/
      RED, 
       /** The color purple **/
      PURPLE, 
       /** The color green **/      
      GREEN
   }
   /**
    * The Fill enumeration describes the fill type of the icons on the card.
    */
   public enum FILL
   {
      /** The solid fill type **/
      SOLID, 
      /** The solid striped type **/
      STRIPED, 
      /** The solid empty type **/
      EMPTY
   }
   /**
    * The Number enumeration describes the number of icons on the card.
    */
   public enum NUMBER
   {
      /** One icon on the card **/
      ONE, 
      /** Two icons on the card **/      
      TWO, 
      /** Three icons on the card **/ 
      THREE
   }

   /**
    * Contains the shape of the card's icons
    */
   private SHAPE shape;
   /**
    * Contains the color of the card's icons
    */   
   private COLOR color;
   /**
    * Contains the fill type of the card's icons
    */   
   private FILL fill;
   /**
    * Contains the number of icons on the card
    */   
   private NUMBER number;
   
   /**
    * Creates a card with the shape, color, fill and number passed.
    * @param   shape the shape of the icons on the card
    * @param   color the color of the icons on the card
    * @param   fill  the fill type of the icons on the card
    * @param   number   the number of icons on the card
    */
   public Card(SHAPE shape, COLOR color, FILL fill, NUMBER number)
   {
   }

   /**
    * This method returns the shape of the icons on the card.
    * @return  Returns the Shape of the icons
    */
   public SHAPE getShape()
   {
      //RETURN shape
      return null;
   }

   /**
    * This method returns the color of the icons on the card.
    * @return  Returns the Color of the icons
    */
   public COLOR getColor()
   {
      //RETURN color
      return null;
   }

   /**
    * This method returns the fill type of the icons on the card.
    * @return  Returns the Fill of the icons
    */
   public FILL getFill()
   {
      //RETURN fill
      return null;
   }

   /**
    * This method returns the number of icons on the card.
    * @return  Returns the Number of icons
    */
   public NUMBER getNumber()
   {
      //RETURN number
      return null;
   }
   
   /**
    * Discovers if another object equals this card.
    * @param obj the object being compared to.
    * @return true if objects are equal, false otherwise.
    */   
   public boolean equals(Object obj)
   {
      return true;
   }
   
}
