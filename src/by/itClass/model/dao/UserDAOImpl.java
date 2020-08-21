package by.itClass.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.itClass.model.db.SQLRequests.*;

import by.itClass.model.db.ConnectionManager;
import by.itClass.model.entities.User;
import by.itClass.model.exceptions.DAOException;



public class UserDAOImpl implements IUserDAO {
	private static final String LOCK = new String();
	@Override
	public User getUser(String login, String password) throws DAOException {
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		User user = null;
		
		try {
			cn = ConnectionManager.getConnection();
			pst = cn.prepareStatement(SELECT_USER);
			pst.setString(1, login);
			pst.setString(2, password);
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt(ID_COL);
				String name = rs.getString(NAME_COL);
				String surname = rs.getString(SURNAME_COL);
				String email = rs.getString(EMAIL_COL);
				user = new User(id, login, name, surname, email);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}	
		return user;
	}
	
	@Override
	public boolean addUser(User user, String password) throws DAOException {
		
		Connection cn = null;
		PreparedStatement pst = null;
		boolean result = false;
		
		try {
			cn = ConnectionManager.getConnection();
			pst = cn.prepareStatement(ADD_USER);
			pst.setString(1, user.getLogin());
			pst.setString(2, password);
			pst.setString(3, user.getName());
			pst.setString(4, user.getSurname());
			pst.setString(5, user.getEmail());
			
			
			synchronized (LOCK) {
				result = pst.executeUpdate() > 0;	
			}
			
			
		} catch (Exception e) {
			throw new DAOException(e);
		}
		return result;
	}

}
