package Repository;

import Domain.Entity;
import Domain.IEntityFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRepository<T extends Entity> extends MemoryRepository<T> {
    private String fileName;
    private IEntityFactory<T> entityFactory;

    public FileRepository(String fileName, IEntityFactory<T> entityFactory) throws FileNotFoundException, DuplicateEntityException {
        this.fileName = fileName;
        this.entityFactory = entityFactory;

        readFromFile();
    }

    private void readFromFile() throws FileNotFoundException, DuplicateEntityException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            T entity = entityFactory.createEntity(line);
            add(entity);
        }
        scanner.close();
    }
}
