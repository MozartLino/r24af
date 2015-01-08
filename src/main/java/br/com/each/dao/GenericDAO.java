package br.com.each.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;

@SuppressWarnings("unchecked")
@Component
public class GenericDAO<T> {

	private final Class<T> persistentClass;

	private Session session;

	public GenericDAO(Session session) {
		this.session = session;
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T load(Long id) {
		return (T) this.getSession().get(this.persistentClass, id);
	}

	public T save(T t) {
		this.getSession().persist(t);
		return t;
	}

	public T update(T t) {
		this.getSession().update(t);
		return t;
	}

	public void delete(T t) {
		this.getSession().delete(t);
	}

	public List<T> list() {
		return this.getSession().createCriteria(this.persistentClass).list();
	}

	public void refresh(T t) {
		this.getSession().refresh(t);
	}

	public void merge(T t) {
		this.getSession().merge(t);
	}

	public Session getSession() {
		return session;
	}

}