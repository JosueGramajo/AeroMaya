$(document).ready(function () {
    $("#registerButton").click(function () {
        $("#register-button").hide();
        $("#loader").show();

        $.ajax({
            url: "/doRegister",
            method: "POST",
            data: {
                "name" : $("#username").val(),
                "email" : $("#email").val(),
                "password" : $("#password").val()
            },
            success : function (data) {
                $("#register-button").show();
                $("#loader").hide();

                $("#modalTitle").html("Exito")
                $("#modalBody").html("Usuario registrado exitosamente");
                $("#genericModal").modal('show');
            },
            error: function (xhr) {
                $("#register-button").show();
                $("#loader").hide();

                $("#modalTitle").html("Error")
                $("#modalBody").html(xhr.responseText);
                $("#genericModal").modal('show');
            }
        });
    });

    $("#modalAcceptButton").click(function () {
        window.location.href = "/login"
    });
});