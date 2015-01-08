<div id="step-holder">
	<div class="step-no-off">1</div>
	<div class="step-light-left">Dados Obrigatórios</div>
	<div class="step-light-right">&nbsp;</div>

	<div class="step-no">2</div>
	<div class="step-dark-left">Antecedentes</div>
	<div class="step-dark-right">&nbsp;</div>

	<div class="step-no-off">3</div>
	<div class="step-light-left">Hábitos</div>
	<div class="step-light-right">&nbsp;</div>

	<div class="step-no-off">4</div>
	<div class="step-light-left">Inform. Adicionais</div>
	<div class="step-light-round">&nbsp;</div>

	<div class="clear"></div>
</div>

<table border="0" cellpadding="0" cellspacing="0" id="id-form">
	<tr>
		<th valign="top">Antecedentes Familiares :</th>
		<td><select class="styledselect-day"
			ng-model="paciente.pessoa.antecedentes">
				<option value="">Selecione...</option>
				<option value="NAO">Nao</option>
				<option value="SIM">Sim</option>
		</select></td>
		<td></td>
	</tr>
	<tr>
		<th valign="top">Diabetes Mellitus:</th>
		<td><select class="styledselect-day" ng-model="paciente.pessoa.diabetes">
				<option value="">Selecione...</option>
				<option value="NAO">Nao</option>
				<option value="SIM">Sim</option>
				<option value="NAOSABE">Nao Sabe</option>
		</select></td>
		<td></td>
	</tr>
	<tr>
		<th valign="top">Acid. Vascular encefálico</th>
		<td><select class="styledselect-day" ng-model="paciente.pessoa.vascular">
				<option value="">Selecione...</option>
				<option value="NAO">Nao</option>
				<option value="SIM">Sim</option>
				<option value="NAOSABE">Nao Sabe</option>
		</select></td>
		<td></td>
	</tr>
	<tr>
		<th valign="top">Hipertensão Arterial:</th>
		<td><select class="styledselect-day"
			ng-model="paciente.pessoa.hipertensao">
				<option value="">Selecione...</option>
				<option value="NAO">Nao</option>
				<option value="SIM">Sim</option>
				<option value="NAOSABE">Nao Sabe</option>
		</select></td>
		<td></td>
	</tr>
	<tr>
		<th valign="top">Cardiopatias:</th>
		<td><select class="styledselect-day"
			ng-model="paciente.pessoa.cardiopatias">
				<option value="">Selecione...</option>
				<option value="NAO">Nao</option>
				<option value="SIM">Sim</option>
				<option value="NAOSABE">Nao Sabe</option>
		</select></td>
		<td></td>
	</tr>
	<tr>
		<th valign="top">Neoplasias:</th>
		<td><select class="styledselect-day"
			ng-model="paciente.pessoa.neoplasias">
				<option value="">Selecione...</option>
				<option value="NAO">Nao</option>
				<option value="SIM">Sim</option>
				<option value="NAOSABE">Nao Sabe</option>
		</select></td>
		<td></td>
	</tr>
	<tr>
		<th valign="top">Hiperlipidemias:</th>
		<td><select class="styledselect-day"
			ng-model="paciente.pessoa.hiperlipidemias">
				<option value="">Selecione...</option>
				<option value="NAO">Nao</option>
				<option value="SIM">Sim</option>
				<option value="NAOSABE">Nao Sabe</option>
		</select></td>
		<td></td>
	</tr>
	<tr>
		<th>&nbsp;</th>
		<td valign="top"><input type="button" class="form-submit"
			ng-click="salvaPaciente()" /></td>
		<td></td>
	</tr>
</table>
<br />
<br />