package dao;

import Models.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

   public static String url = "jdbc:postgresql://dataoppa.cbb9i9nde4sj.us-east-2.rds.amazonaws.com/ExpenseReimbursementSystem";
    public static String username = "dataoppa";
    public static String password = "eWDang1603";

   /* public static String url = TestingDAO.url;
    public static String username = TestingDAO.username;
    public static String password = TestingDAO.password;*/

    final static Logger loggy = Logger.getLogger(UserDAOImpl.class);

    private User user;


    /**
     * Create new user and add user's information in postgresql database
     * @param user
     * @return True if new user is added
     * */
    @Override
    public boolean createUser(User user) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)\n" +
                    "VALUES (?,?,?,?,?,?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getUserEmail());
            ps.setInt(6, user.getRoleId());

            ps.executeUpdate();
            System.out.println("Successfully added new user!!!!!!!!!!!!");
            return true;

            //add an error message whenever constraints are broken <--role id or unique username+email
        } catch (SQLException e) {
            e.printStackTrace();
            loggy.error(e);
        }

        return false;
    }

    /**
     * Pass in String userName and userPassword
     * If wrong or non-exist userName and userPassword then returns null
     * @param userName, userPassword
     * @return user
     * */

    @Override
    public User checkLogin(String userName, String userPassword) {

        User user = null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "SELECT * FROM ers_users WHERE ers_username =? AND ers_password =?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, userName);
            ps.setString(2, userPassword);


            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                user = new User (
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            loggy.error(e);
        }

        //return message if user is null
        if (user == null) {
            System.out.println("------------------------------------");
            System.out.println("Wrong input!!!\nPlease try again!!!");
            System.out.println("------------------------------------");
            return null;
        }

        return user;

    }

    @Override
    public User getUserByUserName(String userName) {
        User getUser = null;

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME =?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, userName);



            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                getUser = new User (
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
                );
            }



        } catch (SQLException e) {
            e.printStackTrace();
            loggy.error(e);
        }

        return getUser;

    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "SELECT * FROM ERS_USERS;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                users.add(new User(rs.getInt(1)
                                  ,rs.getString(2)
                                  ,rs.getString(3)
                                  ,rs.getString(4)
                                  ,rs.getString(5)
                                  ,rs.getString(6)
                                  ,rs.getInt(7))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            loggy.error(e);
        }
        return users;
    }
        /**
     * Delete user based on userName
     * @param userName
     * @return
     * */

    @Override
    public boolean deleteUser(String userName) {

        try(Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "DELETE FROM ers_users WHERE ers_username = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,userName);


            return ps.executeUpdate() != 0;


        }catch(SQLException e){
            e.printStackTrace();
            loggy.error(e);
        }

        return false;

    }
}
