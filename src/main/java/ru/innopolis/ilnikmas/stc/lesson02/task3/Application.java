package ru.innopolis.ilnikmas.stc.lesson02.task3;

import java.util.ArrayList;
import java.util.List;

import static ru.innopolis.ilnikmas.stc.lesson02.task3.Methods.*;

public class Application {
    public static void main(String[] args) {
        //Генерация массива
        ArrayList<Person> personArray = listGeneration();
//        for (Person person: personArray) {
//            System.out.println(person);
//        }
//        System.out.println("---------------------------------------");
        long timeStart = System.currentTimeMillis();
        BubbleSort.sort(personArray);
        long timeFinish = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (timeFinish - timeStart) + " мс");

        timeStart = System.currentTimeMillis();
        SelectionSort.sort(personArray);
        timeFinish = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (timeFinish - timeStart) + " мс");
        for (Person person : personArray) {
            System.out.println(person);
        }
    }
}
