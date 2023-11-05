package org.example;

import org.example.tdd.PerformUserInput;

import java.util.ArrayList;

public class Main {

    public static Equipment basicEquipment;

    public static void main(String[] args) {

        System.out.println("Hello world!");
        basicFill();

        Character userInput = 'к';

        if (PerformUserInput.isLetterInWord(basicEquipment, userInput)){
            PerformUserInput.removeLetterFromAlphabet(basicEquipment, userInput);
            PerformUserInput.updateUserWord(basicEquipment, userInput);
        }

        long startTime = System.currentTimeMillis();
        long endTime = startTime + 60 * 1000;

        while (System.currentTimeMillis() < endTime) {
            allocateMemory();
            deallocateMemory();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void basicFill(){
        basicEquipment = new Equipment();
        basicEquipment.alphabet = new ArrayList<>();
        basicEquipment.hiddenWord = new ArrayList<>();
        basicEquipment.userWord = new ArrayList<>();
        for (int i = 1073; i <= 1103; i++) basicEquipment.alphabet.add( (char) i );
        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('о');
        basicEquipment.hiddenWord.add('ш');
        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('а');
        for (int i = 0; i < basicEquipment.hiddenWord.size(); i++) basicEquipment.userWord.add('_');
    }

    private static void allocateMemory() {
        int[] array = new int[1000000]; // Выделяем память для массива из 1 миллиона элементов
    }

    private static void deallocateMemory() {
        // Освобождаем память путем присвоения null ссылке на объект
        int[] array = null;
    }
}