package edu.mum.service;

import java.util.List;

import edu.mum.domain.FeedBack;


public interface FeedBackService {

	public void save(FeedBack feedBack);

	public List<FeedBack> getAllFeedBacks();

	public FeedBack findOne(Long id);

	public void delete(Long id);
	
	/*public List<FeedBack> findByRideNumber(int rideNumber);*/
}
