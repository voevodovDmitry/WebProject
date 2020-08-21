package by.itClass.model.dao;

import by.itClass.model.entities.User;
import by.itClass.model.exceptions.DAOException;


public interface IUserDAO {
	User getUser(String login, String password) throws DAOException;
	boolean addUser(User user, String password) throws DAOException;
}
