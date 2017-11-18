package edu.mum.service;

import java.util.List;

import edu.mum.domain.Feeling;

public interface FeelingService {
	public Feeling save(Feeling feeling);
	
	public List<Feeling> getAll();

	public Feeling get(Long id);
}
