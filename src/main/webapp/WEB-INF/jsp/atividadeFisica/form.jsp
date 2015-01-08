<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../../geral/header.jsp" />

<table border="0" width="100%" cellpadding="0" cellspacing="0">
	<tr valign="top">
		<td>
			<div id="step-holder">
				<div class="step-no">1</div>
				<div class="step-dark-left">Dados Obrigatórios</div>
				<div class="step-dark">&nbsp;</div>

				<div class="clear"></div>
			</div> <input type="hidden" class="inp-form" id="id"
			value='${atividadeFisica.id}' /> <input type="hidden"
			class="inp-form" id="pacienteId" value='${paciente.id}' /> <br /> <br />

			<table border="0" cellpadding="0" cellspacing="0" id="id-form">
				<tr>
					<th valign="top">Atividade:</th>
					<td>
						<select class="styledselect_form_1" id="atividade">
								<option value="" id="atividade_option">Atividade</option>
						</select>
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<th valign="top">Semana:</th>
					<td><select class="styledselect-day" id="diaDaSemana">
							<option value="">Semana</option>
							<option value="SEGUNDA">Segunda</option>
							<option value="TERCA">Terça</option>
							<option value="QUARTA">Quarta</option>
							<option value="QUINTA">Quinta</option>
							<option value="SEXTA">Sexta</option>
							<option value="SABADO">Sábado</option>
							<option value="DOMINGO">Domingo</option>
					</select></td>
					<td></td>
				</tr>
				<tr>
					<th valign="top">Dia:</th>
					<td><select class="styledselect-day" id="dia">
							<option value="">Dia</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
					</select></td>
					<td></td>
				</tr>
				<tr>
					<th valign="top">Tempo :</th>

					<td><span id=tempoInicial>Tempo Inicial : </span> <select
						class="styledselect-day_min" id="hora_inicial">

							<option value="00">00h</option>
							<option value="01">01h</option>
							<option value="02">02h</option>
							<option value="03">03h</option>
							<option value="04">04h</option>
							<option value="05">05h</option>
							<option value="06">06h</option>
							<option value="07">07h</option>
							<option value="08">08h</option>
							<option value="09">09h</option>
							<option value="10">10h</option>
							<option value="11">11h</option>
							<option value="12">12h</option>
							<option value="13">13h</option>
							<option value="14">14h</option>
							<option value="15">15h</option>
							<option value="16">16h</option>
							<option value="17">17h</option>
							<option value="18">18h</option>
							<option value="19">19h</option>
							<option value="20">20h</option>
							<option value="21">21h</option>
							<option value="22">22h</option>
							<option value="23">23h</option>
							<option value="24">24h</option>
					</select> <select class="styledselect-day_min" id="minuto_inicial">
							<option value="00">00m</option>
							<option value="01">01m</option>
							<option value="02">02m</option>
							<option value="03">03m</option>
							<option value="04">04m</option>
							<option value="05">05m</option>
							<option value="06">06m</option>
							<option value="07">07m</option>
							<option value="08">08m</option>
							<option value="09">09m</option>
							<option value="10">10m</option>
							<option value="11">11m</option>
							<option value="12">12m</option>
							<option value="13">13m</option>
							<option value="14">14m</option>
							<option value="15">15m</option>
							<option value="16">16m</option>
							<option value="17">17m</option>
							<option value="18">18m</option>
							<option value="19">19m</option>
							<option value="20">20m</option>
							<option value="21">21m</option>
							<option value="22">22m</option>
							<option value="23">23m</option>
							<option value="24">24m</option>
							<option value="25">25m</option>
							<option value="26">26m</option>
							<option value="27">27m</option>
							<option value="28">28m</option>
							<option value="29">29m</option>
							<option value="30">30m</option>
							<option value="31">31m</option>
							<option value="32">32m</option>
							<option value="33">33m</option>
							<option value="34">34m</option>
							<option value="35">35m</option>
							<option value="36">36m</option>
							<option value="37">37m</option>
							<option value="38">38m</option>
							<option value="39">39m</option>
							<option value="40">40m</option>
							<option value="41">41m</option>
							<option value="42">42m</option>
							<option value="43">43m</option>
							<option value="44">44m</option>
							<option value="45">45m</option>
							<option value="46">46m</option>
							<option value="47">47m</option>
							<option value="48">48m</option>
							<option value="49">49m</option>
							<option value="50">50m</option>
							<option value="51">51m</option>
							<option value="52">52m</option>
							<option value="53">53m</option>
							<option value="54">54m</option>
							<option value="55">55m</option>
							<option value="56">56m</option>
							<option value="57">57m</option>
							<option value="58">58m</option>
							<option value="59">59m</option>
					</select> <span id=tempoFinal> Tempo Final : </span> <select
						class="styledselect-day_min" id="hora_final">
							<option value="00">00h</option>
							<option value="01">01h</option>
							<option value="02">02h</option>
							<option value="03">03h</option>
							<option value="04">04h</option>
							<option value="05">05h</option>
							<option value="06">06h</option>
							<option value="07">07h</option>
							<option value="08">08h</option>
							<option value="09">09h</option>
							<option value="10">10h</option>
							<option value="11">11h</option>
							<option value="12">12h</option>
							<option value="13">13h</option>
							<option value="14">14h</option>
							<option value="15">15h</option>
							<option value="16">16h</option>
							<option value="17">17h</option>
							<option value="18">18h</option>
							<option value="19">19h</option>
							<option value="20">20h</option>
							<option value="21">21h</option>
							<option value="22">22h</option>
							<option value="23">23h</option>
							<option value="24">24h</option>

					</select> <select class="styledselect-day_min" id="minuto_final">
							<option value="00">00m</option>
							<option value="01">01m</option>
							<option value="02">02m</option>
							<option value="03">03m</option>
							<option value="04">04m</option>
							<option value="05">05m</option>
							<option value="06">06m</option>
							<option value="07">07m</option>
							<option value="08">08m</option>
							<option value="09">09m</option>
							<option value="10">10m</option>
							<option value="11">11m</option>
							<option value="12">12m</option>
							<option value="13">13m</option>
							<option value="14">14m</option>
							<option value="15">15m</option>
							<option value="16">16m</option>
							<option value="17">17m</option>
							<option value="18">18m</option>
							<option value="19">19m</option>
							<option value="20">20m</option>
							<option value="21">21m</option>
							<option value="22">22m</option>
							<option value="23">23m</option>
							<option value="24">24m</option>
							<option value="25">25m</option>
							<option value="26">26m</option>
							<option value="27">27m</option>
							<option value="28">28m</option>
							<option value="29">29m</option>
							<option value="30">30m</option>
							<option value="31">31m</option>
							<option value="32">32m</option>
							<option value="33">33m</option>
							<option value="34">34m</option>
							<option value="35">35m</option>
							<option value="36">36m</option>
							<option value="37">37m</option>
							<option value="38">38m</option>
							<option value="39">39m</option>
							<option value="40">40m</option>
							<option value="41">41m</option>
							<option value="42">42m</option>
							<option value="43">43m</option>
							<option value="44">44m</option>
							<option value="45">45m</option>
							<option value="46">46m</option>
							<option value="47">47m</option>
							<option value="48">48m</option>
							<option value="49">49m</option>
							<option value="50">50m</option>
							<option value="51">51m</option>
							<option value="52">52m</option>
							<option value="53">53m</option>
							<option value="54">54m</option>
							<option value="55">55m</option>
							<option value="56">56m</option>
							<option value="57">57m</option>
							<option value="58">58m</option>
							<option value="59">59m</option>
					</select></td>
				</tr>
				<tr>
					<th valign="top">Descriçao:</th>
					<td><textarea rows="" cols="" class="form-textarea"
							id="descricao"></textarea></td>
				</tr>
				<tr>
					<th>&nbsp;</th>
					<td valign="top"><input type="button" value=""
						class="form-submit finalizar" /></td>
					<td></td>
				</tr>
			</table>

		</td>
		<td><c:import url="../../geral/menuLateral.jsp" /></td>
	</tr>
	<tr>
		<td><img src="<c:url value='/images/shared/blank.gif' />"
			width="695" height="1" alt="blank" /></td>
		<td></td>
	</tr>
</table>

<c:import url="../../geral/modal.jsp"></c:import>
<c:import url="../../geral/footer.jsp"></c:import>

<script src="<c:url value='/js/eventos/atividadeFisica.js' />"
	type="text/javascript"></script>