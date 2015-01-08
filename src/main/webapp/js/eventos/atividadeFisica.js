$(function() {

	$(".finalizar").click(function() {
		if (validaObjeto()) {
			var atividadeFisica = criaObjeto();

			$.ajax({
				url : "",
				type : "POST",
				dataType : "json",
				data : atividadeFisica,
				success : function(data) {
					limpaObjeto();
					$("#message-red").hide();
					$("#message-green").show();
				},
				error : function() {
					$("#message-green").hide();
					$("#message-red").show();
				}
			});
		}
	});

	$(".atividades").live(
			"click",
			function(e) {
				$("#atividade_input").attr("data-id",
						$(e.currentTarget).attr("data-id"));
				$("#atividade_input").val(
						$(e.currentTarget).attr("data-text").substr(0, 28)
								+ "...");
				$.modal.close();
			});

	$("#atividade_busca").keyup(
			function() {

				if ($("#atividade_busca").val().length > 4) {
					var url = "/r24af/atividades/"
							+ $("#atividade_busca").val();
					if ($("#select_categoria").val() != "") {
						url = "/r24af/atividades/"
								+ $("#atividade_busca").val() + "/categoria/"
								+ $("#select_categoria").val();
					}

					$.ajax({
						url : url,
						type : "GET",
						success : function(data) {
							$(".atividades").remove();
							$.each(data, function() {
								console.log(this);
								var $tr = $("<tr/>", {
									"class" : "atividades",
									"data-id" : this.id,
									"data-text" : this.nome
								});
								$("<td/>").append(this.nome).appendTo($tr);
								$("<td/>").append(this.MET).appendTo($tr);
								$("<td/>").append(
										this.repouso == true ? "Sim" : "Não")
										.appendTo($tr);
								$("<td/>").append(this.categoria.nome)
										.appendTo($tr);

								$("#modal-table").append($tr);

							});
						}
					});
				}
			});

	$("#select_categoria").change(
			function() {

				if ($("#select_categoria").val() != "") {
					url = "/r24af/atividades/categoria/"
							+ $("#select_categoria").val();
					$.ajax({
						url : url,
						type : "GET",
						success : function(data) {
							$(".atividades").remove();
							$.each(data, function() {
								var $tr = $("<tr/>", {
									class : "atividades"
								});
								$("<td/>").append(this.nome).appendTo($tr);
								$("<td/>").append(this.MET).appendTo($tr);
								$("<td/>").append(
										this.repouso == true ? "Sim" : "Não")
										.appendTo($tr);
								$("<td/>").append(this.categoria.nome)
										.appendTo($tr);

								$("#modal-table").append($tr);

							});
						}
					});
				}
			});

	$(".editar")
			.click(
					function() {
						if (validaObjeto()) {
							var atividadeFisica = criaObjeto();
							$
									.ajax({
										url : "atividadeFisica",
										type : "POST",
										data : $.extend({
											_method : "PUT"
										}, atividadeFisica, {
											"atividadeFisica.paciente.id" : 1
										}),
										success : function(data) {
											window.location.href = "/r24af/atividadesRealizada";
										}
									});
						}
					});

	$(".remover").click(
			function(e) {
				if (confirm("Deseja realmente Exluir essa categoria?")) {
					$.ajax({
						url : "/r24af/paciente/" + $("#pacienteId").val()
								+ "/atividadeFisica/"
								+ $(e.currentTarget).attr("data-id"),
						type : "POST",
						data : {
							"_method" : "DELETE"
						},
						success : function(data) {
							$(e.currentTarget).parent().parent().remove();
							$("#message-red").hide();
							$("#message-green").show();
						},
						error : function(data) {
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

	$('#atividade_input').click(function(e) {
		$('#basic-modal-content').modal();

		return false;
	});

});

function validaObjeto() {
	var retorno = true;

	if ($("#atividade_input").val() == "Atividade") {
		$("#atividade_input").attr("class", "inp-form-error");
		retorno = false;
	}
	if ($("#diaDaSemana_input").val() == "Semana") {
		$("#diaDaSemana_input").attr("class", "inp-form-error");
		retorno = false;
	}
	if ($("#dia_input").val() == "Dia") {
		$("#dia_input").attr("class", "inp-form-error");
		retorno = false;
	}
	if (!verificaHora()) {
		$("#tempoFinal").html("Tempo Final :");
		$("#tempoFinal").attr("style", "color : red");

		$("#tempoInicial").html("Tempo Inicial :");
		$("#tempoInicial").attr("style", "color : red");

		$("#error_message").html(
				"Hora Final não pode ser menor do que a Hora Inicial");

		$("#message-green").hide();
		$("#message-red").show();

		retorno = false;
	}

	return retorno;
}

function criaObjeto() {
	var atividadeFisica = {
		'atividadeFisica.id' : $("#id").val(),
		'atividadeFisica.atividade.id' : $("#atividade_input").attr("data-id"),
		'atividadeFisica.descricao' : $("#descricao").val(),
		'atividadeFisica.diaDaSemana' : $("#diaDaSemana").val(),
		'atividadeFisica.dia' : $("#dia").val(),
		'atividadeFisica.horaInicial' : $("#hora_inicial").val(),
		'atividadeFisica.horaFinal' : $("#hora_final").val(),
		'atividadeFisica.minutoInicial' : $("#minuto_inicial").val(),
		'atividadeFisica.minutoFinal' : $("#minuto_final").val()
	};

	return atividadeFisica;

}

function limpaObjeto() {
	$("#id").val("");
	$("#descricao").val("");
	$("#atividade_input").val("");
	$("#diaDaSemana").val("Semana");
	$("#dia_input").val("Dia");
	$("#hora_inicial").val("");
	$("#hora_final").val("");
	$("#minuto_inicial").val("");
	$("#minuto_final").val("");
}

function verificaHora() {

	var hora = $("#hora_final").val() - $("#hora_inicial").val();
	var minuto = $("#minuto_final").val() - $("#minuto_inicial").val();

	if (hora < 0) {
		return false;
	} else if (hora == 0 && minuto < 0) {
		return false;
	} else {
		return true;
	}
}