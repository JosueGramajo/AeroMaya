$(document).ready(function () {
    $(".userBuys").click(function () {
        let id = $(this).data('id');
        let email = $(this).data('email');

        $.redirect('/ticketReportForUser',{
            id, email
        });
    });
});