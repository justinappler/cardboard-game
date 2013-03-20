#!/bin/bash
mkdir ScoresGraphic/classes
set -o verbose

#compile the classses we depend op
javac -classpath ./ScoresGraphic/classes -d ./ScoresGraphic/classes ./ScoresGraphic/com/immortallabs/cardboard/game/Score.java

javac -classpath ./ScoresGraphic/classes -d ./ScoresGraphic/classes ./ScoresGraphic/com/immortallabs/cardboard/game/GameState.java

#compile the class to be tested
javac -classpath ./ScoresGraphic/classes -d ./ScoresGraphic/classes ../../src/com/immortallabs/cardboard/ui/ScoresGraphic.java

#compile the driver classes
javac -classpath ./ScoresGraphic/classes -d ./ScoresGraphic/classes ./ScoresGraphic/com/immortallabs/cardboard/ui/ScoresGraphicTester.java

javac -classpath ./ScoresGraphic/classes -d ./ScoresGraphic/classes ./ScoresGraphic/com/immortallabs/cardboard/ui/ScoresGraphicTesterDriver.java


#Run the test with EMMA
java -cp ../resources/emma.jar emma instr -ip ./ScoresGraphic/classes/ -m overwrite -filter -*GameState* -filter -*Tester* -filter -*Score -filter -*Tester* -out ScoresGraphic_Unit.em

java -classpath :../resources/emma.jar:./ScoresGraphic/classes/ com/immortallabs/cardboard/ui/ScoresGraphicTesterDriver 


rm -rf ScoresGraphic/classes/*
rmdir ScoresGraphic/classes
