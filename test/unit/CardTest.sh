#!/bin/bash
set -o verbose
rm -rf Card/classes/*

# Compile the real classes we are testing
javac -d Card/classes/ ../../src/com/immortallabs/cardboard/game/Card.java

# Compile the junit classes
javac -classpath :Card/classes/:../../lib/junit4.jar:Card/classes/com/immortallabs/cardboard/game/: -d Card/classes/ Card/src/CardTest.java 

# Run the driver and save the result
java -classpath :Card/classes:../../lib/junit4.jar junit.textui.TestRunner unit.CardTest.CardTest
