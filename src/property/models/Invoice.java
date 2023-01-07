package property.models;

import java.util.Date;

public class Invoice {
    private User tenant;
    private Property property;
    private Date startDate;
    private Date endDate;
    private double amountDue;

    private double deposit;
    private double agentFee;

    public Invoice(User tenant, Property property, Date startDate, Date endDate, double amountDue) {
        this.tenant = tenant;
        this.property = property;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amountDue = amountDue;

        this.deposit = property.getRentPerMonth() * 6;
        this.agentFee = property.getRentPerMonth() * 0.2;
        this.amountDue = amountDue + this.deposit + this.agentFee;
    }


    public double getDeposit() {
        return deposit;
    }

    public double getAgentFee() {
        return agentFee;
    }

    public User getTenant() {
        return tenant;
    }

    public Property getProperty() {
        return property;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getAmountDue() {
        return amountDue;
    }
}

