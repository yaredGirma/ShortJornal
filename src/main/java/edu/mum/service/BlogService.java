package edu.mum.service;

import java.util.List;

import edu.mum.domain.BlogPost;

public interface BlogService {

	public BlogPost save(BlogPost blogPost);

//	public BlogPost edit(BlogPost blogPost);

	public void remove(Long blogId);

	public BlogPost find(Long id);

	public List<BlogPost> findAll();

}
