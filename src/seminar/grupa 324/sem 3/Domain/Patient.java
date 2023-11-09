package Domain;

import Domain.Entity;

public class Patient extends Entity {
    private String name;
    private int age;

    public Patient(int ID, String name, int age) {
        super(ID);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString()
    {
        return "Id: " + id + ", Name: " + name + ", Age: " + age;
    }
}