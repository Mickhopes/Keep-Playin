function checkPassword() {
	var password = $('#password').val();
	var pass_conf = $('#password_conf').val();

	if (password === pass_conf && password != "") {
		$('#btn_inscription').removeAttr("disabled");
	} else {
		$('#btn_inscription').attr("disabled", true);
	}
}

function checkPasswordModif() {
	var password = $('#password').val();
	var pass_conf = $('#password_conf').val();

	if (password === pass_conf && password != "") {
		$('#btn_modif_profil').removeAttr("disabled");
		$('#confirmer').html('<span class="glyphicon glyphicon-ok green" aria-hidden="true" style="padding-top:5px">');
	} else {
		$('#btn_modif_profil').attr("disabled", true);
		$('#confirmer').html('<span class="glyphicon glyphicon-remove red" aria-hidden="true" style="padding-top:5px">');
	}
}