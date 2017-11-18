package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.FeedBack;
import edu.mum.repository.FeedBackRepository;
import edu.mum.service.FeedBackService;

@Service
@Transactional 
public class FeedBackServiceImpl implements FeedBackService {

	@Autowired
	private FeedBackRepository feedbackRespository;
	

	@Override
	public void save(FeedBack privatemessage) {
		feedbackRespository.save(privatemessage);	
	}

	@Override
	public FeedBack findOne(Long id) {
		
		return feedbackRespository.findOne(id);
	}

	@Override
	public List<FeedBack> getAllFeedBacks() {
		return (List<FeedBack>) feedbackRespository.findAll();
	}


	/*@Override
	public List<FeedBack> findByRideNumber(int rideNumber) {
		return feedbackRespository.getMessageByrideNumber(rideNumber);
	}*/

	@Override
	public void delete(Long id) {
		feedbackRespository.delete(id);
		
	}

	

}
