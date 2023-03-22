package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> showListUsers() {
        return userDao.showListUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByCarNumberAndSeries(String carModel, int carSeries) {
        return userDao.getUserByCarNumberAndSeries(carModel, carSeries);
    }


}








