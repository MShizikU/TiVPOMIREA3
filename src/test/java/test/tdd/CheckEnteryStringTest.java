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

        for (int i = 1072; i <= 1103; i++) basicEquipment.alphabet.add( (char) i );
    }
    
}
