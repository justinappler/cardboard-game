package com.immortallabs.cardboard.game;
/**
 * <p>The Score class models each players score.  A score is a
 * non-negative integer that can be increased or decreased 
 * based on game play.</p>
 *
 * <br><br>
 * <b>Operations:</b>
 * <ul>
 * <li>The Score class can modify the players score.
 * <li>The Score class can return the players current score.
 * <li>The Score class can reset the players score to 0.
 * </ul>
 *
 * @author Nikhil Kowshik
 * @author Formerly Ryan S. Lange at version 0.2
 * @version 0.3 
 * @version 1/14/09
 * 
 * @history
 *  - 12/04/08 0.2 Added Version History & Pseudocode<br>
 *  - 12/01/08 0.1 Initial Class Skeleton<br>
 */

public class Score 
{
   private int score;
     
   /**
    * Initializes the score for a player to 0.
    */
    public Score() 
    {
      //SET score equal to 0
      score = 0;
    }    
    /**
    * Returns the current score of the player.
    * 
    * @return the current score of the player.
    */
    public int getScore()
    {
      //RETURN score 
      return score;
    }
}
