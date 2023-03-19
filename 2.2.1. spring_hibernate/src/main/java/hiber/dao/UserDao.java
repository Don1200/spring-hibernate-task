package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    public User getUser_By_Car_Number_And_Series(String carModel, int carSeries);

}
