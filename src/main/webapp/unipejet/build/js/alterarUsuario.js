$(document).ready(function () {
    var number = Math.floor(Math.random() * 9999999999999999999);

    $('#nrCartaoMilhaSpan').html(number);

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
    $.listen('parsley:field:validate', function () {
        validateFront();
    });
    $('#formAlterarUsuario .btn').on('click', function () {
        $('#formAlterarUsuario').parsley().validate();
        validateFront();
    });
    var validateFront = function () {
        if (true === $('#formAlterarUsuario').parsley().isValid()) {
            $('.bs-callout-info').removeClass('hidden');
            $('.bs-callout-warning').addClass('hidden');
        } else {
            $('.bs-callout-info').addClass('hidden');
            $('.bs-callout-warning').removeClass('hidden');
        }
    };

});