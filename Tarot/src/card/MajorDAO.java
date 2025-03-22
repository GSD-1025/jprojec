package card;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MajorDAO extends BasicDAO{

	
	public ArrayList<MajorDTO> loadMajor() {
		ArrayList<MajorDTO> mlist= new ArrayList<>();
		Statement stmt=null;
		ResultSet rs=null;
		Connection conn=null;
		try {
			conn=getConnection();
			String sq1="select * FROM major";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sq1);
			while(rs.next()) {
				if(rs.getString("card_num").equals("0000")) {
					rs.next();
				}
				MajorDTO c= new MajorDTO();
				c.setCardnum(rs.getString("card_num"));
				c.setName(rs.getString("name"));
				c.setWay(rs.getString("way"));
				c.setMean(rs.getString("mean"));
				c.setMajornum(rs.getInt("major_num"));
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
