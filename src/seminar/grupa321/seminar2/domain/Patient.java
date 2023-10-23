package seminar.grupa321.seminar2.domain;

public class Patient extends Entity {
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
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}