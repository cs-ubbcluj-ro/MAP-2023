package seminar.grupa321.seminar3;

import seminar.grupa321.seminar3.Patient;
import seminar.grupa321.seminar3.repo.IRepository;
import seminar.grupa321.seminar3.repo.MemoryRepository;
import seminar.grupa321.seminar3.repo.RepositoryException;

public class Seminar3 {
    /*

    1. Aveti la dispozitie interfata IRepository<T extends Entity> extends Iterable<T>
                           clasa abstracta AbstractRepository<T extends Entity> extends IRepository<T>
    2. Implementati clasa MemoryRepository<T extends Entity> extends AbstractRepository<T>
            - functioneaza cu clasele Patient si Doctor din Seminar 2

    3. De scris un JUnit test MemoryRepositoryTest si rulat ca si test + run with coverage

    4. Implementati clasa TextFileRepository <T extends Entity> extends MemoryRepository<T>
                (FileWriter/FileReader)
                !!!??? cum reprezentam T in fisier ???!!!
                remember: try with resources

    5. Implementati clasa BinaryFileRepository <T extends Entity> extends MemoryRepository<T>
                (ObjectOutputStream/ObjectInputStream)

    6. Stabilim ce repository folosim printr-un fisier de setari

    7. Wishful thinking -- service, ui, trick || treat !
     */

    public static void main(String[] args) throws RepositoryException {
        IRepository<Patient> repo = new MemoryRepository<>();
        repo.add(new Patient(100, "Popescu Marian", 40));
        repo.add(new Patient(101, "Balan Anca", 20));

        for (Patient p : repo) {
            System.out.println(p);
        }
    }
}
