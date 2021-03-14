package ru.innopolis.ilnikmas.stc.lesson04.task2;

public class Application {
    public static void main(String[] args) {
        ObjectBox<Object> obox1 = new ObjectBox<>();
        obox1.addObject("String");
        obox1.addObject(2);
        obox1.addObject(3.14);
        obox1.dump();
        obox1.deleteObject("String");
        obox1.dump();
    }
}
