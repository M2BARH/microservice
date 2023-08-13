package za.co.protogen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import za.co.protogen.core.ReservationService;
import za.co.protogen.domain.Reservation;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationServiceApiController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationServiceApiController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public void addReservation(@RequestBody Reservation reservation) {
        reservationService.addReservation(reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @PutMapping
    public void updatedReservation(@RequestBody Long id, Reservation reservation) {
       reservationService.updateReservation(id, reservation);
    }

    @DeleteMapping("/{id}")
    public void removeReservation(Long id) {
        reservationService.removeReservation(id);
    }
}
