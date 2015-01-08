package br.com.each.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtividadeFisicaDAOTest {

	public static Session session;

	public static SessionFactory sessionFactory;

	@Test
	public void deveRetornarAtividadesFisicaPorPaciente() {
	}

	@After
	public void finish() {
		session.beginTransaction().rollback();
		session.close();
		sessionFactory.close();
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

}
