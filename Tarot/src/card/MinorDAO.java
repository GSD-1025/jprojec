package card;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import main.BasicDAO;

public class MinorDAO extends BasicDAO{
	
	public ArrayList<MinorDTO> loadMinor(){
		ArrayList<MinorDTO> mlist= new ArrayList<>();
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=null;
		try {
			conn=getConnection();
			String sq1="SELECT * FROM minor order by minor_num";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sq1);
			while(rs.next()) {
				if(rs.getString("card_num").equals("0000")) {
					rs.next();
				}
				MinorDTO c=new MinorDTO();
				c.setCardnum(rs.getString("card_num"));
				c.setSuits(rs.getString("suits"));
				c.setMean(rs.getString("mean"));
				c.setMinornum(rs.getInt("minor_num"));
				c.setImagepath(rs.getString("image_path"));
				mlist.add(c);
			}
		} catch (Exception e) {
			
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return mlist;
	}

}
