package org.example.tdd;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class PoleChudes {

    private Map<String, List<String>> categories = new HashMap<>();
    private String currentWord;
    private Random random;

    public PoleChudes(String filename) throws IOException {
        random = new Random();
        loadWordsFromFile(filename);
    }

    private void loadWordsFromFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        String currentCategory = "";

        for (String line : lines) {
            if (line.startsWith("[")) {
                currentCategory = line.substring(1, line.length() - 1);
                categories.put(currentCategory, new ArrayList<>());
            } else {
                categories.get(currentCategory).add(line);
            }
        }
    }

    public String chooseWord() {
        List<String> allWords = new ArrayList<>();
        for (List<String> categoryWords : categories.values()) {
            allWords.addAll(categoryWords);
        }
        currentWord = allWords.get(random.nextInt(allWords.size()));
        return currentWord;
    }

    public String chooseWordFromCategory(String category) {
        if (categories.containsKey(category)) {
            List<String> categoryWords = categories.get(category);
            currentWord = categoryWords.get(random.nextInt(categoryWords.size()));
            return currentWord;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        PoleChudes game = new PoleChudes("../../resources/words.txt.txt");
        String chosenWord = game.chooseWord();
        System.out.println(chosenWord);
        chosenWord = game.chooseWordFromCategory("города");
        System.out.println(chosenWord);
    }
}


