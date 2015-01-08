package br.com.each.calculos;

import org.joda.time.LocalDate;

import br.com.each.modelo.paciente.Paciente;
import br.com.each.modelo.paciente.Sexo;

public class CalculoBasalHarrisBenedict {

	private Paciente paciente;

	private int idade;

	public static Double getBasal(Paciente paciente) {
		return new CalculoBasalHarrisBenedict(paciente).calculaBasal();
	}

	private CalculoBasalHarrisBenedict(Paciente paciente) {
		this.paciente = paciente;
		this.idade = calculaIdade();
	}

	private Double calculaBasal() {
		if (isMasculino()) {
			return calculoBasalMasculino();
		} else if (isFeminino()) {
			return calculoBasalFeminino();
		} else {
			throw new IllegalStateException("Não pode calcular o basal");
		}
	}

	private int calculaIdade() {
		return new LocalDate().getYear() - paciente.getDataNascimento().getYear();
	}

	private double calculoBasalMasculino() {
		return 66.473 + 13.752 * paciente.getPeso() + 5.003 * paciente.getAltura() - 6.755 * idade;
	}

	private double calculoBasalFeminino() {
		return 655.095 + 9.563 * paciente.getPeso() + 1.850 * paciente.getAltura() - 4.676 * idade;
	}

	private boolean isMasculino() {
		return Sexo.Masculino == paciente.getSexo();
	}

	private boolean isFeminino() {
		return Sexo.Feminino == paciente.getSexo();
	}
}
