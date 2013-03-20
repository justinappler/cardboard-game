package com.immortallabs.cardboard;

import com.immortallabs.cardboard.CardBoardResource;
import com.immortallabs.cardboard.CardBoardPreferences;
import com.immortallabs.cardboard.game.SoundPlayer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import edu.profdalbey.Natural;
import java.awt.Graphics;
import java.awt.Point;
public class TestSP extends JFrame
{
	
	public static void main(String args[]) 
	{
		new TestSP();
	}
	public TestSP() 
	{

	   //GameWindow gamewindow=new GameWindow();
      SoundPlayer sp=new SoundPlayer();
      CardBoardPreferences prefs=CardBoardPreferences.getInstance();
      
		JLabel jlbHelloWorld = new JLabel("asdf");
		add(jlbHelloWorld);
      sp.playActionAcknowledged();
      sp.playSetSuccess();
      sp.playSetFailure();
      sp.playWin();
		this.setSize(600, 600);
		setVisible(true);
		
	}

}
