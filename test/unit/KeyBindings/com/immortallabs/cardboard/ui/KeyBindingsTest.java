package com.immortallabs.cardboard.ui;

import java.util.HashMap;

import com.immortallabs.cardboard.ui.KeyBindings.KEY_BIND;

import junit.framework.TestCase;

public class KeyBindingsTest extends TestCase
{
   KeyBindings keys;
   
   public void setUp()
   {
      keys = new KeyBindings();
   }
   
   public void testGetKeyBinding()
   {
      assertEquals(keys.getKeyBinding(KEY_BIND.HINT), "72");
      assertEquals(keys.getKeyBinding(KEY_BIND.PAUSE), "80");
      assertEquals(keys.getKeyBinding(KEY_BIND.THREE_MORE), "84");
      assertEquals(keys.getKeyBinding(KEY_BIND.SELECT), "10");
      assertEquals(keys.getKeyBinding(KEY_BIND.UP), "38");
      assertEquals(keys.getKeyBinding(KEY_BIND.DOWN), "40");
      assertEquals(keys.getKeyBinding(KEY_BIND.LEFT), "37");
      assertEquals(keys.getKeyBinding(KEY_BIND.RIGHT), "39");
      assertEquals(keys.getKeyBinding(KEY_BIND.REMOVE_INLAY_POS_ONE), "49");
      assertEquals(keys.getKeyBinding(KEY_BIND.REMOVE_INLAY_POS_TWO), "50");
      assertEquals(keys.getKeyBinding(KEY_BIND.PLAYER1_BUZZ), "16");
      assertEquals(keys.getKeyBinding(KEY_BIND.PLAYER2_BUZZ), "32");
      assertEquals(keys.getKeyBinding(KEY_BIND.PLAYER3_BUZZ), "17");
      assertEquals(keys.getKeyBinding(KEY_BIND.PLAYER4_BUZZ), "96");
   }
   
   public void testSetKeyBindings()
   {
      HashMap<KEY_BIND, String> keyBindings = new HashMap<KEY_BIND, String>();
      
      //ADD the hint key to keyBindings
      keyBindings.put(KEY_BIND.HINT, "1");
      
      //ADD the pause key to keyBindings
      keyBindings.put(KEY_BIND.PAUSE, "1");
      
      //ADD the three more key to keyBindings
      keyBindings.put(KEY_BIND.THREE_MORE, "1");
      
      //ADD the select key to keyBindings
      keyBindings.put(KEY_BIND.SELECT, "1");
      
      //ADD the up key to keyBindings
      keyBindings.put(KEY_BIND.UP, "1");
      
      //ADD the down key to keyBindings
      keyBindings.put(KEY_BIND.DOWN, "1");
      
      //ADD the left key to keyBindings
      keyBindings.put(KEY_BIND.LEFT, "1");
      
      //ADD the right key to keyBindings
      keyBindings.put(KEY_BIND.RIGHT, "1");
      
      //ADD the remove inlay key one to keyBindings
      keyBindings.put(KEY_BIND.REMOVE_INLAY_POS_ONE, "1");
      
      //ADD the remove inlay key two to keyBindings
      keyBindings.put(KEY_BIND.REMOVE_INLAY_POS_TWO, "1");
      
      //ADD the player one buzz key to keyBindings
      keyBindings.put(KEY_BIND.PLAYER1_BUZZ, "1");
      
      //ADD the player two buzz key to keyBindings
      keyBindings.put(KEY_BIND.PLAYER2_BUZZ, "1");
      
      //ADD the player three buzz key to keyBindings
      keyBindings.put(KEY_BIND.PLAYER3_BUZZ, "1");
      
      //ADD the player four buzz key to keyBindings
      keyBindings.put(KEY_BIND.PLAYER4_BUZZ, "1");
      
      keys.setKeyBindings(keyBindings);
      
      assertEquals(keys.getKeyBinding(KEY_BIND.HINT), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.PAUSE), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.THREE_MORE), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.SELECT), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.UP), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.DOWN), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.LEFT), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.RIGHT), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.REMOVE_INLAY_POS_ONE), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.REMOVE_INLAY_POS_TWO), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.PLAYER1_BUZZ), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.PLAYER2_BUZZ), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.PLAYER3_BUZZ), "1");
      assertEquals(keys.getKeyBinding(KEY_BIND.PLAYER4_BUZZ), "1");
   }
}
