package org.example.bdd;

import org.example.Equipment;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class PoleChudes {

    private Map<String, List<String>> categories = new HashMap<>();
    private String currentWord;
    private Random random;
    private Equipment equipment;

    public PoleChudes(String filename, Equipment equipment) throws IOException {
        this.equipment = equipment;
        random = new Random();
        loadWordsFromFile(filename);
        equipment.setAlphabet();  // Устанавливаем алфавит в equipment
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
        equipment.setHiddenWord(currentWord); // Устанавливаем слово в equipment
        return currentWord;
    }

    public String chooseWordFromCategory(String category) {
        if (categories.containsKey(category)) {
            List<String> categoryWords = categories.get(category);
            currentWord = categoryWords.get(random.nextInt(categoryWords.size()));
            equipment.setHiddenWord(currentWord); // Устанавливаем слово в equipment
            return currentWord;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        Equipment equipment = new Equipment();
        PoleChudes game = new PoleChudes("../../resources/words.txt.txt", equipment);
        String chosenWord = game.chooseWord();
        System.out.println(chosenWord);
        chosenWord = game.chooseWordFromCategory("города");
        System.out.println(chosenWord);
    }
}
