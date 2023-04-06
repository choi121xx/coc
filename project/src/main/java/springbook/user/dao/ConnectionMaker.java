package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	public Connection makeConneciton() throws ClassNotFoundException, SQLException;
}
