rm -rf ./coverage/*

java -classpath ./resources/emma.jar emma report -r html -properties=emmaconfig.txt -in ./integration/CardBoardButton_Int.em -in ./integration/CardBoardMenu_Int.em -in ./integration/CardBoardResource_Int.em -in ./integration/Card_Int.em -in ./integration/Deck_Int.em -in ./integration/GameState_Int.em -in ./integration/KeyBindings_Int.em -in ./integration/Score_Int.em -in ./integration/ScoresGraphic_Int.em -in ./integration/SetsBoard_Int.em -in ./integration/TextUI_Int.em -in ./integration/Timer_Int.em -in ./integration/coverage.ec -in ./unit/ActionMap_Unit.em -in ./unit/CardBoardButton_Unit.em -in ./unit/CardBoardMenu_Unit.em -in ./unit/Card_Unit.em -in ./unit/GameState_Unit.em -in ./unit/KeyBindings_Unit.em -in ./unit/ScoresGraphic_Unit.em -in ./unit/Score_Unit.em -in ./unit/SetsBoard_Unit.em -in ./unit/Timer_Unit.em -in ./unit/coverage.ec -in ./integration/sys_coverage.ec -in ./integration/SystemTest.em -sp ../src/

cp -r coverage $HOME/www/ImmortalLabs/
chmod -R og+rx    $HOME/www/ImmortalLabs/coverage
