package ru.innopolis.ilnikmas.stc.lesson05.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("number", 100500);

        Integer value = map.getOrDefault("number", 0);
        System.out.println(value); // 100500


        Integer valOrDefault = map.getOrDefault("I forgot my key", 0);
        System.out.println(valOrDefault); // 0

    }
}
