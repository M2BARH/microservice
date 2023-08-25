package za.co.protogen.adapter;

import za.co.protogen.controller.models.ReservationDTO;
import org.mapstruct.*;
import za.co.protogen.domain.Reservation;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {

    @Mapping(target = "fromDate", source = "fromDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "toDate", source = "toDate", dateFormat = "yyyy-MM-dd")
    Reservation dtoToReservation(ReservationDTO reservationDTO);

    @Mapping(target = "fromDate", source = "fromDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "toDate", source = "toDate", dateFormat = "yyyy-MM-dd")
    ReservationDTO reservationToDTO(Reservation reservation);

    List<ReservationDTO> reservationToDTO(List<Reservation> reservation);

    void updateReservationFromDTO(ReservationDTO reservationDTO, @MappingTarget Reservation reservation);
}