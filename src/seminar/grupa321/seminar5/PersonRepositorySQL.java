package seminar.grupa321.seminar5;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa foloseste o baza de date ca si data store
 * <p>
 * 1. Cand pornesc repo-ul, vreau ca datele sa fie incarcate din SQL (le incarc in constructor)
 * 2. Cand modific datele din repo, le salvez in SQL (add/remove)
 */
public class PersonRepositorySQL {

    private static final String JDBC_URL = "jdbc:sqlite:persons.db";

    private Connection conn = null;

    private List<Person> data = new ArrayList<>();

    public PersonRepositorySQL() {
        openConnection();
        createSchema();

    }

    private void openConnection() {
        try {
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl(JDBC_URL);
            if (conn == null || conn.isClosed())
                conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createSchema() {
        try {
            try (final Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS persons(name varchar(400), age int);");
            }
        } catch (SQLException e) {
            System.err.println("[ERROR] createSchema : " + e.getMessage());
        }
    }

    void add(Person p) throws SQLException {
        this.data.add(p);

        try (PreparedStatement statement = conn.prepareStatement("INSERT INTO persons VALUES (?, ?)")) {
            statement.setString(1, p.getName());
            statement.setInt(2, p.getAge());
            statement.executeUpdate();
        }
    }

    List<Person> getAll() {
        return data;
    }

}
