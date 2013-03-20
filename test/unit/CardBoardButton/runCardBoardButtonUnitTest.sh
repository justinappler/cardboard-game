#!/bin/bash

mkdir classes
set -o verbose

#compile classes

javac -classpath ./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/Card.java

javac -classpath ./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/Deck.java

javac -classpath ./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/SetsBoard.java

javac -classpath ./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/Timer.java

javac -classpath ./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/ui/TimerGraphic.java

javac -classpath ./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/Score.java

javac -classpath ./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/ui/ScoresGraphic.java

javac -classpath ./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/CardBoardPreferences.java

javac -classpath ./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/ui/CardBoardUI.java

javac -classpath ./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/HighScores.java

javac -classpath ./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/game/SoundPlayer.java

javac -classpath ./classes:./naturalLib.jar -d classes com/immortallabs/cardboard/ui/ActionMap.java com/immortallabs/cardboard/ui/CardBoardButton.java com/immortallabs/cardboard/game/GameState.java com/immortallabs/cardboard/ui/GameWindow.java  com/immortallabs/cardboard/ui/CardGraphic.java com/immortallabs/cardboard/ui/CardBoardMenu.java

javac -classpath ./classes -d classes com/immortallabs/cardboard/ui/CardBoardButton.java

javac -classpath ./classes -d classes com/immortallabs/cardboard/ui/CardBoardButtonTester.java

javac -classpath ./classes -d classes com/immortallabs/cardboard/ui/CardBoardButtonTesterDriver.java

#Run the test 
java -classpath ./classes com.immortallabs.cardboard.ui.CardBoardButtonTesterDriver 

rm -rf classes/*
rmdir classes
