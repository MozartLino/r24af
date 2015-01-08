package br.com.each.modelo.paciente;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String email;

	@NotNull
	private Sexo sexo;

	@NotNull
	private Double altura;

	@NotNull
	@Type(type = "org.joda.time.contrib.hibernate.PersistentLocalDate")
	private LocalDate dataEntrada;

	@NotNull
	private String dataNascimento;

	@NotNull
	private Double peso;

	private Naturalidade naturalidade;

	private CorDaPele corPele;

	private Integer estadoMarital;

	private Long rendaMensal;

	private String ocupacao;

	private Escolaridade escolaridade;

	private Integer anosEstudo;

	private Opcao antecedentes;

	private Opcao diabetes;

	private Opcao vascular;

	private Opcao cardiopatias;

	private Opcao neoplasias;

	private Opcao hipertensao;

	private Opcao hiperlipidemias;

	private Boolean fumaAtual;

	private Integer qtdCigarrosAtual;

	private Integer tempoEmMesesQueFumaAtual;

	private TipodeFumo tipoFumo;

	private String tipoFumoOutros;

	private Boolean parouDeFumar;

	private Integer tempoQueFumouEmMEses;

	private Integer parouHaQuantoTempo;

	private Integer acordaDisposto;

	private Integer qdeCigarrosQueFumou;

	private Integer horasSonoDiarias;

	private Boolean alcoolismo;

	private FrequencialPorSemana frequenciaAlcool;

	private TipoDeBebida tipoBebida;

	private BigDecimal qdeBebida;

	protected Pessoa() {
		this.dataEntrada = new LocalDate();
	}

	public Pessoa(String nome, String email, Sexo sexo, Double altura, String dataNascimento, Double peso) {
		this.nome = nome;
		this.email = email;
		this.sexo = sexo;
		this.altura = altura;
		this.dataNascimento = dataNascimento;
		this.peso = peso;
		this.dataEntrada = new LocalDate();
	}

	public Naturalidade getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(Naturalidade naturalidade) {
		this.naturalidade = naturalidade;
	}

	public CorDaPele getCorPele() {
		return corPele;
	}

	public void setCorPele(CorDaPele corPele) {
		this.corPele = corPele;
	}

	public Integer getEstadoMarital() {
		return estadoMarital;
	}

	public void setEstadoMarital(Integer estadoMarital) {
		this.estadoMarital = estadoMarital;
	}

	public Long getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(Long rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public Integer getAnosEstudo() {
		return anosEstudo;
	}

	public void setAnosEstudo(Integer anosEstudo) {
		this.anosEstudo = anosEstudo;
	}

	public Opcao getAntecedentes() {
		return antecedentes;
	}

	public void setAntecedentes(Opcao antecedentes) {
		this.antecedentes = antecedentes;
	}

	public Opcao getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Opcao diabetes) {
		this.diabetes = diabetes;
	}

	public Opcao getVascular() {
		return vascular;
	}

	public void setVascular(Opcao vascular) {
		this.vascular = vascular;
	}

	public Opcao getCardiopatias() {
		return cardiopatias;
	}

	public void setCardiopatias(Opcao cardiopatias) {
		this.cardiopatias = cardiopatias;
	}

	public Opcao getNeoplasias() {
		return neoplasias;
	}

	public void setNeoplasias(Opcao neoplasias) {
		this.neoplasias = neoplasias;
	}

	public Opcao getHipertensao() {
		return hipertensao;
	}

	public void setHipertensao(Opcao hipertensao) {
		this.hipertensao = hipertensao;
	}

	public Opcao getHiperlipidemias() {
		return hiperlipidemias;
	}

	public void setHiperlipidemias(Opcao hiperlipidemias) {
		this.hiperlipidemias = hiperlipidemias;
	}

	public Boolean getFumaAtual() {
		return fumaAtual;
	}

	public void setFumaAtual(Boolean fumaAtual) {
		this.fumaAtual = fumaAtual;
	}

	public Integer getQtdCigarrosAtual() {
		return qtdCigarrosAtual;
	}

	public void setQtdCigarrosAtual(Integer numerosCigarros) {
		this.qtdCigarrosAtual = numerosCigarros;
	}

	public Integer getTempoEmMesesQueFumaAtual() {
		return tempoEmMesesQueFumaAtual;
	}

	public void setTempoEmMesesQueFumaAtual(Integer anosFuma) {
		this.tempoEmMesesQueFumaAtual = anosFuma;
	}

	public TipodeFumo getTipoFumo() {
		return tipoFumo;
	}

	public void setTipoFumo(TipodeFumo tipoFumo) {
		this.tipoFumo = tipoFumo;
	}

	public String getTipoFumoOutros() {
		return tipoFumoOutros;
	}

	public void setTipoFumoOutros(String tipoFumoOutros) {
		this.tipoFumoOutros = tipoFumoOutros;
	}

	public Boolean getParouDeFumar() {
		return parouDeFumar;
	}

	public void setParouDeFumar(Boolean parouFumar) {
		this.parouDeFumar = parouFumar;
	}

	public Integer getTempoQueFumouEmMEses() {
		return tempoQueFumouEmMEses;
	}

	public void setTempoQueFumouEmMEses(Integer tempoFumou) {
		this.tempoQueFumouEmMEses = tempoFumou;
	}

	public Integer getAcordaDisposto() {
		return acordaDisposto;
	}

	public void setAcordaDisposto(Integer acordaDisposto) {
		this.acordaDisposto = acordaDisposto;
	}

	public Integer getQdeCigarrosQueFumou() {
		return qdeCigarrosQueFumou;
	}

	public void setQdeCigarrosQueFumou(Integer qdeCigarrosDia) {
		this.qdeCigarrosQueFumou = qdeCigarrosDia;
	}

	public Integer getHorasSonoDiarias() {
		return horasSonoDiarias;
	}

	public void setHorasSonoDiarias(Integer horasSonoDiarias) {
		this.horasSonoDiarias = horasSonoDiarias;
	}

	public Boolean getAlcoolismo() {
		return alcoolismo;
	}

	public void setAlcoolismo(Boolean alcoolismo) {
		this.alcoolismo = alcoolismo;
	}

	public FrequencialPorSemana getFrequenciaAlcool() {
		return frequenciaAlcool;
	}

	public void setFrequenciaAlcool(FrequencialPorSemana frequenciaAlcool) {
		this.frequenciaAlcool = frequenciaAlcool;
	}

	public TipoDeBebida getTipoBebida() {
		return tipoBebida;
	}

	public void setTipoBebida(TipoDeBebida tipoBebida) {
		this.tipoBebida = tipoBebida;
	}

	public BigDecimal getQdeBebida() {
		return qdeBebida;
	}

	public void setQdeBebida(BigDecimal qdeBebida) {
		this.qdeBebida = qdeBebida;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public Double getAltura() {
		return altura;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public LocalDate getDataNascimento() {
		try {
			return new LocalDate(new SimpleDateFormat("dd/mm/yyyy").parseObject(dataNascimento));
		} catch (ParseException e) {
			return new LocalDate();
		}
	}

	public Double getPeso() {
		return peso;
	}

	public Integer getParouHaQuantoTempo() {
		return parouHaQuantoTempo;
	}

	public void setParouHaQuantoTempo(Integer parouHaQuantoTempo) {
		this.parouHaQuantoTempo = parouHaQuantoTempo;
	}

	public Integer getIdade() {
		return calculaIdadePelaDataDeNascimento();
	}

	private Integer calculaIdadePelaDataDeNascimento() {
		if (dataAtualEhMenorQueDataNascimento()) {
			return 0;
		}
		
		if (mesAtualEhMaioQueMesDataNascimento()) {
			return retornaDiferencaDeAnos() - 1;
		} else {
			return retornaDiferencaDeAnos();
		}
	}

	private int retornaDiferencaDeAnos() {
		return LocalDate.now().getYear() - getDataNascimento().getYear();
	}

	private boolean mesAtualEhMaioQueMesDataNascimento() {
		return getDataNascimento().getMonthOfYear() < LocalDate.now().dayOfMonth().get();
	}

	private boolean dataAtualEhMenorQueDataNascimento() {
		return LocalDate.now().isBefore(getDataNascimento());
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
