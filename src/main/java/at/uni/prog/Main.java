package at.uni.prog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {


        System.out.println("===============================================================================");
        System.out.println("                             Welcome to Hangman !                              ");
        System.out.println("===============================================================================");
        System.out.println();
        System.out.println("* You are allowed to make six mistakes, after the sixth mistake you will lose *");
        System.out.println();


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

        // It will be used if we want to test the program
        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();



        // while the game is running, the loops and methods will be executed
        int wrongCount = 0;

        while (true) {
            printHangedMan(wrongCount);
            printWordState(word, playerGuesses);


            if (wrongCount >= 6) {
                System.out.println("You lose!");
                System.out.println("The word was: " + word);
                break;
            }


            if (!getPlayerGuess(guessing, word, playerGuesses)) {
                wrongCount++;
            }

            if (printWordState(word, playerGuesses)) {
                System.out.println("You win!");
                break;
            }

            if (wrongCount <= 5) {
                System.out.print("You have a chance to win the game, by entering the full word: ");

                if (guessing.nextLine().equalsIgnoreCase(word)) {
                    System.out.println("You win!");
                    break;
                } else {
                    System.out.println("Your guess for the full word was wrong, please try again!");
                    System.out.println();
                }
            }
        }

    }


    /**
     * @param guessing      : what the user enters.
     * @param word          : the word that will randomly select from the list of words
     * @param playerGuesses : the list of characters the player has guessed.
     * @author https://www.codepile.net/pile/2pn7ka1W
     */
    private static boolean getPlayerGuess(Scanner guessing, String word, List<Character> playerGuesses) {
        System.out.print("Enter a letter: ");

        String guessingLetter = guessing.nextLine();

        playerGuesses.add(guessingLetter.charAt(0));

        return word.contains(guessingLetter);
    }


    /**
     * @param word          : the word that will randomly select from the list of words.
     * @param playerGuesses : the list of characters the player has guessed.
     * @return determine if the count of guesses has reached or not.
     */
    public static boolean printWordState(String word, List<Character> playerGuesses) {
        // In order to ignore case sensitive differences
        List<Character> lowercasePlayerGuesses = new ArrayList<>();
        for (Character c : playerGuesses) {
            lowercasePlayerGuesses.add(Character.toLowerCase(c));
        }
        int countGuess = 0;
        for (int i = 0; i < word.length(); i++) {
            char lowerCaseExpectedChar = Character.toLowerCase(word.charAt(i));
            if (lowercasePlayerGuesses.contains(lowerCaseExpectedChar)) {
                System.out.print(word.charAt(i));
                countGuess++;
            } else {
                System.out.print("_");
            }

        }
        System.out.println();

        return (word.length() == countGuess);
    }

    // For every wrong Guess a part of the hangman will be printed.
    private static void printHangedMan(int wrongCount) {
        switch (wrongCount) {
            case 0:
                System.out.println(wrongCount + " mistakes currently !");
                System.out.println();
                System.out.println("     _____________");
                System.out.println("     |           |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("------------");


                break;

            case 1:
                System.out.println(wrongCount + " mistake currently !");
                System.out.println();
                System.out.println("     _____________");
                System.out.println("     |           |");
                System.out.println("     |           O");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("------------");

                break;

            case 2:
                System.out.println(wrongCount + " mistakes currently !");
                System.out.println();
                System.out.println("     _____________");
                System.out.println("     |           |");
                System.out.println("     |           O");
                System.out.println("     |           |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("------------");

                break;

            case 3:
                System.out.println(wrongCount + " mistakes currently !");
                System.out.println();
                System.out.println("     _____________");
                System.out.println("     |           |");
                System.out.println("     |           O");
                System.out.println("     |          \\| ");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("------------");

                break;

            case 4:
                System.out.println(wrongCount + " mistakes currently !");
                System.out.println();
                System.out.println("     _____________");
                System.out.println("     |           |");
                System.out.println("     |           O");
                System.out.println("     |          \\|/ ");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("------------");

                break;

            case 5:
                System.out.println(wrongCount + " mistakes currently! Attention!!! The next mistake will end the game.");
                System.out.println();
                System.out.println("     _____________");
                System.out.println("     |           |");
                System.out.println("     |           O");
                System.out.println("     |          \\|/ ");
                System.out.println("     |          /");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("------------");
                break;

            case 6:
                System.out.println("     _____________");
                System.out.println("     |           |");
                System.out.println("     |           O");
                System.out.println("     |          \\|/ ");
                System.out.println("     |          / \\");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("------------");
                break;


        }

    }
}
