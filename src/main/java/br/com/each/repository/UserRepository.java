package br.com.each.repository;

import br.com.each.modelo.user.User;

public interface UserRepository extends Repository<User> {

	public User buscaPor(String login);
}
