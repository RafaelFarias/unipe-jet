$(document).ready(function () {
    var number = Math.floor(Math.random() * 9999999999999999999);

    $('#nrCartaoMilhaSpan').html(number);
    $('#nrCartaoMilha').val(number);

    $('[name="tipoDocumento"]').on('change', function () {
        var value = $(this).val();

        if (value == 'CPF') {
            $('#divCpf').show('slow');
            $('#divRg').hide('slow');
        } else {
            $('#divCpf').hide('slow');
            $('#divRg').show('slow');
        }
    });


    // fomulario do login
    $.listen('parsley:field:validate', function() {
        validateFront();
    });
    $('#formLogin .btn').on('click', function() {
        $('#formLogin').parsley().validate();
        validateFront();
    });
    var validateFront = function() {
        if (true === $('#formLogin').parsley().isValid()) {
            $('.bs-callout-info').removeClass('hidden');
            $('.bs-callout-warning').addClass('hidden');
        } else {
            $('.bs-callout-info').addClass('hidden');
            $('.bs-callout-warning').removeClass('hidden');
        }
    };


    //formulario do usuario
    $.listen('parsley:field:validate', function() {
        validateFront();
    });
    $('#formCriarConta .btn').on('click', function() {
        $('#formCriarConta').parsley().validate();
        validateFront();
    });
    var validateFront = function() {
        if (true === $('#formCriarConta').parsley().isValid()) {
            $('.bs-callout-info').removeClass('hidden');
            $('.bs-callout-warning').addClass('hidden');
        } else {
            $('.bs-callout-info').addClass('hidden');
            $('.bs-callout-warning').removeClass('hidden');
        }
    };

});