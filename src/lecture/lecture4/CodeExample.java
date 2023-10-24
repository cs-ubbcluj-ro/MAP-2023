package lecture.lecture4;


import lecture.lecture4.repo.Repository;
import lecture.lecture4.repo.RepositoryException;

public class CodeExample {
    public static void main(String[] args) throws RepositoryException {

        Repository repo = new Repository();
        repo.add(new Circle("first circle", 20));
        repo.add(new Circle("second circle", 10));
        repo.add(new Circle("first circle", 20));


    }
}
