#!/bin/bash
set -o verbose
rm -rf SoundPlayer/classes/*

# Compile the fake classes
javac -classpath :SoundPlayer/classes/:SoundPlayer -d SoundPlayer/classes/ SoundPlayer/com/immortallabs/cardboard/ui/ActionMap.java
javac -classpath :SoundPlayer/classes/:SoundPlayer -d SoundPlayer/classes/ SoundPlayer/com/immortallabs/cardboard/ui/GameWindow.java
javac -classpath :SoundPlayer/classes/:SoundPlayer -d SoundPlayer/classes/ SoundPlayer/com/immortallabs/cardboard/CardBoardPreferences.java
javac -classpath :SoundPlayer/classes/:SoundPlayer -d SoundPlayer/classes/ SoundPlayer/com/immortallabs/cardboard/CardBoardResource.java
javac -classpath :SoundPlayer/classes/:SoundPlayer -d SoundPlayer/classes/ SoundPlayer/edu/profdalbey/Natural.java

# Compile the real classes we are testing
javac -classpath ./SoundPlayer/classes/ -d SoundPlayer/classes/ ../../src/com/immortallabs/cardboard/game/SoundPlayer.java

# Instrument the classes we want coverage on.
java -cp ../resources/emma.jar emma instr -ip ./SoundPlayer/classes/ -m overwrite -out SoundPlayer_Unit.em -filter -*Map* -filter -*Preferences* -filter -*Resources* -filter -*Window* -filter -*Test* -filter -*Natural* -filter -*Card* -filter -*Game*

# Compile the junit classes
javac -classpath SoundPlayer/classes/:./junit.jar -d SoundPlayer/classes/ SoundPlayer/com/immortallabs/cardboard/TestSP.java 

# Run the driver and save the result
java -classpath :../resources/emma.jar:./SoundPlayer/classes/:./SoundPlayer/classes/com/immortallabs/cardboard:./ com.immortallabs.cardboard.TestSP


