package za.co.protogen.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;
import za.co.protogen.persistance.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// reservationServiceImpl which implements ReservationService methods
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    // ReservationServiceImpl constructor
    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // method to add reservation to reservations list
    @Override
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }


    // method to remove reservation from reservations list
    @Override
    public void removeReservation(Long id) {
        boolean exists = reservationRepository.existsById(String.valueOf(id));
        if (!exists) {// remove reservation identified by id, if it exists
            throw  new IllegalStateException("Reservation with " + id + " does not exist");
        }
        reservationRepository.deleteById(String.valueOf(id));
    }

    // method to retrieve user by unique Id
    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(String.valueOf(id)).orElse(null); // retrieve first reservation found
    }

    // method that retrieve all reservations in reservations list
    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    // method to update reservation
    @Override
    public void updateReservation(Long id, Reservation updatedReservation) {
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
    public List<Reservation> searchReservation(Long id, Long userId, Long cardId, LocalDate fromDate, LocalDate toDate, String pickUpLocation, String dropOfLocation) {
        List<Reservation> allReservations = reservationRepository.findAll();
        return allReservations.stream().filter(reservation -> Objects.equals(reservation.getId(), id) ||
                Objects.equals(reservation.getUserId(), userId) ||
                Objects.equals(reservation.getCardId(), cardId) ||
                reservation.getFromDate().equals(fromDate) ||
                reservation.getToDate().equals(toDate) ||
                reservation.getPickUpLocation().toLowerCase().equals(pickUpLocation) ||
                reservation.getDropOffLocation().toLowerCase().equals(dropOfLocation)).collect(Collectors.toList());
    }
}
