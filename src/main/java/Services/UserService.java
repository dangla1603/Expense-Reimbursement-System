package Services;

import Models.User;

public interface UserService {

    //CREATE
    public boolean createUser(User user);

    //READ
    public User checkLogin(String userName, String userPassword);

    //UPDATE

    //DELETE
    public boolean deleteUser(String userName);
}
