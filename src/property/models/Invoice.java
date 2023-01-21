package property.models;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import customer.models.Customer;

public class Invoice  implements Serializable  {
 	private static final long serialVersionUID = 1L;
	private Customer tenant;
	private String customerFullName;
	private String customerPhoneNumber;
    private Property property;
    private String startDate;
    private String endDate;
    private double amountDue;

    private double deposit;
    private Date inviceDate;
    private double agentFee;
    private double subTotal = 0;
    
    public Invoice(Customer tenant, Property property, String startDate, 
    		String endDate, double customerDeposite) {
    	
        this.tenant = tenant;
        this.property = property;
        this.startDate = startDate;
        this.endDate = endDate;
         

        this.deposit = property.getRentPerMonth() * 6;
        this.agentFee = property.getRentPerMonth() * 0.2;
        this.subTotal =  this.deposit + this.agentFee;
        this.amountDue = subTotal - customerDeposite;
        this.setInviceDate(new Date());
        this.customerFullName  = tenant.getFullName();
        this.customerPhoneNumber = tenant.getPhoneNumber();
    }


    public double getDeposit() {
        return deposit;
    }

    public double getAgentFee() {
        return agentFee;
    }

    public Customer getTenant() {
        return tenant;
    }

    public Property getProperty() {
        return property;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getAmountDue() {
        return amountDue;
    }
    
    @Override
    public String toString() {
 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
 
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------Invoice--------------").append("\n");
         
        
        sb.append("Invoice Date: --------------------").append(this.getInviceDate()).append("\n");
        sb.append("\n");
        sb.append("Property Id: ---------------------").append(this.property.getId()).append("\n");
        sb.append("\n");
        
        
        sb.append("Customer Name: -------------------").append(this.getTenant().getFullName()).append("\n");
        sb.append("\n");
        sb.append("Start Date: ----------------------").append(this.getStartDate()).append("\n");
        sb.append("\n");
        

        sb.append("End Date: ------------------------").append(this.getEndDate()).append("\n");
        sb.append("\n");
        sb.append("Rent/Month: ----------------------").append(this.property.getRentPerMonth()).append("\n");
        sb.append("\n");
        sb.append("Number of Months: ----------------").append(6).append("\n");
        sb.append("\n");
        sb.append("Agent Fee ------------------------").append(this.getAgentFee()).append("\n");
        sb.append("\n");
        sb.append("Subtotal: ------------------------").append(this.getSubTotal()).append("\n");
        sb.append("\n");
        return sb.toString();
    }


	public Date getInviceDate() {
		return inviceDate;
	}


	public void setInviceDate(Date inviceDate) {
		this.inviceDate = inviceDate;
	}


	public double getSubTotal() {
		return subTotal;
	}
	


	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	public String getCustomerFullName() {
		return customerFullName;
	}


	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}


	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}


	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
}

