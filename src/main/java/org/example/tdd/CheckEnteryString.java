package org.example.tdd;
import org.example.Equipment;

/*Отработка пользовательского ввода
 1. Проверка на наличие буквы в алфавите;
 2. Проверка на корректность ввода;
 3. Приведение всех букв к нижнему регистру;
 */

public class CheckEnteryString {
    public static boolean inAlphabet(Equipment equipment, Character userInput){
        if(equipment.alphabet.contains(userInput)){
               return true;
           } 
        return false;
    }
    public static boolean isLetter(Equipment equipment, Character userInput){
        if (userInput >= (char)1072 && userInput <= (char)1103)
            return true;
        return false;
    }
    public static Chracter toLower(Equipment equipment, Character userInput){
        Character lowerLetter = Character.toLowerCase(userInput);
        return lowerLetter;
    }
}
