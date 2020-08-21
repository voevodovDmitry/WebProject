package by.itClass.model.enums;

import static by.itClass.model.db.SQLRequests.*;

public enum SectionConf {
	TODAY (WHERE_TODAY),
	TOMORROW (WHERE_TOMORROW),
	SOMEDAY (WHERE_SOMEDAY),
	OLD (WHERE_OLD),
	ALL(WHERE_ALL),
	USER(WHERE_USER);
	
	private String sql;
	
	private SectionConf(String sql) {
		this.sql = sql;
	}
	
	public String getSql() {
		return SELECT_CONF + sql;
	}

}
