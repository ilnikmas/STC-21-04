package ru.innopolis.ilnikmas.stc.lesson05.task1;

public class Pet {
    private int id;
    private String name;
    private Person owner;
    private int weight;

    public Pet(int id, String name, Person owner, int weight) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.weight = weight;
    }

//    public int compareTo(Pet pet) {
//        int result = 0;
//        result = this.getName().compareTo(pet.getName());
//        if (this.getWeight() - pet.getWeight() != 0) {
//            result = this.getWeight() - pet.getWeight() > 0 ? 1 : -1;
//        }
//        result = this.getOwner().getName().compareTo(pet.getOwner().getName());
//        return result;
//    }

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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", weight=" + weight +
                '}';
    }
}
