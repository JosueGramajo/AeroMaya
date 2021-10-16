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
                $("#modalBody2").html("Se a realizado su compra exitosamente. \n\nId de compra: " + data.toString());
                $("#succesModal").modal('show');
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