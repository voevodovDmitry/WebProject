package by.itClass.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.itClass.model.entities.User;
import by.itClass.model.enums.EnumManager;
import by.itClass.model.enums.Operations;
import by.itClass.model.exceptions.ServiceException;
import by.itClass.model.service.ConferenceServiceImpl;
import by.itClass.model.service.IConferenceService;

import static by.itClass.constants.Constants.*;

@WebServlet({ "/OperationConferenceController", "/operation" })
public class OperationConferenceController extends AbstactController {
	private static final long serialVersionUID = 1L;
       
    public OperationConferenceController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oper = request.getParameter(OPERATION_LABEL);
		String[] ids = request.getParameterValues(IDS_LABEL);
		
		IConferenceService conferenceService = new ConferenceServiceImpl();
		
		try {
			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute(USER);
			Operations operation = EnumManager.getKindOperation(oper);
			conferenceService.changeConferences(operation, ids, user.getId());
			response.sendRedirect(getServletContext().getContextPath() + CONF_CONT);
		} catch (ServiceException e) {
			e.printStackTrace();
			jumpError(request, response, HOME_JSP, e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
