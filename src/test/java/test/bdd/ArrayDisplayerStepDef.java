package test.bdd;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.example.bdd.ArrayDisplayer;
import org.example.Equipment;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayDisplayerStepDef {
    private Equipment equipment;
    private ArrayDisplayer displayer;
    private ByteArrayOutputStream outContent;

    @Дано("слово пользователя {string}")
    public void i_have_user_word(String word) {
        equipment = new Equipment();
        for(char c : word.toCharArray()) {
            equipment.userWord.add(c);
        }
        displayer = new ArrayDisplayer();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Дано("пустое слово пользователя")
    public void i_have_empty_user_word() {
        equipment = new Equipment();
        displayer = new ArrayDisplayer();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Дано("дан полный алфавит")
    public void i_have_full_alphabet() {
        equipment.setAlphabet();
    }

    @Когда("я вызываю функцию отображения")
    public void i_call_display_function() {
        displayer.displayArrays(equipment.userWord, equipment.alphabet);
    }

    @Тогда("я вижу {string} и полный алфавит")
    public void i_see_word_and_full_alphabet(String word) {
        assertTrue(outContent.toString().contains("Слово пользователя: " + word));
        assertTrue(outContent.toString().contains("Алфавит: а б в г д е ж з и й к л м н о п р с т у ф х ц ч ш щ ъ ы ь э ю я "));
    }

    @Тогда("я вижу пустое слово и полный алфавит")
    public void i_see_empty_word_and_full_alphabet() {
        assertTrue(outContent.toString().contains("Слово пользователя: "));
        assertTrue(outContent.toString().contains("Алфавит: а б в г д е ж з и й к л м н о п р с т у ф х ц ч ш щ ъ ы ь э ю я "));
    }
}
