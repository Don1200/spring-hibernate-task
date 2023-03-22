package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImp implements CarDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Car addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
        return car;
    }
}
