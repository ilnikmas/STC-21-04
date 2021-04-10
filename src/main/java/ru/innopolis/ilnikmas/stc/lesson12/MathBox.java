package ru.innopolis.ilnikmas.stc.lesson12;

import ru.innopolis.ilnikmas.stc.lesson04.task2.ObjectBox;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс MathBox, доработанный
 * @author Маслёнченко И. Н.
 * @param <T>
 */

public class MathBox<T extends Number> extends ObjectBox<Number> {

    MathBox(T[] numberArray){
        try {
            List<T> duplicateList = getDuplicates(numberArray);
            if (duplicateList.size() > 0) throw new DuplicateElementException("Найдены дубликаты: " + duplicateList);
            Collections.addAll(collection, numberArray);
        } catch (DuplicateElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public double summator() {
//        double sum = 0;
//        for (Number element : collection) {
//            sum += element.doubleValue();
//        }
//        return sum;
        //Замена на стрим и лямбда-выражение
        return collection.stream().mapToDouble(num -> num.doubleValue()).sum();
    }

    public void splitter(T divider) {
//        for (int i = 0; i < collection.size(); i++) {
//            collection.set(i, collection.get(i).doubleValue() / divider.doubleValue());
//        }
        //Замена на стрим и лямбда-выражение
        collection = collection.stream().mapToDouble(num -> num.doubleValue() / divider.doubleValue()).boxed().collect(Collectors.toList());
    }

    public void deleteDuplicateInteger(Integer integer){
        collection.remove(integer);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "MathBox: " + collection;
    }

    private List<T> getDuplicates(T[] array) {
        Set<T> duplicates = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            T e1 = array[i];
            if (e1 == null) continue; // игнорируем null
            // сравниваем каждый элемент со всеми остальными
            for (int j = 0; j < array.length; j++) {
                if (i == j) continue; // не проверяем элемент с собой же
                T e2 = array[j];
                if (e1.equals(e2)) {
                    // дубликат найден, сохраним его
                    duplicates.add(e2);
                }
            }
        }
        return new ArrayList<>(duplicates);
    }
}
