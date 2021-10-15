$(document).ready(function () {
    $(".select-flight").click(function (e) {
        let flightId = $(this).data("id");
        let index = $(this).data("index");

        let ticketsAmount = $("#seatAmountSelector"+index).val();

        $.redirectPost(
            "/seatSelector",
            {
                id: flightId,
                ticketsAmount: ticketsAmount
            }, function(data) {});

    });

    $(".seatAmountSelector").on("change", function (event) {
        let index = $(this).data("index");
        let price = $(this).data("price");

        let selectedValue = $(this).val();

        let result = selectedValue * price;

        $("#totalLabel"+index).html("Total de esta compra: $ " + result);

        if (selectedValue > 0){
            $("#continue-button"+index).removeAttr("hidden");
        }
    });
});

$.extend(
    {
        redirectPost: function(location, args)
        {
            var form = '';
            $.each( args, function( key, value ) {
                value = value.split('"').join('\"')
                form += '<input type="hidden" name="'+key+'" value="'+value+'">';
            });
            $('<form action="' + location + '" method="POST">' + form + '</form>').appendTo($(document.body)).submit();
        }
    });