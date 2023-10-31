package seminar.grupa321.seminar3.test;

import org.junit.jupiter.api.Test;
import seminar.grupa321.seminar3.Patient;
import seminar.grupa321.seminar3.repo.IRepository;
import seminar.grupa321.seminar3.repo.MemoryRepository;
import seminar.grupa321.seminar3.repo.RepositoryException;

// Apavaloaie Tudor
//Andreica David & Andries Andrei

public class MemoryRepositoryTest {

    @Test
    public void testAdd() throws RepositoryException {
        IRepository<Patient> data = new MemoryRepository<>();
        data.add(new Patient(100, "pop", 40));
        data.add(new Patient(101, "dan", 33));
        assert data.getAll().size() == 2;
    }

    @Test
    public void testAdd2() {
        IRepository<Patient> repo = new MemoryRepository<Patient>();
        try {
            repo.add(new Patient(1, "Mircea", 18));
            //repo.add(new Patient(1,"Mircea",18));
        } catch (RepositoryException e) {
            // Aici nu are trebui sa apara erori
            assert false;
        }
    }
}

