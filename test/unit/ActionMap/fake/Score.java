package com.immortallabs.cardboard.game;
/**
 * --FAKE--
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
 * @author Thomas Dvornik
 */

public class Score 
{
	private int score;
	
	/**
	 * An enumeration that contains all the possible point
	 * additions and deductions needed to adjust a player's score.
	 */
	public enum scoreEvent
	{
		/**
		 * Increases score when player gets a correct set.
		 */
		ADD_SET,
		
		/**
		 * Decreases score when player gets a set wrong.
		 */
		MISS_SET,
		
		/**
		 * Decreases score when player runs out of time.
		 */
		TIME_OUT,
		
		/**
		 * Decreases score when player uses the hint button.
		 */
		HINT
	}
	
	/**
	 * Initializes the score for a player to 0.
	 */
    public Score() 
    {
    	//SET score equal to 0
    }
    
    /**
	 * Changes the players score based on the scoreEvent
	 *
	 *@param event
	 *			The scoreEvent passed by the caller providing 
	 *			information on how to adjust the player's score.
	 */
    public void modifyScore(scoreEvent event)
    {
    	//IF event equals ADD_SET
    		//ADD 1000 to score
    	
    	//ELSE IF event equals MISS_SET
    		//SUBTRACT 1000 from score
    	
    	//ELSE IF event equals TIME_OUT
    		//SUBTRACT 1000 from score
    	
    	//ELSE IF event equals HINT
    		//SUBTRACT 400 from score
    	
    	//END IF
    }
    
    /**
	 * Returns the current score of the player.
	 * 
	 * @return the current score of the player.
	 */
    public int getScore()
    {
    	//RETURN score	
    	return 0;
    }
    
    /**
	 * Resets the score for the player to 0.
	 */
    public void resetScore()
    {
    	//SET score equal to 0
    }
}