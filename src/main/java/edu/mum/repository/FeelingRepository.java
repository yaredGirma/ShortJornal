package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Feeling;

@Repository
public interface FeelingRepository extends CrudRepository<Feeling, Long>{

}
