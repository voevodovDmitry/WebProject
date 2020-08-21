package by.itClass.model.factories;

import java.util.ArrayList;
import java.util.List;

import by.itClass.model.entities.Event;

public class EventFactory {
	public static List<Event> getEvents(String[] descrEvents, String[] timeEvents) {
		List<Event> events = new ArrayList<>();
		for (int i = 0; i < descrEvents.length; i++) {
			String time = timeEvents[i];
			String descr = descrEvents[i];
			events.add(new Event(time, descr));
		}
		return events;
	}
}
