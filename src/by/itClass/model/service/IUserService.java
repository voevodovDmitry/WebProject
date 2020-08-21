package by.itClass.model.service;

import by.itClass.model.entities.User;
import by.itClass.model.exceptions.ServiceException;


public interface IUserService {
	User getUser(String login, String password) throws ServiceException;
	boolean addUser(User user, String password) throws ServiceException;
}

