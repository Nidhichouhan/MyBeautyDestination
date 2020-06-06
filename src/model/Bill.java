package model;

public class Bill {
	private int billId;
	private String name;
	private int agentId;
	private double total;
	private long contactDetails;
	private int quantity;
	
	public Bill(int billId, String name, int agentId, double total, long contactDetails, int quantity) {
		this.billId=billId;
		this.name=name;
		this.agentId=agentId;
		this.total=total;
		this.contactDetails=contactDetails;
		this.quantity=quantity;
	}
	
	public Bill() {
		
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public long getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(long contactDetails) {
		this.contactDetails = contactDetails;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
