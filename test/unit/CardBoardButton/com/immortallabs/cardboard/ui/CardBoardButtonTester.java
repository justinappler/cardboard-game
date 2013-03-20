package com.immortallabs.cardboard.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.immortallabs.cardboard.ui.CardBoardButton.BUTTONTYPE;

public class CardBoardButtonTester
{
   private CardBoardButton b1;
   private CardBoardButton b2;
   private CardBoardButton b3;
   private CardBoardButton b4;
   private CardBoardButton b5;
   private CardBoardButton b6;
   private CardBoardButton b7;

   public CardBoardButtonTester()
   {
      b1 = new CardBoardButton(new Point(0, 0), null, BUTTONTYPE.EXPLAIN,
            "Explain");
      b2 = new CardBoardButton(new Point(0, 100), null, BUTTONTYPE.WELCOME,
            "Welcome");
      b3 = new CardBoardButton(new Point(0, 200), null, BUTTONTYPE.HINT, "Hint");
      b4 = new CardBoardButton(new Point(0, 300), null, BUTTONTYPE.PAUSE,
            "Pause");
      b5 = new CardBoardButton(new Point(0, 400), null, BUTTONTYPE.UNPAUSE,
            "Unpause");
      b6 = new CardBoardButton(new Point(0, 200), null, BUTTONTYPE.THREEMORE,
            "Three More");
      b7 = new CardBoardButton(new Point(0, 300), null, BUTTONTYPE.OK, "OK");

      System.out.println(b1.getType().name());
      System.out.println(b2.getType().name());
      System.out.println(b3.getType().name());
      System.out.println(b4.getType().name());
      System.out.println(b5.getType().name());
      System.out.println(b6.getType().name());
      System.out.println(b7.getType().name());

      testDefect159();
      testDefect160();
   }

   public void testDefect159()
   {
      CardBoardButton button = new CardBoardButton(new Point(0, 0), null,
            BUTTONTYPE.EXPLAIN, "Explain");

      System.out.println(button.getType().name());
   }
   
   public void testDefect160()
   {
      CardBoardButton button = new CardBoardButton(new Point(0, 0), null,
            BUTTONTYPE.EXPLAIN, "Explain");

      System.out.println(button.getType().name());
   }
}
