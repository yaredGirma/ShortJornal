package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Event;
import edu.mum.domain.UserCredentials;
import edu.mum.repository.EventRepository;
import edu.mum.service.EventService;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	@Override
	public Event save(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public List<Event> findAll() {
		return (List<Event>) eventRepository.findAll();
	}

	@Override
	public Event findOne(Long id) {
		return eventRepository.findOne(id);
	}

	@Override
	public List<Event> findByUserCredentials(UserCredentials user) {
		return (List<Event>) eventRepository.findByUser(user);
	}

	@Override
	public List<Event> findByUser(UserCredentials user) {
		// TODO Auto-generated method stub
		return (List<Event>) eventRepository.findByUser(user);
	}

	@Override
	public void delete(Event event) {
		eventRepository.delete(event);
	}

}
