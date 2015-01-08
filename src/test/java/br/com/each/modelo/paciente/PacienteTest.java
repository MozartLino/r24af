package br.com.each.modelo.paciente;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.each.modelo.atividade.Atividade;
import br.com.each.modelo.atividade.Categoria;
import br.com.each.modelo.atividadefisica.AtividadeFisica;
import br.com.each.modelo.user.User;

public class PacienteTest {

	public static Session session;

	public static SessionFactory sessionFactory;

	@Test
	public void testaOcalculoBasalTotalPorPaciente() throws ParseException {
		User user = new User("teste", "senha");
		Pessoa pessoa = new Pessoa("Ricardo Mozart Lino", "kadu.m.lino@hotmail.com", Sexo.Masculino, 170D,
				"23/03/2013", 70d);
		Paciente paciente = new Paciente(pessoa, user);

		Categoria categoria = new Categoria("categoria");
		Atividade atividade = new Atividade("Atividade", 8, categoria);

		AtividadeFisica atividadeFisica = new AtividadeFisica(atividade, 01, 02, 00, 00, 1);
		AtividadeFisica atividadeFisica2 = new AtividadeFisica(atividade, 01, 02, 00, 00, 1);

		session.save(user);
		session.save(pessoa);
		session.save(categoria);
		session.save(atividade);
		session.save(paciente);
		session.save(atividadeFisica);
		session.save(atividadeFisica2);

		paciente.addAtividadeFisica(atividadeFisica);
		paciente.addAtividadeFisica(atividadeFisica2);
		session.update(paciente);
		assertTrue("Erro no calculo de caloria", paciente.getCaloriaTotal() == 1120);
	}

	@Before
	public void init() {

		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction().begin();
		session.createSQLQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
		session.createSQLQuery("truncate table r24af.Paciente").executeUpdate();
		session.createSQLQuery("truncate table r24af.User").executeUpdate();
		session.createSQLQuery("truncate table r24af.Categoria").executeUpdate();
		session.createSQLQuery("truncate table r24af.Atividade").executeUpdate();
		session.createSQLQuery("truncate table r24af.AtividadeFisica").executeUpdate();
		session.createSQLQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();

	}

	@After
	public void finish() {
		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
