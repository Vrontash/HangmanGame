package src.main.java;
import java.util.HashSet;

public class HangmanCLI {
    public StringBuilder hiddenWord;
    public void printMainMenu(){
        System.out.println("HANGMAN");
        printHangman(6);
        System.out.println("To start the game press S");
        System.out.println("To exit the game press E");
    }
    public void printWordInformation(int errors, HashSet<Character> enteredLetters){
        System.out.println("Number of errors: " +  errors);
        System.out.println("Entered letters: " +  enteredLetters);
        System.out.println(hiddenWord);
    }
    public void printVictoryMessage(int errors){
        System.out.println("Congratulations!!! You've guessed the right word: " + hiddenWord.toString());
        System.out.println("You've made " + errors + " errors");
        System.out.println("Press any key to continue");
    }
    public void printLoseMessage(int errors){
        System.out.println("You've lost the game. The right word: " + hiddenWord.toString());
        System.out.println("You've made too many errors: " + errors);
        System.out.println("Press any key to continue");
    }
    public void printHangman(int errors){
        switch (errors){
            case 0:
                System.out.println("————————");
                System.out.println("|/");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                break;
            case 1:
                System.out.println("————————");
                System.out.println("|/     |");
                System.out.println("|      ()");
                System.out.println("|        ");
                System.out.println("|        ");
                System.out.println("|");
                break;
            case 2:
                System.out.println("————————");
                System.out.println("|/     |");
                System.out.println("|      ()");
                System.out.println("|      []");
                System.out.println("|        ");
                System.out.println("|");
                break;
            case 3:
                System.out.println("————————");
                System.out.println("|/     |");
                System.out.println("|      ()");
                System.out.println("|      []\\");
                System.out.println("|        ");
                System.out.println("|");
                break;
            case 4:
                System.out.println("————————");
                System.out.println("|/     |");
                System.out.println("|      ()");
                System.out.println("|     /[]\\");
                System.out.println("|        ");
                System.out.println("|");
            case 5:
                System.out.println("————————");
                System.out.println("|/     |");
                System.out.println("|      ()");
                System.out.println("|     /[]\\");
                System.out.println("|      |");
                System.out.println("|");
            case 6:
                System.out.println("————————");
                System.out.println("|/     |");
                System.out.println("|      ()");
                System.out.println("|     /[]\\");
                System.out.println("|      ||");
                System.out.println("|");
        }
    }

}
