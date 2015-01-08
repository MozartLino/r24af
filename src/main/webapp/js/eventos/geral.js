$(function() {

	$('#toggle-all').click(function() {
		$('#toggle-all').toggleClass('toggle-checked');
		$('#mainform input[type=checkbox]').checkBox('toggle');
		return false;
	});

	$('.styledselect_form_1').selectbox({
		inputClass : "styledselect_form_1"
	});
	$('.styledselect_form_2').selectbox({
		inputClass : "styledselect_form_2"
	});

	$('.styledselect_pages').selectbox({
		inputClass : "styledselect_pages"
	});

	$("input.file_1").filestyle({
		image : "images/forms/upload_file.gif",
		imageheight : 29,
		imagewidth : 78,
		width : 300
	});

	$('a.info-tooltip ').tooltip({
		track : true,
		delay : 0,
		fixPNG : true,
		showURL : false,
		showBody : " - ",
		top : -35,
		left : 5
	});

	$(document).pngFix();

	$(".localDateTime").mask("99/99/9999 99:99");

	$("#logout").click(function(e) {
		$.ajax({
			url : "/r24af/deslogar",
			type : "GET",
			success : function(data) {
				window.location.href = "/r24af/login";
			}
		});
	});

	$(".editar_usuario").click(function() {
		window.location.href = "/r24af/usuario/editar";
	});

	$(".remover_usuario").click(function() {
		if (confirm("Deseja realmente Exluir esse uauário?")) {
			$.ajax({
				url : "/r24af/usuario",
				type : "POST",
				data : {
					"_method" : "DELETE"
				},
				success : function(data) {
					window.location.href = "/r24af/login";
				}
			});
		}
	});

});

function menuController($scope, $window, $http) {
	selecionaMenu = function() {
		var urlArray = $window.window.location.pathname.split("/");
		var extractUrl = urlArray[urlArray.length - 1];
		var extractUrlEdit = urlArray[urlArray.length - 2];

		if (extractUrl == "paciente" || extractUrlEdit == "paciente") {
			$scope.paciente = "sub_show";
			$scope.menuCadastro = "current";
			$scope.menuConsulta = "select";
			$scope.cadastro = "show";
		} else if (extractUrl == "atividade" || extractUrlEdit == "atividade") {
			$scope.atividade = "sub_show";
			$scope.menuCadastro = "current";
			$scope.menuConsulta = "select";
			$scope.cadastro = "show";
		} else if (extractUrl == "categoria" || extractUrlEdit == "categoria") {
			$scope.categoria = "sub_show";
			$scope.menuCadastro = "current";
			$scope.menuConsulta = "select";
			$scope.cadastro = "show";
		} else if (extractUrl == "usuario" || extractUrlEdit == "usuario") {
			$scope.usuario = "sub_show";
			$scope.menuCadastro = "current";
			$scope.menuConsulta = "select";
			$scope.cadastro = "show";
		} else if (extractUrl == "pacientes") {
			$scope.pacientes = "sub_show";
			$scope.menuCadastro = "select";
			$scope.menuConsulta = "current";
			$scope.consulta = "show";
		} else if (extractUrl == "atividades") {
			$scope.atividades = "sub_show";
			$scope.menuCadastro = "select";
			$scope.menuConsulta = "current";
			$scope.consulta = "show";
		} else if (extractUrl == "categorias") {
			$scope.categorias = "sub_show";
			$scope.menuCadastro = "select";
			$scope.menuConsulta = "current";
			$scope.consulta = "show";
		} else if (extractUrl == "atividadeFisica") {
			$scope.pacientes = "sub_show";
			$scope.menuCadastro = "select";
			$scope.menuConsulta = "current";
			$scope.consulta = "show";
		} else if (extractUrl == "atividadesFisica") {
			$scope.pacientes = "sub_show";
			$scope.menuCadastro = "select";
			$scope.menuConsulta = "current";
			$scope.consulta = "show";
		}
	}();

};

function tituloController($scope, $window, $http) {
	selecionaMenu = function() {
		var urlArray = $window.window.location.pathname.split("/");
		var extractUrl = urlArray[urlArray.length - 1];
		var extractUrlEdit = urlArray[urlArray.length - 2];

		if (extractUrl == "paciente" || extractUrlEdit == "paciente") {
			$scope.titulo = "Paciente";
		} else if (extractUrl == "atividade" || extractUrlEdit == "atividade") {
			$scope.titulo = "Atividade";
		} else if (extractUrl == "categoria" || extractUrlEdit == "categoria") {
			$scope.titulo = "Categoria";
		} else if (extractUrl == "usuario" || extractUrlEdit == "usuario") {
			$scope.titulo = "Usuário";
		} else if (extractUrl == "pacientes") {
			$scope.titulo = "Pacientes";
		} else if (extractUrl == "atividades") {
			$scope.titulo = "Atividades";
		} else if (extractUrl == "categorias") {
			$scope.titulo = "Categorias";
		} else if (extractUrl == "atividadeFisica") {
			$scope.titulo = "Atividade Física";
		}
	}();
};
