<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../../geral/header.jsp" />

<table border="0" width="100%" cellpadding="0" cellspacing="0" ng-app ng-controller="categoriaEditeController">
	<tr valign="top">
		<td>
			<div id="step-holder">
				<div class="step-no">1</div>
				<div class="step-dark-left">Dados Obrigatórios</div>
				<div class="step-dark">&nbsp;</div>
				<div class="clear"></div>
			</div> <br /> <br />

			<table border="0" cellpadding="0" cellspacing="0" id="id-form">
				<tr>
					<th valign="top">Nome:</th>
					<td>
						<input type="hidden" class="inp-form" ng-model="categoria.id" value="${categoria.id}"/> 
						<input type="text" class="inp-form" ng-model="categoria.nome" value="${categoria.nome}"/>
					</td>
				</tr>
				<tr>
					<th>&nbsp;</th>
					<td valign="top"><input type="button" class='form-submit'
						ng-click="enviaCategoria()" /></td>
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
<br /><br /><br /><br /><br /><br /><br />
<c:import url="../../geral/footer.jsp"></c:import>
</body>
</html>