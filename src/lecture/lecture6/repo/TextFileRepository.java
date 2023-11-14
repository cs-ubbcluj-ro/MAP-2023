package lecture.lecture6.repo;

import lecture.lecture6.domain.Entity;
import lecture.lecture6.domain.EntityConverter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//public class TextFileRepository extends MemoryRepository<Circle> {
//
//}


public class TextFileRepository<T extends Entity> extends MemoryRepository<T> {

    private String fileName;

    private EntityConverter<T> converter;

    public TextFileRepository(String fileName, EntityConverter<T> converter) {
        this.fileName = fileName;
        this.converter = converter;

        try {
            loadFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(T o) throws RepositoryException {
        super.add(o);
        try {
            saveFile();
        } catch (IOException e) {
            throw new RepositoryException("Error saving object", e);
        }
    }

    private void saveFile() throws IOException {
        // TODO File is rewritten at each modification :'(
        try (FileWriter fw = new FileWriter(fileName)) {
            for (T object : data) {
                fw.write(converter.toString(object));
                fw.write("\r\n");
            }
        }
    }

    private void loadFile() throws IOException {
        // delete whatever is in the repo's list
        data.clear();

        // BufferedReader - reads data ahead into a buffer :)
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null && !line.isEmpty()) {
                data.add(converter.fromString(line));
                line = br.readLine();
            }
        }
    }
}
