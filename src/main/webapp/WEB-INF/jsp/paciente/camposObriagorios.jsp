<div id="step-holder">
	<div class="step-no">1</div>
	<div class="step-dark-left">Dados Obrigatórios</div>
	<div class="step-dark-right">&nbsp;</div>

	<div class="step-no-off">2</div>
	<div class="step-light-left">Antecedentes</div>
	<div class="step-light-right">&nbsp;</div>
	
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
		<td><input type="hidden" ng-model="paciente.id"/></td>
	</tr>
	<tr>
		<th valign="top">Nome:</th>
		<td><input type="text" class="inp-form" id="nome" ng-model="paciente.pessoa.nome" /></td>
	</tr>
	<tr>
		<th valign="top">E-mail:</th>
		<td><input type="text" class="inp-form" id="email" ng-model="paciente.pessoa.email"/></td>
	</tr>
	<tr>
		<th valign="top">Sexo:</th>
		<td>
			<select class="styledselect-day" id="sexo" ng-model="paciente.pessoa.sexo">
				<option value="">Selecione...</option>
				<option value="Masculino">Masculino</option>
				<option value="Feminino">Feminino</option>
			</select>
		</td>
		<td></td>
	</tr>
	<tr>
		<th valign="top">Altura:</th>
		<td><input type="text" class="inp-form" id="altura" ng-model="paciente.pessoa.altura"/></td>
		<td></td>
	</tr>
	<tr>
		<th valign="top">Peso:</th>
		<td><input type="text" class="inp-form" id="peso" ng-model="paciente.pessoa.peso"/></td>
		<td></td>
	</tr>
	<tr>
		<th valign="top">Data Nasc.:</th>
		<td><input type="text" class="inp-form" id="dataNascimento" ng-model="paciente.pessoa.dataNascimento" /></td>
		<td></td>
	</tr>
	<tr>
		<th>&nbsp;</th>
		<td valign="top">
			<input type="button" class="form-submit" ng-click="salvaPaciente()"/>
		</td>
		<td></td>
	</tr>
</table>
<br /><br />