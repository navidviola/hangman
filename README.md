# fh-campus-project-hangman

Welcome to our Hangman game :)

To stay alive and in order to not be hanged please read me carefully.

## Description

This project was a challenge for us to use the knowledge we have gained this semester.

### Dependencies

* For running this program you have to use an IDE like IntelliJ and have Java and Gradle installed.

### Installing

1- Downoload the program form the git repository as a zip file
2- Extract it on your computer 
3- Open the folder as a project on your prefered IDE. For exapmle in IntelliJ: By clicking on file > Open 

### Executing program

Playing Hangman is very easy:

- You have to guess the word that exists as a list in a text file.
- Run the program and in the console of IDE you can see a gallows! and a prompt that says "Enter a Letter:"
- Type a character as your guess. (This is not case sensitive)
- If your character is in the word, the code shows you where in the word it is and the wrong count and the gallows stay the same. If not the wrong count will increase and part of the body will be painted there under the gallows.
- Then you have to guess your next character.
- Again, the last procedure will be repeated. But this time you have the opportunity to guess the word. If you guess correctly you win! If not the program will ask you the next character you guess.

## Help

- There is a code line in line 31 which show the user what the guessing word is. You can comment it if you really want to run as a player: System.out.println(word);
- It is possible to customize the list of words in the package for users. Just go to resources in src and update file list.txt as you wish. 

## Version History

* 0.1
    * Initial Release
