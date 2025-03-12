package card;

import java.sql.Connection;
import java.sql.DriverManager;

public class BasicDAO {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private String id="system";
	private String pass="1111";
	private Connection conn=null;
	
	public BasicDAO() {
	
	}
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,id,pass);
			System.out.println("연결성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결오류");
		}
		return conn;
	}

}
