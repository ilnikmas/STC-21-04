package ru.innopolis.ilnikmas.stc.lesson02.task3;

import java.util.ArrayList;

public class BubbleSort {
    public static void sort(ArrayList<Person> array) {

        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = array.size() - 1; j > i; j--) {
                if (array.get(j - 1).getAge() < array.get(j).getAge()) {
                    Person tmp = array.get(j - 1);
                    array.remove(j - 1);
                    array.add(j, tmp);
                }
            }
        }

        Methods.sortBySex(array);

        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = array.size() - 1; j > i; j--) {
                if (array.get(j - 1).getAge() == array.get(j).getAge() && array.get(j - 1).getSex().equals(array.get(j).getSex())) {
                    if (array.get(j - 1).getName().compareTo(array.get(j).getName()) > 0) {
                        Person tmp = array.get(j - 1);
                        array.remove(j - 1);
                        array.add(j, tmp);
                    }
                }
            }
        }
    }
}
