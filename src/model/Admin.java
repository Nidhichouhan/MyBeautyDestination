package model;

public class Admin {
	private int adminId;
	private String name;
	private String userName;
	private String password;
	private String confirmPassword;
	private String email;
	private String contactDetails;
	
	public Admin(int adminId, String name, String userName, String password, String confirmPassword, String email, String contactDetails) {
		this.adminId=adminId;
		this.name=name;
		this.userName=userName;
		this.password=password;
		this.confirmPassword=confirmPassword;
		this.email=email;
		this.contactDetails=contactDetails;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Admin() {
		
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
}
