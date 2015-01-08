<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../../geral/header.jsp" />

<table border="0" width="100%" cellpadding="0" cellspacing="0">
	<tr valign="top">
		<td>

			<div id="step-holder">
				<div class="step-no">1</div>
				<div class="step-dark-left">Dados Obrigatórios</div>
				<div class="step-dark-right">&nbsp;</div>

				<div class="clear"></div>
			</div>

			<table border="0" cellpadding="0" cellspacing="0" id="id-form">
				<tr>
					<th valign="top">Login:</th>
					<td><input type="hidden" class="inp-form" id="id"
						value='${user.id}' /> <input type="text" class="inp-form"
						id="login" value='${user.login}' disabled="disabled" /></td>
				</tr>
				<tr>
					<th valign="top">Nova Senha:</th>
					<td><input type="password" class="inp-form" id="senha" /></td>
				</tr>
				<tr>
					<th valign="top">Confirmar Senha:</th>
					<td><input type="password" class="inp-form"
						id="confirmar_senha" /></td>
				</tr>
				<tr>
					<th>&nbsp;</th>
					<td valign="top"><input type="button" value=""
						class='form-submit finalizar' /></td>
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
<br /><br />
<div class="clear"></div>

<c:import url="../../geral/footer.jsp"></c:import>

<script src="<c:url value='/js/eventos/user.js' />"
	type="text/javascript"></script>