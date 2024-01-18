package Service;

import Domain.Car;
import Domain.Rent;
import Repository.DuplicateEntityException;
import Repository.IRepository;

import java.util.Collection;
import java.util.Date;

public class RentService {
    IRepository<Rent> repository;

    public RentService(IRepository<Rent> repository)
    {
        this.repository = repository;
    }

    public void add(int id, int carId, Date startDate, Date endDate) throws DuplicateEntityException {
        repository.add(new Rent(id, carId, startDate, endDate));
    }

    public void update(int id, int carId, Date startDate, Date endDate) {
        repository.update(new Rent(id, carId, startDate, endDate));
    }

    public void remove(int id)
    {
        repository.remove(id);
    }

    public Collection<Rent> getAll()
    {
        return repository.getAll();
    }
}
