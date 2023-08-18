package za.co.protogen.controller;

import com.example.reservationservice.api.ReservationsApi;
import com.example.reservationservice.models.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.adapter.ReservationMapper;
import za.co.protogen.core.impl.ReservationServiceImpl;
import za.co.protogen.domain.Reservation;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationServiceApiController implements ReservationsApi {

    private final ReservationServiceImpl reservationServiceImpl;
    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationServiceApiController(ReservationServiceImpl reservationServiceImpl, ReservationMapper reservationMapper) {
        this.reservationServiceImpl = reservationServiceImpl;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public ResponseEntity<Void> createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.dtoToReservation(reservationDTO);
        reservationServiceImpl.addReservation(reservation);
        return null;
    }

    @Override
    public ResponseEntity<List<ReservationDTO>> getAllReservation() {
        List<Reservation> reservation = reservationServiceImpl.getAllReservation();
        List<ReservationDTO> reservationDTO = reservationMapper.reservationToDTO(reservation);
        return ResponseEntity.ok(reservationDTO);
    }

    @Override
    public ResponseEntity<ReservationDTO> getReservationById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> removeReservationById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateReservationById(String id) {
        return null;
    }

//    @PostMapping
//    public void addReservation(@RequestBody Reservation reservation) {
//        reservationServiceImpl.addReservation(reservation);
//    }
//
//    @GetMapping
//    public List<Reservation> getAllReservation() {
//        return reservationServiceImpl.getAllReservation();
//    }
//
//    @GetMapping("/{id}")
//    public Reservation getReservation(@PathVariable Long id) {
//        return reservationServiceImpl.getReservationById(id);
//    }
//
//    @PutMapping
//    public void updatedReservation(@RequestBody Long id, Reservation reservation) {
//       reservationServiceImpl.updateReservation(id, reservation);
//    }
//
//    @DeleteMapping("/{id}")
//    public void removeReservation(Long id) {
//        reservationServiceImpl.removeReservation(id);
//    }
}
