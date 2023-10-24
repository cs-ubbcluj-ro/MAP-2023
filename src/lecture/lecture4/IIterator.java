package lecture.lecture4;

public interface IIterator<T> {
    public T getValue();

    public boolean isValid();

    public void nextNode();
}
