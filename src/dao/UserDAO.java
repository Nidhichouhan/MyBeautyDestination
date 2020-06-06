package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface{

	@Override
	public int signUp(User user) {
		try {
		Connection con=null;
		con=ConnectionManager.getConnection();
		int result=0;
		
		String sql="INSERT INTO USER_AGENT3(ID,NAME,EMAIL,USERNAME,PASSWORD,CONFIRMPASSWORD,CONTACTDETAILS,ADDRESS,AMOUNT) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, user.getUserId());
		pst.setString(2, user.getName());
		pst.setString(3, user.getEmail());
		pst.setString(4, user.getUserName());
		pst.setString(5, user.getPassword());
		pst.setString(6, user.getConfirmpassword());
		pst.setString(7, user.getContactNumber());
		pst.setString(8, user.getAddress());
		pst.setInt(9, user.getAmount());
		
		
		result=pst.executeUpdate();
		return result;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	@Override
	public boolean loginUser(User user) {
		
		try {
			Connection con=ConnectionManager.getConnection();
			boolean result=false;
			PreparedStatement st=con.prepareStatement("SELECT * FROM USER_AGENT3 WHERE USERNAME=? AND PASSWORD=?");
			st.setString(1, user.getUserName());
			st.setString(2, user.getPassword());
			
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

	@Override
	public void viewUserDetails() {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT ID,NAME,EMAIL,CONTACTDETAILS FROM USER_AGENT3");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4));
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		
	}
	
}