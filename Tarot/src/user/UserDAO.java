package user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import card.BasicDAO;

public class UserDAO extends BasicDAO{

	public ArrayList<UserDTO> loadUser(){
		ArrayList<UserDTO> ulist=new ArrayList<>();
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=null;
		try {
			conn=getConnection();
			String sq1="select * FROM userinfo";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sq1);
			while(rs.next()) {
				UserDTO u=new UserDTO();
				u.setName(rs.getString("name"));
				u.setUnum(rs.getString("user_num"));
				u.setAge(rs.getInt("age"));
				u.setPhone(rs.getString("ph_num"));
				ulist.add(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return ulist;		
	}
	
	
}
