package edu.mum.service;

import java.util.List;

import edu.mum.domain.Event;
import edu.mum.domain.UserCredentials;

public interface EventService {
	public Event save(Event event);
	public List<Event> findAll();
	public Event findOne(Long id);
	public List<Event> findByUserCredentials(UserCredentials user);
	public List<Event> findByUser(UserCredentials user);
	public void delete(Event event);
}
