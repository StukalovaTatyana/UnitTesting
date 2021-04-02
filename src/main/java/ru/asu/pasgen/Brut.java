package ru.asu.pasgen;

import java.util.ArrayList;
import java.util.List;

public class Brut {
    public List<String> generatePassword(String[] list) {
        if (list == null) {
            list = new String[]{"0", "1", "2"};
        }
        List<String> result = new ArrayList<>();

        // TODO: 02.04.2021 Тут обработка по генерации полного перебора
        //  ЗАДАЧА:
        //  1. из символов в массиве list нужно сделать полный перебор всех вариантов перестановок
        //      пример перебора: "000" "001" "002" "010" "011" ... "222"
        //  2. все новые строки необходимо записывать в массив result
        //  3. массив result необходимо вывести на экран
        //  4. массив result необходимо вернуть в качестве результата работы функции


        return result;
    }
}
