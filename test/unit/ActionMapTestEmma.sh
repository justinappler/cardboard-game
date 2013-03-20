#!/bin/bash
set -o verbose
rm -rf ActionMap/bin/*

# Compile the fake classes
javac -classpath :ActionMap/:ActionMap/fakes -d ActionMap/bin/ ActionMap/ActionMapTestData.java ActionMap/fake/*.java ../../src/com/immortallabs/cardboard/ui/ActionMap.java ../../src/edu/profdalbey/Natural.java

# Instrument the classes we want coverage on.
java -cp ../resources/emma.jar emma instr -ip ./ActionMap/bin/ -m overwrite -out ActionMap_Unit.em -ix +com.immortallabs.cardboard.ui.ActionMap

# Compile the junit classes
javac -classpath :ActionMap/bin/:../../lib/junit4.jar -d ActionMap/bin/ ActionMap/ActionMapTest.java 

# Run the driver and save the result
java -classpath :../resources/emma.jar:ActionMap/bin/:../../lib/junit4.jar org.junit.runner.JUnitCore unit.ActionMap.ActionMapTest
