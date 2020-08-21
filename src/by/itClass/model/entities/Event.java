package by.itClass.model.entities;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import by.itClass.constants.Constants;

public class Event {
	private int id;
	private Time time;
	private String descr;
	
	public Event() {
		super();
	}
	
	public Event(String time, String descr) {
		super();
		this.descr = descr;
		setTime(time);
	}
	
	public Event(int id, Time time, String descr) {
		super();
		this.id = id;
		this.time = time;
		this.descr = descr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(String time) {
		SimpleDateFormat format = new SimpleDateFormat(Constants.TIME_FORMAT);
		try {
			Date tempTime = format.parse(time);
			this.time = new Time(tempTime.getTime());
		} catch (ParseException e) {
			this.time = Time.valueOf(LocalTime.now());
		}
		
	}
	
	public void setTime(Time time) {
		this.time = time;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
	
}
