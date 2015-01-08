package br.com.each.calculos;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import br.com.each.modelo.paciente.Paciente;
import br.com.each.modelo.paciente.Pessoa;
import br.com.each.modelo.paciente.Sexo;
import br.com.each.modelo.user.User;

public class CalculoHarrisBenedictTest {

	private int idadeMasculina;

	private int idadeFeminina;

	private Paciente pacienteMasculino;

	private Paciente pacienteFeminina;

	@Test
	public void testaCalculoDaTaxaMetabolicaBasalConformePesoSexoEIdade() throws ParseException {
		assertTrue("Não calculou o basal masculino", CalculoBasalHarrisBenedict.getBasal(pacienteMasculino) == valorExperadoDoCalculoBasalMasculino());
		assertTrue("Não calculou o basal feminino", CalculoBasalHarrisBenedict.getBasal(pacienteFeminina) == valorEsperadoDoCalculoBasalFeminino());
	}

	@Before
	public void init() {

		User user = new User("user", "senha");

		Pessoa pessoaMasculino = new Pessoa("nome", "email", Sexo.Masculino, 170D, "12/12/2013", 70d);
		pacienteMasculino = new Paciente(pessoaMasculino, user);

		Pessoa pessoaFeminina = new Pessoa("nome", "email", Sexo.Feminino, 150D, "12/12/2008", 70d);
		pacienteFeminina = new Paciente(pessoaFeminina, user);

		idadeMasculina = calculaIdade(pacienteMasculino);
		idadeFeminina = calculaIdade(pacienteFeminina);

	}

	private int calculaIdade(Paciente paciente) {
		return new LocalDate().getYear() - paciente.getPessoa().getDataNascimento().getYear();
	}

	private double valorEsperadoDoCalculoBasalFeminino() {
		return 655.095 + (9.563 * 70) + (1.850 * 150) - (4.676 * idadeFeminina);
	}

	private double valorExperadoDoCalculoBasalMasculino() {
		return 66.473 + (13.752 * 70) + (5.003 * 170) - (6.755 * idadeMasculina);
	}
}
