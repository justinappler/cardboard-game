package com.immortallabs.cardboard;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import junit.framework.TestCase;

import com.immortallabs.cardboard.game.SoundPlayer;

public class CardBoardResourcesSoundsTest extends TestCase {
	
	CardBoardResource cBR;
	SoundPlayer sp;
	
	public CardBoardResourcesSoundsTest(String s)
    {
        super(s);
    }
    
    public void setUp()
    {
        sp = new SoundPlayer();
        cBR = new CardBoardResource();
    }
    
    public void testNullSoundGetSound()
    {
        try
        {
            Clip soundTest = CardBoardResource.getSound(sp, "beep-01.wav");
            
            Clip newSound = null;
            AudioInputStream aStream = AudioSystem.getAudioInputStream(new File("sounds/beep-01.wav"));
            DataLine.Info dl = new DataLine.Info(Clip.class, aStream.getFormat());
            newSound = (Clip)AudioSystem.getLine(dl);
            newSound.open(aStream);

            assertEquals(newSound.getFrameLength(), soundTest.getFrameLength());
            assertEquals(newSound.getMicrosecondLength(), soundTest.getMicrosecondLength());
            assertEquals(newSound.getMicrosecondPosition(), soundTest.getMicrosecondPosition());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public void testAddAndRetrieveSound()
    {
        try{
            CardBoardResource.getSound(sp, "beep-01.wav");
            CardBoardResource.getSound(sp, "beep-02.wav");
            CardBoardResource.getSound(sp, "beep-03.wav");
            CardBoardResource.getSound(sp, "beep-04.wav");
            Clip clipOne = CardBoardResource.getSound(sp, "beep-05.wav");
            CardBoardResource.getSound(sp, "beep-06.wav");
            CardBoardResource.getSound(sp, "beep-07.wav");
            CardBoardResource.getSound(sp, "beep-08.wav");
            CardBoardResource.getSound(sp, "beep-09.wav");
            CardBoardResource.getSound(sp, "beep-10.wav");
            Clip clipTwo = CardBoardResource.getSound(sp, "beep-10.wav");
            
            assertEquals(clipOne.getFrameLength(), 4973);
            assertEquals(clipOne.getMicrosecondLength(), 451065);
            assertEquals(clipOne.getMicrosecondPosition(), 0);
            
            assertEquals(clipTwo.getFrameLength(), 5712);
            assertEquals(clipTwo.getMicrosecondLength(), 518095);
            assertEquals(clipOne.getMicrosecondPosition(), 0);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void testInvalidSound()
    {
    	CardBoardResource.getSound(sp, "ThisIsNotARealSound.wav");
    	
    	System.out.println("\nCompare the last line against this one:\n"
    			+ "Couldn't load audio file: ThisIsNotARealSound.wav" +
    					"Error creating audio clip: ThisIsNotARealSound.wav");
 /*   	assertEquals(CardBoardResource.getSound(sp, "ThisIsNotARealSound.wav"),
    			"Couldn't load audio file: ThisIsNotARealSound.wav");*/
    }

}