package za.co.protogen.controller;

import com.example.reservationservice.api.ReservationsApi;
import com.example.reservationservice.models.ReservationDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.protogen.adapter.ReservationMapper;
import za.co.protogen.core.impl.ReservationServiceImpl;
import za.co.protogen.domain.Reservation;

import java.util.List;

@RestController
@RefreshScope
@RequiredArgsConstructor
@RequestMapping
public class ReservationServiceApiController implements ReservationsApi {

    private final ReservationServiceImpl reservationServiceImpl;
    private final ReservationMapper reservationMapper;
    private final Logger logger = LoggerFactory.getLogger(ReservationServiceApiController.class);


    @Override
    public ResponseEntity<Void> createReservation(ReservationDTO reservationDTO) {
        logger.info("Adding a reservation to the database");
        Reservation reservation = reservationMapper.dtoToReservation(reservationDTO);
        reservationServiceImpl.addReservation(reservation);
        return null;
    }

    @Override
    public ResponseEntity<List<ReservationDTO>> getAllReservation() {
        logger.info("Getting all reservations from the database");
        List<Reservation> reservation = reservationServiceImpl.getAllReservation();
        List<ReservationDTO> reservationDTO = reservationMapper.reservationToDTO(reservation);
        return ResponseEntity.ok(reservationDTO);
    }

    @Override
    public ResponseEntity<ReservationDTO> getReservationById(Long id) {
        logger.info("Getting reservation identified by: " + id + ", from the database");
        Reservation reservation = reservationServiceImpl.getReservationById(id);
        ReservationDTO reservationDTO = reservationMapper.reservationToDTO(reservation);
        return ResponseEntity.ok(reservationDTO);
    }

    @Override
    public ResponseEntity<Void> removeReservationById(Long id) {
        logger.info("Removing reservation identified by: " + id + ", from the database");
        reservationServiceImpl.removeReservation(id);
        return null;
    }

    @Override
    public ResponseEntity<Void> updateReservationById(Long id) {
        logger.info("Getting reservation identified by: " + id + ", from the database and updating it");
        Reservation reservation = reservationServiceImpl.getReservationById(id);
        reservationServiceImpl.updateReservation(id, reservation);
        return null;
    }

}
