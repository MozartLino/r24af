package br.com.each.modelo.atividadefisica;

import br.com.each.modelo.atividade.Atividade;
import br.com.each.modelo.atividade.Categoria;
import br.com.each.modelo.paciente.Paciente;
import br.com.each.modelo.paciente.Pessoa;
import br.com.each.modelo.paciente.Sexo;
import br.com.each.modelo.user.User;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

public class PacienteLoader {

	public static void loader(){
		
	Fixture.of(Categoria.class).addTemplate("valid", new Rule(){{
	    add("nome", "teste");
	}});
	
	Fixture.of(Atividade.class).addTemplate("valid", new Rule(){{
	    add("nome", "teste");
	    add("MET", 8D);
	    add("categoria", one(Categoria.class, "valid"));
	}});
	
	
	Fixture.of(AtividadeFisica.class).addTemplate("valid", new Rule(){{
	    add("atividade", one(Atividade.class, "valid"));
	    add("horaInicial", 01);
	    add("horaFinal", 02);
	    add("minutoInicial", 00);
	    add("minutoFinal", 00);
	    add("dia", 1);
	}});
	
	
	Fixture.of(User.class).addTemplate("valid", new Rule(){{
	    add("login", "teste");
	    add("password", "teste");
	}});
	
	Fixture.of(Paciente.class).addTemplate("valid", new Rule(){{
	    add("pessoa", one(Pessoa.class, "valid"));
	    add("user", one(User.class, "valid"));
	    add("atividadesFisica", has(1).of(AtividadeFisica.class, "valid"));
	}});
	
	Fixture.of(Pessoa.class).addTemplate("valid", new Rule(){{
	    add("nome", "Ricardo Mozart Lino");
	    add("email", "kadu.m.lino@hotmail.com");
	    add("sexo", Sexo.Masculino);
	    add("altura", 170D);
	    add("peso", 70d);
	    add("dataNascimento", "12/12/2012");
	}});
	
	
	}
}
