package za.co.protogen;

import za.co.protogen.core.ReservationService;
import za.co.protogen.core.impl.ReservationServiceImpl;
import za.co.protogen.domain.Reservation;
import za.co.protogen.utility.Constant;

public class Application {

    public static void main(String[] args) {
        ReservationService reservationService = new ReservationServiceImpl(Constant.reservations);

        System.out.println("All cars:");
        for (Reservation reservation : reservationService.getAllReservation()) {
            System.out.println(reservation.toString());
        }

        String removedReservation = String.valueOf(reservationService.getReservationById(1L));
        System.out.println(removedReservation + " was Removed!");
    }
}
