package br.com.each.repository;

import java.util.List;

import br.com.each.modelo.atividade.Atividade;
import br.com.each.modelo.atividade.Categoria;

public interface AtividadeRepository extends Repository<Atividade> {

	public List<Atividade> listaPor(String nome);
	
	public List<Atividade> listaPor(String nome, Categoria categoria);

	public List<Atividade> listaPor(Categoria categoria);
}
