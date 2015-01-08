package br.com.each.excel;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import br.com.each.modelo.paciente.PacienteRepresentation;

@br.com.caelum.vraptor.ioc.Component
public class GeradorDeExcel {

	private WritableWorkbook workbook;

	private WritableSheet sheet;

	public GeradorDeExcel() {
		try {
			workbook = Workbook.createWorkbook(new File("output.xls"));
			sheet = workbook.createSheet("First Sheet", 0);
			String[] colunas = { "Código", "Nome", "Basal", "Kcal Total", "Tempo Total", "Leve[Kcal]", "Tempo Leve",
					"Moderado[kcal]", "Tempo Moderado", "Vigoroso[kcal]", "Tempo Vigoroso", "Idade", "Peso", "Altura" };

			for (int i = 0; colunas.length > i; i++) {
				sheet.addCell(new Label(i, 0, colunas[i]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

	public void writeSheet(List<PacienteRepresentation> pacientes) throws Exception {

		int i = 1;

		for (PacienteRepresentation representation : pacientes) {
			sheet.addCell(new Label(0, i, representation.getId().toString()));
			sheet.addCell(new Label(1, i, representation.getNome()));
			sheet.addCell(new Label(2, i, representation.getBasal().toString()));
			sheet.addCell(new Label(3, i, representation.getCaloriaTotal().toString()));
			sheet.addCell(new Label(4, i, representation.getTempoTotal().toString()));
			sheet.addCell(new Label(5, i, representation.getCaloriaLeve().toString()));
			sheet.addCell(new Label(6, i, representation.getTempoLeve().toString()));
			sheet.addCell(new Label(7, i, representation.getCaloriaModerado().toString()));
			sheet.addCell(new Label(8, i, representation.getTempoModerado().toString()));
			sheet.addCell(new Label(9, i, representation.getCaloriaVigoroso().toString()));
			sheet.addCell(new Label(10, i, representation.getTempoVigoroso().toString()));
			sheet.addCell(new Label(11, i, representation.getIdade().toString()));
			sheet.addCell(new Label(12, i, representation.getPeso().toString()));
			sheet.addCell(new Label(13, i, representation.getAltura().toString()));

			i++;
		}

		workbook.write();
		workbook.close();

		System.out.println("Planilha gerada com sucesso");

	}
}