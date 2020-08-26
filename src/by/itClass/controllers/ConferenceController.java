package by.itClass.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.itClass.constants.Constants;
import by.itClass.model.entities.Conference;
import by.itClass.model.entities.User;
import by.itClass.model.enums.SectionConf;
import by.itClass.model.enums.EnumManager;
import by.itClass.model.exceptions.ServiceException;
import by.itClass.model.service.ConferenceServiceImpl;
import by.itClass.model.service.IConferenceService;
import static by.itClass.constants.Constants.*;

@WebServlet({ "/ConferenceController", "/confCont" })
public class ConferenceController extends AbstactController {
	private static final long serialVersionUID = 1L;
       
    public ConferenceController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String section = request.getParameter(SECTION_LABEL);
		String sectionNumber = section;
		String header = response.getHeader(SECTION_LABEL);
		System.out.println(section);
	
		if (header != null) {
			section = header;
		}
	
		IConferenceService conferenceService = new ConferenceServiceImpl();
		
		try {
			HttpSession session = request.getSession(true);
			User user = (User) session.getAttribute(USER);
			SectionConf sect = EnumManager.getKindSectionConf(section);
			List<Conference> confList = conferenceService.getConferences(sect, user.getId());
			session.setAttribute(CONF_LIST, confList);
			session.setAttribute("sectionNumber", sectionNumber);
			if (sect == SectionConf.USER) {
				jump(request, response, HOME_JSP);
			} else {
				jump(request, response, INDEX_JSP);
			}
		} catch (ServiceException e) {
			jumpError(request, response, INDEX_JSP, e.getMessage());
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
