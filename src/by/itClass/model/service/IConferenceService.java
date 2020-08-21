package by.itClass.model.service;

import java.util.List;

import by.itClass.model.entities.Conference;
import by.itClass.model.enums.Operations;
import by.itClass.model.enums.SectionConf;
import by.itClass.model.exceptions.DAOException;
import by.itClass.model.exceptions.ServiceException;

public interface IConferenceService {
	List<Conference> getConferences(SectionConf section, int idUser) throws ServiceException;
	Conference getConference(String idConf, List<Conference> conferences) throws ServiceException;
	boolean addConference(Conference conference, int idUser) throws ServiceException;
	void changeConferences(Operations operation, String[] ids, int idUser) throws ServiceException;
}
