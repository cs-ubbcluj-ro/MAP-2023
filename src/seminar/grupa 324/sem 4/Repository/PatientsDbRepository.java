package Repository;

import Domain.Patient;
import org.sqlite.SQLiteDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PatientsDbRepository extends MemoryRepository<Patient> {
    private String JDBC_URL = "jdbc:sqlite:patients_db.sqlite";
    Connection connection;

    public PatientsDbRepository()
    {
        openConnection();
        createTable();
        loadDataInMemory();
        //initData();
    }

    private void openConnection()
    {
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

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e. printStackTrace();
        }
    }

    private void createTable() {
        try (final Statement st = connection.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS patients(id int, name varchar(400), age int);");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void loadDataInMemory() {
        for (Patient p : getAll())
        {
            entities.add(p);
            //super.add(p);
        }
    }

    private void initData() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1, "Ion Pop", 23));
        patients.add(new Patient(2, "Alexandra Ionescu", 25));
        patients.add(new Patient(3, "Radu Oprea", 30));
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO patients VALUES (?,?,?)")) {
            for (Patient p : patients)
            {
                statement.setInt(1, p.getId());
                statement.setString(2, p.getName());
                statement.setInt(3, p.getAge());
                statement.executeUpdate();
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Collection<Patient> getAll()
    {
        List<Patient> patients = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM patients")) {
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                patients.add(new Patient(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return patients;
    }

    public void add(Patient p) throws DuplicateEntityException {
        super.add(p);
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO patients VALUES (?,?,?)")) {
            statement.setInt(1, p.getId());
            statement.setString(2, p.getName());
            statement.setInt(3, p.getAge());
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
