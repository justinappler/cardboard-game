#!/bin/bash
set -o verbose

#compile classes
javac -classpath ../../src/com/immortallabs/cardboard:../../src/ -d CardBoardResource/classes ../../src/com/immortallabs/cardboard/CardBoardResource.java

java -cp ../resources/emma.jar emma instr -ip ./CardBoardResource/classes/ -m overwrite -out CardBoardResource_Int.em

#Compile tester classes
javac -classpath CardBoardResource/classes/:./junit.jar -d CardBoardResource/classes CardBoardResource/src/CardBoardResourceTester.java
javac -classpath CardBoardResource/classes/:./junit.jar -d CardBoardResource/classes CardBoardResource/src/CardBoardResourceTesterDriver.java
javac -classpath CardBoardResource/classes/:./junit.jar -d CardBoardResource/classes/ CardBoardResource/src/CardBoardResourcesSoundsTest.java

#Run the test
java -classpath :./com/immortallabs/cardboard/:../resources/emma.jar:./CardBoardResource/classes/:../resources/junit.jar junit.textui.TestRunner com.immortallabs.cardboard.CardBoardResourcesSoundsTest
#java -classpath :./com/immortallabs/cardboard/:./junit.jar:CardBoardResource/classes/ junit.textui.TestRunner com.immortallabs.cardboard.CardBoardResourcesSoundsTest

java -classpath :../resources/emma.jar:./CardBoardResource/classes/ com.immortallabs.cardboard.CardBoardResourceTesterDriver

# java -classpath ../../src/com/immortallabs/cardboard:CardBoardResource/classes com.immortallabs.cardboard.CardBoardResourceTesterDriver

rm -rf CardBoardResource/classes/*
