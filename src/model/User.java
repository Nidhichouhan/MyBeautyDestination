package model;



public class User{
	private int userId;
	private String name;
	private String email;
	private String userName;
	private String password;
	private String confirmpassword;
	private String contactNumber;
	private String Address;
	private int Amount;
	
	public User(int userId,String name,String email, String userName, String password, String confirmPassword,String contactNumber, String Address, int amount) {
		this.userId=userId;
		this.name=name;
		this.email=email;
		this.userName=userName;
		this.password=password;
		this.confirmpassword=confirmPassword;
		this.contactNumber=contactNumber;
		this.Address=Address;
		this.Amount=amount;
	}
	
	
	public int getAmount() {
		return Amount;
	}


	public void setAmount(int amount) {
		Amount = amount;
	}


	public User() {
		
	}
	
	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	
}