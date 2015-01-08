<div id="camposHabitos">
	<br /> <br />
	<div id="step-holder">
		<div class="step-no-off">1</div>
		<div class="step-light-left">Dados Obrigatórios</div>
		<div class="step-light-right">&nbsp;</div>

		<div class="step-no-off">2</div>
		<div class="step-light-left">Antecedentes</div>
		<div class="step-light-right">&nbsp;</div>

		<div class="step-no">3</div>
		<div class="step-dark-left">Hábitos</div>
		<div class="step-dark-right">&nbsp;</div>

		<div class="step-no-off">4</div>
		<div class="step-light-left">Inform. Adicionais</div>
		<div class="step-light-round">&nbsp;</div>

		<div class="clear"></div>
	</div>

	<table border="0" cellpadding="0" cellspacing="0" id="id-form">
		<tr>
			<th valign="top">Fuma atualmente? :</th>
			<td><select class="styledselect-day"
				ng-model="paciente.pessoa.fumaAtual" ng-change="fumaAtualmenteChange()">
					<option value="">Selecione...</option>
					<option value="NAO">Nao</option>
					<option value="SIM">Sim</option>
			</select></td>
			<td></td>
		</tr>
		<tr class="hidden fuma">
			<th valign="top">Quantos Cigarros por Dia:</th>
			<td><input type="text" class="inp-form"
				ng-model="paciente.pessoa.qtdCigarrosAtual" /></td>
			<td></td>
		</tr>
		<tr class="hidden fuma">
			<th valign="top">Há quanto Tempo fumou (meses):</th>
			<td><input type="text" class="inp-form"
				ng-model="paciente.pessoa.tempoEmMesesQueFumaAtual" /></td>
			<td></td>
		</tr>
		<tr class="hidden fuma">
			<th valign="top">Tipo de fumo:</th>
			<td><select class="styledselect-day"
				ng-model="paciente.pessoa.tipoFumo" ng-change="tipoDeFumoChange()">
					<option value="">Selecione...</option>
					<option value="CSF">Cigarro sem Filtro</option>
					<option value="CCF">Cigarro com Filtro</option>
					<option value="CACHIMBO">Cachimbo</option>
					<option value="CHARUTO">Charuto</option>
					<option value="OUTRO">Outro</option>
			</select></td>
			<td></td>
		</tr>
		<tr class="parouDeFumar">
			<th valign="top">Parou de fumar? :</th>
			<td><select class="styledselect-day"
				ng-model="paciente.pessoa.parouDeFumar" ng-change="fumavaChange()">
					<option value="">Selecione...</option>
					<option value="NAO">Nao</option>
					<option value="SIM">Sim</option>
			</select></td>
			<td></td>
		</tr>
		<tr class="hidden fumava">
			<th valign="top">Parou há quanto tempo?</th>
			<td><input type="text" class="inp-form" ng-model="paciente.pessoa.parouHaQuantoTempo" />
			</td>
			<td></td>
		</tr>
		<tr class="hidden fumava">
			<th valign="top">Fumou por quanto tempo?(meses):</th>
			<td><input type="text" class="inp-form" ng-model="paciente.pessoa.tempoQueFumouEmMEses" />
			</td>
			<td></td>
		</tr>
		<tr class="hidden fumava">
			<th valign="top">Fumava quantos cigarros por dia?:</th>
			<td><input type="text" class="inp-form" ng-model="paciente.peso" />
			</td>
			<td></td>
		</tr>
		<tr class="hidden fumava">
			<th valign="top">Tipo de fumo:</th>
			<td><select class="styledselect-day"
				ng-model="paciente.pessoa.tipoFumo" ng-change="tipoDeFumoChange()">
					<option value="">Selecione...</option>
					<option value="CSF">Cigarro sem Filtro</option>
					<option value="CCF">Cigarro com Filtro</option>
					<option value="CACHIMBO">Cachimbo</option>
					<option value="CHARUTO">Charuto</option>
					<option value="OUTRO">Outro</option>
			</select></td>
			<td></td>
		</tr>
		<tr class="alcoolismo">
			<th valign="top">Alcoolismo? :</th>
			<td><select class="styledselect-day" ng-model="paciente.pessoa.alcoolismo" ng-change="alcoolismoChange()">
					<option value="">Selecione...</option>
					<option value="NAO">Nao</option>
					<option value="SIM">Sim</option>
			</select></td>
			<td></td>
		</tr>
		<tr class="consomeAlcool hidden">
			<th valign="top">Qual frequência?:</th>
			<td>
				<select class="styledselect-day" ng-model="frequenciaAlcool">
					<option value="">Selecione...</option>
					<option value="SIM">1 há 2 vezes na semana</option>
					<option value="SIM">3 há 4 vezes na semana</option>
					<option value="SIM">5 há 6 vezes na semana</option>
					<option value="SIM">Todos os dias</option>
				</select>
			</td>
			<td></td>
		</tr>
		<tr class="consomeAlcool hidden">
			<th valign="top">Tipo da bebida:</th>
			<td><select class="styledselect-day" ng-model="paciente.pessoa.tipoBebida">
					<option value="">Selecione...</option>
					<option value="CERVEJA">Cerveja</option>
					<option value="AGUARDENTE">Aguardente</option>
					<option value="CONHAQUE">Conhaque</option>
					<option value="LICOR">Licor</option>
					<option value="VINHO">Vinho</option>
					<option value="WHISKY">Whisky</option>
					<option value="OUTRO">Outro</option>
			</select></td>
			<td></td>
		</tr>
		<tr class="consomeAlcool hidden">
			<th valign="top">Quantidade?(ml):</th>
			<td><input type="text" class="inp-form" ng-model="paciente.pessoa.qdeBebida" />
			</td>
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