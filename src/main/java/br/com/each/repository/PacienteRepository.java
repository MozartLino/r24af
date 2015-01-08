package br.com.each.repository;

import java.util.List;

import br.com.each.modelo.atividadefisica.DiaDaSemana;
import br.com.each.modelo.paciente.Paciente;
import br.com.each.modelo.user.User;

public interface PacienteRepository extends Repository<Paciente> {

	public List<Paciente> list(User user);

	public void removeAllBy(User user);

	public List<Paciente> buscaPacienteComAtividadePorDia(User user, Integer dia);

	public List<Paciente> buscaPacienteComAtividadePorDiaDaSemana(User user, DiaDaSemana diaDaSemana);

	public void removeAllAtividadesFisica(Paciente paciente);

	public List<Paciente> buscaPacienteSemAtividadeSedentaria(User user);

}
