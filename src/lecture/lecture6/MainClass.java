package lecture.lecture6;

import lecture.lecture6.domain.Circle;
import lecture.lecture6.domain.CircleConverter;
import lecture.lecture6.domain.EntityConverter;
import lecture.lecture6.repo.*;

import java.io.IOException;
import java.util.Objects;

public class MainClass {
    public static void main(String[] args) throws IOException, RepositoryException {

//        Properties settings = new Properties();
//        settings.put("repo_type", "memory");
//        settings.put("repo_file", "none");
//
//        try (FileWriter fw = new FileWriter("settings.properties")) {
//            settings.store(fw, "no comment");
//        }

//        try (FileReader fr = new FileReader("settings.properties")) {
//            Properties settings = new Properties();
//            settings.load(fr);
//
//            System.out.println(settings);
//        }

        IRepository<Circle> repo = null;
        EntityConverter<Circle> ec = new CircleConverter();

        Settings setari = Settings.getInstance();
        if (Objects.equals(setari.getRepoType(), "memory")) {
            repo = new MemoryRepository<>();
        }

        if (Objects.equals(setari.getRepoType(), "text")) {
            repo = new TextFileRepository<>(setari.getRepoFile(), ec);
        }

        if (Objects.equals(setari.getRepoType(), "db")) {
            repo = new SQLCircleRepository(setari.getRepoFile());
        }

//        IRepository<Circle> repo = new MemoryRepository<>();


//        IRepository<Circle> repo = new BinaryFileRepository<>("data.bin");
//        IRepository<Circle> repo = new TextFileRepository<>("data.txt", ec);


//        try {
//            repo.add(new Circle(100, "one", 1));
//            repo.add(new Circle(101, "two", 2));
//            repo.add(new Circle(102, "three", 3));
//            repo.add(new Circle(103, "four", 4));
//        } catch (RepositoryException e) {
//            e.printStackTrace();
//        }


        for (Circle c : repo) {
            System.out.println(c);
        }

    }
}
