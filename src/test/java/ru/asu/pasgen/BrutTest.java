package ru.asu.pasgen;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrutTest {

    @Test
    void baseBrutTest() {
        Brut brut = new Brut();
        List<String> result = brut.generatePassword(null);
        Set<String> expected = Set.of(
                "000", "001", "002",
                "010", "011", "012",
                "020", "021", "022",
                "100", "101", "102",
                "110", "111", "112",
                "120", "121", "122",
                "200", "201", "202",
                "210", "211", "212",
                "220", "221", "222");
        assertEquals(expected, new HashSet<>(result), "Списки не совпадают");
    }

}