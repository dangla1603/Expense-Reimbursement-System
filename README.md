# Expense Reimbursement System (ERS) - Java CDE Full Stack

## Project Description

The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used

* Java
* JavaScript
* HTML/CSS
* AWS RDS
* PostgreSQL
* Javalin

## Features

List of features ready and TODOs for future development
* As employees, user can login into account and be able to submit the reimbursement ticket ( types are LODGING, FOOD, TRAVEL, OTHERS ) with specific amount and description of that ticket. The default status for ticket will be pending, finance manager will able to review that ticket and are authorized to approve and deny requests for expense reimbursement.
* As finance manager, user can login into account and be able to review all tickets from employees. User can either approve or deny the tickets by inserting the ticket id.
* User can register new account to be either employee or manager.


To-do list:
* Encrypted password on database.
* Forget-password will able to send email confirmation and reset password from user.
* As employee, user can upload the reimbursement reciept when create ticket.
* As manager, user can download and view the reciept.

## Getting Started
* First we need to git clone the project
> git clone https://github.com/dangla1603/Expense-Reimbursement-System.git
* Then, we will install IntelliJ https://www.jetbrains.com/idea/download/#section=windows

## Usage

* When you open the project, go to Driver folder inside main folder. Open the MainDriver class and run that class.
![run](https://user-images.githubusercontent.com/43182305/115806450-66d6fd00-a3ac-11eb-9752-6ef225e650bb.PNG)

* After running the MainDriver class, it will give you the url where the project is running ( http://localhost:9060 )
* Login page on the url
![login](https://user-images.githubusercontent.com/43182305/115806569-a271c700-a3ac-11eb-8e29-5d2c3e8dc4b5.PNG)

* You can register account as well
![register](https://user-images.githubusercontent.com/43182305/115806579-a7367b00-a3ac-11eb-814f-27a46083c0eb.PNG)

* When you log in as employee account, it will redirect you to the employee page which has the table of all reimbursement tickets in your account. you can make new ticket by click on " create new reimbursement ticket " button.
![employee](https://user-images.githubusercontent.com/43182305/115806584-aa316b80-a3ac-11eb-87ca-df8cd81f485b.PNG)
![ticket](https://user-images.githubusercontent.com/43182305/115806592-ad2c5c00-a3ac-11eb-9d54-6000a3342130.PNG)

* When you log in as finance manger from log in page, it will redirect you the manager page which has the table of reimbursement tickets from your employee. You can either approve or deny the tickets.
![manager](https://user-images.githubusercontent.com/43182305/115806587-abfb2f00-a3ac-11eb-8225-680be2a3a2ad.PNG)

* After finish doing reimbursement, you can hit " log out " button on top left corner, it will exist your account and redirect back to log in page.
## License

This project uses the following license: [<license_name>](<link>).

