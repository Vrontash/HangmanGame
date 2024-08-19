package src.main.java;
import java.io.*;

import java.util.ArrayList;


public class Game {
    private final String WORDS_FILENAME = "src/main/resources/russian_nouns.txt";
    private final HangmanCLI gameCLI;

    Game(HangmanCLI gameCLI){
        this.gameCLI = gameCLI;
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
        ArrayList<String> listOfWords = readWordsFile(WORDS_FILENAME);
        System.out.println(listOfWords);
        gameCLI.printHangman(0);
        String hiddenWord = chooseWord(listOfWords);
        System.out.println(hiddenWord);
    }
}
