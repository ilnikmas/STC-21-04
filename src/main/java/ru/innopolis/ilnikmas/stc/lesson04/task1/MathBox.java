package ru.innopolis.ilnikmas.stc.lesson04.task1;

import java.util.*;

/**
 * Класс MathBox
 * @author Маслёнченко И. Н.
 * @param <T>
 */

public class MathBox<T extends Number> {
    private List<Number> collection;

    MathBox(T[] numberArray){
        collection = new ArrayList<>();
        try {
            List<T> duplicateList = getDuplicates(numberArray);
            if (duplicateList.size() > 0) throw new DuplicateElementException("Найдены дубликаты: " + duplicateList);
            Collections.addAll(collection, numberArray);
        } catch (DuplicateElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public double summator() {
        double sum = 0;
        for (Number element : collection) {
            sum += element.doubleValue();
        }
        return sum;
    }

    public void splitter(T divider) {
        for (int i = 0; i < collection.size(); i++) {
            collection.set(i, collection.get(i).doubleValue() / divider.doubleValue());
        }
    }

    public void deleteDuplicateInteger(Integer integer){
        collection.remove(integer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MathBox)) return false;
        MathBox<?> mathBox = (MathBox<?>) o;
        return collection.equals(mathBox.collection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collection);
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
