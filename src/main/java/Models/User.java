package Models;

public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String userEmail;
    private int roleId;
    private int userId;


    /**
     * CONSTRUCTORS
     * No-arg Constructors
     * All instance Constructors
     * some customized Constructor
     * */
    public User(){}

    public User(String username,String password){
        this.username = username;
        this.password = password;

    }
    public User (String username, String password, String firstName, String lastName, String userEmail, int roleId){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.roleId = roleId;
    }

    public User (int userId, String username, String password, String firstName,String lastName, String userEmail,int roleId ){
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.roleId = roleId;
    }


    /**
     *  GETTER & SETTER for variables
     *
     * */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }



 /*   @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", roleId=" + roleId +
                ", userId=" + userId +
                '}';
    }*/

    @Override
    public String toString() {
        return "\nUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", roleId=" + roleId +
                ", userId=" + userId +
                '}';
    }
}
