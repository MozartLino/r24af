package br.com.each.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.caelum.vraptor.ioc.Component;
import br.com.each.modelo.user.User;
import br.com.each.repository.AtividadeFisicaRepository;
import br.com.each.repository.UserRepository;

@Component
@Qualifier(value = "users")
public class UserDAO extends GenericDAO<User> implements UserRepository {


	public UserDAO(Session session, AtividadeFisicaRepository atividadesFisica) {
		super(session);
	}

	@Override
	public User buscaPor(String login) {
		Query query = getSession().createQuery("FROM User u WHERE u.login = :login");
		query.setParameter("login", login);
		
		return (User) query.uniqueResult();
	}
	
}
