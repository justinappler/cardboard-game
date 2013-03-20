package unit.About;


import com.immortallabs.cardboard.About;

import junit.framework.TestCase;


/**
 * The test class AboutTest.
 *
 * @author  J. Dalbey
 */
public class AboutTest extends TestCase
{
	/** 
	 *  Tests for a bug presented in defects 26, 27, and 28
	 *  
	 *  Update by Bradley Barrows on 1/14/09  
	 *  Update by Ryan Lange on 1/14/09
	 *  Update by Thomas Dvornik on 1/14/09
	 *  Update by Justin Appler on 1/14/09
	 *  Edited by Michael Brooks on 1/13/09
	 *  Edited by Kyle Williamson on 1/14/09
	 */
	public void testGetAuthors28()
	{
		assertEquals("Michael Brooks/nLamont Samuels/nKyle Williamson/nJustin Appler/nThomas Dvornik/nBradley Barrows/nRyan Lange/n", About.getAuthors());
	}
}


