function checkPassword() {
	var password = $('#password').val();
	var pass_conf = $('#password_conf').val();

	if (password === pass_conf && password != "") {
		$('#btn_inscription').removeAttr("disabled");
	} else {
		$('#btn_inscription').attr("disabled", true);
	}
}