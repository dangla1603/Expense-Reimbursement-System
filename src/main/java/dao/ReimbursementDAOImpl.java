package dao;

import Models.Reimbursement;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImpl implements  ReimbursementDAO{

    public static String url = "jdbc:postgresql://dataoppa.cbb9i9nde4sj.us-east-2.rds.amazonaws.com/ExpenseReimbursementSystem";
    public static String username = "dataoppa";
    public static String password = "eWDang1603";

    final static Logger loggy = Logger.getLogger(UserDAOImpl.class);


    /**
     * ADDs ticket
     * @param reimbursement
     * @return
     * */
    @Override
    public boolean addTicket(Reimbursement reimbursement) {
        try(Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT,REIMB_DESCRIPTION,REIMB_AUTHOR,REIMB_STATUS_ID,REIMB_TYPE_ID)\n" +
                    "VALUES (?,?,?,?,?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1,reimbursement.getAmount());
            ps.setString(2,reimbursement.getDescription());
            ps.setInt(3,reimbursement.getAuthor());
            ps.setInt(4,reimbursement.getStatusId());
            ps.setInt(5,reimbursement.getTypeId());


            return ps.executeUpdate() != 0;


        }catch(SQLException e){
            e.printStackTrace();
            loggy.error(e);
        }

        return false;
    }

    /**
     * Selecting all Tickets that are PENDING status
     * @param
     * @return
     * */
    @Override
    public List<Reimbursement> selectAllPendingTickets() {
        List<Reimbursement> tickets = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID =1;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();



            while (rs.next()) {


                tickets.add(
                        new Reimbursement(
                               /* rs.getInt(1),                               //reimID
                                rs.getInt(2),                               //amount
                                rs.getString(3),                            //description
                                rs.getInt(4),                               //author
                                rs.getInt(5),                               //resolver
                                rs.getInt(6),                               //status_id
                                rs.getInt(7)                                //type_id*/
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            loggy.error(e);
        }
        if (tickets == null) {
            System.out.println("No tickets");
        }
        return tickets;

    }

    /**
     * Select all tickets from user
     * @param userId
     * @return
     * */
    @Override
    public List<Reimbursement> selectUserTickets(int userId) {
        List<Reimbursement> tickets = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            /*String sql = "SELECT * FROM ers_reimbursement er INNER JOIN ers_users eu ON er.reimb_author = eu.ers_users_id WHERE eu.ers_users_id =?";*/
            /*String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR =?;";*/
            String sql = "SELECT * FROM ERS_REIMBURSEMENT r \n" +
                    "LEFT JOIN REIMBURSEMENT_STATUS s ON r.reimb_status_id  = s.reim_status_id\n" +
                    "LEFT JOIN REIMBURSEMENT_TYPE rt ON r.REIMB_TYPE_ID = rt.reim_type_id\n" +
                    "LEFT JOIN ERS_USERS eu ON r.reimb_author = eu.ers_users_id\n" +
                    "WHERE r.reimb_author = ?; ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();



            while (rs.next()) {


                tickets.add(
                        new Reimbursement(
                                rs.getInt(1),
                                rs.getInt(2),
                                rs.getDate(3),
                                rs.getDate(4),
                                rs.getString(5),
                                rs.getInt(6),
                                rs.getInt(7),
                                rs.getInt(8),
                                rs.getInt(9),
                                rs.getString(11),
                                rs.getString(13),
                                rs.getString(15)
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            loggy.error(e);
        }

        return tickets;

    }

    @Override
    public List<Reimbursement> selectUserTest(int userId) {

        List<Reimbursement> tickets1 = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            /*String sql = "SELECT * FROM ers_reimbursement er INNER JOIN ers_users eu ON er.reimb_author = eu.ers_users_id WHERE eu.ers_users_id =?";*/
            String sql = "SELECT * FROM ERS_REIMBURSEMENT r \n" +
                         "LEFT JOIN REIMBURSEMENT_STATUS s ON r.reimb_status_id  = s.reim_status_id\n" +
                         "LEFT JOIN REIMBURSEMENT_TYPE rt ON r.REIMB_TYPE_ID = rt.reim_type_id\n" +
                         "LEFT JOIN ERS_USERS eu ON r.REIMB_RESOLVER = eu.ers_users_id\n" +
                         "WHERE r.reimb_author = ?; ";


            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();



            while (rs.next()) {
                tickets1.add(
                        new Reimbursement(
                                rs.getInt(1),
                                rs.getInt(2),
                                rs.getDate(3),
                                rs.getDate(4),
                                rs.getString(5),
                                rs.getInt(6),
                                rs.getInt(7),
                                rs.getInt(8),
                                rs.getInt(9),
                                rs.getString(11),
                                rs.getString(13),
                                rs.getString(17)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            loggy.error(e);
        }

        return tickets1;
    }

    @Override
    public List<Reimbursement> selectAllTicket() {
        List<Reimbursement> tickets2 = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            /*String sql = "SELECT * FROM ers_reimbursement er INNER JOIN ers_users eu ON er.reimb_author = eu.ers_users_id WHERE eu.ers_users_id =?";*/
            String sql = "SELECT * FROM ERS_REIMBURSEMENT r \n" +
                    "LEFT JOIN REIMBURSEMENT_STATUS s ON r.reimb_status_id  = s.reim_status_id\n" +
                    "LEFT JOIN REIMBURSEMENT_TYPE rt ON r.REIMB_TYPE_ID = rt.reim_type_id\n" +
                    "LEFT JOIN ERS_USERS eu ON r.reimb_author = eu.ers_users_id\n";


            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();



            while (rs.next()) {
                tickets2.add(
                        new Reimbursement(
                                rs.getInt(1),
                                rs.getInt(2),
                                rs.getDate(3),
                                rs.getDate(4),
                                rs.getString(5),
                                rs.getInt(6),
                                rs.getInt(7),
                                rs.getInt(8),
                                rs.getInt(9),
                                rs.getString(11),
                                rs.getString(13),
                                rs.getString(15)
                        ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            loggy.error(e);
        }

        return tickets2;
    }

    /**
     * APPROVE ticket
     * @param reimbId,resId
     * @return false
     * */
    @Override
    public boolean approveTicket(int reimbId, int resId) {

        try(Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "UPDATE ers_reimbursement \n" +
                    "SET REIMB_STATUS_ID = 2, REIMB_RESOLVER = ?, REIMB_RESOLVED = NOW()\n" +
                    "WHERE REIMB_ID = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,resId);
            ps.setInt(2,reimbId);


            return ps.executeUpdate() != 0;


        }catch(SQLException e){
            e.printStackTrace();
            loggy.error(e);
        }

        return false;
    }

    /**
     * DENY  ticket
     * @param reimbId,restId
     * @return false
     * */

    @Override
    public boolean denyTicket(int reimbId, int resId) {
        try(Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "UPDATE ers_reimbursement \n" +
                    "SET REIMB_STATUS_ID = 3, REIMB_RESOLVER = ?, REIMB_RESOLVED = NOW()\n" +
                    "WHERE REIMB_ID = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,resId);
            ps.setInt(2,reimbId);


            return ps.executeUpdate() != 0;


        }catch(SQLException e){
            e.printStackTrace();
            loggy.error(e);
        }

        return false;
    }

    @Override
    public boolean updateTicket(int statusId, int resolver,int reimbId) {
        try(Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "UPDATE ers_reimbursement \n" +
                    "SET REIMB_STATUS_ID = ?, REIMB_RESOLVER = ?, REIMB_RESOLVED = NOW()\n" +
                    "WHERE REIMB_ID = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,statusId);
            ps.setInt(2,resolver);
            ps.setInt(3,reimbId);

            return ps.executeUpdate() != 0;


        }catch(SQLException e){
            e.printStackTrace();
            loggy.error(e);
        }
        return false;
    }


    /**
     * DELETE ticket
     * @param reimId
     * @return
     * */

    @Override
    public boolean deleteTicket(int reimId) {
        try(Connection conn = DriverManager.getConnection(url, username, password)){

            String sql = "DELETE FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,reimId);


            return ps.executeUpdate() != 0;


        }catch(SQLException e){
            e.printStackTrace();
            loggy.error(e);
        }

        return false;

    }
}
