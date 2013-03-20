package com.immortallabs.cardboard.game;

/**
 * <p>
 * The Score class models each players score. A score is a non-negative integer
 * that can be increased or decreased based on game play.
 * </p>
 * <br>
 * <br>
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
 * @history - 12/04/08 0.2 Added Version History & Pseudocode<br>
 *          - 12/01/08 0.1 Initial Class Skeleton<br>
 */

public class Score
{
    /**
     * Amount to add to the score if the player gets a set.
     */
    private static final int kAddSet = 15;

    /**
     * Amount to add to the score if the player gets an incorrect set.
     */
    private static final int kMissSet = 5;

    /**
     * Amount to add to the score if the player runs out of time.
     */
    private static final int kTimeOut = 10;

    /**
     * Amount to add to the score if the player uses a hint.
     */
    private static final int kHint = 5;

    /**
     * Amount to add to the score if the player asks for three more when there
     * is a set.
     */
    private static final int kThreeMore = 3;

    /**
     * The score for a player.
     */
    private int score;

    /**
     * An enumeration that contains all the possible point additions and
     * deductions needed to adjust a player's score.
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
        HINT,
        /**
         * Decreases the players score if the player asks for three more when
         * there is at least one set on the board.
         */
        THREE_MORE
    }

    /**
     * Initializes the score for a player to 0.
     */
    public Score()
    {
        // SET score equal to 0
        score = 0;
    }

    /**
     * Changes the players score based on the scoreEvent
     * 
     *@param event
     *            The scoreEvent passed by the caller providing information on
     *            how to adjust the player's score.
     */
    public void modifyScore(scoreEvent event)
    {
        // IF event equals ADD_SET
        if (event == scoreEvent.ADD_SET)
        {
            // ADD 15 to score
            score += kAddSet;
        }

        // ELSE IF event equals MISS_SET
        else if (event == scoreEvent.MISS_SET)
        {
            // SUBTRACT 5 from score
            score -= kMissSet;
        }

        // ELSE IF event equals TIME_OUT
        else if (event == scoreEvent.TIME_OUT)
        {
            // SUBTRACT 10 from score
            score -= kTimeOut;
        }

        // ELSE IF event equals HINT
        else if (event == scoreEvent.HINT)
        {
            // SUBTRACT 2 from score
            score -= kHint;
        }

        // ELSE IF event equals THREE_MORE
        else if (event == scoreEvent.THREE_MORE)
        {
            // SUBTRACT 3 from score
            score -= kThreeMore;
        }
        // END IF
        
        //IF the score is below zero
        if (score < 0)
        {
            //SET the score to 0
            score = 0;
        }
    }

    /**
     * Returns the current score of the player.
     * 
     * @return the current score of the player.
     */
    public int getScore()
    {
        // RETURN score
        return score;
    }

    /**
     * Resets the score for the player to 0.
     */
    public void resetScore()
    {
        // SET score equal to 0
        score = 0;
    }
}
