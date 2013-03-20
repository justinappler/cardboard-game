#!/bin/bash
mkdir CardBoardButton/classes
mkdir CardBoardButton/classes/images

cp ../../images/explain.jpg CardBoardButton/classes/images/explain.jpg
cp ../../images/hint.jpg CardBoardButton/classes/images/hint.jpg
cp ../../images/ok.jpg CardBoardButton/classes/images/ok.jpg
cp ../../images/pause.jpg CardBoardButton/classes/images/pause.jpg
cp ../../images/resume.jpg CardBoardButton/classes/images/resume.jpg
cp ../../images/start.jpg CardBoardButton/classes/images/start.jpg
cp ../../images/threeMore.jpg CardBoardButton/classes/images/threeMore.jpg


set -o verbose

#compile the real classes we need
javac -d CardBoardButton/classes/ ../../src/com/immortallabs/cardboard/*.java ../../src/com/immortallabs/cardboard/game/*.java ../../src/com/immortallabs/cardboard/ui/*.java ../../src/edu/profdalbey/*.java

#complie the test class's drivers
javac -classpath ./CardBoardButton/classes:./CardBoardButton/naturalLib.jar -d CardBoardButton/classes CardBoardButton/src/com/immortallabs/cardboard/ui/CardBoardButtonTester.java

javac -classpath ./CardBoardButton/classes:./CardBoardButton/naturalLib.jar -d CardBoardButton/classes CardBoardButton/src/com/immortallabs/cardboard/ui/CardBoardButtonTesterDriver.java

#Run the test 
java -classpath ./CardBoardButton/classes com.immortallabs.cardboard.ui.CardBoardButtonTesterDriver > CardBoardButton.results

diff CardBoardButton.results CardBoardButton.oracle

rm -rf  CardBoardButton/classes/*
