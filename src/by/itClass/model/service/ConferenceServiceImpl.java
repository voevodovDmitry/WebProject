package by.itClass.model.service;

import java.util.List;

import by.itClass.model.dao.ConferenceDAOImpl;
import by.itClass.model.dao.IConferenceDAO;
import by.itClass.model.entities.Conference;
import by.itClass.model.enums.Operations;
import by.itClass.model.enums.SectionConf;
import by.itClass.model.exceptions.DAOException;
import by.itClass.model.exceptions.ServiceException;

public class ConferenceServiceImpl implements IConferenceService {
	private IConferenceDAO conferenceDAO;
	
	public ConferenceServiceImpl() {
		super();
		conferenceDAO = new ConferenceDAOImpl();
	}

	@Override
	public List<Conference> getConferences(SectionConf section, int idUser) throws ServiceException {
		List<Conference> confList = null;
		try {
			confList = conferenceDAO.getConferences(section, idUser);
			return confList;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Conference getConference(String idConf, List<Conference> conferences) throws ServiceException {
		try {
			int id = Integer.parseInt(idConf);
			int index = conferences.indexOf(new Conference(id));
			return conferences.get(index);
		} catch (NumberFormatException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean addConference(Conference conference, int idUser) throws ServiceException {
		try {
			return conferenceDAO.addConference(conference, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void changeConferences(Operations operation, String[] ids, int idUser) throws ServiceException {
		try {
			conferenceDAO.changeConferences(operation, ids, idUser);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}

}
