package com.immortallabs.cardboard.game;

import javax.sound.sampled.Clip;

import com.immortallabs.cardboard.CardBoardResource;
import com.immortallabs.cardboard.CardBoardPreferences;

/**
 * <p>
 * Loads and plays sound files. SoundPlayer will play four different types of
 * sounds depending on what is currently happening in the game.
 * </p>
 * <b>Operations:</b>
 * <ul>
 * <li>The SoundPlayer class plays various sounds depending on the game state</li>
 * </ul>
 * 
 * @author Brad Barrows
 * @author Formerly Sky Eckstrom
 * @author Rusty Nail CSC308 F08
 * @version 1.1
 * @version 12/04/08
 * @history - 12/04/08 1.1 Added Version History & Pseudocode<br>
 *          - 11/30/08 1.0 Inital Class Skeleton<br>
 **/
public class SoundPlayer
{
    /**
     * The name of the acknowledged sound file
     */
    private static final String kAcknowledgedFile = "ack.wav";

    /**
     * The name of the success sound file
     */
    private static final String kSuccessFile = "success.wav";

    /**
     * The name of the failure sound file
     */
    private static final String kFailureFile = "failure.wav";

    /**
     * The name of the winning sound file
     */
    private static final String kWinFile = "win.wav";

    /** The preferences for the cardboard game */
    private CardBoardPreferences prefs;

    /**
     * Instantiates a new SoundPlayer instance
     **/
    public SoundPlayer()
    {
       prefs = CardBoardPreferences.getInstance();
    }

    /**
     * Plays the sound associated with the acknowledgement of a user action in
     * the game.
     **/
    public void playActionAcknowledged()
    {
        //IF SOUND is enabled
        if(prefs.getPreference(CardBoardPreferences.PREF.SOUNDS).equals("ON"))
        {        
            // GET the acknowledged audio stream
            Clip audioClip =
                    CardBoardResource.getSound(this, kAcknowledgedFile);
           // PLAY the action acknowledged sound file
           audioClip.start();
        }
    }

    /**
     * Plays the sound associated with a successful completion of a set in the
     * game
     **/
    public void playSetSuccess()
    {
        //IF SOUND is enabled
        if(prefs.getPreference(CardBoardPreferences.PREF.SOUNDS).equals("ON"))
        {        
            // GET the acknowledged audio stream
            Clip audioClip =
                    CardBoardResource.getSound(this, kSuccessFile);
           // PLAY the action acknowledged sound file
           audioClip.start();
        }

    }

    /**
     * Plays the sound associated with an incorrect set in the game
     **/
    public void playSetFailure()
    {
        //IF SOUND is enabled
        if(prefs.getPreference(CardBoardPreferences.PREF.SOUNDS).equals("ON"))
        {        
            // GET the acknowledged audio stream
            Clip audioClip =
                    CardBoardResource.getSound(this, kFailureFile);
           // PLAY the action acknowledged sound file
           audioClip.start();
        }
    }

    /**
     * Plays the sound associated with winning the game
     **/
    public void playWin()
    {
        //IF SOUND is enabled
        if(prefs.getPreference(CardBoardPreferences.PREF.SOUNDS).equals("ON"))
        {        
            // GET the acknowledged audio stream
            Clip audioClip =
                    CardBoardResource.getSound(this, kWinFile);
           // PLAY the action acknowledged sound file
           audioClip.start();
        }
    }
}