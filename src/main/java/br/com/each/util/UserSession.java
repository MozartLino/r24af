package br.com.each.util;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.com.each.modelo.user.User;

@Component
@SessionScoped
@SuppressWarnings("serial")
public class UserSession implements Serializable {

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogin() {
		return getUser().getLogin();
	}

	public boolean isLogado() {
		return getUser() == null ? false : true;
	}

	public Long getId() {
		return getUser().getId();
	}

}