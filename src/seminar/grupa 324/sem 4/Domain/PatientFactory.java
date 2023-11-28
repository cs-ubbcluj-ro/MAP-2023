package Domain;

public class PatientFactory implements IEntityFactory<Patient>{
    @Override
    public Patient createEntity(String line) {
        int id = Integer.parseInt(line.split(",")[0]);
        String name = line.split(",")[1];
        int age = Integer.parseInt(line.split(",")[2]);

        return new Patient(id, name, age);
    }
}
