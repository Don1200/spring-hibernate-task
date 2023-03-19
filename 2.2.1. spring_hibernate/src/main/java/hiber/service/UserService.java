package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getUser_By_Car_Number_And_Series(String carModel, int carSeries);
}
