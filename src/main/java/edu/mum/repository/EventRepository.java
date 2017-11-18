package edu.mum.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Event;
import edu.mum.domain.UserCredentials;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	
	public List<Event> findByUser(@Param("user") UserCredentials user);
}
