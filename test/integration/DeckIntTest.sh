#!/bin/bash
set -o verbose

#compile the class we depend on
javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/ -d Deck/classes ../../src/com/immortallabs/cardboard/game/Card.java
javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/ -d Deck/classes ../../src/com/immortallabs/cardboard/game/Deck.java

#compile the junit classes
javac -classpath Deck/classes/:./junit.jar -d Deck/classes Deck/src/DeckTest.java

#Change to proper directory
#cd ./Deck/classes/

#Run junit test
java -classpath :./com/immortallabs/cardboard/game:./junit.jar:Deck/classes junit.textui.TestRunner com.immortallabs.cardboard.game.DeckTest

#Remove old class files
rm -rf ./Deck/classes/*
