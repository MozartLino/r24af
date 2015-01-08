<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../../geral/header.jsp" />

<div id="table-content">

	<div id="message-red" style="display: none">
		<table border="0" width="97%" cellpadding="0" cellspacing="0"
			style="margin-left: 20px;">
			<tr>
				<td class="red-left">Erro : <a href="" onclick="return false"
					id="message-text"> Essa Atividade não pode ser excluída, pois á
						paciente com essa atividade.</a></td>
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
					onclick="return false"> Atividade Removida com sucesso.</a></td>
				<td class="green-right"><a class="close-green"><img
						src="images/table/icon_close_green.gif" alt="" /></a></td>
			</tr>
		</table>
	</div>

	<form id="mainform" action="">
		<table border="0" width="100%" cellpadding="0" cellspacing="0"
			id="product-table">
			<tr>
				<th class="table-header-check"><a id="toggle-all"></a></th>
				<th class="table-header-repeat line-left minwidth-1"><a href="">Nome</a></th>
				<th class="table-header-repeat line-left"><a href="">MET</a></th>
				<th class="table-header-repeat line-left"><a href="">Categoria</a></th>
				<th class="table-header-repeat line-left"><a href="">Repouso</a></th>
				<th class="table-header-options line-left"><a href="">Opções</a></th>
			</tr>

			<c:forEach var="atividade" items="${atividadeList}">
				<tr>
					<td><input type="checkbox" /></td>
					<td>${atividade.nome}</td>
					<td><a href="">${atividade.MET}</a></td>
					<td>${atividade.categoria.nome}</td>
					<td><input type="checkbox" style="margin-left: 20px"
						disabled="disabled" ${atividade.repouso ? "checked" : ""}></td>
					<td class="options-width"><a href="atividade/${atividade.id}"
						title="Editar" class="icon-1 info-tooltip"></a> <a href=""
						onclick="return false" title="Remover"
						class="icon-2 info-tooltip remover" data-id="${atividade.id}"></a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>

<table border="0" cellpadding="0" cellspacing="0" id="paging-table">
	<tr>
		<td><a href="" class="page-far-left"></a> <a href=""
			class="page-left"></a>
			<div id="page-info">
				Page <strong>1</strong> / 15
			</div> <a href="" class="page-right"></a> <a href="" class="page-far-right"></a></td>
		<td><select class="styledselect_pages">
				<option value="">Number of rows</option>
				<option value="">1</option>
				<option value="">2</option>
				<option value="">3</option>
		</select></td>
	</tr>
</table>

<c:import url="../../geral/footer.jsp"></c:import>
<script src="<c:url value='/js/eventos/atividade.js' />"
	type="text/javascript"></script>
</body>
</html>