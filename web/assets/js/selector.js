$(document).ready(function () {
    $('#btn1').click(function () {
        $('#title').text('Bạn vừa chọn phần tử theo ID!');
    });

    $('#btn2').click(function () {
        $('.desc').toggleClass('highlight');
    });

    $('#btn3').click(function () {
        $('p').append(' ✅');
    });
});