package Controllers;

import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;
import Models.Reimbursement;
import Models.User;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class ReimbursementController {

    Javalin app;
    static ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();

    //Constructor
    public ReimbursementController(Javalin app) {
        this.app = app;
    }


    public static void createTicket(Context ctx){

        System.out.println("Creating new ticket");
        User user = ctx.sessionAttribute("currentUser");

        int type = Integer.parseInt(ctx.formParam("type"));
        int amount = Integer.parseInt(ctx.formParam("amount"));
        String description = ctx.formParam("description");
        Reimbursement newTicket = new Reimbursement(amount,description,user.getUserId(),1,type);

        System.out.println(newTicket.toString());

        reimbursementDAO.addTicket(newTicket);


        ctx.redirect("/employee.html");

    }

    public static void getUserTickets(Context ctx){

        System.out.println("Getting user Tickets");
        User user = ctx.sessionAttribute("currentUser");
        int userId = user.getUserId();
        for (Reimbursement thisReim : reimbursementDAO.selectUserTickets(userId)){
            System.out.println(thisReim.toString());
        }

        /*ctx.json(reimbursementDAO.selectUserTickets(userId));*/
        ctx.json(reimbursementDAO.selectUserTest(userId));
    }

    public static void selectAllTickets(Context ctx){
        System.out.println("Getting all users tickets!!!!");
        List<Reimbursement> reimList = reimbursementDAO.selectAllTicket();
        ctx.json(reimList);
    }

    public static void updateTickets(Context ctx){
        System.out.println("Updating The Ticket !!!!!");
        User user = ctx.sessionAttribute("currentUser");
        int userId = user.getUserId();
        System.out.println(user);
        System.out.println(ctx.body());
        Reimbursement reimbursement = ctx.bodyAsClass(Reimbursement.class);
        System.out.println(reimbursement);

        int reimbId = reimbursement.getReimbId();
        int statusId =reimbursement.getStatusId();
        reimbursementDAO.updateTicket(statusId,userId,reimbId);
        ctx.redirect("/manager.html");


        /*System.out.println(ctx.formParam("thisReimId"));
        System.out.println(ctx.formParam("statusId"));*/
        /*int reimbId = Integer.parseInt(ctx.formParam("reimId"));
        int statusId = Integer.parseInt(ctx.formParam("statusId"));*/
        /*String reimbId = ctx.formParam("thisReimId");
        String statusId = ctx.formParam("statusId");*/


        /*ctx.json(reimbursementDAO.updateTicket(statusId,userId,reimbId));*/
        /*ctx.redirect("/manager.html");*/

    }

}

