package org.example.tdd;

import java.util.ArrayList;

public class ArrayDisplayer {

    /**
     * Выводит содержимое двух списков.
     * @param userWord Список с символами слова пользователя.
     * @param alphabet Список с алфавитом.
     */
    public void displayArrays(ArrayList<Character> userWord, ArrayList<Character> alphabet) {
        // Выводим список userWord
        System.out.print("Слово пользователя: ");
        for(Character c : userWord) {
            System.out.print(c + " ");
        }
        System.out.println();  // Переходим на следующую строку

        // Выводим список alphabet
        System.out.print("Алфавит: ");
        for(Character c : alphabet) {
            System.out.print(c + " ");
        }
        System.out.println();  // Переходим на следующую строку
    }
}

