package src.main.java;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Game {
    private static final String WORDS_FILENAME = "src/main/resources/russian_nouns.txt";
    private static final int MAX_ERRORS = 6;
    private final HangmanCLI gameCLI;
    private final ArrayList<String> listOfWords;

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
        int errors = 0;
        HashSet<Character> enteredLetters = new HashSet<Character>();
        gameCLI.printHangman(errors);
        gameCLI.hiddenWord = new StringBuilder("_".repeat(hiddenWord.length()));
        while ((!hiddenWord.contentEquals(gameCLI.hiddenWord)) && (errors != MAX_ERRORS)){
            gameCLI.printWordInformation(errors, enteredLetters);

        }

    }
}
