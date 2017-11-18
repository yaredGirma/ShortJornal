package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Frequency;

@Repository
public interface FrequencyRepository extends CrudRepository<Frequency, Long> {

}
