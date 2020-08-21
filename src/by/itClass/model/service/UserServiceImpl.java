package by.itClass.model.service;

import by.itClass.model.dao.IUserDAO;
import by.itClass.model.dao.UserDAOImpl;
import by.itClass.model.entities.User;
import by.itClass.model.exceptions.DAOException;
import by.itClass.model.exceptions.ServiceException;


public class UserServiceImpl implements IUserService {

	@Override
	public User getUser(String login, String password) throws ServiceException {
		IUserDAO userDAO = new UserDAOImpl();
		User user = null;
		try {
			user = userDAO.getUser(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return user;
	}

	@Override
	public boolean addUser(User user, String password) throws ServiceException {
		IUserDAO userService = new UserDAOImpl();
		boolean result = false;
		try {
			if (userService.addUser(user, password)) {
				result = true;
			}
			
			
		} catch (DAOException e) {			
			throw new ServiceException(e.getCause());
		}
		return result;
	}
	
	

}
