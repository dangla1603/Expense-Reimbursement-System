package FrontControllers;

import io.javalin.Javalin;

public class FrontController {

    Javalin app;
    Dispatcher dispatcher;

    //Constructor
    public FrontController(Javalin app){
        this.app = app;

        dispatcher = new Dispatcher(app);
    }
}
