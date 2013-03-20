package com.immortallabs.cardboard.ui;


import com.immortallabs.cardboard.game.HighScores;


/**
 * The HighscoreWindow class creates a window that lists the top ten highest
 * scores. This class retrieves the scores from an instance of the HighScores
 * class. <br />
 * <br />
 * <b>Operations:</b>
 * <ul>
 * <li>The HighScoresWindow class can create a high scores window to display
 * the top ten scores.
 * </ul>
 * 
 * @author Brad Barrows
 * @version 1.3
 * @version Jan. 3rd, 2008
 * @history - 1/13/09 1.3 Updated packages and tags <br> - 12/04/08 1.2 More
 *          Pseudocoding<br> - 12/02/08 1.1 Added Version History & Pseudocode<br>
 */

public class HighScoresWindow
{

    /**
     * Creates a window displaying the top ten scores.
     * 
     * @param highscores
     *            The instance of Highscores to get the top ten scores from.
     * @see HighScores
     */
    public HighScoresWindow(HighScores highscores)
    {
        // CREATE a String theScores
        // CREATE an integer place = 1
        // WHILE the current highscores name is not null
        // EXTRACT name from highscores
        // EXTRACT score from highscores
        // APPEND the place and the current highscore name and score to
        // theScores
        // INCREMENT place
        // END WHILE

        // CREATE a dialog containing the string created above and a button
        // labeled "Ok" to close the dialog
    }

}
