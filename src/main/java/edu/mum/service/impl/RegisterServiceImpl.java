package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Register;
import edu.mum.domain.UserCredentials;
import edu.mum.repository.RegisterRepository;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional
public class RegisterServiceImpl implements edu.mum.service.RegisterService {

	@Autowired
	private RegisterRepository registerRepository;

	@Autowired
	UserCredentialsService credentialsService;

	public void save(Register register) {
		registerRepository.save(register);
	}

	@Override
	public void saveFull(Register register) {
		credentialsService.save(register.getUserCredentials());
		registerRepository.save(register);
	}

	public List<Register> findAll() {
		return (List<Register>) registerRepository.findAll();
	}

	public Register findOne(Long id) {
		return registerRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		registerRepository.delete(id);

	}

	@Override
	public Register findByUserCredentials(UserCredentials userCredentials) {
		return registerRepository.findByUserCredentials(userCredentials);
	}

}
