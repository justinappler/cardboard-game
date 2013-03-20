package com.immortallabs.cardboard.ui;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import com.immortallabs.cardboard.ui.KeyBindings.KEY_BIND;

/**
 * <p>The KeyBindingsWindow class models a window for a user 
 * to change all key binding for the game.</p>
 * 
 * @author Thomas Dvornik
 * @author RustyNail CSC308 F08
 * @version 1.2
 * @version 12/04/08
 * @see KeyBindings
 * @see KeyBindings.KEY_BIND
 * 
 * @history 
 * - 12/04/08 1.1 Create constructor with pseudocode. Added TODO
 * - 12/05/08 1.2 Fixed TODO. Created private class listener. Now using
 * 	textField instead of textArea. Cleaned up design so each textField
 * 	has its own listener which will take care of saving it to the keyMap
 * 	and display it in the textField. 
 */
public class KeyBindingWindow implements ActionListener {
	/** 
	 * The current KeyBindings. This is used to get the current key 
	 * bindings as well as save them since KeyBindings does the persistence.
	 */
	private KeyBindings keyBinding;
	
	
	/** 
	 * A map of all KEY_BIND to their corresponding key in string 
	 * representation. 
	 */
	private HashMap<KEY_BIND, String> keyMap;
	
	/**
	 * <p>This private class implements a KeyListener for TextFields</p>
	 * 
	 * @author Thomas Dvornik
	 * @author RustyNail CSC308 F08
	 * @version 1.1
	 * @version 12/04/08
	 */
	private class textFieldListener implements KeyListener {
		/** The TextField that corresponds to the listener. */
		private TextField textField;
		
		/** 
		 * Initializes the textFieldListener with a TextField
		 *
		 * @param textField The testField that this listener was added too
		 */
		public textFieldListener(TextField textField) {
			//SET this's textField to textField
		}
		
		/**
		 * Adds the new key binding to the keyMap and displays it in the 
		 * textField
		 */
		public void keyPressed(KeyEvent keyEvent) {
			String oldKey;
		
			//SET oldKey to textField's getText
			
			//CALL keyMap's put with findKeyBind with oldKey, keyEvent's 
			//	getText with keyEvent's getCode 
			
			//CALL textField's setText with keyEvent's getText with 
			//	keyEvent's getCode 
		}

		/** Not used in textFieldListner */
		public void keyReleased(KeyEvent e) {}
		/** Not used in textFieldListner */
		public void keyTyped(KeyEvent e) {}
	}
	
	/**
	 * Instantiates a window to change all the KEY_BIND
	 * 
	 * @param KEY_BIND The current key bindings
	 */
	public KeyBindingWindow(KeyBindings KEY_BIND) {
		//SET keyBinding to KEY_BIND
		
		//CREATE window
		
		//GET KEY_BIND entrySet
		//FOR each entry in entrySet
			//DISPLAY key's name from entry on new line
			//CREATE textField with value from entry same line as name 
			//CALL textField's setEditable to false
			//CALL textField's addActionListener with new textFieldListener
			//	with this
		//END FOR
		
		//CREATE save button
		//CALL save button's addActionListener with this
		//CREATE cancel button
		//CALL cancel button's addActionListener with this
	}
	
	/**
	 * Finds the KEY_BIND with a given key values as a string. This 
	 * method is used to get a KEYBIND with a string from the keyMap
	 * 
	 * @param keyValue String to turn into a KEY_BIND
	 * @return The KEY_BIND that corresponds to the string
	 */
	private KEY_BIND findKeyBind(String keyValue) {
		KEY_BIND keyBind = null;
		
		//FOR each entry in keyMap's entrySets
			//IF entry's value equals keyValues
				//SET keyBind to entry's key
		    //END IF
		//END FOR
		
		//RETURN keyBind
		return null;
	}
	
	
	/** 
	 * Handles the Save and Cancel button. If Save is pushed, save the 
	 * key binding to KeyBinding. Else if cancel is pushed, close the 
	 * window and don't do anything.
	 * 
	 * @param actionEvent The current action to perform
	 */
	public void actionPerformed(ActionEvent actionEvent) {
		//GET source from each
		//GET class from source
		//IF button is cancel
			//CLOSE window
		//ELSE IF button is save
			//CALL keyBinding's setKeyBindings with keyMap
		//END IF
	}
}
	
