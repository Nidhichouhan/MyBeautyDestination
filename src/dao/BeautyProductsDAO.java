package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import model.Beauty_Products;
import utility.ConnectionManager;

public class BeautyProductsDAO implements BeautyProductsDaoInterface{
	public void insertProducts(Beauty_Products beauty){
		int i=0;
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql = "INSERT INTO BEAUTY_PRODUCTS(ID,NAME,DESCRIPTION, INGREDIENTS, INGREDIENTS_ID,PRICE,EXPIRY_DATE,QUANTITY) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);;
			st.setInt(1, beauty.getProductId());
			st.setString(2, beauty.getProductName());
			st.setString(3, beauty.getProductDescription());
			st.setString(4, beauty.getProductIngredients());
			st.setInt(5, beauty.getIngredientsId());
			st.setInt(6, beauty.getPrice());
			st.setDate(7, java.sql.Date.valueOf(beauty.getExpiryDate()));
			st.setInt(8, beauty.getQuantity());
		    st.executeUpdate();
			System.out.println("Inserted Successfully!");
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
//Delete a Beauty Product from Beauty_Product Table
	public void deleteProducts(int product_id) {
		try  {
			Connection con = ConnectionManager.getConnection();
			PreparedStatement st= con.prepareStatement("DELETE FROM BEAUTY_PRODUCTS WHERE ID = ?");
			st.setInt(1, product_id);
			int  rowDeleted = st.executeUpdate();
			if(rowDeleted>0)
				System.out.println("Product ID = "+product_id+" Deleted Successfully!");
			else
				System.out.println("Incorrect ID!");
		    con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}
//Update Beauty Product in Beauty product Table	
	public void updateProducts(int product_id) {
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = ConnectionManager.getConnection();
			PreparedStatement st = con.prepareStatement("UPDATE BEAUTY_PRODUCTS SET NAME = ? WHERE ID = ?");
		
			System.out.print("Edit Beauty Name : ");
			String product_name = sc.next();
			
			st.setString(1, product_name);
			st.setInt(2, product_id);
			
			int rowUpdated = st.executeUpdate();
			if(rowUpdated>0)
			System.out.println("Product ID = "+product_id+" Updated Successfully!");
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
