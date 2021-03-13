package ru.innopolis.ilnikmas.stc.lesson02.task3;

import java.util.List;

/**
 * Класс, реализующий сортировку пузырьковым методом
 *
 * @author Маслёнченко И. Н.
 */

public class BubbleSort {
    public static void sort(List<Person> array) {

        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = array.size() - 1; j > i; j--) {
                try {
                    if ((array.get(j - 1).getAge() == array.get(j).getAge()) & (array.get(j - 1).getName().equals(array.get(j).getName()))) {
                        throw new DuplicateRecordException("В таблице имеется дубликат");
                    }
                    if (array.get(j - 1).compareTo(array.get(j)) > 0) {
                        Person tmp = array.get(j - 1);
                        array.remove(j - 1);
                        array.add(j, tmp);
                    }
                } catch (DuplicateRecordException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
