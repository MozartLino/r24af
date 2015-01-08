package br.com.each.modelo.paciente;

public enum Intensidade {

	SEDENTARIO(0.0, 1.49), LEVE(0.0, 2.9), MODERADO(3.0, 5.9), VIGOROSO(6.0, Double.MAX_VALUE);

	private Double min;

	private Double max;

	private Intensidade(Double min, Double max) {
		this.min = min;
		this.max = max;
	}
	
	public Double getMin() {
		return min;
	}

	public Double getMax() {
		return max;
	}
}
