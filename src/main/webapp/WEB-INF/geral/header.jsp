<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>R24AF</title>
<link rel="stylesheet" href="<c:url value='/css/screen.css' />"
	type="text/css" media="screen" title="default" />
<link rel="stylesheet" href="<c:url value='/css/datePicker.css' />"
	type="text/css" />

</head>
<body ng-app>

	<div id="page-top-outer">
		<div id="page-top">
			<div id="logo">
				<a href=""><img src="/r24af/images/shared/logo.png" width="156"
					height="40" alt="" /></a>
			</div>
			<div id="top-search">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><input type="text" value="Search"
							onblur="if (this.value=='') { this.value='Search'; }"
							onfocus="if (this.value=='Search') { this.value=''; }"
							class="top-search-inp" /></td>
						<td><input type="image"
							src="/r24af/images/shared/top_search_btn.gif" /></td>
					</tr>
				</table>
			</div>
			<div class="clear"></div>
		</div>
	</div>

	<div class="clear">&nbsp;</div>

	<div class="nav-outer-repeat">
		<div class="nav-outer">
			<div id="nav-right">
				<div class="nav-divider">&nbsp;</div>
				<div class="showhide-account">
					<img src="/r24af/images/shared/nav/nav_myaccount.gif" width="93"
						height="14" alt="" />
				</div>
				<div class="nav-divider">&nbsp;</div>
				<a href="" id="logout"><img
					src="/r24af/images/shared/nav/nav_logout.gif" width="64"
					height="14" alt="" /></a>
				<div class="clear">&nbsp;</div>

				<div class="account-content">
					<div class="account-drop-inner">
						<a href="" onclick="return false" class="editar_usuario">Alterar
							Senha</a>
						<div class="clear">&nbsp;</div>
						<div class="acc-line">&nbsp;</div>
						<a href="" onclick="return false;" class="remover_usuario">Excluir
							Conta</a>
					</div>
				</div>
			</div>


			<div class="nav">
				<div class="table menus" ng-controller="menuController">

					<ul class="{{menuCadastro}}">
						<li><a href="#nogo"><b>Cadastro</b></a>
							<div class="select_sub {{cadastro}}">
								<ul class="sub">
									<li class="{{paciente}}"><a href="/r24af/paciente">Paciente</a></li>
									<li class="{{atividade}}"><a href="/r24af/atividade">Atividade</a></li>
									<li class="{{categoria}}"><a href="/r24af/categoria">Categoria</a></li>
									<li class="{{usuario}}"><a href="/r24af/usuario">Usuário</a></li>
								</ul>
							</div></li>
					</ul>

					<div class="nav-divider">&nbsp;</div>

					<ul class="{{menuConsulta}}">
						<li><a href="" onclick="return false;"><b>Consulta</b></a>
							<div class="select_sub {{consulta}}">
								<ul class="sub">
									<li class="{{pacientes}}"><a href="/r24af/pacientes">Pacientes</a></li>
									<li class="{{atividades}}"><a href="/r24af/atividades">Atividades</a></li>
									<li class="{{categorias}}"><a href="/r24af/categorias">Categorias</a></li>
								</ul>
							</div></li>
					</ul>

				</div>
			</div>

		</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>


	<div id="content-outer">
		<div id="content">

			<div id="page-heading">
				<h1 ng-controller="tituloController">{{titulo}}</h1>
			</div>

			<div id="message-red" class="hidden">
				<table border="0" width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td class="red-left">Erro. <a href="" id="error"></a></td>
						<td class="red-right"><a class="close-red"><img
								src="/r24af/images/table/icon_close_red.gif" alt="" /></a></td>
					</tr>
				</table>
			</div>

			<div id="message-green" class="hidden">
				<table border="0" width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td class="green-left">Sucesso. <a href="" id="success"></a></td>
						<td class="green-right"><a class="close-green"><img
								src="/r24af/images/table/icon_close_green.gif" alt="" /></a></td>
					</tr>
				</table>
			</div>

			<table border="0" width="100%" cellpadding="0" cellspacing="0"
				id="content-table">
				<tr>
					<th rowspan="3" class="sized"><img
						src="/r24af/images/shared/side_shadowleft.jpg" width="20"
						height="300" alt="" /></th>
					<th class="topleft"></th>
					<td id="tbl-border-top">&nbsp;</td>
					<th class="topright"></th>
					<th rowspan="3" class="sized"><img
						src="/r24af/images/shared/side_shadowright.jpg" width="20"
						height="300" alt="" /></th>
				</tr>
				<tr>
					<td id="tbl-border-left"></td>
					<td>
						<div id="content-table-inner">