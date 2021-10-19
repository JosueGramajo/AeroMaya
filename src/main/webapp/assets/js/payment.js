$(document).ready(function () {
    $("#btnPay").click(function () {
        $.ajax({
            method: "POST",
            url: "/addTickets",
            data: {
                "id": id,
                "seats": JSON.stringify(list)
            },
            success: function (data) {
                $.redirect("/ticketSuccess", {
                    confirmation: data.toString()
                });
            },
            error: function (xhr) {
                $("#modalTitle").html("Error");
                $("#modalBody").html(xhr.responseText);
                $("#genericModal").modal('show');
            }
        });
    });

    $("#acceptSuccess").click(function () {
        window.location.href = "/dashboard";
    });
});