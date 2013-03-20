#!/bin/bash

mkdir classes
set -o verbose

#compile classes
javac -classpath ./classes -d classes com/immortallabs/cardboard/game/Score.java

javac -classpath ./classes -d classes com/immortallabs/cardboard/game/GameState.java

javac -classpath ./classes -d classes com/immortallabs/cardboard/ui/ScoresGraphic.java

javac -classpath ./classes -d classes com/immortallabs/cardboard/ui/ScoresGraphicTester.java

javac -classpath ./classes -d classes com/immortallabs/cardboard/ui/ScoresGraphicTesterDriver.java

#Run the test 
java -classpath ./classes com.immortallabs.cardboard.ui.ScoresGraphicTesterDriver 

rm -rf classes/*
rmdir classes
