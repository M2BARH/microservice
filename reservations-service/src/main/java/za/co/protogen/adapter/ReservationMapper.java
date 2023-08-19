package za.co.protogen.adapter;

import com.example.reservationservice.models.ReservationDTO;
import org.mapstruct.*;
import za.co.protogen.domain.Reservation;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {

    Reservation dtoToReservation(ReservationDTO reservationDTO);

    ReservationDTO reservationToDTO(Reservation reservation);

    List<ReservationDTO> reservationToDTO(List<Reservation> reservation);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reservation partialUpdate(ReservationDTO reservationDTO, @MappingTarget Reservation reservation);
}