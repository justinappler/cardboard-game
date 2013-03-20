package com.immortallabs.cardboard;

import com.immortallabs.cardboard.ui.CardGraphic;
import com.immortallabs.cardboard.ui.ActionMap;
import com.immortallabs.cardboard.ui.GameWindow;
import com.immortallabs.cardboard.game.Card;
import com.immortallabs.cardboard.game.SetsBoard;
import javax.swing.JFrame;
import javax.swing.JLabel;
import edu.profdalbey.Natural;
import java.awt.Graphics;
import java.awt.Point;

public class TestCG extends JFrame
{
   private CardGraphic cg;	private Card c;
	
	public static void main(String args[]) 
	{
		new TestCG();
	}
	public TestCG() 
	{
	   //(Card card, ActionMap actionmap, Natural row, Natural column, GameWindow gamewindow)
	   
	   c=new Card(Card.SHAPE.DIAMONDS,Card.COLOR.PURPLE, Card.FILL.STRIPED ,Card.NUMBER.TWO);
	   ActionMap actionmap=new ActionMap();
	   GameWindow gamewindow=new GameWindow();

      Card temp;
           
	   cg=new CardGraphic(c, actionmap, new Natural(2), new Natural(2), gamewindow, new Point(200,200) );
	   
      temp=cg.getCard();
		JLabel jlbHelloWorld = new JLabel("asdf");
		add(jlbHelloWorld);
		//cg.animateTo(new Point(0,0));
		cg.scaleTo(SetsBoard.ROWS.SIX);
		//cg.animateTo(new Point(300,300));
		this.setSize(600, 600);
		setVisible(true);
	    try
	    {
	       Thread.sleep(1000);        
	             
	    }catch (InterruptedException ie)
	    {
	       System.out.println(ie.getMessage());
	    }
	    System.exit(0);
	     		
	}
	public void paint(Graphics g)
   {
		while(true) cg.paint(g);
   }
	public void update(Graphics g)
   {
      cg.paint(g);

   }
}
