package edu.mum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.domain.FeedBack;

@Repository
public interface FeedBackRepository extends CrudRepository<FeedBack, Long>{
	/*@Query("select p from PrivateMessage p where p.rideNumber = :rideNumber")
	public List<FeedBack> getMessageByrideNumber(@Param("rideNumber") int rideNumber);*/
}
