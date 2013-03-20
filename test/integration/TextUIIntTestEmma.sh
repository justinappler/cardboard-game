#!/bin/bash
set -o verbose

#compile the class we depend on
javac -classpath ./TextUI/classes:../../src/com/immortallabs/cardboard:../../src/:./edu/profdalbey -d ./TextUI/classes ../../src/com/immortallabs/cardboard/CardBoardApp.java
java -cp ../resources/emma.jar emma instr -ip ./TextUI/classes/ -m overwrite -out TextUI_Int.em

#Run keystrokes through program
java -classpath :./com/immortallabs/cardboard/game:TextUI/classes:../resources/emma.jar com.immortallabs.cardboard.CardBoardApp -t -text < TextUI/src/TextUI1.keystrokes > TextUI/src/TextUI1.results
java -classpath :./com/immortallabs/cardboard/game:TextUI/classes:../resources/emma.jar com.immortallabs.cardboard.CardBoardApp -t -text < TextUI/src/TextUI2.keystrokes > TextUI/src/TextUI2.results

rm -rf ./TextUI/classes/*
