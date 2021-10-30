$(document).ready(function () {
    $(".select-airline").click(function (e) {
        let id = $(this).data("id");

        $.redirect('/flightsForAirline',{ id });
    });
});