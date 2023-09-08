package za.co.protogen.core.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Car;
import za.co.protogen.domain.Reservation;
import za.co.protogen.domain.User;
import za.co.protogen.exception.ReservationNotFoundException;
import za.co.protogen.feignClients.CarServiceClient;
import za.co.protogen.feignClients.UserServiceClient;
import za.co.protogen.persistance.repository.ReservationRepository;
import za.co.protogen.searchCriteria.SearchCriteria;
import za.co.protogen.specifications.ReservationSpecifications;

import java.time.LocalDate;
import java.util.List;

// reservationServiceImpl which implements ReservationService methods
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CarServiceClient carServiceClient;
    private final UserServiceClient userServiceClient;

    // method to add reservation to reservations list
    @Override
    public void addReservation(Reservation reservation) {
        User user = userServiceClient.getUser(reservation.getUserId());
        if (user == null) {
            throw  new IllegalArgumentException("User with userId: " + reservation.getUserId() + " does not exist");
        }

        Car car = carServiceClient.getCar(reservation.getCarId());
        if (car == null) {
            throw new IllegalArgumentException("car with carId: " + reservation.getCarId() + " does not exist");
        }

        reservationRepository.save(reservation);
    }

    // method to remove reservation from reservations list
    @Override
    public void removeReservation(Long id) {
        boolean exists = reservationRepository.existsById(id);
        if (!exists) {// remove reservation identified by id, if it exists
            throw  new IllegalStateException("Reservation with " + id + " does not exist");
        }
        reservationRepository.deleteById(id);
    }

    // method to retrieve user by unique Id
    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository // retrieve first reservation found
                .findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
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

            updatedReservation.setId(existingReservation.getId());

            if (updatedReservation.getUserId() == null) {
                updatedReservation.setUserId(existingReservation.getUserId());
            }
            if (updatedReservation.getCarId() == null) {
                updatedReservation.setCarId(existingReservation.getCarId());
            }
            if (updatedReservation.getFromDate() == null) {
                updatedReservation.setFromDate(existingReservation.getFromDate());
            }
            if (updatedReservation.getToDate() == null) {
                updatedReservation.setToDate(existingReservation.getToDate());
            }
            if (updatedReservation.getPickUpLocation() == null) {
                updatedReservation.setPickUpLocation(existingReservation.getPickUpLocation());
            }
            if (updatedReservation.getDropOffLocation() == null) {
                updatedReservation.setDropOffLocation(existingReservation.getDropOffLocation());
            }
            reservationRepository.save(updatedReservation);
        }
    }

    // method to search for a reservations based on given attributes
    @Override
    public List<Reservation> searchReservation(SearchCriteria criteria) {
        Specification<Reservation> spec = ReservationSpecifications.buildSpecification(criteria);
        return reservationRepository.findAll(spec);
    }
}
