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
class PerformUserInputTest {
    Equipment basicEquipment;

    @BeforeEach
    void setUpEach() {
        basicEquipment = new Equipment();
        basicEquipment.alphabet = new ArrayList<>();
        basicEquipment.hiddenWord = new ArrayList<>();
        basicEquipment.userWord = new ArrayList<>();

        for (int i = 1072; i <= 1103; i++) basicEquipment.alphabet.add( (char) i );
    }

    @Test
    void testIsLetterInWordMiddleTrue(){
        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('о');
        basicEquipment.hiddenWord.add('ш');
        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('а');

        Character userInput = 'ш';

        Boolean isLetterInWord = PerformUserInput.isLetterInWord(basicEquipment, userInput);

        assertEquals(true, isLetterInWord);
    }

    @Test
    void testIsLetterInWordFirstTrue(){
        basicEquipment.hiddenWord.add('м');
        basicEquipment.hiddenWord.add('ы');
        basicEquipment.hiddenWord.add('ш');
        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('а');

        Character userInput = 'м';

        Boolean isLetterInWord = PerformUserInput.isLetterInWord(basicEquipment, userInput);

        assertEquals(true, isLetterInWord);
    }

    @Test
    void testIsLetterInWordLastTrue(){

        basicEquipment.hiddenWord.add('х');
        basicEquipment.hiddenWord.add('л');
        basicEquipment.hiddenWord.add('е');
        basicEquipment.hiddenWord.add('б');

        Character userInput = 'б';

        Boolean isLetterInWord = PerformUserInput.isLetterInWord(basicEquipment, userInput);

        assertEquals(true, isLetterInWord);
    }

    @Test
    void testIsLetterInWordEnFalse(){
        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('о');
        basicEquipment.hiddenWord.add('ш');
        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('а');

        Character userInput = 'a';

        Boolean isLetterInWord = PerformUserInput.isLetterInWord(basicEquipment, userInput);

        assertEquals(false, isLetterInWord);
    }

    @Test
    void testIsLetterInWordFalse(){
        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('о');
        basicEquipment.hiddenWord.add('ш');
        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('а');

        Character userInput = 'ы';

        Boolean isLetterInWord = PerformUserInput.isLetterInWord(basicEquipment, userInput);

        assertEquals(false, isLetterInWord);
    }

    @Test
    void testRemoveLetterFromAlphabet(){
        Character userInput = 'с';

        Equipment resultedEquipment = PerformUserInput.removeLetterFromAlphabet(basicEquipment, userInput);

        ArrayList<Character> expectedAlphabet = new ArrayList<>(basicEquipment.alphabet);
        expectedAlphabet.set(18, '_');

        assert resultedEquipment != null;
        assertIterableEquals(expectedAlphabet, resultedEquipment.alphabet);
    }

    @Test
    void testRemoveLetterFromAlphabetUnexistLetter(){
        Character userInput = 'b';

        Equipment resultedEquipment = PerformUserInput.removeLetterFromAlphabet(basicEquipment, userInput);

        ArrayList<Character> expectedAlphabet = new ArrayList<>(basicEquipment.alphabet);

        assert resultedEquipment != null;
        assertEquals(expectedAlphabet, resultedEquipment.alphabet);
    }

    @Test
    void testRemoveLetterFromAlphabetDeletedLetter(){
        Character userInput = 'б';

        Equipment resultedEquipment = PerformUserInput.removeLetterFromAlphabet(basicEquipment, userInput);

        ArrayList<Character> expectedAlphabet = new ArrayList<>(basicEquipment.alphabet);
        expectedAlphabet.set(18, '_');

        assert resultedEquipment != null;
        assertEquals(expectedAlphabet, resultedEquipment.alphabet);
    }

    @Test
    void testUpdateUserWordMiddle(){

        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('о');
        basicEquipment.hiddenWord.add('ш');
        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('а');

        Character userInput = 'ш';

        for (int i = 0; i < basicEquipment.hiddenWord.size(); i++) basicEquipment.userWord.add('_');

        ArrayList<Character> expected = new ArrayList<>(basicEquipment.userWord);
        expected.set(2, userInput);

        Equipment result = PerformUserInput.updateUserWord(basicEquipment, userInput);

        assert result != null;
        assertIterableEquals(expected, result.userWord);
    }

    @Test
    void testUpdateUserWordFirst(){

        basicEquipment.hiddenWord.add('м');
        basicEquipment.hiddenWord.add('о');
        basicEquipment.hiddenWord.add('ш');
        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('а');

        Character userInput = 'к';

        for (int i = 0; i < basicEquipment.hiddenWord.size(); i++) basicEquipment.userWord.add('_');

        ArrayList<Character> expected = new ArrayList<>(basicEquipment.userWord);
        expected.set(0, userInput);

        Equipment result = PerformUserInput.updateUserWord(basicEquipment, userInput);

        assert result != null;
        assertIterableEquals(expected, result.userWord);
    }

    @Test
    void testUpdateUserWordLast(){

        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('о');
        basicEquipment.hiddenWord.add('ш');
        basicEquipment.hiddenWord.add('к');
        basicEquipment.hiddenWord.add('а');

        Character userInput = 'а';

        for (int i = 0; i < basicEquipment.hiddenWord.size(); i++) basicEquipment.userWord.add('_');

        ArrayList<Character> expected = new ArrayList<>(basicEquipment.userWord);
        expected.set(4, userInput);

        Equipment result = PerformUserInput.updateUserWord(basicEquipment, userInput);

        assert result != null;
        assertIterableEquals(expected, result.userWord);
    }
}