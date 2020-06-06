package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import model.Beauty_Products;
import model.Ingredients;
import utility.ConnectionManager;

public class IngredientsDAO implements IngredientsDaoInterface{
	public void insertIngredients(Ingredients ingredients){
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql = "INSERT INTO INGREDIENTS(ID,NAME,DESCRIPTION, ISSUES_TARGETED, SKIN_TYPE,SKIN_ID) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);;
			st.setInt(1, ingredients.getIngredientsId());
			st.setString(2, ingredients.getName());
			st.setString(3, ingredients.getDescription());
			st.setString(4, ingredients.getIssuesTargeted());
			st.setString(5, ingredients.getSkinType());
			st.setInt(6, ingredients.getSkinId());
			
			int rowInserted = st.executeUpdate();
			if (rowInserted > 0)
				System.out.println("Inserted Successfully!");
			else
				System.out.println("Insert Failed");
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}


	//Delete a Beauty Product from Beauty_Product Table
	@Override
	public void deleteIngredients(int ingredient_id) {
		try  {
			Connection con = ConnectionManager.getConnection();
			PreparedStatement st= con.prepareStatement("DELETE FROM INGREDIENTS WHERE ID = ?");
			st.setInt(1, ingredient_id);
			int  rowDeleted = st.executeUpdate();
			if(rowDeleted>0)
				System.out.println("Ingredient ID = "+ingredient_id+" Deleted Successfully!");
			else
				System.out.println("Incorrect ID!");
		    con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		
	}
	
	//Update Beauty Product in Beauty product Table	
	@Override
	public void updateIngredients(int ingredient_id) {
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = ConnectionManager.getConnection();
			PreparedStatement st = con.prepareStatement("UPDATE INGREDIENTS SET NAME = ? WHERE ID = ?");
		
			System.out.print("Edit Ingredient Name : ");
			String product_name = sc.next();
			
			st.setString(1, product_name);
			st.setInt(2, ingredient_id);
			
			int rowUpdated = st.executeUpdate();
			if(rowUpdated>0)
			System.out.println("Ingredient ID = "+ingredient_id+" Updated Successfully!");
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
