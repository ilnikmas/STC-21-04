package ru.innopolis.ilnikmas.stc.lesson05.task1;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс Person, описывающий хозяина животного
 * @author Маслёнченко И. Н.
 */
class Person {
    private String name;
    private int age;
    private Sex sex;

    Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
