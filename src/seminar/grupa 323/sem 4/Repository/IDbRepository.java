package Repository;

import Domain.Patient;
import Domain.Entity;

import java.util.ArrayList;

public interface IDbRepository<T extends Entity> extends IRepository<T> {
    void openConnection();
    void closeConnection();
    void createTable();
    void initTable();
}
