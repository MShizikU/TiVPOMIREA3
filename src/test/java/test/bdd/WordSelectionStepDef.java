package test.bdd;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.example.bdd.PoleChudes;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordSelectionStepDef {
    private PoleChudes game;
    private String chosenWord;

    @Дано("^файл со словами (.*)")
    public void givenWordsFile(String filename) throws Exception {
        game = new PoleChudes(filename);
    }

    @Дано("^дана категория (.*)")
    public void givenCategory(String category) {
        // Пока просто задаем категорию. Выбор слова из категории происходит в другом шаге.
    }

    @Когда("^я выбираю случайное слово из файла$")
    public void whenChooseRandomWord() {
        chosenWord = game.chooseWord();
    }

    @Когда("^я выбираю слово из категории$")
    public void whenChooseWordFromCategory(String category) {
        chosenWord = game.chooseWordFromCategory(category);
    }

    @Тогда("^я получаю слово из списка слов файла$")
    public void thenIGetAWordFromList() {
        assertTrue(chosenWord != null && !chosenWord.isEmpty());
    }

    @Тогда("^я получаю слово из этой категории$")
    public void thenIGetAWordFromCategory() {
        assertTrue(chosenWord != null && !chosenWord.isEmpty());
    }
}
