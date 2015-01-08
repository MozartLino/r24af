function listaPacientesController($scope, $window, $http) {

	var $ = jQuery;
	
	lista = function() {
		$http.get('/r24af/pacientes/representation').success(function(data) {
			var pacientes = [];
			$.each(data, function(){
				pacientes.push($window.trataCasasDecimais(this));
			});
			$scope.pacientes = pacientes;
		});
	}();
	
	$scope.remover = function(paciente) {
		var url = "/r24af/pacientes/" + paciente.id;
		if(confirm("Deseja realmente exluir o paciente " + paciente.nome + "?")) {
			$http.delete(url).success(function(data) {
				var index = $scope.pacientes.indexOf(paciente);
				$scope.pacientes.splice(index, 1);
				$("#success").html("Excluído com sucesso");
				$("#message-red").hide();
				$("#message-green").show();
			}).error(function(){
				$("#error").html("Não foi possível remover o paciente " + paciente.nome+ ".");
				$("#message-red").show();
				$("#message-green").hide();
			});
		}
	};

	$scope.redireciona = function(paciente){
		var url = "/r24af/paciente/"
			+ paciente.id + "/atividadesFisica";
		
		$window.location.href = url;
	}

	$scope.editarPaciente = function(paciente) {
		$window.location.href = "/r24af/paciente/" + paciente.id + "/atividadesFisica";
	};

	$scope.buscaPacientesComAtividadePeloDiaCadastrado = function() {
		var url = "/r24af/pacientes/representation/dia/" + $scope.dia;
		$http.get(url).success(function(data) {
			var pacientes = [];
			$.each(data, function(){
				pacientes.push($window.trataCasasDecimais(this));
			});
			$scope.pacientes = pacientes;
		});
	};

	$scope.buscaPacientesComAtividadesPeloDiaDaSemanaCadastrada = function() {
		var url = "/r24af/pacientes/representation/diaDaSemana/" + $scope.diaDaSemana;
		$http.get(url).success(function(data) {
			var pacientes = [];
			$.each(data, function(){
				pacientes.push($window.trataCasasDecimais(this));
			});
			$scope.pacientes = pacientes;
		});
	};

	$scope.buscaPacientesSemAtividadesSedentaria = function() {
		var url = "pacientes/representation";

		if ($scope.sedentario == "SEM"){
			url = "/r24af/pacientes/representation/semAtividadeSedentaria";
		}
		
		$http.get(url).success(function(data) {
			var pacientes = [];
			$.each(data, function(){
				pacientes.push($window.trataCasasDecimais(this));
			});
			$scope.pacientes = pacientes;
		});
	};
	$scope.alteraPorcentagem = function() {
		$.each($scope.pacientes, function() {
			if ($scope.porcento == "com"){
				this.caloriaTotal = (this.caloriaTarget * 1.1).toFixed(2);
			} else {
				this.caloriaTotal = this.caloriaTarget;
			} 
		});
	};
	
	$scope.alteraEquacaoBasal = function() {
		$.each($scope.pacientes, function() {
			if ($scope.basal == "harris"){
				this.basal = this.basalHarrisBenedict;
			} else if($scope.basal == "fao"){
				this.basal = this.basalFAO;
			} else {
				this.basal = "";
			}
		});
	};
	
	$scope.geradorExcel = function() {
		var url = "/r24af/gerador";
		
		var string = null;
		var data = {};
		 angular.forEach($scope.pacientes, function(paciente, key) {
			string = '{"pacientes[' + key + '].id": "' + paciente.id +
						'", "pacientes[' + key + '].nome": "' + paciente.nome +
						'", "pacientes[' + key + '].caloriaTotal": "' + paciente.caloriaTotal +
						'", "pacientes[' + key + '].caloriaTarget": "' + paciente.caloriaTarget +
						'", "pacientes[' + key + '].caloriaLeve": "' + paciente.caloriaLeve +
						'", "pacientes[' + key + '].caloriaModerado": "' + paciente.caloriaModerado +
						'", "pacientes[' + key + '].caloriaVigoroso": "' + paciente.caloriaVigoroso +
						'", "pacientes[' + key + '].tempoTotal": "' + paciente.tempoTotal +
						'", "pacientes[' + key + '].tempoLeve": "' + paciente.tempoLeve +
						'", "pacientes[' + key + '].tempoModerado": "' + paciente.tempoModerado +
						'", "pacientes[' + key + '].tempoVigoroso": "' + paciente.tempoVigoroso +
						'", "pacientes[' + key + '].peso": "' + paciente.peso +
						'", "pacientes[' + key + '].altura": "' + paciente.altura +
						'", "pacientes[' + key + '].basalHarrisBenedict": "' + paciente.basalHarrisBenedict +
						'", "pacientes[' + key + '].basalFAO": "' + paciente.basalFAO +
						'", "pacientes[' + key + '].basal": "' + paciente.basal +
						'", "pacientes[' + key + '].idade": "' + paciente.idade + '"}';
			console.log(string);
			$.extend(data, JSON.parse(string));
		 });
		
		 $.ajax({
				url : url,
				type : "POST",
				data : data,
				success : function(data) {
					$("#message-red").hide();
					$("#message-green").show();
					$("#message-red2").hide();
					$("#message-green2").show();
				},
				error : function(){
					$("#message-green2").hide();
					$("#message-red2").show();
					$("#message-green").hide();
					$("#message-red").show();
				}
			});
	};
		
}

function formPacientesController($scope, $window, $http) {

	init = function() {
		var urlArray = $window.window.location.pathname.split("/");
		var extractUrl = urlArray[urlArray.length -1];
		if(!(extractUrl == "paciente")){
			$http.get('/r24af/pacientes/'+ extractUrl +"/representation").success(function(data) {
				$scope.paciente = data;
			});
		};
	}();

	$scope.salvaPaciente = function() {
		
		if (validaObjeto()) {
			var paciente = angular.toJson({
					"paciente" : $scope.paciente,
				});
			var url = "/r24af/pacientes";
			if($scope.paciente.id == undefined){
				$http.post(url, paciente).success(function(data) {
					$scope.pacientes = data;
					$window.window.location.href = "/r24af/pacientes";
				}).
				error(function(data, status, headers, config) {
					console.log(status);
				});
			} else {
				$http.put(url, paciente).success(function(data) {
					$window.window.location.href = "/r24af/pacientes";
				}).
				error(function(data, status, headers, config) {
					console.log(data, status, config);
				});
			};
		};
	};
	
	$scope.fumaAtualmenteChange = function() {
		if($scope.paciente.pessoa.fumaAtual == "SIM"){
			$.each($(".fuma"), function(){
				$(this).show();
			});
			$(".parouDeFumar").hide();
			$(".fumava").hide();
		} else {
			$.each($(".fuma"), function(){
				$(this).hide();
			});
			$(".parouDeFumar").show();
			if ($scope.paciente.parouDeFumar==1){
				$(".fumava").show();
			}
		}
	};
	
	$scope.alcoolismoChange = function() {
		if($scope.paciente.pessoa.alcoolismo == "SIM"){
			$(".consomeAlcool").show();
		} else {
			$(".consomeAlcool").hide();
		}
	};
	
	$scope.fumavaChange = function() {
		if($scope.paciente.pessoa.parouDeFumar == "SIM"){
			$.each($(".fumava"), function(){
				$(this).show();
			});
		} else {
			$.each($(".fumava"), function(){
				$(this).hide();
			});
		}
	};
	
	validaObjeto = function() {
		
		var retorno = true;

		if ($scope.paciente == undefined){
			$("#nome").attr("class", "inp-form-error");
			$("#email").attr("class", "inp-form-error");
			$("#sexo").attr("class", "inp-form-error-select ng-pristine ng-valid");
			$("#altura").attr("class", "inp-form-error");
			$("#peso").attr("class", "inp-form-error");
			$("#dataNascimento").attr("class", "inp-form-error");
		} else {
			if ($scope.paciente.pessoa.nome == undefined || $scope.paciente.pessoa.nome == "") {
				$("#nome").attr("class", "inp-form-error");
				retorno = false;
			}
			if ( $scope.paciente.pessoa.email == undefined || $scope.paciente.pessoa.email == "") {
				$("#email").attr("class", "inp-form-error");
				retorno = false;
			}
			if ($scope.paciente.pessoa.sexo == undefined || $scope.paciente.pessoa.sexo == "Selecione...") {
				$("#sexo").attr("class", "inp-form-error-select ng-pristine ng-valid");
				retorno = false;
			}
			if ($scope.paciente.pessoa.altura == undefined || $scope.paciente.pessoa.altura == "") {
				$("#altura").attr("class", "inp-form-error");
				retorno = false;
			}
			if ($scope.paciente.pessoa.peso == undefined || $scope.paciente.pessoa.peso == "") {
				$("#peso").attr("class", "inp-form-error");
				retorno = false;
			}
			if ($scope.paciente.pessoa.dataNascimento == undefined || $scope.paciente.pessoa.dataNascimento == "") {
				$("#dataNascimento").attr("class", "inp-form-error");
				retorno = false;
			}
		}
		return retorno;
	};
}

$(function() {
	$(".inp-form-error").live("keyup", function(e) {
		$(e.currentTarget).attr("class", "inp-form");
	});
	
	$(".inp-form-error-select").live("change", function(e) {
		console.log("sdjklfhasdklf");
		$(e.currentTarget).attr("class", "inp-form");
	});
});

function trataCasasDecimais(paciente){
	paciente.caloriaTotal = paciente.caloriaTotal.toFixed(2);
	paciente.caloriaTarget = paciente.caloriaTotal;
	paciente.caloriaLeve = paciente.caloriaLeve.toFixed(2);
	paciente.caloriaModerado = paciente.caloriaModerado.toFixed(2);
	paciente.caloriaVigoroso = paciente.caloriaVigoroso.toFixed(2);
	paciente.peso = paciente.peso.toFixed(1);
	paciente.altura = paciente.altura.toFixed(1);
	paciente.basalHarrisBenedict = paciente.basalHarrisBenedict.toFixed(2);
	paciente.basalFAO = paciente.basalFAO.toFixed(2);
	
	return paciente;
};