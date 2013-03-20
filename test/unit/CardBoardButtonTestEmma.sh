#!/bin/bash

mkdir ./CardBoardButton/classes
set -o verbose

#compile classes
javac -classpath :CardBoardButton/classes/:CardBoardButton/. -d CardBoardButton/classes/ CardBoardButton/com/immortallabs/cardboard/ui/ActionMap.java

javac -classpath :CardBoardButton/classes/:CardBoardButton/. -d CardBoardButton/classes/ ../../src/com/immortallabs/cardboard/ui/CardBoardButton.java CardBoardButton/com/immortallabs/cardboard/ui/CardBoardResource.java

javac -classpath :CardBoardButton/classes/:CardBoardButton/. -d CardBoardButton/classes/ CardBoardButton/com/immortallabs/cardboard/ui/CardBoardButtonTester.java

javac -classpath :CardBoardButton/classes/:CardBoardButton/. -d CardBoardButton/classes/ CardBoardButton/com/immortallabs/cardboard/ui/CardBoardButtonTesterDriver.java


#Run the test
java -cp ../resources/emma.jar emma instr -ip ./CardBoardButton/classes/ -m overwrite -filter -*ActionMap* -filter -*CardBoardButtonTester* -filter -*CardBoardResource* -filter -CardBoardButton* -out CardBoardButton_Unit.em

java -classpath :../resources/emma.jar:./CardBoardButton/classes/ com/immortallabs/cardboard/ui/CardBoardButtonTesterDriver > CardBoardButton.results

diff -wb CardBoardButton.results CardBoardButton.oracle

rm CardBoardButton.results

rm -rf ./CardBoardButton/classes/*
rmdir ./CardBoardButton/classes
