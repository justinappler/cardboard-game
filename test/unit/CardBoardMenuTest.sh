#!/bin/bash
set -o verbose
rm -rf CardBoardMenu/classes/*

# Compile the real classes we are testing
javac -classpath ../../src/com/immortallabs/cardboard/ui:CardBoardMenu/src/ -d CardBoardMenu/classes/ ../../src/com/immortallabs/cardboard/ui/CardBoardMenu.java

# Compile the fake classes
javac -classpath :CardBoardMenu/classes/:CardBoardMenu/src -d CardBoardMenu/classes/ CardBoardMenu/src/com/immortallabs/cardboard/ui/ActionMap.java
javac -classpath :CardBoardMenu/classes/:CardBoardMenu/src -d CardBoardMenu/classes/ CardBoardMenu/src/com/immortallabs/cardboard/CardBoardPreferences.java


# Compile the junit classes
javac -classpath CardBoardMenu/classes/:./junit.jar -d CardBoardMenu/classes/ CardBoardMenu/src/com/immortallabs/cardboard/ui/CardBoardMenuTest.java 

# Display the classes' information
cp junit.jar CardBoardMenu/classes/com/immortallabs/cardboard/ui

# Change to proper directory
cd ./CardBoardMenu/classes/

# Run the driver and save the result
java -classpath :./com/immortallabs/cardboard/ui/:./com/immortallabs/cardboard/ui/junit.jar junit.textui.TestRunner com.immortallabs.cardboard.ui.CardBoardMenuTest

# Return to beginning directory
cd ../..
