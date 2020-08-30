package by.itClass.model.db;

public final class SQLRequests {
	public static final String SELECT_USER = "select * from users where login=? and password=?";
	
	public static final String ADD_USER = "insert into `itclass_po44`.`users` (`login`,`password`,`name`,`surname`,`email`)" +
			"VALUES ( ?, ?, ?, ?, ?);";

	
	public static final String SELECT_EVENTS = "select * from events "
												+ "join confevents on events.id=idEvent "
												+ "where idConf=?";
	public static final String SELECT_CONF = "select "
											+ "conferences.id, conferences.title, "
											+ "CONCAT(users.name, ' ', users.surname) as user, "
											+ "conferences.place, conferences.date,"
											+ "conferences.descr, conferences.state "
											+ "from conferences "
											+ "join users on conferences.idUser=users.id ";
	public static final String WHERE_TODAY = "where date=CURDATE()";
	public static final String WHERE_TOMORROW = "where date=DATE_ADD(CURDATE(), INTERVAL 1 DAY)";
	public static final String WHERE_SOMEDAY = "where date>DATE_ADD(CURDATE(), INTERVAL 1 DAY)";
	public static final String WHERE_OLD = "where date<CURDATE()";
	public static final String WHERE_ALL = "";
	public static final String WHERE_USER = "where idUser=?";
	
	public static final String ADD_CONF = "insert into conferences(title,idUser,place,date,descr) values(?,?,?,?,?)";
	
	public static final String ADD_EVENT = "insert into events(time,descr) values";
	
	public static final String ADD_RELATIONS = "insert into confevents(idConf,idEvent) values(?,?)";
	
	public static final String DELETE_CONF = "delete from conferences,confevents,events using confevents "
											+ "left join conferences on confevents.idConf=conferences.id "
											+ "left join events on confevents.idEvent=events.id "
											+ "where conferences.id=? and conferences.idUser=(select users.id from users where users.id=?)";
	
	public static final String DONE_CONF = "update conferences set state= -(state) where conferences.id=? and conferences.idUser=(select id from users where users.id=?)";
	
	public static final String ID_COL = "id";
	
	public static final String LOGIN_COL = "login";
	public static final String NAME_COL = "name";
	public static final String SURNAME_COL = "surname";
	public static final String EMAIL_COL = "email";
	
	public static final String TITLE_COL = "title";
	public static final String USER_COL = "user";
	public static final String PLACE_COL = "place";
	public static final String DATE_COL = "date";
	public static final String DESCR_COL = "descr";
	public static final String STATE_COL = "state";
	
	public static final String TIME_COL = "time";
	
}
