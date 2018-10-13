
(function ($) {
    "use strict";
    
    /*==================================================================
    [ Focus input ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })
  
  
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    /* Cambio de formularios segun perfil de usuario*/
    $(document).on('click','.lateral',function(){
    	
    	let middleSrc = $('.middle > img').attr('src');
    	let clickedSrc = $(this).find('img').attr('src');
    	    
    	let clickedToLower = clickedSrc.toLowerCase();
    	
    	/* Intercambio de imagenes */
    	$('.middle > img').attr('src', clickedSrc);
    	$(this).find('img').attr('src', middleSrc);
    	
    	// ocultar todos los formularios
    	$('.form-content').removeClass('active');
    	
    	let formType = $('#form-action').hasClass('login') ? "/Login" : "/SignUp";
    	
    	
    	
    	// mostrar formulario correspondiente
    	if(clickedToLower.indexOf('student') >= 0){
    		$('.f-STUDENT').addClass('active');
    		$('#form-action').attr('action', formType + '/Student');
    	}else if(clickedToLower.indexOf('cel') >= 0){
    		$('.f-CEL').addClass('active');
    		$('#form-action').attr('action', formType + '/CEL');
    	}else if(clickedToLower.indexOf('family') >= 0){
    		$('.f-FAMILY').addClass('active');
    		$('#form-action').attr('action', formType + '/Family');
    	}
    });
    
    
    
})(jQuery);