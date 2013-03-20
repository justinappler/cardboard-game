package com.immortallabs.cardboard.ui;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import junit.framework.TestCase;

/**
 * <p>The CardBoardMenuTest class tests the CardBoardMenu.</p>
 * 
 * @author Michael Brooks
 * @author ImmortalLabs CSC 309 W'09
 * @version 1.0
 * @version 1/22/09
 *
 * @history  
 *  - 1/22/09 Version 1.0 Created test class.
 */
public class CardBoardMenuTest extends TestCase
{
	private CardBoardMenu test;
	private CardBoardMenu test2;

	
	public void setUp()
	{
		test = new CardBoardMenu(new ActionMap());
		test2 = new CardBoardMenu(new ActionMap());
	}
	
	/**
	 * Test that the menu is constructed correctly and 
	 * that getMenuBar() works as expected.
	 */
	public void testConstructorandGetMenuBar()
	{
		JMenuBar bar = test.getMenuBar();
		String hold = bar.toString();	
		JMenu one = bar.getMenu(0);
		JMenu two = bar.getMenu(1);
		JMenu three = bar.getMenu(2);
		JMenu newGame = (JMenu) one.getItem(0);
		JMenu prefs = (JMenu) two.getItem(0);
		JMenu time = (JMenu) prefs.getItem(0);
		JMenu multiplayer = (JMenu) newGame.getItem(3);
		
		assertEquals(hold.contains("DefaultMenuLayout"), true);
		assertEquals(hold.contains("flags=392"), true);		
		
		assertEquals(((((JMenu)one.getItem(0)).toString())).contains("New Game"), true);

		assertEquals(((((JMenuItem)newGame.getItem(1)).toString())).contains("Solitaire"), true);
		assertEquals(((((JMenuItem)newGame.getItem(0)).toString())).contains("Beginner"), true);
		assertEquals(((((JMenuItem)newGame.getItem(2)).toString())).contains("Competitive"), true);
		assertEquals(((((JMenu)newGame.getItem(3)).toString())).contains("Multiplayer"), true);
		
		assertEquals(((((JMenu)prefs.getItem(0)).toString())).contains("Time Limit"), true);
		
		assertEquals(((((JRadioButtonMenuItem)multiplayer.getItem(0)).toString())).contains("2 Player"), true);
		assertEquals(((((JRadioButtonMenuItem)multiplayer.getItem(1)).toString())).contains("3 Player"), true);
		assertEquals(((((JRadioButtonMenuItem)multiplayer.getItem(2)).toString())).contains("4 Player"), true);

		assertEquals(((((JRadioButtonMenuItem)time.getItem(0)).toString())).contains("15 Seconds"), true);
		assertEquals(((((JRadioButtonMenuItem)time.getItem(1)).toString())).contains("30 Seconds"), true);
		assertEquals(((((JRadioButtonMenuItem)time.getItem(2)).toString())).contains("45 Seconds"), true);

		assertEquals(((((JMenuItem)three.getItem(0)).toString())).contains("About CardBoard"), true);
		assertEquals(((((JMenuItem)three.getItem(1)).toString())).contains("How to play CardBoard"), true);
		
		
	}
	
	/**
	 * Tests that the menu is consistently constructed
	 * correctly.
	 */
	public void testConsistentBuild()
	{
		assertEquals(test.getMenuBar().toString(), test2.getMenuBar().toString());
	}
}
