#!/bin/bash

mkdir classes
set -o verbose

#compile classes 
javac -classpath ./edu/prodalbey/:./images:./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/Card.java

javac -classpath ./images:./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/Deck.java

javac -classpath ./images:./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/SetsBoard.java

javac -classpath ./images:./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/Timer.java

javac -classpath ./images:./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/ui/TimerGraphic.java

javac -classpath ./images:./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/Score.java

javac -classpath ./images:./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/CardBoardMessage.java


javac -classpath ./images:./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/CardBoardPreferences.java


javac -classpath ./images:./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/ui/ActionMap.java com/immortallabs/cardboard/game/GameState.java com/immortallabs/cardboard/ui/GameWindow.java  com/immortallabs/cardboard/ui/CardGraphic.java com/immortallabs/cardboard/ui/CardBoardMenu.java com/immortallabs/cardboard/ui/GameWindowDriver.java com/immortallabs/cardboard/ui/ScoresGraphic.java com/immortallabs/cardboard/CardBoardResource.java com/immortallabs/cardboard/ui/CardBoardButton.java com/immortallabs/cardboard/ui/CardBoardUI.java


#Run the test 
java -classpath ./classes:./naturalLib.jar  com.immortallabs.cardboard.ui.GameWindowDriver > output.results

# Compare results to the oracle 
diff -wBb output.results GameWindow.oracle

rm -rf classes/*
rmdir classes