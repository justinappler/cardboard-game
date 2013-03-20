package com.immortallabs.cardboard.game;

/**
 *	<p>Loads and plays sound files. SoundPlayer will play
 *	four different types of sounds depending on what
 *	is currently happening in the game.</p>
 *
 *	<b>Operations:</b>
 *	<ul>
 *	<li>The SoundPlayer class plays various sounds depending on
 *		the game state</li>
 *	</ul>
 *
 * @author Brad Barrows
 * @version 1.3
 * @version Jan. 3rd, 2008
 *
 *	@history
 *    - 1/13/09  1.3 Updated packages and tags <br> 
 *		- 12/04/08 1.1	Added Version History & Pseudocode<br>
 *		- 11/30/08 1.0	Inital Class Skeleton<br>
 *
 **/
public class SoundPlayer
{
	/**
	 *	Instantiates a new SoundPlayer instance
	 **/
	public SoundPlayer()
	{
	}
	
	/**
	 *	Plays the sound associated with
	 *	the acknowledgement of a user action
	 *	in the game.
	 **/
	 public void playActionAcknowledged()
	 {
	 	// LOAD the action acknowledged sound file
	 	// PLAY the action acknowledged sound file
	 }
	 
	 /**
	  *	Plays the sound associated with a successful
	  *	completion of a set in the game
	  **/
	 public void playSetSuccess()
	 {
	 	// LOAD the set success sound file
	 	// PLAY the set success sound file
	 }
	 
	 /**
	  *	Plays the sound associated with an incorrect
	  *	set in the game
	  **/
	 public void playSetFailure()
	 {
	 	// LOAD the set failure sound file
	 	// PLAY the set failure sund file
	 }
	 
	 /**
	  *	Plays the sound associated with winning the
	  *	game
	  **/
	 public void playWin()
	 {
	 	// LOAD the win sound file
	 	// PLAY the win sound file
	 }
}
