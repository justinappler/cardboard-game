package com.immortallabs.cardboard.game;


public class Card implements Cloneable
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
   

   public Card(SHAPE shape, COLOR color, FILL fill, NUMBER number)
   {
      this.shape = shape;
      this.color = color;
      this.fill = fill;
      this.number = number;
   }


   public SHAPE getShape()
   {
      //RETURN shape
      return shape;
   }


   public COLOR getColor()
   {
      //RETURN color
      return color;
   }


   public FILL getFill()
   {
      //RETURN fill
      return fill;
   }


   public NUMBER getNumber()
   {
      //RETURN number
      return number;
   }
   

   public Object clone()
   {
      return null;     
   }
   
   
  
   public boolean equals(Object obj)
   {
      boolean retValue = false;

      if (obj instanceof Card)
      {
         Card other = (Card)obj;
         
         if (other.getShape()  == this.shape 
             && other.getColor() == this.color
             && other.getFill() == this.fill
             && other.getNumber() == this.number)
         {
            retValue = true;
         }
            
      }
      
      return retValue;
   }   
}
