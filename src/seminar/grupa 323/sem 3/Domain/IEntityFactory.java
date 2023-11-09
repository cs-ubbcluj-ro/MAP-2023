package Domain;

public interface IEntityFactory<T extends Entity> {
    public T createEntity(String line);
}
