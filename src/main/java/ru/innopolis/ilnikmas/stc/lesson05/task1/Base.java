package ru.innopolis.ilnikmas.stc.lesson05.task1;

import java.util.*;

/**
 * Класс - картотека домашних животных
 * @author Маслёнченко И. Н.
 */
class Base {
    private Map<Integer, Pet> petList = new HashMap<>();

    /**
     * Метод добавления животного в картотеку
     * @param pet
     */
    void petAdd(Pet pet){
        try {
            if (petList.putIfAbsent(pet.getId(), pet) != null)
            throw new PetDuplicateException("Животное с данным id уже есть: " + pet.getId());
        } catch (PetDuplicateException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод поиска животного в картотеке по его имени
     * @param petName
     * @return список животных с именем petName
     */
    List<Pet> petFind(String petName){
        List<Pet> foundPet = new ArrayList<>();
        for (Map.Entry<Integer, Pet> entry : petList.entrySet()) {
            if (entry.getValue().getName().equals(petName)) {
                foundPet.add(entry.getValue());
            }
        }
        return foundPet;
    }

    /**
     * Метод, изменяющий параметры животного
     * @param id
     * @param name
     * @param weight
     */
    void petEdit(int id, String name, int weight){
        if (!name.equals("")) petList.get(id).setName(name);
        if (weight != 0) petList.get(id).setWeight(weight);
    }


    /**
     * Метод вывода в консоль отсортированного списка животных
     */
    void printPets(){
        List<Pet> list = new ArrayList<>(petList.values());
        Collections.sort(list, Comparator.comparing(Pet::getName).thenComparing(Pet::getWeight));
        for (Pet pet : list) {
            System.out.println(pet);
        }
    }

}
