package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        while (gameEnd) {
            // Yep I made a array
            String[] alphabet  = "abcde".split("");
            int randomEnd = (int) (Math.random() * (alphabet.length - 3) + 3);
            gameGUI.createBoard(randomEnd, true);
            String[] gameStringArr = new String[randomEnd];
            for(int i =0; i < randomEnd; i++){
                   gameStringArr[i] = alphabet[i];

            }

            // Yep this is when I use Permutation.
            String[] randomStringArray = randomPermutation.makeRandomStringArray(gameStringArr);

            double randomDelay =  (Math.random() * (1 - 0.5) + 0.5);

            // Then the random string array get loaded
            String userGuess = gameGUI.playSequence(randomStringArray, randomDelay);
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