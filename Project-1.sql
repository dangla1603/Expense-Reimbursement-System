

-------------------------------------------------------
-----------------------DROP--------------------------
-------------------------------------------------------
DROP TABLE ERS_REIMBURSEMENT;
DROP TABLE ERS_USERS;
DROP TABLE REIMBURSEMENT_STATUS;
DROP TABLE REIMBURSEMENT_TYPE;
DROP TABLE USER_ROLES;




-------------------------------------------------------
-----------------------CREATE--------------------------
-------------------------------------------------------

CREATE TABLE ERS_REIMBURSEMENT(
	REIMB_ID SERIAL PRIMARY KEY
	,REIMB_AMOUNT INTEGER NOT NULL
	,REIMB_SUBMITTED TIMESTAMP DEFAULT NOW()
	,REIMB_RESOLVED TIMESTAMP
	,REIMB_DESCRIPTION VARCHAR(250)
	,REIMB_AUTHOR INTEGER NOT NULL
	,REIMB_RESOLVER INTEGER
	,REIMB_STATUS_ID INTEGER NOT NULL
	,REIMB_TYPE_ID INTEGER NOT NULL
	,FOREIGN KEY (REIMB_AUTHOR) REFERENCES ERS_USERS(ERS_USERS_ID)
	,FOREIGN KEY (REIMB_RESOLVER) REFERENCES ERS_USERS(ERS_USERS_ID)
	,FOREIGN KEY (REIMB_STATUS_ID) REFERENCES REIMBURSEMENT_STATUS(reim_status_id)
	,FOREIGN KEY (REIMB_TYPE_ID) REFERENCES REIMBURSEMENT_TYPE(REIM_TYPE_ID)
);


CREATE TABLE ERS_USERS(
	ERS_USERS_ID SERIAL PRIMARY KEY
	,ERS_USERNAME VARCHAR(50) UNIQUE NOT NULL
	,ERS_PASSWORD VARCHAR(50) NOT NULL
	,USER_FIRST_NAME VARCHAR(100) NOT NULL
	,USER_LAST_NAME VARCHAR(100) NOT NULL
	,USER_EMAIL VARCHAR(150) UNIQUE NOT NULL
	,USER_ROLE_ID INTEGER NOT NULL
	,FOREIGN KEY (USER_ROLE_ID) REFERENCES USER_ROLES(USER_ROLE_ID)
);


CREATE TABLE REIMBURSEMENT_STATUS (
	REIM_STATUS_ID integer PRIMARY KEY
	,REIM_STATUS varchar(20) NOT NULL
);


CREATE TABLE REIMBURSEMENT_TYPE (
	REIM_TYPE_ID integer PRIMARY KEY
	,REIM_TYPE varchar(20) NOT NULL
);


CREATE TABLE USER_ROLES(
	USER_ROLE_ID integer PRIMARY KEY
	,USER_ROLE varchar(20) NOT NULL
);


-------------------------------------------------------
-----------------------SELECT--------------------------
-------------------------------------------------------

SELECT * FROM ERS_REIMBURSEMENT;
SELECT * FROM ERS_USERS;
SELECT * FROM REIMBURSEMENT_STATUS;
SELECT * FROM REIMBURSEMENT_TYPE;
SELECT * FROM USER_ROLES;

SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID =1;
SELECT * FROM ERS_USERS e INNER JOIN USER_ROLES er ON er.USER_ROLE_ID = e.USER_ROLE_ID WHERE ERS_USERNAME = 'dangla';
SELECT * FROM ERS_REIMBURSEMENT er INNER JOIN ERS_USERS eu ON er.REIMB_AUTHOR = eu.ERS_USERS_ID WHERE eu.ERS_USERS_ID = 1;
SELECT * FROM ers_reimbursement er INNER JOIN ers_users eu ON er.reimb_author = eu.ers_users_id WHERE eu.ers_users_id =1;
SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR =1;



SELECT * FROM ERS_REIMBURSEMENT r 
	LEFT JOIN REIMBURSEMENT_STATUS s ON r.reimb_status_id  = s.reim_status_id
	LEFT JOIN REIMBURSEMENT_TYPE rt ON r.REIMB_TYPE_ID = rt.reim_type_id
	LEFT JOIN ERS_USERS eu ON r.reimb_author = eu.ers_users_id
	WHERE r.reimb_author = 1;

SELECT * FROM ERS_REIMBURSEMENT r 
	LEFT JOIN REIMBURSEMENT_STATUS s ON r.reimb_status_id  = s.reim_status_id
	LEFT JOIN REIMBURSEMENT_TYPE rt ON r.REIMB_TYPE_ID = rt.reim_type_id
	LEFT JOIN ERS_USERS eu ON r.REIMB_RESOLVER = eu.ers_users_id
	WHERE r.reimb_author = 3;


-------------------------------------------------------
-----------------------INSERT--------------------------
-------------------------------------------------------

----ERS_REIMBURSEMENT-----
INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT,REIMB_DESCRIPTION,REIMB_AUTHOR,REIMB_STATUS_ID,REIMB_TYPE_ID) VALUES ( 100, 'dangTicket', 1, 1, 4);
INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT,REIMB_DESCRIPTION,REIMB_AUTHOR,reimb_resolver,REIMB_STATUS_ID,REIMB_TYPE_ID) VALUES ( 200, 'secondDangTicket',1,2, 2, 4);
INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT,REIMB_DESCRIPTION,REIMB_AUTHOR,reimb_resolver,REIMB_STATUS_ID,REIMB_TYPE_ID) VALUES ( 200, 'thirdDangTicket',1,2, 1, 4);
----ERS_USERS-----
INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('dangla','la','dang','la','dangla@yahoo.com',1);
INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('admin','password','thisAdmin','thatAdmin','admin@yahoo.com',2);
INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES ('test20','pass','john','cena','test20@yahoo.com',1);
----REIMBURSEMENT_STATUS-----
INSERT INTO REIMBURSEMENT_STATUS (REIM_STATUS_ID,REIM_STATUS) VALUES (1,'Pending');
INSERT INTO REIMBURSEMENT_STATUS (REIM_STATUS_ID,REIM_STATUS) VALUES (2,'Approved');
INSERT INTO REIMBURSEMENT_STATUS (REIM_STATUS_ID,REIM_STATUS) VALUES (3,'Denied');
----REIMBURSMENT_TYPE-----
INSERT INTO REIMBURSEMENT_TYPE (REIM_TYPE_ID, REIM_TYPE) VALUES (1, 'Lodging');
INSERT INTO REIMBURSEMENT_TYPE (REIM_TYPE_ID, REIM_TYPE) VALUES (2, 'Travel');
INSERT INTO REIMBURSEMENT_TYPE (REIM_TYPE_ID, REIM_TYPE) VALUES (3, 'Food');
INSERT INTO REIMBURSEMENT_TYPE (REIM_TYPE_ID, REIM_TYPE) VALUES (4, 'Other');
----USER_ROLES-----
INSERT INTO user_roles (USER_ROLE_ID,USER_ROLE) VALUES (1,'Employee');
INSERT INTO user_roles (USER_ROLE_ID,USER_ROLE) VALUES (2,'Manager');



DELETE FROM ERS_USERS WHERE ers_username  = 'dangla';
DELETE FROM user_roles WHERE user_role  = 'employee';
DELETE FROM REIMBURSEMENT_STATUS WHERE REIM_STATUS = 'Approved';
DELETE FROM ers_reimbursement  WHERE reimb_description ='secondDangTicket';
DELETE FROM ers_reimbursement  WHERE reimb_description ='dangTicket';

UPDATE ers_reimbursement
	SET REIMB_STATUS_ID = 2, REIMB_RESOLVER = 2, REIMB_RESOLVED = NOW()
    WHERE REIMB_ID = 4;
    
   
