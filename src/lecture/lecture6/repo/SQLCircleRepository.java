package lecture.lecture6.repo;

import lecture.lecture6.domain.Circle;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLCircleRepository extends MemoryRepository<Circle> {

    private final String dbLocation;

    private Connection conn = null;

    public SQLCircleRepository(String dbLocation) throws RepositoryException {
        this.dbLocation = "jdbc:sqlite:" + dbLocation;
        initDbConnection();
        createSchema();
    }


    private void initDbConnection() throws RepositoryException {
        try {
            // with DataSource
            SQLiteDataSource ds = new SQLiteDataSource();
            ds.setUrl(dbLocation);
            if (conn == null || conn.isClosed())
                conn = ds.getConnection();
        } catch (SQLException e) {
            throw new RepositoryException("Error creating DB connection", e);
        }
    }

    void createSchema() throws RepositoryException {
        try {
            try (final Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS circles(id int, name varchar(200), radius float);");
            }
        } catch (SQLException e) {
            throw new RepositoryException("Error creating DB schema", e);
        }
    }

}
