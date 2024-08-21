package src.main.java;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {
    private static final String WORDS_FILENAME = "src/main/resources/russian_nouns.txt";
    private static final int MAX_ERRORS = 6;
    private final HangmanCLI gameCLI;
    private final ArrayList<String> listOfWords;
    private final HashSet<Character> enteredLetters = new HashSet<>();
    private int errors = 0;
    Game(HangmanCLI gameCLI){
        this.gameCLI = gameCLI;
        this.listOfWords = readWordsFile(WORDS_FILENAME);
    }

    public ArrayList <String> readWordsFile(String fileName){
        ArrayList<String> listOfWords = new ArrayList<>();
        try {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null)
                listOfWords.add(line);
        } catch (IOException e) {
            System.out.println("ERROR: File with words cannot be found or read");
            System.exit(-1);
        }
        return listOfWords;
    }

    public String chooseWord(ArrayList<String> listOfWords){
        int wordIndex = (int) (Math.random() * listOfWords.size());
        return listOfWords.get(wordIndex);
    }

    public void start(){
        String hiddenWord = chooseWord(listOfWords);
        errors = 0;
        gameCLI.hiddenWord = new StringBuilder("_".repeat(hiddenWord.length()));
        gameLoop(gameCLI, hiddenWord);
    }

    private void gameLoop(HangmanCLI gameCLI, String hiddenWord){
        while ((!hiddenWord.contentEquals(gameCLI.hiddenWord))
                && (errors != MAX_ERRORS)){
            gameCLI.printHangman(errors);
            gameCLI.printWordInformation(errors, enteredLetters);
            guessLetter(hiddenWord);
        }
        if (errors == MAX_ERRORS)
            gameCLI.printLoseMessage(errors, hiddenWord);
        else
            gameCLI.printVictoryMessage(errors);
        Scanner sc = new Scanner(System.in);
        sc.next();
    }

    private void guessLetter(String hiddenWord){
        Scanner sc = new Scanner(System.in);
        String guessLetter = sc.next().toLowerCase();
        while (true){
            if (guessLetter.length() != 1) {
                System.out.println("Enter only a letter");
            }
            else if (!Pattern.matches("[А-Яа-яЁё]",guessLetter)){
                System.out.println("The letter must be from russian alphabet");
            }
            else if (enteredLetters.contains(guessLetter.charAt(0))){
                System.out.println("This letter was entered before");
            }
            else break;
            guessLetter = sc.next().toLowerCase();
        }
        enteredLetters.add(guessLetter.charAt(0));
        if (!hiddenWord.contains(guessLetter)){
            errors++;
        }
        else {
            int index = hiddenWord.indexOf(guessLetter);
            while (index >= 0) {
                gameCLI.hiddenWord.setCharAt(index, guessLetter.charAt(0));
                index = hiddenWord.indexOf(guessLetter, index + 1);
            }
        }
    }
}
