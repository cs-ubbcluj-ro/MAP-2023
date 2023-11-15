import Domain.Patient;
import Domain.PatientFactory;
import Repository.*;
import Service.PatientService;
import UI.Console;

import java.io.FileNotFoundException;

public class Seminar3 {
    public static void main(String[] args) throws DuplicateEntityException, FileNotFoundException {
        PatientsDbRepository repositoryPatient = new PatientsDbRepository();
        PatientService patientService = new PatientService(repositoryPatient);
        Console console = new Console(patientService);

        console.runMenu();
        repositoryPatient.closeConnection();
    }
}
