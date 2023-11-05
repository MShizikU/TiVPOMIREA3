package test.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Equipment;
import org.example.tdd.CheckEnteryString;
import org.example.tdd.PerformUserInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class CheckEnteryStringTest {
    Equipment basicEquipment;

    @BeforeEach
    void setUpEach() {
        basicEquipment = new Equipment();
        basicEquipment.alphabet = new ArrayList<>();
        basicEquipment.hiddenWord = new ArrayList<>();
        basicEquipment.userWord = new ArrayList<>();

        for (int i = 1073; i <= 1103; i++) basicEquipment.alphabet.add( (char) i );
    }
    @Test
    void testIsLetter(){
        Character userInput = '0';
        Boolean isLetter = CheckEnteryString.isLetter(basicEquipment, userInput);
        assertEquals(false, isLetter);
    }

    @Test
    void testInAlphabet(){
        Character userInput = 'а';
        Boolean isInAlphabet = CheckEnteryString.inAlphabet(basicEquipment, userInput);
        assertEquals(false, isInAlphabet);
    }
    
    @Test
    void testToLower(){
        Character userInput = 'А';
        Character newCharacter = CheckEnteryString.toLower(basicEquipment, userInput);
        Character equipmentLetter = 'а';
        assertEquals(equipmentLetter, newCharacter);
    }

    @Test
    void testDashIsLetter(){
        Character userInput = '-';
        Boolean isLetter = CheckEnteryString.isLetter(basicEquipment, userInput);
        assertEquals(false, isLetter);
    }

    @Test
    void testLowerLetterToLower(){
        Character userInput = 'б';
        Character newCharacter = CheckEnteryString.toLower(basicEquipment, userInput);
        Character equipmentLetter = 'б';
        assertEquals(equipmentLetter, newCharacter);
    }

    @Test
    void testAlphabetLetterInAlphabet(){
        Character userInput = 'б';
        Boolean isInAlphabet = CheckEnteryString.inAlphabet(basicEquipment, userInput);
        assertEquals(true, isInAlphabet);
    }

    @Test
    void testEnglishLetterIsLetter(){
        Character userInput = 'b';
        Boolean isLetter = CheckEnteryString.isLetter(basicEquipment, userInput);
        assertEquals(false, isLetter);
    }
}
