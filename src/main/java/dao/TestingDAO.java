package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestingDAO {

    public static String url = "jdbc:h2:C:\\Users\\Dang\\Documents\\TestingIssue";
    public static String username = "sa";
    public static String password = "sa";


    public static void h2InitDao() {
        //I am inserting two pokemon "types" into the database, but my Pokemon model in the model layer
        //	only uses one type. I simplified the model for demo purposes. AND to demo that your model can
        //	differ from the actual database table, in JDBC.

        try(Connection conn=
                    DriverManager.getConnection(url,username, password))
        {
            String sql= "CREATE TABLE USER_ROLES(\n" +
                    "\tUSER_ROLE_ID integer PRIMARY KEY \n" +
                    "\t,USER_ROLE varchar(20) NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "INSERT INTO user_roles (USER_ROLE_ID,USER_ROLE) VALUES (1,'Employee');\n" +
                    "INSERT INTO user_roles (USER_ROLE_ID,USER_ROLE) VALUES (2,'Manager');\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE REIMBURSEMENT_TYPE (\n" +
                    "\tREIM_TYPE_ID integer PRIMARY KEY\n" +
                    "\t,REIM_TYPE varchar(20) NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "INSERT INTO REIMBURSEMENT_TYPE (REIM_TYPE_ID, REIM_TYPE) VALUES (1, 'Lodging');\n" +
                    "INSERT INTO REIMBURSEMENT_TYPE (REIM_TYPE_ID, REIM_TYPE) VALUES (2, 'Travel');\n" +
                    "INSERT INTO REIMBURSEMENT_TYPE (REIM_TYPE_ID, REIM_TYPE) VALUES (3, 'Food');\n" +
                    "INSERT INTO REIMBURSEMENT_TYPE (REIM_TYPE_ID, REIM_TYPE) VALUES (4, 'Other');\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE REIMBURSEMENT_STATUS (\n" +
                    "\tREIM_STATUS_ID integer PRIMARY KEY\n" +
                    "\t,REIM_STATUS varchar(20) NOT NULL\n" +
                    ");\n" +
                    "\n" +
                    "INSERT INTO REIMBURSEMENT_STATUS (REIM_STATUS_ID,REIM_STATUS) VALUES (1,'Pending');\n" +
                    "INSERT INTO REIMBURSEMENT_STATUS (REIM_STATUS_ID,REIM_STATUS) VALUES (2,'Approved');\n" +
                    "INSERT INTO REIMBURSEMENT_STATUS (REIM_STATUS_ID,REIM_STATUS) VALUES (3,'Denied');\n" +
                    "\n" +
                    "\n" +
                    "CREATE TABLE ERS_USERS(\n" +
                    "\tERS_USERS_ID SERIAL PRIMARY KEY\n" +
                    "\t,ERS_USERNAME VARCHAR(50) UNIQUE NOT NULL\n" +
                    "\t,ERS_PASSWORD VARCHAR(50) NOT NULL\n" +
                    "\t,USER_FIRST_NAME VARCHAR(100) NOT NULL\n" +
                    "\t,USER_LAST_NAME VARCHAR(100) NOT NULL\n" +
                    "\t,USER_EMAIL VARCHAR(150) UNIQUE NOT NULL\n" +
                    "\t,USER_ROLE_ID INTEGER NOT NULL\n" +
                    "\t,FOREIGN KEY (USER_ROLE_ID) REFERENCES USER_ROLES(USER_ROLE_ID)\n" +
                    ");\n" +
                    "\n" +
                    "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)\n" +
                    "VALUES ('dangla','la','dang','la','dangla@yahoo.com',1);" +
                    "\n" +
                    "\n" +

                    "CREATE TABLE ERS_REIMBURSEMENT(\n" +
                    "\tREIMB_ID SERIAL PRIMARY KEY\n" +
                    "\t,REIMB_AMOUNT INTEGER NOT NULL\n" +
                    "\t,REIMB_SUBMITTED TIMESTAMP\n" +
                    "\t,REIMB_RESOLVED TIMESTAMP\n" +
                    "\t,REIMB_DESCRIPTION VARCHAR(250)\n" +
                    "\t,REIMB_AUTHOR INTEGER NOT NULL\n" +
                    "\t,REIMB_RESOLVER INTEGER\n" +
                    "\t,REIMB_STATUS_ID INTEGER NOT NULL\n" +
                    "\t,REIMB_TYPE_ID INTEGER NOT NULL\n" +
                    "\t,FOREIGN KEY (REIMB_AUTHOR) REFERENCES ERS_USERS(ERS_USERS_ID)\n" +
                    "\t,FOREIGN KEY (REIMB_RESOLVER) REFERENCES ERS_USERS(ERS_USERS_ID)\n" +
                    "\t,FOREIGN KEY (REIMB_STATUS_ID) REFERENCES REIMBURSEMENT_STATUS(reim_status_id)\n" +
                    "\t,FOREIGN KEY (REIMB_TYPE_ID) REFERENCES REIMBURSEMENT_TYPE(REIM_TYPE_ID)\n" +
                    ");\n" +
                    "\n" +
                    "INSERT INTO ERS_REIMBURSEMENT (REIMB_ID,REIMB_AMOUNT,REIMB_DESCRIPTION,REIMB_AUTHOR,REIMB_STATUS_ID,REIMB_TYPE_ID)\n" +
                    "VALUES (1, 100, 'dangTicket', 1, 1, 4);";

                    Statement state = conn.createStatement();
            state.execute(sql);
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }

    public static void h2DestroyDao() {
        try(Connection conn=
                    DriverManager.getConnection(url,username, password))
        {
            String sql= "DROP TABLE ERS_REIMBURSEMENT;\n"+
                    "DROP TABLE ERS_USERS;\n" +
                    "DROP TABLE REIMBURSEMENT_STATUS;"+
                    "DROP TABLE USER_ROLES;\n" +
                    "DROP TABLE REIMBURSEMENT_TYPE;";


            Statement state = conn.createStatement();
            state.execute(sql);
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }

}
