package at.uni.prog;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();

        Scanner scanner = new Scanner(new File("C:/Users/Ravin/Desktop/HangmanList.txt"));
        Scanner guessing= new Scanner(System.in);

        List<String> words = new ArrayList<>();


        while (scanner.hasNext()){
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

        printWordState(word, playerGuesses);

        while (true) {
            getPlayerGuess(guessing, word, playerGuesses);
            if(printWordState(word, playerGuesses)){
                System.out.println("You win!");
                break;
            }

        }

        }

        private static void getPlayerGuess(Scanner guessing, String word,List<Character> playerGuesses ){
            System.out.println("Enter a letter:");
            String guessingLetter = guessing.nextLine();
            playerGuesses.add(guessingLetter.charAt(0));


        }

    private static boolean printWordState(String word, List<Character> playerGuesses){
        int countGuess = 0;
        int falseGuess = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                countGuess++;
            } else {
                System.out.print("-");
                falseGuess++;
            }
        }
        System.out.println();

    return (word.length()==countGuess);
    }



}
