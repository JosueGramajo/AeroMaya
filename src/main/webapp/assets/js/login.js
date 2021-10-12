$(document).ready(function(){
    $("#loginButton").click(function () {
        $("#loader").modal('show');

        $.ajax({
            method: "POST",
            url: "/doLogin",
            data: {
                "email": $("#emailInput").val(),
                "password": $("#passwordInput").val()
            },
            success: function (data) {
                $("#loader").modal('hide');

                window.location.href = "/dashboard";
            },
            error: function (xhr) {
                $("#loader").modal('hide');

                $("#modalTitle").html("Error");
                $("#modalBody").html(xhr.responseText);
                $("#genericModal").modal('show');
            }
        });
    });

    $("#modalAcceptButton").click(function () {
        $("#genericModal").modal('hide');
    });
});