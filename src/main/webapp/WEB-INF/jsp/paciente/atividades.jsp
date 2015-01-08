<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../../geral/cabecalho.jsp" />

<div id="content-outer">
	<div id="content">
		<div id="page-heading">
			<h1>Add product</h1>
		</div>
		<table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
			<tr>
				<th rowspan="3" class="sized"><img src="<c:url value='/images/shared/side_shadowleft.jpg' />" width="20" height="300" alt="" /></th>
				<th class="topleft"></th>
				<td id="tbl-border-top">&nbsp;</td>
				<th class="topright"></th>
				<th rowspan="3" class="sized"><img src="<c:url value='/images/shared/side_shadowright.jpg' />" width="20" height="300" alt="" /></th>
			</tr>
			<tr>
				<td id="tbl-border-left"></td>
				<td>
					<!--  start content-table-inner ...................................................................... START -->
					<div id="content-table-inner">

						<!--  start table-content  -->
						<div id="table-content">
						
						<input type="button" value="+ atividade" class="" />

							<form id="mainform" action="">
								<table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
									<tr>
										<th class="table-header-check"><a id="toggle-all"></a></th>
										<th class="table-header-repeat line-left minwidth-1"><a href="">Last Name</a></th>
										<th class="table-header-repeat line-left minwidth-1"><a href="">First Name</a></th>
										<th class="table-header-repeat line-left"><a href="">Email</a></th>
										<th class="table-header-repeat line-left"><a href="">Due</a></th>
										<th class="table-header-repeat line-left"><a href="">Website</a></th>
										<th class="table-header-options line-left"><a href="">Options</a></th>
									</tr>
									<tr>
										<td><input type="checkbox" /></td>
										<td>Sabev</td>
										<td>George</td>
										<td><a href="">george@mainevent.co.za</a></td>
										<td>R250</td>
										<td><a href="">www.mainevent.co.za</a></td>
										<td class="options-width"><a href="" title="Edit" class="icon-1 info-tooltip"></a> <a href="" title="Edit" class="icon-2 info-tooltip"></a>
											<a href="" title="Edit" class="icon-3 info-tooltip"></a> <a href="" title="Edit" class="icon-4 info-tooltip"></a> <a href="" title="Edit"
											class="icon-5 info-tooltip"></a></td>
									</tr>
									<tr class="alternate-row">
										<td><input type="checkbox" /></td>
										<td>Sabev</td>
										<td>George</td>
										<td><a href="">george@mainevent.co.za</a></td>
										<td>R250</td>
										<td><a href="">www.mainevent.co.za</a></td>
										<td class="options-width"><a href="" title="Edit" class="icon-1 info-tooltip"></a> <a href="" title="Edit" class="icon-2 info-tooltip"></a>
											<a href="" title="Edit" class="icon-3 info-tooltip"></a> <a href="" title="Edit" class="icon-4 info-tooltip"></a> <a href="" title="Edit"
											class="icon-5 info-tooltip"></a></td>
									</tr>
									<tr>
										<td><input type="checkbox" /></td>
										<td>Sabev</td>
										<td>George</td>
										<td><a href="">george@mainevent.co.za</a></td>
										<td>R250</td>
										<td><a href="">www.mainevent.co.za</a></td>
										<td class="options-width"><a href="" title="Edit" class="icon-1 info-tooltip"></a> <a href="" title="Edit" class="icon-2 info-tooltip"></a>
											<a href="" title="Edit" class="icon-3 info-tooltip"></a> <a href="" title="Edit" class="icon-4 info-tooltip"></a> <a href="" title="Edit"
											class="icon-5 info-tooltip"></a></td>
									</tr>
									<tr class="alternate-row">
										<td><input type="checkbox" /></td>
										<td>Sabev</td>
										<td>George</td>
										<td><a href="">george@mainevent.co.za</a></td>
										<td>R250</td>
										<td><a href="">www.mainevent.co.za</a></td>
										<td class="options-width"><a href="" title="Edit" class="icon-1 info-tooltip"></a> <a href="" title="Edit" class="icon-2 info-tooltip"></a>
											<a href="" title="Edit" class="icon-3 info-tooltip"></a> <a href="" title="Edit" class="icon-4 info-tooltip"></a> <a href="" title="Edit"
											class="icon-5 info-tooltip"></a></td>
									</tr>
									<tr>
										<td><input type="checkbox" /></td>
										<td>Sabev</td>
										<td>George</td>
										<td><a href="">george@mainevent.co.za</a></td>
										<td>R250</td>
										<td><a href="">www.mainevent.co.za</a></td>
										<td class="options-width"><a href="" title="Edit" class="icon-1 info-tooltip"></a> <a href="" title="Edit" class="icon-2 info-tooltip"></a>
											<a href="" title="Edit" class="icon-3 info-tooltip"></a> <a href="" title="Edit" class="icon-4 info-tooltip"></a> <a href="" title="Edit"
											class="icon-5 info-tooltip"></a></td>
									</tr>
									<tr class="alternate-row">
										<td><input type="checkbox" /></td>
										<td>Sabev</td>
										<td>George</td>
										<td><a href="">george@mainevent.co.za</a></td>
										<td>R250</td>
										<td><a href="">www.mainevent.co.za</a></td>
										<td class="options-width"><a href="" title="Edit" class="icon-1 info-tooltip"></a> <a href="" title="Edit" class="icon-2 info-tooltip"></a>
											<a href="" title="Edit" class="icon-3 info-tooltip"></a> <a href="" title="Edit" class="icon-4 info-tooltip"></a> <a href="" title="Edit"
											class="icon-5 info-tooltip"></a></td>
									</tr>
								</table>
							</form>
						</div>
						<div id="actions-box">
							<a href="" class="action-slider"></a>
							<div id="actions-box-slider">
								<a href="" class="action-edit">Edit</a> <a href="" class="action-delete">Delete</a>
							</div>
							<div class="clear"></div>
						</div>
						<table border="0" cellpadding="0" cellspacing="0" id="paging-table">
							<tr>
								<td><a href="" class="page-far-left"></a> <a href="" class="page-left"></a>
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
						<div class="clear"></div>
					</div>
				</td>
				<td id="tbl-border-right"></td>
			</tr>
			<tr>
				<th class="sized bottomleft"></th>
				<td id="tbl-border-bottom">&nbsp;</td>
				<th class="sized bottomright"></th>
			</tr>
		</table>
		<div class="clear">&nbsp;</div>

	</div>
	<div class="clear">&nbsp;</div>
</div>

<div class="clear">&nbsp;</div>

<c:import url="../../geral/footer.jsp" />