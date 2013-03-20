#!/bin/bash
set -o verbose
rm -rf GameState/bin/*

# Compile the fake classes
javac -classpath :GameState/:GameState/fakes -d GameState/bin/ GameState/TestMonitor.java GameState/FakeUI.java GameState/fake/*.java ../../src/com/immortallabs/cardboard/game/GameState.java ../../src/edu/profdalbey/Natural.java

# Instrument the classes we want coverage on.
java -cp ../resources/emma.jar emma instr -ip ./GameState/bin/ -m overwrite -out GameState_Unit.em -ix +com.immortallabs.cardboard.game.GameState

# Compile the junit classes
javac -classpath :GameState/bin/:../../lib/junit4.jar -d GameState/bin/ GameState/GameStateTest.java 

# Run the driver and save the result
java -classpath :../resources/emma.jar:GameState/bin/:../../lib/junit4.jar org.junit.runner.JUnitCore unit.GameState.GameStateTest
