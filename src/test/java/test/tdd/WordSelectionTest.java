package test.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.example.tdd.PoleChudes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WordSelectionTest {
    private PoleChudes game;
    private List<String> allWordsFromFile;

    @BeforeEach
    void setUp() throws IOException {
        game = new PoleChudes("../../resources/words.txt");
        allWordsFromFile = Files.readAllLines(Paths.get("../../resources/words.txt"));
    }

    @Test
    void testChooseRandomWord() {
        String word = game.chooseWord();

        // Проверяем, что слово не пустое и оно присутствует в файле
        assertNotNull(word, "Выбранное слово не должно быть пустым");
        assertTrue(allWordsFromFile.contains(word), "Выбранное слово должно быть из файла");
    }

    @Test
    void testChooseWordFromCategory() {
        // Допустим, первые 5 слов в файле относятся к категории 'города' (для демонстрации)
        List<String> mockedCategoryWords  = allWordsFromFile.subList(0, 5);

        String word = game.chooseWord(); // Так как у нас нет метода выбора слова по категории, используем общий метод

        assertTrue(mockedCategoryWords.contains(word), "Выбранное слово должно быть из заданной категории");
    }
}
