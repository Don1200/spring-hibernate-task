package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);


        userService.addUser(new User("User1", "Lastname1", "user1@mail.ru",
                carService.addCar(new Car("Fiat Punto", 111))));
        userService.addUser(new User("User2", "Lastname2", "user2@mail.ru",
                carService.addCar(new Car("Renault Sandero Stepwey", 222))));
        userService.addUser(new User("User3", "Lastname3", "user3@mail.ru",
                carService.addCar(new Car("Renault Duster", 321))));
        userService.addUser(new User("User4", "Lastname4", "user4@mail.ru",
                carService.addCar(new Car("Renault Duster", 333))));


        System.out.println(userService.getUserByCarNumberAndSeries("Renault Duster", 333));

        System.out.println(userService.listUsers());

        userService.listUsers();

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car model = " + user.getCar().getModel());
            System.out.println("Car series = " + user.getCar().getSeries());
            System.out.println();
        }

        context.close();
    }
}
