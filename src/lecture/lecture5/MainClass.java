package lecture.lecture5;

import lecture.lecture5.domain.Circle;
import lecture.lecture5.repo.BinaryFileRepository;
import lecture.lecture5.repo.IRepository;
import lecture.lecture5.repo.MemoryRepository;
import lecture.lecture5.repo.RepositoryException;

public class MainClass {
    public static void main(String[] args) {
//        IRepository<Circle> repo = new MemoryRepository<>();
        IRepository<Circle> repo = new BinaryFileRepository<>("data.bin");
        try {
            repo.add(new Circle(100, "one", 1));
            repo.add(new Circle(101, "two", 2));
            repo.add(new Circle(102, "three", 3));
        } catch (RepositoryException e) {
            // infasuram exceptia intr-un runtime exception pentru a nu pierde cauza
            throw new RuntimeException(e);
//            System.out.println(e.getMessage());
//            e.printStackTrace();
        }

        for (Circle c : repo) {
            System.out.println(c);
        }

    }
}
