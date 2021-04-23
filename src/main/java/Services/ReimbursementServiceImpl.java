package Services;

import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;
import Models.Reimbursement;

import java.util.List;

public class ReimbursementServiceImpl implements  ReimbursementService{

    ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();

    /**
     *  Add ticket to system
     * @param reimbursement
     * @return
     * */
    @Override
    public boolean addTicket(Reimbursement reimbursement) {
        return reimbursementDAO.addTicket(reimbursement);
    }

    /**
     * Select all PENDING ticket
     * @param
     * @return
     * */
    @Override
    public List<Reimbursement> selectAllPendingTickets() {
        return reimbursementDAO.selectAllPendingTickets();
    }

    /**
     * Approving ticket
     * @param reimbId,resId
     * @return
     * */
    @Override
    public boolean approveTicket(int reimbId, int resId) {
        return reimbursementDAO.approveTicket(reimbId,resId);
    }


    /**
     * Denying Ticket
     * @param reimbId, resId
     * @return
     * */
    @Override
    public boolean denyTicket(int reimbId, int resId) {
        return reimbursementDAO.denyTicket(reimbId,resId);
    }

    /**
     * Deleting Tickets
     * @param reimId
     * */
    @Override
    public boolean deleteTicket(int reimId) {
        return reimbursementDAO.deleteTicket(reimId);
    }
}
