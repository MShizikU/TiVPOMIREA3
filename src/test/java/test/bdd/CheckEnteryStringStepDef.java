package test.bdd;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.example.Equipment;
import org.example.bdd.CheckEnteryString;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class CheckEnteryStringStepDef{
    private Equipment equipment;
    private Character userInput;

    @Дано("^загаданное слово (.*)")
    public void givenCurrentWord(String currentWord) {
        equipment = new Equipment();
        equipment.alphabet = new ArrayList<>();
        equipment.hiddenWord = new ArrayList<>();
        equipment.userWord = new ArrayList<>();

        for (char c : currentWord.toCharArray()) {
            equipment.hiddenWord.add(c);
        }

        for (int i = 1072; i <= 1103; i++) equipment.alphabet.add( (char) i );
    }

    @Когда("^пользователь вводит символ (.*)")
    public void givenInput(Character userInput){
        this.userInput = userInput;
    }

    @И("^текущий алфавит (.*)")
    public void createExistedAlphabet(String alphabet) {
        equipment.alphabet = new ArrayList<>();
        for (char c : alphabet.toCharArray()) equipment.alphabet.add(c);
    }
    
    @Тогда("^проверка на наличие буквы возвращает (.*)")
    public void checkNumberIsLetter(String strRes){
        Boolean expResult = strRes.equals("да");
        assertEquals(expResult, CheckEnteryString.isLetter(equipment, userInput));
    }

    @Тогда("^проверка на наличие в алфавите возвращает (.*)")
    public void checkLetterInAlphabet(String strRes){
        Boolean expResult = strRes.equals("да");
        assertEquals(expResult, CheckEnteryString.inAlphabet(equipment, userInput));
    }

    @Тогда("^функция понижение регистра возвращает (.*)")
    public void bigLetterToLower(String strRes){
        Boolean expResult = strRes.equals('a');
        assertEquals(expResult, CheckEnteryString.toLower(equipment, userInput));
    }
}