#!/bin/bash
mkdir ScoresGraphic/classes
set -o verbose

#compile the class we depend on
javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/com/immortallabs/cardboard/ui:./ScoresGraphic/classes:./CardBoardMenu/naturalLib.jar -d ScoresGraphic/classes ../../src/com/immortallabs/cardboard/game/Card.java

javac -classpath ../../src/edu/profdalbey -d ScoresGraphic/classes ../../src/edu/profdalbey/Natural.java

javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/com/immortallabs/cardboard/ui:./ScoresGraphic/classes:./CardBoardMenu/naturalLib.jar -d ScoresGraphic/classes ../../src/com/immortallabs/cardboard/game/Deck.java

javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/com/immortallabs/cardboard/ui:./ScoresGraphic/classes:./CardBoardMenu/naturalLib.jar -d ScoresGraphic/classes ../../src/com/immortallabs/cardboard/game/SetsBoard.java

javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/com/immortallabs/cardboard/ui:./ScoresGraphic/classes:./CardBoardMenu/naturalLib.jar -d ScoresGraphic/classes ../../src/com/immortallabs/cardboard/game/Timer.java

javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/com/immortallabs/cardboard/ui:./ScoresGraphic/classes:./CardBoardMenu/naturalLib.jar -d ScoresGraphic/classes ../../src/com/immortallabs/cardboard/ui/TimerGraphic.java

javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/com/immortallabs/cardboard/ui:./ScoresGraphic/classes:./CardBoardMenu/naturalLib.jar -d ScoresGraphic/classes ../../src/com/immortallabs/cardboard/game/Score.java

javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/com/immortallabs/cardboard/ui:./ScoresGraphic/classes:./CardBoardMenu/naturalLib.jar -d ScoresGraphic/classes ../../src/com/immortallabs/cardboard/CardBoardPreferences.java

javac -classpath ../../src/com/immortallabs/cardboard/game:../../src/com/immortallabs/cardboard/ui:./ScoresGraphic/classes:./CardBoardMenu/naturalLib.jar -d ScoresGraphic/classes ../../src/com/immortallabs/cardboard/game/HighScores.java

javac -classpath  ScoresGraphic/classes/:./junit.jar:../../src/com/immortallabs/cardboard/game:../../src/com/immortallabs/cardboard/ui:./ScoresGraphic/classes:./../../lib/naturalLib.jar:./ScoresGraphic/src/com/immortallabs/cardboard/ui -d ScoresGraphic/classes ../../src/com/immortallabs/cardboard/ui/ScoresGraphic.java ../../src/com/immortallabs/cardboard/ui/KeyBindings.java ../../src/com/immortallabs/cardboard/ui/CardBoardUI.java ../../src/com/immortallabs/cardboard/game/GameState.java ../../src/com/immortallabs/cardboard/game/SoundPlayer.java ../../src/com/immortallabs/cardboard/CardBoardResource.java ../../src/com/immortallabs/cardboard/ui/CardBoardButton.java ../../src/com/immortallabs/cardboard/ui/GameWindow.java ../../src/com/immortallabs/cardboard/ui/ActionMap.java ../../src/com/immortallabs/cardboard/ui/CardGraphic.java ../../src/com/immortallabs/cardboard/ui/CardBoardMenu.java ../../src/com/immortallabs/cardboard/game/CardBoardMessage.java

#comple the test class's drivers
javac -classpath ./ScoresGraphic/classes -d ScoresGraphic/classes ScoresGraphic/src/com/immortallabs/cardboard/ui/ScoresGraphicTester.java
javac -classpath ./ScoresGraphic/classes -d ScoresGraphic/classes ScoresGraphic/src/com/immortallabs/cardboard/ui/ScoresGraphicTesterDriver.java

#Run the test with EMMA
java -cp ../resources/emma.jar emma instr -ip ./ScoresGraphic/classes/ -m overwrite -filter -*ScoreGraphicTester -filter -*ScoresGraphicTesterDriver -out ScoresGraphic_Int.em

java -classpath :../resources/emma.jar:./ScoresGraphic/classes/ com/immortallabs/cardboard/ui/ScoresGraphicTesterDriver 


rm -rf ScoresGraphic/classes/*
rmdir ScoresGraphic/classes
