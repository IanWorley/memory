package com.company;

/**
 * Project 3.6.5
 * By Ian W Worley
 *  
 */


public class MemoryGame {
    public static void main(String[] args) {
        // count score
        int score = 0;
        // round count
        int round = 0;
        // Create an object call random permutation
        RandomPermutation randomPermutation = new RandomPermutation();
        // Create a object gameGui
        MemoryGameGUI gameGUI = new MemoryGameGUI();
        // init var called gameEnd set it to true not my fault stupid PLTW and there dumb class.
        boolean gameEnd = true;
        // YEP I made board look at me Mom.
        gameGUI.createBoard(3, true);
        while (gameEnd) {
            // Yep I made a array
            String[] memoryString = {"a", "b", "c"};
            // Yep this is when I use Permutation.
            String[] randomStringArray = randomPermutation.makeRandomStringArray(memoryString);
            // Then the random string array get loaded
            String userGuess = gameGUI.playSequence(randomStringArray, 0.5);
            // I hate String Builder oh well it does job to add strings together with a for loop.
            StringBuilder k = new StringBuilder(new String(""));
            for (String s : randomStringArray) {
                k.append(s);
            }
            // This counts round.
            round++;
            // This checks if the player won a round
            if (!userGuess.equals(k.toString())) {
                // Gives tryAgain screen
                gameGUI.tryAgain();
            } else {

                // Sends congrats to screen
                gameGUI.matched();
                // well we have to give the point to user
                score++;
                // ask the user do they want to play again
                gameEnd = gameGUI.playAgain();
            }



        }
        // Show score
        gameGUI.showScore(score, round);
        // game Quits
        gameGUI.quit();

    }
}