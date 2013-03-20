#!/bin/bash
mkdir classes
set -o verbose

# Compile the real classes we are testing
javac -classpath ./classes -d classes ../../../src/com/immortallabs/cardboard/game/Score.java

# Compile the junit classes
javac -classpath ./classes:./junit.jar -d classes com/immortallabs/cardboard/game/ScoreTest.java

# Display the classes' information
#cp junit.jar CardTest/classes/com/immortallabs/cardboard/game

# Change to proper directory
#cd ./CardTest/classes/

# Run the driver and save the result
java -classpath ./classes:./junit.jar  junit.textui.TestRunner com.immortallabs.cardboard.game.ScoreTest

rm -rf classes/*
rmdir classes
