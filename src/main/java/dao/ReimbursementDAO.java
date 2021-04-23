package dao;

import Models.Reimbursement;

import java.util.List;

public interface ReimbursementDAO {


    //CRUD Methods

    //CREATE
    public boolean addTicket(Reimbursement reimbursement);

    //READ
    public List<Reimbursement> selectAllPendingTickets();
    public List<Reimbursement> selectUserTickets(int userId);
    public List<Reimbursement> selectUserTest (int userId);
    public List<Reimbursement> selectAllTicket();

    //UPDATE
    public boolean approveTicket(int reimbId, int resId);
    public boolean denyTicket(int reimbId, int resId);
    public boolean updateTicket(int statusId, int resolver,int reimbId);

    //DELETE
    public boolean deleteTicket(int reimId);

}
