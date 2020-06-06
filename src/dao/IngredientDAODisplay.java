package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.IngredientDaoDisplayInterface;
import utility.ConnectionManager;

public class IngredientDAODisplay implements IngredientDaoDisplayInterface {

	@Override
	public void viewAllIngredientDetails() {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT ID,NAME,DESCRIPTION,ISSUES_TARGETED,SKIN_TYPE,SKIN_ID FROM INGREDIENTS");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(4)+"\t\t\t"+rs.getString(5)+"\t\t\t"+rs.getInt(6));
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		
	}
	

}
