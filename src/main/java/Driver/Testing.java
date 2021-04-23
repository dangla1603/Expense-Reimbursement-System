package Driver;

import dao.*;

public class Testing {
    public static void main(String[] args) {
       /* UserDAO userDAO = new UserDAOImpl();
//        System.out.println(userDAO.getUserByUserName("dangla"));
        userDAO.getAllUser();
//        userDAO.checkLogin("dangla","la");
        User user = new User();
        user = userDAO.checkLogin("dangla","la");
        System.out.println(user.getRoleId());*/

        /*UserService userService = new UserServiceImpl();
        System.out.println(userService.checkLogin("dangla","la"));*/
        UserDAO userDAO = new UserDAOImpl();
        ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
       /* System.out.println(reimbursementDAO.selectUserTickets(1));
        *//*System.out.println(reimbursementDAO.selectAllTicket());*//*
        System.out.println(reimbursementDAO.updateTicket(2,2,10));*/
        /*System.out.println(reimbursementDAO.selectUserTest(1));*/





    }
}
