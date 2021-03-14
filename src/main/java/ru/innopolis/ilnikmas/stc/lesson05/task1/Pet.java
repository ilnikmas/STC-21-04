package ru.innopolis.ilnikmas.stc.lesson05.task1;

/**
 * Класс Pet, описывающий животное
 * @author Маслёнченко И. Н.
 */
public class Pet {
    private int id;
    private String name;
    private int weight;
    private Person owner;

    public Pet(int id, String name, int weight, Person owner) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight + '\'' +
                ", owner=" + owner.getName() + '\'' +
                '}';
    }
}
