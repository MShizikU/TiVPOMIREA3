package org.example.bdd;

import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class PoleChudes {

    private Map<String, List<String>> categories = new HashMap<>();
    private String currentWord;
    private Random random;

    public PoleChudes(String filename) throws IOException {
        random = new Random();
        loadWordsFromFile(filename);
    }

    private void loadWordsFromFile(String filename) throws IOException {
    }

    public String chooseWord() {
        return null;
    }

    public String chooseWordFromCategory(String category) {
        return null;
    }

    public static void main(String[] args) throws IOException {
    }
}

