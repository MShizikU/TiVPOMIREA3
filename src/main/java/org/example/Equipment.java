package org.example;

import java.util.ArrayList;

public class Equipment {

    public ArrayList<Character> hiddenWord = new ArrayList<>();
    public ArrayList<Character> alphabet = new ArrayList<>();
    public ArrayList<Character> userWord = new ArrayList<>();

    // Установить алфавит
    public void setAlphabet() {
        for(char c='а'; c<='я'; c++) {
            alphabet.add(c);
        }
    }

    // Установить загаданное слово как массив символов
    public void setHiddenWord(String word) {
        hiddenWord.clear(); // Очистить список перед добавлением нового слова
        for(char c : word.toCharArray()) {
            hiddenWord.add(c);
        }
    }
}
