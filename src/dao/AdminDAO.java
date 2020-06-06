package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import model.User;
import utility.ConnectionManager;

public class AdminDAO implements AdminDaoInterface {

	public int signUp(Admin add) {
		try {
			Connection con=null;
			con=ConnectionManager.getConnection();
			int result=0;
			
			String sql="INSERT INTO ADMIN2(ADMIN_ID,NAME,USER_NAME, PASSWORD,CONFIRMPASSWORD,EMAIL, CONTACTDETAILS) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,add.getAdminId());
			pst.setString(2, add.getName());
			pst.setString(3, add.getUserName());
			pst.setString(4, add.getPassword());
			pst.setString(5, add.getConfirmPassword());
			pst.setString(6, add.getEmail());
			pst.setString(7, add.getContactDetails());
			result=pst.executeUpdate();
			return result;
			}
			catch (Exception e) {
				System.out.println(e);
			}
		return 0;
	}

	
	@Override
	public boolean loginUser(Admin add) {
		try {
			Connection con=ConnectionManager.getConnection();
			boolean result=false;
			PreparedStatement st=con.prepareStatement("SELECT * FROM ADMIN2 WHERE USER_NAME=? AND PASSWORD=?");
			st.setString(1, add.getUserName());
			st.setString(2, add.getPassword());
			
			ResultSet rs=st.executeQuery();
			result=rs.next();
			
			return result;
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
