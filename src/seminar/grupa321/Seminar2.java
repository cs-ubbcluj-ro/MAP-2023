package seminar.grupa321;

import java.util.ArrayList;


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
}
