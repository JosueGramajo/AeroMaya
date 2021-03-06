$(document).ready(function () {
    var currentId = "";

    var editionMode = false;

    $("#planeTable").DataTable();

    $("#addPlaneButton").click(function () {
        $("#nameInput").val("");
        $("#airlineSelect").val("");
        $("#capacitySelect").val("");

        editionMode = false;

        $("#planeCreationModal").modal('show');
    });

    $(".deletePlane").click(function () {
        currentId = $(this).data("id");
        $("#confirmationModal").modal('show');
    });

    $(".editPlane").click(function () {
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

                $("#planeCreationModal").modal('show');
            }
        });
    });

    $("#deletePlaneConfirmation").click(function () {
        $.ajax({
            url: "/deletePlane",
            method: "DELETE",
            data: { id : currentId },
            success: function (data) {
                window.location.href = "/planeManagement";
            },
            error: function (xhr) {
                $("#errorLabel-Confirmation").html(xhr.responseText);
                $("#errorLabelContainer-Confirmation").show();
            }
        });
    });

    $("#planeCreationAccept").click(function () {
        let name = $("#nameInput").val();
        let airline = $("#airlineSelect").val();
        let capacity = $("#capacitySelect").val();

        if (name == "" || airline == "" || capacity == ""){
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