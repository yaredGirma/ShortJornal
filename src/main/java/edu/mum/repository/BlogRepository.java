package edu.mum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.domain.BlogPost;

@Repository
public interface BlogRepository extends CrudRepository<BlogPost, Long> {

}
