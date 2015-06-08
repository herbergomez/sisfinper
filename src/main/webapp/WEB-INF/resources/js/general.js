/**
 * 
 */
$(document).ready(function() 
{
	/*
	 * Formato general 
	 * para fechas que requieren
	 * horas
	 * */
	$('.datetimepicker').datetimepicker({
		dateFormat: "dd-mm-yy",
	    timeFormat: "HH:mm:ss",
	    	currentText: "Ahora",
	    	closeText: "Listo",
	    	timeText: 'Hora',
            hourText: 'Horas',
            minuteText: 'Minutos',
            secondText: 'Segundos',
            millisecText: 'Milisegundos',
	    	dayNamesMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
	    	monthNames: ["Enero", "Febrero", "Marzo", "Abril", "Mayo","Junio", "Julio", "Agosto", "Septiembre","Octubre", "Noviembre", "Diciembre"],
	    	monthNamesShort: ["Ene", "Feb", "Mar", "Abr","May", "Jun", "Jul", "Ago","Sep", "Oct", "Nov", "Dic"]
	});	
	/*
	 * Formato general 
	 * fechas
	 * */
	$('.datepicker').datepicker({
		closeText: 'Cerrar',
        prevText: 'Ant',
        nextText: 'Sig',
        currentText: 'Hoy',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
        dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
        dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sa'],
        weekHeader: 'Sm',
        dateFormat: 'dd-mm-yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''
	});	
	
	$("#formCambioClave").validate({
	errorElement: "span",
	rules: 
	{
	   oldPass:
	   {
	       required:true,
	       maxlength: 20,
	       minlength: 3
	   },
	   newPass:
	   {
		   required:true,
	       maxlength: 20,
	       minlength: 3 
	   },
	   confirmNewPass:
	   {
		   required:true,
		   equalTo: "#newPass"
	   }
	  },
	highlight: function(element) {
		$(element).closest('.control-group')
		.removeClass('has-success').addClass('has-error');
	},
	success: function(element) {
		element.addClass('help-inline')
		.closest('.control-group')
		.removeClass('has-error').addClass('has-success');
	},
	submitHandler : function(form)
	{
		var oldPass = $("#oldPass").val();
		var newPass = $("#newPass").val();
		
	}
	 
});
	
	
});
