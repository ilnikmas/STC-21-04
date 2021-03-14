package ru.innopolis.ilnikmas.stc.lesson05.task1;

import java.util.*;

public class DataBase {
   Map<Integer, Pet> dataBase = new HashMap<>();

    public void petAdd(Pet pet) {
        dataBase.put(pet.getId(), pet);
    }

    public Pet petFind(String name) {
        Pet result = null;
        for (Map.Entry<Integer, Pet> entry : dataBase.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                result = entry.getValue();
            }
        }
        return result;
    }

    public void petList() {
        List<Pet> sorted = new ArrayList<>(dataBase.values());
        for (Pet p : sorted) {
            System.out.println(p);
        }
        System.out.println("---------------------------------");
        Collections.sort(sorted, Comparator.comparing(Pet::getName).thenComparing(Pet::getWeight));
//        for (Map.Entry<Integer, Pet> entry : dataBase.entrySet()) {
//            System.out.println(entry.toString());
//        }
        for (Pet p : sorted) {
            System.out.println(p);
        }
    }

}
