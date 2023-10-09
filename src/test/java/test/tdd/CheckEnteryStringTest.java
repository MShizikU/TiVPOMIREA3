package test.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Equipment;
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
        Character userInput = 'A';
        Equipment newEquipment = CheckEnteryString.toLower(basicEquipment, userInput);
        Character newEquipmentLetter = newEquipment.userWord.get(newEquipment.userWord.size() - 1);
        Character equipmentLetter = 'a';
        assertEquals(equipmentLetter, newEquipmentLetter);
    }
}
