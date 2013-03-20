#!/bin/bash
set -o verbose
rm -rf Timer/bin/*

# Compile the fake classes
javac -classpath :Timer/ -d Timer/bin/ ../../src/com/immortallabs/cardboard/game/Timer.java ../../src/edu/profdalbey/Natural.java

# Instrument the classes we want coverage on.
java -cp ../resources/emma.jar emma instr -ip ./Timer/bin/ -m overwrite -out Timer_Int.em -ix +com.immortallabs.cardboard.game.Timer*

# Compile the junit classes
javac -classpath :Timer/bin/:../../lib/junit4.jar -d Timer/bin/ Timer/TimerTest.java 

# Run the driver and save the result
java -classpath :../resources/emma.jar:Timer/bin/:../../lib/junit4.jar org.junit.runner.JUnitCore integration.Timer.TimerTest
