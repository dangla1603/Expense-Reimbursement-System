package Services;

import dao.UserDAO;
import dao.UserDAOImpl;
import Models.User;

public class UserServiceImpl implements UserService{

    UserDAO userDAO = new UserDAOImpl();


    /**
     * Create new user
     * @param user
     * @return user
     * */
    @Override
    public boolean createUser(User user) {
        return userDAO.createUser(user);
    }


    /**
     * Validate Credentials
     * @param userName, userPassword
     * @return
     * */
    @Override
    public User checkLogin(String userName, String userPassword) {
        return userDAO.checkLogin(userName,userPassword);
    }


    /**
     * Delete existing user
     * @param userName
     * @return true if successful
     * */
    @Override
    public boolean deleteUser(String userName) {
        return userDAO.deleteUser(userName);
    }
}
