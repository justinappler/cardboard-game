#!/bin/bash
set -o verbose
rm -rf SetsBoard/bin/*

# Compile the fake classes
javac -classpath :SetsBoard/:SetsBoard/bin/ -d SetsBoard/bin/ ../../src/com/immortallabs/cardboard/game/SetsBoard.java  ./SetsBoard/fake/*.java ../../src/edu/profdalbey/Natural.java

# Instrument the classes we want coverage on.
java -cp ../resources/emma.jar emma instr -ip ./SetsBoard/bin/ -m overwrite -out SetsBoard_Unit.em -ix +com.immortallabs.cardboard.game.SetsBoard* -filter -*Deck -filter -*Card*

# Compile the junit classes
javac -classpath :SetsBoard/bin/:../../lib/junit4.jar -d SetsBoard/bin/ SetsBoard/SetsBoardTest.java 

# Run the driver and save the result
java -classpath :../resources/emma.jar:SetsBoard/bin/:../../lib/junit4.jar org.junit.runner.JUnitCore unit.SetsBoard.SetsBoardTest
