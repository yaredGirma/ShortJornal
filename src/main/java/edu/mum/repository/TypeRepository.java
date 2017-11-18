package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.Type;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long>{

}
