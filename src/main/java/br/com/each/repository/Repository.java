package br.com.each.repository;

import java.util.List;

import org.hibernate.Session;

public interface Repository<T> {

	public T load(Long id);

	public T save(T t);

	public T update(T t);

	public void delete(T t);

	public List<T> list();

	public void refresh(T t);

	public void merge(T t);

	public Session getSession();

}
