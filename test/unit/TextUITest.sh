#!/bin/bash
set -o verbose

#compile the class we depend on
javac -classpath ./TextUI/:TextUI/fakes -d TextUI/classes ./TextUI/fakes/*.java ./TextUI/fakes/CardBoardApp.java ../../src/com/immortallabs/cardboard/ui/TextUI.java ../../src/edu/profdalbey/Natural.java
#javac -classpath ./TextUI/classes:TextUI/fakes:./edu/profdalbey -d ./TextUI/classes ./TextUI/fakes/CardBoardApp.java

#Run keystrokes through program
java -classpath ./TextUI/classes com.immortallabs.cardboard.CardBoardApp -t -text < TextUI/src/TextUI1.keystrokes > TextUI/src/TextUI1.results
java -classpath ./TextUI/classes com.immortallabs.cardboard.CardBoardApp -t -text < TextUI/src/TextUI2.keystrokes > TextUI/src/TextUI2.results

#Compare results and oracles
diff -wBb ./TextUI/src/TextUI1.results ./TextUI/src/TextUI1.oracle
diff -wBb ./TextUI/src/TextUI2.results ./TextUI/src/TextUI2.oracle

rm -rf ./TextUI/classes/*
