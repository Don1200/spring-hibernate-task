package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> showListUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByCarNumberAndSeries(String carModel, int carSeries) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car where model = :car_model and series = :car_series")
                .setParameter("car_model", carModel)
                .setParameter("car_series", carSeries);

        List<Car> findCarList = query.getResultList();
        List<User> userList = showListUsers();


        for (User user : userList)
            for (Car car : findCarList) {
                if (user.getCar().getSeries() == car.getSeries() && Objects.equals(user.getCar().getModel(), car.getModel())) {
                    return user;
                }
            }
        System.out.println("Юзверя с таким автомобилем пока не существует!!!!");
        return null;
    }
}










