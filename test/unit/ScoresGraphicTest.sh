#!/bin/bash

mkdir ./ScoresGraphic/classes
set -o verbose

#compile classes
javac -classpath ./ScoresGraphic/classes -d ./ScoresGraphic/classes ./ScoresGraphic/com/immortallabs/cardboard/game/Score.java

javac -classpath ./ScoresGraphic/classes -d ./ScoresGraphic/classes ./ScoresGraphic/com/immortallabs/cardboard/game/GameState.java

javac -classpath ./ScoresGraphic/classes -d ./ScoresGraphic/classes ./ScoresGraphic/com/immortallabs/cardboard/ui/ScoresGraphic.java

javac -classpath ./ScoresGraphic/classes -d ./ScoresGraphic/classes ./ScoresGraphic/com/immortallabs/cardboard/ui/ScoresGraphicTester.java

javac -classpath ./ScoresGraphic/classes -d ./ScoresGraphic/classes ./ScoresGraphic/com/immortallabs/cardboard/ui/ScoresGraphicTesterDriver.java

#Run the test 
java -classpath ./ScoresGraphic/classes com.immortallabs.cardboard.ui.ScoresGraphicTesterDriver 

rm -rf ./ScoresGraphic/classes/*
rmdir ./ScoresGraphic/classes
