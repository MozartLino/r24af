package br.com.each.modelo.paciente;


public enum TipodeFumo {

	CSF("Cigarro sem Filtro"), CCF("Cigarro com Filtro"), CACHIMBO("Cachimbo"), CHARUTO(
			"Charuto"), OUTRO("Outro");

	private String tipoDeFumo;

	private TipodeFumo(String tipoDeFumo) {
		this.tipoDeFumo = tipoDeFumo;
	}

	public String tipoDeFumo() {
		return this.tipoDeFumo;
	}

}
