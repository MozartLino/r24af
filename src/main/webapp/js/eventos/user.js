$(function() {

	$(".finalizar").click(function() {
		var isPut = $("#id").val() != undefined;
		
		if (validaObjeto()) {
			var user = criaObjeto();

			if (isPut) {
				$.extend(user, {_method : "PUT"});
			}
			
			$.ajax({
				url : "",
				type : "POST",
				data : user,
				success : function(data) {
					if (!isPut) {
						$("#message-red").hide();
						$("#message-green").show();
						limpaCampos();
					} else {
						window.location.href = "/r24af/pacientes";
					}
				}, 
				error : function () {
					$("#message-text").html("Login inválido");
					$("#message-red").show();
					$("#message-green").hide();
				}
			});
		}
	});
	
	$(".inp-form-error").live("keyup", function(e) {
		$(e.currentTarget).attr("class", "inp-form");
	});
	
});

function validaObjeto() {
	var retorno = true;
	var login = $("#login");
	var senha = $("#senha");
	var confirmar = $("#confirmar_senha");

	if (login.val() == "") {
		login.attr("class", "inp-form-error");
		retorno = false;
	}
	if(senha.val() == "" || senha.val() != confirmar.val()){
		senha.attr("class", "inp-form-error");
		confirmar.attr("class", "inp-form-error");
		retorno = false;
	}
	
	if (!retorno){
		$("#message-red").show();
	}

	return retorno;
}

function criaObjeto() {

	var user = {
			'user.login' : $("#login").val(),
			'user.password' : $("#senha").val(),
			'user.id' : $("#id").val()
	};

	return user;
}

function limpaCampos(){
	$("#login").val("");
	$("#senha").val("");
	$("#confirmar_senha").val("");
}