package by.itClass.model.entities;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import by.itClass.constants.Constants;

public class Conference {
	private int id;
	private String title;
	private String user;
	private String place;
	private Date date;
	private String descr;
	private int state;
	private List<Event> events;
	
	public Conference() {
		super();
	}

	public Conference(int id) {
		super();
		this.id = id;
	}
	
	public Conference(String title, String place, String date, String descr, List<Event> events) {
		super();
		this.title = title;
		this.place = place;
		this.descr = descr;
		setDate(date);
		this.events = events;
	}

	public Conference(int id, String title, String user, String place, Date date, String descr, int state) {
		super();
		this.id = id;
		this.title = title;
		this.user = user;
		this.place = place;
		this.date = date;
		this.descr = descr;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public void setDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
		java.util.Date tempDate = null;
		try {
			tempDate = format.parse(date);
			this.date = new Date(tempDate.getTime());
		} catch (ParseException e) {
			this.date = Date.valueOf(LocalDate.now());
		}
		
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conference other = (Conference) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}