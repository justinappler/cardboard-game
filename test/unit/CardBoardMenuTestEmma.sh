#!/bin/bash
set -o verbose
rm -rf CardBoardMenu/classes/*

# Compile the fake classes
javac -classpath :CardBoardMenu/classes/:CardBoardMenu/src -d CardBoardMenu/classes/ CardBoardMenu/src/com/immortallabs/cardboard/ui/ActionMap.java
javac -classpath :CardBoardMenu/classes/:CardBoardMenu/src -d CardBoardMenu/classes/ CardBoardMenu/src/com/immortallabs/cardboard/CardBoardPreferences.java

# Compile the real classes we are testing
javac -classpath ./CardBoardMenu/classes/ -d CardBoardMenu/classes/ ../../src/com/immortallabs/cardboard/ui/CardBoardMenu.java

# Compile the junit classes
javac -classpath CardBoardMenu/classes/:./junit.jar -d CardBoardMenu/classes/ CardBoardMenu/src/com/immortallabs/cardboard/ui/CardBoardMenuTest.java 

# Instrument the classes we want coverage on.
java -cp ../resources/emma.jar emma instr -ip ./CardBoardMenu/classes/ -m overwrite -filter -*Map* -filter -*Preferences* -filter -*Test -out CardBoardMenu_Unit.em 

# Display the classes' information
cp junit.jar CardBoardMenu/classes/com/immortallabs/cardboard/ui

# Run the driver and save the result
java -classpath :../resources/emma.jar:./CardBoardMenu/classes/:../resources/junit.jar junit.textui.TestRunner com.immortallabs.cardboard.ui.CardBoardMenuTest
