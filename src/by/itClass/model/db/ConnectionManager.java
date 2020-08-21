package by.itClass.model.db;

import static by.itClass.model.db.DBConstants.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	private static Connection cn = null;
	
	static {
		try {
			Class.forName(DRIVER_DB);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			if (cn == null || cn.isClosed()) {
				cn = DriverManager.getConnection(URL_DB + NAME_DB + PARAMS_FOR_DB, USER_DB, PASSWORD_DB);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
	
	public static void closeConnection() {
		if (cn != null) {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
