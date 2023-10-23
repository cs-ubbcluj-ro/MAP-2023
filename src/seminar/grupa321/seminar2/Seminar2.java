package seminar.grupa321.seminar2;

import seminar.grupa321.seminar2.domain.Patient;
import seminar.grupa321.seminar2.repository.Repository;


//Barac Sebastian Beniamin

public class Seminar2 {
    /*

    1. Scriem o clasă abstractă numită Entity și care are un câmp ID de tip int
        - ID este câmp protected
        - ID e setat prin constructorul clasei
        - ID poate fi citit prin getID()

    2. Scriem o clasă Patient (non-abstractă) derivată din clasa Entity
        - name e câmp de tip String
        - age câmp de tip int

    3. Scriem o clasă Doctor (non-abstractă) derivată din clasa Entity
        - name e câmp de tip String
        - field de tip String (ENT, cardiology, etc.)
        - listă de pacienți (ArrayList<Patient>)

    4. Clasa Repository<T> generică (T va fi ori Patient, ori Doctor)
        - un câmp ArrayList<T> în care stocăm entitățile domeniului
        - adăugare entitate
        - căutare după id
        - ștergere
        - cum facem clasa asta să fie nice :) --» implementăm java.util.Iterable<T>
     */

    public static void main(String[] args) {
        Repository<Patient> repo = new Repository<>();

        repo.addEntity(new Patient(1000, "Popescu Marius", 42));
        repo.addEntity(new Patient(1001, "Ionescu Ana", 80));
        repo.addEntity(new Patient(1002, "Zaris Oana", 12));
        repo.addEntity(new Patient(1003, "Albu Iulian Ioan", 50));

        for (Object p : repo) {
            System.out.println(p);
        }
    }
}
