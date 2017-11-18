package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Feeling;
import edu.mum.repository.FeelingRepository;
import edu.mum.service.FeelingService;

@Service
@Transactional
public class FeelingServiceImpl implements FeelingService {

	@Autowired
	FeelingRepository feelingRepository;

	@Override
	public Feeling save(Feeling feeling) {
		return feelingRepository.save(feeling);
	}

	@Override
	public List<Feeling> getAll() {
		return (List<Feeling>) feelingRepository.findAll();
	}

	@Override
	public Feeling get(Long id) {
		return feelingRepository.findOne(id);
	}

}
