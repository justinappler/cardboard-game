#!/bin/bash
#author Michael Brooks

sh CardBoardButtonTest.sh
echo ================================================================================
sh CardBoardMenuIntTest.sh
echo ================================================================================
sh CardBoardResourceIntTest.sh
echo ================================================================================
sh CardTest.sh
echo ================================================================================
sh DeckIntTest.sh
echo ================================================================================
ant -f GameStateTest.xml
echo ================================================================================
sh KeyBindingsIntTest.sh
echo ================================================================================
sh PrefTestInt.sh
echo ================================================================================
sh ScoresGraphicTest.sh
echo ================================================================================
sh ScoreTest.sh
echo ================================================================================
ant -f SetsBoardIntTest.xml
echo ================================================================================
sh TextUIIntTest.sh
echo ================================================================================
ant -f TimerTest.xml
echo ================================================================================
