package src.main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HangmanCLI gameCLI = new HangmanCLI();
        Scanner sc = new Scanner(System.in);
        while (true) {
            gameCLI.printMainMenu();
            String inAction = sc.next().toLowerCase();
            while (inAction.length() != 1) {
                System.out.println("Enter only a letter");
                inAction = sc.next().toLowerCase();
            }
            switch (inAction){
                case "s":
                    Game game = new Game(gameCLI);
                    game.start();
                    break;
                case "e":
                    System.exit(0);
            }
        }

    }
}
