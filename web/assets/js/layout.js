// Toggle dropdown
$('.user-info').click(function (e) {
    e.stopPropagation();
    $('.user-menu').slideToggle(200);
});

// Đóng menu nếu click ra ngoài
$(document).click(function (e) {
    if (!$(e.target).closest('.user').length) {
        $('.user-menu').slideUp(200);
    }
});

$(document).ready(function () {
    $('.menu-item').click(function () {
        $(this).find('a')[0].click();
    });
});

$(document).ready(function () {
    $('.login-btn').click(function () {
        $(this).find('a')[0].click();
    });
});