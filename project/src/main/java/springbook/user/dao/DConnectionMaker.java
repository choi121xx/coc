package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{
	public Connection makeConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin","qwer1122!!");
		return c;
	}

	@Override
	public Connection makeConneciton() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
