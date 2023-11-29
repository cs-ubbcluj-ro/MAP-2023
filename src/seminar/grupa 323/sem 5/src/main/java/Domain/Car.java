package Domain;

public class Car extends Entity{
    private String model;

    public Car(int id, String model) {
        super(id);
        this.model = model;
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
        return "id: " + id + ", model: " + model;
    }
}
