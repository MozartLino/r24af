package br.com.each.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.caelum.vraptor.ioc.Component;
import br.com.each.modelo.atividade.Atividade;
import br.com.each.modelo.atividade.Categoria;
import br.com.each.repository.AtividadeRepository;

@Component
@Qualifier(value = "atividades")
@SuppressWarnings("unchecked")
public class AtividadeDAO extends GenericDAO<Atividade> implements AtividadeRepository {

	public AtividadeDAO(Session session) {
		super(session);
	}

	@Override
	public List<Atividade> listaPor(String nome) {
		Query query = getSession().createQuery("SELECT a FROM Atividade a WHERE a.nome like :nome");
		query.setParameter("nome", "%" + nome + "%");

		return query.list();
	}

	@Override
	public List<Atividade> listaPor(String nome, Categoria categoria) {
		Query query = getSession().createQuery("SELECT a FROM Atividade a WHERE a.categoria = :categoria and a.nome like :nome");
		query.setParameter("nome", "%" + nome + "%");
		query.setParameter("categoria", categoria);

		return query.list();
	}

	@Override
	public List<Atividade> listaPor(Categoria categoria) {
		Query query = getSession().createQuery("SELECT a FROM Atividade a WHERE a.categoria = :categoria");
		query.setParameter("categoria", categoria);

		return query.list();
	}

}
