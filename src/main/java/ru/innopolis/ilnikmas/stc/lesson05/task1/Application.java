package ru.innopolis.ilnikmas.stc.lesson05.task1;

public class Application {
    public static void main(String[] args) {
        Base base = new Base();
        base.petAdd(new Pet(1,"Aaaa", 1, new Person("Bbbb", 23, Sex.MAN)));
        base.petAdd(new Pet(2,"Dddd", 10, new Person("Aaaa", 14, Sex.MAN)));
        base.petAdd(new Pet(3,"Aaaa", 3, new Person("Dddd", 24, Sex.MAN)));
        base.petAdd(new Pet(4,"Cccc", 7, new Person("Aaaa", 16, Sex.MAN)));
        base.petAdd(new Pet(5,"Bbbb", 8, new Person("Cccc", 37, Sex.MAN)));
        base.petAdd(new Pet(6,"Dddd", 8, new Person("Bbbb", 23, Sex.MAN)));
        base.petAdd(new Pet(7,"Bbbb", 4, new Person("Dddd", 56, Sex.MAN)));
        base.petAdd(new Pet(8,"Cccc", 2, new Person("Aaaa", 34, Sex.MAN)));
        base.petAdd(new Pet(9,"Bbbb", 6, new Person("Bbbb", 23, Sex.MAN)));
        base.petAdd(new Pet(10,"Cccc", 1, new Person("Dddd", 53, Sex.MAN)));
        base.petAdd(new Pet(11,"Aaaa", 2, new Person("Bbbb", 43, Sex.MAN)));
        base.petAdd(new Pet(12,"Dddd", 3, new Person("Cccc", 19, Sex.MAN)));

        base.printPets();
        System.out.println("----------------------------------");
        base.editName(116554, "Aaaa");
        base.editWeight(17665565, 100);
        base.printAll();
//        base.printPets();
//        System.out.println(base.petFind("Dddd"));
//        System.out.println(base.petFind("Aaaa"));
    }
}
