#!/bin/bash
#javac com/immortallabs/cardboard/TestCG.java
rm -rf com/immortallabs/cardboard/ui/CardGraphic.class
javac com/immortallabs/cardboard/TestCG.java
java -cp ../../resources/emma.jar emma instr -ip ./ -m overwrite -out CardGraphic_Unit.em -ix +com.immortallabs.cardboard.ui.CardGraphic*
#java com/immortallabs/cardboard/TestCG
java -classpath :../../resources/emma.jar com.immortallabs.cardboard.TestCG
