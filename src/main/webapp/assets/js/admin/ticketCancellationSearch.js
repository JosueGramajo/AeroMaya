$(document).ready(function () {
    $("#searchButton").click(function () {
        $("#loader").show();

        $.ajax({
            url: "/searchTicketsForUser",
            method: "GET",
            data: {
                "email": $("#emailSearchInput").val()
            },
            success: function (data) {
                $("#loader").hide();

                let obj = $.parseJSON(data);

                $('#tableResult tr').not(':first').remove();

                var html = '';
                $.each( obj, function( key, value ) {
                    html += '<tr>' +
                                '<td>' + (key + 1) + '</td>' +
                                '<td>' + value.flightDesc + '</td>' +
                                '<td>' + value.amount + '</td>' +
                                '<td>' + value.price + '</td>' +
                                '<td><input type="button" class="btn btn-info select-ticket" value="Seleccionar" data-id="'+ value.id +'"></td>' +
                            '</tr>';
                });

                $('#tableResult tr:first').after(html);

                $("#resultDiv").show();
            },
            error: function (xhr) {
                $("#loader").hide();
            }
        });
    });

    $("#tableResult").on("click", ".select-ticket", function () {
        let id = $(this).data('id');

        $.redirect('/ticketCancellation', {
            id
        });
    });
});