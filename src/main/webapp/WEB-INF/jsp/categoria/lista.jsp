<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../../geral/header.jsp" />

<div id="table-content" ng-app ng-controller="categoriaController">

	<div id="message-red" style="display: none">
		<table border="0" width="97%" cellpadding="0" cellspacing="0"
			style="margin-left: 20px;">
			<tr>
				<td class="red-left">Erro : <a href="" onclick="return false"
					id="message-text"> Existe uma Atividade cadastrada com essa categoria. Remova a atividade e tente a exclusão novamente.</a></td>
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
					onclick="return false">Usuário Removido com sucesso.</a></td>
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
				<th class="table-header-options line-left"><a href="">Options</a></th>
			</tr>

			<tr ng-repeat="categoria in categorias">
					<td><input type="checkbox" /></td>
					<td>{{categoria.nome}}</td>
					<td class="options-width">
						<a href="categoria/{{categoria.id}}" title="Editar" class="icon-1 info-tooltip"></a> 
						<a href="" title="Excluir" class="icon-2 info-tooltip" ng-click="exclui(categoria)"></a>
					</td>
				</tr>
		</table>
	</form>
</div>

<c:import url="../../geral/footer.jsp"></c:import>
<script src="<c:url value='/js/eventos/categoria.js' />"
	type="text/javascript"></script>