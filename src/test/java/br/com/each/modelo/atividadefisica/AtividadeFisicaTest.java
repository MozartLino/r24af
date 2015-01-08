package br.com.each.modelo.atividadefisica;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import br.com.each.modelo.paciente.Paciente;
import br.com.six2six.fixturefactory.Fixture;

public class AtividadeFisicaTest {

	@Test
	public void testaCalculoBasalPorAtividade() throws ParseException {

		PacienteLoader.loader();
		Paciente paciente = Fixture.from(Paciente.class).gimme("valid");

		assertTrue("Valor não bateu", paciente.getAtividadesFisica().iterator().next().getCaloriaPorAtividadeFisica(paciente) == 560.0);
	}

	@Before
	public void setUp() {
	}

}
