import Domain.IEntityFactory;
import Domain.Patient;
import Domain.PatientFactory;
import Repository.DuplicateEntityException;
import Repository.FileRepository;
import Repository.IRepository;
import Repository.MemoryRepository;
import Service.PatientService;
import UI.Console;

import java.io.FileNotFoundException;

public class Seminar3 {
    public static void main(String[] args) throws DuplicateEntityException, FileNotFoundException {
       //IRepository<Patient> patientRepository = new MemoryRepository<>();
        IEntityFactory<Patient> patientFactory = new PatientFactory();
        IRepository<Patient> patientRepository = new FileRepository<>("patients.txt",patientFactory);
        PatientService patientService = new PatientService(patientRepository);
        Console console = new Console(patientService);

        console.runMenu();
    }
}
