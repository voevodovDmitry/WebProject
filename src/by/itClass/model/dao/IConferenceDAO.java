package by.itClass.model.dao;

import java.util.List;

import by.itClass.model.entities.Conference;
import by.itClass.model.entities.Event;
import by.itClass.model.enums.Operations;
import by.itClass.model.enums.SectionConf;
import by.itClass.model.exceptions.DAOException;

public interface IConferenceDAO {
	List<Conference> getConferences(SectionConf section, int idUser) throws DAOException;
	void getEvents(Conference conference) throws DAOException;
	boolean addConference(Conference conference, int idUser) throws DAOException;
	void addEvents(List<Event> events, int idConf) throws DAOException;
	void changeConferences(Operations operation, String[] ids, int idUser) throws DAOException;
}
