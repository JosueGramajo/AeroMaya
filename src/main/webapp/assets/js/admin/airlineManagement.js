$(document).ready(function () {
    var currentId = "";

    var editionMode = false;

    $("#planeTable").DataTable();

    $("#addAirlineButton").click(function () {
        $("#nameInput").val("");
        $("#statusContainer").hide();

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
            url: "/getAirline",
            method: "GET",
            data: { id },
            success: function (data) {
                let obj = $.parseJSON(data);

                $("#nameInput").val(obj.name);
                $("#statusSwitch").prop('checked', obj.status);
                $("#statusContainer").show();

                editionMode = true;

                $("#airlineCreationModal").modal('show');
            }
        });
    });

    $("#deleteAirlineConfirmation").click(function () {
        $.ajax({
            url: "/deleteAirline",
            method: "DELETE",
            data: { id : currentId },
            success: function (data) {
                window.location.href = "/airlineManagement";
            },
            error: function (xhr) {
                $("#errorLabel-Confirmation").html(xhr.responseText);
                $("#errorLabelContainer-Confirmation").show();
            }
        });
    });

    $("#airlineCreationAccept").click(function () {
        let name = $("#nameInput").val();
        let status = $("#statusSwitch").prop('checked');

        if (name == ""){
            $("#errorLabel").html("Favor complete todos los campos");
            $("#errorLabelContainer").show();
            return;
        }

        $("#creationOptions").hide();
        $("#loader").show();

        if (editionMode){
            $.ajax({
                url: "/updateAirline",
                method: "PUT",
                data: {id:currentId, name, status },
                success: function (data) {
                    window.location.href = "/airlineManagement";
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
                url: "/createAirline",
                method: "POST",
                data: { name },
                success: function (data) {
                    window.location.href = "/airlineManagement";
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