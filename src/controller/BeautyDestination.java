package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utility.ConnectionManager;
import utility.ValidationDetails;
import dao.AddToCartDAO;
import dao.AdminDAO;
import dao.BeautyProductsDAO;
import dao.BeautyProductsDisplay;
import dao.IngredientDAODisplay;
import dao.IngredientsDAO;
import dao.UserDAO;
import model.Admin;
import model.Beauty_Products;
import model.Ingredients;
import model.User;
public class BeautyDestination
{
	static BeautyDestinationAdmin beautyAdmin=new BeautyDestinationAdmin();
	//Welcome page
	static int choice;	
	public static void main(String[] args) throws Exception
	{
		System.out.println("\n********************************************************************************************************************************************************\n\n ");
		System.out.println("                                          YOU ARE WELCOME TO THE ONE STOP DESTINATION FOR ALL YOUR SKIN CONCERN                                                                  \n\n");
		System.out.println("\n********************************************************************************************************************************************************\n\n ");
		selectOptions();
	}
	
	//Registration & Login options
	public static void selectOptions() throws Exception
	{
		System.out.println("-----------------------------------------------------------------------Please choose one option:----------------------------------------------------------------\n1.Admin\n2.User");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		choice = Integer.parseInt(br.readLine());
		switch(choice)
		{
			case 1: adminMode();
					break;
			case 2:	userMode();
					break;
			default: System.out.println("Please Enter Correct Choice");
					selectOptions();
		}
		br.close();
	}
	
	//For Admin
	public static void adminMode() throws Exception
	{
		 Admin admin=new Admin();
		System.out.println("------------------------------------------------------------------------Enter your Choice------------------------------------------------------------\n1.Register\n2.Login");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int option = Integer.parseInt(br.readLine());
		switch(option)
		{
			case 1: BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
					AdminDAO admindao=new AdminDAO();
					ValidationDetails validate = new ValidationDetails();
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
					System.out.println("                                       *********************************Welcome*******************************************         \nAdmin Registration Details                          \n");
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
					System.out.println("Enter Your Id: \n");
					int id=Integer.parseInt(br1.readLine());
					System.out.println("Enter Your Name: \n");
					String name = br1.readLine();
					System.out.println("Enter Your Email-Id: \n");
					String email = br1.readLine();
					System.out.println("Enter Your UserName: \n");
					String username = br1.readLine();
					System.out.println("Enter Your Password: \n");
					String password = br1.readLine();
					System.out.println("Re-enter Your Password: \n");
					String confirmPassword = br1.readLine();
					System.out.println("Enter Your Mobile Number: \n");
				    String mobile = br1.readLine();
						
					if(validate.isValid(email, password, confirmPassword, mobile))
					{
						admin.setAdminId(id);
						admin.setName(name);
						admin.setEmail(email);
						admin.setUserName(username);
						admin.setPassword(password);
						admin.setConfirmPassword(confirmPassword);
						admin.setContactDetails(mobile);
					    int checkUser=admindao.signUp(admin);
					    if(checkUser!=0) {
					    	System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");
						    System.out.println("                               \nSuccessfully Registered.!!\n\nRedirecting to Login\n                                           \n");
						    System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");
						    adminMode();
					    }
						br1.close();
					}
					else
					{
						System.out.println("\nPlease correct your details.!");
						adminMode();
					}
					break;
						
			case 2: 
				   
				    AdminDAO admindao1=new AdminDAO();
					System.out.println("Enter Username: ");
					String userName = br.readLine();
					System.out.println("Enter Password: ");
					String loginPassword = br.readLine();
					admin.setUserName(userName);
					admin.setPassword(loginPassword);
					boolean checkUser=admindao1.loginUser(admin);
				    
					if(checkUser==true) {
						System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						System.out.println("                                                                        Logged in Successfully                                                               \n");
						System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						beautyAdmin.admin();
					}
					else {
						System.out.println("Invalid Credentials\n\nPlease Enter Again");
						adminMode();
					}
				    
					break;
				    
			default: System.out.println("Please Enter Correct Choice");
					selectOptions();	
		}
		br.close();
	}
	public static void userMode() throws Exception {
		User user=new User();
		System.out.println("------------------------------------------------------------------------Enter your Choice------------------------------------------------------------\n1.Register\n2.Login");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int option = Integer.parseInt(br.readLine());
		switch(option)
		{
			case 1: BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
					UserDAO userdao=new UserDAO();
					ValidationDetails validate = new ValidationDetails();
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
					System.out.println("                                       **************************************Welcome*******************************************         \n User Registration                          \n");
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
					System.out.println("Enter Your Id: \n");
					int id=Integer.parseInt(br1.readLine());
					System.out.println("Enter Your Name: \n");
					String name = br1.readLine();
					System.out.println("Enter Your Email-Id: \n");
					String email = br1.readLine();
					System.out.println("Enter Your UserName: \n");
					String username = br1.readLine();
					System.out.println("Enter Your Password: \n");
					String password = br1.readLine();
					System.out.println("Re-enter Your Password: \n");
					String confirmPassword = br1.readLine();
					System.out.println("Enter Your Mobile Number: \n");
				    String mobile = br1.readLine();
				    System.out.println("Enter Your Address: \n");
				    String address = br1.readLine();
				    System.out.println("Enter Your Wallet Amount: \n");
				    int amount=Integer.parseInt(br1.readLine());
						
					if(validate.isValid(email, password, confirmPassword, mobile))
					{
						user.setUserId(id);
						user.setName(name);
						user.setEmail(email);
						user.setUserName(username);
						user.setPassword(password);
						user.setConfirmpassword(confirmPassword);
						user.setContactNumber(mobile);
						user.setAddress(address);
						user.setAmount(amount);
					    int checkUser=userdao.signUp(user);
					    if(checkUser!=0) {
					    	System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");
						    System.out.println("                               \nSuccessfully Registered.!!\n\nRedirecting to Login\n                                           \n");
						    System.out.println("--------------------------------------------------------------------------------------------------------------------------------\n");
						    userMode();
					    }
						br1.close();
					}
					else
					{
						System.out.println("\nPlease correct your details.!");
						userMode();
					}
					break;
						
			case 2: 
				    UserDAO userdao1=new UserDAO();
				    AddToCartDAO addcart=new AddToCartDAO();
					System.out.println("Enter Username: ");
					String userName = br.readLine();
					System.out.println("Enter Password: ");
					String loginPassword = br.readLine();
					
					user.setUserName(userName);
					user.setPassword(loginPassword);
					
					boolean checkUser=userdao1.loginUser(user);
					if(checkUser==true) {
						System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						System.out.println("                                                                        Logged in Successfully                                                               \n");
						System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
						beautyAdmin.user();
						System.out.println("Do you want to order products: [Y/N]");
						String input=br.readLine();
						if(input.equalsIgnoreCase("Y")) {
								addcart.shopping(userName);
						}
					}
					else {
						System.out.println("Invalid Credentials");
						userMode();
					}
					break;
			default: System.out.println("Please Enter Correct Choice");
					selectOptions();	
		}
		br.close();
	}
	public static void endApp() {
		System.out.println("****************************************************************************THANKS FOR VISITING**********************************************************************************\n\n\n**************************************************************************HAVE A NICE DAY***************************************************************************************");
	}
	
	
}