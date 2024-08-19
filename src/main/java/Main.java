package src.main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HangmanCLI gameCLI = new HangmanCLI();
        Scanner sc = new Scanner(System.in);
        while (true) {
            gameCLI.printMainMenu();
            String inAction = sc.next();
            while (inAction.length() != 1) {
                System.out.println("Enter only a letter");
                inAction = sc.next();
            }
            switch (inAction){
                case "S":
                    Game game = new Game(gameCLI);
                    game.start();
                    break;
                case "E":
                    System.exit(0);
            }
        }

    }
}
