<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="basic-modal-content">

	<div id="content">

		<div id="page-heading">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><input id="atividade_busca" type="text" value="Atividades"
						onblur="if (this.value=='') { this.value='Atividades'; }"
						onfocus="if (this.value=='Atividades') { this.value=''; }"
						class="top-search-inp" /></td>
					<td>
						<select class="styledselect categoria_select"
							id="select_categoria">
								<option value="">Categoria</option>
								<c:forEach var="categoria" items="${categoriaList}">
									<option value="${categoria.id}">${categoria.nome}</option>
								</c:forEach>
						</select>
					</td>
				</tr>
			</table>
			<br /> <br />
			<table border="0" width="94%" cellpadding="0" cellspacing="0"
				id="modal-table">
				<tr>
					<th class="table-header-options line-left"><a href="">Atividade</a></th>
					<th class="table-header-repeat line-left" ><a href="">MET</a></th>
					<th class="table-header-repeat line-left"><a href="">Repouso</a></th>
					<th class="table-header-options line-left"><a href="">Categoria</a></th>
				</tr>
				<c:forEach var="atividade" items="${atividadeList}">
					<tr class="atividades" data-id="${atividade.id}" data-text="${atividade.nome}">
						<td>${atividade.nome}</td>
						<td>${atividade.MET}</td>
						<td>
							<input type="checkbox" style="margin-left: 20px" disabled="disabled" ${atividade.repouso ? "checked" : ""}>
						</td>
						<td>${atividade.categoria.nome}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="clear"></div>

		<div class="clear">&nbsp;</div>
	</div>

</div>