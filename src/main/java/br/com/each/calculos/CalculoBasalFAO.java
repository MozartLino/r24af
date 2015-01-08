package br.com.each.calculos;

import org.joda.time.LocalDate;

import br.com.each.modelo.paciente.Paciente;
import br.com.each.modelo.paciente.Sexo;

public class CalculoBasalFAO {

	private Paciente paciente;

	private int idade;

	public static Double getBasal(Paciente paciente) {
		return new CalculoBasalFAO(paciente).calculoBasal();
	}

	private CalculoBasalFAO(Paciente paciente) {
		this.paciente = paciente;
		this.idade = calculaIdade(paciente);
	}

	public Double calculoBasal() {
		if (isMasculino()) {
			return calculaBasalMasculino();
		} else if (isFeminino()) {
			return calculaBasalFeminino();
		} else {
			throw new IllegalStateException("Dados inconsistente para fazer o cálculo");
		}
	}

	private boolean isFeminino() {
		return paciente.getSexo() == Sexo.Feminino;
	}

	private boolean isMasculino() {
		return paciente.getSexo() == Sexo.Masculino;
	}

	private int calculaIdade(Paciente paciente) {
		return new LocalDate().getYear() - paciente.getDataNascimento().getYear();
	}

	private Double calculaBasalMasculino() {
		Double peso = paciente.getPeso();

		if (idade <= 3) {
			return 69.9 * peso - 54;
		} else if (idade > 3 && idade <= 10) {
			return 22.7 * peso + 495;
		} else if (idade > 10 && idade <= 18) {
			return 17.5 * peso + 651;
		} else if (idade > 18 && idade <= 30) {
			return 15.3 * peso + 679;
		} else if (idade > 30 && idade <= 60) {
			return 11.6 * peso + 879;
		} else {
			return 13.5 * peso + 487;
		}
	}

	private Double calculaBasalFeminino() {
		Double peso = paciente.getPeso();

		if (idade <= 3) {
			return 61.0 * peso - 51;
		} else if (idade > 3 && idade <= 10) {
			return 22.5 * peso + 499;
		} else if (idade > 10 && idade <= 18) {
			return 12.2 * peso + 746;
		} else if (idade > 18 && idade <= 30) {
			return 14.7 * peso + 496;
		} else if (idade > 30 && idade <= 60) {
			return 8.7 * peso + 829;
		} else {
			return 10.5 * peso + 596;
		}
	}
}
