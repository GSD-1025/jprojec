package card;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
				MinorDTO c=new MinorDTO();
				c.setCardnum(rs.getString("card_num"));
				c.setSuits(rs.getString("suits"));
				c.setMean(rs.getString("mean"));
				c.setNum(rs.getInt("minor_num"));
				c.setImagepath(rs.getString("image_path"));
				/*System.out.println(c);
				System.out.println(c.getSuits());
				System.out.println(c.getMinornum());*/
				mlist.add(c);
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
		return mlist;
	}

}
