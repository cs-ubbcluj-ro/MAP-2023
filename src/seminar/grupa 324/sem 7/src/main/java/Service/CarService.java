package Service;

import Domain.Car;
import Repository.DuplicateEntityException;
import Repository.IRepository;

import java.util.Collection;

public class CarService {
    IRepository<Car> repository;

    public CarService(IRepository<Car> repository)
    {
        this.repository = repository;
    }

    public void add(int id, String model) throws DuplicateEntityException {
        repository.add(new Car(id, model));
    }

    public void update(int id, String model) {
        repository.update(new Car(id, model));
    }

    public void remove(int id)
    {
        repository.remove(id);
    }

    public Collection<Car> getAll()
    {
        return repository.getAll();
    }
}

