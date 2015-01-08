package br.com.each.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.caelum.vraptor.ioc.Component;
import br.com.each.modelo.atividade.Categoria;
import br.com.each.repository.CategoriaRepository;

@Component
@Qualifier(value = "categorias")
public class CategoriaDAO extends GenericDAO<Categoria> implements
		CategoriaRepository {

	public CategoriaDAO(Session session) {
		super(session);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> list() {

		Criteria criteria = this.getSession().createCriteria(Categoria.class);
		criteria.addOrder(Order.asc("nome"));
		return criteria.list();

	}
}
