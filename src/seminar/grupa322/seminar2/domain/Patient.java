package seminar.grupa322.seminar2.domain;

import java.io.Serializable;

public class Patient extends Entity implements Serializable {

    // TODO Change value when class is updated
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Patient(int ID, String name, int age) {
        super(ID);
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ID=" + ID +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Patient(int ID) {
        super(ID);
    }
}