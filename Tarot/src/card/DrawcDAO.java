package card;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DrawcDAO extends BasicDAO{
	
	public ArrayList<DrawcDTO> drawload(){	
		ArrayList<DrawcDTO> dlist=new ArrayList<DrawcDTO>();
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=null;
		try {
			conn=getConnection();
			String sq1="select * FROM pull_card";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sq1);
			while(rs.next()) {
				DrawcDTO d=new DrawcDTO();
				d.setPnum(rs.getInt("pnum"));
				d.setCard1(rs.getInt("card1"));
				d.setCard2(rs.getInt("card2"));
				d.setCard3(rs.getInt("card3"));
				d.setCard4(rs.getInt("card4"));
				d.setCard5(rs.getInt("card5"));
				d.setCard6(rs.getInt("card6"));
				dlist.add(d);
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
		return dlist;
	
	}
	

}
