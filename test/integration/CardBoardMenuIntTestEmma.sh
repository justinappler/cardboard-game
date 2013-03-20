#!/bin/bash
set -o verbose
rm -rf CardBoardMenu/classes/*

# Compile the real classes we are testing
javac -classpath ../resources/junit.jar -d CardBoardMenu/classes/ ../../src/com/immortallabs/cardboard/*.java ../../src/com/immortallabs/cardboard/game/*.java ../../src/com/immortallabs/cardboard/ui/*.java ../../src/edu/profdalbey/*.java CardBoardMenu/src/com/immortallabs/cardboard/ui/CardBoardMenuTest.java

# Instrument the classes we want coverage on.
java -cp ../resources/emma.jar emma instr -ip ./CardBoardMenu/classes/ -m overwrite -filter -*Test* -out CardBoardMenu_Int.em 

# Run the driver and save the result
java -classpath :../resources/emma.jar:./CardBoardMenu/classes/:../resources/junit.jar junit.textui.TestRunner com.immortallabs.cardboard.ui.CardBoardMenuTest

