<div id="camposAntecedentes">
	<br /> <br />

	<div id="step-holder">
		<div class="step-no-off">1</div>
		<div class="step-light-left">Dados Obrigatórios</div>
		<div class="step-light-right">&nbsp;</div>

		<div class="step-no-off">2</div>
		<div class="step-light-left">Antecedentes</div>
		<div class="step-light-right">&nbsp;</div>

		<div class="step-no-off">3</div>
		<div class="step-light-left">Hábitos</div>
		<div class="step-light-right">&nbsp;</div>

		<div class="step-no">4</div>
		<div class="step-light-left">Informacões Adicionais</div>

		<div class="clear"></div>
	</div>

	<table border="0" cellpadding="0" cellspacing="0" id="id-form">
		<tr>
			<th valign="top">Naturalidade :</th>
			<td><select class="styledselect-day" ng-model="paciente.pessoa.naturalidade">
					<option value="">Selecione...</option>
					<option value="SP">SP</option>
					<option value="MG">MG</option>
					<option value="RJ">RJ</option>
					<option value="SC">SC</option>
					<option value="SC">SC</option>
			</select></td>
			<td></td>
		</tr>
		<tr>
			<th valign="top">Cor da pele :</th>
			<td><select class="styledselect-day" ng-model="paciente.pessoa.corPele">
					<option value="">Selecione...</option>
					<option value="BRANCA">Branca</option>
					<option value="PRETA">Preta</option>
					<option value="PARDA">Parda</option>
					<option value="AMARELA">Amarela</option>
					<option value="OUTRAS">Outras</option>
			</select></td>
			<td></td>
		</tr>
		<tr>
			<th valign="top">Estado Marital:</th>
			<td><select class="styledselect-day">
					<option value="">Selecione...</option>
					<option value="SOLTEIRO">Solteiro</option>
					<option value="CASADO">Casado</option>
					<option value="SEPARADO">Separado</option>
					<option value="VIUVO">Viúvo</option>
					<option value="OUTRO">Outro</option>
			</select></td>
			<td></td>
		</tr>
		<tr>
			<th valign="top">Renda mensal:</th>
			<td><input type="text" class="inp-form" /></td>
			<td></td>
		</tr>
		<tr>
			<th valign="top">Escolaridade:</th>
			<td><input type="text" class="inp-form" /></td>
			<td></td>
		</tr>
		<tr>
			<th valign="top">Ocupação:</th>
			<td><input type="text" class="inp-form" /></td>
			<td></td>
		</tr>
		<tr>
			<th>&nbsp;</th>
			<td valign="top"><input type="button" class="form-submit"
				ng-click="salvaPaciente()" /></td>
			<td></td>
		</tr>
	</table>
</div>




