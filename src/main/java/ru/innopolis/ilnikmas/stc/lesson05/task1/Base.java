package ru.innopolis.ilnikmas.stc.lesson05.task1;

import java.util.*;

/**
 * Класс - картотека домашних животных
 * @author Маслёнченко И. Н.
 */
class Base {
    private Map<Integer, Pet> petList = new HashMap<>();
    private Map<String, List<Pet>> indexList = new HashMap<>();

    /**
     * Метод добавления животного в картотеку
     * @param pet
     */
    void petAdd(Pet pet){
        try {
            if (petList.putIfAbsent(pet.getId(), pet) != null)
            throw new PetDuplicateException("Животное с данным id уже есть: " + pet.getId());
            //Заполнение индекса
            List<Pet> indexPet = indexList.getOrDefault(pet.getName(), new ArrayList<>());
            indexPet.add(pet);
            indexList.put(pet.getName(), indexPet);
            //
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
        return indexList.get(petName);
    }

    /**
     * Метод, изменяющий параметры животного
     * @param id
     * @param newName
     */
    void editName(Integer id, String newName) {
        try {
            if (petList.containsKey(id)) {
                Pet pet = petList.get(id);
                String oldName = petList.get(id).getName();
                List<Pet> list = new ArrayList<>(indexList.get(oldName));
                if (!"".equals(newName)) {
                    petList.remove(id, pet);
                    list.remove(pet);
                    pet.setName(newName);
                    petAdd(pet);
                    indexList.remove(oldName);
                    indexList.put(oldName, list);
                    for (Map.Entry entry : indexList.entrySet()) {
                        System.out.println(entry);
                    }
                } else throw new Exception("Введённый id не существует!");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    void editWeight(Integer id, Integer newWeight) {
        try {
            if (petList.containsKey(id)) {
                Pet pet = petList.get(id);
                List<Pet> list = new ArrayList<>(indexList.get(pet.getName()));
                if (newWeight != null) {
                    petList.remove(id, pet);
                    list.remove(pet);
                    pet.setWeight(newWeight);
                    list.add(pet);
                    petAdd(pet);
                    indexList.remove(pet.getName());
                    indexList.put(pet.getName(), list);
                    for (Map.Entry entry : indexList.entrySet()) {
                        System.out.println(entry);
                    }
                } else throw new Exception("Введённый id не существует!");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
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

    void printAll(){
        for (Map.Entry entry : petList.entrySet()){
            System.out.println(entry);
        }
    }

}
