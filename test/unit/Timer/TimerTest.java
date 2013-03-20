package unit.Timer;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Observable;
import java.util.Observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.immortallabs.cardboard.game.Timer;
import com.immortallabs.cardboard.game.Timer.TIMER_LIMIT;

public class TimerTest implements Observer
{
	private boolean expired;
	
	@Before
	public void setUp() throws Exception
	{
		expired = false;
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testTimer()
	{
		Timer t = new Timer();
		sleep(3);
		assertEquals(3, t.getSeconds().intValue());
		t.pause();
	}

	@Test
	public void testStartCountUp()
	{
		Timer t = new Timer();
		t.startCountUp();
		sleep(3);
		assertEquals(3, t.getSeconds().intValue());
		t.pause();
	}

	@Test
	public void testPause()
	{
		Timer t = new Timer();
		t.startCountUp();
		sleep(1);
		t.pause();
		sleep(2);
		assertEquals(1, t.getSeconds().intValue());
		t.pause();
	}

	@Test
	public void testResume()
	{
		Timer t = new Timer();
		t.startCountUp();
		sleep(1);
		t.pause();
		sleep(2);
		assertEquals(1, t.getSeconds().intValue());
		t.resume();
		sleep(2);
		assertEquals(3, t.getSeconds().intValue());
		t.pause();
	}

	@Test
	public void testBuzzIn()
	{
		Timer t = new Timer();
		t.startCountUp();
		sleep(1);
		assertEquals(1, t.getSeconds().intValue());
		t.buzzIn();
		assertEquals(15, t.getSeconds().intValue());
		sleep(2);
		assertEquals(13, t.getSeconds().intValue());
		t.pause();
	}

	@Test
	public void testBuzzDone()
	{
		Timer t = new Timer();
		t.startCountUp();
		sleep(1);
		assertEquals(1, t.getSeconds().intValue());
		t.buzzIn();
		assertEquals(15, t.getSeconds().intValue());
		sleep(2);
		assertEquals(13, t.getSeconds().intValue());
		t.buzzDone();
		assertEquals(1, t.getSeconds().intValue());
		t.pause();
	}

	@Test
	public void testStartCountdown()
	{
		Timer t = new Timer();
		t.addObserver(this);
		t.startCountdown(TIMER_LIMIT.TIME_15SEC);
		sleep(1);
		assertEquals(14, t.getSeconds().intValue());
		sleep(13);
		assertEquals(1, t.getSeconds().intValue());
		assertFalse(expired);
		sleep(2);
		assertTrue(expired);
	}
	
	@Test
	public void testDefect158()
	{
	    assertTrue(TIMER_LIMIT.TIME_15SEC.toString().equals("TIME_15SEC"));
	    assertTrue(TIMER_LIMIT.TIME_30SEC.toString().equals("TIME_30SEC"));
	    assertTrue(TIMER_LIMIT.TIME_45SEC.toString().equals("TIME_45SEC"));
	    assertTrue(TIMER_LIMIT.TIME_UNLIMITED.toString().equals("TIME_UNLIMITED"));
	}
	
	@Test
    public void testDefect177() throws Exception
    {
        Timer t = new Timer();
        t.addObserver(this);
        t.startCountdown(TIMER_LIMIT.TIME_UNLIMITED);
        sleep(1);
        assertEquals(1, t.getSeconds().intValue());
        sleep(1);
        assertEquals(2, t.getSeconds().intValue());
    }

	@Test
    public void testDefect178() throws Exception
    {
        Timer t = new Timer();
        t.addObserver(this);
        t.startCountdown(TIMER_LIMIT.TIME_15SEC);
        t.startCountUp();
        assertTrue(!expired);
        sleep(15);
        assertTrue(!expired);
    }
	
	private void sleep(int seconds)
	{
		try
		{
			Thread.sleep(seconds * 1020);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Observable o, Object arg)
	{
		if (((Timer) o).isExpired())
			expired = true;
	}
}
