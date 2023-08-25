package za.co.protogen.core;

import za.co.protogen.domain.Reservation;
import za.co.protogen.searchCriteria.SearchCriteria;

import java.util.List;

// ReservationService interface, implemented by ReservationServiceImpl
public interface ReservationService {

    void addReservation(Reservation reservation); // add reservation object to reservations list
    void removeReservation(Long id); // remove reservation object from reservations list
    Reservation getReservationById(Long id); // retrieve a reservation based on its unique identifier
    List<Reservation> getAllReservation(); // return a list of all reservations from reservations list
    void updateReservation(Long id, Reservation updatedReservation); // update a reservation based on given attributes
    List<Reservation> searchReservation(SearchCriteria criteria); // returns a list of reservations searched based on given attributes
}
