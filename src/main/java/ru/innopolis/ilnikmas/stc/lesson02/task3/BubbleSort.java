package ru.innopolis.ilnikmas.stc.lesson02.task3;

import java.util.ArrayList;

/**
 * Класс, реализующий сортировку пузырьковым методом
 *
 * @author Маслёнченко И. Н.
 */

public class BubbleSort {
    public static void sort(ArrayList<Person> array) {

        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = array.size() - 1; j > i; j--) {
                try {
                    if ((array.get(j - 1).getAge() == array.get(j).getAge()) & (array.get(j - 1).getName().equals(array.get(j).getName()))) {
                        throw new DuplicateRecordException("В таблице имеется дубликат");
                    }
                    if (((array.get(j - 1).getSex().equals(Sex.MAN) && array.get(j).getSex().equals(Sex.MAN))
                            && (array.get(j - 1).getAge() < array.get(j).getAge())) || (((array.get(j - 1).getSex().equals(Sex.MAN)
                            && array.get(j).getSex().equals(Sex.MAN))) && ((array.get(j - 1).getAge() == array.get(j).getAge())
                            && (array.get(j - 1).getName().compareTo(array.get(j).getName()) > 0)))
                            || ((array.get(j - 1).getSex().equals(Sex.WOMAN) && array.get(j).getSex().equals(Sex.WOMAN))
                            && (array.get(j - 1).getAge() < array.get(j).getAge())) || (((array.get(j - 1).getSex().equals(Sex.WOMAN)
                            && array.get(j).getSex().equals(Sex.WOMAN))) && ((array.get(j - 1).getAge() == array.get(j).getAge())
                            && (array.get(j - 1).getName().compareTo(array.get(j).getName()) > 0)))
                            || (array.get(j - 1).getSex().equals(Sex.WOMAN) && array.get(j).getSex().equals(Sex.MAN))
                    ) {
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
