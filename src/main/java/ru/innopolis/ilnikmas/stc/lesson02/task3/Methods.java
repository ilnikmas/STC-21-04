package ru.innopolis.ilnikmas.stc.lesson02.task3;

import java.util.ArrayList;
import java.util.Random;

public class Methods {
    private static Random random = new Random();

    static ArrayList<Person> listGeneration() {
        ArrayList<Person> personArray = new ArrayList<Person>();
        for (int i = 0; i < 100; i++) {
            personArray.add(new Person(nameGenerate(), ageGenerate(), sexGenerate()));
        }
        return personArray;
    }

    static char letterGen() {
        int dec = random.nextInt(26) + 97;
        String hexStr = Integer.toHexString(dec);
        return (char) Integer.parseInt(hexStr, 16);
    }

    static String nameGenerate() {
        StringBuffer name = new StringBuffer();
        int nameLength = random.nextInt(6) + 3;
        for (int j = 1; j <= nameLength; j++) {
            name.append(letterGen());
        }
        return name.toString();
    }

    static int ageGenerate() {
        int age = random.nextInt(48) + 18;
        return age;
    }

    static Sex sexGenerate() {
        if (random.nextInt(2) == 0) return Sex.WOMAN;
        else return Sex.MAN;
    }

    static ArrayList<Person> sortBySex(ArrayList<Person> array) {
        int womenQuantity = 0;
        for (int i = 0; i < array.size() - womenQuantity; i++) {
            if (array.get(i).getSex().equals(Sex.WOMAN)) {
                Person tmp = array.get(i);
                array.remove(i);
                array.add(tmp);
                i--;
                womenQuantity++;
            }
        }
        return array;
    }
}
