package br.com.each.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.each.modelo.atividadefisica.AtividadeFisica;
import br.com.each.modelo.atividadefisica.DiaDaSemana;
import br.com.each.modelo.paciente.Paciente;
import br.com.each.repository.AtividadeFisicaRepository;
import br.com.each.repository.AtividadeRepository;
import br.com.each.repository.CategoriaRepository;
import br.com.each.repository.PacienteRepository;

@Resource
public class AtividadeFisicaController {

	private Result result;

	private AtividadeFisicaRepository atividadesFisica;

	private AtividadeRepository atividades;

	private PacienteRepository pacientesRepository;

	private CategoriaRepository categorias;

	private Validator validator;

	public AtividadeFisicaController(Result result, AtividadeFisicaRepository atividadesFisica,
			AtividadeRepository atividades, PacienteRepository pacientes, CategoriaRepository categorias,
			Validator validator) {
		this.result = result;
		this.atividadesFisica = atividadesFisica;
		this.atividades = atividades;
		this.pacientesRepository = pacientes;
		this.categorias = categorias;
		this.validator = validator;
	}

	@Get("/paciente/{id}/atividadeFisica")
	public void form(Long id) {
		result.include("paciente", pacientesRepository.load(id));
		result.include("atividadeList", atividades.list());
		result.include("categoriaList", categorias.list());
	}

	@Get("/atividadeFisica/{atividadeFisica.id}")
	public void form(AtividadeFisica atividadeFisica) {
		result.include("atividadeList", atividades.list());
		result.include("atividadeFisica", atividadesFisica.load(atividadeFisica.getId()));
	}

	@Delete("/paciente/{paciente.id}/atividadeFisica/{atividadeFisica.id}")
	public void deleta(Paciente paciente, AtividadeFisica atividadeFisica) {
		atividadeFisica = atividadesFisica.load(atividadeFisica.getId());
		paciente = pacientesRepository.load(paciente.getId());
		paciente.removeAtividadeFisica(atividadeFisica);
		result.nothing();
	}

	@Post("/paciente/{paciente.id}/atividadeFisica")
	public void save(Paciente paciente, AtividadeFisica atividadeFisica) {
		validator.validate(atividadeFisica);
		validator.onErrorSendBadRequest();
		atividadesFisica.save(atividadeFisica);

		paciente = pacientesRepository.load(paciente.getId());
		paciente.addAtividadeFisica(atividadeFisica);
		pacientesRepository.update(paciente);

		result.nothing();
	}

	@Get("/paciente/{paciente.id}/atividades/categoria/{categoriaId}")
	public void atividadesRealizadaPorCategoria(Paciente paciente, Long categoriaId) {
		List<AtividadeFisica> lista = new ArrayList<>();

		for (AtividadeFisica atividadeFisica : paciente.getAtividadesFisica()) {
			if (atividadeFisica.getCategoria().getId() != categoriaId) {
				lista.add(atividadeFisica);
			}
		}

		result.use(Results.json()).withoutRoot().from(lista).serialize();
	}

	@Get("/paciente/{paciente.id}/atividades/diaDaSemana/{diaDaSemana}")
	public void atividadesRealizada(Paciente paciente, DiaDaSemana diaDaSemana) {
		List<AtividadeFisica> lista = new ArrayList<>();

		for (AtividadeFisica atividadeFisica : paciente.getAtividadesFisica()) {
			if (atividadeFisica.getDiaDaSemana() == diaDaSemana) {
				lista.add(atividadeFisica);
			}
		}

		result.use(Results.json()).withoutRoot().from(lista).serialize();
	}

	@Get("/paciente/{paciente.id}/atividades/dia/{dia}")
	public void atividadesRealizada(Paciente paciente, Integer dia) {
		List<AtividadeFisica> lista = new ArrayList<>();

		for (AtividadeFisica atividadeFisica : paciente.getAtividadesFisica()) {
			if (atividadeFisica.getDia() == dia) {
				lista.add(atividadeFisica);
			}
		}

		result.use(Results.json()).withoutRoot().from(lista).serialize();
	}

}