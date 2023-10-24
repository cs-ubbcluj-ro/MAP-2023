package seminar.grupa322.seminar2.repository;

import org.junit.jupiter.api.Test;
import seminar.grupa322.seminar2.domain.Patient;

public class RepositoryTest {

    private final Repository<Patient> repo;
    private final Patient dummyPacient;

    public RepositoryTest() {
        this.repo = new Repository<Patient>();
        this.dummyPacient = new Patient(1, "ag", 3);
        this.repo.add(new Patient(1, "ag", 3));
    }

    @Test
    public void doAddAndGetTest() {
        // FIXME failing test
        assert this.repo.getById(1).equals(dummyPacient);
    }

    @Test
    public void doDelete() {
        // FIXME failing test
        this.repo.delete(dummyPacient);
        assert this.repo.size() == 0;
    }
}
