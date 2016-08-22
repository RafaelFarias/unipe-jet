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

});