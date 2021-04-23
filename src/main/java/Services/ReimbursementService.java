package Services;

import Models.Reimbursement;

import java.util.List;

public interface ReimbursementService {
    public boolean addTicket(Reimbursement reimbursement);

    //READ
    public List<Reimbursement> selectAllPendingTickets();

    //UPDATE
    public boolean approveTicket(int reimbId, int resId);
    public boolean denyTicket(int reimbId, int resId);

    //DELETE
    public boolean deleteTicket(int reimId);
}
