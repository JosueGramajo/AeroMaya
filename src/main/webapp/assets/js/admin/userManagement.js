$(document).ready(function () {
    var currentId = "";

    var editionMode = false;

    $("#userTable").DataTable();

    $("#addUserButton").click(function () {
        $("#nameInput").val("");
        $("#emailInput").val("");
        $("#passwordInput").val("");
        $("#rolSelect").val("");

        editionMode = false;

        $("#userCreationModal").modal('show');
    });

    $(".deleteUser").click(function () {
        currentId = $(this).data("id");
        $("#confirmationModal").modal('show');
    });

    $(".editUser").click(function () {
        let id = $(this).data("id");
        currentId = id;

        $.ajax({
            url: "/getUser",
            method: "POST",
            data: { id },
            success: function (data) {
                let obj = $.parseJSON(data);

                $("#nameInput").val(obj.name);
                $("#emailInput").val(obj.email);
                $("#passwordInput").val(obj.password);
                $("#rolSelect").val(obj.role);

                editionMode = true;

                $("#userCreationModal").modal('show');
            }
        });
    });

    $("#deleteUserConfirmation").click(function () {
        $.ajax({
            url: "/deleteUser",
            method: "DELETE",
            data: { id : currentId },
            success: function (data) {
                window.location.href = "/userManagement";
            },
            error: function (xhr) {

            }
        });
    });

    $("#userCreationAccept").click(function () {
        let name = $("#nameInput").val();
        let email = $("#emailInput").val();
        let password = $("#passwordInput").val();
        let role = $("#rolSelect").val();

        if (name === "" || email === "" || password === ""){
            $("#errorLabel").html("Favor complete todos los campos");
            $("#errorLabelContainer").show();
            return;
        }

        $("#creationOptions").hide();
        $("#loader").show();

        if (editionMode){
            $.ajax({
                url: "/updateUser",
                method: "PUT",
                data: {id:currentId, name, email, password, role},
                success: function (data) {
                    window.location.href = "/userManagement";
                },
                error: function (xhr) {
                    $("#creationOptions").show();
                    $("#loader").hide();

                    $("#errorLabel").html(xhr.responseText);
                    $("#errorLabelContainer").show();
                }
            });
        }else{
            $.ajax({
                url: "/createUser",
                method: "POST",
                data: {name, email, password, role},
                success: function (data) {
                    window.location.href = "/userManagement";
                },
                error: function (xhr) {
                    $("#creationOptions").show();
                    $("#loader").hide();

                    $("#errorLabel").html(xhr.responseText);
                    $("#errorLabelContainer").show();
                }
            });
        }
    });
});