#!/bin/bash
set -o verbose
rm -rf Card/bin/*

# Compile the real classes we are testing
javac -d Card/classes/ ../../src/com/immortallabs/cardboard/game/Card.java

# Compile the junit classes
javac -classpath :Card/classes/:../../lib/junit4.jar:Card/classes/com/immortallabs/cardboard/game/: -d Card/classes/ Card/src/CardTest.java 

# Instrument the files to use Emma.
java -cp ../resources/emma.jar emma instr -ip ./Card/classes/ -m overwrite -filter -*Test* -out Card_Unit.em

# Run the JUnit test
java -classpath :../resources/emma.jar::Card/classes:../../lib/junit4.jar junit.textui.TestRunner unit.CardTest.CardTest

