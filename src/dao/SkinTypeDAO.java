package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import model.Beauty_Products;
import model.Skin_Type;
import utility.ConnectionManager;

public class SkinTypeDAO implements SkinTypeDaoInterface{
	 public void insertSkinType(Skin_Type skinType){
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql = "INSERT INTO SKIN_TYPE(ID,NAME) VALUES(?,?)";
			PreparedStatement st = con.prepareStatement(sql);;
			st.setInt(1, skinType.getSkinTypeId());
			st.setString(2, skinType.getSkinTypeName());
			
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
	public void deleteSkinType(int skin_id) {
		try  {
			Connection con = ConnectionManager.getConnection();
			PreparedStatement st= con.prepareStatement("DELETE FROM SKIN_TYPE WHERE ID = ?");
			st.setInt(1, skin_id);
			int  rowDeleted = st.executeUpdate();
			if(rowDeleted>0)
				System.out.println("Skin Type ID = "+skin_id+" Deleted Successfully!");
			else
				System.out.println("Incorrect ID!");
		    con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}
//Update Beauty Product in Beauty product Table	
	public void updateSkinType(int skin_id) {
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = ConnectionManager.getConnection();
			PreparedStatement st = con.prepareStatement("UPDATE SKIN_TYPE SET NAME = ? WHERE ID = ?");
		
			System.out.print("Edit Skin Type Name : ");
			String skinType_name = sc.next();
			
			st.setString(1, skinType_name);
			st.setInt(2, skin_id);
			
			int rowUpdated = st.executeUpdate();
			if(rowUpdated>0)
			System.out.println("Product ID = "+skin_id+" Updated Successfully!");
		
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

