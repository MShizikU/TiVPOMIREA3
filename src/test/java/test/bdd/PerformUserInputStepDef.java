package test.bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.example.Equipment;
import org.example.bdd.PerformUserInput;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerformUserInputStepDef {
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
            equipment.userWord.add('_');
        }

        for (int i = 1072; i <= 1103; i++) equipment.alphabet.add( (char) i );
    }

    @Когда("^пользователь вводит букву (.)")
    public void givenInput(Character userInput){
        this.userInput = userInput;
    }

    @Тогда("^проверка на наличие буквы возвращает (.*)")
    public void checkIsLetterInWord(String strRes){
        Boolean expResult = strRes.equals("да");
        assertEquals(expResult, PerformUserInput.isLetterInWord(equipment, userInput));
    }
}
