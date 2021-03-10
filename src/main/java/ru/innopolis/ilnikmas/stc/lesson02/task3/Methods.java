package ru.innopolis.ilnikmas.stc.lesson02.task3;

import java.util.ArrayList;
import java.util.Random;

/**
 * Класс, содержащий методы для работы программы
 *
 * @author Маслёнченко И. Н.
 */

public class Methods {
    private static Random random = new Random();

    /**
     * Метод генерирует список, состоящий из объектов класса Person
     * @param num - количество объектов типа Person в списке
     * @return список, состоящий из num объектов
     */

    static ArrayList<Person> listGeneration(int num) {
        ArrayList<Person> personArray = new ArrayList<Person>();
        for (int i = 0; i < num; i++) {
            personArray.add(new Person(nameGenerate(), ageGenerate(), sexGenerate()));
        }
        return personArray;
    }

    /**
     * Метод генерирует случайный символ из таблицы unicode
     * @return сивмол в диапазоне от a до z
     */
    static char letterGen() {
        int dec = random.nextInt(26) + 97;
        String hexStr = Integer.toHexString(dec);
        return (char) Integer.parseInt(hexStr, 16);
    }

    /**
     * Метод генерирует имя, составленное из сгенерированных
     * символов от a до z
     * @return имя длиной от 3 до 8 символов
     */
    static String nameGenerate() {
        StringBuffer name = new StringBuffer();
        int nameLength = random.nextInt(6) + 3;
        name.append(String.valueOf(letterGen()).toUpperCase());
        for (int j = 1; j <= nameLength - 1; j++) {
            name.append(letterGen());
        }
        return name.toString();
    }

    /**
     * Метод генерирует возраст
     * @return возраст в диапазоне от 18 до 65 лет
     */

    static int ageGenerate() {
        int age = random.nextInt(48) + 18;
        return age;
    }

    /**
     * Метод случайным образом выбирает пол
     * @return пол, WOMAN или MAN
     */

    static Sex sexGenerate() {
        if (random.nextInt(2) == 0) return Sex.WOMAN;
        else return Sex.MAN;
    }
}
