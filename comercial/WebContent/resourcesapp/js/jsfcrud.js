function handleSubmit(args, dialog) {
    var jqDialog = jQuery('#' + dialog);
    if (args.validationFailed) {
        jqDialog.effect('shake', {times: 3}, 100);
    } else {
        PF(dialog).hide();
    }
}





function showDisplay(idObj) {
	
	/*
	var obj = $(idObj);
	if ( $(idObj).is(":visible") ) {
		$(idObj).hide();
	} else {
		$(idObj).show();
	}*/
	
	var obj = document.getElementById(idObj);
	
	if (obj.style.display == 'block') {
		obj.style.display = 'none';
	} else {
		obj.style.display = 'block';
	}
	
}