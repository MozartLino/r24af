package br.com.each.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.each.annotation.Public;
import br.com.each.modelo.user.User;
import br.com.each.payload.Payload;
import br.com.each.repository.PacienteRepository;
import br.com.each.repository.UserRepository;
import br.com.each.util.UserSession;

import com.sun.media.sound.InvalidDataException;

@Resource
public class UserController {

	private Result result;
	private UserRepository users;
	private Validator validator;
	private UserSession userSession;
	private PacienteRepository pacientes;

	public UserController(Result result, UserRepository users, PacienteRepository pacientes, Validator validator,
			UserSession userSession) {
		this.result = result;
		this.users = users;
		this.pacientes = pacientes;
		this.validator = validator;
		this.userSession = userSession;
	}

	@Public
	@Get("/login")
	public void login() {
	}

	@Get("/usuario")
	public void form() {
	}

	@Post("/usuario")
	public void salva(User user) {
		User userBD = users.buscaPor(user.getLogin());

		if (userBD != null) {
			validator.add(new ValidationMessage("user.login", "Login inválido"));
		}
		validator.validate(user);
		validator.onErrorSendBadRequest();

		users.save(user);
		result.nothing();
	}

	@Get("/usuario/editar")
	public void editar(Long id) {
		result.include("user", userSession.getUser());
	}

	@Put("/usuario/editar")
	public void edita(User user) {
		validator.validate(user);
		validator.onErrorSendBadRequest();
		users.merge(user);
		result.nothing();
	}

	@Delete("/usuario")
	public void deleta() {
		User user = users.load(userSession.getUser().getId());
		pacientes.removeAllBy(user);
		users.delete(user);
		userSession.setUser(null);
		result.nothing();
	}

	@Public
	@Post("/logar")
	public void logar(User user) throws InvalidDataException {
		User userBD = users.buscaPor(user.getLogin());
		if (userBD != null && userBD.valida(user)) {
			userSession.setUser(userBD);
			result.nothing();
		} else {
			throw new InvalidDataException("Usuário e/ou senha inválido");
		}
	}

	@Get("/deslogar")
	public void deslogar() {
		userSession.setUser(null);
		result.nothing();
	}

	@Public
	@Get("/payload")
	public void payloadInit() {
		Payload.init();
		System.out.println("inicio");
	}

}