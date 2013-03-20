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
 * @author Immortal Labs CSC309 W'09
 * @author Brad Barrows
 * @author Rusty Nail CSC308 F'08
 * @version 1.2
 * @version Jan. 11th, 2009
 * 
 * @history
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
      /** The squiggly shape **/	  
      SQUIGGLY, 
      /** The diamond shape **/
      DIAMOND, 
      /** The oval shape **/
      OVAL
   }
   /**
    * The Color enumeration describes the color of the icons on the card.
    */
   public enum COLOR
   {
       /** The red color **/
	   RED, 
       /** The blue color **/
	   BLUE, 
       /** The green color **/	   
	   GREEN
   }
   /**
    * The Fill enumeration describes the fill type of the icons on the card.
    */
   public enum FILL
   {
      /** The solid fill type **/
      SOLID, 
      /** The solid hatched type **/
      HATCHED, 
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
	   //SET this cards shape
	   //SET this cards color
	   //SET this cards fill
	   //SET this cards number
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
   
   @Override 	
   public boolean equals(Object obj)
   {
	  //CREATE boolean retValue=false
      //IF THIS==obj
	  //   retValue=true
      //IF obj!=null
      //   CARD other=Cast obj to Card
	  //   IF others shape == this shape && others color == this color && others fill == this fill 
	  //   && others number == this number 
      //   retValue=true
	  //RETURN retValue
	  return false;
   }
   
}