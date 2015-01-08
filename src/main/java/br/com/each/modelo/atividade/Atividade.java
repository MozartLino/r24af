package br.com.each.modelo.atividade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private double MET;

	@ManyToOne
	@NotNull
	private Categoria categoria;

	@NotNull
	private boolean repouso;

	protected Atividade() {
	}

	public Atividade(String nome, double MET, Categoria categoria) {
		this.nome = nome;
		this.MET = MET;
		this.categoria = categoria;
	}
	public Atividade(String nome, double MET, Categoria categoria, boolean repouso) {
		this.nome = nome;
		this.MET = MET;
		this.categoria = categoria;
		this.repouso = repouso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public double getMET() {
		return MET;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public boolean isRepouso() {
		return repouso;
	}

	public void setRepouso(boolean repouso) {
		this.repouso = repouso;
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
		Atividade other = (Atividade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atividade [id=" + id + ", nome=" + nome + ", MET=" + MET + ",  categoria=" + categoria + "]";
	}

}
