package Service;

import Domain.Patient;
import Repository.DuplicateEntityException;
import Repository.IRepository;

import java.util.Collection;

public class PatientService {
    IRepository<Patient> repository;

    public PatientService(IRepository<Patient> repository)
    {
        this.repository = repository;
    }

    public void add(int id, String name, int age) throws DuplicateEntityException {
        repository.add(new Patient(id, name, age));
    }

    public Collection<Patient> getAll()
    {
        return repository.getAll();
    }
}
