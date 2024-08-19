package src.main.java;

public class HangmanCLI {


    public void printMainMenu(){
        System.out.println("HANGMAN");
        printHangman(6);
        System.out.println("To start the game press S");
        System.out.println("To exit the game press E");
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
            case 2:
            case 3:
            case 4:
            case 5:
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
