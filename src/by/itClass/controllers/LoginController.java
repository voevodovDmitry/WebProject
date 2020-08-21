package by.itClass.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.itClass.loggers.LoggerManager;
import by.itClass.model.entities.User;
import by.itClass.model.exceptions.ServiceException;
import by.itClass.model.service.IUserService;
import by.itClass.model.service.UserServiceImpl;

import static by.itClass.constants.Constants.*;

@WebServlet({ "/LoginController", "/login" })
public class LoginController extends AbstactController {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(LOGIN_LABEL);
		String password = request.getParameter(PASSWORD_LABEL);
		
		if (login == null || password == null) {
			jumpError(request, response, LOGIN_JSP, PARAM_NULL_MESSAGE);
			return;
		}
		
		if (login.equals(EMPTY) || password.equals(EMPTY)) {
			jumpError(request, response, LOGIN_JSP,PARAM_EMPTY_MESSAGE);
			return;
		}
		
		IUserService userService = new UserServiceImpl();
		
		try {
			User user = userService.getUser(login, password);
			
			if (user != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute(USER, user);
				jump(request, response, CONF_CONT);
			} else {
				LoggerManager.LOGGER.info("User: " + login + ";"  + INCORRECT_LOG_PASS_MESSAGE );
				jumpError(request, response, LOGIN_JSP, INCORRECT_LOG_PASS_MESSAGE);
			}
		} catch (ServiceException e) {
			LoggerManager.LOGGER.info(e.getMessage());
			jumpError(request, response, LOGIN_JSP, e.getMessage());
		}
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}










