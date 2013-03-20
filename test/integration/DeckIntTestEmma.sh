#!/bin/bash
set -o verbose

#compile the class we depend on
javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/ -d Deck/classes ../../src/com/immortallabs/cardboard/game/Card.java
javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/ -d Deck/classes ../../src/com/immortallabs/cardboard/game/Deck.java

java -cp ../resources/emma.jar emma instr -ip ./Deck/classes/ -m overwrite -out Deck_Int.em


#compile the junit classes
javac -classpath Deck/classes/:./junit.jar -d Deck/classes Deck/src/DeckTest.java

#Run junit test
java -classpath :../resources/emma.jar:./Deck/classes/:../resources/junit.jar junit.textui.TestRunner com.immortallabs.cardboard.game.DeckTest
#java -classpath :./com/immortallabs/cardboard/game:./junit.jar:Deck/classes junit.textui.TestRunner com.immortallabs.cardboard.game.DeckTest

#Remove old class files
rm -rf ./Deck/classes/*
