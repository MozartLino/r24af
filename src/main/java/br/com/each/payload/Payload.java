package br.com.each.payload;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.each.modelo.atividade.Atividade;
import br.com.each.modelo.atividade.Categoria;
import br.com.each.modelo.atividadefisica.AtividadeFisica;
import br.com.each.modelo.paciente.Paciente;
import br.com.each.modelo.paciente.Pessoa;
import br.com.each.modelo.paciente.Sexo;
import br.com.each.modelo.user.User;

public class Payload {

	public static void init() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction().begin();
		session.createSQLQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
		session.createSQLQuery("truncate table r24af.Paciente").executeUpdate();
		session.createSQLQuery("truncate table r24af.Pessoa").executeUpdate();
		session.createSQLQuery("truncate table r24af.User").executeUpdate();
		session.createSQLQuery("truncate table r24af.Categoria").executeUpdate();
		session.createSQLQuery("truncate table r24af.Atividade").executeUpdate();
		session.createSQLQuery("truncate table r24af.AtividadeFisica").executeUpdate();
		session.createSQLQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate();

		Categoria categoria1 = new Categoria("Ciclismo");
		Categoria categoria2 = new Categoria("Exercício de Condicionamento");
		Categoria categoria3 = new Categoria("Dança");
		Categoria categoria4 = new Categoria("Caça e Pesca");
		Categoria categoria5 = new Categoria("Atividade Doméstica");
		Categoria categoria6 = new Categoria("Reparos Domésticos");
		Categoria categoria7 = new Categoria("Inatividade Doméstica");
		Categoria categoria8 = new Categoria("Inatividade, tranquiilo");
		Categoria categoria9 = new Categoria("Gramado e Jardim");

		Categoria categoria10 = new Categoria("Tocar Música/ Instrumentos");
		Categoria categoria11 = new Categoria("Atividades Ocupacionais");
		Categoria categoria12 = new Categoria("Correr");
		Categoria categoria13 = new Categoria("Cuidados Pessoais");
		Categoria categoria14 = new Categoria("Atividade Sexual");
		Categoria categoria15 = new Categoria("Esportes");
		Categoria categoria16 = new Categoria("Transporte");
		Categoria categoria17 = new Categoria("Caminhar");
		Categoria categoria18 = new Categoria("Atividades aquáticas");
		Categoria categoria19 = new Categoria("Atividades de inverno");
		Categoria categoria20 = new Categoria("Atividades Religiosas");
		Categoria categoria21 = new Categoria("Atividades voluntárias");

		session.save(categoria1);
		session.save(categoria2);
		session.save(categoria3);
		session.save(categoria4);
		session.save(categoria5);
		session.save(categoria6);
		session.save(categoria7);
		session.save(categoria8);
		session.save(categoria9);
		session.save(categoria10);
		session.save(categoria11);
		session.save(categoria12);
		session.save(categoria13);
		session.save(categoria14);
		session.save(categoria15);
		session.save(categoria16);
		session.save(categoria17);
		session.save(categoria18);
		session.save(categoria19);
		session.save(categoria20);
		session.save(categoria21);

		Atividade atividade1 = new Atividade("Ciclismo, BMX ou montanha (01009)", 8.0, categoria1);
		Atividade atividade2 = new Atividade(
				"Ciclismo, < 16 km/h, geral, lazer, para trabalho ou lazer (01010 ou 115 de Taylor)", 4.0, categoria1);
		Atividade atividade3 = new Atividade("Ciclismo, velocidade em geral (01015)", 8.0, categoria1);
		Atividade atividade4 = new Atividade("Ciclismo, 16 a 19 km/h, lazer, lento, esforço leve (01030)", 6.0,
				categoria1);
		Atividade atividade5 = new Atividade("Ciclismo, 19 a 22km/h, lazer, esforço moderado (01030)", 8.0, categoria1);
		Atividade atividade6 = new Atividade(
				"Ciclismo, 22 a 25km/h, corrida ou lazer, rápido, esforço vigoroso (01040)", 10.0, categoria1);
		Atividade atividade7 = new Atividade(
				"Ciclismo, 25 a 30km/h, corrida/ sem explosão ou >30km/h, explosivo, muito veloz, corrida em geral (01050)",
				12.0, categoria1);
		Atividade atividade8 = new Atividade("Ciclismo, >32km/h, corrida, sem explosão (01060)", 16.0, categoria1);
		Atividade atividade9 = new Atividade("Ciclismo, pedalando monociclo (01070)", 5.0, categoria1);
		Atividade atividade10 = new Atividade("Ciclismo, estacionário, geral (02010)", 7.0, categoria2);
		Atividade atividade11 = new Atividade("Ciclismo, estacionário, 50W, esforço muito leve (02011)", 3.0,
				categoria2);
		Atividade atividade12 = new Atividade("Ciclismo, estacionário, 100W, esforço leve (02012)", 5.0, categoria2);
		Atividade atividade13 = new Atividade("Ciclismo, estacionário, 150W, esforço moderado (02013)", 7.0, categoria2);
		Atividade atividade14 = new Atividade("Ciclismo, estacionário, 200W, esforço vigoroso (02014)", 10.0,
				categoria2);
		Atividade atividade15 = new Atividade("Ciclismo, estacionário, 250W, esforço muito vigoroso (02015)", 12.0,
				categoria2);
		Atividade atividade16 = new Atividade(
				"Calistenia (i.e. flexões, abdominais, puxadas), pesado, esforço vigoroso (02020)", 8.0, categoria2);
		Atividade atividade17 = new Atividade(
				"Calistenia, exercício em casa, esforço leve ou moderado, geral (ex.: exercícios para as costas), levantar e deitar no chão (02030 ou 150 de Taylor)",
				3.0, categoria2);
		Atividade atividade18 = new Atividade("Treinamento em circuito, geral (02040)", 8.0, categoria2);

		session.save(atividade1);
		session.save(atividade2);
		session.save(atividade3);
		session.save(atividade4);
		session.save(atividade5);
		session.save(atividade6);
		session.save(atividade7);
		session.save(atividade8);
		session.save(atividade9);
		session.save(atividade10);
		session.save(atividade11);
		session.save(atividade12);
		session.save(atividade13);
		session.save(atividade14);
		session.save(atividade15);
		session.save(atividade16);
		session.save(atividade17);
		session.save(atividade18);

		User user1 = new User("user1", "default");
		User user2 = new User("user2", "default");
		session.save(user1);
		session.save(user2);

		Pessoa pessoa1 = new Pessoa("Ricardo Mozart Lino", "kadu.m.lino@hotmail.com", Sexo.Masculino, 170D,
				"12/12/1990", 70d);
		Pessoa pessoa2 = new Pessoa("teste segunda pessoa", "segunda.pessoa@hotmail.com", Sexo.Feminino, 150D,
				"12/12/1994", 80d);
		session.save(pessoa1);
		session.save(pessoa2);

		Paciente paciente1 = new Paciente(pessoa1, user1);
		Paciente paciente2 = new Paciente(pessoa2, user2);
		session.save(paciente1);
		session.save(paciente2);

		AtividadeFisica atividadeFisica1 = new AtividadeFisica(atividade1, 1, 04, 30, 05, 6);
		AtividadeFisica atividadeFisica2 = new AtividadeFisica(atividade2, 2, 15, 54, 23, 2);

		paciente1.addAtividadeFisica(atividadeFisica1);
		paciente2.addAtividadeFisica(atividadeFisica2);
		session.update(paciente1);
		session.update(paciente2);

		session.beginTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
