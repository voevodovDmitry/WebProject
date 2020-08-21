package by.itClass.model.enums;

import static by.itClass.model.db.SQLRequests.*;

public enum Operations {
	DELETE(DELETE_CONF),
	DONE(DONE_CONF);
	
	private String sql;
	
	private Operations(String sql) {
		this.sql = sql;
	}
	
	public String getSql() {
		return sql;
	}
	
}
