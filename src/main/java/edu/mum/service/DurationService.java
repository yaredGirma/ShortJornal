package edu.mum.service;

import java.util.List;

import edu.mum.domain.Duration;

public interface DurationService {
	public Duration save(Duration duration);
	
	public List<Duration> getAll();

	public Duration get(Long id);
}
