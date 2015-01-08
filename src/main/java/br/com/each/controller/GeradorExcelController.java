package br.com.each.controller;

import java.util.List;

import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.excel.GeradorDeExcel;
import br.com.each.modelo.paciente.PacienteRepresentation;

@Resource
public class GeradorExcelController {

	private Result result;

	private GeradorDeExcel geradorDeExcel;

	public GeradorExcelController(Result result, GeradorDeExcel geradorDeExcel) {
		this.result = result;
		this.geradorDeExcel = geradorDeExcel;
	}

	@Post("/gerador")
	public void gerador(List<PacienteRepresentation> pacientes) {
		try {
			geradorDeExcel.writeSheet(pacientes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		result.nothing();
	}

}
