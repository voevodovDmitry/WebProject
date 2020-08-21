package by.itClass.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.itClass.model.entities.Conference;
import by.itClass.model.entities.Event;
import by.itClass.model.entities.User;
import by.itClass.model.exceptions.ServiceException;
import by.itClass.model.factories.EventFactory;
import by.itClass.model.service.ConferenceServiceImpl;
import by.itClass.model.service.IConferenceService;

import static by.itClass.constants.Constants.*;

@WebServlet({ "/AddConferenceController", "/addConf" })
public class AddConferenceController extends AbstactController {
	private static final long serialVersionUID = 1L;
       
    public AddConferenceController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter(TITLE_LABEL);
		String place = request.getParameter(PLACE_LABEL);
		String date = request.getParameter(DATE_LABEL);
		String descrConf = request.getParameter(DESCR_CONF_LABEL);
		
		String[] timeEvents = request.getParameterValues(TIMES_LABEL);
		String[] descrEvents = request.getParameterValues(DESCR_EVENTS_LABEL);
		
		System.out.println(date);
		IConferenceService conferenceService = new ConferenceServiceImpl();
		
		try {
			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute(USER);
			List<Event> events = EventFactory.getEvents(descrEvents, timeEvents);
			Conference conference = new Conference(title, place, date, descrConf, events);
			if (conferenceService.addConference(conference, user.getId())) {
				response.setHeader(SECTION_LABEL, SECTION_USER);
				response.sendRedirect(getServletContext().getContextPath() + CONF_CONT);
			} else {
				jumpError(request, response, ADD_CONF_JSP, FAIL_ADD_CONF_MESSAGE);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			jumpError(request, response, ADD_CONF_JSP, e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
