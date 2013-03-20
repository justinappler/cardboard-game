#!/bin/bash
set -o verbose

# Compile the fake classes
javac -classpath :Deck/:Deck/fakes -d Deck/classes/ Deck/fakes/*.java ../../src/edu/profdalbey/Natural.java

#compile the class we depend on
javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/ -d Deck/classes ../../src/com/immortallabs/cardboard/game/Deck.java

#compile the junit classes
javac -classpath Deck/classes/:./junit.jar -d Deck/classes Deck/src/DeckTest.java

#Run junit test
java -classpath :./com/immortallabs/cardboard/game:./junit.jar:Deck/classes junit.textui.TestRunner com.immortallabs.cardboard.game.DeckTest

#Remove old class files
rm -rf ./Deck/classes/*
