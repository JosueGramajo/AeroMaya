$(document).ready(function () {
    $("#search-container").show();
    $("#loader").hide();

    //Date select
    let today = new Date();
    $('#startDate').datepicker({
        language: 'es',
        autoClose: true,
        startDate: today,
        minDate: today
    });

    $('#endDate').datepicker({
        language: 'es',
        autoClose: true,
        minDate: today
    });

    $("#destinationPlaceText").autocomplete({
        source: countries
    }).on('input', function() {
        $("#date-section").show();
    });

    $("#submitButton").click(function () {
        $("#search-container").hide();
        $("#loader").show();

        $.redirect('/flights', {
            destination: $("#destinationPlaceText").val(),
            departureDate: $("#startDate").val(),
            arrivalDate: $("#endDate").val()
        })
    });
});