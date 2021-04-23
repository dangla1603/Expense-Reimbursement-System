package FrontControllers;

import Controllers.ReimbursementController;
import Controllers.UserController;
import Models.Reimbursement;
import Models.User;
import io.javalin.Javalin;
import io.javalin.http.Context;

import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.get;

/**
 *  Responsible for receiving and transmitting pure and reliable messages
 *
 * */

public class Dispatcher {

    Javalin app;
    UserController userController;

    public Dispatcher(Javalin app){
        this.app = app;
        userController = new UserController(app);
        allRoute();
    }

    private void allRoute() {
        userRoutes();
        webRoutes();
        logOutRoutes();
        ticketRoutes();
    }

    private void userRoutes() {
        app.routes(() -> {
            path("/api/user", () -> {
                post(UserController::getAllUsers);
            });
        });

    }

    public void webRoutes(){
        app.routes(() -> {
            path("/login", () -> {
                post(UserController::checkCredentials);
            });
            path("/getUser",() ->{
                get(UserController::getUser);
            });
            path("/register",() -> {
                post(UserController::createUser);
            });
        });
    }

    public void logOutRoutes(){
        app.routes(() ->{
            path("/logout",()->{
                get(UserController::logOut);
            });
        });
    }

    public void ticketRoutes(){
        app.routes(() ->{
            path("/ticket",()->{
                path("/list",()->{
                    get(ReimbursementController::getUserTickets);
                });
                path("/add",()->{
                    post(ReimbursementController::createTicket);
                });
                path("/allTickets",()->{
                    get(ReimbursementController::selectAllTickets);
                });
                path("/updateTicket",()->{
                    post(ReimbursementController::updateTickets);
                });
            });
        });
    }
}
