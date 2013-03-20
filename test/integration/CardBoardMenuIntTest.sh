#!/bin/bash
set -o verbose
rm -rf CardBoardMenu/classes/*

javac -classpath ../resources/junit.jar -d CardBoardMenu/classes/ ../../src/com/immortallabs/cardboard/*.java ../../src/com/immortallabs/cardboard/game/*.java ../../src/com/immortallabs/cardboard/ui/*.java ../../src/edu/profdalbey/*.java CardBoardMenu/src/com/immortallabs/cardboard/ui/CardBoardMenuTest.java

# Run the driver and save the result
java -classpath ./CardBoardMenu/classes:../../lib/junit4.jar junit.textui.TestRunner com.immortallabs.cardboard.ui.CardBoardMenuTest
