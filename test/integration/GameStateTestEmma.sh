#!/bin/bash
set -o verbose
rm -rf GameState/bin/*

# Compile the fake classes
javac -d GameState/bin/ ../../src/com/immortallabs/cardboard/*.java ../../src/com/immortallabs/cardboard/game/*.java ../../src/com/immortallabs/cardboard/ui/*.java ../../src/edu/profdalbey/*.java

# Instrument the classes we want coverage on.
java -cp ../resources/emma.jar emma instr -Dverbosity.level=silent -ip ./GameState/bin/ -m overwrite -out GameState_Int.em 

# Run the driver and save the result
java -classpath :../resources/emma.jar:GameState/bin/ com.immortallabs.cardboard.CardBoardApp -text -t < GameState/inputs.txt > GameState/result.txt

# Remove the last line of the result file
sed '$d' < GameState/result.txt > GameState/lastremoved.txt
mv GameState/lastremoved.txt GameState/result.txt

# Diff the oracle and the result
diff GameState/result.txt GameState/oracle.txt
