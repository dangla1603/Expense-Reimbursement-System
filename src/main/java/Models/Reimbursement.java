package Models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Reimbursement {

    private int reimbId;
    private int amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date submitted;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date resolved;
    private String description;
    private int author;
    private int resolver;
    private int statusId;
    private int typeId;
    private String status;
    private String type;
    private String userName;




    /**
     * CONSTRUCTORS
     * No-arg Constructors
     * All instance Constructors
     * some customized Constructor
     * */
    public Reimbursement() {
    }

    public Reimbursement(int reimbId, int amount, Date submitted, int resolver, String description, String status, String type) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submitted = submitted;
        this.resolver = resolver;
        this.description = description;
        this.status = status;
        this.type = type;
    }

    public Reimbursement(int reimbId, int amount, Date submitted, Date resolved, String description, int author, int resolver, int statusId, int typeId, String status, String type,String userName) {
        this.reimbId = reimbId;
        this.amount = amount;
        this.submitted = submitted;
        this.resolved = resolved;
        this.description = description;
        this.author = author;
        this.resolver = resolver;
        this.statusId = statusId;
        this.typeId = typeId;
        this.status = status;
        this.type = type;
        this.userName = userName;
    }

    public Reimbursement(int amount, String description, int author, int resolver, int statusId, int typeId) {
        this.amount = amount;
        this.description = description;
        this.author = author;
        this.resolver = resolver;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public Reimbursement( int amount, String description,int author, int statusId,int typeId){
        this.amount = amount;
        this.description = description;
        this.author = author;
        this.statusId = statusId;
        this.typeId = typeId;
    }

    public Reimbursement(int reimbId, int resolver, int statusId) {
        this.reimbId = reimbId;
        this.resolver = resolver;
        this.statusId = statusId;
    }

    /**
     * GETTERs AND SETTERs
     * */

    public int getReimbId() {
        return reimbId;
    }

    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Date submitted) {
        this.submitted = submitted;
    }

    public Date getResolved() {
        return resolved;
    }

    public void setResolved(Date resolved) {
        this.resolved = resolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getResolver() {
        return resolver;
    }

    public void setResolver(int resolver) {
        this.resolver = resolver;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "\nReimbursement{" +
                "reimbId=" + reimbId +
                ", amount=" + amount +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", resolver=" + resolver +
                ", statusId=" + statusId +
                ", typeId=" + typeId +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
