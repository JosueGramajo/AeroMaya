$(document).ready(function () {
    $(".enableSwitch").on('change', function () {
       let id = $(this).data("id");
        updateCountryStatus(id, true);
    });

    $(".disableSwitch").on('change', function () {
        let id = $(this).data("id");
        updateCountryStatus(id, false);
    });

    function updateCountryStatus(id, status) {
        $.ajax({
            url: "/changeCountryStatus",
            method: "PUT",
            data: { id: id, status: status },
            success: function (data) {
                window.location.href = "/countryManagement";
            }
        });
    }
});