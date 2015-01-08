package br.com.each.modelo.atividadefisica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.each.modelo.atividade.Atividade;
import br.com.each.modelo.atividade.Categoria;
import br.com.each.modelo.paciente.Intensidade;
import br.com.each.modelo.paciente.Paciente;

@Entity
public class AtividadeFisica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne
	private Atividade atividade;

	@NotNull
	private Integer horaInicial;

	@NotNull
	private Integer horaFinal;

	@NotNull
	private Integer minutoInicial;

	@NotNull
	private Integer minutoFinal;

	@NotNull
	private Integer dia;

	private DiaDaSemana diaDaSemana;

	private String descricao;

	protected AtividadeFisica() {
	}

	public AtividadeFisica(Atividade atividade,
			Integer horaInicial,
			Integer horaFinal,
			Integer minutoInicial,
			Integer minutoFinal,
			Integer dia) {
		this.atividade = atividade;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.minutoInicial = minutoInicial;
		this.minutoFinal = minutoFinal;
		this.dia = dia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public Integer getHoraInicial() {
		return horaInicial;
	}

	public Integer getHoraFinal() {
		return horaFinal;
	}

	public Integer getMinutoInicial() {
		return minutoInicial;
	}

	public Integer getMinutoFinal() {
		return minutoFinal;
	}

	public Integer getDia() {
		return dia;
	}

	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public String getDescricao() {
		return descricao;
	}

	public Categoria getCategoria() {
		return getAtividade().getCategoria();
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTempo() {
		Integer hora = getHoraFinal() - getHoraInicial();
		Integer minuto = getMinutoFinal() - getMinutoInicial();
		return hora * 60 + minuto;
	}

	public Double getCalculoFAO_OMS() {
		return 1D;
	}

	public Double getCaloriaPorAtividadeFisica(Paciente paciente) {
		return (getAtividade().getMET() * paciente.getPessoa().getPeso() * this.getTempo()) / 60;
	}

	public String getCorIntensidade() {
		double met = getAtividade().getMET();
		if (met < 3) {
			return "#e79300";
		} else if (met >= 3 && met < 6) {
			return "";
		} else {
			return "#6da827";
		}
	}

	public boolean ehUmaAtividadeComEssa(Intensidade intensidade) {
		return this.getAtividade().getMET() >= intensidade.getMin()
				&& this.getAtividade().getMET() <= intensidade.getMax();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtividadeFisica other = (AtividadeFisica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AtividadeFisica [id=" + id + ", atividade=" + atividade + ", horaInicial=" + horaInicial
				+ ", horaFinal=" + horaFinal + ", minutoInicial=" + minutoInicial + ", minutoFinal=" + minutoFinal
				+ ", dia=" + dia + ", diaDaSemana=" + diaDaSemana + ", descricao=" + descricao + "]";
	}
}
