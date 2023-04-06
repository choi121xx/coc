package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.bean.domain.UserBean;

public abstract class UserDao {
	
	//private SimpleConnectionMaker simpleConnectionMaker;
	private ConnectionMaker connectionMaker;
	
	public UserDao() {
		//simpleConnectionMaker = new SimpleConnectionMaker();
		connectionMaker = new DConnectionMaker();
	}

	public void add(UserBean user)throws ClassNotFoundException, SQLException{
		//Connection c = simpleConnectionMaker.makeNewConnection();
		Connection c = connectionMaker.makeConneciton();
		PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values(?,?,?)");
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());		
		ps.execute();		
		ps.close();
		c.close();		
	}
	
	public UserBean get(String id) throws ClassNotFoundException, SQLException {
		//Connection c = simpleConnectionMaker.makeNewConnection();	
		Connection c = connectionMaker.makeConneciton();	
		PreparedStatement ps = c.prepareStatement(
				"select * from users where id =?");
		ps.setString(1, id);		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		UserBean user = new UserBean();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		ps.close();
		c.close();
		return user;
	}

//	public abstract Connection getConnection() throws ClassNotFoundException, SQLException; 
//	{
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin","qwer1122!!");
//		return c;
//	}
}
