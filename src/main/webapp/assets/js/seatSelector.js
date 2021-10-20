$(document).ready(function () {
    let totalSelected = 0;

    let selectedSeats = [];

    $("#btnContinueToPayment").click(function () {
        if (totalSelected !== ticketsAmount){
            $("#modalTitle").html("Error");
            $("#modalBody").html("Le falta seleccionar " + (ticketsAmount - totalSelected) + " boleto" + ((ticketsAmount - totalSelected) === 1 ? "." : "s."));
            $("#genericModal").modal('show');
            return;
        }

        let seatsJson = JSON.stringify(selectedSeats);

        $.redirect('/paymentForm', {
            flightId: flightId,
            seatsSelected: seatsJson,
            total: total.toString()
        })
    });

    $(".seatCheckbox").change(function () {

        let seat = $(this).data('seat');

        if (this.checked){
            totalSelected++;

            if (totalSelected <= ticketsAmount){
                selectedSeats.push(seat);
            }else{
                totalSelected--;
                $(this).prop('checked', false);
            }
        }else{
            totalSelected--;
            selectedSeats.splice( $.inArray(seat, selectedSeats), 1 );
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