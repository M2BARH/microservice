package za.co.protogen.adapter;

import com.example.reservationservice.models.ReservationDTO;
import org.mapstruct.*;
import za.co.protogen.domain.Reservation;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {

//    @Mapping(target = "fromDate", source = "fromDate", dateFormat = "yyyy-MM-dd")
//    @Mapping(target = "toDate", source = "toDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "fromDate", ignore = true)
    @Mapping(target = "toDate", ignore = true)
    Reservation dtoToReservation(ReservationDTO reservationDTO);

//    @Mapping(target = "fromDate", source = "fromDate", dateFormat = "yyyy-MM-dd")
//    @Mapping(target = "toDate", source = "toDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "fromDate", ignore = true)
    @Mapping(target = "toDate", ignore = true)
    ReservationDTO reservationToDTO(Reservation reservation);

    List<ReservationDTO> reservationToDTO(List<Reservation> reservation);

//    @Mapping(target = "fromDate", source = "fromDate", dateFormat = "yyyy-MM-dd")
//    @Mapping(target = "toDate", source = "toDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "fromDate", ignore = true)
    @Mapping(target = "toDate", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reservation partialUpdate(ReservationDTO reservationDTO, @MappingTarget Reservation reservation);
}