$(document).ready(function () {
    var number = Math.floor(Math.random() * 9999999999999999999);

    $('#nrCartaoMilhaSpan').html(number);
    $('#nrCartaoMilha').val(number);

    $('#deleteUser').on('click', function () {

        if (confirm('Você tem certeza que deseja excluir?')) {
            alert('excluido');
        } else {
            alert('cancelado');
        }
    });

});