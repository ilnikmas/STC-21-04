package ru.innopolis.ilnikmas.stc.lesson02.task3;

/**
 * Класс Person
 *
 * @author Маслёнченко И. Н.
 */

public class Person {
    private String name;
    private int age;
    private Sex sex;


    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Person person) {
        int result = 0;
        if (this.getSex() != person.getSex()) {
            result = this.getSex() == Sex.MAN ? -1 : 1;
            return result;
        }
        if (this.getAge() - person.getAge() != 0) {
            return this.getAge() - person.getAge() > 0 ? -1 : 1;
        }
        result = this.getName().compareTo(person.getName());
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
