package dao;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import controller.BeautyDestinationAdmin;
import controller.BeautyDestination;
import utility.ConnectionManager;

public class AddToCartDAO {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static double cost;
	static String username;
	static int id;
	static HashMap<String,Double>  displayitems = new HashMap<String,Double>();
	static HashMap<String,Double> prices = new HashMap<String,Double>(); 
	static HashMap<String,Integer> customer = new HashMap<String,Integer>();
	public AddToCartDAO(){}
	//Shopping Module for civilians
	public static void shopping(String userName) throws Exception 
	{
		username = userName;
		
		product();
		
	}
	
	public static void product() throws Exception {
		Statement query = ConnectionManager.getConnection().createStatement();
		String sql = "SELECT NAME,PRICE,ID FROM BEAUTY_PRODUCTS ";
		
		Statement query1 = ConnectionManager.getConnection().createStatement();
		ResultSet result = query.executeQuery(sql);
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n                                                          AVAILABLE PRODUCTS                                                                               ");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("                                          %-30s %20s %n","PRODUCT NAME", "PRICE");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		String product=" ";
		double productPrice;
		
		//displaying grains
		while(result.next()) 
		{
			product = result.getString("NAME");
			productPrice = result.getInt("PRICE");
			System.out.printf("                                     %-30s %25s %n",product, productPrice);
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			prices.put(product,productPrice);
//			System.out.println("------------------------------------------------------------------------------------------------------------------------");
		}
		result = query.executeQuery(sql);
		System.out.println("\nAdd to cart: ");
		String productBeauty = br.readLine();
		
		String sql1 = "SELECT * FROM BEAUTY_PRODUCTS WHERE NAME = '" + productBeauty + "'";
		ResultSet result1 = query1.executeQuery(sql1);
		if(!result1.next())
		{
			System.out.println("\nSorry this product went out of Stock.. Please select from available options");
			product();
		}
		
		System.out.println("\nPlease Enter the Quantity.");
		double quantity = Double.parseDouble(br.readLine()); 
		
		//Storing the user selected item in Cart (HashMap)
		displayitems.put(productBeauty,quantity);
		
		double totalCost = 0;
		while(result.next())
		{	
			String tempItem = result.getString("NAME");
			double tempCost = result.getDouble("PRICE");
			id = result.getInt("ID");
			
			//calculating total cost
			if(tempItem.equals(productBeauty))
			{
				customer.put(productBeauty, id);
				totalCost = quantity * tempCost;
				cost += totalCost;
				System.out.println("\nTotal Cost of Joy : " + cost);
			}
		}
		System.out.println("\n\nYou still want to add more Y/N ??");
		char repeat = br.readLine().charAt(0);
		switch(Character.toLowerCase(repeat))
		{
			case 'y' : product();
					   break;
			case 'n' : 
				       System.out.println("Do you want to proceed for Billing "+username);
				       String option=br.readLine();
				       if(option.equalsIgnoreCase("Y")) {
				       showBill();
				       }else {
				    	   System.out.println("Please proceed with payment: ");
				    	   payThroughWallet(username);
				       }
					   break;
			default:   System.out.println("\nPlease select the option that is available !! ");
					   shopping(username);
		}
	}
	public static void showBill() throws Exception
	{
		System.out.println("\n                                                   LIST FOR THE ITEM PURCHASED : \n");
		System.out.println("**********************************************************************************************************************************************************************************************************************");
		System.out.printf("                                      %-30s %20s", "ITEM NAME", "QUANTITY\n");
		System.out.println("**********************************************************************************************************************************************************************************************************************");
		
		
		//display cart items
		for(String itemName : displayitems.keySet()) 
		{
			System.out.format("                           %-30s %25s",itemName, displayitems.get(itemName) + "\n");
		}
		System.out.println("\n====================================================================================================================================================================================================================");
		System.out.println("                                                    Final Amount: "+cost);
		System.out.println("\n====================================================================================================================================================================================================================");
		System.out.println("\nDo you want to proceed for payment Y/N?");
		String decide = br.readLine();
		
		//check amount for order
		if(decide.equalsIgnoreCase("Y")) {
			payThroughWallet(username);
		}
		else {
			BeautyDestinationAdmin.user();
		}
	}

	//payment through wallet
	private static void payThroughWallet(String userName) throws Exception 
	{
		String sql = "SELECT AMOUNT FROM USER_AGENT3 WHERE USERNAME = '" + username+"'";
		Statement query = ConnectionManager.getConnection().createStatement();
		ResultSet result = query.executeQuery(sql);
		boolean notEmpty = result.next();
		
		int balance;
		while(notEmpty)
		{
			//inserting required data for billing
			balance = result.getInt("AMOUNT");
			if(balance > cost)
			{
				String sql2 = "INSERT INTO BILLAMOUNT(USERNAME,CUSTOMER_ID,PRODUCT,QUANTITY,COST) VALUES(?,?,?,?,?)";
				PreparedStatement query2 = ConnectionManager.getConnection().prepareStatement(sql2);
				query2.setString(1, username);
				
				for(String item : displayitems.keySet()) 
				{
					
					query2.setInt(2, customer.get(item));
					query2.setString(3, item);
					query2.setDouble(4, displayitems.get(item));
					query2.setDouble(5, prices.get(item));
					query2.execute();
				}
				System.out.println("                                                                                                                                                              ");
				System.out.println("\n\nPAYMENT SUCCESFULL..!!\n*********************************************************************************************THANKS FOR SHOPPING*********************************************************************************************\n\n\n*********************************************************************************************VISIT AGAIN "+username.toUpperCase()+"*********************************************************************************************");
				System.out.println("                                                                                                                                                              ");
				double remainingBalance = balance - cost;
				
				//updating amount column in database
				String sql1 = "UPDATE USER_AGENT3 SET AMOUNT = "+remainingBalance+" WHERE USERNAME = '"+username+"'";
				PreparedStatement query1 = ConnectionManager.getConnection().prepareStatement(sql1);
				query1.executeUpdate();
				ConvertToPDF.billPdf(displayitems,prices,username,cost);
				
			}
			notEmpty = result.next();
			break;	
			}
			
			
		}
		
		
	}
	
	

