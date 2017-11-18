package edu.mum.service;

import java.util.List;

import edu.mum.domain.Type;

public interface TypeService {
	public Type save(Type type);

	public List<Type> getAll();

	public Type get(Long id);
}
