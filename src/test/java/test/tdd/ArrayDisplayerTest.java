package test.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.example.tdd.ArrayDisplayer;
import org.example.Equipment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ArrayDisplayerTest {

    private Equipment equipment;
    private ArrayDisplayer displayer;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        equipment = new Equipment();
        displayer = new ArrayDisplayer();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDisplayWithUserWord() {
        // Данные
        String userWord = "слово";
        for(char c : userWord.toCharArray()) {
            equipment.userWord.add(c);
        }
        equipment.setAlphabet();

        // Действие
        displayer.displayArrays(equipment.userWord, equipment.alphabet);

        // Проверка
        assertTrue(outContent.toString().contains("Слово пользователя: слово"));
        assertTrue(outContent.toString().contains("Алфавит: а б в г д е ж з и й к л м н о п р с т у ф х ц ч ш щ ъ ы ь э ю я "));
    }

    @Test
    public void testDisplayWithEmptyUserWord() {
        // Данные
        equipment.setAlphabet();

        // Действие
        displayer.displayArrays(equipment.userWord, equipment.alphabet);

        // Проверка
        assertTrue(outContent.toString().contains("Слово пользователя: "));
        assertTrue(outContent.toString().contains("Алфавит: а б в г д е ж з и й к л м н о п р с т у ф х ц ч ш щ ъ ы ь э ю я "));
    }
}
