package ru.innopolis.ilnikmas.stc.lesson02.task3;

import java.util.ArrayList;

/**
 * Класс, реализующий сортировку выбором
 *
 * @author Маслёнченко И. Н.
 */

public class SelectionSort {
    public static void sort(ArrayList<Person> array) {
        for (int i = 0; i < array.size(); i++) {
            Person min = array.get(i);
            int min_i = i;
            for (int j = i + 1; j < array.size(); j++) {
                try {
                    if ((array.get(j).getName().equals(min.getName())) & (array.get(j).getAge() == min.getAge())) {
                        throw new DuplicateRecordException("В таблице имеется дубликат");
                    }
                    if (((array.get(j).getSex().equals(Sex.MAN) && min.getSex().equals(Sex.MAN))
                            && (array.get(j).getAge() > min.getAge())) || (((array.get(j).getSex().equals(Sex.MAN)
                            && min.getSex().equals(Sex.MAN))) && ((array.get(j).getAge() == min.getAge())
                            && (array.get(j).getName().compareTo(min.getName()) < 0)))
                            || ((array.get(j).getSex().equals(Sex.WOMAN) && min.getSex().equals(Sex.WOMAN))
                            && (array.get(j).getAge() > min.getAge())) || (((array.get(j).getSex().equals(Sex.WOMAN)
                            && min.getSex().equals(Sex.WOMAN))) && ((array.get(j).getAge() == min.getAge())
                            && (array.get(j).getName().compareTo(min.getName()) < 0)))
                            || (array.get(j).getSex().equals(Sex.MAN) && min.getSex().equals(Sex.WOMAN))) {
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
