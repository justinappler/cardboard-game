#!/bin/sh
#Michael Brooks

# Run unit Emma tests.
cd ./unit/

sh ActionMapTestEmma.sh

sh CardBoardButtonTestEmma.sh
sh CardBoardMenuTestEmma.sh
sh CardBoardPreferencesTest.sh

sh CardGraphicTest.sh

sh CardTestEmma.sh

sh GameStateTestEmma.sh

sh KeyBindingsTestEmma.sh

sh ScoresGraphicTestEmma.sh
sh ScoreTestEmma.sh

sh SetsBoardTestEmma.sh

sh TimerTestEmma.sh


# Run integration Emma tests.
cd ../integration

sh CardBoardButtonTestEmma.sh
sh CardBoardMenuIntTestEmma.sh
sh CardBoardPreferencesIntTestEmma.sh
sh PrefTestInt.sh
sh CardBoardResourceIntTestEmma.sh
sh CardTestEmma.sh

sh DeckIntTestEmma.sh

sh GameStateTestEmma.sh

sh KeyBindingsTestEmma.sh

sh ScoresGraphicTestEmma.sh
sh ScoreTestEmma.sh
sh SetsBoardTestEmma.sh

sh TextUIIntTestEmma.sh
sh TimerTestEmma.sh

# DONE. Running System Tester:




# Create the report.
cd ..
#sh mergeEmma.sh
