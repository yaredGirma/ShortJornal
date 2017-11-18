package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Frequency;
import edu.mum.repository.FrequencyRepository;
import edu.mum.service.FrequencyService;

@Service
@Transactional
public class FrequencyServiceImpl implements FrequencyService {

	@Autowired
	FrequencyRepository frequencyRepository;

	@Override
	public Frequency save(Frequency frequency) {
		return frequencyRepository.save(frequency);
	}

	@Override
	public List<Frequency> getAll() {
		return (List<Frequency>) frequencyRepository.findAll();
	}

	@Override
	public Frequency get(Long id) {
		return frequencyRepository.findOne(id);
	}

}
