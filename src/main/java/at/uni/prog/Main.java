package at.uni.prog;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        // give file as a list of words from resources directory
        File file = new File(
                Main.class.getClassLoader().getResource("list.txt").getFile());
        Scanner scanner = new Scanner(file);
        // give input of the player
        Scanner guessing = new Scanner(System.in);
        // create a list of words
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }

        Random rand = new Random();

        String word = words.get(rand.nextInt(words.size()));

        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();
        printWordState(word, playerGuesses);

        System.out.println("Enter a letter:");
        String guessingLetter = guessing.nextLine();
        playerGuesses.add(guessingLetter.charAt(0));


        Integer wrongCount = 0;

        while (true) {

            printHangedMan(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("You lose!");
                System.out.println("The word was: " + word);
                break;
            }

            printWordState(word, playerGuesses);
            if (!getPlayerGuess(guessing, word, playerGuesses)) {
                wrongCount++;
            }

            if (printWordState(word, playerGuesses)) {
                System.out.println("You win!");
                break;
            }
            System.out.println("Please enter your guess for the word:");
            if (guessing.nextLine().equals(word)) {
                System.out.println("You win!");
                break;
            } else {
                System.out.println("Wrong guess, please try again!");
            }
        }

    }

    /**
     * @param guessing      : what the user enters.
     * @param word          : the word that will randomly select from the list of words
     * @param playerGuesses : the list of characters the player has guessed.
     */
    private static boolean getPlayerGuess(Scanner guessing, String word, List<Character> playerGuesses) {
        System.out.println("Enter a letter:");
        String guessingLetter = guessing.nextLine();
        playerGuesses.add(guessingLetter.charAt(0));

        return word.contains(guessingLetter);
    }

    /**
     * @param word          : the word that will randomly select from the list of words.
     * @param playerGuesses : the list of characters the player has guessed.
     * @return determine if the count of guesses has reached or not.
     */
    private static boolean printWordState(String word, List<Character> playerGuesses) {
        // In order to ignore case sensitive differences
        List<Character> lowercasePlayerGuesses = new ArrayList<>();
        for (Character c : playerGuesses) {
            lowercasePlayerGuesses.add(Character.toLowerCase(c));
        }
        int countGuess = 0;
        int falseGuess = 0;
        for (int i = 0; i < word.length(); i++) {
            char lowerCaseExpectedChar = Character.toLowerCase(word.charAt(i));
            if (lowercasePlayerGuesses.contains(lowerCaseExpectedChar)) {
                System.out.print(word.charAt(i));
                countGuess++;
            } else {
                System.out.print("_");
                falseGuess++;

            }

        }
        System.out.println();

        return (word.length() == countGuess);
    }

    private static void printHangedMan(Integer wrongCount) {
        System.out.println(" -------");
        System.out.println(" |     |");
        if (wrongCount >= 1) {
            System.out.println(" O");
        }

        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }

        if (wrongCount >= 4) {
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.print("/ ");
            if (wrongCount >= 6) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");
    }
}
