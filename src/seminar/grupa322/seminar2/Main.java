package seminar.grupa322.seminar2;

import seminar.grupa322.seminar2.domain.Patient;
import seminar.grupa322.seminar2.repository.Repository;

public class Main {
    public static void main(String[] args) {
        Repository<Patient> repository = new Repository<Patient>();
        Patient pacient = new Patient(1, "a b", 1);
        Patient pacient1 = new Patient(2, "d b", 1);
        Patient pacient2 = new Patient(3, "ag b", 1);
        Patient pacient3 = new Patient(4, "ags b", 1);
        Patient pacient4 = new Patient(5, "aasasd b", 1);
        repository.add(pacient);
        repository.add(pacient1);
        repository.add(pacient2);
        repository.add(pacient3);
        repository.add(pacient4);

        for (var pacientIn : repository) {
            System.out.println(pacientIn);
        }

    }
}