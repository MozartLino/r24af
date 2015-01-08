package br.com.each.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.caelum.vraptor.ioc.Component;
import br.com.each.modelo.atividadefisica.AtividadeFisica;
import br.com.each.repository.AtividadeFisicaRepository;

@Component
@Qualifier(value = "categorias")
public class AtividadeFisicaDAO extends GenericDAO<AtividadeFisica> implements AtividadeFisicaRepository {

	public AtividadeFisicaDAO(Session session) {
		super(session);
	}

	@Override
	public void clear() {
		this.getSession().clear();
	}
}
