$(document).ready(function () {
    $(".select-buy").click(function () {
        let id = $(this).data("id");

        $.redirect('/ticketSuccess', {
            "confirmation": id
        });
    });
});