package com.immortallabs.cardboard.game;



public class Score
{

    private static final int kAddSet = 15;


    private static final int kMissSet = 5;


    private static final int kTimeOut = 10;


    private static final int kHint = 5;


    private static final int kThreeMore = 3;


    private int score;

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


    public Score()
    {

    }


    public void modifyScore(scoreEvent event)
    {

    }


    public int getScore()
    {
        return 0;
    }


    public void resetScore()
    {

    }
}
