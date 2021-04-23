package dao;

import Models.User;

import java.util.List;

public interface UserDAO {

    //CRUD Methods

    //CREATE
    public boolean createUser(User user);

    //READ
    public User checkLogin(String userName, String userPassword);
    public User getUserByUserName (String userName);
    public List<User> getAllUser();


    //UPDATE

    //DELETE
    public boolean deleteUser(String userName);





}
