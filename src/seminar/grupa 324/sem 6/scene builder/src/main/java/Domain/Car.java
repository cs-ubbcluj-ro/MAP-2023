package Domain;

public class Car extends Entity{
    private String model;

    public Car(int id, String model) {
        super(id);
        this.model = model;
    }

    public Car(String line) {
        super(Integer.parseInt(line.split(",")[0]));
        model = line.split(",")[1];
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString()
    {
        return "Id: " + id + ", model: " + model;
    }

    public String toFileString() {
        return id + "," + model;
    }
}
