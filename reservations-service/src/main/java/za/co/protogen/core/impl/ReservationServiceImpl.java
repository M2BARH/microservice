package za.co.protogen.core.impl;

import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

// reservationServiceImpl which implements ReservationService methods
public class ReservationServiceImpl implements ReservationService {

    private final List<Reservation> reservations; // reservation lists variable

    // ReservationServiceImpl constructor
    public ReservationServiceImpl(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    // method to add reservation to reservations list
    @Override
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }


    // method to remove reservation from reservations list
    @Override
    public void removeReservation(long id) {
        reservations.removeIf(reservation -> reservation.getId().equals(id)); // remove reservation identified by id, if it exists
    }

    // method to retrieve user by unique Id
    @Override
    public Reservation getReservationById(long id) {
        return reservations.stream().filter(reservation -> reservation.getId().equals(id)).findFirst().orElse(null); // retrieve first reservation found
    }

    // method that retrieve all reservations in reservations list
    @Override
    public List<Reservation> getAllReservation() {
        return reservations;
    }

    // method to update reservation
    @Override
    public void updateReservation(long id, Reservation updatedReservation) {
        Reservation existingReservation = getReservationById(id); // retrieve reservation by unique id
        if (existingReservation != null) { // if the reservation is present within the list. The following attributes are updated
            existingReservation.setId(updatedReservation.getId());
            existingReservation.setUserId(updatedReservation.getUserId());
            existingReservation.setCardId(updatedReservation.getCardId());
            existingReservation.setFromDate(updatedReservation.getFromDate());
            existingReservation.setToDate(updatedReservation.getToDate());
            existingReservation.setPickUpLocation(updatedReservation.getPickUpLocation());
            existingReservation.setDropOffLocation(updatedReservation.getDropOffLocation());
        }
    }

    // method to search for a reservations based on given attributes
    @Override
    public List<Reservation> searchReservation(long id, long userId, long cardId, LocalDate fromDate, LocalDate toDate, String pickUpLocation, String dropOfLocation) {
        return reservations.stream().filter(reservation -> reservation.getId() == id ||
                reservation.getUserId() == userId ||
                reservation.getCardId() == cardId ||
                reservation.getFromDate().equals(fromDate) ||
                reservation.getToDate().equals(toDate) ||
                reservation.getPickUpLocation().toLowerCase().equals(pickUpLocation) ||
                reservation.getDropOffLocation().toLowerCase().equals(dropOfLocation)).collect(Collectors.toList());
    }
}
