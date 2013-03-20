#!/bin/bash
set -o verbose
rm -rf CardBoardPreferences/bin/*

javac -d CardBoardPreference/bin/ ../../src/com/immortallabs/cardboard/CardBoardPreferences.java

# Instrument the classes we want coverage on.
java -cp ../resources/emma.jar emma instr -ip CardBoardPreference/bin/ -m overwrite -out CardBoardPreferences_Unit.em -ix +com.immortallabs.cardboard.CardBoardPreferences*

# Compile the junit classes
javac -classpath :CardBoardPreference/bin/:../../lib/junit4.jar -d CardBoardPreference/bin/ CardBoardPreference/PrefUnitTest.java 

# Run the driver and save the result
java -classpath :../resources/emma.jar:CardBoardPreference/bin/:../../lib/junit4.jar org.junit.runner.JUnitCore unit.CardBoardPreference.PrefUnitTest
