package com.immortallabs.cardboard.game;

import java.util.ArrayList;

import edu.profdalbey.Natural;

/**
 * <p>The HighScores class models a high score list.  The High Score class can
 * have up to 10 High Scores each of which has a score value and a name 
 * associated with it.  When a High Score is added to a full list, the lowest
 * score is dropped from the list.</p>
 * 
 * <b>Operations:</b>
 * <ul>
 * <li>The HighScores class can check if a score is a high score
 * <li>The HighScores class can add a new high score to the High Score List
 * <li>The HighScores class can provide the names of players in the list
 * <li>The HighScores class can provide the scores of the players in the list
 * <li>The HighScores class maintains it's own persistence
 * </ul>
 * @author Lamont Samuels
 * @author Immortal Labs CSC309 W09
 * @author Justin C. Appler
 * @author Rusty Nail CSC308 F08
 * @version 1.3
 * @version January 13h, 2009
 * @see Logic
 * 
 * @history
 *  - 01/13/08 Updated the author tags and version. 
 *  - 12/04/08 1.2 Conformed JavaDocs to RustyNail Standard, Added Package<br>
 *  - 12/02/08 1.1 Added Version History & Pseudoscode<br>
 *  - 12/01/08 1.0 Initial Class Skeleton<br>
 */
public class HighScores
{
	/** The location of the High Scores data file relative 
	 * to the current directory
	 */
	private static final String kHighScoresFile = "highscores.dat";
	
	/** List of Scores in the top 10 list */
	private ArrayList<Score> scores;
	
	/** Lists of player names in the top 10 list */
	private ArrayList<String> names;
	
	/**
	 *  Creates a new HighScores using default paths for persistence 
	 */
	public HighScores()
	{
		//INSTANTIATE the parallel scores and names lists
		//OPEN the HighScoresFile
		
		//FOR each line of the file
			//SPLIT the line into a score and a name
			//INSERT the name at the end of the names list
			//INSERT the score at the end of the scores list
		//END for each
		
		//CLOSE the HighScoresFile
	}
	
	/**
	 * Checks to see if the passed score is higher than the lowest score
	 * in the list of High Scores.
	 * 
	 * @param score Score to compare to the list
	 * @return True if the score is higher than a score in the list, false
	 * otherwise
	 */
	public boolean isHighScore(Score score)
	{
		//GET the last score in the scores list
		//RETURN the passed score is greater than the last score
		return true;
	}
	
	/**
	 * Adds a High Score to the list of High Scores
	 * 
	 * Pre-condition: The passed score is higher than the last score in the
	 * 				  list
	 * 
	 * @param score The score to add
	 * @param name The player name/handle to associate with the score
	 */
	public void addScore(Score score, String name)
	{
		//IF the passed score is greater than the last score
		
			//REMOVE the last item from the scores and names lists
			
			//FOR EACH of the scores in the list starting at the bottom
				//IF the passed score is less than the current score
				//   AND the score has not yet been added
					//INSERT the passed score at the current position in scores
					//INSERT the passed name at the current position in names
				//END IF
	        //END FOR EACH
		//END IF
		
		//OPEN the HighScoresFile
		
		//FOR each of the scores in the list
			//WRITE a line containing the score, a comma, 
		    	// and the respective name
		//END FOR each
		
		//CLOSE the HighScoresFile
	}
	
	/**
	 * Gets the name of the player with the given index in the list
	 * of High Scores.
	 * 
	 * (1 returns the player in First Place, 10 returns the player in last place)
	 * 
	 * @param index The rank of the player in the High Score List
	 * @return The name/handle of the player at the given index
	 * @throws IndexOutOfBoundsException If the index is less than 1 or greater than 10
	 */
	public String getHighScoreName(Natural index) throws IndexOutOfBoundsException
	{
		//RETURN the string at the passed index in the names list
		return null;
	}
	
	/**
	 * Gets the score of the player with the given index in the list
	 * of High Scores
	 * 
	 * (1 returns the player in First Place, 10 returns the player in last place)
	 * 
	 * @param index The rank of the player in the High Score List
	 * @return The score of the player at the given index
	 * @throws IndexOutOfBoundsException If the index is less than 1 or greater than 10
	 */
	public int getHighScoreValue(Natural index) throws IndexOutOfBoundsException
	{
		//RETURN the integer at the passed index in the score list
		return 0;
	}
}
