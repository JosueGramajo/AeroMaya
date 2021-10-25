$(document).ready(function () {
    $("#modalLoginAcceptButton").click(function () {
        $("#login-accept-modal-footer").hide()
        $("#user-message").hide();

        $("#login-form").show();
        $("#login-modal-footer").show();
    });

    $("#modalLoginButton").click(function () {
        $("#login-modal-footer").hide();
        $("#loader").show();

        $.ajax({
            method: "POST",
            url: "/doLogin",
            data: {
                "email": $("#modalEmailInput").val(),
                "password": $("#modalPasswordInput").val()
            },
            success: function (data) {
                $("#loader").hide();
                $("#login-modal-footer").show();

                $("#login-general-div").hide();

                $("#loginModal").modal('hide');

                loggedIn = true;
            },
            error: function (xhr) {
                $("#loader").hide();
                $("#login-modal-footer").show();

                $("#errorLabel").html(xhr.responseText);
                $("#errorLabelContainer").show();
            }
        });
    });

    $("#modalAcceptButton").click(function () {
        $("#genericModal").modal('hide');
    });
});