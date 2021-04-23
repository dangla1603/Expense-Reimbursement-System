package Driver;

import FrontControllers.FrontController;
import Models.User;
import io.javalin.Javalin;
import io.javalin.http.Context;



public class MainDriver {
    public static void main(String[] args) {

        Javalin app = Javalin.create(
                config -> {
                    config.addStaticFiles("/html-pages");
                    config.addStaticFiles("/css");
                    config.addStaticFiles("/javascript");
                    config.addStaticFiles("/images");

                }
        ).start(9060);

        FrontController fc = new FrontController(app);
    }
}
