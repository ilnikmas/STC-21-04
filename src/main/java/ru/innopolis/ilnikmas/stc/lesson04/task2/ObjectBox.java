package ru.innopolis.ilnikmas.stc.lesson04.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс ObjectBox
 * @author Маслёнченко И. Н.
 * @param <T>
 */

public class ObjectBox<T extends Object> {
    public List<T> collection = new ArrayList<>();

    public void addObject(T object) {
        collection.add(object);
    }

    public void deleteObject(T object) {
        collection.remove(object);
    }

    public void dump() {
        System.out.println(toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ObjectBox)) return false;
        ObjectBox<?> objectBox = (ObjectBox<?>) o;
        return collection.equals(objectBox.collection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collection);
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "collection=" + collection +
                '}';
    }
}
