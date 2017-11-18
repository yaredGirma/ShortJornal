package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Duration;

@Repository
public interface DurationRepository extends CrudRepository<Duration, Long> {

}
