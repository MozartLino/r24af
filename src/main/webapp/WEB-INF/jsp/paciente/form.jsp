<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../../geral/header.jsp" />


<table border="0" width="100%" cellpadding="0" cellspacing="0">
	<tr valign="top">
		<td ng-app ng-controller="formPacientesController">
			<c:import url="camposObriagorios.jsp" /><br />
			<c:import url="camposAntecedentes.jsp" /><br />
			<c:import url="camposHabitos.jsp" /><br />
			<c:import url="camposAdicionais.jsp" />
		</td>
		<td>
			<c:import url="../../geral/menuLateral.jsp" />
		</td>
	</tr>
	<tr>
		<td><img src="<c:url value='/images/shared/blank.gif' />"
			width="695" height="1" alt="blank" /></td>
		<td></td>
	</tr>
</table>

<c:import url="../../geral/footer.jsp"></c:import>