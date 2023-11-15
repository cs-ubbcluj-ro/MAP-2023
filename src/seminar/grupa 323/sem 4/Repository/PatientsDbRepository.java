package Repository;

import Domain.Patient;
import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientsDbRepository  extends MemoryRepository<Patient> implements IDbRepository<Patient> {
    private String JDBC_URL = "jdbc:sqlite:database.db";

    private Connection connection;

    public PatientsDbRepository()
    {
        openConnection();
        createTable();
        //initTable();
    }

    public void openConnection() {
        SQLiteDataSource ds = new SQLiteDataSource();
        ds.setUrl(JDBC_URL);

        try {
            if (connection == null || connection.isClosed())
            {
                connection = ds.getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection()
    {
        if (connection != null)
        {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void createTable()
    {
        try (final Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS patients(id int, name varchar(400), age int);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initTable()
    {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1, "Ion Pop", 23));
        patients.add(new Patient(2, "Maria Ionescy", 25));
        patients.add(new Patient(3, "IRadu Verdea", 30));
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO patients values (?,?,?);")) {
            for (Patient p: patients)
            {
                stmt.setInt(1,p.getId());
                stmt.setString(2,p.getName());
                stmt.setInt(3,p.getAge());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Patient> getAll()
    {
        ArrayList<Patient> patients = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * from patients;")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Patient p = new Patient(rs.getInt(1), rs.getString(2), rs.getInt(3));
                patients.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patients;
    }

    public void add(Patient p)
    {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO patients values (?,?,?);")) {
            stmt.setInt(1,p.getId());
            stmt.setString(2,p.getName());
            stmt.setInt(3,p.getAge());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
