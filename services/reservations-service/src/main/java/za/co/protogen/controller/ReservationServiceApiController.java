package za.co.protogen.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.LocalDate;
import za.co.protogen.adapter.ReservationMapper;
import za.co.protogen.controller.models.ReservationDTO;
import za.co.protogen.controller.models.ReservationsApi;
import za.co.protogen.core.impl.ReservationServiceImpl;
import za.co.protogen.domain.Reservation;
import za.co.protogen.searchCriteria.SearchCriteria;

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
        reservationServiceImpl.addReservation(
                reservationMapper.dtoToReservation(reservationDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<ReservationDTO>> getAllReservation() {
        logger.info("Getting all reservations from the database");
        return ResponseEntity.ok(reservationMapper.
                reservationToDTO(reservationServiceImpl.getAllReservation()));
    }

    @Override
    public ResponseEntity<ReservationDTO> getReservationById(Long id) {
        logger.info("Getting reservation identified by: " + id + ", from the database");
        return ResponseEntity.ok(reservationMapper.
                reservationToDTO(reservationServiceImpl
                        .getReservationById(id)));
    }

    @Override
    public ResponseEntity<Void> removeReservation(Long id) {
        logger.info("Removing reservation identified by: " + id + ", from the database");
        reservationServiceImpl.removeReservation(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<ReservationDTO>>
    searchReservation(Long id, Long userId, Long carId,
                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate,
                      String pickUpLocation, String dropOffLocation) {
        logger.info("Searching for a reservation from the database");
        SearchCriteria criteria = new SearchCriteria();
        criteria.setId(id);
        criteria.setUserId(userId);
        criteria.setCarId(carId);
        criteria.setFromDate(fromDate);
        criteria.setToDate(toDate);
        criteria.setPickUpLocation(pickUpLocation);
        criteria.setDropOffLocation(dropOffLocation);

        List<Reservation> reservations = reservationServiceImpl.searchReservation(criteria);
        List<ReservationDTO> reservationDTOs = reservationMapper.reservationToDTO(reservations);
        return ResponseEntity.ok(reservationDTOs);
    }

    @Override
    public ResponseEntity<Void> updateReservationById(Long id, ReservationDTO reservationDTO) {
        logger.info("Getting reservation identified by: " + id + ", from the database and updating it");
        reservationServiceImpl.updateReservation(id, reservationMapper.dtoToReservation(reservationDTO));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
