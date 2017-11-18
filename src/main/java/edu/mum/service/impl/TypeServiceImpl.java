package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Type;
import edu.mum.repository.TypeRepository;
import edu.mum.service.TypeService;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	@Autowired
	TypeRepository typeRepository;

	@Override
	public Type save(Type type) {
		return typeRepository.save(type);
	}

	@Override
	public List<Type> getAll() {
		return (List<Type>) typeRepository.findAll();
	}

	@Override
	public Type get(Long id) {
		return typeRepository.findOne(id);
	}

}
