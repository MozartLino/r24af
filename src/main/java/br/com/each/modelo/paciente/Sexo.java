package br.com.each.modelo.paciente;

public enum Sexo {

	Masculino("Masculino"), Feminino("Feminino");
	
	private String sexo;

	private Sexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return this.sexo;
	}
	
}
