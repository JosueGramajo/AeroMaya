$(document).ready(function () {
    var currentId = "";

    var editionMode = false;

    let today = new Date();

    $("#startDate").datepicker({
        language: 'es',
        autoClose: true,
        startDate: today,
        minDate: today
    });

    $("#endDate").datepicker({
        language: 'es',
        autoClose: true,
        startDate: today,
        minDate: today
    });

    $("#flightsTable").DataTable();

    $("#addFlightButton").click(function () {
        $("#endDate").val("");
        $("#endTime").val("");
        $("#startDate").val("");
        $("#startTime").val("");
        $("#originSelect").val("Guatemala");
        $("#destinySelect").val("");
        $("#descriptionInput").val("");
        $("#planeSelect").val("");
        $("#priceInput").val("");
        $("#statusContainer").hide();

        editionMode = false;

        $("#flightCreationModal").modal('show');
    });

    $(".deleteFlight").click(function () {
        currentId = $(this).data("id");
        $("#confirmationModal").modal('show');
    });

    $(".editFlight").click(function () {
        let id = $(this).data("id");
        currentId = id;

        $.ajax({
            url: "/getFlight",
            method: "GET",
            data: { id },
            success: function (data) {
                let obj = $.parseJSON(data);

                $("#endDate").val(obj.arrivalDate);
                $("#endTime").val(obj.arrivalTime);
                $("#startDate").val(obj.departureDate);
                $("#startTime").val(obj.departureTime);
                $("#originSelect").val(obj.origin);
                $("#destinySelect").val(obj.destination);
                $("#descriptionInput").val(obj.description);
                $("#planeSelect").val(obj.plane);
                $("#priceInput").val(obj.price);

                $("#statusSwitch").prop('checked', obj.status);
                $("#statusContainer").show();

                editionMode = true;

                $("#flightCreationModal").modal('show');
            }
        });
    });

    $("#deleteFlightConfirmation").click(function () {
        $.ajax({
            url: "/deleteFlight",
            method: "DELETE",
            data: { id : currentId },
            success: function (data) {
                window.location.href = "/flightsManagement";
            },
            error: function (xhr) {
                $("#errorLabel-Confirmation").html(xhr.responseText);
                $("#errorLabelContainer-Confirmation").show();
            }
        });
    });

    $("#flightCreationAccept").click(function () {
        let arrivalDate = $("#endDate").val();
        let arrivalTime = $("#endTime").val();
        let departureDate = $("#startDate").val();
        let departureTime = $("#startTime").val();
        let origin = $("#originSelect").val();
        let destination = $("#destinySelect").val();
        let description = $("#descriptionInput").val();
        let plane = $("#planeSelect").val();
        let price = $("#priceInput").val();
        let status = $("#statusSwitch").val();

        if (!arrivalDate || !arrivalTime || !departureDate || !departureTime || !origin || !destination || !description
            || !plane || !price){
            $("#errorLabel").html("Favor complete todos los campos");
            $("#errorLabelContainer").show();
            return;
        }

        $("#creationOptions").hide();
        $("#loader").show();

        if (editionMode){
            $.ajax({
                url: "/updateFlight",
                method: "PUT",
                data: {
                    id: currentId,
                    arrivalDate,
                    arrivalTime,
                    departureDate,
                    departureTime,
                    origin,
                    destination,
                    description,
                    plane,
                    price,
                    status
                },
                success: function (data) {
                    window.location.href = "/flightsManagement";
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
                url: "/createFlight",
                method: "POST",
                data: {
                    arrivalDate,
                    arrivalTime,
                    departureDate,
                    departureTime,
                    origin,
                    destination,
                    description,
                    plane,
                    price
                },
                success: function (data) {
                    window.location.href = "/flightsManagement";
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