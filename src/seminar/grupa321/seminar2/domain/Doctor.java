package seminar.grupa321.seminar2.domain;

import java.util.ArrayList;

class Doctor extends Entity {
    String name;
    String field;
    ArrayList<Patient> patients;

    public Doctor(int id) {
        super(id);
    }

    public Doctor(int ID, String name, String field, ArrayList<Patient> patients) {
        super(ID);
        this.name = name;
        this.field = field;
        this.patients = patients;
    }

    public void addPatient(Patient p) {
        this.patients.add(p);
    }
}
