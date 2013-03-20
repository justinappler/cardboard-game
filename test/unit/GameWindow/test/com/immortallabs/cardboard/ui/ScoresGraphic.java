package com.immortallabs.cardboard.ui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import com.immortallabs.cardboard.game.GameState;
import com.immortallabs.cardboard.game.Score;

/**
 * FAKE
 */

public class ScoresGraphic extends Component 
{
	/**
	 * Scores of player 1
	 */
	private Score player1;

	/**
	 * Scores of player 2
	 */
	private Score player2;

	/**
	 * Scores of player 3
	 */
	private Score player3;

	/**
	 * Scores of player 4
	 */
	private Score player4;
	
	/**
	 * Hold the amount of players to paint in the window
	 */
	private int amountOfPlayers;
	
   private static int tempCount = 0; 
	private Point p; 
	/**
	 * Initializes the ScoresGraphic with a Score from each player.
	 * If the Score for a player is NULL than that Score is ignored.
	 *
	 * @param p  the Point at which to draw the ScoresGraphic window.
	 * @param p1 the Score of player one.
	 * @param p2 the Score of player two.
	 * @param p3 the Score of player three.
	 * @param p4 the Score of player four. 
	 */
    public ScoresGraphic(Point p, Score p1, Score p2, Score p3, Score p4) 
    {
    	this.p = p; 
    	//SET player1 equal to p1
    	//SET player2 equal to p2
    	//SET player3 equal to p3
    	//SET player4 equal to p4
    	
    	//IF p2 equals null
    		//SET amountOfPlayers to 1
    	//ELSE IF p3 equals null
    		//SET amountOfPlayers to 2
    	//ELSE IF p4 equals null
    		//SET amountOfPlayers to 3	
    	//ELSE
    		//SET amountOfPlayers to 4
    	//END IF
    
    	
    	//CALL createWindow
    }
    
    /**
     * Creates a window to display the each player and their score
     * 
     * @param p  the Point at which to draw the ScoresGraphic window.
     */
    private void createWindow(Point p)
    {	
    	//CREATE a window at the point p passed in
    	//SET length of window to ....
    	//SET height of window to ....
    	
    	//FOR i=0 to i = amountOfPlayers
    		//IF i equals 0
    			//GET score of player1
    			//ADD text player1: to window
    			//INSERT score of player1
    		//ELSE IF i equals 1
    			//GET score of player2
    			//ADD text player2: to window
				//INSERT score of player2
    		//ELSE IF i equals 2
    			//GET score of player3
    			//ADD text player3: to window
				//INSERT score of player3
    		//ELSE IF i equals 3
    			//GET score of player4
    			//ADD text player4: to window
				//INSERT score of player4
    		//END IF
    	//END FOR
    	
    	//CALL paint() with the window
    }
    public void setBuzzedPlayer(GameState.PLAYER player)
    {

    }
	@Override
	public void paint(Graphics g)
	{
		//PAINT the score graphic window
		super.paint(g);

         Font font = new Font("TimesRoman", Font.BOLD,  20);
         g.setFont(font);
         g.setColor(Color.white);
         g.drawString("Player One: 24", p.x, p.y); 
      if(tempCount++ == 0) 
      {
         System.out.println("Score Graphic printed"); 
      } 
	}
}