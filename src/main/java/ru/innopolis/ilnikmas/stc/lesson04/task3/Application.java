package ru.innopolis.ilnikmas.stc.lesson04.task3;

import ru.innopolis.ilnikmas.stc.lesson04.task1.MathBox;

public class Application {
    public static void main(String[] args) {
        Number[] numbers = new Number[] {1, 2.5f, 5.4d, 1};
        MathBox<Number> box = new MathBox<>(numbers);
        System.out.println(box.summator());
        System.out.println(box);
//        box.splitter(3);
//        System.out.println(box);
//        box.deleteDuplicateInteger(1);
//        System.out.println(box);

    }
}
