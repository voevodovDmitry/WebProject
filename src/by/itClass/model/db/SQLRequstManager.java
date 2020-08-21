package by.itClass.model.db;

import java.util.List;

import by.itClass.model.entities.Event;

public class SQLRequstManager {
	public static String getAddEventsSQL(List<Event> events) {
		final String BEGIN = "('"; 
		final String DELIMITER = "','";
		final String END = "'),";
		final String COMMA = ",";
		StringBuilder sqlBuilder = new StringBuilder(SQLRequests.ADD_EVENT);
		for (Event event : events) {
			sqlBuilder.append(BEGIN + event.getTime() + DELIMITER + event.getDescr() + END);
		}
		sqlBuilder.deleteCharAt(sqlBuilder.lastIndexOf(COMMA));
		return sqlBuilder.toString();
	}
}
