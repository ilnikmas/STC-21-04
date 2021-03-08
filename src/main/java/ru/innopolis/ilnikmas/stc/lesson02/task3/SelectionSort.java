package ru.innopolis.ilnikmas.stc.lesson02.task3;

import java.util.ArrayList;

public class SelectionSort {
    public static void sort(ArrayList<Person> array) {
        for (int i = 0; i < array.size(); i++) {
            Person min = array.get(i);
            int min_i = i;
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j).getAge() > min.getAge()) {
                    min = array.get(j);
                    min_i = j;
                }
            }
            if (i != min_i) {
                Person tmp = array.get(i);
                array.set(i, array.get(min_i));
                array.set(min_i, tmp);
            }
        }

        Methods.sortBySex(array);

        for (int i = 0; i < array.size(); i++) {
            Person min = array.get(i);
            int min_i = i;
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j).getAge() == min.getAge() && array.get(j).getSex().equals(min.getSex())) {
                    if (array.get(j).getName().compareTo(min.getName()) < 0) {
                        min = array.get(j);
                        min_i = j;
                    }
                }
            }
            if (i != min_i ) {
                Person tmp = array.get(i);
                array.set(i, array.get(min_i));
                array.set(min_i, tmp);
            }
        }
    }
}
