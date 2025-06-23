$('#btn').click(function () {
    alert('clicked button !!!');
});

// Toggle dropdown
$('.user-avatar').click(function (e) {
    e.stopPropagation();
    $('.user-menu').slideToggle(200);
});

// Đóng menu nếu click ra ngoài
$(document).click(function (e) {
    if (!$(e.target).closest('.user').length) {
        $('.user-menu').slideUp(200);
    }
});
