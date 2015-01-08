$(function() {

	$(".finalizar").click(function() {
		if (validaObjeto()) {
			var atividade = criaObjeto();
			$.ajax({
				url : "",
				type : "POST",
				data : atividade,
				success : function(data) {
					window.location.href = "/r24af/atividades";
				}
			});
		}
	});
	
	$(".editar").click(function() {
		if (validaObjeto()) {
			var atividade = criaObjeto();
			$.ajax({
				url : "../atividade",
				type : "POST",
				data : $.extend({_method : "PUT"}, atividade),
				success : function(data) {
					window.location.href = "/r24af/atividades";
				}
			});
		}
	});
	
	$(".remover").click(function(e){
		if(confirm("Deseja realmente Exluir essa Atividade?")) {
			$.ajax({
				url : "atividade",
				type : "POST",
				data : {"atividade.id" : $(e.currentTarget).attr("data-id"), "_method" : "DELETE"},
				success : function(data) {
					$(e.currentTarget).parent().parent().remove();
					$("#success").html("Excluído com sucesso");
					$("#message-red").hide();
					$("#message-green").show();
				},
				error : function(data) {
					$("#error").html("Não foi possível remover a atividade.");
					$("#message-red").show();
					$("#message-green").hide();
				}
			});
		}
	});
	
	$(".inp-form-error").live("keyup", function(e) {
		$(e.currentTarget).attr("class", "inp-form");
	});
	
	$(".inp-form-error").live("change", function(e) {
		$(e.currentTarget).attr("class", "inp-form");
	});

});

function validaObjeto() {
	var retorno = true;

	if ($("#nome").val() == "") {
		$("#nome").attr("class", "inp-form-error");
		retorno = false;
	}
	if ($("#MET").val() == "") {
		$("#MET").attr("class", "inp-form-error");
		retorno = false;
	}
	if ($("#categoria_input").val() == "Selecione...") {
		$("#categoria_input").attr("class", "inp-form-error");
		retorno = false;
	}

	return retorno;
}

function criaObjeto() {

	var atividade = {
			'atividade.id' : $("#id").val(),
			'atividade.nome' : $("#nome").val(),
			'atividade.MET' : $("#MET").val(),
			'atividade.categoria.id' : $("#categoria").val(),
			'atividade.repouso' : $("#repouso").val()
	};

	return atividade;

}