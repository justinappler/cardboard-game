#!/bin/bash
set -o verbose
rm -rf GameState/bin/*

# Compile the fake classes
javac -d GameState/bin/ ../../src/com/immortallabs/cardboard/*.java ../../src/com/immortallabs/cardboard/game/*.java ../../src/com/immortallabs/cardboard/ui/*.java ../../src/edu/profdalbey/*.java

# Instrument the classes we want coverage on.
java -cp ../resources/emma.jar emma instr -ip ./GameState/bin/ -m overwrite -out SystemTest.em 

cd ../../

# Run the driver and save the result
java -classpath :test/resources/emma.jar:test/integration/GameState/bin/ com.immortallabs.cardboard.CardBoardApp -t

# Move the coverage
mv coverage.ec test/integration/sys_coverage.ec
