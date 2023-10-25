package seminar.grupa322.seminar2;

import seminar.grupa322.seminar2.domain.Patient;
import seminar.grupa322.seminar2.repository.Repository;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
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

        FileWriter fw = new FileWriter("patient.txt");
        int index = 0;
        for (var pacientIn : repository) {
            System.out.println(pacientIn);
            // 1. Fisiere text
            // Input/Output Stream -- fisiere binare
            // Reader/Writer -- fisiere text
            fw.write(pacientIn.toString());
            fw.write("\n");

            // 2. Serializarea
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("patient_" + index + ".binary"));
            oos.writeObject(pacientIn);
            oos.close();
            index += 1;
        }
        fw.close();

    }
}