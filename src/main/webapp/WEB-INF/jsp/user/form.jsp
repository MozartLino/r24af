<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../../geral/header.jsp" />


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
				onclick="return false">Usuário adicionado com sucesso.</a></td>
			<td class="green-right"><a class="close-green"><img
					src="/r24af/images/table/icon_close_green.gif" alt="" /></a></td>
		</tr>
	</table>
</div>

<table border="0" width="100%" cellpadding="0" cellspacing="0">
	<tr valign="top">
		<td>

			<div id="step-holder">
				<div class="step-no">1</div>
				<div class="step-dark-left">Dados Obrigatórios</div>
				<div class="step-dark">&nbsp;</div>

				<div class="clear"></div>
			</div> <br />
			<table border="0" cellpadding="0" cellspacing="0" id="id-form">
				<tr>
					<th valign="top">Login:</th>
					<td><input type="text" class="inp-form" id="login" /></td>
				</tr>
				<tr>
					<th valign="top">Senha:</th>
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
<br />
<c:import url="../../geral/footer.jsp"></c:import>
<script src="<c:url value='/js/eventos/user.js' />"
	type="text/javascript"></script>