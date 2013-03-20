package com.immortallabs.cardboard; 
 
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
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
        BufferedImage returnVal = null; 
         
        //IF imageMap has not been constructed 
        if (imageMap == null) 
        { 
            initializeMaps(); 
        } 
        
        //GET the item in imageMap with the same name 
        returnVal = imageMap.get(imageName); 
         
        //IF the image exists in imageMap, return result 
        if (returnVal != null) 
        { 
            return returnVal; 
        } 
        //ELSE add the image to imageMap and return it 
        else 
        { 
            return addImageToMap(caller, imageName); 
        } 
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
        BufferedImage returnVal = null; 
         
        //TRY to load the image from the .jar 
        try 
        { 
            returnVal = ImageIO.read(caller.getClass().
                  getResourceAsStream("/images/" + imageName)); 
        } 
        catch (Exception e1) 
        { 
           //TRY to load the image from the images folder 
           try 
           { 
               returnVal = ImageIO.read(new File("images/" + imageName)); 
           } 
           catch (Exception e2) 
           { 
               System.err.println("Couldn't load image file: " + imageName); 
           } 
        } 
        
        //IF the image is not null 
        if(imageMap != null) 
        {
         imageMap.put(imageName, returnVal); 
        }
         
        return returnVal; 
         
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
        Clip returnVal = null; 
         
        //IF soundMap has not been constructed 
        if (soundMap == null) 
        { 
            initializeMaps(); 
        } 
         
        returnVal = soundMap.get(soundName); 
         
        //IF the sound exists in soundMap, return result 
        if (returnVal != null) 
        { 
            // RESET the clip to it's initial frame position 
            returnVal.setFramePosition(0); 
             
            return returnVal; 
        } 
        //ELSE add the sound to soundMap and return it 
        else 
        { 
            return addSoundToMap(caller, soundName); 
        } 
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
        Clip returnVal = null; 
        AudioInputStream inputStream = null; 
        DataLine.Info info = null; 
         
        //TRY to load the sound clip from .jar 
        try 
        { 
             BufferedInputStream buffer = new BufferedInputStream((caller.getClass()
               .getResourceAsStream("/sounds/" + soundName)));

             inputStream = AudioSystem.getAudioInputStream(buffer);
        } 
        catch (Exception e1) 
        { 
           //TRY to load the sound clip from the sounds folder 
           try 
           { 
               inputStream = AudioSystem.getAudioInputStream(new 
                     File("sounds/" + soundName)); 
           } 
           catch (Exception e2) 
           { 
               System.err.println("Couldn't load audio file: " + soundName); 
           } 
        } 
        
        //IF the audio stream is not null 
        if(inputStream != null) 
        {
         info = new DataLine.Info(Clip.class, inputStream.getFormat());
        }
         
        //TRY and convert a DataLine, which implements
        //Clip, into a sound Clip and open it 
        try 
        { 
            returnVal = (Clip) AudioSystem.getLine(info); 
            returnVal.open(inputStream); 
        } 
        catch (Exception e) 
        { 
            System.err.println("Error creating audio clip: " + soundName); 
        } 

        //ADD the sound to soundMap 
        soundMap.put(soundName, returnVal); 
         
        return returnVal; 
         
    } 
 
    /** 
     * Initializes the image and sound maps 
     */ 
    private static void initializeMaps() 
    { 
        // IF there is no image map 
        if (imageMap == null) 
        { 
            // INITIALIZE the image map 
            imageMap = new HashMap<String, BufferedImage>(); 
        } 
         
        // IF there is no sound map 
        if (soundMap == null) 
        { 
            // INITIALIZE the sound map 
            soundMap = new HashMap<String, Clip>(); 
        } 
    } 
} 

