package br.com.each.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.caelum.vraptor.ioc.Component;
import br.com.each.modelo.atividadefisica.AtividadeFisica;
import br.com.each.modelo.atividadefisica.DiaDaSemana;
import br.com.each.modelo.paciente.Paciente;
import br.com.each.modelo.user.User;
import br.com.each.repository.PacienteRepository;

@Component
@Qualifier(value = "pacientes")
@SuppressWarnings("unchecked")
public class PacienteDAO extends GenericDAO<Paciente> implements PacienteRepository {

	public PacienteDAO(Session session) {
		super(session);
	}

	@Override
	public void removeAllBy(User user) {
		List<Paciente> list = list(user);

		for (Paciente paciente : list) {
			getSession().delete(paciente);
		}
	}

	public List<Paciente> list(User user) {
		Query query = getSession().createQuery("FROM Paciente p WHERE p.user = :user");
		query.setParameter("user", user);

		return (List<Paciente>) query.list();
	}

	@Override
	public void removeAllAtividadesFisica(Paciente paciente) {
		for (AtividadeFisica atividadeFisica : paciente.getAtividadesFisica()) {
			getSession().delete(atividadeFisica);
		}
	}

	@Override
	public List<Paciente> buscaPacienteComAtividadePorDia(User user, Integer dia) {
		getSession().enableFilter("atividadesDia").setParameter("dia", dia);

		Query query = getSession().createQuery("FROM Paciente p WHERE p.user = :user");
		query.setParameter("user", user);

		return query.list();
	}

	@Override
	public List<Paciente> buscaPacienteComAtividadePorDiaDaSemana(User user, DiaDaSemana diaDaSemana) {
		getSession().enableFilter("atividadesDiaDaSemana").setParameter("diaDaSemana", diaDaSemana.ordinal());

		Query query = getSession().createQuery("FROM Paciente p WHERE p.user = :user");
		query.setParameter("user", user);

		return query.list();
	}

	public List<Paciente> buscaPacienteSemAtividadeSedentaria(User user) {
		getSession().enableFilter("atividadesSedentarias");

		Query query = getSession().createQuery("FROM Paciente p WHERE p.user = :user");
		query.setParameter("user", user);

		return query.list();
	}

}
