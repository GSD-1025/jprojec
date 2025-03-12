package spread;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import card.BasicDAO;

public class OneDAO extends BasicDAO{
	
	public ArrayList<OneDTO> loadOne(){
		ArrayList<OneDTO> olist=new ArrayList<>();
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=null;
		try {
			conn=getConnection();
			String sq1="select * FROM one_spread";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sq1);
			while(rs.next()) {
				OneDTO o=new OneDTO();
				o.setResnum(rs.getInt("res_num"));
				o.setMnum(rs.getInt("major_num"));
				o.setInterpret(rs.getString("interpret"));
				o.setDuedate(rs.getString("duedate"));
				o.setUnum(rs.getString("user_num"));
				olist.add(o);
			}
		} catch (Exception e) {
			
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				
			}
		}
		return olist;
	}
}
