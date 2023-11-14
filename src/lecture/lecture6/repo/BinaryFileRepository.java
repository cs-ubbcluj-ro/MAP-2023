package lecture.lecture6.repo;

import lecture.lecture6.domain.Entity;

import java.io.*;
import java.util.List;

public class BinaryFileRepository<T extends Entity> extends MemoryRepository<T> {
    private String fileName;

    public BinaryFileRepository(String fileName) {
//        super();
        this.fileName = fileName;
        try {
            loadFile();
        } catch (IOException | ClassNotFoundException e) {
            // not very good practice
            throw new RuntimeException(e);
        }
    }


    @Override
    public void add(T o) throws RepositoryException {
        super.add(o);
        // saveFile se executa doar daca super.add() nu a aruncat exceptie
        try {
            saveFile();
        } catch (IOException e) {
            throw new RepositoryException("Error saving file " + e.getMessage(), e);
        }
    }

    @Override
    public void remove(int id) {
        super.remove(id);
        // TODO De serioalizat lista de obiecte
    }

    private void loadFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            this.data = (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            // TODO Replace with logging
            System.out.println("Repo starting a new file");
        } finally {
            // finally se executa tot timpul
            if (ois != null)
                ois.close();
        }


    }


    private void saveFile() throws IOException {
        // try-with-resources
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        }

//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
//
//        oos.close();
    }

}
