function switchUrlFieldState(noLinkVal) {
	if (noLinkVal) {
		$('.url_input').attr("disabled", true);
	} else {
		$('.url_input').removeAttr("disabled");
	}
}
