$(document).click(function () {
    $("#cancellation-button").click(function () {
        $("#confirmationModal").modal('show');
    });

    $("#cancelConfirmation").click(function () {
        $.ajax({
            url: "/cancelTicket",
            method: "POST",
            data: { "id": confirmation },
            success: function () {
                $.redirect('/ticketCancellationSuccess', {
                    id: confirmation
                });
            },
            error: function () {

            }
        });
    });
});