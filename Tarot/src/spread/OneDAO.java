package spread;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import card.BasicDAO;

public class OneDAO extends BasicDAO{
	
	private static OneDAO odao=null;
	
	public static OneDAO getInstance() {
		if(odao==null) {
			odao=new OneDAO();
		}
		return odao;
	}
	
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

	public void insert(OneDTO o) {
		PreparedStatement psmt=null;
		Connection conn=null;
		try {
			conn=getConnection();
			String sq1="INSERT INTO one_spread VALUES(osq.nextval,?,?,default,?)";
			psmt=conn.prepareStatement(sq1);
			psmt.setInt(1, o.getMnum());
			psmt.setString(2, o.getInterpret());
			psmt.setString(3, o.getUnum());
			psmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				psmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public void delete(String unum) {
		PreparedStatement psmt=null;
		Connection conn=null;
		try {
			conn=getConnection();
			String sq1="delete from one_spread where user_num=?";
			psmt=conn.prepareStatement(sq1);
			psmt.setString(1, unum);
			psmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				psmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
