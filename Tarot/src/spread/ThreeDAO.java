package spread;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import card.BasicDAO;

public class ThreeDAO extends BasicDAO{
	
	public ArrayList<ThreeDTO> loadThree(){
		ArrayList<ThreeDTO> tlist= new ArrayList<>();
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=null;
		try {
			conn=getConnection();
			String sq1="select * FROM three_spread";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sq1);
			while(rs.next()) {
				ThreeDTO t=new ThreeDTO();
				t.setResnum(rs.getInt("res_num"));
				t.setUnum(rs.getString("user_num"));
				t.setInterway(rs.getString("interpret_way"));
				t.setInterpret(rs.getString("interpret"));
				t.setDuedate(rs.getString("duedate"));
				tlist.add(t);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return tlist;
	}
	public ArrayList<Integer> loadpnum(String unum){
		ArrayList<Integer> list= new ArrayList<>();
		PreparedStatement psmt=null;
		ResultSet rs=null;
		Connection conn=null;
		try {
			conn=getConnection();
			String sq1="select PNUM FROM three_spread where user_num=?";
			psmt=conn.prepareStatement(sq1);
			psmt.setString(1, unum);
			rs=psmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("pnum"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rs.close();
				psmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}

	public void insert(ThreeDTO t) {
		PreparedStatement psmt=null;
		Connection conn=null;
		try {
			conn=getConnection();
			String sq1="insert into three_spread values(tsq.nextval,?,?,?,?,default)";
			psmt=conn.prepareStatement(sq1);
			psmt.setString(1, t.getUnum());
			psmt.setInt(2, t.getPnum());
			psmt.setString(3, t.getInterway());
			psmt.setString(4, t.getInterpret());
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
			String sq1="delete from Three_spread where user_num=?";
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
