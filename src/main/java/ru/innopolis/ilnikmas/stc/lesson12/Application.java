package ru.innopolis.ilnikmas.stc.lesson12;

public class Application {
    public static void main(String[] args) {
        Number[] numbers = new Number[] {1, 2.5f, 5.4d};
        MathBox<Number> box = new MathBox<>(numbers);
        System.out.println(box.summator());
        System.out.println(box);
//        box.splitter(3);
//        System.out.println(box);
//        box.deleteDuplicateInteger(1);
//        System.out.println(box);
        box.addObject(3.5);
        box.dump();
    }
}
