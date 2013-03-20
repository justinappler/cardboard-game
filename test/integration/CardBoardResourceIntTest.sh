#!/bin/bash
set -o verbose

#compile classes
javac -classpath ../../src/com/immortallabs/cardboard:../../src/ -d CardBoardResource/classes ../../src/com/immortallabs/cardboard/CardBoardResource.java

#Compile tester classes
javac -classpath CardBoardResource/classes/:./junit.jar -d CardBoardResource/classes CardBoardResource/src/CardBoardResourceTester.java
javac -classpath CardBoardResource/classes/:./junit.jar -d CardBoardResource/classes CardBoardResource/src/CardBoardResourceTesterDriver.java
javac -classpath CardBoardResource/classes/:./junit.jar -d CardBoardResource/classes/ CardBoardResource/src/CardBoardResourcesSoundsTest.java

#Run the test
java -classpath :./com/immortallabs/cardboard/:./junit.jar:CardBoardResource/classes/ junit.textui.TestRunner com.immortallabs.cardboard.CardBoardResourcesSoundsTest

java -classpath ../../src/com/immortallabs/cardboard:CardBoardResource/classes com.immortallabs.cardboard.CardBoardResourceTesterDriver

rm -rf CardBoardResource/classes/*
