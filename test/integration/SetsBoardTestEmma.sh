#!/bin/bash
set -o verbose
rm -rf SetsBoard/bin/*

# Compile the fake classes
javac -classpath :SetsBoard/ -d SetsBoard/bin/ ../../src/com/immortallabs/cardboard/game/SetsBoard.java ../../src/com/immortallabs/cardboard/game/Card.java ../../src/com/immortallabs/cardboard/game/Deck.java ../../src/edu/profdalbey/Natural.java

# Instrument the classes we want coverage on.
java -cp ../resources/emma.jar emma instr -ip ./SetsBoard/bin/ -m overwrite -out SetsBoard_Int.em -ix -edu.profdalbey.Nat*

# Compile the junit classes
javac -classpath :SetsBoard/bin/:../../lib/junit4.jar -d SetsBoard/bin/ SetsBoard/SetsBoardTestInt.java 

# Run the driver and save the result
java -classpath :../resources/emma.jar:SetsBoard/bin/:../../lib/junit4.jar junit.textui.TestRunner integration.SetsBoard.SetsBoardTestInt
