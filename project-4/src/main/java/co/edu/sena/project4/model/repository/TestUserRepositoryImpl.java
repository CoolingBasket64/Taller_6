package co.edu.sena.project4.model.repository;

import co.edu.sena.project4.model.User;

import java.sql.*;

public class TestUserRepositoryImpl {

    public static void main(String[] args) throws SQLException{
        Repository<User> repository = new UserRepositoryImpl();

        System.out.println("========== saveObj Insert ==========");
        User userInsert = new User();
        userInsert.setUser_name("santiago");
        userInsert.setUser_lastname("cardenas");
        userInsert.setUser_email("sa@gmail.com");
        userInsert.setUser_password("Sena1234");
        repository.saveObj(userInsert);
        userInsert.setUser_name("johan");
        userInsert.setUser_lastname("navarro");
        userInsert.setUser_email("johs@gmail.com");
        userInsert.setUser_password("Sena1234*");
        repository.saveObj(userInsert);
        userInsert.setUser_name("Alan");
        userInsert.setUser_lastname("Torres");
        userInsert.setUser_email("alansito@gmail.com");
        userInsert.setUser_password("Senasi1234*");
        repository.saveObj(userInsert);

        System.out.println("========== listAllObj ==========");
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== byIdObj ==========");
        System.out.println(repository.byIdObj(1));
        System.out.println();

        System.out.println("========== saveObj ==========");
        User userUpdate = new User();
        userUpdate.setUser_id(2);
        userUpdate.setUser_name("jorge");
        userUpdate.setUser_lastname("palacios");
        userUpdate.setUser_email("jorge@gmail.com");
        userUpdate.setUser_password("1234asdfg");
        repository.saveObj(userUpdate);
        repository.listAllObj().forEach(System.out::println);
        System.out.println();

        System.out.println("========== deleteObj ==========");
        repository.deleteObj(1);
        repository.listAllObj().forEach(System.out::println);
    }
}
