package br.com.each.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.each.modelo.atividade.Categoria;
import br.com.each.repository.CategoriaRepository;

@Resource
public class CategoriaController {

	private Result result;
	private CategoriaRepository categorias;
	private Validator validator;

	public CategoriaController(Result result, CategoriaRepository categorias, Validator validator) {
		this.result = result;
		this.categorias = categorias;
		this.validator = validator;
	}

	@Get("/categoria")
	public void form() {
	}

	@Get("/categoria/{id}")
	public void form(Long id) {
		result.include("categoria", categorias.load(id));
	}

	@Post("/categoria")
	public void salva(Categoria categoria) {
		validator.validate(categoria);
		validator.onErrorSendBadRequest();

		categorias.save(categoria);
		result.nothing();
	}

	@Put("/categoria")
	public void edita(Categoria categoria) {
		validator.validate(categoria);
		validator.onErrorSendBadRequest();

		categorias.update(categoria);
		result.nothing();
	}

	@Delete("/categorias/{categoria.id}")
	public void deleta(Categoria categoria) {
		categorias.delete(categoria);
		result.nothing();
	}

	@Get("/categorias")
	public void lista() {
	}

	@Get("/categorias/representation")
	public void listaRepresentation() {
		result.use(Results.json()).withoutRoot().from(categorias.list()).serialize();
	}

}