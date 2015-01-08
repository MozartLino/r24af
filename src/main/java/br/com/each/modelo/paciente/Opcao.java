package br.com.each.modelo.paciente;

public enum Opcao {

	NAO("Nao"), SIM("Sim"), NAOSABE("NaoSabe");

	private String opcao;

	private Opcao(String opcao) {
		this.opcao = opcao;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
}
