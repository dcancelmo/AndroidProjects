Daniel Cancelmo
dcancelm@u.rochester.edu
CSC 214 - Android Mobile App Development
Professor St Jacques
TA: Alan Beadle
Project 01
March 11, 2017
ReadMe File

I affirm that I did not give or receive any unauthorized help on this project, and that all work herein is my own.

Code description:
MainActivity is the launcher activity. Within the user can select names and which game to play. It also uses ScoreFragment to display a scoreboard with the names and scores of the two players. MainActivity has data persistence throughout the activity lifecycle.
ScoreFragment displays the current score and names of the players. It is used in every activity and is displayed at the top.
HotColdActivity is a number guessing game. The user guesses a number that has been selected and gets hints on how close the guess is to the actual value. The player with the fewer guesses wins with a scre of 100 times the guess difference. HotColdActivity has data persistence throughout the activity lifecycle.
HangmanActivity is a game of hangman where the two players will have to guess the same word so the phone is passed between. The player gets 8 guesses before the man is hung. The gallows and hanging man are drawn as the user guesses. Scoring works the same as with HotCold but instead of the difference of all guesses only the idfference of missed guesses.
Connect4Activity is a game of connect 4. This is done in a 6x6 grid with one additional row on top for buttons. The user presses this row of buttons (blue downward arrows) to select which column to drop their piece into. The game can recognize all possible win scenarios of 4 horisontal, vertical, or diagonal in any direction. The winner is awarded 1000 points.

The orientation is locked to portrait for HangmanActivity and Connect4Activity because of space limitations. Orientation is dynamic for MainActivity and HotColdActivity.

This app was developed for Android version 7.1.1 API 25 and texted on the Nexus 6 with 1440x2560 resolution and x86 CPU.

Extra credit:
I used fragments to implement the scoreboard across all activities. This can be seen by looking at the ScoreFragment.java and fragment_score.xml files.

I drew the actual gallows and hanging man for the hangman game. This can be seen in the HangmanActivity.java and activity_hangman.xml files as well as directly observed during the game.