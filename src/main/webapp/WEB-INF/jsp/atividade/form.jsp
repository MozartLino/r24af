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
			value='${atividade.id}' />


			<table border="0" cellpadding="0" cellspacing="0" id="id-form">
				<tr>
					<th valign="top">Nome:</th>
					<td><input type="text" class="inp-form" id="nome"
						value='${atividade.nome}' /></td>
				</tr>
				<tr>
					<th valign="top">MET:</th>
					<td><input type="text" class="inp-form" id="MET"
						value='${atividade.MET}' /></td>
				</tr>
				<tr>
					<th valign="top">Categoria:</th>
					<td><select class="styledselect-day" id="categoria">
							<option value="">Selecione...</option>
							<c:forEach var="categoria" items="${categoriaList}">
								<option value="${categoria.id}">${categoria.nome}</option>
							</c:forEach>
					</select></td>
					<td></td>
				</tr>
				<tr>
					<th valign="top">Atividade de Repouso:</th>
					<td><select class="styledselect-day" id="repouso">
							<option value="0">Não</option>
							<option value="1">Sim</option>

					</select></td>
				</tr>
				<tr>
					<th>&nbsp;</th>
					<td valign="top"><input type="button" value=""
						class='form-submit ${atividade.id == undefined ? "finalizar" : "editar"}' />

					</td>
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

<c:import url="../../geral/footer.jsp"></c:import>
<script src="<c:url value='/js/eventos/atividade.js' />"
	type="text/javascript"></script>
</body>
</html>

