package lecture.lecture5.repo;

import lecture.lecture5.domain.Entity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BinaryFileRepository<T extends Entity> extends MemoryRepository<T> {
    private String fileName;

    public BinaryFileRepository(String fileName) {
//        super();
        this.fileName = fileName;
        loadFile();
    }


    @Override
    public void add(T o) throws RepositoryException {
        super.add(o);
        // saveFile se executa doar daca super.add() nu a aruncat exceptie
        try {
            saveFile();
        } catch (IOException e) {
            throw new RepositoryException("Error saving file " + e.getMessage());
        }
    }

    private void loadFile() {

    }


    private void saveFile() throws IOException {
        // FIXME try with resources
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"));
        oos.writeObject(oos);
    }

}
