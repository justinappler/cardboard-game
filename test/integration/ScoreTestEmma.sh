#!/bin/bash
set -o verbose
mkdir Score/classes

# Compile the real classes we are testing
javac -classpath ./Score/classes -d Score/classes ../../src/com/immortallabs/cardboard/game/Score.java

# Compile the junit classes
javac -classpath ./Score/classes:./junit.jar -d Score/classes Score/src/com/immortallabs/cardboard/game/ScoreTest.java

# Display the classes' information
#cp junit.jar CardTest/classes/com/immortallabs/cardboard/game

# Change to proper directory
#cd ./CardTest/classes/

# Run the driver with EMMA and save the result
java -cp ../resources/emma.jar emma instr -ip ./Score/classes/ -m overwrite -filter +*Score -filter -Score* -out Score_Int.em

java -classpath :../resources/emma.jar:./Score/classes/:../resources/junit.jar junit.textui.TestRunner com.immortallabs.cardboard.game.ScoreTest

rm -rf Score/classes/*
rmdir Score/classes
