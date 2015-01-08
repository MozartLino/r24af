package br.com.each.modelo.paciente;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;
import org.joda.time.LocalDate;

import br.com.each.calculos.CalculoBasalFAO;
import br.com.each.calculos.CalculoBasalHarrisBenedict;
import br.com.each.calculos.CalculoCaloria;
import br.com.each.calculos.CalculoTempo;
import br.com.each.modelo.atividadefisica.AtividadeFisica;
import br.com.each.modelo.atividadefisica.AtividadeFisicaRepresentation;
import br.com.each.modelo.user.User;

@Entity
@FilterDefs({
		@FilterDef(name = "atividadesSedentarias"),
		@FilterDef(name = "atividadesDia", parameters = @ParamDef(name = "dia", type = "integer")),
		@FilterDef(name = "atividadesPorCategoria", parameters = @ParamDef(name = "dia", type = "integer")),
		@FilterDef(name = "atividadesDiaDaSemana",
				parameters = @ParamDef(name = "diaDaSemana", type = "integer"))
})
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@OneToOne
	@Cascade(value = { CascadeType.ALL })
	private Pessoa pessoa;

	@NotNull
	@OneToOne
	private User user;

	@OneToMany(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.ALL })
	@JoinColumn(name = "paciente_id")
	// @Cascade(value = { CascadeType.ALL })
	@Filters({
			@Filter(name = "atividadesDia", condition = "dia = :dia"),
			@Filter(name = "atividadesDiaDaSemana", condition = "diaDaSemana = :diaDaSemana"),
			@Filter(name = "atividadesSedentarias",
					condition = "atividade_id in (SELECT a.id FROM Atividade a WHERE a.MET >= 1.5)"),
			@Filter(name = "atividadesPorCategoria",
					condition = "atividade_id in (SELECT a.id FROM Atividade a WHERE a.categoria_id < :categoria_id)")
	})
	private Set<AtividadeFisica> atividadesFisica;

	protected Paciente() {
	}

	public Paciente(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Paciente(Pessoa pessoa, User user) {
		this.pessoa = pessoa;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public String getEmail() {
		return getPessoa().getEmail();
	}

	public String getNome() {
		return getPessoa().getNome();
	}

	public Sexo getSexo() {
		return getPessoa().getSexo();
	}

	public Integer getIdade() {
		return getPessoa().getIdade();
	}

	public Double getPeso() {
		return getPessoa().getPeso();
	}

	public LocalDate getDataNascimento() {
		return getPessoa().getDataNascimento();
	}

	public Double getAltura() {
		return getPessoa().getAltura();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<AtividadeFisica> getAtividadesFisica() {
		if (atividadesFisica == null) {
			atividadesFisica = new HashSet<>();
		}
		return atividadesFisica;
	}

	public Collection<AtividadeFisicaRepresentation> getAtividadesFisicaRepresentation() {
		Set<AtividadeFisicaRepresentation> representations = new HashSet<>();

		for (AtividadeFisica atividadeFisica : atividadesFisica) {
			representations.add(new AtividadeFisicaRepresentation(atividadeFisica, this));
		}

		return representations;
	}

	public void setAtividadesFisica(Collection<AtividadeFisica> atividadesFisica) {
		this.atividadesFisica = new HashSet<>(atividadesFisica);
	}

	public void addAtividadeFisica(AtividadeFisica atividadeFisica) {
		getAtividadesFisica().add(atividadeFisica);
	}

	public void removeAtividadeFisica(AtividadeFisica atividadeFisica) {
		getAtividadesFisica().remove(atividadeFisica);
	}

	public Double getBasalHarrisBenedict() {
		return new BigDecimal(CalculoBasalHarrisBenedict.getBasal(this)).setScale(2, BigDecimal.ROUND_UP).doubleValue();
	}

	public Double getBasalFAO() {
		return CalculoBasalFAO.getBasal(this);
	}

	public Double getCaloriaTotal() {
		return CalculoCaloria.getCaloriaTotal(this);
	}

	public Double getCaloriaLeve() {
		return CalculoCaloria.getCaloriaPorAtividadeLeve(this);
	}

	public Double getCaloriaModerado() {
		return CalculoCaloria.getCaloriaPorAtividadeModerada(this);
	}

	public Double getCaloriaVigoroso() {
		return CalculoCaloria.getCaloriaPorAtividadeVigorosa(this);
	}

	public Double getCaloriaTotalSemAtividadeSedentaria() {
		return CalculoCaloria.getCaloriaTotalSemAtividadeSedentaria(this);
	}

	public Double getTempoTotal() {
		return CalculoTempo.getTempoTotal(atividadesFisica);
	}

	public Double getTempoLeve() {
		return CalculoTempo.getTempoPorAtividadeLeve(atividadesFisica);
	}

	public Double getTempoModerado() {
		return CalculoTempo.getTempoPorAtividadeModerado(atividadesFisica);
	}

	public Double getTempoVigoroso() {
		return CalculoTempo.getTempoPorAtividadeVigorosa(atividadesFisica);
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
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", pessoa=" + pessoa + ", user=" + user + ", atividadesFisica="
				+ atividadesFisica + "]";
	}

}
