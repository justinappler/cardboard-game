package com.immortallabs.cardboard;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 * <p>
 * The CardBoardResource class models an external resource contained either in
 * the application's JAR file or in a directory relative to the working
 * directory.
 * </p>
 * <b>Operations:</b>
 * <ul>
 * <li>The CardBoardResource class can return an image or sound to the
 * requesting class
 * <li>The CardBoardResource class can cache loaded images or sounds to improve
 * performance
 * </ul>
 * 
 * @author Kyle Williamson
 * @author Formerly Justin C. Appler
 * @author Immortal Labs, CSC309 W09
 * 
 * @version 1.1
 * @version February 14th, 2009
 * 
 * @see GameWindow
 * @see CardBoardButton
 * @see CardGraphic
 * @see SoundPlayer
 * @history 
 *      - 02/14/09 1.1 Class taken over by Kyle
 *      - 02/11/09 1.0 Initial version<br>
 */
public class CardBoardResource
{
    /** A mapping between the image file names and the image class */
    private static HashMap<String, BufferedImage> imageMap;
    
    /** A mapping between the sound file names and the sound stream */
    private static HashMap<String, Clip> soundMap;
    
    /**
     * Gets an image given a calling class and a filename for the image.
     * 
     * @param caller Class that is calling the method
     * @param imageName The filename of the desired image
     * @return The image of the filename requested
     */
    public static BufferedImage getImage(Object caller, String imageName)
    {   
	System.out.println("Getting image...");

	return  null;
    }

    /**
     * Adds an image to the image map and returns the image added
     * 
     * @param caller The object that is attempting to get a copy of the image
     * @param imageName The filename of the image to be added to the map
     * @return The image specified in the image name
     */
    private static BufferedImage addImageToMap(Object caller, String imageName)
    {
        return null;
        
    }

    /**
     * Gets a sound stream given a calling class and a filename for the sound.
     * 
     * @param caller Class that is calling the method
     * @param soundName The filename of the desired sound
     * @return The sound of the filename requested
     */
    public static Clip getSound(Object caller, String soundName)
    {   
        return null;
    }

    /**
     * Adds a sound to the sound map and returns the sound added
     * 
     * @param caller The object that is attempting to get a copy of the sound
     * @param soundName The filename of the sound to be added to the map
     * @return The sound specified in the sound name
     */
    private static Clip addSoundToMap(Object caller, String soundName)
    {
        return null;
        
    }

    /**
     * Initializes the image and sound maps
     */
    private static void initializeMaps()
    {
        
    }
}
