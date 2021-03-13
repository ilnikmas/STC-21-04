package ru.innopolis.ilnikmas.stc.lesson02.task3;

import java.util.List;

/**
 * Класс, реализующий сортировку выбором
 *
 * @author Маслёнченко И. Н.
 */

public class SelectionSort {
    public static void sort(List<Person> array) {
        for (int i = 0; i < array.size(); i++) {
            Person min = array.get(i);
            int min_i = i;
            for (int j = i + 1; j < array.size(); j++) {
                try {
                    if ((array.get(j).getName().equals(min.getName())) & (array.get(j).getAge() == min.getAge())) {
                        throw new DuplicateRecordException("В таблице имеется дубликат");
                    }
                    if (array.get(j).compareTo(min) < 0) {
                        min = array.get(j);
                        min_i = j;
                    }
                } catch (DuplicateRecordException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (i != min_i) {
                Person tmp = array.get(i);
                array.set(i, array.get(min_i));
                array.set(min_i, tmp);
            }
        }
    }
}
