package br.com.each.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.each.modelo.atividade.Atividade;
import br.com.each.modelo.atividade.Categoria;
import br.com.each.repository.AtividadeRepository;
import br.com.each.repository.CategoriaRepository;

@Resource
public class AtividadeController {

	private Result result;
	private AtividadeRepository atividades;
	private Validator validator;
	private CategoriaRepository categorias;

	public AtividadeController(Result result, Validator validator, AtividadeRepository atividades,
			CategoriaRepository categorias) {
		this.result = result;
		this.validator = validator;
		this.atividades = atividades;
		this.categorias = categorias;
	}

	@Get("/atividade")
	public void form() {
		result.include("categoriaList", categorias.list());
	}

	@Get("/atividade/{id}")
	public void form(Long id) {
		result.include("categoriaList", categorias.list());
		result.include("atividade", atividades.load(id));
	}

	@Post("/atividade")
	public void salva(Atividade atividade) {

		validator.validate(atividade);
		validator.onErrorSendBadRequest();

		atividades.save(atividade);
		result.nothing();
	}

	@Put("/atividade")
	public void edita(Atividade atividade) {

		validator.validate(atividade);
		validator.onErrorSendBadRequest();

		atividades.update(atividade);
		result.nothing();
	}

	@Delete("/atividade")
	public void deleta(Atividade atividade) {
		atividades.delete(atividade);
		result.nothing();
	}

	@Get("/atividades")
	public void lista() {
		result.include("atividadeList", atividades.list());
	}

	@Get("/atividades/{nome}")
	public void listaPor(String nome) {
		result.use(Results.json()).withoutRoot().from(atividades.listaPor(nome)).include("categoria").serialize();
	}

	@Get("/atividades/{nome}/categoria/{categoria.id}")
	public void listaPor(String nome, Categoria categoria) {
		result.use(Results.json()).withoutRoot().from(atividades.listaPor(nome, categoria)).include("categoria")
				.serialize();
	}

	@Get("/atividades/categoria/{categoria.id}")
	public void listaPor(Categoria categoria) {
		result.use(Results.json()).withoutRoot().from(atividades.listaPor(categoria)).include("categoria").serialize();
	}
}
