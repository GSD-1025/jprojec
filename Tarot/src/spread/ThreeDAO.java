package spread;

import java.sql.Connection;
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
				t.setCard1(rs.getInt("card1"));
				t.setCard2(rs.getInt("card2"));
				t.setCard3(rs.getInt("card3"));
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
	
}
