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

        console.log("continue");
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

    $("#modalAcceptButton").click(function () {
        $("#genericModal").modal('hide');
    });
});