package br.com.each.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.each.modelo.atividadefisica.DiaDaSemana;
import br.com.each.modelo.paciente.Paciente;
import br.com.each.modelo.paciente.PacienteRepresentation;
import br.com.each.repository.CategoriaRepository;
import br.com.each.repository.PacienteRepository;
import br.com.each.util.UserSession;

@Resource
public class PacienteController {

	private Result result;

	private PacienteRepository pacientes;

	private Validator validator;

	private CategoriaRepository categorias;

	private UserSession userSession;

	public PacienteController(Result result, PacienteRepository pacientes, Validator validator,
			CategoriaRepository categorias, UserSession userSession) {
		this.result = result;
		this.pacientes = pacientes;
		this.validator = validator;
		this.categorias = categorias;
		this.userSession = userSession;
	}

	@Get("/paciente")
	public void form() {
	}

	@Get("/paciente/{id}")
	public void form(Long id) {
	}

	@Get("/pacientes")
	public void lista() {
	}

	@Post("/pacientes")
	@Consumes("application/json")
	public void save(Paciente paciente) {
		paciente.setUser(userSession.getUser());

		pacientes.save(paciente);
		result.nothing();
	}

	@Put("/pacientes")
	@Consumes("application/json")
	public void update(Paciente paciente) {
		paciente.setUser(userSession.getUser());
		validator.validate(paciente);
		validator.onErrorSendBadRequest();

		pacientes.update(paciente);
		result.nothing();
	}

	@Get("/paciente/{id}/atividadesFisica")
	public void paciente(Long id) {
		Paciente paciente = pacientes.load(id);
		result.include("paciente", paciente);
		result.include("atividadeFisicaList", paciente.getAtividadesFisicaRepresentation());
		result.include("categoriaList", categorias.list());

	}

	@Get("/pacientes/representation")
	public void representation() {
		List<PacienteRepresentation> representations = new ArrayList<>();

		for (Paciente paciente : pacientes.list(userSession.getUser())) {
			representations.add(new PacienteRepresentation(paciente));
		}

		result.use(Results.json()).withoutRoot().from(representations).serialize();
	}

	@Get("/pacientes/{paciente.id}/representation")
	public void getPaciente(Paciente paciente) {
		paciente = pacientes.load(paciente.getId());
		result.use(Results.json()).withoutRoot().from(paciente).include("user")
				.include("pessoa", "pessoa.dataNascimento").serialize();
	}

	@Delete("/pacientes/{paciente.id}")
	public void remove(Paciente paciente) {
		paciente = pacientes.load(paciente.getId());
		pacientes.delete(paciente);
		result.nothing();
	}

	@Get("/pacientes/representation/dia/{dia}")
	public void representationBy(Integer dia) {
		List<PacienteRepresentation> representations = new ArrayList<>();

		for (Paciente paciente : pacientes.buscaPacienteComAtividadePorDia(userSession.getUser(), dia)) {
			representations.add(new PacienteRepresentation(paciente));
		}

		result.use(Results.json()).withoutRoot().from(representations).serialize();
	}

	@Get("/pacientes/representation/diaDaSemana/{diaDaSemana}")
	public void representationBy(DiaDaSemana diaDaSemana) {
		List<PacienteRepresentation> representations = new ArrayList<>();

		for (Paciente paciente : pacientes.buscaPacienteComAtividadePorDiaDaSemana(userSession.getUser(), diaDaSemana)) {
			representations.add(new PacienteRepresentation(paciente));
		}

		result.use(Results.json()).withoutRoot().from(representations).serialize();
	}

	@Get("/pacientes/representation/semAtividadeSedentaria")
	public void representationSemAtividadeSedentaria() {
		List<PacienteRepresentation> representations = new ArrayList<>();

		for (Paciente paciente : pacientes.buscaPacienteSemAtividadeSedentaria(userSession.getUser())) {
			representations.add(new PacienteRepresentation(paciente));

			result.use(Results.json()).withoutRoot().from(representations).serialize();
		}
	}
}
