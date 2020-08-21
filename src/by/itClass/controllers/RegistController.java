package by.itClass.controllers;

import static by.itClass.constants.Constants.*;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.itClass.constants.Constants;
import by.itClass.model.entities.User;

import by.itClass.model.service.IUserService;
import by.itClass.model.service.UserServiceImpl;



@WebServlet({ "/RegistController", "/regist" })
public class RegistController extends AbstactController {
	private static final long serialVersionUID = 1L;
       
   
    public RegistController() {
        super();       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String login = request.getParameter(Constants.LOGIN_LABEL);
		String name = request.getParameter(NAME_LABEL);
		String surname = request.getParameter(SURNAME_LABEL);		
		String email = request.getParameter(EMAIL_LABEL);		
		String password = request.getParameter(PASSWORD_LABEL);
		
		if (login == null || password == null || name == null || surname == null || email == null){
			jumpError(request, response, REGIST_JSP, PARAM_NULL_MESSAGE);
			return;
		}
		
		if (login.equals(EMPTY) || password.equals(EMPTY) || name.equals(EMPTY) || surname.equals(EMPTY) || email.equals(EMPTY)) {
			jumpError(request, response, REGIST_JSP, PARAM_EMPTY_MESSAGE);
			return;
		}
		
		User user = new User(login, name, surname, email);
		
		IUserService userService = new UserServiceImpl();
		
		try {
			if (userService.addUser(user, password)) {
				jump(request, response,  START_JSP);
			} else {
				jumpError(request, response, REGIST_JSP, FAILED_TO_REGISTER);
			}
						
		} catch (Exception e) {
			jumpError(request, response, LOGIN_JSP, e.getMessage());
		}
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
