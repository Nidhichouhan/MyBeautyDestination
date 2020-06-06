package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import utility.ConnectionManager;

public class BeautyProductsDisplay implements BeautyProductsDisplayInterface{

	@Override
	public void viewAllProductDetailsAdmin() {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT BEAUTY_PRODUCTS.ID,BEAUTY_PRODUCTS.NAME,BEAUTY_PRODUCTS.DESCRIPTION,BEAUTY_PRODUCTS.PRICE,BEAUTY_PRODUCTS.EXPIRY_DATE,BEAUTY_PRODUCTS.QUANTITY, INGREDIENTS.ID,INGREDIENTS.NAME FROM BEAUTY_PRODUCTS INNER JOIN INGREDIENTS ON BEAUTY_PRODUCTS.ID=INGREDIENTS.ID");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t\t\t"+rs.getInt(4)+"\t\t\t"+rs.getDate(5)+"\t\t\t"+rs.getInt(6)+"\t\t\t"+rs.getInt(7)+"\t\t\t"+rs.getString(8));
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		
	}

	@Override
	public void viewAllProductDetailsUser() {
		try {
		Connection con = ConnectionManager.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT NAME, DESCRIPTION, INGREDIENTS,PRICE, EXPIRY_DATE, QUANTITY FROM BEAUTY_PRODUCTS");
		while(rs.next())
		{ 
			System.out.printf("%-20s  %60s  %43s  %35s  %40s %38s  %n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getInt(6));
//			System.out.println(rs.getString(1)+"\t\t\t\t"+rs.getString(2)+"\t\t\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getInt(4)+"\t\t\t"+rs.getString(5)+"\t\t\t"+rs.getInt(6)+"In stock");
		}
		con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void searchbySkinType(String skin_type) {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT BEAUTY_PRODUCTS.NAME, BEAUTY_PRODUCTS.DESCRIPTION, SKIN_TYPE.NAME,BEAUTY_PRODUCTS.PRICE, BEAUTY_PRODUCTS.INGREDIENTS, BEAUTY_PRODUCTS.EXPIRY_DATE,INGREDIENTS.ISSUES_TARGETED FROM BEAUTY_PRODUCTS JOIN INGREDIENTS ON BEAUTY_PRODUCTS.INGREDIENTS_ID=INGREDIENTS.ID JOIN SKIN_TYPE ON INGREDIENTS.SKIN_ID=SKIN_TYPE.ID");
			while(rs.next())
			{
				
				if(skin_type.equals(rs.getString(3))) {
				System.out.printf("%-20s  %60s  %43s  %35s  %40s %38s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDate(6));
				System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
				System.out.println("Do you want to see which issues are generally resolved by this particular ingredient: [Y/N]");
				Scanner sc=new Scanner(System.in);
				String input=sc.next();
				if(input.equalsIgnoreCase("Y")) {
					System.out.println("*------------------------------------------------------------------------------------------------------*");
					System.out.println("                              View Issues Targeted                             ");
					System.out.println("*------------------------------------------------------------------------------------------------------*");
					System.out.printf("%-20s  %40s  %n","Ingredient_Name","Issues_Targeted\n");
					System.out.println("*------------------------------------------------------------------------------------------------------*");
					System.out.printf("%-20s  %40s  %n",rs.getString(5),rs.getString(7));
				
				}
				}
				
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	  }
	public void viewAllSkinCareProducts() {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT BEAUTY_PRODUCTS.NAME, BEAUTY_PRODUCTS.DESCRIPTION, BEAUTY_PRODUCTS.INGREDIENTS, BEAUTY_PRODUCTS.PRICE, BEAUTY_PRODUCTS.EXPIRY_DATE, BEAUTY_PRODUCTS.QUANTITY, INGREDIENTS.NAME, SKIN_TYPE.NAME, INGREDIENTS.ISSUES_TARGETED FROM BEAUTY_PRODUCTS JOIN INGREDIENTS ON BEAUTY_PRODUCTS.SKIN_ID=INGREDIENTS.SKIN_ID JOIN SKIN_TYPE ON INGREDIENTS.SKIN_ID=SKIN_TYPE.ID");
			while(rs.next())
			{
				
				System.out.printf("%-20s  %60s  %43s  %35s  %40s  %38s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getString(6));
			}
            System.out.println("-----------------------------------------------------------------------------------------------------------------");
			
			System.out.println("Do you want to see which issues are generally resolved by this particular ingredient: [Y/N]");
			Scanner sc=new Scanner(System.in);
			String input=sc.next();
			if(input.equalsIgnoreCase("Y")) {
				ResultSet rs1 = st.executeQuery("SELECT INGREDIENTS.NAME, INGREDIENTS.ISSUES_TARGETED FROM BEAUTY_PRODUCTS INNER JOIN INGREDIENTS ON BEAUTY_PRODUCTS.INGREDIENTS=INGREDIENTS.NAME INNER JOIN SKIN_TYPE ON INGREDIENTS.SKIN_ID=SKIN_TYPE.ID");
				System.out.println("*------------------------------------------------------------------------------------------------------*");
				System.out.println("                   View Issues Targeted                             ");
				System.out.println("*------------------------------------------------------------------------------------------------------*");
				System.out.printf("%-20s  %40s %n","Ingredient_Name","Issues_Targeted\n");
				System.out.println("*------------------------------------------------------------------------------------------------------*");
				while(rs1.next()) {
					System.out.printf("%-20s  %40s %n",rs1.getString(1),rs1.getString(2));	
				}
			
				System.out.println("*------------------------------------------------------------------------------------------------------*");
			}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}
	public void searchbySkinIssue(String skin_issue) {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT BEAUTY_PRODUCTS.NAME, BEAUTY_PRODUCTS.DESCRIPTION, BEAUTY_PRODUCTS.INGREDIENTS,BEAUTY_PRODUCTS.PRICE, BEAUTY_PRODUCTS.EXPIRY_DATE,ISSUE.NAME FROM BEAUTY_PRODUCTS INNER JOIN ISSUE ON BEAUTY_PRODUCTS.ISSUES_ID=ISSUE.ID");
			while(rs.next())
			{
				
				if(skin_issue.equals(rs.getString(6))) {
				System.out.printf("%-20s  %60s  %43s  %35s  %40s  %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5));
				System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
				
				}
				
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	  }
	public void viewAllHairCareProducts() {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT BEAUTY_PRODUCTS.NAME, BEAUTY_PRODUCTS.DESCRIPTION, BEAUTY_PRODUCTS.INGREDIENTS, BEAUTY_PRODUCTS.PRICE, BEAUTY_PRODUCTS.EXPIRY_DATE, HAIR_TYPE.NAME FROM BEAUTY_PRODUCTS INNER JOIN HAIR_TYPE ON BEAUTY_PRODUCTS.HAIR_TYPEID=HAIR_TYPE.ID");
			while(rs.next())
			{
				
				System.out.printf("%-20s  %60s  %43s  %35s  %40s  %38s %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5),rs.getString(6));
			}
			System.out.println("-----------------------------------------------------------------------------------------------------------------");
			
			System.out.println("Do you want to see which issues are generally resolved by this particular ingredient: [Y/N]");
			Scanner sc=new Scanner(System.in);
			String input=sc.next();
			if(input.equalsIgnoreCase("Y")) {
				ResultSet rs1 = st.executeQuery("SELECT INGREDIENTS.NAME, INGREDIENTS.ISSUES_TARGETED FROM BEAUTY_PRODUCTS INNER JOIN INGREDIENTS ON BEAUTY_PRODUCTS.INGREDIENTS=INGREDIENTS.NAME INNER JOIN HAIR_TYPE ON INGREDIENTS.HAIR_TYPE=HAIR_TYPE.ID");
				System.out.println("*------------------------------------------------------------------------------------------------------*");
				System.out.println("                   View Issues Targeted                             ");
				System.out.println("*------------------------------------------------------------------------------------------------------*");
				System.out.printf("%-20s  %40s %n","Ingredient_Name","Issues_Targeted\n");
				System.out.println("*------------------------------------------------------------------------------------------------------*");
				while(rs1.next()) {
					System.out.printf("%-20s  %40s %n",rs1.getString(1),rs1.getString(2));	
				}
				System.out.println("*------------------------------------------------------------------------------------------------------*");
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}
	public void searchbyHairType(String hair_type) {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT BEAUTY_PRODUCTS.NAME, BEAUTY_PRODUCTS.DESCRIPTION, HAIR_TYPE.NAME,BEAUTY_PRODUCTS.PRICE, BEAUTY_PRODUCTS.INGREDIENTS, BEAUTY_PRODUCTS.EXPIRY_DATE,INGREDIENTS.ISSUES_TARGETED FROM BEAUTY_PRODUCTS JOIN INGREDIENTS ON BEAUTY_PRODUCTS.INGREDIENTS_ID=INGREDIENTS.ID JOIN HAIR_TYPE ON INGREDIENTS.HAIR_TYPE=HAIR_TYPE.ID");
			while(rs.next())
			{
				
				if(hair_type.equals(rs.getString(3))) {
				System.out.printf("%-20s  %60s  %43s  %35s  %40s  %n",rs.getString(1),rs.getString(2),rs.getInt(4),rs.getString(5),rs.getDate(6));
				System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
				System.out.println("Do you want to see which issues are generally resolved by this particular ingredient: [Y/N]");
				Scanner sc=new Scanner(System.in);
				String input=sc.next();
				if(input.equalsIgnoreCase("Y")) {
					System.out.println("*------------------------------------------------------------------------------------------------------*");
					System.out.println("                              View Issues Targeted                             ");
					System.out.println("*------------------------------------------------------------------------------------------------------*");
					System.out.printf("%-20s  %40s %n","Ingredient_Name","Issues_Targeted\n");
					System.out.println("*------------------------------------------------------------------------------------------------------*");
					System.out.printf("%-20s  %40s %n",rs.getString(5),rs.getString(7));
				
				}
				}
				
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	  }
	public void searchbyHairIssue(String hair_issue) {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT BEAUTY_PRODUCTS.NAME, BEAUTY_PRODUCTS.DESCRIPTION, BEAUTY_PRODUCTS.INGREDIENTS,BEAUTY_PRODUCTS.PRICE, BEAUTY_PRODUCTS.EXPIRY_DATE,ISSUE.NAME FROM BEAUTY_PRODUCTS INNER JOIN ISSUE ON BEAUTY_PRODUCTS.ISSUES_ID=ISSUE.ID");
			while(rs.next())
			{
				
				if(hair_issue.equals(rs.getString(6))) {
				System.out.printf("%-20s  %60s  %43s  %35s  %40s  %n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDate(5));
				System.out.println("*------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*");
				
				}
				
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	  }
}
