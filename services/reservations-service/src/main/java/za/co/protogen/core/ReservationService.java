package za.co.protogen.core;

import org.springframework.stereotype.Service;
import za.co.protogen.domain.Reservation;

import java.time.LocalDate;
import java.util.List;

// ReservationService interface, implemented by ReservationServiceImpl
public interface ReservationService {

    void addReservation(Reservation reservation); // add reservation object to reservations list
    void removeReservation(Long id); // remove reservation object from reservations list
    Reservation getReservationById(Long id); // retrieve a reservation based on its unique identifier
    List<Reservation> getAllReservation(); // return a list of all reservations from reservations list
    void updateReservation(Long id, Reservation updatedReservation); // update a reservation based on given attributes
    List<Reservation> searchReservation(Long id, Long userId, Long carId, LocalDate fromDate,
                                        LocalDate toDate, String pickUpLocation, String dropOffLocation); // returns a list of reservations searched based on given attributes
}
