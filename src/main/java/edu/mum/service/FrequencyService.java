package edu.mum.service;

import java.util.List;

import edu.mum.domain.Frequency;

public interface FrequencyService {
	public Frequency save(Frequency frequency);
	
	public List<Frequency> getAll();

	public Frequency get(Long id);
}
