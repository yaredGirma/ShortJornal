package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Register;
import edu.mum.domain.UserCredentials;

@Repository
public interface RegisterRepository extends CrudRepository<Register, Long> {
	public Register findByUserCredentials(@Param("userCredentials") UserCredentials userCredentials);
}