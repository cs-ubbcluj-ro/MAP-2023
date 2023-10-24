package seminar.grupa322.seminar2;

public class Seminar2 {
    /*
    1. Scriem o clasă abstractă numită Entity și care are un câmp ID de tip int
        - ID este câmp protected
        - ID e setat prin constructorul clasei
        - ID poate fi citit prin getID()

    2. Scriem o clasă Patient (non-abstractă) derivată din clasa Entity
        - name e câmp de tip String
        - age câmp de tip int

    3. Scriem o clasă PatientTest (clasă de testare cu JUnit)
        - 2 metode de test (setteri/getteri, nume, vârstă)
        - rulăm testul folosind JUnit

    4. Clasa Repository<T> generică (T va fi de regula Patient)
        - un câmp ArrayList<T> în care stocăm entitățile domeniului
        - adăugare entitate
        - căutare după id
        - ștergere
        - cum facem clasa asta să fie nice :) --» implementăm java.util.Iterable<T>

    5. Clasa RepositoryTest (clasă de testare cu JUnit)
        - 3 metode de testare

    6. Metoda main
        - adaugat 5 pacienti din cod
        - iterat peste repository
        for (Patient p : myRepo) { System.out.println(p); }

    7. Fisiere !!??
     */
}
