package seminar.grupa321.seminar5;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        PersonRepositorySQL repo = new PersonRepositorySQL();
//        repo.add(new Person("Popescu Anca", 30));
//        repo.add(new Person("Popescu Ionut", 29));
//        repo.add(new Person("Popescu Mirel", 3));

        for (var p : repo.getAll()) {
            System.out.println(p);
        }


    }
}