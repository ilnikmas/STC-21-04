package ru.innopolis.ilnikmas.stc.lesson13.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Приложение, создающее ошибку OutOfMemoryError с пометкой JavaHeapSpace.
 *
 * @author Маслёнченко И. Н.
 */
public class OutOfMemoryErrorJavaHeapSpaceExample {

    public static void main(String[] args) throws InterruptedException {
        List<Object> listOfObjects = new ArrayList<>();
        while (true) {
            listOfObjects.add(new Object());
            new HashMap<String, Object>();
        }
    }
}
