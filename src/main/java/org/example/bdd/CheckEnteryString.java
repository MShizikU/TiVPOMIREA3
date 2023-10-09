package org.example.bdd;
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
        return false;
    }
    public static Equipment toLower(Equipment equipment, Character userInput){
        return equipment;
    }
}
