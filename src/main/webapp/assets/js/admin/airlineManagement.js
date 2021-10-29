$(document).ready(function () {
    var currentId = "";

    var editionMode = false;

    $("#planeTable").DataTable();

    $("#addAirlineButton").click(function () {
        $("#nameInput").val("");
        $("#airlineSelect").val("");
        $("#capacitySelect").val("");

        editionMode = false;

        $("#airlineCreationModal").modal('show');
    });

    $(".deleteAirline").click(function () {
        currentId = $(this).data("id");
        $("#confirmationModal").modal('show');
    });

    $(".editAirline").click(function () {
        let id = $(this).data("id");
        currentId = id;

        $.ajax({
            url: "/getPlane",
            method: "GET",
            data: { id },
            success: function (data) {
                let obj = $.parseJSON(data);

                $("#nameInput").val(obj.name);
                $("#airlineSelect").val(obj.airline);
                $("#capacitySelect").val(obj.capacity);

                editionMode = true;

                $("#airlineCreationModal").modal('show');
            }
        });
    });

    $("#deleteUserConfirmation").click(function () {
        $.ajax({
            url: "/deleteUser",
            method: "DELETE",
            data: { id : currentId },
            success: function (data) {
                window.location.href = "/planeManagement";
            },
            error: function (xhr) {

            }
        });
    });

    $("#airlineCreationAccept").click(function () {
        let name = $("#nameInput").val();

        if (name == ""){
            $("#errorLabel").html("Favor complete todos los campos");
            $("#errorLabelContainer").show();
            return;
        }

        $("#creationOptions").hide();
        $("#loader").show();

        if (editionMode){
            $.ajax({
                url: "/updatePlane",
                method: "PUT",
                data: {id:currentId, name, airline, capacity},
                success: function (data) {
                    window.location.href = "/planeManagement";
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
                url: "/createPlane",
                method: "POST",
                data: {name, airline, capacity},
                success: function (data) {
                    window.location.href = "/planeManagement";
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