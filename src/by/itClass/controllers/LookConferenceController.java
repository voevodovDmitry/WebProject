package by.itClass.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.itClass.constants.Constants.*;

import by.itClass.model.entities.Conference;
import by.itClass.model.exceptions.ServiceException;
import by.itClass.model.service.ConferenceServiceImpl;
import by.itClass.model.service.IConferenceService;

@WebServlet({ "/LookConferenceController", "/lookConf" })
public class LookConferenceController extends AbstactController {
	private static final long serialVersionUID = 1L;
   
	public LookConferenceController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idConf = request.getParameter(ID_LABEL);
		
		IConferenceService conferenceService = new ConferenceServiceImpl();
		
		try {
			HttpSession session = request.getSession(true);
			@SuppressWarnings("unchecked")
			List<Conference> conferences = (List<Conference>) session.getAttribute(CONF_LIST);
			Conference conference = conferenceService.getConference(idConf, conferences);
			request.setAttribute(CONF, conference);
			jump(request, response, CONF_JSP);
		} catch (ServiceException e) {
			jumpError(request, response, INDEX_JSP, e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
