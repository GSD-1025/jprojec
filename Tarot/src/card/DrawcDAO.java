package card;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	public int pnumload(DrawcDTO d) {
		int pnum=0;
		PreparedStatement psmt=null;
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			String sq1="select pnum from pull_card where card1=? and card2=? and card3=? and card4=? and card5=? and card6=?";
			psmt=conn.prepareStatement(sq1);
			psmt.setInt(1, d.getCard1());
			psmt.setInt(2, d.getCard2());
			psmt.setInt(3, d.getCard3());
			psmt.setInt(4, d.getCard4());
			psmt.setInt(5, d.getCard5());
			psmt.setInt(6, d.getCard6());
			rs=psmt.executeQuery();
			rs.next();
			pnum=rs.getInt("pnum");
		} catch (Exception e) {
			
		}finally {
			try {
				rs.close();
				psmt.close();
				conn.close();
			} catch (Exception e2) {
				
			}
		}
		return pnum;
	}
	
	
 	public void insert(DrawcDTO d) {
		PreparedStatement psmt=null;
		Connection conn=null;
		try {
			conn=getConnection();
			String sq1="insert into pull_card values(psq.nextval,?,?,?,?,?,?)";
			psmt=conn.prepareStatement(sq1);
			psmt.setInt(1, d.getCard1());
			psmt.setInt(2, d.getCard2());
			psmt.setInt(3, d.getCard3());
			psmt.setInt(4, d.getCard4());
			psmt.setInt(5, d.getCard5());
			psmt.setInt(6, d.getCard6());
			psmt.execute();
		} catch (Exception e) {
			
		}finally {
			try {
				psmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public void delete(int i) {
		PreparedStatement psmt=null;
		Connection conn=null;
		try {
			conn=getConnection();
			String sq1="delete from pull_card where pnum=?";
			psmt=conn.prepareStatement(sq1);
			psmt.setInt(1,i);
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
