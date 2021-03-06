package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utility.ConnectionManager;

public class SkinTypeDaoDisplay implements SkinTypeDaoDisplayInterface{

	@Override
	public void viewAllSkinTypeDetails() {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT ID,NAME FROM SKIN_TYPE");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t\t"+rs.getString(2));
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		
		
	}

}
