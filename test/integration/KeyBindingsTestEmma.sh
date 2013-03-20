#!/bin/bash
mkdir ./KeyBindings/classes
set -o verbose

# Compile the real classes we are testing
javac -classpath ./KeyBindings/classes -d ./KeyBindings/classes ../../src/com/immortallabs/cardboard/ui/KeyBindings.java

# Compile the junit classes
javac -classpath ./KeyBindings/classes:./junit.jar -d ./KeyBindings/classes KeyBindings/com/immortallabs/cardboard/ui/KeyBindingsTest.java

# Run the driver and save the result
java -cp ../resources/emma.jar emma instr -ip ./KeyBindings/classes/ -m overwrite -filter +*KeyBindings -filter -KeyBindings* -out KeyBindings_Int.em

java -classpath :../resources/emma.jar:./KeyBindings/classes/:../resources/junit.jar junit.textui.TestRunner com.immortallabs.cardboard.ui.KeyBindingsTest

rm -rf ./KeyBindings/classes/*
rmdir ./KeyBindings/classes
