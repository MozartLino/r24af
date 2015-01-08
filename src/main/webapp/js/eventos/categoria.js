function categoriaController($scope, $window, $http) {
	
	var $ = jQuery;

	lista = function() {
		$http.get('/r24af/categorias/representation').success(function(data) {
			$scope.categorias = data;
		});
	}();

	$scope.enviaCategoria = function() {
		var url = "/r24af/categorias";
		
		if ($scope.categoria.id != undefined){
			$http.post(url, $scope.categoria).success(function(data) {
				$scope.categorias = data;
				window.location.href = "/r24af/categorias";
			});
		} else {
			$http.put(url, $scope.categoria).success(function(data) {
				$scope.categorias = data;
				window.location.href = "/r24af/categorias";
			});
		}
	};

	$scope.exclui = function(categoria) {
		var url = "/r24af/categorias/" + categoria.id;
		if(confirm("Deseja realmente Exluir a Categoria " + categoria.nome + "?")) {
			$http.delete(url).success(function(data) {
				var index = $scope.categorias.indexOf(categoria);
				$scope.categorias.splice(index, 1);
				$("#success").html("Excluído com sucesso");
				$("#message-red").hide();
				$("#message-green").show();
			}).error(function(){
				$("#error").html("Não foi possível remover a categoria" + categoria.nome+ ".");
				$("#message-red").show();
				$("#message-green").hide();
			});
		}
	};
	
	valida = function(){
		var retorno = true;

		if ($scope.categoria.nome == "") {
			$("#nome").attr("class", "inp-form-error");
			retorno = false;
		}

		return retorno;
	};
	
	$(".inp-form-error").live("keyup", function(e) {
		$(e.currentTarget).attr("class", "inp-form");
	});

}