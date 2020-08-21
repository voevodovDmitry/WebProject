package by.itClass.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static by.itClass.model.db.SQLRequests.*;

import by.itClass.model.db.ConnectionManager;
import by.itClass.model.db.SQLRequstManager;
import by.itClass.model.entities.Conference;
import by.itClass.model.entities.Event;
import by.itClass.model.enums.Operations;
import by.itClass.model.enums.SectionConf;
import by.itClass.model.exceptions.DAOException;


public class ConferenceDAOImpl implements IConferenceDAO {

	@Override
	public List<Conference> getConferences(SectionConf section, int idUser) throws DAOException {
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		List<Conference> confList = new ArrayList<>();
		
		String sql = section.getSql();
		
		try {
			cn = ConnectionManager.getConnection();
			pst = cn.prepareStatement(sql);
			
			if (section == SectionConf.USER) {
				pst.setInt(1, idUser);
			}
			
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(ID_COL);
				String title = rs.getString(TITLE_COL);
				String user = rs.getString(USER_COL);
				String place = rs.getString(PLACE_COL);
				Date date = rs.getDate(DATE_COL);
				String descr = rs.getString(DESCR_COL);
				int state = rs.getInt(STATE_COL);
				Conference conference = new Conference(id, title, user, place, date, descr, state);
				getEvents(conference);
				confList.add(conference);
			}	
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return confList;
	}

	@Override
	public void getEvents(Conference conference) throws DAOException {
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		List<Event> events = new ArrayList<>();
		
		try {
			cn = ConnectionManager.getConnection();
			pst = cn.prepareStatement(SELECT_EVENTS);
			pst.setInt(1, conference.getId());
			rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(ID_COL);
				Time time = rs.getTime(TIME_COL);
				String descr = rs.getString(DESCR_COL);
				events.add(new Event(id, time, descr));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(pst);
		}
		conference.setEvents(events);
	}

	@Override
	public boolean addConference(Conference conference, int idUser) throws DAOException {
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		boolean result = false;
		
		try {
			cn = ConnectionManager.getConnection();
			pst = cn.prepareStatement(ADD_CONF, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, conference.getTitle());
			pst.setInt(2, idUser);
			pst.setString(3, conference.getPlace());
			pst.setDate(4, conference.getDate());
			pst.setString(5, conference.getDescr());
			result = pst.executeUpdate() > 0;
			rs = pst.getGeneratedKeys();
			if (rs.next()) {
				int idConf = rs.getInt(1);
				addEvents(conference.getEvents(), idConf);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(pst);
			ConnectionManager.closeConnection();
		}
		return result;
	}
	
	@Override
	public void addEvents(List<Event> events, int idConf) throws DAOException {
		Connection cn = null;
		PreparedStatement pstEvent = null;
		PreparedStatement pstRelation = null;
		ResultSet rs = null;
		
		String sql = SQLRequstManager.getAddEventsSQL(events);
	
		try {
			cn = ConnectionManager.getConnection();
			pstEvent = cn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
			if (pstEvent.executeUpdate() > 0) {
				pstRelation = cn.prepareStatement(ADD_RELATIONS);
				pstRelation.setInt(1, idConf);
				rs = pstEvent.getGeneratedKeys();
				while (rs.next()) {
					int idEvent = rs.getInt(1);
					pstRelation.setInt(2, idEvent);
					pstRelation.executeUpdate();
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			ConnectionManager.closeResultSet(rs);
			ConnectionManager.closeStatement(pstEvent);
			ConnectionManager.closeStatement(pstRelation);
			ConnectionManager.closeConnection();
		}
		
	}
	
	@Override
	public void changeConferences(Operations operation, String[] ids, int idUser) throws DAOException {
		Connection cn = null;
		PreparedStatement pst = null;
		
		String sql = operation.getSql();
		
		try {
			cn = ConnectionManager.getConnection();
			pst = cn.prepareStatement(sql);
			pst.setInt(2, idUser);
			for (String id : ids) {
				int idConf = Integer.parseInt(id);
				pst.setInt(1, idConf);
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			ConnectionManager.closeStatement(pst);
			ConnectionManager.closeConnection();
		}
	}
}





