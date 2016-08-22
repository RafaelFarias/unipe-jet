$(document).ready(function () {


    // fomulario do login
    $.listen('parsley:field:validate', function () {
        validateFront();
    });
    $('#formLogin .btn').on('click', function () {
        $('#formLogin').parsley().validate();
        validateFront();
    });
    var validateFront = function () {
        if (true === $('#formLogin').parsley().isValid()) {
            $('.bs-callout-info').removeClass('hidden');
            $('.bs-callout-warning').addClass('hidden');
        } else {
            $('.bs-callout-info').addClass('hidden');
            $('.bs-callout-warning').removeClass('hidden');
        }
    };


    //formulario do usuario
    $.listen('parsley:field:validate', function () {
        validateFront();
    });
    $('#formCriarConta .btn').on('click', function () {
        $('#formCriarConta').parsley().validate();
        validateFront();
    });
    var validateFront = function () {
        if (true === $('#formCriarConta').parsley().isValid()) {
            $('.bs-callout-info').removeClass('hidden');
            $('.bs-callout-warning').addClass('hidden');
        } else {
            $('.bs-callout-info').addClass('hidden');
            $('.bs-callout-warning').removeClass('hidden');
        }
    };

});