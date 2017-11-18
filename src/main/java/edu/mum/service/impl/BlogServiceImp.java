package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.BlogPost;
import edu.mum.repository.BlogRepository;
import edu.mum.service.BlogService;
@Service
@Transactional
public class BlogServiceImp implements BlogService {
	
	@Autowired
	BlogRepository blogRepository;

	@Override
	public BlogPost save(BlogPost blogPost) {
		// TODO Auto-generated method stub
		return blogRepository.save(blogPost);
	}

	@Override
	public void remove(Long blogPost) {

		blogRepository.delete(blogPost);
		
	}

	@Override
	public BlogPost find(Long id) {
		// TODO Auto-generated method stub
		return blogRepository.findOne(id);
	}

	@Override
	public List<BlogPost> findAll() {
		// TODO Auto-generated method stub
		return (List<BlogPost>) blogRepository.findAll();
	}

}
