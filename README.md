The Cardboard Game
=========

The Cardboard game was a project by myself and the following other students at Cal Poly, San Luis Obispo
*I'm sure these guys will be thrilled to take credit for this code :)*

  - Nikhil Kowshik
  - Mike Brooks
  - Kyle Williamson
  - Lamont Samuels
  - Thomas Dvornik (@amphro)
  - Brad Barrows (@bbarrows)
  - Ryan Lange


Project Overview
=========
*Please remember this was a class project*

The Design of the Immortal Labs CardBoard Game can be divided into two distinct parts, the Internal State and the External Display.

Internal State
-------

The Internal State is managed by the Logic class which 'delegates intelligence' to a set of classes that model the game while maintaining adherence to the rules. These classes include SetsBoard, Timer, SoundPlayer, Timer, HighScore, Deck, Score, and the interface CardBoardUI. Each of these classes handles the various tasks and data elements necessary to run that specific component, such that the logic relies almost entirely on them to run the game. This, in effect, creates a modularized set of logical units each of which can be tested individually. In addition, all of the logic for the game remains completely separate from any display code so that the eventual interface is interchangeable.

Internal State Classes
-------
**Card**
The Card class contains all the necessary information to represent a Cardboard game card. It contains enumerations and "getter" methods for each attribute of the card.
**Score**
The Score class models each players score. A score is a non-negative integer that can be increased or decreased based on game play. There are 3 cases that effect the score of a player. The score increases if player gets a correct set, the score decreases if the player gets an incorrect set, and the score decreases if the player runs out of time.
**SetsBoard**
The SetsBoard class maintains the state of the game board by keeping track of what Cards are in the inlay and what Cards are on the game board. Also the SetsBoard class determines what is a set and can return information about the game board.
**Logic**
The Logic class maintains the state of a Sets game, abiding by the various rules and restrictions. The logic also processes the actions made by the user and updates the state to reflect those actions.
**CardBoardUI**
The CardBoardUI class is an interface that must implemented by all user interfaces for the Cardboard Sets Game.
**Timer**
Counts the number of seconds that have passed continuously. Timer also will handle counting down a specified number of seconds and can have a concurrent buzz-in count down timer.
**Deck**
Represents a stack of CardBoard cards in a random order. You can deal card off the deck and ask the deck if it's empty.
**HighScore**
Models a high score list and can have up to 10 High Scores each of which has a score value and a name associated with it. When a High Score is added to a full list, the lowest score is dropped from the list.
**SoundPlayer**
Loads and plays sound files. SoundPlayer will play four different types of sounds depending on what is currently happening in the game.
**CardBoardPreferences**
The CardBoardPreferences maintains the current game preferences and key bindings. It allows the preferences and key bindings change during a game and persist the values so they will be saved for future games.

External Display
-------
The External Display consists of all the classes that take part in displaying information about the game state. The division of labor and the 'main loop' occur in the GameWindow class, which handles the creation of the game window itself, as well as places the individual graphic components, each of which handles their own drawing.

Internal State Classes
-------
**CardGraphic**
The CardGraphic class is used to draw the Cardboard game cards in the GameWindow. It does this by extending Component and overwriting the paint method. This class also contains methods to animate and scale the cards appropriately.
**Button**
The Button class is used to draw one of the three Cardboard game buttons in the GameWindow. The type of button to be created is defined in the Button constructor using the ButtonType enumeration.
**HighScoreWindow**
The HighScoreWindow class creates a window that lists the top ten highest scores. This class retrieves the scores from an instance of the HighScore class.
**ScoreGraphic**
The ScoresGraphic class displays the information of all the player's Score's in a graphical display. It uses the Score class to get the information about the score and then displays it.
**TimerGraphic**
The TimerGraphic class graphically displays the information from a Timer class.
**GameWindow**
Displays the state of the CardBoard game in a single window.
**GameBoardMenu**
The Menu class instantiates a menu for the game window to use. The menu includes new games, preferences, and key bindings.
**KeyBindings**
The KeyBindings class models all key binding for the game. If a player changes any key bindings, the class persist it to retain the information for future games.
**KeyBindingsWindow**
The KeyBindingsWindow class models a window for a user to change all key binding for the game.

Other Classes
-------
While nearly all classes are responsible for either controlling or displaying the Game State, there are 2 classes that intentionally fall into neither category. The first is the CardBoardApp which creates both the GameWindow and the Logic classes. The second is the ActionMap class, which maps button presses and mouse clicks to various Logic and GameWindow actions. This creates a filter between the User and the internal workings of the software so that less interpretation work is done by the Logic and GameWindow class and no code is duplicated in both of the aforementioned classes.

Class Interactions
-------
The most interesting class interactions occur between ActionMap, GameWindow, Logic, and CardGraphic class. As seen in the diagram below a mouse click on a card graphic is handled by the ActionMap class. ActionMap then retrieves the source of this click, a CardGraphic class, and passes this to the GameWindow class. GameWindow then tells the CardGraphic class to begin its animation process. This animation is handled on its own thread. Once this is done, CardGraphic calls ActionMap's cardClicked with the CardGraphic. This is done so that the state of the game is not corrupted by the animation and the Logic class never has to worry about the intermediate state of animation, a construct purely of the UI. ActionMap then tells the GameWindow to set the card graphic as selected and tells the Logic a card has been chosen which then asks the GameWindow class for the selected card.

  

    
