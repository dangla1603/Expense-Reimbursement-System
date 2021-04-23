package Controllers;

import dao.UserDAO;
import dao.UserDAOImpl;
import Models.User;
import io.javalin.Javalin;
import io.javalin.http.Context;


import java.util.List;

public class UserController {

    Javalin app;

    static UserDAO userDAO = new UserDAOImpl();


    //CONSTRUCTOR
    public UserController(Javalin app){
        this.app = app;
    }


    //ROUTES
    public static void getAllUsers(Context context){
        List<User> users = userDAO.getAllUser();
        context.json(users);
    }


    /**
     * Log-in Method
     * check credentials of user
     * then redirect to page
     * @param ctx
     * */
    public static void checkCredentials(Context ctx){

        String thisUsername = ctx.formParam("thatUsername");
        String thisPassword = ctx.formParam("thatPassword");

        /*String username = "admin";
        String password = "password";*/
        System.out.println(thisUsername);
        System.out.println(thisPassword);
        User user = userDAO.checkLogin(thisUsername, thisPassword);

        System.out.println(user);

        if(user != null){
            ctx.sessionAttribute("currentUser",user);
            if(user.getRoleId()==1){
                System.out.println("Verified as an employee");
                ctx.redirect("/employee.html");
            }else{
                System.out.println("Verified as an manager");
                ctx.redirect("/manager.html");
            }
        }else{
           ctx.json("Wrong credentials");
            System.out.println("Wrong credentials ");
            /*ctx.sessionAttribute("WrongcheckCredentials","wrong")*/
            ctx.redirect("/index.html");

//            ctx.redirect("/index.html");
        }


    }




    /**
     * Getting user Information
     * @param ctx
     *
     * */
    public static void getUser(Context ctx){
        User user = ctx.sessionAttribute("currentUser");
        ctx.json(user);
    }

    /**
     * Create new user information using formParam() method
     * @param ctx
     * */

    public static void createUser(Context ctx){
        String username = ctx.formParam("thatNewUserName");
        String password = ctx.formParam("thatNewPassword");
        String firstName = ctx.formParam("thatNewFirstName");
        String lastName = ctx.formParam("thatNewLastName");
        String email = ctx.formParam("thatNewEmail");
        int role = Integer.parseInt(ctx.formParam("statusId"));

        User user = new User(username,password,firstName,lastName,email,role);

        // check if user is exist
        User thisUser = userDAO.getUserByUserName(username);

        if(thisUser != null){
            ctx.sessionAttribute("feedback","This account is exist");
            System.out.println("this account is exist");
            ctx.redirect("/registerPage.html");
        }else{
            userDAO.createUser(user);
            ctx.sessionAttribute("feedback",null);
            ctx.redirect("/index.html");
        }
    }

    /**
     * Log-out Method
     * @param ctx
     *
     * */
    public static void logOut(Context ctx){
        ctx.sessionAttribute("currentUser",null);
        /*ctx.result("Bye ! See you next time !");*/
        /*ctx.redirect("/index.html");*/
    }
}
