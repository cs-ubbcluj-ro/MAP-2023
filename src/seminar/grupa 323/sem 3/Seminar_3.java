import Domain.Patient;
import Domain.PatientFactory;
import Repository.DuplicateEntityException;
import Repository.FileRepository;
import Repository.IRepository;
import Service.PatientService;
import UI.Console;

import java.io.FileNotFoundException;

public class Seminar_3 {
    public static void main(String[] args) throws DuplicateEntityException, FileNotFoundException {
        //IRepository<Patient> repositoryPatient = new MemoryRepository<>();
        IRepository<Patient> repositoryPatient = new FileRepository<>("patients.txt", new PatientFactory());
        PatientService patientService = new PatientService(repositoryPatient);
        Console console = new Console(patientService);

        console.runMenu();
    }
}
