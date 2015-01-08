<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>R24AF</title>
<link rel="stylesheet" href="css/screen.css" type="text/css"
	media="screen" title="default" />
<script src="js/jquery/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery/custom_jquery.js" type="text/javascript"></script>
<script src="js/jquery/jquery.pngFix.pack.js" type="text/javascript"></script>
</head>

<body id="login-bg">
	<div class="bgLogin"></div>
	<div id="login-holder">
		<div id="logo-login">
			<a href="index.html"><img /></a>
		</div>
		<div class="clear"></div>
		<div id="loginbox">
			<div id="login-inner">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th>Login</th>
						<td><input type="text" class="login-inp" id="login" /></td>
					</tr>
					<tr>
						<th>Senha</th>
						<td><input type="password" value="" onfocus="this.value=''"
							class="login-inp" id="senha" /></td>
					</tr>
					<tr>
						<th></th>
						<td valign="top"><input type="checkbox" class="checkbox-size"
							id="login-check" /><label for="login-check">Lembrar - me</label></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="button" class="submit-login" id="logar" /></td>
					</tr>
				</table>
			</div>
			<div style="margin-left : 70px; color: red;" id="error"></div>
			<div class="clear"></div>
			<a href="" class="forgot-pwd">Esqueceu sua senha?</a>
		</div>
		<div id="forgotbox">
			<div id="forgotbox-text">Please send us your email and we'll
				reset your password.</div>
			<div id="forgot-inner">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th>Email address:</th>
						<td><input type="text" value="" class="login-inp" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="button" class="submit-login" /></td>
					</tr>
				</table>
			</div>
			<div class="clear"></div>
			<a href="" class="back-login">Back to login</a>
		</div>
	</div>
<script type="text/javascript">
$(document).ready(function() {
	$(document).pngFix();
$("#logar").click(function() {
		
		user = {
				"user.login" : $("#login").val(), 
				"user.password" : $("#senha").val()
		};
		
		$.ajax({
			url : "/r24af/logar",
			type : "POST",
			data : user,
			success : function(data) {
				window.location.href = "/r24af/pacientes";
			}, 
			error : function(data){
				$("#error").html("usuário ou senha inválido!");
			}
		});
	});
});
</script>
</body>
</html>