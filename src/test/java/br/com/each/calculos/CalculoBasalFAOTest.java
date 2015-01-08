package br.com.each.calculos;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

import br.com.each.modelo.paciente.Paciente;
import br.com.each.modelo.paciente.Pessoa;
import br.com.each.modelo.paciente.Sexo;
import br.com.each.modelo.user.User;

public class CalculoBasalFAOTest {

	@Test
	public void testaCalculoDaTaxaMetabolicaBasalConformePesoSexoEIdade() throws ParseException {
		User user = new User("user", "senha");

		Pessoa pessoaDe0a3Anos = new Pessoa("nome", "email", Sexo.Masculino, 170D, "12/12/2012", 70d);
		Paciente pacienteDe0a3Anos = new Paciente(pessoaDe0a3Anos, user);

		Pessoa pessoaDe4a10Anos = new Pessoa("nome", "email", Sexo.Masculino, 170D, "12/12/2008", 70d);
		Paciente pacienteDe4a10Anos = new Paciente(pessoaDe4a10Anos, user);

		Pessoa pessoaDe11a18Anos = new Pessoa("nome", "email", Sexo.Masculino, 170D, "12/12/2001", 70d);
		Paciente pacienteDe11a18Anos = new Paciente(pessoaDe11a18Anos, user);

		Pessoa pessoaMaiorDe60Anos = new Pessoa("nome", "email", Sexo.Masculino, 170D, "12/12/1940", 70d);
		Paciente pacienteMaiorDe60Anos = new Paciente(pessoaMaiorDe60Anos, user);

		assertTrue("Deveria fazer o calculo", CalculoBasalFAO.getBasal(pacienteDe0a3Anos) == 69.9 * 70 - 54);
		assertTrue("Deveria fazer o calculo", CalculoBasalFAO.getBasal(pacienteDe4a10Anos) == 22.7 * 70 + 495);
		assertTrue("Deveria fazer o calculo", CalculoBasalFAO.getBasal(pacienteDe11a18Anos) == 17.5 * 70 + 651);
		assertTrue("Deveria fazer o calculo", CalculoBasalFAO.getBasal(pacienteMaiorDe60Anos) == 13.5 * 70 + 487);

	}
}
