package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> showListUsers();

    public User getUserByCarNumberAndSeries(String carModel, int carSeries);

}
