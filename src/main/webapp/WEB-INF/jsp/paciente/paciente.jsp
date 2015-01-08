<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../../geral/header.jsp" />

<div id="table-content">

	<b>Paciente :</b> ${paciente.nome} <br /> <br /> <b>Email :</b>
	${paciente.email} <br /> <br /> <b>Estatura :</b> ${paciente.altura}
	<br /> <br /> <b>Peso :</b> ${paciente.peso} <br /> <br /> <b>Sexo
		:</b> ${paciente.sexo} <br /> <br /> <b>Gasto Total[Kcal] :</b>
	${paciente.caloriaTotal}<br /> <br /> <b>Basal segundo Harris
		Benedict :</b> ${paciente.basalHarrisBenedict} <br /> <br /> <b>Basal
		segundo a FAO:</b> ${paciente.basalFAO} <input type="hidden"
		id="pacienteId" value="${paciente.id}">
	<div id="top-search">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td><select class="styledselect" id="select_categoria">
						<option value="">Categoria</option>
						<c:forEach var="categoria" items="${categoriaList}">
							<option value="${categoria.id}">${categoria.nome}</option>
						</c:forEach>
				</select></td>
				<td><select class="styledselect" id="diaDaSemana">
						<option value="0">Semana</option>
						<option value="1">Segunda</option>
						<option value="2">Terça</option>
						<option value="3">Quarta</option>
						<option value="4">Quinta</option>
						<option value="5">Sexta</option>
						<option value="6">Sábado</option>
						<option value="7">Domingo</option>
				</select></td>
				<td><select class="styledselect" id="diaDaSemana">
						<option value="0">1 - 7 (Todos)</option>
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
	</div>
	<div class="clear"></div>
	<h3>
		Atividades Física <a
			href="/r24af/paciente/${paciente.id}/atividadeFisica"
			id="nova_atividade" style="color: #92b22c;">+</a>
	</h3>

	<div id="message-red" style="display: none">
		<table border="0" width="97%" cellpadding="0" cellspacing="0"
			style="margin-left: 20px;">
			<tr>
				<td class="red-left">Erro : <a href="" onclick="return false"
					id="message-text"> Verifique os erros e tente novamente.</a></td>
				<td class="red-right"><a class="close-red"><img
						src="/r24af/images/table/icon_close_red.gif" alt="" /></a></td>
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
						src="/r24af/images/table/icon_close_green.gif" alt="" /></a></td>
			</tr>
		</table>
	</div>

	<form id="mainform" action="">
		<table border="0" width="100%" cellpadding="0" cellspacing="0"
			id="product-table">
			<tr>
				<th class="table-header-check"><a id="toggle-all"></a></th>
				<th class="table-header-options line-left"><a href="">Atividade
						Física</a></th>
				<th class="table-header-repeat line-left"><a href="">MET</a></th>
				<th class="table-header-repeat line-left"><a href="">Gasto
						Total[Kcal]</a></th>
				<th class="table-header-repeat line-left"><a href="">Inicio</a></th>
				<th class="table-header-repeat line-left"><a href="">Fim</a></th>
				<th class="table-header-repeat line-left"><a href="">Duração</a></th>
				<th class="table-header-options line-left"><a href="">Descrição</a></th>
				<th class="table-header-options line-left"><a href="">Opções</a></th>
			</tr>

			<c:forEach var="atividadeFisica" items="${atividadeFisicaList}"
				varStatus="contador">
				<tr class="atividadesRealizada alternate-row${contador.count%2==0}">
					<td><span class="ui-checkbox"
						style='background: ${atividadeFisica.corIntensidade}'></span></td>
					<td>${atividadeFisica.atividade.nome}</td>
					<td><a href="">${atividadeFisica.atividade.MET}</a></td>
					<td>${atividadeFisica.caloria}</td>
					<td>${atividadeFisica.horaInicial}</td>
					<td>${atividadeFisica.horaFinal}</td>
					<td>${atividadeFisica.tempo}</td>
					<td>${atividadeFisica.descricao}</td>
					<td class="options-width"><a
						href="atividadeFisica/${atividadeFisica.id}" title="Editar"
						class="icon-1 info-tooltip"></a> <a href=""
						onclick="return false;" title="Remover"
						class="icon-2 info-tooltip remover"
						data-id="${atividadeFisica.id}"> </a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>

<c:import url="../../geral/footer.jsp"></c:import>
<script src="<c:url value='/js/eventos/atividadeFisica.js' />"
	type="text/javascript"></script>
</body>
</html>