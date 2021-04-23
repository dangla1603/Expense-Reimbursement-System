package dao;

import Models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOImplTest {

    UserDAOImpl userDAO = new UserDAOImpl();


    @BeforeEach
    void setUp() {
        TestingDAO.h2InitDao();
    }

    @AfterEach
    void tearDown() {
        TestingDAO.h2DestroyDao();
    }

    @Test
    void createUser() {
        assertTrue(userDAO.createUser(new User("test1", "password", "test2", "test3", "testing@gmail.com", 1)));

    }

    @Test
    void checkLogin() {
        User user = userDAO.getUserByUserName("dangla");
        System.out.println(user);
        assertEquals(user.toString(), userDAO.checkLogin("dangla","la").toString());

    }

    @Test
    @Disabled
    void deleteUser() {
        User employee = new User("test5","password","test6","test7","testing2@gmail.com",1);
        userDAO.createUser(employee);
        assertTrue(userDAO.deleteUser(employee.getUsername()));
    }
}