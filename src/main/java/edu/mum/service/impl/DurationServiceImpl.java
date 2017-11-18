package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Duration;
import edu.mum.repository.DurationRepository;
import edu.mum.service.DurationService;

@Service
@Transactional
public class DurationServiceImpl implements DurationService {

	@Autowired
	DurationRepository durationRepository;

	@Override
	public Duration save(Duration duration) {
		return durationRepository.save(duration);
	}

	@Override
	public List<Duration> getAll() {
		return (List<Duration>) durationRepository.findAll();
	}

	@Override
	public Duration get(Long id) {
		return durationRepository.findOne(id);
	}

}
