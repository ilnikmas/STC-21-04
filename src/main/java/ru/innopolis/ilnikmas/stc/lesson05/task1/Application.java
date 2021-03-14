package ru.innopolis.ilnikmas.stc.lesson05.task1;

public class Application {
    public static void main(String[] args) {
        DataBase base = new DataBase();
        base.petAdd(new Pet(1, "Шарик", new Person("Иванов", 28, Sex.MAN), 15));
        base.petAdd(new Pet(2, "Тузик", new Person("Петров", 22, Sex.MAN), 12));
        base.petAdd(new Pet(3, "Бобик", new Person("Сидорова", 18, Sex.WOMAN), 9));
        base.petAdd(new Pet(4, "Вулкан", new Person("Смит", 32, Sex.MAN), 23));
        base.petAdd(new Pet(5, "Трезор", new Person("Иванова", 32, Sex.WOMAN), 13));
        base.petAdd(new Pet(6, "Великан", new Person("Самсонов", 37, Sex.MAN), 7));
        base.petAdd(new Pet(7, "Бильбо", new Person("Ильин", 32, Sex.MAN), 28));
        base.petAdd(new Pet(8, "Штакет", new Person("Павлов", 32, Sex.MAN), 17));
        base.petAdd(new Pet(9, "Космос", new Person("Иволгин", 32, Sex.MAN), 9));
        base.petAdd(new Pet(10, "Волна", new Person("Петропавлов", 32, Sex.MAN), 14));
        base.petAdd(new Pet(11, "Туман", new Person("Собянин", 32, Sex.MAN), 10));
        base.petList();
    }
}
