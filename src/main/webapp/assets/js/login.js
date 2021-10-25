$(document).ready(function(){
    $("#loginButton").click(function () {
        $("#loader").show();
        $("#login-button").hide();

        $.ajax({
            method: "POST",
            url: "/loginRedirect",
            data: {
                "email": $("#emailInput").val(),
                "password": $("#passwordInput").val()
            },
            success: function (data) {
                $("#loader").hide();
                $("#login-button").show();

                window.location.href = data;
            },
            error: function (xhr) {
                $("#loader").hide();
                $("#login-button").show();

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