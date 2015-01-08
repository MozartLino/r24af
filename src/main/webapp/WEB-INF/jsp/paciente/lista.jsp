<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="../../geral/header.jsp" />

<div id="table-content" ng-app ng-controller="listaPacientesController">
	<div id="top-search">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td><select class="styledselect" id="select_porcento"
					ng-model="basal" ng-change="alteraEquacaoBasal()">
						<option value="">Equação Basal</option>
						<option value="harris">Eq. Harris-Benedict</option>
						<option value="fao">Eq. FAO/OMS</option>
				</select></td>
				<td><select class="styledselect" ng-model="porcento"
					ng-change="alteraPorcentagem()">
						<option value="">Porcentagem</option>
						<option value="sem">Sem 10%</option>
						<option value="com">Com 10%</option>
				</select></td>
				<td><select class="styledselect" ng-model="sedentario"
					ng-change="buscaPacientesSemAtividadesSedentaria()">
						<option value="">Opções</option>
						<option value="COM">Com Atividade Sedentaria</option>
						<option value="SEM">Sem Atividade Sedentaria</option>
				</select></td>
				<td><select class="styledselect" ng-model="diaDaSemana"
					ng-change="buscaPacientesComAtividadesPeloDiaDaSemanaCadastrada()">
						<option value="">Semana</option>
						<option value="SEGUNDA">Segunda</option>
						<option value="TERCA">Terça</option>
						<option value="QUARTA">Quarta</option>
						<option value="QUINTA">Quinta</option>
						<option value="SEXTA">Sexta</option>
						<option value="SABADO">Sábado</option>
						<option value="DOMINGO">Domingo</option>
				</select></td>
				<td><select class="styledselect" ng-model="dia"
					ng-change="buscaPacientesComAtividadePeloDiaCadastrado()">
						<option value="">1 - 7 (Todos)</option>
						<option value="8">6 e 7 (Fim de semana)</option>
						<option value="9">1 há 5 (dias úteis)</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
				</select></td>
			</tr>
		</table>
		<br />
	</div>

	<div id="message-red" style="display: none">
		<table border="0" width="97%" cellpadding="0" cellspacing="0"
			style="margin-left: 20px;">
			<tr>
				<td class="red-left">Erro : <a href="" onclick="return false"
					id="message-text"> Verifique os erros e tente novamente.</a></td>
				<td class="red-right"><a class="close-red"><img
						src="images/table/icon_close_red.gif" alt="" /></a></td>
			</tr>
		</table>
	</div>
	<div id="message-green" style="display: none">
		<table border="0" width="97%" cellpadding="0" cellspacing="0"
			style="margin-left: 20px;">
			<tr>
				<td class="green-left">Sucesso. <a href=""
					onclick="return false">Paciente Removido com Sucesso.</a></td>
				<td class="green-right"><a class="close-green"><img
						src="images/table/icon_close_green.gif" alt="" /></a></td>
			</tr>
		</table>
	</div>

	<form id="mainform" action="">
		<table border="0" width="100%" cellpadding="0" cellspacing="0"
			id="product-table">
			<tr>
				<th class="table-header-repeat line-left minwidth-1"
					style="min-width: 140px"><a href="">Nome</a></th>
				<th class="table-header-repeat line-left"><a href="">Basal</a></th>
				<th class="table-header-repeat line-left"><a href="">kcal</a></th>
				<th class="table-header-repeat line-left" style="min-width: 108px;"><a
					href="">Tempo Total</a></th>
				<th class="table-header-repeat line-left"><a href="">Leve[kcal]</a></th>
				<th class="table-header-repeat line-left" style="min-width: 85px;"><a
					href="">Tempo</a></th>
				<th class="table-header-repeat line-left"><a href="">Moderado[kcal]</a></th>
				<th class="table-header-repeat line-left"><a href="">Tempo</a></th>
				<th class="table-header-repeat line-left"><a href="">Vigoroso[kcal]</a></th>
				<th class="table-header-repeat line-left"><a href="">Tempo</a></th>
				<th class="table-header-repeat line-left"><a href="">Idade</a></th>
				<th class="table-header-repeat line-left"><a href="">Peso</a></th>
				<th class="table-header-repeat line-left"><a href="">Altura</a></th>
				<th class="table-header-repeat line-left" style="min-width: 110px"><a
					href="">Opções</a></th>
			</tr>
			<tr ng-repeat="paciente in pacientes"
				class='paciente  alternate-row{{$index%2==0}}'>
				<td>{{paciente.nome}}</td>
				<td>{{paciente.basal}}</td>
				<td>{{paciente.caloriaTotal}}</td>
				<td>{{paciente.tempoTotal}} min.</td>
				<td>{{paciente.caloriaLeve}}</td>
				<td>{{paciente.tempoLeve}} min.</td>
				<td>{{paciente.caloriaModerado}}</td>
				<td>{{paciente.tempoModerado}} min.</td>
				<td>{{paciente.caloriaVigoroso}}</td>
				<td>{{paciente.tempoVigoroso}} min.</td>
				<td>{{paciente.idade}}</td>
				<td>{{paciente.peso}}</td>
				<td>{{paciente.altura}}</td>
				<td class="options-width"><a href="paciente/{{paciente.id}}"
					title="Editar" class="icon-1 info-tooltip"></a> <a href="#"
					title="Remover" class="icon-2 info-tooltip"
					ng-click="remover(paciente)"> </a><a
					href="paciente/{{paciente.id}}/atividadesFisica" title="Visualizar"
					class="icon-5 info-tooltip"> </a></td>
			</tr>
		</table>
	</form>
	<div id="message-red2" class="hidden">
		<table border="0" width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td class="red-left">Erro. Não gerou a planilha<a href=""
					id="error"></a></td>
				<td class="red-right"><a class="close-red"><img
						src="/r24af/images/table/icon_close_red.gif" alt="" /></a></td>
			</tr>
		</table>
	</div>
	<div id="message-green2" class="hidden">
		<table border="0" width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td class="green-left">Sucesso. Planilha gerada com sucesso<a
					href="" id="success"></a></td>
				<td class="green-right"><a class="close-green"><img
						src="/r24af/images/table/icon_close_green.gif" alt="" /></a></td>
			</tr>
		</table>
	</div>
	<input type="button" class="cupid-green" ng-click="geradorExcel()"
		value="Gerar Planilha" />
</div>

<c:import url="../../geral/footer.jsp"></c:import>
</body>
</html>