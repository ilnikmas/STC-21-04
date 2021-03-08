package ru.innopolis.ilnikmas.stc.lesson02.task3;

import java.util.ArrayList;

import static ru.innopolis.ilnikmas.stc.lesson02.task3.Methods.*;

public class Application {
    public static void main(String[] args) {
        //Генерация массива
        ArrayList<Person> personArray = new ArrayList<Person>();
        for (int i = 0; i < 100; i++) {
            personArray.add(new Person(nameGenerate(), ageGenerate(), sexGenerate()));
        }
//        for (Person person: personArray) {
//            System.out.println(person);
//        }
//        System.out.println("---------------------------------------");
        long timeStart = System.currentTimeMillis();
        BubbleSort.sort(personArray);
        long timeFinish = System.currentTimeMillis();
        System.out.println(timeFinish - timeStart);

        timeStart = System.currentTimeMillis();
        SelectionSort.sort(personArray);
        timeFinish = System.currentTimeMillis();
        System.out.println(timeFinish - timeStart);
        for (Person person : personArray) {
            System.out.println(person);
        }
    }
}
