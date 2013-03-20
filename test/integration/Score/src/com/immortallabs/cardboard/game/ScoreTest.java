package com.immortallabs.cardboard.game;

import com.immortallabs.cardboard.game.Score.scoreEvent;

import junit.framework.TestCase;

public class ScoreTest extends TestCase
{
   Score s;
   
   
   protected void setUp() throws Exception
   {
      s = new Score();
   }
   
   public void testConstructor()
   {
      assertEquals(0, s.getScore());
   }

   public void testModifyScore()
   {
      s.modifyScore(scoreEvent.ADD_SET);
      assertEquals(15, s.getScore());
      
      s.modifyScore(scoreEvent.MISS_SET);
      assertEquals(10, s.getScore());
      
      s.modifyScore(scoreEvent.ADD_SET);
      assertEquals(25, s.getScore());
      
      s.modifyScore(scoreEvent.TIME_OUT);
      assertEquals(15, s.getScore());
      
      s.modifyScore(scoreEvent.ADD_SET);
      assertEquals(30, s.getScore());
      
      s.modifyScore(scoreEvent.HINT);
      assertEquals(25, s.getScore());
      
      s.modifyScore(scoreEvent.HINT);
      assertEquals(20, s.getScore());

      s.modifyScore(scoreEvent.THREE_MORE);
      assertEquals(17, s.getScore());
   }
   
   public void testResetScore()
   {
      s.modifyScore(scoreEvent.ADD_SET);
      
      s.resetScore();
      assertEquals(0, s.getScore());
   }

   public void testScoreSetBelowZero()
   {
      s.modifyScore(scoreEvent.ADD_SET);

      s.modifyScore(scoreEvent.TIME_OUT);
      s.modifyScore(scoreEvent.TIME_OUT);

      assertEquals(0, s.getScore());
   }
}
