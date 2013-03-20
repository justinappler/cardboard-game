package com.immortallabs.cardboard.ui;

import com.immortallabs.cardboard.ui.ScoresGraphicTester;

public class ScoresGraphicTesterDriver
{
   static ScoresGraphicTester tester;
   
   public static void main(String[] args) throws InterruptedException
   {
      tester = new ScoresGraphicTester(1);
      
      tester = new ScoresGraphicTester(2);
      
      tester = new ScoresGraphicTester(3);
      
      tester = new ScoresGraphicTester(4);

   }
}
